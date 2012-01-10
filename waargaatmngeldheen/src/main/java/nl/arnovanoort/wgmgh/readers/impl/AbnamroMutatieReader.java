package nl.arnovanoort.wgmgh.readers.impl;

import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.inject.Inject;
import javax.inject.Named;

import nl.arnovanoort.wgmgh.domain.BankMutatie;
import nl.arnovanoort.wgmgh.domain.Rekening;
import nl.arnovanoort.wgmgh.exception.ReaderException;
import nl.arnovanoort.wgmgh.log.Logger;
import nl.arnovanoort.wgmgh.readers.MutatieReader;
import nl.arnovanoort.wgmgh.services.BankMutatieService;
import nl.arnovanoort.wgmgh.services.RekeningService;

import org.apache.commons.logging.Log;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

@Named("abnamroMutatieReader")
public class AbnamroMutatieReader implements MutatieReader{

	@Inject 
	RekeningService rekeningService;
	@Inject 
	BankMutatieService bankMutatieService;
	
	@Logger
	Log log;
	
	public static final DateFormat formatter = new SimpleDateFormat("yyyyMMdd");
	
	public void process(Rekening rekening, InputStream inp) {
	    try {
		    Workbook wb = WorkbookFactory.create(inp);
		    Sheet sheet = wb.getSheetAt(0);
		    
		    // remove headers
		    sheet.removeRow(sheet.getRow(0));
		    
		    // loop through rows
		    for (Row row : sheet) {
		    	// create mutatie
		    	BankMutatie bankMutatie = createMutatie(row, rekening);
		    	// store mutatie.
		    	rekeningService.add(bankMutatie, rekening);
		    }
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InvalidFormatException e) {
			e.printStackTrace();
		} catch( ReaderException re){
			re.printStackTrace();
		}
	}

	private BankMutatie createMutatie(Row row, Rekening rekening) {
		BankMutatie bankMutatie = null; 
		try {
			// get transaction date from double
			BigDecimal transactieDatumBD = new BigDecimal(row.getCell(2).getNumericCellValue());
			Date transactieDatum = formatter.parse(transactieDatumBD.setScale(0, RoundingMode.HALF_DOWN).toPlainString());

			// get transaction date from double
			BigDecimal renteDatumBD = new BigDecimal(row.getCell(3).getNumericCellValue());
			Date renteDatum = formatter.parse(renteDatumBD.setScale(0, RoundingMode.HALF_DOWN).toPlainString());
			
			// map other fields
			double beginSaldo = row.getCell(4).getNumericCellValue();
			double eindSaldo = row.getCell(5).getNumericCellValue();
			double transactieBedrag = row.getCell(6).getNumericCellValue();
			String omschrijving = (String)row.getCell(7).getRichStringCellValue().getString();
			
			// create bankmutatie 
			bankMutatie = bankMutatieService.createMutatie(transactieDatum,renteDatum, beginSaldo, eindSaldo, transactieBedrag, omschrijving);
	    	bankMutatie.setRekening(rekening);
		} catch (ParseException e) {
			String message = " Could not parse date, skipping mutatie " + row.getCell(7).getRichStringCellValue().getString();
			log.warn(message);
			throw new ReaderException(message,e);
		}
		return bankMutatie;
	}

}

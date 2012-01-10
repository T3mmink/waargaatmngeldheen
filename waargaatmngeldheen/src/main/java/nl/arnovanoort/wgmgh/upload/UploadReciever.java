package nl.arnovanoort.wgmgh.upload;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

import javax.inject.Inject;
import javax.inject.Named;

import nl.arnovanoort.vaadintest6.MyVaadinApplication;
import nl.arnovanoort.wgmgh.domain.Rekening;
import nl.arnovanoort.wgmgh.gui.views.UploadView;
import nl.arnovanoort.wgmgh.readers.MutatieReader;
import nl.arnovanoort.wgmgh.readers.impl.AbnamroMutatieReader;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import com.vaadin.ui.Select;
import com.vaadin.ui.Upload.FailedEvent;
import com.vaadin.ui.Upload.FailedListener;
import com.vaadin.ui.Upload.Receiver;
import com.vaadin.ui.Upload.SucceededEvent;
import com.vaadin.ui.Upload.SucceededListener;

@Named
public class UploadReciever implements Receiver, SucceededListener, FailedListener {

	@Inject
	MutatieReader abnamroMutatieReader;
	
	ByteArrayOutputStream outputStream;

	private Select rekeningNummerSelect;
	
	public OutputStream receiveUpload(String filename, String mimeType) {
		outputStream = new ByteArrayOutputStream();
		return outputStream;
	}

	public void uploadFailed(FailedEvent event) {
		Exception e = event.getReason();
		e.printStackTrace();
		
	}

	public void uploadSucceeded(SucceededEvent event) {
		Rekening rekening = (Rekening)rekeningNummerSelect.getValue();
		

		InputStream inputStream = new ByteArrayInputStream(outputStream.toByteArray());
		abnamroMutatieReader.process(rekening,inputStream);
	}

	public void setRekeningNummerSelect(Select rekeningNummerSelect) {
		this.rekeningNummerSelect=rekeningNummerSelect;
		
	}

}

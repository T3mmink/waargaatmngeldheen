package nl.arnovanoort.wgmgh.services.impl.test;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;

import nl.arnovanoort.wgmgh.domain.BankMutatie;
import nl.arnovanoort.wgmgh.services.impl.BankMutatieServiceImpl;

import org.junit.Before;
import org.junit.Test;

public class BankMutatieServiceImplTest {

	BankMutatieServiceImpl bankMutatieServiceImpl;
	Calendar calendar = Calendar.getInstance();//.set(2011, 12, 03);
	Date today;
	Date tomorrow;
	Double beginSaldo = 100.03d; 
	Double eindSaldo = 150.05d;
	Double transactieBedrag = 50.02d;
	private static String ZAKGELD = "zakgeld";

	@Before
	public void before(){
		bankMutatieServiceImpl = new BankMutatieServiceImpl();
		calendar.set(2011, 12, 03);
		today = calendar.getTime();
		calendar.set(2011,12,04);
		tomorrow = calendar.getTime();
				
	}
	
	@Test
	public void testCreateBankMutatie(){
		BankMutatie bankMutatie = bankMutatieServiceImpl.createMutatie(today, tomorrow, beginSaldo, eindSaldo, transactieBedrag, ZAKGELD);
		assertEquals(bankMutatie.getTransactieDatum(),today);
		assertEquals(bankMutatie.getRenteDatum(),tomorrow);
		assertEquals(bankMutatie.getBeginSaldo(), new BigDecimal(beginSaldo).setScale(2,BigDecimal.ROUND_HALF_DOWN));
		assertEquals(bankMutatie.getEindSaldo(),new BigDecimal(eindSaldo).setScale(2,BigDecimal.ROUND_HALF_DOWN));
		assertEquals(bankMutatie.getTransactieBedrag(),new BigDecimal(transactieBedrag).setScale(2,BigDecimal.ROUND_HALF_DOWN));
		assertEquals(bankMutatie.getTransactieDatum(),today);
		assertEquals(bankMutatie.getOmschrijving(),ZAKGELD);
		
	}
}

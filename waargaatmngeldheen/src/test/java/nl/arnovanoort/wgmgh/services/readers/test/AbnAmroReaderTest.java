package nl.arnovanoort.wgmgh.services.readers.test;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.io.File;
import java.net.URL;

import nl.arnovanoort.wgmgh.dao.impl.MutatieDaoImpl;
import nl.arnovanoort.wgmgh.domain.BankMutatie;
import nl.arnovanoort.wgmgh.readers.MutatieReader;
import nl.arnovanoort.wgmgh.readers.impl.AbnamroMutatieReader;

import org.junit.Before;
import org.junit.Test;

public class AbnAmroReaderTest {

	MutatieReader mutatieReader;
	MutatieDaoImpl daoMock;
	
	@Before
	public void before(){
		mutatieReader = new AbnamroMutatieReader();
		daoMock = mock(MutatieDaoImpl.class);
//		mutatieReader.setDao(daoMock);
		
			
	}
	@Test
	public void test() {
		File testfile = getBankMutatieBestand("abn-10-2011.xls");
		BankMutatie b = new BankMutatie();
//		when(daoMock.exists(any(BankMutatie.class))).thenReturn(true);
//		mutatieReader.process(testfile);
		
	}
	
	
	public File getBankMutatieBestand(String filename){
		return getFile("/bankmutaties/" + filename);
	}

	public File getFile(String filename){
		URL url = this.getClass().getResource(filename);
		File file = new File(url.getFile());
		return file;

	}

}

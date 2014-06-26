package comparer.synchro.reader.readerbookmaker.convert.converter.williamhill;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import javax.inject.Inject;

import org.junit.Test;

import com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.convert.converter.williamhill.MarketNameToXmlMarketName;

import comparer.synchro.reader.readerbookmaker.convert.core.AbstractTest;

public class MarketNameToXmlMarketNameTest extends AbstractTest{
	
	@Inject
	private MarketNameToXmlMarketName marketName;
	
	@Test
	public void getNameTest() {
		String name = marketName.getName();
		assertNotNull(name);
		assertTrue(name.equals("marketNameToXmlMarketNameWilliam"));
	}
	
	@Test
	public void convertTest() {
		String result = (String) marketName.convert(null, "prueba - conversion", null, null);
		assertNotNull(result);
		assertEquals(result ,"conversion");
	}
	

}

package comparer.synchro.reader.readerbookmaker.convert.converter.williamhill;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import javax.inject.Inject;

import org.junit.Test;

import com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.convert.converter.williamhill.MarketNameToXmlMatchName;

import comparer.synchro.reader.readerbookmaker.convert.core.AbstractTest;

public class MarketNameToXmlMatchNameTest extends AbstractTest{
	
	@Inject
	private MarketNameToXmlMatchName matchName;
	
	@Test
	public void getNameTest() {
		assertNotNull(matchName.getName());
		assertTrue(matchName.getName().equals("marketNameToXmlMatchNameWilliam"));
	}
	
	@Test
	public void convertTest() {
		String result = (String) matchName.convert(null, "prueba - conversion", null, null);
		assertNotNull(result);
		assertEquals(result, "prueba");
	}

}

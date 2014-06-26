package com.comparadorad.bet.comparer.synchro.reader.urlparameter;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import javax.inject.Inject;

import org.junit.Test;

import com.comparadorad.bet.comparer.model.config.bean.CfgBookmaker;
import com.comparadorad.bet.comparer.synchro.reader.model.BeanParameterPinnacle;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlMatch;
import com.comparadorad.bet.comparer.synchro.reader.url.core.StrategyType;
import com.comparadorad.bet.comparer.synchro.reader.urlparameter.config.AbstractUrlParameterTest;
import com.comparadorad.bet.comparer.synchro.reader.urlparameter.exception.NoParameterException;
import com.comparadorad.bet.comparer.synchro.reader.urlparameter.exception.UrlParameterException;

public final class UrlParameterTest extends AbstractUrlParameterTest {

	@Inject
	private UrlParameter urlParameter;

	@Test
	public void nullTest() throws UrlParameterException {
		assertNotNull(urlParameter);
		urlParameter.readParameter(null, null);
	}

	@Test
	public void bedfredTest() {

	}

	@Test
	public void pinnacleTest() throws UrlParameterException {

		XmlMatch match = new XmlMatch();
		CfgBookmaker cfgBookmaker = new CfgBookmaker();

		match.setAbstractBeanParameters(new BeanParameterPinnacle("test"));

		cfgBookmaker.setNameId("PinnacleSports");

		assertNotNull(urlParameter);

		urlParameter.readParameter(match, cfgBookmaker);

		assertEquals(StrategyType.PINNACLE.getUriParameter().size(), 1);

	}
	
	@Test(expected=NoParameterException.class)
	public void pinnacleExceptionTest() throws UrlParameterException {

		XmlMatch match = new XmlMatch();
		CfgBookmaker cfgBookmaker = new CfgBookmaker();		

		cfgBookmaker.setNameId("PinnacleSports");

		assertNotNull(urlParameter);

		urlParameter.readParameter(match, cfgBookmaker);

		assertEquals(StrategyType.PINNACLE.getUriParameter().size(), 1);

	}

}

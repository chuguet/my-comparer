/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.valuebet.process;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;

import com.comparadorad.bet.comparer.model.bet.bean.RtMatch;
import com.comparadorad.bet.comparer.model.config.bean.CfgBetType.CfgBetTypeId;
import com.comparadorad.bet.comparer.model.core.bean.IDocument;
import com.comparadorad.bet.comparer.model.valuebet.bean.ValueBetData;
import com.comparadorad.bet.comparer.synchro.valuebet.core.bean.result.ResultValueBet;
import com.comparadorad.bet.comparer.util.test.mongo.json.util.JSONUtil;
import com.mongodb.util.JSONParseException;

/**
 * The Class ProcessValueBetTest.
 */
public class ProcessValueBetTest extends AbstractProcessValueBetTest {

	/** The Constant LOG. */
	private static final Log LOG = LogFactory.getLog(ProcessValueBetTest.class);

	/** The process value bet. */
	@Inject
	IProcessValueBet processValueBet;

	/** {@inheritDoc} */
	@Override
	public String getAditionalNameForLoad() {
		return new StringBuffer().append("-")
				.append(this.getClass().getSimpleName()).toString();
	}

	/**
	 * Pasamos un rtMatch grande que tiene en total 10 valuebets.
	 */
	@Test
	public void processTest() {

		List<IDocument> matchsPOJO = new ArrayList<IDocument>();
		RtMatch matchPOJO;
		ResultValueBet resultValueBet;

		short ganadorPartido = 0;
		short asianHandicap = 0;
		short unoXDos = 0;
		short handicapUnoXDos = 0;
		short masMenos = 0;

		try {
			matchsPOJO = JSONUtil.parseJSONToPOJO(RtMatch.class, getClass(),
					getAditionalNameForLoad(), mongoTemplate);
		} catch (JSONParseException e) {
			LOG.error("Test failure: ", e);
			fail("JSONParseException");
		} catch (IOException e) {
			LOG.error("Test failure: ", e);
			fail("IOException");
		}

		assertEquals(1, matchsPOJO.size());
		matchPOJO = (RtMatch) matchsPOJO.get(0);

		try {
			resultValueBet = processValueBet.process(matchPOJO);
			assertNotNull(resultValueBet);
			assertNotNull(resultValueBet.getValueBetDatas());
			assertEquals(5, resultValueBet.getValueBetDatas().size());

			for (ValueBetData valueBet : resultValueBet.getValueBetDatas()) {
				if (valueBet.getBet().getBetType().getObjectId().toString()
						.equals(CfgBetTypeId.GANADOR_PARTIDO.id())) {
					ganadorPartido++;
				} else if (valueBet.getBet().getBetType().getObjectId()
						.toString().equals(CfgBetTypeId.UNO_X_DOS.id())) {
					unoXDos++;
				} else if (valueBet.getBet().getBetType().getObjectId()
						.toString().equals(CfgBetTypeId.MAS_MENOS.id())) {
					masMenos++;
				} else if (valueBet.getBet().getBetType().getObjectId()
						.toString().equals(CfgBetTypeId.HANDICAP_ASIATICO.id())) {
					asianHandicap++;
				} else if (valueBet.getBet().getBetType().getObjectId()
						.toString()
						.equals(CfgBetTypeId.UNO_X_DOS_HANDICAP.id())) {
					handicapUnoXDos++;
				}
			}

			// assertEquals(1, ganadorPartido);
			// assertEquals(1, unoXDos);
			// assertEquals(1, masMenos);
			// assertEquals(1, asianHandicap);
			// assertEquals(1, handicapUnoXDos);

		} catch (Exception e) {
			LOG.error("Test failure: ", e);
			fail("Exception");
		}

	}
}

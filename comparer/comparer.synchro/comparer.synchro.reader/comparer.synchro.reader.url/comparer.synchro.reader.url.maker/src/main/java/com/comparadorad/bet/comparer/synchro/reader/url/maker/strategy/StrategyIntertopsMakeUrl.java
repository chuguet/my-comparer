package com.comparadorad.bet.comparer.synchro.reader.url.maker.strategy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.comparadorad.bet.comparer.model.config.bean.CfgBookmaker;
import com.comparadorad.bet.comparer.model.config.bean.bmconf.CfgBookmakerDataUrl.UrlDataTypes;
import com.comparadorad.bet.comparer.synchro.reader.url.core.StrategyType;
import com.comparadorad.bet.comparer.synchro.reader.url.maker.bean.BeanUrlMaker;
import com.comparadorad.bet.comparer.synchro.reader.url.maker.exception.TimeOutReaderURLException;
import com.comparadorad.bet.comparer.synchro.reader.url.maker.exception.URLOutConfigurationException;

@Component
final class StrategyIntertopsMakeUrl extends AbstractStrategyRebootUrlMaker {

	/** The date start. */
	private final Date dateStart;

	/** The lastupdate. */
	private final Map<String, Date> lastupdate;

	private static final Integer INIT_DELAY = 30;

	private static final Integer END_DELAY = 7200;

	private static final String AMPSERSAND = "&";

	private static final String PARAMETER = "delta";

	private static final String EQUAL = "=";

	String[] a = { "1" };

	public StrategyIntertopsMakeUrl() {
		dateStart = new Date();
		lastupdate = new HashMap<String, Date>();
	}

	@Override
	public List<BeanUrlMaker> getUrls(CfgBookmaker bookmaker)
			throws URLOutConfigurationException, TimeOutReaderURLException {
		List<BeanUrlMaker> urls;
		List<BeanUrlMaker> result = new ArrayList<BeanUrlMaker>();
		StringBuffer buffer;

		urls = super.getUrls(bookmaker);

		for (BeanUrlMaker url : urls) {
			buffer = new StringBuffer();
			if (!isRebootUrlMaker(url, bookmaker.getBookmakerConfiguration())) {
				buffer.append(url.getUrl()).append(AMPSERSAND)
						.append(PARAMETER).append(EQUAL).append(INIT_DELAY);
			} else {
				buffer.append(url.getUrl()).append(AMPSERSAND)
						.append(PARAMETER).append(EQUAL).append(END_DELAY);
			}
			result.add(new BeanUrlMaker(buffer.toString(), UrlDataTypes.DATA));
		}

		return result;
	}

	@Override
	public StrategyType getStrategyType() {
		return StrategyType.INTERTOPS;
	}

	@Override
	protected Date getDateStart() {
		return dateStart;
	}

	@Override
	protected Map<String, Date> getLastupdate() {
		return lastupdate;
	}

}

/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.reader.app.bookmaker.step2;

import java.util.List;

import javax.inject.Inject;

import org.springframework.batch.item.ItemWriter;
import org.springframework.stereotype.Service;

import com.comparadorad.bet.comparer.model.config.bean.CfgBookmaker;
import com.comparadorad.bet.comparer.synchro.reader.app.bookmaker.AbstractBookmakerProcess;
import com.comparadorad.bet.comparer.synchro.reader.url.maker.MakeUrl;
import com.comparadorad.bet.comparer.synchro.reader.url.maker.bean.BeanUrlMaker;

/**
 * The Class MakerUrlWriter.
 */
@Service
final class MakerUrlWriter extends AbstractBookmakerProcess implements ItemWriter<CfgBookmaker> {

	/** The make url. */
	@Inject
	private MakeUrl makeUrl;

	/**
	 * Instantiates a new maker url writer.
	 */
	private MakerUrlWriter() {
		super();
	}

	/** {@inheritDoc} */
	@Override
	public void write(List<? extends CfgBookmaker> cfgBookmakers) throws Exception {

		List<BeanUrlMaker> urls;
		BookmakerStep2Data bookmakerStep2Data = BookmakerStep2Data.getInstance(getExecutionContext());

		for (CfgBookmaker cfgBookmaker : cfgBookmakers) {
			urls = makeUrl.getUrl(cfgBookmaker);
			for (BeanUrlMaker url : urls) {
				bookmakerStep2Data.add(url, cfgBookmaker);
			}
		}

	}

}

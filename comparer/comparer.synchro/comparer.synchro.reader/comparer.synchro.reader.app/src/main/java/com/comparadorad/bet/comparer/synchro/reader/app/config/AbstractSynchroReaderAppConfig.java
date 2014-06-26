/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.reader.app.config;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.comparadorad.bet.comparer.model.config.service.config.ConfigServiceConfig;
import com.comparadorad.bet.comparer.model.log.service.config.LogServiceConfig;
import com.comparadorad.bet.comparer.synchro.reader.datasource.config.SynchroReaderDatasourceConfig;
import com.comparadorad.bet.comparer.synchro.reader.filter.config.ReaderFilterConfig;
import com.comparadorad.bet.comparer.synchro.reader.processbookmaker.config.SynchroReaderProcessConfig;
import com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.core.config.SynchroReaderReaderbookmakerConfig;
import com.comparadorad.bet.comparer.synchro.reader.url.maker.config.UrlFactoryConfig;
import com.comparadorad.bet.comparer.synchro.reader.urlparameter.config.UrlParameterConfig;
import com.comparadorad.bet.comparer.synchro.reader.writer.config.SynchroReaderWriterConfig;
import com.comparadorad.bet.comparer.synchro.toolbar.filter.config.ToolbarFilterConfig;
import com.comparadorad.bet.comparer.util.batch.config.AbstractBatchAppConfig;

/**
 * The Class EmbededMongoConfig.
 */
@Configuration
@Import({ SynchroReaderReaderbookmakerConfig.class,
		SynchroReaderProcessConfig.class, SynchroReaderWriterConfig.class,
		SynchroReaderDatasourceConfig.class, ConfigServiceConfig.class,
		LogServiceConfig.class, ReaderFilterConfig.class, UrlFactoryConfig.class, ToolbarFilterConfig.class, UrlParameterConfig.class })
@ComponentScan("com.comparadorad.bet.comparer.synchro.reader")
public abstract class AbstractSynchroReaderAppConfig extends
		AbstractBatchAppConfig {

	/** The read all bookmaker. */
	@Value("${read.all.bookmaker}")
	private Boolean readAllBookmaker;

	/** The read bookmaker id. */
	@Value("${read.bookmakerid}")
	private String readBookmakerId;

	@Value("${config.filter.memorymaxElement}")
	private Integer memorymaxElement;

	/** The bookmaker id. */
	private List<BigInteger> bookmakerId;

	/** The Constant SEPARATOR. */
	private static final String SEPARATOR = ",";

	/**
	 * Gets the bookmaker id.
	 * 
	 * @return the bookmaker id
	 */
	public final List<BigInteger> getBookmakerId() {
		if (bookmakerId == null) {
			bookmakerId = new ArrayList<BigInteger>();
			StringTokenizer tokenizer = new StringTokenizer(
					getReadBookmakerId(), SEPARATOR);
			while (tokenizer.hasMoreTokens()) {
				bookmakerId.add(new BigInteger(tokenizer.nextToken()));

			}
		}
		return bookmakerId;
	}

	public final Integer getMemorymaxElement() {
		return memorymaxElement;
	}

	/**
	 * Gets the read all bookmaker.
	 * 
	 * @return the read all bookmaker
	 */
	public final Boolean getReadAllBookmaker() {
		return readAllBookmaker;
	}

	/**
	 * Gets the read bookmaker id.
	 * 
	 * @return the read bookmaker id
	 */
	public final String getReadBookmakerId() {
		return readBookmakerId;
	}

	/**
	 * Sets the bookmaker id.
	 * 
	 * @param bookmakerId
	 *            the new bookmaker id
	 */
	public final void setBookmakerId(List<BigInteger> bookmakerId) {
		this.bookmakerId = bookmakerId;
	}

	public final void setMemorymaxElement(Integer memorymaxElement) {
		this.memorymaxElement = memorymaxElement;
	}

	/**
	 * Sets the read all bookmaker.
	 * 
	 * @param readAllBookmaker
	 *            the new read all bookmaker
	 */
	public final void setReadAllBookmaker(Boolean readAllBookmaker) {
		this.readAllBookmaker = readAllBookmaker;
	}

	/**
	 * Sets the read bookmaker id.
	 * 
	 * @param readBookmakerId
	 *            the new read bookmaker id
	 */
	public final void setReadBookmakerId(String readBookmakerId) {
		this.readBookmakerId = readBookmakerId;
	}

}

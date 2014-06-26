/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.toolbar.filter.plugin;

import java.security.MessageDigest;
import java.util.Stack;

import javax.inject.Inject;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

import com.comparadorad.bet.comparer.model.bet.bean.RtMarket;
import com.comparadorad.bet.comparer.model.bet.bean.RtMatch;
import com.comparadorad.bet.comparer.synchro.toolbar.filter.bean.ToolbarConfigurationBean;
import com.comparadorad.bet.comparer.synchro.toolbar.filter.config.AbstractToolbarFilterConfig;
import com.comparadorad.bet.comparer.synchro.toolbar.filter.exception.ToolbarException;

/**
 * The Class HashKeyToolbarFilter.
 */
@Component
public class HashKeyToolbarFilter implements PluginToolbarFilter {

	/** The config. */
	@Inject
	private AbstractToolbarFilterConfig config;

	/** The calculated hashkey. */
	private static Stack<String> calculatedHashkey;

	/** The Constant LOG. */
	private static final Log LOG = LogFactory
			.getLog(HashKeyToolbarFilter.class);
	
	public HashKeyToolbarFilter(){
		reset();
	}

	/**
	 * Encrypt.
	 * 
	 * @param message
	 *            the message
	 * @param codification
	 *            the codification
	 * @param type
	 *            the type
	 * @return the string
	 */
	private static String encrypt(String message, String codification,
			String type) {
		MessageDigest messageDigest;
		byte[] buffer, digest;
		StringBuilder hash;
		hash = new StringBuilder();
		try {
			buffer = message.getBytes(codification);
			messageDigest = MessageDigest.getInstance(type);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		messageDigest.update(buffer);
		digest = messageDigest.digest();
		for (byte b : digest) {
			hash.append(String.format("%02x", b & 0xff));
		}
		return hash.toString();
	}

	/** {@inheritDoc} */ 
	@Override
	public Boolean deleteElement(RtMatch match,
			ToolbarConfigurationBean configurationBean) throws ToolbarException {

		String hashkey;
		Boolean result = Boolean.FALSE;
		String valueRtMach;

		valueRtMach = getValuesXmlMatch(match);

		hashkey = encrypt(valueRtMach, config.getCodification(),
				config.getHashkeyType());

		if (calculatedHashkey.contains(hashkey)) {
			result = Boolean.TRUE;
		} else {
			calculatedHashkey.push(hashkey);
		}

		if (calculatedHashkey.size() < calculatedHashkey.size()) {
			calculatedHashkey.pop();
		}

		return result;
	}

	/**
	 * Gets the values xml match.
	 *
	 * @param rtMatch the rt match
	 * @return the values xml match
	 */
	private String getValuesXmlMatch(final RtMatch rtMatch) {

		StringBuffer buffer = new StringBuffer();

		buffer.append(rtMatch.getHashKey());

		for (RtMarket market : rtMatch.getRtMarkets()) {
			buffer.append(market.getHashKey());
		}

		return buffer.toString();
	}

	@Override
	public void reset() {
		calculatedHashkey = new Stack<String>();
	}

}

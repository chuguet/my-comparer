package com.comparadorad.bet.comparer.model.config.bean.bmconf;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.validation.constraints.NotNull;

import org.springframework.data.mongodb.core.mapping.Field;

import com.comparadorad.bet.comparer.model.core.bean.AbstractIdActivable;
import com.comparadorad.bet.comparer.model.core.bean.IDocument;

public class AbstractWebUrl extends AbstractIdActivable implements IDocument  {

	/** The Constant PATTERN_URL. */
	private final static String PATTERN_URL = "\\b(https?|ftp|file)://[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]";

	/** The private url. */
	@Field
	@NotNull
	private String url;

	/**
	 * Gets the url.
	 *
	 * @return the url
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * Sets the url.
	 *
	 * @param url the new url
	 */
	public void setUrl(String url) {
		Pattern patt = Pattern.compile(PATTERN_URL);
		Matcher matcher = patt.matcher(url);
		if (matcher.find()) {
			this.url = url;
		}
	}
	
}

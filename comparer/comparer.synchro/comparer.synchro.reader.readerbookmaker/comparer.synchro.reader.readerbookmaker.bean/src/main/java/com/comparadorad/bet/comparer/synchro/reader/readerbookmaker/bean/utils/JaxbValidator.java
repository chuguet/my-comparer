package com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.bean.utils;

import javax.xml.bind.ValidationEvent;
import javax.xml.bind.ValidationEventHandler;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * The Class JaxbValidator.
 */
public class JaxbValidator implements ValidationEventHandler {

	/** The LOG. */
	private static final Log LOG = LogFactory.getLog(JaxbValidator.class);
	
	/* (non-Javadoc)
	 * @see javax.xml.bind.ValidationEventHandler#handleEvent(javax.xml.bind.ValidationEvent)
	 */
	@Override
	public boolean handleEvent(ValidationEvent event) {
		LOG.debug("\nEVENT - Error detail JaxB");
		LOG.debug(new StringBuffer("SEVERITY:  ").append(event.getSeverity()).toString());
		LOG.debug(new StringBuffer("MESSAGE:  ").append(event.getMessage()).toString());
		LOG.debug(new StringBuffer("LINKED EXCEPTION:  ").append(event.getLinkedException()).toString());
		LOG.debug("LOCATOR");
		LOG.debug(new StringBuffer("    LINE NUMBER:  ").append(event.getLocator().getLineNumber()).toString());
		LOG.debug(new StringBuffer("    COLUMN NUMBER:  ").append(event.getLocator().getColumnNumber()).toString());
		LOG.debug(new StringBuffer("    OFFSET:  ").append(event.getLocator().getOffset()).toString());
		LOG.debug(new StringBuffer("    OBJECT:  ").append(event.getLocator().getObject()).toString());
		LOG.debug(new StringBuffer("    NODE:  ").append(event.getLocator().getNode()).toString());
		LOG.debug(new StringBuffer("    URL:  ").append(event.getLocator().getURL()).toString());
		return true;
	}

}


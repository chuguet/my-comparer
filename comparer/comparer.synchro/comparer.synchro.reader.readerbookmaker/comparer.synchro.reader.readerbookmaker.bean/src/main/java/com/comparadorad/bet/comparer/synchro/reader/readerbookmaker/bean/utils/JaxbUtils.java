/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.bean.utils;

import java.io.File;
import java.io.InputStream;
import java.io.StringWriter;
import java.io.Writer;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * The Class JaxbUtils.
 */
public class JaxbUtils {


	/** The Constant LOG. */
	private static final Log LOG = LogFactory.getLog(JaxbUtils.class);

	/**
	 * Read xml.
	 * 
	 * @param xmlFile
	 *            the xml file
	 * @param clazz
	 *            the clazz
	 * @return the object
	 * @throws JAXBException
	 *             the jAXB exception
	 */
	public static Object readXML(File xmlFile, Class<?> clazz)
			throws JAXBException {
		JAXBContext jc;
		jc = JAXBContext.newInstance(clazz);
		Unmarshaller u;
		u = jc.createUnmarshaller();
		u.setEventHandler(new JaxbValidator());
		return u.unmarshal(xmlFile);
	}

	/**
	 * Read xml.
	 * 
	 * @param xmlFile
	 *            the xml file
	 * @param clazz
	 *            the clazz
	 * @return the object
	 * @throws JAXBException
	 *             the jAXB exception
	 */
	public static Object readXML(InputStream xmlFile, Class<?> clazz)
			throws JAXBException {
		JAXBContext jc;
		Unmarshaller u;
		jc = JAXBContext.newInstance(clazz);
		u = jc.createUnmarshaller();
		u.setEventHandler(new JaxbValidator());
		return u.unmarshal(xmlFile);
	}

	/**
	 * Write xml.
	 * 
	 * @param container
	 *            the container
	 * @param clazz
	 *            the clazz
	 * @return the string
	 */
	public static String writeXML(Object container, Class<?> clazz) {
		JAXBContext jaxbContext;
		Writer writer = new StringWriter();
		try {
			jaxbContext = JAXBContext.newInstance(clazz);

			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
			// output pretty printed
			jaxbMarshaller.setEventHandler(new JaxbValidator());
			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			jaxbMarshaller.marshal(container, writer);
		} catch (JAXBException e) {
			LOG.error(e.getMessage(), e);
		}
		return writer.toString();
	}
}

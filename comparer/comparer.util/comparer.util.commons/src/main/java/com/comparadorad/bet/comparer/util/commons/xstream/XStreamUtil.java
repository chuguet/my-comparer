/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.util.commons.xstream;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;

import org.apache.commons.io.FileUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.comparadorad.bet.comparer.util.commons.lang.EncodingUtil;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.XStreamException;
import com.thoughtworks.xstream.io.xml.DomDriver;

/**
 * The Class XstreamUtil.
 */
public final class XStreamUtil {

	/** The Constant LOG. */
	private static final Log LOG = LogFactory.getLog(XStreamUtil.class);

	/**
	 * Creates the x stream.
	 * 
	 * @return the x stream
	 */
	public static XStream createXStream() {
		return new XStream(new DomDriver(EncodingUtil.DEFAULT_ENCODING));
	}

	/**
	 * From xml.
	 * 
	 * @param xml
	 *            the xml
	 * @return the object
	 */
	public static Object fromXML(final byte[] xml) {
		try {
			Object result = null;
			XStream xStream = createXStream();
			result = xStream.fromXML(new String(xml));
			return result;
		} catch (XStreamException e) {
			throw new XStreamUtilException(e);
		}
	}

	/**
	 * From xml.
	 * 
	 * @param pStream
	 *            the stream
	 * @return the object
	 */
	public static Object fromXML(InputStream pStream) {
		try {
			Object result = null;
			XStream xStream = createXStream();
			result = xStream.fromXML(pStream);
			return result;
		} catch (XStreamException e) {
			throw new XStreamUtilException(e);
		}
	}

	/**
	 * From xml.
	 * 
	 * @param xml
	 *            the xml
	 * @return the object
	 */
	public static Object fromXML(final String xml) {
		try {
			Object result = null;
			XStream xStream = createXStream();
			result = xStream.fromXML(xml);
			return result;
		} catch (XStreamException e) {
			throw new XStreamUtilException(e);
		}
	}

	/**
	 * To xml.
	 * 
	 * @param object
	 *            the object
	 * @return the string
	 */
	public static String toXML(final Object object) {
		try {
			XStream xStream = createXStream();
			ByteArrayOutputStream bos = new ByteArrayOutputStream();
			Writer w = new OutputStreamWriter(bos,
					EncodingUtil.ENCODING_ISO_8859_1);
			xStream.toXML(object, w);
			return bos.toString();
		} catch (XStreamException e) {
			throw new XStreamUtilException(e);
		} catch (UnsupportedEncodingException e) {
			throw new XStreamUtilException(e);
		}
	}

	/**
	 * Write object.
	 * 
	 * @param object
	 *            the object
	 * @param pathFile
	 *            the path file
	 */
	public static void writeObject(Object object, String pathFile) {
		try {

			if (pathFile != null) {
				LOG.info("Se inicia el proceso de generacion del fichero "
						+ pathFile);
				FileUtils.write(new File(pathFile), toXML(object));
				LOG.info("Se finaliza el proceso de generacion del fichero "
						+ pathFile);
			} else {
				LOG.error("No hay elementos en la lista de objetos");
			}
		} catch (FileNotFoundException e1) {
			LOG.error(e1.getMessage(), e1);
		} catch (IOException e) {
			LOG.error(e.getMessage(), e);
		}
	}

	/**
	 * Instantiates a new x stream util.
	 */
	private XStreamUtil() {
		super();
	}
}

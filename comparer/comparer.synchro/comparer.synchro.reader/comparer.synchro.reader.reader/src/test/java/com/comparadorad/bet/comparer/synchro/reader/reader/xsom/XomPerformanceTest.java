/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.reader.reader.xsom;

import java.io.IOException;
import java.util.Date;

import nu.xom.Builder;
import nu.xom.Comment;
import nu.xom.DocType;
import nu.xom.Document;
import nu.xom.Element;
import nu.xom.Node;
import nu.xom.ParsingException;
import nu.xom.ProcessingInstruction;
import nu.xom.Text;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;

/**
 * The Class XomPerformanceTest.
 * 
 * Test the time of read an xml (5mb) with xsom
 */
public class XomPerformanceTest {

	/** The Constant LOG. */
	private static final Log LOG = LogFactory.getLog(XomPerformanceTest.class);

	/** The log active. */
	private static boolean logActive = false;

	/**
	 * List children.
	 * 
	 * @param current
	 *            the current
	 * @param depth
	 *            the depth
	 */
	public static void listChildren(Node current, int depth) {

		printSpaces(depth);
		String data = "";
		if (current instanceof Element) {
			Element temp = (Element) current;
			data = ": " + temp.getQualifiedName();
		} else if (current instanceof ProcessingInstruction) {
			ProcessingInstruction temp = (ProcessingInstruction) current;
			data = ": " + temp.getTarget();
		} else if (current instanceof DocType) {
			DocType temp = (DocType) current;
			data = ": " + temp.getRootElementName();
		} else if (current instanceof Text || current instanceof Comment) {
			String value = current.getValue();
			value = value.replace('\n', ' ').trim();
			if (value.length() <= 20) {
				data = ": " + value;
			} else {
				data = ": " + current.getValue().substring(0, 17) + "...";
			}
		}
		// Attributes are never returned by getChild()
		if (logActive) {
			LOG.info(current.getClass().getName() + data);
		}
		for (int i = 0; i < current.getChildCount(); i++) {
			listChildren(current.getChild(i), depth + 1);
		}

	}

	/**
	 * Prints the spaces.
	 * 
	 * @param n
	 *            the n
	 */
	private static void printSpaces(int number) {

		for (int i = 0; i < number; i++) {
			if (logActive) {
				LOG.info(' ');
			}
		}
	}

	/**
	 * Read1 reg xsom.
	 */
	@Test
	public void read1RegXsom() {
		readXsom("XomPerformanceTest.xml");
	}

	/**
	 * Read xsom.
	 * 
	 * @param fileName
	 *            the file name
	 */
	private void readXsom(String fileName) {
		try {
			Date initTime = new Date();
			Builder parser = new Builder();
			Document doc = parser.build(this.getClass().getResourceAsStream(
					fileName));
			Element root = doc.getRootElement();
			listChildren(root, 0);
			Date endTime = new Date();
			LOG.info("initTime: " + initTime + "  endTime: " + endTime);
		} catch (ParsingException ex) {
			LOG.error("Cafe con Leche is malformed today. How embarrassing!");
		} catch (IOException ex) {
			LOG.error("Could not connect to Cafe con Leche. The site may be down.");
		}
	}
}

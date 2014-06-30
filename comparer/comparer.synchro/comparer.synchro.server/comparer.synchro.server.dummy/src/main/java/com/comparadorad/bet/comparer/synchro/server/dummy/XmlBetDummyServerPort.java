/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.server.dummy;

import java.io.IOException;
import java.net.ServerSocket;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * The Class MongoConfigPort.
 */
public class XmlBetDummyServerPort {

	/** The Constant LOG. */
	private static final Log LOG = LogFactory.getLog(XmlBetDummyServerPort.class);

	/**
	 * Find free port.
	 * 
	 * @return the int
	 */
	public static int findFreePort() {
		ServerSocket server = null;
		try {
			server = new ServerSocket(0);
			int port = server.getLocalPort();
			server.close();
			return port;
		} catch (IOException e) {
			LOG.error(e.getMessage(), e);
			throw new RuntimeException(e.getMessage(), e);
		} finally {
			if (server != null) {
				try {
					server.close();
				} catch (IOException e) {
					LOG.error(e.getMessage(), e);
					throw new RuntimeException(e.getMessage(), e);
				}
			}
		}
	}

	/** The port. */
	private int port = -1;

	/**
	 * Gets the port.
	 * 
	 * @return the port
	 */
	public int getPort() {
		if (port == -1) {
			port = findFreePort();
		}
		return port;
	}

	/**
	 * Sets the port.
	 * 
	 * @param pPort
	 *            the new port
	 */
	public void setPort(int pPort) {
		port = pPort;
	}

}

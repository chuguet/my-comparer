/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.server.dummy;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.AbstractHandler;

import com.comparadorad.bet.comparer.util.commons.io.JarFileUtils;

/**
 * The Class XmlBetDummyServer.
 */
public class XmlBetDummyServer extends AbstractHandler {

	/** The Constant LOG. */
	private static final Log LOG = LogFactory.getLog(XmlBetDummyServer.class);
	/** The bet dummy server params. */
	@Inject
	private XmlBetDummyServerParams betDummyServerParams;

	/** The server. */
	private Server server;

	/**
	 * Handle.
	 * 
	 * @param target
	 *            the target
	 * @param baseRequest
	 *            the base request
	 * @param request
	 *            the request
	 * @param response
	 *            the response
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 * @throws ServletException
	 *             the servlet exception {@inheritDoc}
	 */
	@Override
	public final void handle(String target, Request baseRequest,
			HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		try {
			String xmlFile = "";
			response.setContentType("text/html;charset=utf-8");
			response.setStatus(HttpServletResponse.SC_OK);
			baseRequest.setHandled(true);
			xmlFile = (String) request.getParameter("xmlFile");
			if (xmlFile != null) {
				InputStream inputStream = getClass().getResourceAsStream(
						xmlFile);
				if (inputStream != null) {
					response.getWriter().println(IOUtils.toString(inputStream));
				} else {
					response.getWriter().println("File do not found");
				}
			}
			if (request.getParameter(betDummyServerParams.getProxiedUrlparam()) != null) {
				String proxiedUrl = request.getParameter(betDummyServerParams
						.getProxiedUrlparam());
				String fileId = "";
				for (Iterator<String> iterator = betDummyServerParams
						.getServerUrlMap().keySet().iterator(); iterator
						.hasNext();) {
					String serverUrl = (String) iterator.next();
					// LOG.debug("serverUrl:" + serverUrl + " proxiedUrl:"
					// + proxiedUrl);
					if (proxiedUrl.toLowerCase().contains(serverUrl)) {
						fileId = betDummyServerParams.getServerUrlMap().get(
								serverUrl);
						break;
					}
				}
				byte[] result = resolveFile(fileId);
				if (result != null) {
					response.getWriter().print(new String(result));
				} else {
					response.setStatus(HttpServletResponse.SC_NO_CONTENT);
				}
			}
		} catch (IOException e) {
			LOG.error(e.getMessage(), e);
			throw e;
		} catch (RuntimeException e) {
			LOG.error(e.getMessage(), e);
			throw e;
		}
	}

	/**
	 * Resolve file.
	 * 
	 * @param fileId
	 *            the file id
	 * @return the byte[]
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	private byte[] resolveFile(final String fileId) throws IOException {
		return JarFileUtils.resolveFile(fileId, ".xml", filePositionIndex,
				getClass());
	}

	/** The file position index. */
	private Map<String, Integer> filePositionIndex = new HashMap<String, Integer>();

	/**
	 * Inits the server.
	 * 
	 * @throws Exception
	 *             the exception
	 */
	public final void initServer() throws Exception {
		server = new Server(betDummyServerParams.getServerPort());
		server.setHandler(this);
		try {
			server.start();
			LOG.debug("Mock web server started in:"
					+ betDummyServerParams.getServerUrl());
		} catch (Exception e) {
			LOG.error(e.getMessage());
			throw new Exception(e.getMessage());
		}
	}

	/**
	 * Stop server.
	 * 
	 * @throws Exception
	 *             the exception
	 */
	public final void stopServer() throws Exception {
		try {
			server.stop();
			LOG.debug("Mock web server stopped in:"
					+ betDummyServerParams.getServerUrl());
		} catch (Exception e) {
			LOG.error(e.getMessage());
			throw new Exception(e.getMessage());
		}
	}
}

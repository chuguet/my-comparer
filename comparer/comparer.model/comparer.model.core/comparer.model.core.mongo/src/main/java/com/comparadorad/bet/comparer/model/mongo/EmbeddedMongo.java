/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.model.mongo;

import static java.util.Collections.singletonList;

import java.io.IOException;
import java.net.Authenticator;
import java.net.InetSocketAddress;
import java.net.PasswordAuthentication;
import java.net.Proxy;
import java.net.ProxySelector;
import java.net.SocketAddress;
import java.net.URI;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.comparadorad.bet.comparer.model.mongo.config.EmbeddedMongoConfig;

import de.flapdoodle.embedmongo.MongoDBRuntime;
import de.flapdoodle.embedmongo.MongodExecutable;
import de.flapdoodle.embedmongo.MongodProcess;
import de.flapdoodle.embedmongo.config.MongodConfig;
import de.flapdoodle.embedmongo.distribution.Version;
import de.flapdoodle.embedmongo.runtime.Network;

/**
 * The Class EmbeddedMongo.
 */
public class EmbeddedMongo {

	/**
	 * The Class TooManyFailedAttemptException.
	 */
	@SuppressWarnings("serial")
	private static final class TooManyFailedAttemptException extends
			RuntimeException {

	}

	/** The Constant LOG. */
	private static final Log LOG = LogFactory.getLog(EmbeddedMongo.class);

	/** The embedded mongo properties. */
	private final transient EmbeddedMongoConfig embededMongoConfig;

	/** The mongod. */
	private transient MongodProcess mongod;

	/** The mongod exe. */
	private transient MongodExecutable mongodExe;

	/** The version. */
	private transient Version version;

	/**
	 * Instantiates a new embedded mongo.
	 * 
	 * @param pEmbededMongoConfig
	 *            the embeded mongo config
	 */
	public EmbeddedMongo(final EmbeddedMongoConfig pEmbededMongoConfig) {
		super();
		this.embededMongoConfig = pEmbededMongoConfig;
	}

	/**
	 * Adds the authenticator.
	 */
	private void addAuthenticator() {
		Authenticator.setDefault(new Authenticator() {
			private int count = 0;
			private URL previous;
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				try {
					if (previous == getRequestingURL()) {
						count++;
					}
					if (previous != getRequestingURL()) {
						count = 0;
					} else {
						if (count > 3) {
							// Throw a RuntimeException to prevent locking the account
							throw new TooManyFailedAttemptException();
						}
						return new PasswordAuthentication(embededMongoConfig
								.getProxyUser(), embededMongoConfig.getProxyPassword().toCharArray());
					}
				} finally {
					previous = getRequestingURL();
				}
				return new PasswordAuthentication(embededMongoConfig.getProxyUser(), 
						embededMongoConfig.getProxyPassword().toCharArray());
			}
		});
	}

	/**
	 * Adds the proxy selector.
	 */
	private void addProxySelector() {
		final ProxySelector defaultProxySelector = ProxySelector.getDefault();
		ProxySelector.setDefault(new ProxySelector() {
			@Override
			public void connectFailed(final URI uri,
					final SocketAddress socketAddress, final IOException ioe) {
				// No connection
			}

			@Override
			public List<Proxy> select(final URI uri) {
				if (uri.getHost().equals("fastdl.mongodb.org")) {
					return singletonList(new Proxy(Proxy.Type.HTTP,
							new InetSocketAddress(embededMongoConfig
									.getProxyHost(), embededMongoConfig
									.getProxyPort())));
				} else {
					return defaultProxySelector.select(uri);
				}
			}
		});
	}

	/**
	 * Sets the version.
	 * 
	 * @param version
	 *            the new version
	 */
	public void setVersion(final Version version) {
		this.version = version;
	}

	/**
	 * Start.
	 */
	public void start() /* throws Exception */{
		try {
			LOG.info("STARTING MONGO IN:  " + embededMongoConfig.getProxyHost()
					+ ":" + embededMongoConfig.getMongoPort());
			this.addProxySelector();
			this.addAuthenticator();
			final MongoDBRuntime runtime = MongoDBRuntime.getDefaultInstance();
			if (version == null) {
				version = Version.V2_0_5;
			}
			mongodExe = runtime.prepare(new MongodConfig(version,
					embededMongoConfig.getMongoPort(), Network
							.localhostIsIPv6()));
			mongod = mongodExe.start();
		} catch (UnknownHostException e) {
			LOG.error(e.getMessage(), e);
		} catch (IOException e) {
			LOG.warn(e.getMessage());
		} catch (Throwable e) {
			LOG.error(e.getMessage(), e);
		}
	}

	/**
	 * Stop.
	 */
	public void stop() {
		try {
			LOG.info("STOPPING MONGO IN:  " + embededMongoConfig.getProxyHost()
					+ ":" + embededMongoConfig.getMongoPort());
			mongod.stop();
		} catch (Throwable e) {
			LOG.error(e.getMessage());
		} finally {
			mongodExe.cleanup();
		}
	}
}
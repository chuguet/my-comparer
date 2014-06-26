/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.model.dbcore.config;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;
import org.springframework.core.env.MapPropertySource;
import org.springframework.data.authentication.UserCredentials;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;

import com.comparadorad.bet.comparer.model.mongo.config.MongoConfigPort;
import com.comparadorad.bet.comparer.util.commons.profile.ProfileConstant;
import com.comparadorad.bet.comparer.util.commons.resource.RelativeUtil;
import com.mongodb.Mongo;
import com.mongodb.MongoOptions;
import com.mongodb.ReadPreference;
import com.mongodb.ServerAddress;

/**
 * The Class AbstractMongoConfig.
 */
abstract class AbstractMongoConfig extends AbstractMongoConfiguration {

	/** The ctx. */
	@Inject
	private ConfigurableApplicationContext ctx;

	/** The Constant ENVIROMENT. */
	private static final String ENVIROMENT = "enviroment";
	
	
	/**
	 * Gets the name property file.
	 *
	 * @return the name property file
	 */
	public abstract String getNamePropertyFile();
	
	/**
	 * Gets the path property file.
	 *
	 * @return the path property file
	 */
	public abstract String getPathPropertyFile();

	/**
	 * The Class UserAndPort.
	 */
	private class UserAndPort {

		/** The host. */
		private final String host;

		/** The port. */
		private final Integer port;

		/**
		 * Instantiates a new user and port.
		 * 
		 * @param host
		 *            the host
		 * @param port
		 *            the port
		 */
		public UserAndPort(String host, Integer port) {
			super();
			this.host = host;
			this.port = port;
		}

		/**
		 * Gets the host.
		 * 
		 * @return the host
		 */
		public String getHost() {
			return host;
		}

		/**
		 * Gets the port.
		 * 
		 * @return the port
		 */
		public Integer getPort() {
			return port;
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see java.lang.Object#toString()
		 */
		/**
		 * To string.
		 *
		 * @return the string
		 * {@inheritDoc}
		 */
		@Override
		public String toString() {
			return "UserAndPort [host=" + host + ", port=" + port + "]";
		}

	}

	/** The Constant DEFAULT_PORT. */
	private static final Integer DEFAULT_PORT = 27017;

	/** The Constant LOG. */
	private static final Log LOG = LogFactory.getLog(AbstractMongoConfig.class);

	/** The Constant SEPARATOR_LOCALHOST. */
	private static final String SEPARATOR_HOST = ",";

	/** The Constant SEPARATOR_PORT. */
	private static final String SEPARATOR_PORT = ":";

	/**
	 * Gets the separator host.
	 * 
	 * @return the separator host
	 */
	protected static String getSeparatorHost() {
		return SEPARATOR_HOST;
	}

	/**
	 * Gets the separator port.
	 * 
	 * @return the separator port
	 */
	protected static String getSeparatorPort() {
		return SEPARATOR_PORT;
	}

	/**
	 * Property sources placeholder configurer.
	 * 
	 * @return the property sources placeholder configurer
	 */
	@Bean
	public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
		return new PropertySourcesPlaceholderConfigurer();
	}

	/** The database name. */
	private String databaseName;

	/** The environment. */
	@Inject
	private Environment environment;

	/** The host. */

	private String host;

	/** The mongo config port. */
	@Autowired(required = false)
	private MongoConfigPort mongoConfigPort;

	/** The mongo initializer params create data. */
	private Boolean mongoInitializerParamsCreateData;

	/** The mongo initializer params default. */
	private Boolean mongoInitializerParamsDefault;

	/** The mongo initializer params drop. */
	private Boolean mongoInitializerParamsDrop;

	/** The password. */

	private String password;

	/**
	 * Numero de conexiones del pool de mongo.
	 */
	private String poolConexions;

	/** The port. */
	private Integer port;

	/** The replicas. */
	private List<String> replicas;

	/** The user. */
	private String user;

	/**
	 * Instantiates a new abstract mongo config.
	 */
	public AbstractMongoConfig() {
		super();
		LOG.info("Mongo configuration:" + getClass().getSimpleName());
	}

	/**
	 * Gets the database name.
	 * 
	 * @return the database name {@inheritDoc}
	 */
	@Override
	public String getDatabaseName() {
		return databaseName;
	}

	/**
	 * Gets the host.
	 * 
	 * @return the host
	 */
	public String getHost() {
		return host;
	}

	/**
	 * Gets the mongo config port.
	 * 
	 * @return the mongo config port
	 */
	public MongoConfigPort getMongoConfigPort() {
		return mongoConfigPort;
	}

	/**
	 * Gets the mongo initializer params create data.
	 * 
	 * @return the mongo initializer params create data
	 */
	public Boolean getMongoInitializerParamsCreateData() {
		return mongoInitializerParamsCreateData;
	}

	/**
	 * Gets the mongo initializer params default.
	 * 
	 * @return the mongo initializer params default
	 */
	public Boolean getMongoInitializerParamsDefault() {
		return mongoInitializerParamsDefault;
	}

	/**
	 * Gets the mongo initializer params drop.
	 * 
	 * @return the mongo initializer params drop
	 */
	public Boolean getMongoInitializerParamsDrop() {
		return mongoInitializerParamsDrop;
	}

	/**
	 * Gets the password.
	 * 
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Devuelve el numero de conexiones del pool de mongo.
	 * 
	 * @return Número de conexiones
	 */
	public int getPoolConexions() {
		return Integer.valueOf(poolConexions);
	}

	/**
	 * Gets the port.
	 * 
	 * @return the port
	 */
	public int getPort() {
		if (port == null) {
			port = DEFAULT_PORT;
			if (mongoConfigPort != null) {
				this.port = mongoConfigPort.getPort();
			}
		}
		return port;
	}

	/**
	 * Gets the replicas.
	 * 
	 * @return the replicas
	 */
	protected List<String> getReplicas() {
		return replicas;
	}

	/**
	 * Gets the replicas.
	 * 
	 * @param replicas
	 *            the replicas
	 * @return the replicas
	 */
	private List<String> getReplicas(String replicas) {
		List<String> result;
		result = Arrays.asList(replicas.split(getSeparatorHost()));
		if (result.size() == 1 && result.get(0).equals("")) {
			result = new ArrayList<String>();
		}
		return result;
	}

	/**
	 * Gets the user.
	 * 
	 * @return the user
	 */
	public String getUser() {
		return user;
	}

	/**
	 * Gets the user and port.
	 * 
	 * @param server
	 *            the server
	 * @return the user and port
	 */
	protected UserAndPort getUserAndPort(String server) {
		UserAndPort result;
		String host = server.substring(0, server.indexOf(getSeparatorPort()));
		Integer port = Integer.parseInt(server.substring(
				server.indexOf(getSeparatorPort()) + 1, server.length()));
		result = new UserAndPort(host, port);
		return result;
	}

	/**
	 * Gets the user credentials.
	 * 
	 * @return the user credentials {@inheritDoc}
	 */
	@Override
	public UserCredentials getUserCredentials() {
		UserCredentials userCredentials = null;
		if (getUser() != null) {
			userCredentials = new UserCredentials(getUser(), getPassword());
		}
		return userCredentials;
	}

	/**
	 * Mongo.
	 * 
	 * @return the mongo
	 * @throws Exception
	 *             the exception {@inheritDoc}
	 */
	@Override
	@Bean
	public Mongo mongo() throws Exception {
		Mongo mongo = null;
		MongoOptions mongoOptions;
		ServerAddress master;
		List<ServerAddress> servers;
		UserAndPort userAndPort;

		resolverParameters();

		mongoOptions = new MongoOptions();
		mongoOptions.connectionsPerHost = getPoolConexions();
		master = new ServerAddress(getHost(), getPort());

		if (getReplicas().size() == 0) {
			mongo = new Mongo(master, mongoOptions);
		} else {
			servers = new ArrayList<ServerAddress>();
			servers.add(master);
			for (String replica : getReplicas()) {
				userAndPort = getUserAndPort(replica);
				servers.add(new ServerAddress(userAndPort.getHost(),
						userAndPort.getPort()));
			}
			mongoOptions.setReadPreference(ReadPreference.secondaryPreferred());
			mongo = new Mongo(servers, mongoOptions);
		}

		LOG.info(new StringBuffer("Database --- ").append((mongo.toString()))
				.append(" ").append(getDatabaseName()));
		return mongo;
	}

	/**
	 * Resolver parameters.
	 */
	private void resolverParameters() {

		
		Map<String, Object> map = RelativeUtil
				.convertResourceToMap(RelativeUtil.makeResource(getPathPropertyFile(),
						getNamePropertyFile()));

		MapPropertySource propertySource = new MapPropertySource(ENVIROMENT,
				map);

		ctx.getEnvironment().getPropertySources().addFirst(propertySource);

		if (user == null) {
			databaseName = environment.getProperty("db.mongo.databaseName");
			UserAndPort userAndPort = getUserAndPort(environment
					.getProperty("db.mongo.host"));
			host = userAndPort.getHost();
			port = userAndPort.getPort();
			password = environment.getProperty("db.mongo.password");
			user = environment.getProperty("db.mongo.user");
			poolConexions = environment.getProperty("db.mongo.conexions");
			mongoInitializerParamsDefault = environment.getProperty(
					"db.mongo.params.default", Boolean.class);
			mongoInitializerParamsCreateData = environment.getProperty(
					"db.mongo.params.create", Boolean.class);
			mongoInitializerParamsDrop = environment.getProperty(
					"db.mongo.params.drop", Boolean.class);
			replicas = getReplicas(environment.getProperty("db.mongo.replicas",
					String.class));

			if (ArrayUtils.contains(environment.getActiveProfiles(),
					ProfileConstant.TEST_JENKINS)
					|| System.getProperty("jenkins") != null) {
				port = null;
				databaseName = "comparer_test_jenkins";
			}

		}
	}

	/**
	 * Sets the replicas.
	 * 
	 * @param replicas
	 *            the new replicas
	 */
	protected void setReplicas(List<String> replicas) {
		this.replicas = replicas;
	}
}

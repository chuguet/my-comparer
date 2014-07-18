package com.comparadorad.bet.comparer.web.server.hook.userservice.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public abstract class AbstractUserService implements IUserService {
	private Connection connect = null;

	private Statement statement = null;

	private ResultSet resultSet = null;

	protected static final String DRIVER = "com.mysql.jdbc.Driver";

	protected static final String URL = "jdbc:mysql://192.168.0.28:3306/";

	protected static final String DATABASE = "autosender";

	protected static final String USER = "root";

	protected static final String PWD = "root";

	private static final Log LOG = LogFactory.getLog(AbstractUserService.class);

	protected Connection getConnection() {
		try {
			LOG.info(new StringBuffer("Nos conectamos a: ").append(URL).append(
					DATABASE));
			Class.forName(DRIVER);
			connect = DriverManager.getConnection(URL + DATABASE, USER, PWD);
		} catch (ClassNotFoundException e) {
			LOG.error(e);
		} catch (SQLException e) {
			LOG.error(e);
		}
		return connect;
	}

	protected void close() {
		try {
			if (resultSet != null) {
				resultSet.close();
			}

			if (statement != null) {
				statement.close();
			}

			if (connect != null) {
				connect.close();
			}
		} catch (Exception e) {
			LOG.error(e);
		}
	}
}

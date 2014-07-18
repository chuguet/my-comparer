package com.comparadorad.bet.comparer.web.server.hook.userservice.database;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.comparadorad.bet.comparer.model.autosender.bean.ActionType;
import com.comparadorad.bet.comparer.model.autosender.bean.ActionType.ActionTypeName;
import com.comparadorad.bet.comparer.model.autosender.bean.User;
import com.comparadorad.bet.comparer.model.autosender.bean.UserAction;
import com.comparadorad.bet.comparer.model.autosender.bean.UserContent;
import com.comparadorad.bet.comparer.model.autosender.bean.UserContent.UserContentName;

/**
 * The Class UserService.
 */
public class UserService extends AbstractUserService {

	/** The Constant creationUser. */
	private static final String creationUser = "LiferayUserServiceHook";

	private static final Log LOG = LogFactory.getLog(UserService.class);

	private static final String DOT = ".";

	private static final String COMMA = ",";

	/**
	 * Save.
	 * 
	 * @param user
	 *            the user {@inheritDoc}
	 */
	public void save(User user) {
		try {
			PreparedStatement preparedStatement = null;
			Connection connect = getConnection();
			StringBuffer query;

			// Inserta en la tabla usuario
			query = new StringBuffer("INSERT INTO ")
					.append(DATABASE)
					.append(DOT)
					.append(TableName.USER)
					.append(" (CREATION_USER, CREATION_DATE, NAME, EMAIL, liferayUserId, ACTIVE) values (?, ?, ?, ?, ?, ?)");

			LOG.info(new StringBuffer("Se crea la consulta: ").append(query));

			preparedStatement = connect.prepareStatement(query.toString());

			LOG.info(new StringBuffer("Primer parametro: ")
					.append(creationUser));

			preparedStatement.setString(1, creationUser);

			LOG.info(new StringBuffer("Segundo parametro: ").append(new Date(
					Calendar.getInstance().getTimeInMillis())));

			preparedStatement.setDate(2, new Date(Calendar.getInstance()
					.getTimeInMillis()));

			LOG.info(new StringBuffer("Tercer parametro: ").append(user
					.getName()));

			preparedStatement.setString(3, user.getName());

			LOG.info(new StringBuffer("Cuarto parametro: ").append(user
					.getEmail()));

			preparedStatement.setString(4, user.getEmail());

			LOG.info(new StringBuffer("Quinto parametro: ").append(user
					.getLiferayUserId()));

			preparedStatement.setInt(5, user.getLiferayUserId());

			LOG.info(new StringBuffer("Sexto parametro: ").append(true));

			preparedStatement.setBoolean(6, true);
			preparedStatement.executeUpdate();

			query = new StringBuffer("SELECT MAX(USER_ID) FROM ")
					.append(DATABASE).append(DOT).append(TableName.USER);

			LOG.info(new StringBuffer("Se crea la consulta: ").append(query));

			preparedStatement = connect.prepareStatement(query.toString());
			ResultSet rs = preparedStatement.executeQuery();
			int idUsuario = 0;
			if (rs.next()) {
				idUsuario = rs.getInt(1);
			}

			for (UserContent content : user.getUserContents()) {
				// Inserta en la tabla UserContent
				
				LOG.info( new StringBuffer("El contenido es: ").append(content.getName()) );
				
				query = new StringBuffer("INSERT INTO ")
						.append(DATABASE)
						.append(DOT)
						.append(TableName.USER_CONTENT)
						.append(" (CREATION_USER, CREATION_DATE, NAME) values (?, ?, ?)");

				LOG.info(new StringBuffer("Se crea la consulta: ")
						.append(query));

				preparedStatement = connect.prepareStatement(query.toString());

				LOG.info(new StringBuffer("Se asigna el primer parametro: ")
						.append(creationUser));

				preparedStatement.setString(1, creationUser);

				LOG.info(new StringBuffer("Se asigna el segundo parametro: ")
						.append(new Date(Calendar.getInstance()
								.getTimeInMillis())));

				preparedStatement.setDate(2, new Date(Calendar.getInstance()
						.getTimeInMillis()));

				LOG.info(new StringBuffer("Se asigna el tercer parametro: ")
						.append(content.getName().ordinal()));

				preparedStatement.setInt(3, content.getName().ordinal());
				preparedStatement.executeUpdate();

				query = new StringBuffer("SELECT MAX(USER_CONTENT_ID) FROM ")
						.append(DATABASE).append(DOT)
						.append(TableName.USER_CONTENT);

				LOG.info(new StringBuffer("Se crea la consulta: ")
						.append(query));

				preparedStatement = connect.prepareStatement(query.toString());
				rs = preparedStatement.executeQuery();
				int idContent = 0;
				if (rs.next()) {
					idContent = rs.getInt(1);
				}

				// Inserta en la tabla UserContent - Usuario

				query = new StringBuffer("INSERT INTO ")
						.append(DATABASE)
						.append(DOT)
						.append(TableName.USER_USER_CONTENT)
						.append(" (USER_USER_ID, userContents_USER_CONTENT_ID) values (?, ?)");

				LOG.info(new StringBuffer("Se crea la consulta: ")
						.append(query));

				preparedStatement = connect.prepareStatement(query.toString());

				LOG.info(new StringBuffer("Primer parametro: ")
						.append(creationUser));

				preparedStatement.setInt(1, idUsuario);

				LOG.info(new StringBuffer("Segundo parametro: ")
						.append(idContent));

				preparedStatement.setInt(2, idContent);
				preparedStatement.executeUpdate();
			}

			for (UserAction action : user.getActions()) {
				// Inserta en la tabla UserActionType
				query = new StringBuffer("INSERT INTO ")
						.append(DATABASE)
						.append(DOT)
						.append(TableName.ACTION_TYPE)
						.append(" (CREATION_USER, CREATION_DATE, NAME) values (?, ?, ?)");

				LOG.info(new StringBuffer("Se crea la consulta: ")
						.append(query));

				preparedStatement = connect.prepareStatement(query.toString());

				LOG.info(new StringBuffer("Primer parametro: ")
						.append(creationUser));

				preparedStatement.setString(1, creationUser);

				LOG.info(new StringBuffer("Segundo parametro: ")
						.append(new Date(Calendar.getInstance()
								.getTimeInMillis())));

				preparedStatement.setDate(2, new Date(Calendar.getInstance()
						.getTimeInMillis()));

				LOG.info(new StringBuffer("Tercer parametro: ").append(action
						.getActionType().getName().ordinal()));

				preparedStatement.setInt(3, action.getActionType().getName()
						.ordinal());
				preparedStatement.executeUpdate();

				query = new StringBuffer("SELECT MAX(ACTION_TYPE_ID) FROM ")
						.append(DATABASE).append(DOT)
						.append(TableName.ACTION_TYPE);

				LOG.info(new StringBuffer("Se crea la consulta: ")
						.append(query));

				preparedStatement = connect.prepareStatement(query.toString());

				rs = preparedStatement.executeQuery();
				int idActionType = 0;
				if (rs.next()) {
					idActionType = rs.getInt(1);
				}

				// Inserta en la tabla UserAction

				query = new StringBuffer("INSERT INTO ")
						.append(DATABASE)
						.append(DOT)
						.append(TableName.USER_ACTION)
						.append(" (CREATION_USER, CREATION_DATE, actionType_ACTION_TYPE_ID, user_USER_ID) values (?, ?, ?, ?)");

				LOG.info(new StringBuffer("Se crea la consulta: ")
						.append(query));

				preparedStatement = connect.prepareStatement(query.toString());

				LOG.info(new StringBuffer("Primer parametro: ")
						.append(creationUser));

				preparedStatement.setString(1, creationUser);

				LOG.info(new StringBuffer("Segundo parametro: ")
						.append(new Date(Calendar.getInstance()
								.getTimeInMillis())));

				preparedStatement.setDate(2, new Date(Calendar.getInstance()
						.getTimeInMillis()));

				LOG.info(new StringBuffer("Tercer parametro: ")
						.append(idActionType));

				preparedStatement.setInt(3, idActionType);

				LOG.info(new StringBuffer("Cuarto parametro: ")
						.append(idUsuario));

				preparedStatement.setInt(4, idUsuario);
				preparedStatement.executeUpdate();

				query = new StringBuffer("SELECT MAX(USER_ACTION_ID) FROM ")
						.append(DATABASE).append(DOT)
						.append(TableName.USER_ACTION);

				LOG.info(new StringBuffer("Se crea la consulta: ")
						.append(query));

				preparedStatement = connect.prepareStatement(query.toString());

				rs = preparedStatement.executeQuery();
				int idAction = 0;
				if (rs.next()) {
					idAction = rs.getInt(1);
				}

				// Inserta en la tabla UserAction - Usuario

				query = new StringBuffer("INSERT INTO ")
						.append(DATABASE)
						.append(DOT)
						.append(TableName.USER_USER_ACTION)
						.append("(USER_USER_ID, actions_USER_ACTION_ID) values (?, ?)");

				LOG.info(new StringBuffer("Se crea la consulta: ")
						.append(query));

				preparedStatement = connect.prepareStatement(query.toString());

				LOG.info(new StringBuffer("Primer parametro: ")
						.append(creationUser));

				preparedStatement.setInt(1, idUsuario);

				LOG.info(new StringBuffer("Segundo parametro: ")
						.append(idUsuario));

				preparedStatement.setInt(2, idAction);

				preparedStatement.executeUpdate();

			}

		} catch (Exception e) {
			LOG.error(e);
		} finally {
			close();
		}
	}

	/**
	 * Update.
	 * 
	 * @param user
	 *            the user
	 * @param name
	 *            the name {@inheritDoc}
	 */
	public void update(User user, ActionTypeName name) {
		try {
			StringBuffer query;
			PreparedStatement preparedStatement = null;
			Connection connect = getConnection();

			// Modifico el cambio active y lo pongo a false
			query = new StringBuffer("UPDATE ")
					.append(DATABASE)
					.append(DOT)
					.append(TableName.USER)
					.append(" SET MODIFICATION_DATE=?, MODIFICATION_USER=?, name=? WHERE liferayUserId=?");

			LOG.info(new StringBuffer("Se crea la consulta: ").append(query));

			preparedStatement = connect.prepareStatement(query.toString());
			preparedStatement.setDate(1, new Date(Calendar.getInstance()
					.getTimeInMillis()));
			preparedStatement.setString(2, creationUser);
			preparedStatement.setString(3, user.getName());
			preparedStatement.setInt(4, user.getLiferayUserId());
			preparedStatement.executeUpdate();

			query = new StringBuffer("SELECT USER_ID FROM ").append(DATABASE)
					.append(DOT).append(TableName.USER)
					.append(" WHERE liferayUserId=?");

			LOG.info(new StringBuffer("Se crea la consulta: ").append(query));

			preparedStatement = connect.prepareStatement(query.toString());
			preparedStatement.setInt(1, user.getLiferayUserId());
			ResultSet rs = preparedStatement.executeQuery();
			int idUsuario = 0;
			if (rs.next()) {
				idUsuario = rs.getInt(1);
			}

			// Inserta en la tabla UserActionType
			if (name != null) {

				query = new StringBuffer("INSERT INTO ")
						.append(DATABASE)
						.append(DOT)
						.append(TableName.ACTION_TYPE)
						.append(" (CREATION_USER, CREATION_DATE, NAME) values (?, ?, ?)");

				LOG.info(new StringBuffer("Se crea la consulta: ")
						.append(query));

				preparedStatement = connect.prepareStatement(query.toString());

				preparedStatement.setString(1, creationUser);
				preparedStatement.setDate(2, new Date(Calendar.getInstance()
						.getTimeInMillis()));
				preparedStatement.setInt(3, name.ordinal());
				preparedStatement.executeUpdate();

				query = new StringBuffer("SELECT MAX(ACTION_TYPE_ID) FROM ")
						.append(DATABASE).append(DOT)
						.append(TableName.ACTION_TYPE);

				LOG.info(new StringBuffer("Se crea la consulta: ")
						.append(query));

				preparedStatement = connect.prepareStatement(query.toString());

				rs = preparedStatement.executeQuery();
				int idActionType = 0;
				if (rs.next()) {
					idActionType = rs.getInt(1);
				}

				// Inserta en la tabla UserAction

				query = new StringBuffer("INSERT INTO ")
						.append(DATABASE)
						.append(DOT)
						.append(TableName.USER_ACTION)
						.append(" (CREATION_USER, CREATION_DATE, actionType_ACTION_TYPE_ID, user_USER_ID) values (?, ?, ?, ?)");

				LOG.info(new StringBuffer("Se crea la consulta: ")
						.append(query));

				preparedStatement = connect.prepareStatement(query.toString());

				preparedStatement.setString(1, creationUser);
				preparedStatement.setDate(2, new Date(Calendar.getInstance()
						.getTimeInMillis()));
				preparedStatement.setInt(3, idActionType);
				preparedStatement.setInt(4, idUsuario);
				preparedStatement.executeUpdate();

				query = new StringBuffer("SELECT MAX(USER_ACTION_ID) FROM ")
						.append(DATABASE).append(DOT)
						.append(TableName.USER_ACTION);

				LOG.info(new StringBuffer("Se crea la consulta: ")
						.append(query));

				preparedStatement = connect.prepareStatement(query.toString());

				rs = preparedStatement.executeQuery();
				int idAction = 0;
				if (rs.next()) {
					idAction = rs.getInt(1);
				}

				// Inserta en la tabla UserAction - Usuario

				query = new StringBuffer("INSERT INTO ")
						.append(DATABASE)
						.append(DOT)
						.append(TableName.USER_USER_ACTION)
						.append(" (USER_USER_ID, actions_USER_ACTION_ID) values (?, ?)");

				LOG.info(new StringBuffer("Se crea la consulta: ")
						.append(query));

				preparedStatement = connect.prepareStatement(query.toString());

				preparedStatement.setInt(1, idUsuario);
				preparedStatement.setInt(2, idAction);
				preparedStatement.executeUpdate();
			}
		} catch (Exception e) {
			LOG.error(e);
		} finally {
			close();
		}
	}

	/**
	 * Delete.
	 * 
	 * @param pId
	 *            the id {@inheritDoc}
	 */
	public void delete(Integer pId) {
		// TODO
		// try {
		//
		// PreparedStatement preparedStatement = null;
		// Properties properties = getProperties();
		// Connection connect = getConnection(properties);
		//
		// // Borrar el usuario de la tabla USER
		// preparedStatement = connect
		// .prepareStatement("delete FROM " +
		// properties.getProperty("db.database")
		// + ".user WHERE liferayUserId=?");
		// preparedStatement.setInt(1, pId);
		// preparedStatement.execute();
		// } catch (Exception e) {
		// e.printStackTrace();
		// } finally {
		// close();
		// }
	}

	/**
	 * Find by liferay user.
	 * 
	 * @param pId
	 *            the id
	 * @return the user {@inheritDoc}
	 */
	public User findByLiferayUser(Integer pId) {
		User user = new User();
		try {
			StringBuffer query;
			PreparedStatement preparedStatement = null;
			Connection connect = getConnection();

			// Recuperamos los datos de USER

			query = new StringBuffer(
					"SELECT USER_ID, NAME, EMAIL, liferayUserId FROM ").append(
					TableName.USER).append(" WHERE liferayUserId=?");

			LOG.info(new StringBuffer("Se crea la consulta: ").append(query));

			preparedStatement = connect.prepareStatement(query.toString());
			preparedStatement.setInt(1, pId);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				user.setUserId(rs.getInt(1));
				user.setName(rs.getString(2));
				user.setEmail(rs.getString(3));
				user.setLiferayUserId(rs.getInt(4));
			}

			// Recuperamos los datos de USER_CONTENT

			query = new StringBuffer(
					"SELECT USER_CONTENT.USER_CONTENT_ID, USER_CONTENT.NAME FROM ")
					.append(TableName.USER)
					.append(COMMA)
					.append(TableName.USER_CONTENT)
					.append(COMMA)
					.append(TableName.USER_USER_CONTENT)
					.append(" WHERE")
					.append(" USER.liferayUserId=? and USER.USER_ID=USER_USER_CONTENT.USER_USER_ID and USER_CONTENT.USER_CONTENT_ID=USER_USER_CONTENT.userContents_USER_CONTENT_ID");

			LOG.info(new StringBuffer("Se crea la consulta: ").append(query));

			preparedStatement = connect.prepareStatement(query.toString());
			preparedStatement.setInt(1, pId);
			rs = preparedStatement.executeQuery();
			List<UserContent> contents = new ArrayList<UserContent>();
			UserContent content;
			while (rs.next()) {
				content = new UserContent();
				content.setUserContentId(rs.getInt(1));
				UserContentName contentName = getUserContentName2(rs.getInt(2));
				content.setName(contentName);
				contents.add(content);
			}
			user.setUserContents(contents);

			// Recuperamos los datos de USER_CONTENT

			query = new StringBuffer(
					"SELECT USER_ACTION.USER_ACTION_ID, USER_ACTION.ACTIONTYPE_ACTION_TYPE_ID FROM ")
					.append(TableName.USER)
					.append(COMMA)
					.append(TableName.USER_ACTION)
					.append(COMMA)
					.append(TableName.USER_USER_ACTION)
					.append(" WHERE  USER.liferayUserId=? and USER.USER_ID=USER_USER_ACTION.USER_USER_ID and USER_ACTION.USER_ACTION_ID=USER_USER_ACTION.actions_USER_ACTION_ID");

			LOG.info(new StringBuffer("Se crea la consulta: ").append(query));

			preparedStatement = connect.prepareStatement(query.toString());

			preparedStatement.setInt(1, pId);
			rs = preparedStatement.executeQuery();
			List<UserAction> actions = new ArrayList<UserAction>();
			UserAction action;
			ActionType actionType = new ActionType();
			while (rs.next()) {
				action = new UserAction();
				action.setUser(user);
				action.setUserActionId(rs.getInt(1));
				int ordinalActionType = rs.getInt(2);

				query = new StringBuffer("SELECT NAME FROM ").append(
						TableName.ACTION_TYPE).append(
						" ACTION_TYPE WHERE ACTION_TYPE_ID=?");

				LOG.info(new StringBuffer("Se crea la consulta: ")
						.append(query));

				preparedStatement = connect.prepareStatement(query.toString());

				preparedStatement.setInt(1, ordinalActionType);
				ResultSet actionRS = preparedStatement.executeQuery();
				while (actionRS.next()) {
					actionType.setActionTypeId(ordinalActionType);
					int ordinal = actionRS.getInt(1);
					actionType.setName(getActionTypeName(ordinal));
				}
				action.setActionType(actionType);
				actions.add(action);
			}
			user.setActions(actions);

		} catch (Exception e) {
			LOG.error(e);
		} finally {
			close();
		}
		return user;
	}

	/**
	 * Find by email.
	 * 
	 * @param email
	 *            the email
	 * @return the user {@inheritDoc}
	 */
	public User findByEmail(String email) {
		User user = new User();
		try {
			StringBuffer query;
			PreparedStatement preparedStatement = null;
			Connection connect = getConnection();

			// Recuperamos los datos de USER

			query = new StringBuffer(
					"SELECT USER_ID, NAME, EMAIL, liferayUserId FROM ").append(
					TableName.USER).append(" WHERE email=?");

			LOG.info(new StringBuffer("Se crea la consulta: ").append(query));

			preparedStatement = connect.prepareStatement(query.toString());
			preparedStatement.setString(1, email);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				user.setUserId(rs.getInt(1));
				user.setName(rs.getString(2));
				user.setEmail(rs.getString(3));
				user.setLiferayUserId(rs.getInt(4));
			}

			// Recuperamos los datos de USER_CONTENT

			query = new StringBuffer(
					"SELECT USER_CONTENT.USER_CONTENT_ID, USER_CONTENT.NAME FROM ")
					.append(TableName.USER)
					.append(COMMA)
					.append(TableName.USER_CONTENT)
					.append(COMMA)
					.append(TableName.USER_USER_CONTENT)
					.append(" WHERE USER.email=? and USER.USER_ID=USER_USER_CONTENT.USER_USER_ID AND USER_CONTENT.USER_CONTENT_ID=USER_USER_CONTENT.userContents_USER_CONTENT_ID");

			LOG.info(new StringBuffer("Se crea la consulta: ").append(query));

			preparedStatement = connect.prepareStatement(query.toString());
			preparedStatement.setString(1, email);
			rs = preparedStatement.executeQuery();
			List<UserContent> contents = new ArrayList<UserContent>();
			UserContent content;
			while (rs.next()) {
				content = new UserContent();
				content.setUserContentId(rs.getInt(1));
				UserContentName contentName = getUserContentName2(rs.getInt(2));
				content.setName(contentName);
				contents.add(content);
			}
			user.setUserContents(contents);

			// Recuperamos los datos de USER_CONTENT
			query = new StringBuffer(
					"SELECT USER_ACTION.USER_ACTION_ID, USER_ACTION..ACTIONTYPE_ACTION_TYPE_ID FROM ")
					.append(TableName.USER)
					.append(COMMA)
					.append(TableName.USER_ACTION)
					.append(COMMA)
					.append(TableName.USER_USER_ACTION)
					.append(" WHERE USER.email=? AND USER.USER_ID=USER_USER_ACTION.USER_USER_ID and USER_ACTION.USER_ACTION_ID=USER_USER_ACTION.actions_USER_ACTION_ID");

			LOG.info(new StringBuffer("Se crea la consulta: ").append(query));

			preparedStatement = connect.prepareStatement(query.toString());
			preparedStatement.setString(1, email);
			rs = preparedStatement.executeQuery();
			List<UserAction> actions = new ArrayList<UserAction>();
			UserAction action;
			ActionType actionType = new ActionType();
			while (rs.next()) {
				action = new UserAction();
				action.setUser(user);
				action.setUserActionId(rs.getInt(1));
				int ordinalActionType = rs.getInt(2);

				query = new StringBuffer("SELECT NAME FROM ").append(
						TableName.ACTION_TYPE)
						.append(" WHERE ACTION_TYPE_ID=?");

				LOG.info(new StringBuffer("Se ejecuta la consulta: ")
						.append(query));

				preparedStatement = connect.prepareStatement(query.toString());
				preparedStatement.setInt(1, ordinalActionType);
				ResultSet actionRS = preparedStatement.executeQuery();
				while (actionRS.next()) {
					actionType.setActionTypeId(ordinalActionType);
					int ordinal = actionRS.getInt(1);
					actionType.setName(getActionTypeName(ordinal));
				}
				action.setActionType(actionType);
				actions.add(action);
			}
			user.setActions(actions);

		} catch (Exception e) {
			LOG.error(e);
		} finally {
			close();
		}
		return user;
	}

	/**
	 * Gets the action type name.
	 * 
	 * @param ordinal
	 *            the ordinal
	 * @return the action type name
	 */
	private ActionTypeName getActionTypeName(int ordinal) {
		ActionTypeName result = null;
		for (ActionTypeName actionName : ActionTypeName.values()) {
			if (actionName.ordinal() == ordinal) {
				result = actionName;
			}
		}
		return result;
	}

	/**
	 * Gets the user content name.
	 * 
	 * @param ordinal
	 *            the ordinal
	 * @return the user content name
	 */
	private UserContentName getUserContentName2(int ordinal) {
		UserContentName result = null;
		for (UserContentName contentName : UserContentName.values()) {
			if (contentName.ordinal() == ordinal) {
				result = contentName;
			}
		}
		return result;
	}

	/**
	 * Deactivate.
	 * 
	 * @param pId
	 *            the id
	 * @param name
	 *            the name {@inheritDoc}
	 */
	public void deactivate(Integer pId, ActionTypeName name) {
		try {
			StringBuffer query;
			PreparedStatement preparedStatement = null;
			Connection connect = getConnection();

			// Modifico el cambio active y lo pongo a false

			query = new StringBuffer("UPDATE ")
					.append(TableName.USER)
					.append(" SET MODIFICATION_DATE=?, MODIFICATION_USER=?, active=? WHERE liferayUserId=?");

			LOG.info(new StringBuffer("Se ejecuta la consulta: ").append(query));

			preparedStatement = connect.prepareStatement(query.toString());
			preparedStatement.setDate(1, new Date(Calendar.getInstance()
					.getTimeInMillis()));
			preparedStatement.setString(2, creationUser);
			preparedStatement.setBoolean(3, false);
			preparedStatement.setInt(4, pId);
			preparedStatement.executeUpdate();

			User user = findByLiferayUser(pId);

			// Inserta en la tabla UserActionType
			query = new StringBuffer("INSERT INTO ")
					.append(DATABASE)
					.append(DOT)
					.append(TableName.ACTION_TYPE)
					.append(" (CREATION_USER, CREATION_DATE, NAME) values (?, ?, ?)");

			LOG.info(new StringBuffer("Se ejecuta la consulta: ").append(query));

			preparedStatement = connect.prepareStatement(query.toString());
			preparedStatement.setString(1, creationUser);
			preparedStatement.setDate(2, new Date(Calendar.getInstance()
					.getTimeInMillis()));
			preparedStatement.setInt(3, name.ordinal());
			preparedStatement.executeUpdate();

			query = new StringBuffer("SELECT MAX(ACTION_TYPE_ID) FROM ")
					.append(DATABASE)
					.append(DOT)
					.append(TableName.ACTION_TYPE)
					.append(DATABASE)
					.append(DOT)
					.append(TableName.ACTION_TYPE)
					.append(" (CREATION_USER, CREATION_DATE, NAME) values (?, ?, ?)");

			LOG.info(new StringBuffer("Se ejecuta la consulta: ").append(query));

			preparedStatement = connect.prepareStatement(query.toString());
			ResultSet rs = preparedStatement.executeQuery();
			int idActionType = 0;
			if (rs.next()) {
				idActionType = rs.getInt(1);
			}

			// Inserta en la tabla UserAction

			query = new StringBuffer("INSERT INTO ")
					.append(DATABASE)
					.append(DOT)
					.append(TableName.USER_ACTION)
					.append(" (CREATION_USER, CREATION_DATE, actionType_ACTION_TYPE_ID, user_USER_ID) values (?, ?, ?, ?)");

			LOG.info(new StringBuffer("Se ejecuta la consulta: ").append(query));

			preparedStatement = connect.prepareStatement(query.toString());
			preparedStatement.setString(1, creationUser);
			preparedStatement.setDate(2, new Date(Calendar.getInstance()
					.getTimeInMillis()));
			preparedStatement.setInt(3, idActionType);
			preparedStatement.setInt(4, user.getUserId());
			preparedStatement.executeUpdate();

			query = new StringBuffer("SELECT MAX(USER_ACTION_ID) FROM ")
					.append(DATABASE).append(DOT).append(TableName.USER_ACTION);

			LOG.info(new StringBuffer("Se ejecuta la consulta: ").append(query));

			preparedStatement = connect.prepareStatement(query.toString());
			rs = preparedStatement.executeQuery();
			int idAction = 0;
			if (rs.next()) {
				idAction = rs.getInt(1);
			}

			// Inserta en la tabla UserAction - Usuario

			query = new StringBuffer("INSERT INTO ")
					.append(DATABASE)
					.append(DOT)
					.append(TableName.USER_USER_ACTION)
					.append(" (USER_USER_ID, actions_USER_ACTION_ID) values (?, ?)");

			LOG.info(new StringBuffer("Se ejecuta la consulta: ").append(query));

			preparedStatement = connect.prepareStatement(query.toString());
			preparedStatement.setInt(1, user.getUserId());
			preparedStatement.setInt(2, idAction);
			preparedStatement.executeUpdate();

		} catch (Exception e) {
			LOG.error(e);
		} finally {
			close();
		}
	}

}

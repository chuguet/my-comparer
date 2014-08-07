/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.web.server.mvc.core.convert;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.dozer.Mapping;
import org.junit.Before;
import org.junit.Test;

import com.comparadorad.bet.comparer.model.core.bean.IModel;
import com.comparadorad.bet.comparer.web.client.gwt.core.bean.IClientTo;

/**
 * The Class AnnotationModelToToClientConverterTest.
 */
public class AbstractAnnotMdlLstToClientConverterTest {

	/**
	 * The Class User.
	 */
	@SuppressWarnings("serial")
	public static class User implements IModel {

		/** The age. */
		private Short age;

		/** The free text. */
		private String freeText;

		/** The id. */
		private Long id;

		/** The name. */
		@Mapping("username")
		private String name;

		/**
		 * Instantiates a new user.
		 * 
		 * @param pId
		 *            the id
		 * @param pName
		 *            the name
		 * @param pAge
		 *            the age
		 * @param pFreeText
		 *            the free text
		 */
		public User(Long pId, String pName, Short pAge, String pFreeText) {
			super();
			id = pId;
			name = pName;
			age = pAge;
			freeText = pFreeText;
		}

		/**
		 * Gets the age.
		 * 
		 * @return the age
		 */
		public Short getAge() {
			return age;
		}

		/**
		 * Gets the id.
		 * 
		 * @return the id
		 */
		@Mapping("pk")
		public Long getId() {
			return id;
		}

		/**
		 * Sets the age.
		 * 
		 * @param age
		 *            the new age
		 */
		public void setAge(Short age) {
			this.age = age;
		}

		/**
		 * Sets the id.
		 * 
		 * @param id
		 *            the new id
		 */
		public void setId(Long id) {
			this.id = id;
		}
	}

	/**
	 * The Class UserDto.
	 */
	public static class UserDto implements IClientTo {

		/** The comment. */
		@Mapping("freeText")
		private String comment;

		/** The id. */
		private String id;

		/** The name. */
		//private String name;

		/** The pk. */
		private String pk;

		/** The username. */
		private String username;

		/** The years. */
		private String years;

		/**
		 * Gets the id.
		 * 
		 * @return the id
		 */
		public String getId() {
			return id;
		}

		/**
		 * Gets the pk.
		 * 
		 * @return the pk
		 */
		public String getPk() {
			return pk;
		}

		/**
		 * Gets the years.
		 * 
		 * @return the years
		 */
		@Mapping("age")
		public String getYears() {
			return years;
		}

		/**
		 * Sets the id.
		 * 
		 * @param id
		 *            the new id
		 */
		public void setId(String id) {
			this.id = id;
		}

		/**
		 * Sets the pk.
		 * 
		 * @param pk
		 *            the new pk
		 */
		public void setPk(String pk) {
			this.pk = pk;
		}

		/**
		 * Sets the years.
		 * 
		 * @param years
		 *            the new years
		 */
		public void setYears(String years) {
			this.years = years;
		}
	}

	/**
	 * The Class UserDtoList.
	 */
	public static class UserDtoList implements IClientTo {

		/** The user dtos. */
		private List<UserDto> userDtos = new ArrayList<AbstractAnnotMdlLstToClientConverterTest.UserDto>();

		/**
		 * Adds the.
		 * 
		 * @param pE
		 *            the p e
		 * @return true, if successful
		 */
		public boolean add(UserDto pE) {
			return userDtos.add(pE);
		}

		/**
		 * Gets the user dtos.
		 * 
		 * @return the user dtos
		 */
		public List<UserDto> getUserDtos() {
			return userDtos;
		}

		/**
		 * Sets the user dtos.
		 * 
		 * @param pUserDtos
		 *            the new user dtos
		 */
		public void setUserDtos(List<UserDto> pUserDtos) {
			userDtos = pUserDtos;
		}
	}

	/**
	 * Sets the up.
	 * 
	 * @throws Exception
	 *             the exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * Test convert.
	 */
	@Test
	public void testConvert() {
		AbstractAnnotMdlLstToClientConverter<UserDtoList, User, UserDto> annotationModelListToToClientConverter 
			= new AbstractAnnotMdlLstToClientConverter<UserDtoList, User, UserDto>() {
			@SuppressWarnings("unchecked")
			@Override
			public UserDtoList convert(Iterable<?> pIModel) {
				UserDtoList result = new UserDtoList();
				for (User user : (Iterable<User>) pIModel) {
					UserDto userDto = map(user, UserDto.class);
					result.add(userDto);
				}
				return result;
			}
		};
		final List<User> sourceList = new ArrayList<AbstractAnnotMdlLstToClientConverterTest.User>();
		User user1 = new User((long) 1, "John", (short) 34, "text 1");
		sourceList.add(user1);
		User user2 = new User((long) 2, "Charles", (short) 34, "text 2");
		sourceList.add(user2);
		User user3 = new User((long) 1, "Hugh", (short) 66, "text 3");
		sourceList.add(user3);

		UserDtoList userDtoList = annotationModelListToToClientConverter
				.convert(sourceList);
		assertEquals(user1.id.toString(), userDtoList.getUserDtos().get(0).pk);
		assertEquals(user1.name, userDtoList.getUserDtos().get(0).username);
		assertEquals(user1.age.toString(),
				userDtoList.getUserDtos().get(0).years);
		assertEquals(user1.freeText, userDtoList.getUserDtos().get(0).comment);
	}
}

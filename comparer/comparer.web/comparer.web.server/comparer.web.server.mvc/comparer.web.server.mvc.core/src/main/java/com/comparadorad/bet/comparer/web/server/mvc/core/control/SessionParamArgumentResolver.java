/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.web.server.mvc.core.control;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.core.MethodParameter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.web.bind.support.WebArgumentResolver;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.servlet.support.RequestContextUtils;

import com.comparadorad.bet.comparer.model.core.bean.enume.LiferayRoles;
import com.comparadorad.bet.comparer.model.core.bean.user.Roles;
import com.comparadorad.bet.comparer.model.core.bean.user.UserData;

/**
 * The Class SessionParamArgumentResolver.
 */
public class SessionParamArgumentResolver implements WebArgumentResolver {

	/** The Constant SECURITY_TOKEN. */
	private static final String SECURITY_TOKEN = "SECURITY_TOKEN";
	// javax.portlet.p.comparerwebserverportlettoolbar_WAR_comcomparadoradbetcomparerwebserverportlettoolbar_LAYOUT_12671?SECURITY_TOKEN
	/** The Constant LOG. */
	private static final Log LOG = LogFactory
			.getLog(SessionParamArgumentResolver.class);

	/** {@inheritDoc} */
	@Override
	public Object resolveArgument(final MethodParameter param,
			final NativeWebRequest request) throws Exception {

		Class<?> paramType = param.getParameterType();
		if (paramType.equals(UserData.class)) {

			HttpServletRequest httprequest = (HttpServletRequest) request
					.getNativeRequest();

			HttpSession session = httprequest.getSession(false);

			UserData result = null;
			if (session != null) {
				result = (UserData) session.getAttribute(UserData.class
						.getName());
			}
			if (result == null) {
				result = new UserData();
			}

			String element = null;
			if (session != null && session.getAttributeNames() != null) {
				Enumeration<String> attributes = session.getAttributeNames();

				while (attributes.hasMoreElements()) {
					String atri = (String) attributes.nextElement();
					if (atri.contains(SECURITY_TOKEN)) {
						element = atri;
						break;
					}

				}
			}
			Authentication auth = null;
			if (element != null) {
				auth = (Authentication) session.getAttribute(element);
				result.setPrincipal(auth.getPrincipal().toString());
			}

			Roles roles = new Roles();
			List<LiferayRoles> liferayRoles = new ArrayList<LiferayRoles>();
			if (auth != null && auth.getAuthorities().size() != 0) {
				for (GrantedAuthority authority : auth.getAuthorities()) {
					liferayRoles.add(process(authority.getAuthority()));
				}

			} else {
				liferayRoles.add(LiferayRoles.UNREGISTERED);
			}
			roles.setRoles(liferayRoles);
			result.setRoles(roles);

			Cookie[] cookies = httprequest.getCookies();
			String localeResolved = null;
			String timeZoneResolved = null;
			if (cookies != null) {
				for (Cookie cookie : cookies) {
					if (cookie.getName().equals("GUEST_LANGUAGE_ID")) {
						localeResolved = cookie.getValue();
						String[] strLocale = localeResolved.split("_");
						result.setLocale(new Locale(strLocale[0], strLocale[1]));
					} else if (cookie.getName().equals("USER_TIMEZONE")) {
						timeZoneResolved = cookie.getValue();
						result.setTimeZone(TimeZone
								.getTimeZone(timeZoneResolved));
					}
				}
			}
			if (localeResolved == null) {
				result.setLocale(RequestContextUtils.getLocale(httprequest));
			}
			if (timeZoneResolved == null) {
				result.setTimeZone(TimeZone.getDefault());
			}

			return result;

		}
		return WebArgumentResolver.UNRESOLVED;
	}

	private LiferayRoles process(String name) {
		if (name.equalsIgnoreCase("gratuitos") || name.equalsIgnoreCase("free")) {

			return LiferayRoles.FREE;
		}
		if (name.contains("0")) {

			return LiferayRoles.SPECIAL_LEVEL_0;
		}
		if (name.contains("1")) {

			return LiferayRoles.LEVEL_1;
		}
		if (name.contains("2")) {

			return LiferayRoles.LEVEL_2;
		}
		if (name.contains("3")) {

			return LiferayRoles.LEVEL_3;
		}

		return LiferayRoles.UNREGISTERED;

	}
}
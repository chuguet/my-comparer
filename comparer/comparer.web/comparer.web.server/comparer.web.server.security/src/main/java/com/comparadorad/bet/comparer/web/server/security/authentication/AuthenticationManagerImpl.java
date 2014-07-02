/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.web.server.security.authentication;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.UserGroup;
import com.liferay.portal.service.UserLocalServiceUtil;

/**
 * The Class AuthenticationManagerImpl.
 */
public class AuthenticationManagerImpl implements AuthenticationManager {

	/** The Constant LOG. */
	private static final Log LOG = LogFactory
			.getLog(AuthenticationManagerImpl.class);

	/** {@inheritDoc} */
	@Override
	public Authentication authenticate(Authentication auth)
			throws AuthenticationException {
		Collection<GrantedAuthority> authList = new ArrayList<GrantedAuthority>();
		try {
			LOG.debug("Roles del usuario " + auth.getName() + ": ");
			
			for (UserGroup userGroup : UserLocalServiceUtil.getUser(
					Long.valueOf(auth.getName()).longValue()).getUserGroups()) {
				authList.add(new SimpleGrantedAuthority(userGroup.getName()));
				LOG.debug(userGroup.getName());
			}
		} catch (NumberFormatException e) {
			LOG.error("Error: No se puedieron obtener los roles del usuario.");
		} catch (SystemException e) {
			LOG.error("Error: No se puedieron obtener los roles del usuario.");
		} catch (PortalException e) {
			LOG.error("Error: No se puedieron obtener los roles del usuario.");
		}
		return new UsernamePasswordAuthenticationToken(auth.getName(),
				auth.getCredentials(), authList);
	}

}

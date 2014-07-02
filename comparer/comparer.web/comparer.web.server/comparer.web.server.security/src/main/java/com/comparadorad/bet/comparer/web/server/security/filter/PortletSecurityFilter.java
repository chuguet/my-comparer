/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.web.server.security.filter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.EventRequest;
import javax.portlet.EventResponse;
import javax.portlet.PortletException;
import javax.portlet.PortletSession;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.portlet.filter.ActionFilter;
import javax.portlet.filter.EventFilter;
import javax.portlet.filter.FilterChain;
import javax.portlet.filter.FilterConfig;
import javax.portlet.filter.RenderFilter;
import javax.portlet.filter.ResourceFilter;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.security.authentication.AuthenticationDetailsSource;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.preauth.PreAuthenticatedAuthenticationToken;

import com.comparadorad.bet.comparer.web.server.security.authentication.AuthenticationManagerImpl;

/**
 * Implements security behavior for Spring Security 3.0. Adds an Authentication
 * to the SecurityContext and to the PortletSession. Spring Security picks up
 * the Authentication when it meets annotated methods with the @Secured
 * annotation.
 */
public class PortletSecurityFilter implements ActionFilter, RenderFilter,
		ResourceFilter, EventFilter {

	/** The Constant LOG. */
	private static final Log LOG = LogFactory
			.getLog(PortletSecurityFilter.class);

	/** The Constant SECURITY_TOKEN. */
	private static final String SECURITY_TOKEN = "SECURITY_TOKEN";

	/** The authentication manager. */
	private AuthenticationManager authenticationManager = new AuthenticationManagerImpl();

	/** {@inheritDoc} */
	@Override
	/**
	 * Follow the Spring Security method for an AuthenticationFilter.
	 * @see AbstractAuthenticationProcessingFilter
	 */
	public void doFilter(ActionRequest request, ActionResponse response,
			FilterChain chain) throws IOException, PortletException {
		LOG.debug("PortletFilter for action.");

	}

	/**
	 * Default behavior for successful authentication.
	 * 
	 * Sets the successful Authentication object on the
	 * 
	 * @param request
	 *            the request
	 * @param response
	 *            the response
	 * @param authResult
	 *            the object returned from the attemptAuthentication method.
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 * @throws PortletException
	 *             the portlet exception {@link SecurityContextHolder} Sets the
	 *             Authentication onto the PortletSession
	 * @see AbstractAuthenticationProcessingFilter
	 */
	protected void successfulAuthentication(RenderRequest request,
			RenderResponse response, Authentication authResult)
			throws IOException, PortletException {

		if (LOG.isDebugEnabled()) {
			LOG.debug("Authentication success. Updating SecurityContextHolder to contain: "
					+ authResult);
		}
		SecurityContextHolder.getContext().setAuthentication(authResult);

		PortletSession session = request.getPortletSession();
		session.setAttribute(SECURITY_TOKEN, authResult);
	}

	/**
	 * Implementation of setDetails.
	 * 
	 * @param request
	 *            that an authentication request is being created for
	 * @param authRequest
	 *            the authentication request object that should have its details
	 *            set
	 * @see UsernamePasswordAuthenticationFilter
	 */
	protected void setDetails(RenderRequest request,
			PreAuthenticatedAuthenticationToken authRequest) {
		AuthenticationDetailsSource authenticationDetailsSource = (AuthenticationDetailsSource) SecurityContextHolder
				.getContext().getAuthentication().getDetails();
		authRequest.setDetails(authenticationDetailsSource
				.buildDetails(request));
	}

	/** {@inheritDoc} */
	@Override
	public void destroy() {
		LOG.debug("Action filter destroy.");
	}

	/** {@inheritDoc} */
	@Override
	public void init(FilterConfig arg0) throws PortletException {
		LOG.debug("Action filter init.");
	}

	/** {@inheritDoc} */
	@Override
	public void doFilter(ResourceRequest arg0, ResourceResponse arg1,
			FilterChain arg2) throws IOException, PortletException {
		LOG.debug("PortletFilter for resource.");

	}

	/** {@inheritDoc} */
	@Override
	public void doFilter(RenderRequest request, RenderResponse response,
			FilterChain chain) throws IOException, PortletException {
		LOG.debug("PortletFilter for render.");
		if (request.getUserPrincipal() == null) {
			// If no UserPrincipal from Portal stop the chain here.
			Collection<GrantedAuthority> authList = new ArrayList<GrantedAuthority>();
			authList.add(new SimpleGrantedAuthority("ROLE_ANONYMOUS"));
			Authentication authResult = new UsernamePasswordAuthenticationToken(
					"anonymous", "", authList);
			SecurityContextHolder.getContext().setAuthentication(authResult);
			// PortletSession session = request.getPortletSession();
			// session.setAttribute(SECURITY_TOKEN, authResult);
			chain.doFilter(request, response);
			return;
		}
		Authentication auth = (Authentication) request.getPortletSession()
				.getAttribute(SECURITY_TOKEN);
		if (auth == null) {
			PreAuthenticatedAuthenticationToken authToken = new PreAuthenticatedAuthenticationToken(
					request.getUserPrincipal(), request.getRemoteUser());

			// setDetails(request, authToken);
			auth = authenticationManager.authenticate(authToken);
		}

		if (auth.isAuthenticated()) {
			successfulAuthentication(request, response, auth);
			chain.doFilter(request, response);
			return;
		}
	}

	/** {@inheritDoc} */
	@Override
	public void doFilter(EventRequest arg0, EventResponse arg1, FilterChain arg2)
			throws IOException, PortletException {
		LOG.debug("PortletFilter for event.");

	}

}
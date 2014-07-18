<%--
/**
 * Copyright (c) 2000-2012 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */
--%>
<%@page import="com.liferay.portal.theme.ThemeDisplay"%>


<portlet:defineObjects />
<%
ThemeDisplay themeDisplay = (ThemeDisplay)request.getAttribute (com.liferay.portal.kernel.util.WebKeys.THEME_DISPLAY);

String redirect_value_bets = themeDisplay.getPortalURL() + "/value-bets#page=1;"; 
String redirect_apuestas_seguras = themeDisplay.getPortalURL() + "/apuestas-seguras#page=1;";

%>

<div class="valuebar"></div>
<a href="<%=redirect_apuestas_seguras %>"><button type="button" class="b1">
		<p>
			<strong>Sure Bets</strong>
		</p>
	</button></a>

</br>

<a href="<%=redirect_value_bets %>"><button type="button" class="b2">
		<p>
			<strong>Value Bets</strong>
		</p>
	</button> </a>
	
</br>
<div class="valuebar"></div>
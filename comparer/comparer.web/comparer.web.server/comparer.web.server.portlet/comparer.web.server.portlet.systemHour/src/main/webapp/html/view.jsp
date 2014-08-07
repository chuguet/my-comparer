<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*"%>
<%@ page import="java.text.SimpleDateFormat"%>
<%@ page import="com.liferay.portal.util.PortalUtil"%>
<%@ page import="com.liferay.portal.kernel.util.PropsUtil"%>
<%@ page import="com.liferay.portal.kernel.util.PropsKeys"%>



<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
	//Recupero el timezone por defecto
	TimeZone usertimeZone = TimeZone.getDefault();

	//Si existe usuario recupero su zona horaria y su id, sino la recupera de la cookie y sino sera el timezone por defecto.
	String userId = "";
	if (PortalUtil.getUser(request) != null
			&& PortalUtil.getUser(request).getTimeZoneId() != null) {
		usertimeZone = TimeZone.getTimeZone(PortalUtil.getUser(request)
				.getTimeZoneId());
		userId = String
				.valueOf(PortalUtil.getUser(request).getUserId());
	} else {
		Cookie cookies[] = request.getCookies();
		Cookie cookieTimeZone = null;

		if (cookies != null) {
			for (int i = 0; i < cookies.length; i++) {
				Cookie c = cookies[i];
				if (c.getName().equals("USER_TIMEZONE")) {
					cookieTimeZone = c;
					break;
				}
			}
		}
		
		if (cookieTimeZone != null) {
			usertimeZone = TimeZone.getTimeZone(cookieTimeZone
					.getValue());
		}
	}

	//Recupero todas las zonas horarias para ponerlas en el combo
	List<TimeZone> listaTimeZone = new ArrayList<TimeZone>();
	String[] timeZonesLiferay = PropsUtil
			.getArray(PropsKeys.TIME_ZONES);
	for (int i = 0; i < timeZonesLiferay.length; i++) {
		listaTimeZone.add(TimeZone.getTimeZone(timeZonesLiferay[i]));
	}

	//Calculo la fecha con la zona horaria calculada
	String fechaActual = "";
	Date fecha = new Date();
	SimpleDateFormat formatter = new SimpleDateFormat(
			"dd/MM/yyyy HH:mm");

	if (usertimeZone != null) {
		formatter.setTimeZone(usertimeZone);
	} else {
		formatter.setTimeZone(TimeZone.getDefault());
	}
	fechaActual = formatter.format(fecha);
%>
<html>
<liferay-theme:defineObjects />
<portlet:defineObjects />
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/main.css" type="text/css"> 
<script src="<%=request.getContextPath()%>/js/generic-min.js" type="text/javascript"></script>
<script src="<%=request.getContextPath()%>/js/systemHour-min.js" type="text/javascript"></script>
<script src="<%=request.getContextPath()%>/js/JsSimpleDateFormat-min.js" type="text/javascript"></script>
<script src="<%=request.getContextPath()%>/js/cookie-min.js" type="text/javascript"></script>
<script type="text/javascript">
$(document).ready(load);

window.setInterval(timer, 60000);
</script>
</head>
<body>
	<input hidden type="text" id="userId" value="<%=userId%>" />
	<input hidden type="text" id="userTimeZone"
		value="<%=usertimeZone.getID()%>" />
	<div id="portletSystemHour">
		<div class="contentPortletSystemHour" id="focusFecha"></div>
		<input class="contentPortletSystemHour" type="text" readonly
			id="fecha" value="<%=fechaActual%>" /> <select
			class="contentPortletSystemHour" id="timezones"
			onChange="onChangeGMT()" onload="load()">
			<%
				for (int i = 0; i < listaTimeZone.size(); i++) {
					TimeZone zona = listaTimeZone.get(i);
			%>
			<option value="<%=zona.getID()%>"
				<%if (zona.getID().equals(usertimeZone.getID())) {%> selected <%}%>><%=zona.getID()%></option>
			<%
				}
			%>
		</select>
	</div>
</body>
</html>
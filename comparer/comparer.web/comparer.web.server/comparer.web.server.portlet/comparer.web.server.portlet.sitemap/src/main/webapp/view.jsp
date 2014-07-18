<%@page contentType="text/html"%><%@page pageEncoding="UTF-8"%><%@ page
	import="javax.portlet.*"%><%@ taglib
	uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>

<portlet:defineObjects />

<h1>Generador de sitemap</h1>
<br>
<form action="<portlet:actionURL/>" method="post">
	<input type="submit" name="b1" value="Generar Sitemap">
	
</form>
<br><br>
<div style="color: red"><h3>${error}</h3> </div></br> 
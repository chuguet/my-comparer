<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<portlet:defineObjects />
<%
        String gwtSource=(String) request.getAttribute("urlGWT");
        String urlSmartGWT= request.getContextPath()+ "/ToolbarModule/sc/";
%>
<script type="text/javascript">
	var isomorphicDir='<%=urlSmartGWT %>' ;
</script>


<script type="text/javascript" language="javascript"
	src="<%=request.getContextPath()%>/ToolbarModule/ToolbarModule.nocache.js"></script>
<table align="center" width="100%">
	<tr>
		<td id="toolbarModuleContainer"></td>
	</tr>
</table>


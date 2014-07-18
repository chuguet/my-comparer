

<%
        String gwtSource=(String) request.getAttribute("urlGWT");
        String urlSmartGWT= request.getContextPath()+ "/ToolbarModuleDev/sc/";
%>
<script type="text/javascript">
var isomorphicDir='<%=urlSmartGWT %>' ;
</script>
<script type="text/javascript" language="javascript"
	src="<%=request.getContextPath()%>/ToolbarModuleDev/ToolbarModuleDev.nocache.js"></script>
<table align="center" width="100%">
	<tr>
		<td id="toolbarModuleContainer"></td>
	</tr>
</table>

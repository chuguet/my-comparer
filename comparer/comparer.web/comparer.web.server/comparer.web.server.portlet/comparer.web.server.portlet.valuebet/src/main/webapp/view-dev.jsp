

<%
        String gwtSource=(String) request.getAttribute("urlGWT");
        String urlSmartGWT= request.getContextPath()+ "/ValueBetModuleDev/sc/";
%>
<script type="text/javascript">
var isomorphicDir='<%=urlSmartGWT %>' ;
</script>
<script type="text/javascript" language="javascript"
	src="<%=request.getContextPath()%>/ValueBetModuleDev/ValueBetModuleDev.nocache.js"></script>
<table align="center" width="100%">
	<tr>
		<td id="valueBetModuleContainer"></td>
	</tr>
</table>
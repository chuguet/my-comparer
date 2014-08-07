<portlet:defineObjects />

<%
        String gwtSource=(String) request.getAttribute("urlGWT");
        String urlSmartGWT= request.getContextPath()+ "/NextEventsModule/sc/";
%>
<script type="text/javascript">
var isomorphicDir='<%=urlSmartGWT %>' ;
</script>
<script type="text/javascript" language="javascript"
	src="<%=request.getContextPath()%>/NextEventsModule/NextEventsModule.nocache.js"></script>
<table align="center" width="100%">
	<tr>
		<td id="nextEventsModuleContainer"></td>
	</tr>
</table>
<portlet:defineObjects />

<%

        String gwtSource=(String) request.getAttribute("urlGWT");
        String urlSmartGWT= request.getContextPath()+ "/ResultsModule/sc/";
%>
<script type="text/javascript">
var isomorphicDir='<%=urlSmartGWT %>' ;
</script>
<script type="text/javascript" language="javascript"
	src="<%=request.getContextPath()%>/ResultsModule/ResultsModule.nocache.js"></script>
<table align="center" width="100%">
	<tr>
		<td id="resultsModuleContainer"></td>
	</tr>
</table>

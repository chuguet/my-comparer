<portlet:defineObjects />

<%
        String gwtSource=(String) request.getAttribute("urlGWT");
        String urlSmartGWT= request.getContextPath()+ "/ImgSliderModule/sc/";
%>
<script type="text/javascript">
var isomorphicDir='<%=urlSmartGWT %>' ;
</script>
<script type="text/javascript" language="javascript"
	src="<%=request.getContextPath()%>/ImgSliderModule/ImgSliderModule.nocache.js"></script>
<table align="center" width="100%">
	<tr>
		<td id="ImgSliderModuleContainer"></td>
	</tr>
</table>
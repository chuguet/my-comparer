

<%
        String gwtSource=(String) request.getAttribute("urlGWT");
        String urlSmartGWT= request.getContextPath()+ "/ImgSliderModuleDev/sc/";
%>
<script type="text/javascript">
var isomorphicDir='<%=urlSmartGWT %>' ;
</script>
<script type="text/javascript" language="javascript"
	src="<%=request.getContextPath()%>/ImgSliderModuleDev/ImgSliderModuleDev.nocache.js"></script>
<table align="center" width="100%">
	<tr>
		<td id="ImgSliderModuleContainer"></td>
	</tr>
</table>

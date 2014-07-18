<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<portlet:defineObjects />

<%
	String gwtSource = (String) request.getAttribute("urlGWT");
	String urlSmartGWT = request.getContextPath() + "/SecureBetModule/sc/";
%>

<script src="<%=request.getContextPath()%>/js/calculadora.js" type="text/javascript"></script>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/style.css" type="text/css"> 
<script type="text/javascript">
var isomorphicDir='<%=urlSmartGWT%>' ;
</script>


<span style="font-size: 15px;"><p>
		Las <b>Surebets</b> te dan la oportunidad de cubrir todos los
		resultados posibles de un evento, consiguiendo beneficio siempre,
		siendo cualquiera el resultado final del evento.
	</p> <a href="/apuestas-seguras-info"><p
			style="margin: 10px;">LEER MÁS AQUÍ</p></a></span>
<sec:authorize
	ifNotGranted="Nivel_1_(caro),Nivel_2_(intermedio),Nivel_3_(barato),Nivel_0">


	<div class="pagina">
		<div class="header">
			<div class="imagen">
				<a class="links_surebet"
					href="/apuestas-seguras?p_p_id=58&p_p_state=maximized&p_p_mode=view&_58_struts_action=%2Flogin%2Fcreate_account"><img
					src="<%=request.getContextPath()%>/images/apuesta_segura.png"
					title="" alt="" /></a>
			</div>
			<div class="texto">
				<p class="red">
					<a
						href="/apuestas-seguras?p_p_id=58&p_p_state=maximized&p_p_mode=view&_58_struts_action=%2Flogin%2Fcreate_account">Prueba
						<strong>GRATIS</strong> nuestos servicios <br /> <strong>APUESTAS
							SEGURAS</strong>
					</a>
				</p>
				<p class="black">
					<a
						href="/apuestas-seguras?p_p_id=58&p_p_state=maximized&p_p_mode=view&_58_struts_action=%2Flogin%2Fcreate_account">Nuestros
						servicios de APUESTAS SEGURAS le permite asegurar una ganancia <strong>INDEPENDIENTEMENTE</strong>
						del resultado.
					</a>
				</p>
				<p class="blue">
					<a
						href="/apuestas-seguras?p_p_id=58&p_p_state=maximized&p_p_mode=view&_58_struts_action=%2Flogin%2Fcreate_account">Durante
						90 d&iacute;as acceso <strong>ILIMITADO</strong>
					</a>
				</p>
			</div>
			<hr style="clear: both;">
		</div>
		<div class="content">
			<div class="imagen2">
				<a class="links_surebet"
					href="/apuestas-seguras?p_p_id=58&p_p_state=maximized&p_p_mode=view&_58_struts_action=%2Flogin%2Fcreate_account"><img
					id="flechasinferiores" width="569" height="161"
					src="<%=request.getContextPath()%>/images/flechas_inferiores.png"
					title="" alt="" /></a>
			</div>
			<div id="boton_imagen">
				<div class="image_surebet">
					<a class="links_surebet"
						href="/apuestas-seguras?p_p_id=58&p_p_state=maximized&p_p_mode=view&_58_struts_action=%2Flogin%2Fcreate_account"><img
						id="botonregistro" height="370"
						src="<%=request.getContextPath()%>/images/boton_registro.png"
						title="" alt="" /></a>
				</div>
				<div class="">
					<a class="links_surebet"
						href="/apuestas-seguras?p_p_id=58&p_p_state=maximized&p_p_mode=view&_58_struts_action=%2Flogin%2Fcreate_account"><img
						id="flechassuperiores" width="175" height="90"
						src="<%=request.getContextPath()%>/images/flechas_superiores.png"
						title="" alt="" /></a>
				</div>
			</div>
		</div>
		<div class="footer"></div>
	</div>







</sec:authorize>

<sec:authorize
	ifAnyGranted="Nivel_1_(caro),Nivel_2_(intermedio),Nivel_3_(barato),Nivel_0">


	<div id="calculator" title="Calculadora apuesta segura">

		<div id="header" class="field_dialog">
			<div id="logo" class="content_header">
				<img id="logo_ico" width="264px" height="80px"/>
			</div>
			<div id="info" class="content_header">
				<p><span id="deporte_label" class="negrita"></span><span id="deporte"/></span></p>
				<p><span id="pais_label" class="negrita"></span><span id="pais"/></span></p>
				<p><span id="competicion_label" class="negrita"></span><span id="competicion"/></span></p>
			</div>
		</div>

		<div id="info_match" class="field_dialog">
			<div id="match" class="column_info_match">
				<p class="name_match" id="part1" />
				<p class="name_match">vs</p>
				<p class="name_match" id="part2" />
			</div>
			<div id="date" class="column_info_match">
				<div id="calendar" class="column_date">
					<img id="calendar_ico" height="40px" width="40px" />
				</div>
				<div class="column_date">
					<div class="calendar_text">
						<p id="date_value" />
					</div>
					<div class="calendar_text">
						<p class="negrita" id="time_value" />
					</div>
				</div>
			</div>
			<div id="benefit" class="column_info_match">
				<p class="negrita" id="benefit_value"/>
			</div>
		</div>

		<div id="type_market" class="field_dialog">
			<div class="column_type_market">
				<p id="type_market_name" />
			</div>
			<div class="column_type_market">
				<p>-
				<p />
			</div>
			<div class="column_type_market">
				<p id="type_market_event_name" />
			</div>
		</div>

		<div class="field_dialog">
			<div id="title_table" class="title_table">
				<div class="column_title_table">
					<p id="resultados" class="column_title_table_single"></p>
				</div>
				<div class="column_title_table">
					<p id="bookmakers"></p>
				</div>
				<div class="column_title_table">
					<p id="quota" class="column_title_table_single"></p>
				</div>
				<div class="column_title_table">
					<p id="stakes" class="column_title_table_single"></p>
				</div>
				<div class="column_title_table">
					<p id="ganacias" class="column_title_table_single"></p>
				</div>
				<div class="column_title_table">
					<p id="porcentajes_beneficio"></p>
				</div>
			</div>

			<div id="row_table_1" class="row_table">
				<div class="column_row_table">
					<div class="column_row_table_participant">
						<p id="resultadosF1"></p>
					</div>
				</div>
				
				<div class="column_row_table">
					<div class="fieldBookmaker"><img width="75px" height="18px" id="bookmakerLocal" class="urlHand"/><input id="urlLocal" type="hidden"/><input type="hidden" id="actionAnalyticsLocal"/><input type="hidden" id="categoryAnalyticsLocal"/></div>
				</div>
				<div class="column_row_table">
					<input id="quotaLocal" type="text" readonly="true"/>
				</div>
				<div class="column_row_table">
					<div class="column_row_table_numbers">
						<p id="stakesF1"></p>
					</div>
				</div>
				<div class="column_row_table">
					<div class="column_row_table_numbers">
						<p id="ganaciasF1"></p>
					</div>
				</div>
				<div class="column_row_table">
					<div class="column_row_table_numbers">
						<p id="porcentajes_beneficioF1"></p>
					</div>
				</div>
			</div>
			<div id="row_table_2" class="row_table">
				<div class="column_row_table">
					<div class="column_row_table_participant">
						<p id="resultadosF2"></p>
					</div>
				</div>
				
				<div class="column_row_table">
					<div class="fieldBookmaker"><img width="75px" height="18px" id="bookmakerEmpate" class="urlHand"/><input id="urlEmpate" type="hidden"/><input type="hidden" id="actionAnalyticsEmpate"/><input type="hidden" id="categoryAnalyticsEmpate"/></div>
				</div>
				<div class="column_row_table">
					<input id="quotaEmpate" type="text" readonly="true"/>
				</div>
				<div class="column_row_table">
					<div class="column_row_table_numbers">
						<p id="stakesF2"></p>
					</div>
				</div>
				<div class="column_row_table">
					<div class="column_row_table_numbers">
						<p id="ganaciasF2"></p>
					</div>
				</div>
				<div class="column_row_table">
					<div class="column_row_table_numbers">
						<p id="porcentajes_beneficioF2"></p>
					</div>
				</div>
			</div>
			<div id="row_table_3" class="row_table">
				<div class="column_row_table">
					<div class="column_row_table_participant">
						<p id="resultadosF3"></p>
					</div>
				</div>
				
				<div class="column_row_table">
	 					<div class="fieldBookmaker"><img width="75px" height="18px" id="bookmakerVisitante" class="urlHand"/><input id="urlVisitante" type="hidden"/><input type="hidden" id="actionAnalyticsVisitante"/><input type="hidden" id="categoryAnalyticsVisitante"/></div>
				</div>
				<div class="column_row_table">
					<input id="quotaVisitante" type="text" readonly="true"/>
				</div>
				<div class="column_row_table">
					<div class="column_row_table_numbers">
						<p id="stakesF3"></p>
					</div>
				</div>
				<div class="column_row_table">
					<div class="column_row_table_numbers">
						<p id="ganaciasF3"></p>
					</div>
				</div>
				<div class="column_row_table">
					<div class="column_row_table_numbers">
						<p id="porcentajes_beneficioF3"></p>
					</div>
				</div>
			</div>
		</div>

		<div id="form_submit" class="field_dialog">
			<div class="column_form_submit">
				<div class="fields_submit">
					<p>Cantidad total que desea apostar</p>
				</div>
			</div>
			<div class="column_form_submit">
				<div class="fields_submit">
					<input id="cantidad" type="text" />
				</div>
			</div>
			<div class="column_form_submit">
				<div class="fields_submit">
					<input id="button_submit" type="button" value="CALCULAR" />
				</div>
			</div>
		</div>

	</div>


	<script type="text/javascript" language="javascript"
		src="<%=request.getContextPath()%>/SecureBetModule/SecureBetModule.nocache.js"></script>
	<table align="center" width="100%">
		<tr>
			<td id="secureBetModuleContainer"></td>
		</tr>
	</table>
</sec:authorize>
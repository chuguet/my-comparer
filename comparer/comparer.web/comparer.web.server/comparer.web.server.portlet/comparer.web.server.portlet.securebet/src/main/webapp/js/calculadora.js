var searchPattern = "9f0AwB7J8CpDud5E6FQGlxnHMbcI3K4LeUNzO1ms2PtRvSVkWXqirTYaghZjoy";
var encryptPattern = "wxBU7nIGj9Flm8f0AH1bcK3hdi4WJ5ZLCpDeMvTQuVkXqraYE6gosyNzOP2RSt";

function load() {
	$("#calculator").dialog({
		autoOpen : false,
		resizable : false,
		modal : true,
		width : 'auto'
	});

	$("#button_submit").button().click(
			function() {
				var cuotaLocal;
				var cuotaEmpate;
				var cuotaVisitante;
				if ($("#row_table_3").is(":visible")) {
					cuotaLocal = $("#quotaLocal").val();
					cuotaEmpate = $("#quotaEmpate").val();
					cuotaVisitante = $("#quotaVisitante").val();
				} else {
					cuotaLocal = $("#quotaLocal").val();
					cuotaEmpate = 0;
					cuotaVisitante = $("#quotaEmpate").val();
				}
				var cantidad = $("#cantidad").val();
				calculoApuestaSegura(cuotaLocal, cuotaEmpate, cuotaVisitante,
						cantidad);
			});
}

function openCalculator(calculadora) {
	$("#calculator").dialog("open");
	fillData(calculadora);
	$("#bookmakerLocal").click(function (){
		openWindow($("#urlLocal").val(), getIdLocalBet(), $("#actionAnalyticsLocal").val(), $("#categoryAnalyticsLocal").val());
	});
	$("#bookmakerEmpate").click(function (){
		openWindow($("#urlEmpate").val(), getIdEmpateBet(), $("#actionAnalyticsEmpate").val(), $("#categoryAnalyticsEmpate").val());
	});
	$("#bookmakerVisitante").click(function (){
		openWindow($("#urlVisitante").val(), getIdVisitanteBet(), $("#actionAnalyticsVisitante").val(), $("#categoryAnalyticsVisitante").val());
	});
}

function getIdLocalBet(){
	return $("#resultadosF1").text() + $("#bookmakerLocal").attr('src') + $("#quotaLocal").val();
}

function getIdEmpateBet(){
	return $("#resultadosF2").text() + $("#bookmakerEmpate").attr('src') + $("#quotaEmpate").val();
}

function getIdVisitanteBet(){
	return $("#resultadosF3").text() + $("#bookmakerVisitante").attr('src') + $("#quotaVisitante").val();
}

function openWindow(encryptUrl, instancePage, actionAnalytics, categoryAnalytics){
	var url = desencryptURL(encryptUrl);
	window.open(url, instancePage);
	_gaq.push(['_trackEvent', categoryAnalytics, actionAnalytics]);
}

function desencryptURL (cadena){
	var original = "";
	for (var pos = 0; pos < cadena.length; pos++) {
		if (pos == 0) {
			original = desencryptChar(cadena.substring(pos, pos + 1),
					cadena.length, pos);
		} else {
			original += desencryptChar(cadena.substring(pos, pos + 1),
					cadena.length, pos);
		}
	}
	return original;
}

function desencryptChar(caracter, variable, indice){
	var ind = 0;
	if (encryptPattern.indexOf(caracter) != -1) {
		if ((encryptPattern.indexOf(caracter) - variable - indice) > 0) {
			ind = (encryptPattern.indexOf(caracter) - variable - indice)
					% encryptPattern.length;
		} else {
			ind = (searchPattern.length)
					+ ((encryptPattern.indexOf(caracter) - variable - indice) % encryptPattern
							.length);
		}
		ind = ind % encryptPattern.length;
		return searchPattern.substring(ind, ind + 1);
	} else {
		return caracter;
	}
}

function fillData(calculadora) {
	$("#logo_ico").attr("src", calculadora.w);
	
	$("#deporte_label").text("Deporte: ");
	$("#pais_label").text("Pa\u00EDs: ");
	$("#competicion_label").text("Competici\u00F3n: ");
	$("#deporte").text(calculadora.j);
	$("#pais").text(calculadora.s);
	$("#competicion").text(calculadora.e);
	
	var nameMatch = calculadora.r;
	var part1 = nameMatch.split(" vs ")[0];
	var part2 = nameMatch.split(" vs ")[1];
	$("#part1").text(part1);
	$("#part2").text(part2);

	$("#calendar_ico").attr("src", calculadora.c);
	$("#date_value").text(calculadora.n);
	$("#time_value").text(calculadora.o);
	$("#benefit_value").text(calculadora.b);

	$("#type_market_name").text(calculadora.v);
	$("#type_market_event_name").text(calculadora.k);

	$("#resultados").text("Resultados");
	$("#bookmakers").text("Casas de apuestas");
	$("#quota").text("Cuota");
	$("#stakes").text("Stakes");
	$("#ganacias").text("Ganancias");
	$("#porcentajes_beneficio").text("Porcentaje beneficio");

	if (calculadora.d.c == 3) {
		$("#resultadosF1").text(calculadora.t);
		$("#quotaLocal").val(calculadora.g)
		$("#bookmakerLocal").attr("src", calculadora.d.b[0].d);
		$("#urlLocal").val(calculadora.d.b[0].f);
		$("#actionAnalyticsLocal").val(calculadora.d.b[0].b);
		$("#categoryAnalyticsLocal").val(calculadora.d.b[0].c);

		$("#resultadosF2").text("Empate");
		$("#quotaEmpate").val(calculadora.f);
		$("#bookmakerEmpate").attr("src", calculadora.d.b[1].d);
		$("#urlEmpate").val(calculadora.d.b[1].f);
		$("#actionAnalyticsEmpate").val(calculadora.d.b[1].b);
		$("#categoryAnalyticsEmpate").val(calculadora.d.b[1].c);

		$("#row_table_3").show();
		$("#resultadosF3").text(calculadora.u);
		$("#quotaVisitante").val(calculadora.i);
		$("#bookmakerVisitante").attr("src", calculadora.d.b[2].d);
		$("#urlVisitante").val(calculadora.d.b[2].f);
		$("#actionAnalyticsVisitante").val(calculadora.d.b[2].b);
		$("#categoryAnalyticsVisitante").val(calculadora.d.b[2].c);
	} else {
		$("#resultadosF1").text(calculadora.t);
		$("#quotaLocal").val(calculadora.g)
		$("#bookmakerLocal").attr("src", calculadora.d.b[0].d);
		$("#urlLocal").val(calculadora.d.b[0].f);
		$("#actionAnalyticsLocal").val(calculadora.d.b[0].b);
		$("#categoryAnalyticsLocal").val(calculadora.d.b[0].c);

		$("#resultadosF2").text(calculadora.u);
		$("#quotaEmpate").val(calculadora.i);
		$("#bookmakerEmpate").attr("src", calculadora.d.b[1].d);
		$("#urlEmpate").val(calculadora.d.b[1].f);
		$("#actionAnalyticsVisitante").val(calculadora.d.b[1].b);
		$("#categoryAnalyticsVisitante").val(calculadora.d.b[1].c);

		$("#row_table_3").hide();
	}
	$("#stakesF1").text("");
	$("#stakesF2").text("");
	$("#stakesF3").text("");
	$("#ganaciasF1").text("");
	$("#ganaciasF2").text("");
	$("#ganaciasF3").text("");
	$("#porcentajes_beneficioF1").text("");
	$("#porcentajes_beneficioF2").text("");
	$("#porcentajes_beneficioF3").text("");
}

function calculoApuestaSegura(cuotaLocal, cuotaEmpate, cuotaVisitante, cantidad) {
	var decimales = 2;
	var probabilidadLocal;
	var probabilidadEmpate;
	var probabilidadVisitante;

	probabilidadLocal = 1 / cuotaLocal;
	probabilidadVisitante = 1 / cuotaVisitante;
	if (cuotaEmpate == 0) {
		probabilidadEmpate = 0;
	} else {
		probabilidadEmpate = 1 / cuotaEmpate;
	}

	var probabilidades = probabilidadLocal + probabilidadEmpate
			+ probabilidadVisitante;

	var probabilidadStakeLocal;
	var probabilidadStakeEmpate;
	var probabilidadStakeVisitante;

	probabilidadStakeLocal = probabilidadLocal / probabilidades;
	probabilidadStakeVisitante = probabilidadVisitante / probabilidades;
	if (probabilidadEmpate == 0) {
		probabilidadStakeEmpate = 0;
	} else {
		probabilidadStakeEmpate = probabilidadEmpate / probabilidades;
	}

	var stakeLocal = probabilidadStakeLocal * cantidad;
	var stakeEmpate = probabilidadStakeEmpate * cantidad;
	var stakeVisitante = probabilidadStakeVisitante * cantidad;

	$("#stakesF1").text(redondear(stakeLocal, decimales));
	if (stakeEmpate != 0) {
		$("#stakesF2").text(redondear(stakeEmpate, decimales));
		$("#stakesF3").text(redondear(stakeVisitante, decimales));
	} else {
		$("#stakesF2").text(redondear(stakeVisitante, decimales));
	}

	var gananciaLocal = stakeLocal * cuotaLocal;
	var gananciaEmpate = stakeEmpate * cuotaEmpate;
	var gananciaVisitante = stakeVisitante * cuotaVisitante;

	$("#ganaciasF1").text(redondear(gananciaLocal, decimales));
	if (gananciaEmpate != 0) {
		$("#ganaciasF2").text(redondear(gananciaEmpate, decimales));
		$("#ganaciasF3").text(redondear(gananciaVisitante, decimales));
	} else {
		$("#ganaciasF2").text(redondear(gananciaVisitante, decimales));
	}

	var beneficioLocal;
	var beneficioEmpate;
	var beneficioVisitante;

	beneficioLocal = gananciaLocal - cantidad;
	beneficioVisitante = gananciaVisitante - cantidad;
	if (gananciaEmpate == 0) {
		beneficioEmpate = 0;
	} else {
		beneficioEmpate = gananciaEmpate - cantidad;
	}

	var porcentajeLocal;
	var porcentajeEmpate;
	var porcentajeVisitante;

	porcentajeLocal = beneficioLocal / cantidad * 100;
	porcentajeVisitante = beneficioVisitante / cantidad * 100;
	if (beneficioEmpate == 0) {
		porcentajeEmpate = 0;
	} else {
		porcentajeEmpate = beneficioEmpate / cantidad * 100;
	}

	$("#porcentajes_beneficioF1").text(
			redondear(porcentajeLocal, decimales) + "%");
	if (porcentajeEmpate != 0) {
		$("#porcentajes_beneficioF2").text(
				redondear(porcentajeEmpate, decimales) + "%");
		$("#porcentajes_beneficioF3").text(
				redondear(porcentajeVisitante, decimales) + "%");
	} else {
		$("#porcentajes_beneficioF2").text(
				redondear(porcentajeVisitante, decimales) + "%");
	}
}

function redondear(numero, cifras) {
	var decimales = Math.pow(10, cifras);
	return Math.round(numero * decimales) / decimales;
}

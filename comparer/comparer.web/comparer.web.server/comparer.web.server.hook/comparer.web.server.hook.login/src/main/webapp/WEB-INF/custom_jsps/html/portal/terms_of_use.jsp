<%--
/**
 * Copyright (c) 2000-2012 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */
--%>

<%@ include file="/html/portal/init.jsp"%>

<%
String currentURL = PortalUtil.getCurrentURL(request);

String referer = ParamUtil.getString(request, WebKeys.REFERER, currentURL);

if (referer.equals(themeDisplay.getPathMain() + "/portal/update_terms_of_use")) {
	referer = themeDisplay.getPathMain() + "?doAsUserId=" + themeDisplay.getDoAsUserId();
}
%>

<aui:form
	action='<%= themeDisplay.getPathMain() + "/portal/update_terms_of_use" %>'
	name="fm">
	<aui:input name="doAsUserId" type="hidden"
		value="<%= themeDisplay.getDoAsUserId() %>" />
	<aui:input name="<%= WebKeys.REFERER %>" type="hidden"
		value="<%= referer %>" />

	<c:choose>
		<c:when
			test="<%= (PropsValues.TERMS_OF_USE_JOURNAL_ARTICLE_GROUP_ID > 0) && Validator.isNotNull(PropsValues.TERMS_OF_USE_JOURNAL_ARTICLE_ID) %>">
			<liferay-ui:journal-article
				articleId="<%= PropsValues.TERMS_OF_USE_JOURNAL_ARTICLE_ID %>"
				groupId="<%= PropsValues.TERMS_OF_USE_JOURNAL_ARTICLE_GROUP_ID %>" />
		</c:when>
		<c:otherwise>
			<div id="condiciones">
				<h1>Condiciones y t�rminos de uso</h1>
				<hr />
				<p>
					<b>En el momento de registro o acceso a betcompara.com usted
						acepta nuestra pol�tica de privacidad y nuestros t�rminos y
						condiciones.</b>
				</p>
				<br />
				<p>Betcompara y Win Bets, LTD se reserva el derecho de hacer
					cambios y modificaciones en la web sin previo aviso.</p>
				<br />
				<p>Todo el material de este sitio web, incluyendo, sin
					limitaci�n, cualquier texto, gr�ficos, logotipos, fotograf�as,
					audio o materiales de video pertenece a Win Bets, LTD. Puede
					recuperar y mostrar el contenido de la p�gina web en una pantalla
					de ordenador, imprimir p�ginas individuales en papel (pero no
					fotocopiarlas) y almacenar dichas p�ginas en formato electr�nico
					(pero no en cualquier servidor u otro dispositivo de almacenamiento
					conectado a una red) para su uso personal, no comercial.</p>
				<p>
					<br /> Usted no puede publicar, modificar o de cualquier manera
					explotar comercialmente cualquiera de los contenidos Betcompara.
					Usted no podr� ceder, sublicenciar o transferir cualquiera de sus
					derechos bajo estos t�rminos a un tercero. Usted no puede compartir
					la informaci�n que reciben de los servicios con terceros.
				</p>
				<br />
				<p>El incumplimiento de estas condiciones o cualquier ley, regla
					o regulaci�n relevante resultar� en la terminaci�n inmediata de
					todos sus derechos. Betcompara podr� en cualquier momento revisar
					estos t�rminos al actualizar esta publicaci�n. Al usar este sitio
					Web, usted acepta quedar obligado por tales revisiones, por lo que
					deber�a visitar peri�dicamente esta p�gina para determinar los
					t�rminos vigentes a los que est� vinculado.</p>
			</div>
			<br />
			<div id="responsabilidad">
				<h1>Limitaci�n de responsabilidad</h1>
				<hr />
				<p>Betcompara es una herramienta para comparar probabilidades
					entre las diferentes casas de apuesta.</p>
				<br />
				<p>Betcompara.com no ofrece apuestas, Betcompara.com ofrece la
					posibilidad de ingresar en las diferentes casas de apuestas de
					manera directa a trav�s de los diferentes banners y espacios
					publicitarios.</p>
				<br />
				<p>La informaci�n que ofrece Betcompara tiene como fuente los
					sitios oficiales de las casas de apuesta y se actualiza, al menos,
					una vez a la hora. Sin embargo, debido a los continuos cambios en
					las probabilidades de las casas de apuesta, es posible que existan
					diferencias en las probabilidades. Para asegurarse de la
					probabilidad de cada casa de apuesta, debe visitar el sitio oficial
					de la casa de apuesta.</p>
				<br />
				<p>Betcompara.com y Win Bets, LTD no se responsabilizan de las
					diferencias que puedan existir entre la probabilidad mostrada en
					Betcompara.com y la probabilidad ofrecida por la casa de apuesta.
					Ni Win Bets, LTD ni cualquier persona asociada a Betcompara o Win
					Bets, LTD aceptar� ning�n tipo de responsabilidad, cualquiera que
					fuera la p�rdida que pudiese surgir como resultado del uso (o del
					uso err�neo) de las probabilidades de Betcompara,
					independientemente de c�mo esa p�rdida podr�a haber sido originada.</p>
				<p>
					<br /> Betcompara no garantiza ganancias y no puede considerarse
					obligado por p�rdidas ocasionadas por el uso de la informaci�n
					obtenida aqu�. Ni puede Betcompara hacerse responsable por
					resultados en l�nea err�neos o incompletos.
				</p>
			</div>
			<br />
			<div id="privacidad">
				<h1>Pol�tica de privacidad</h1>
				<hr />
				<b>1) PRIVACIDAD</b><br />
				<p>Nos comprometemos a proteger su informaci�n personal. Hemos
					creado esta Pol�tica de privacidad para informarle sobre los datos
					que recopilamos sobre usted, los motivos por los que recopilamos
					esta informaci�n y el modo en el que utilizamos la informaci�n
					recopilada. Tenga en cuenta que esta Pol�tica de privacidad
					constituir� un acuerdo entre usted y betcompara.com y Win Bets LTD.
					Peri�dicamente podemos realizar cambios en esta Pol�tica de
					privacidad y publicarlos en este mismo espacio de betcompara.com.
					Le recomendamos que consulte con regularidad esta Pol�tica de
					privacidad.</p>
				<br /> <b>2) INFORMACI�N RECOPILADA</b><br />
				<p>Consideramos la informaci�n que puede identificar a un
					individuo, incluidos, entre otros datos, su nombre y apellido,
					fecha de nacimiento, datos de la cuenta bancaria, direcci�n
					particular y otras direcciones f�sicas, direcci�n de correo
					electr�nico, n�mero de tel�fono u otros datos de contacto, como
					informaci�n personal ("informaci�n personal"). Esta informaci�n la
					conservamos en servidores situados en Malta y EEUU u,
					ocasionalmente, en otros lugares. Adem�s, nuestros servidores
					mantienen un registro de actividad exclusivo para su persona que
					recopila determinada informaci�n administrativa y de tr�fico,
					incluidos los siguientes datos: direcci�n IP de origen, hora de
					acceso, fecha de acceso, p�ginas web visitadas, idioma utilizado,
					informes de interrupci�n del software y tipo de explorador
					utilizado.</p>
				<br /> <b>3) USO DE LA INFORMACI�N</b><br />
				<p>Utilizamos la informaci�n personal que nos proporciona para
					crear nuestra Red de afiliados, para ofrecer el servicio de
					atenci�n al cliente, para realizar las comprobaciones de
					verificaci�n de identidad y seguridad necesarias, para procesar sus
					transacciones en l�nea, para cumplir determinados requisitos
					empresariales y para cualquier otro prop�sito relacionado con el
					funcionamiento de Betcompara.com. Tambi�n podemos utilizar su
					informaci�n personal para ofrecerle ofertas promocionales e
					informaci�n sobre los productos y servicios de Win Bets, LTD. Es
					posible que le solicitemos oportunamente informaci�n mediante
					encuestas o concursos. La participaci�n en estas encuestas y
					concursos es totalmente voluntaria y, por lo tanto, la decisi�n de
					revelar o no dicha informaci�n ser� enteramente suya. La
					informaci�n solicitada puede incluir datos de contacto (como el
					nombre, la direcci�n de correspondencia y el n�mero de tel�fono) e
					informaci�n demogr�fica (como el c�digo postal o la edad). Si
					decide participar en una encuesta o concurso y gana, al aceptar el
					premio del concurso o cualesquiera otras ganancias que ofrezcamos,
					usted consiente que utilicemos su nombre y su imagen para fines
					publicitarios y promocionales sin compensaciones adicionales, salvo
					en los casos en los que est� prohibido por la ley. Salvo que haya
					optado por no recibir informaci�n promocional, tambi�n podremos
					utilizar su informaci�n personal (incluidos su n�mero de tel�fono y
					direcci�n de correo electr�nico) para facilitarle informaci�n sobre
					nuestros productos, servicios y promociones, as� como otros
					productos y servicios de otras partes cuidadosamente seleccionados
					por nosotros.</p>
				<br /> <b>4) EXCLUSI�N DE DETERMINADAS REVELACIONES</b><br />
				<p>Podremos revelar su informaci�n personal en los casos en los
					que lo exija la ley o cuando creamos de buena fe que dicha
					revelaci�n es necesaria para:</p>
				<ul>
					<li>(1) cumplir cualquier procedimiento legal interpuesto
						contra nosotros, contra cualquiera de nuestros sitios o contra la
						Red de afiliados, o en circunstancias en las que nos encontremos
						en obligaci�n legal similar;</li>
					<li>(2) proteger y defender nuestros derechos o propiedades; o</li>
					<li>(3) proteger la seguridad personal de los usuarios de la
						Red de afiliados o el p�blico.</li>
				</ul>
				<p>Si, a nuestro juicio, decidimos que ha intentado enga�arnos o
					defraudarnos, a nosotros o a cualquier otro usuario de la Red de
					afiliados, de cualquier forma, incluidas entre otras la
					manipulaci�n del juego o el fraude de pagos, o si sospechamos que
					est� recibiendo o realizando pagos fraudulentos, incluido el uso de
					tarjetas de cr�dito robadas o cualquier otra actividad fraudulenta
					(incluido cualquier contracargo u otra revocaci�n de un pago) o
					transacciones prohibidas (incluido el blanqueo de dinero), nos
					reservamos el derecho a comunicar esta informaci�n (junto con su
					identidad) a otros sitios de juego en l�nea, bancos, compa��as de
					tarjetas de cr�dito y organismos pertinentes.</p>
				<br /> <b>5) COOKIES</b><br />
				<p>Las cookies son peque�os archivos de texto que se almacenan
					en su equipo cuando visita determinadas p�ginas en l�nea que
					registran sus preferencias. Nosotros utilizamos cookies para llevar
					un seguimiento de nuestros sitios. Tambi�n utilizamos cookies para
					supervisar el tr�fico del sitio, mejorar la Red de afiliados y
					lograr que su uso sea m�s f�cil y pertinente.</p>
				<br /> <b>6) CONSENTIMIENTO PARA UTILIZAR PROVEEDORES DE
					SERVICIOS ELECTR�NICOS</b><br />
				<p>Para formar parte de la Red de afiliados, tendr� que recibir
					dinero de nosotros. Para procesar dichas transacciones financieras
					podr�amos utilizar procesadores de pago electr�nicos y/o
					instituciones financieras ("PSE") de terceros. Al aceptar esta
					Pol�tica de privacidad, usted expresa su consentimiento para que la
					informaci�n personal necesaria para procesar las transacciones se
					comparta con los PSE, incluida, cuando sea necesario, la
					transferencia de informaci�n a pa�ses extranjeros. Nosotros tomamos
					las medidas necesarias para que las disposiciones que acordamos con
					los PSE protejan su privacidad.</p>
				<br /> <b>7) CONSENTIMIENTO PARA LA REVISI�N DE SEGURIDAD</b><br />
				<p>Nos reservamos el derecho a llevar a cabo una revisi�n de
					seguridad en cualquier momento para validar su identidad, edad, los
					datos de registro facilitados por usted, as� como para comprobar el
					uso que hace de la Red de afiliados y sus transacciones financieras
					con el fin de determinar si existe una posible infracci�n de
					nuestro Acuerdo est�ndar para afiliados y de la ley aplicable. Al
					aceptar las condiciones de nuestro Acuerdo est�ndar para afiliados,
					usted nos autoriza, a nosotros, nuestro personal, agentes y
					proveedores, a utilizar su informaci�n personal y a revelarla a
					terceros con el fin de validar la informaci�n que nos proporcione
					durante el uso de la Red de afiliados, incluida, cuando sea
					necesario, la transferencia de informaci�n a pa�ses extranjeros.
					Las revisiones de seguridad pueden incluir, entre otras cosas, la
					petici�n de un informe de situaci�n financiera y/o la verificaci�n
					de la informaci�n facilitada en bases de datos de terceros. Adem�s,
					para facilitar estas revisiones de seguridad, usted acepta
					proporcionar dicha informaci�n o documentaci�n cuando se la
					solicitemos.</p>
				<br /> <b>8) SEGURIDAD</b><br />
				<p>Somos conscientes de la importancia de la seguridad de la
					informaci�n y de las t�cnicas necesarias para protegerla.
					Almacenamos toda la informaci�n personal que recibimos directamente
					de usted en una base de datos protegida con contrase�a que reside
					en nuestra red segura, protegida mediante el m�s moderno software
					cortafuegos. Tomamos las medidas necesarias para asegurarnos de que
					nuestras subsidiarias, agentes, afiliados y proveedores utilicen
					tambi�n los niveles adecuados de seguridad.</p>
				<br /> <b>9) PROTECCI�N INFANTIL</b><br />
				<p>La p�gina web no est� dirigida a personas menores de
					dieciocho (18) a�os. Cualquier persona que nos facilite su
					informaci�n a trav�s de cualquier parte significar� para nosotros
					que es mayor de edad (18 a�os o m�s). Seg�n nuestra pol�tica,
					revelaremos los intentos por parte de menores de edad de entrar en
					nuestra base de datos y que pudieran requerir que obtengamos y
					verifiquemos su informaci�n personal. Si tuvi�ramos conocimiento de
					que un menor ha intentado entrar o ha enviado informaci�n personal
					a trav�s del sitio web, no aceptaremos dicha informaci�n y
					adoptaremos las medidas pertinentes para eliminar dicha informaci�n
					de nuestros registros.</p>
				<br /> <b>10) DESCARGO DE RESPONSABILIDAD</b><br />
				<p>La Red de afiliados y el registro en nuestra base de datos
					funciona "TAL CUAL" y "SEG�N DISPONIBILIDAD", sin ning�n tipo de
					responsabilidad. No somos responsables de los acontecimientos que
					quedan fuera de nuestro control directo. Debido a la naturaleza
					compleja y en constante cambio de nuestra tecnolog�a y actividad,
					no podemos garantizar ni declarar que no se producir� ning�n error
					en la privacidad de su informaci�n personal y no seremos
					responsables de ning�n da�o indirecto, circunstancial, consecuente
					o punitivo resultante del uso o la divulgaci�n de informaci�n
					personal.</p>
				<br /> <b>11) FUSIONES Y OTRAS CIRCUNSTANCIAS QUE REQUIERAN LA
					TRANSFERENCIA DE NUESTROS ACTIVOS</b><br />
				<p>Si en alg�n momento tuvi�ramos que presentar una declaraci�n
					de quiebra o insolvencia, o si fu�semos adquiridos por otra
					empresa, nos fusion�semos con otra empresa, vendi�semos todos o
					parte de nuestros activos, o transfiri�semos todos o parte de
					nuestros activos pertinentes a otra empresa, estar�amos autorizados
					a compartir la informaci�n personal y cualquier otra informaci�n
					que nos haya facilitado a trav�s de nuestro registro, la base de
					datos y la Red de afiliados con las posibles o ulteriores empresas
					y socios de fusi�n.</p>
				<br /> <b>12) CONSENTIMIENTO DE LA POL�TICA DE PRIVACIDAD</b><br />
				<p>Al hacer clic en "Enviar" o en "Acepto" durante el proceso de
					registro o mediante el uso continuado de Betcompara.com tras la
					publicaci�n de esta Pol�tica de privacidad (como corresponda),
					usted acepta esta Pol�tica de privacidad. Se trata de nuestra
					Pol�tica de privacidad �ntegra y exclusiva, y sustituye a cualquier
					versi�n anterior. Peri�dicamente podemos realizar cambios en esta
					Pol�tica de privacidad y notific�rselos mediante su publicaci�n en
					Betcompara.com. Le recomendamos que consulte con regularidad esta
					Pol�tica de privacidad.</p>
			</div>
			<br />
		</c:otherwise>
	</c:choose>

	<c:if test="<%= !user.isAgreedToTermsOfUse() %>">
		<aui:button-row>
			<aui:button type="submit" value="i-agree" />

			<%
			String taglibOnClick = "alert('" + UnicodeLanguageUtil.get(pageContext, "you-must-agree-with-the-terms-of-use-to-continue") + "');";
			%>

			<aui:button onClick="<%= taglibOnClick %>" type="cancel"
				value="i-disagree" />
		</aui:button-row>
	</c:if>
</aui:form>
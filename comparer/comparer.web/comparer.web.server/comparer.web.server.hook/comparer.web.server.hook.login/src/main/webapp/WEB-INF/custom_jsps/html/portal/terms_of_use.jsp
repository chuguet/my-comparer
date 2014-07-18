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
				<h1>Condiciones y términos de uso</h1>
				<hr />
				<p>
					<b>En el momento de registro o acceso a betcompara.com usted
						acepta nuestra política de privacidad y nuestros términos y
						condiciones.</b>
				</p>
				<br />
				<p>Betcompara y Win Bets, LTD se reserva el derecho de hacer
					cambios y modificaciones en la web sin previo aviso.</p>
				<br />
				<p>Todo el material de este sitio web, incluyendo, sin
					limitación, cualquier texto, gráficos, logotipos, fotografías,
					audio o materiales de video pertenece a Win Bets, LTD. Puede
					recuperar y mostrar el contenido de la página web en una pantalla
					de ordenador, imprimir páginas individuales en papel (pero no
					fotocopiarlas) y almacenar dichas páginas en formato electrónico
					(pero no en cualquier servidor u otro dispositivo de almacenamiento
					conectado a una red) para su uso personal, no comercial.</p>
				<p>
					<br /> Usted no puede publicar, modificar o de cualquier manera
					explotar comercialmente cualquiera de los contenidos Betcompara.
					Usted no podrá ceder, sublicenciar o transferir cualquiera de sus
					derechos bajo estos términos a un tercero. Usted no puede compartir
					la información que reciben de los servicios con terceros.
				</p>
				<br />
				<p>El incumplimiento de estas condiciones o cualquier ley, regla
					o regulación relevante resultará en la terminación inmediata de
					todos sus derechos. Betcompara podrá en cualquier momento revisar
					estos términos al actualizar esta publicación. Al usar este sitio
					Web, usted acepta quedar obligado por tales revisiones, por lo que
					debería visitar periódicamente esta página para determinar los
					términos vigentes a los que está vinculado.</p>
			</div>
			<br />
			<div id="responsabilidad">
				<h1>Limitación de responsabilidad</h1>
				<hr />
				<p>Betcompara es una herramienta para comparar probabilidades
					entre las diferentes casas de apuesta.</p>
				<br />
				<p>Betcompara.com no ofrece apuestas, Betcompara.com ofrece la
					posibilidad de ingresar en las diferentes casas de apuestas de
					manera directa a través de los diferentes banners y espacios
					publicitarios.</p>
				<br />
				<p>La información que ofrece Betcompara tiene como fuente los
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
					Bets, LTD aceptará ningún tipo de responsabilidad, cualquiera que
					fuera la pérdida que pudiese surgir como resultado del uso (o del
					uso erróneo) de las probabilidades de Betcompara,
					independientemente de cómo esa pérdida podría haber sido originada.</p>
				<p>
					<br /> Betcompara no garantiza ganancias y no puede considerarse
					obligado por pérdidas ocasionadas por el uso de la información
					obtenida aquí. Ni puede Betcompara hacerse responsable por
					resultados en línea erróneos o incompletos.
				</p>
			</div>
			<br />
			<div id="privacidad">
				<h1>Política de privacidad</h1>
				<hr />
				<b>1) PRIVACIDAD</b><br />
				<p>Nos comprometemos a proteger su información personal. Hemos
					creado esta Política de privacidad para informarle sobre los datos
					que recopilamos sobre usted, los motivos por los que recopilamos
					esta información y el modo en el que utilizamos la información
					recopilada. Tenga en cuenta que esta Política de privacidad
					constituirá un acuerdo entre usted y betcompara.com y Win Bets LTD.
					Periódicamente podemos realizar cambios en esta Política de
					privacidad y publicarlos en este mismo espacio de betcompara.com.
					Le recomendamos que consulte con regularidad esta Política de
					privacidad.</p>
				<br /> <b>2) INFORMACIÓN RECOPILADA</b><br />
				<p>Consideramos la información que puede identificar a un
					individuo, incluidos, entre otros datos, su nombre y apellido,
					fecha de nacimiento, datos de la cuenta bancaria, dirección
					particular y otras direcciones físicas, dirección de correo
					electrónico, número de teléfono u otros datos de contacto, como
					información personal ("información personal"). Esta información la
					conservamos en servidores situados en Malta y EEUU u,
					ocasionalmente, en otros lugares. Además, nuestros servidores
					mantienen un registro de actividad exclusivo para su persona que
					recopila determinada información administrativa y de tráfico,
					incluidos los siguientes datos: dirección IP de origen, hora de
					acceso, fecha de acceso, páginas web visitadas, idioma utilizado,
					informes de interrupción del software y tipo de explorador
					utilizado.</p>
				<br /> <b>3) USO DE LA INFORMACIÓN</b><br />
				<p>Utilizamos la información personal que nos proporciona para
					crear nuestra Red de afiliados, para ofrecer el servicio de
					atención al cliente, para realizar las comprobaciones de
					verificación de identidad y seguridad necesarias, para procesar sus
					transacciones en línea, para cumplir determinados requisitos
					empresariales y para cualquier otro propósito relacionado con el
					funcionamiento de Betcompara.com. También podemos utilizar su
					información personal para ofrecerle ofertas promocionales e
					información sobre los productos y servicios de Win Bets, LTD. Es
					posible que le solicitemos oportunamente información mediante
					encuestas o concursos. La participación en estas encuestas y
					concursos es totalmente voluntaria y, por lo tanto, la decisión de
					revelar o no dicha información será enteramente suya. La
					información solicitada puede incluir datos de contacto (como el
					nombre, la dirección de correspondencia y el número de teléfono) e
					información demográfica (como el código postal o la edad). Si
					decide participar en una encuesta o concurso y gana, al aceptar el
					premio del concurso o cualesquiera otras ganancias que ofrezcamos,
					usted consiente que utilicemos su nombre y su imagen para fines
					publicitarios y promocionales sin compensaciones adicionales, salvo
					en los casos en los que esté prohibido por la ley. Salvo que haya
					optado por no recibir información promocional, también podremos
					utilizar su información personal (incluidos su número de teléfono y
					dirección de correo electrónico) para facilitarle información sobre
					nuestros productos, servicios y promociones, así como otros
					productos y servicios de otras partes cuidadosamente seleccionados
					por nosotros.</p>
				<br /> <b>4) EXCLUSIÓN DE DETERMINADAS REVELACIONES</b><br />
				<p>Podremos revelar su información personal en los casos en los
					que lo exija la ley o cuando creamos de buena fe que dicha
					revelación es necesaria para:</p>
				<ul>
					<li>(1) cumplir cualquier procedimiento legal interpuesto
						contra nosotros, contra cualquiera de nuestros sitios o contra la
						Red de afiliados, o en circunstancias en las que nos encontremos
						en obligación legal similar;</li>
					<li>(2) proteger y defender nuestros derechos o propiedades; o</li>
					<li>(3) proteger la seguridad personal de los usuarios de la
						Red de afiliados o el público.</li>
				</ul>
				<p>Si, a nuestro juicio, decidimos que ha intentado engañarnos o
					defraudarnos, a nosotros o a cualquier otro usuario de la Red de
					afiliados, de cualquier forma, incluidas entre otras la
					manipulación del juego o el fraude de pagos, o si sospechamos que
					está recibiendo o realizando pagos fraudulentos, incluido el uso de
					tarjetas de crédito robadas o cualquier otra actividad fraudulenta
					(incluido cualquier contracargo u otra revocación de un pago) o
					transacciones prohibidas (incluido el blanqueo de dinero), nos
					reservamos el derecho a comunicar esta información (junto con su
					identidad) a otros sitios de juego en línea, bancos, compañías de
					tarjetas de crédito y organismos pertinentes.</p>
				<br /> <b>5) COOKIES</b><br />
				<p>Las cookies son pequeños archivos de texto que se almacenan
					en su equipo cuando visita determinadas páginas en línea que
					registran sus preferencias. Nosotros utilizamos cookies para llevar
					un seguimiento de nuestros sitios. También utilizamos cookies para
					supervisar el tráfico del sitio, mejorar la Red de afiliados y
					lograr que su uso sea más fácil y pertinente.</p>
				<br /> <b>6) CONSENTIMIENTO PARA UTILIZAR PROVEEDORES DE
					SERVICIOS ELECTRÓNICOS</b><br />
				<p>Para formar parte de la Red de afiliados, tendrá que recibir
					dinero de nosotros. Para procesar dichas transacciones financieras
					podríamos utilizar procesadores de pago electrónicos y/o
					instituciones financieras ("PSE") de terceros. Al aceptar esta
					Política de privacidad, usted expresa su consentimiento para que la
					información personal necesaria para procesar las transacciones se
					comparta con los PSE, incluida, cuando sea necesario, la
					transferencia de información a países extranjeros. Nosotros tomamos
					las medidas necesarias para que las disposiciones que acordamos con
					los PSE protejan su privacidad.</p>
				<br /> <b>7) CONSENTIMIENTO PARA LA REVISIÓN DE SEGURIDAD</b><br />
				<p>Nos reservamos el derecho a llevar a cabo una revisión de
					seguridad en cualquier momento para validar su identidad, edad, los
					datos de registro facilitados por usted, así como para comprobar el
					uso que hace de la Red de afiliados y sus transacciones financieras
					con el fin de determinar si existe una posible infracción de
					nuestro Acuerdo estándar para afiliados y de la ley aplicable. Al
					aceptar las condiciones de nuestro Acuerdo estándar para afiliados,
					usted nos autoriza, a nosotros, nuestro personal, agentes y
					proveedores, a utilizar su información personal y a revelarla a
					terceros con el fin de validar la información que nos proporcione
					durante el uso de la Red de afiliados, incluida, cuando sea
					necesario, la transferencia de información a países extranjeros.
					Las revisiones de seguridad pueden incluir, entre otras cosas, la
					petición de un informe de situación financiera y/o la verificación
					de la información facilitada en bases de datos de terceros. Además,
					para facilitar estas revisiones de seguridad, usted acepta
					proporcionar dicha información o documentación cuando se la
					solicitemos.</p>
				<br /> <b>8) SEGURIDAD</b><br />
				<p>Somos conscientes de la importancia de la seguridad de la
					información y de las técnicas necesarias para protegerla.
					Almacenamos toda la información personal que recibimos directamente
					de usted en una base de datos protegida con contraseña que reside
					en nuestra red segura, protegida mediante el más moderno software
					cortafuegos. Tomamos las medidas necesarias para asegurarnos de que
					nuestras subsidiarias, agentes, afiliados y proveedores utilicen
					también los niveles adecuados de seguridad.</p>
				<br /> <b>9) PROTECCIÓN INFANTIL</b><br />
				<p>La página web no está dirigida a personas menores de
					dieciocho (18) años. Cualquier persona que nos facilite su
					información a través de cualquier parte significará para nosotros
					que es mayor de edad (18 años o más). Según nuestra política,
					revelaremos los intentos por parte de menores de edad de entrar en
					nuestra base de datos y que pudieran requerir que obtengamos y
					verifiquemos su información personal. Si tuviéramos conocimiento de
					que un menor ha intentado entrar o ha enviado información personal
					a través del sitio web, no aceptaremos dicha información y
					adoptaremos las medidas pertinentes para eliminar dicha información
					de nuestros registros.</p>
				<br /> <b>10) DESCARGO DE RESPONSABILIDAD</b><br />
				<p>La Red de afiliados y el registro en nuestra base de datos
					funciona "TAL CUAL" y "SEGÚN DISPONIBILIDAD", sin ningún tipo de
					responsabilidad. No somos responsables de los acontecimientos que
					quedan fuera de nuestro control directo. Debido a la naturaleza
					compleja y en constante cambio de nuestra tecnología y actividad,
					no podemos garantizar ni declarar que no se producirá ningún error
					en la privacidad de su información personal y no seremos
					responsables de ningún daño indirecto, circunstancial, consecuente
					o punitivo resultante del uso o la divulgación de información
					personal.</p>
				<br /> <b>11) FUSIONES Y OTRAS CIRCUNSTANCIAS QUE REQUIERAN LA
					TRANSFERENCIA DE NUESTROS ACTIVOS</b><br />
				<p>Si en algún momento tuviéramos que presentar una declaración
					de quiebra o insolvencia, o si fuésemos adquiridos por otra
					empresa, nos fusionásemos con otra empresa, vendiésemos todos o
					parte de nuestros activos, o transfiriésemos todos o parte de
					nuestros activos pertinentes a otra empresa, estaríamos autorizados
					a compartir la información personal y cualquier otra información
					que nos haya facilitado a través de nuestro registro, la base de
					datos y la Red de afiliados con las posibles o ulteriores empresas
					y socios de fusión.</p>
				<br /> <b>12) CONSENTIMIENTO DE LA POLÍTICA DE PRIVACIDAD</b><br />
				<p>Al hacer clic en "Enviar" o en "Acepto" durante el proceso de
					registro o mediante el uso continuado de Betcompara.com tras la
					publicación de esta Política de privacidad (como corresponda),
					usted acepta esta Política de privacidad. Se trata de nuestra
					Política de privacidad íntegra y exclusiva, y sustituye a cualquier
					versión anterior. Periódicamente podemos realizar cambios en esta
					Política de privacidad y notificárselos mediante su publicación en
					Betcompara.com. Le recomendamos que consulte con regularidad esta
					Política de privacidad.</p>
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
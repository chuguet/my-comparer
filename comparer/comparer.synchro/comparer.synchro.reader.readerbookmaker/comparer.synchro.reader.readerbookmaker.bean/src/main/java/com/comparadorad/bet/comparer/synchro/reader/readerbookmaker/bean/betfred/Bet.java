//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantación de la referencia de enlace (JAXB) XML v2.2.6 
// Visite <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: AM.02.28 a las 10:41:58 AM CET 
//


package com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.bean.betfred;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para anonymous complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;attribute name="short-name" use="required">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *             &lt;enumeration value="0-1 Goal"/>
 *             &lt;enumeration value="1st Half"/>
 *             &lt;enumeration value="2-3 Goals"/>
 *             &lt;enumeration value="2nd Half"/>
 *             &lt;enumeration value="4+ Goals"/>
 *             &lt;enumeration value="ALONSO, X"/>
 *             &lt;enumeration value="ALVES, DA"/>
 *             &lt;enumeration value="AMADRID"/>
 *             &lt;enumeration value="ATH. BILB"/>
 *             &lt;enumeration value="Alba, Jor"/>
 *             &lt;enumeration value="Alcantara"/>
 *             &lt;enumeration value="Arbeloa"/>
 *             &lt;enumeration value="Ath - Ath"/>
 *             &lt;enumeration value="Ath - Dra"/>
 *             &lt;enumeration value="Ath - Osa"/>
 *             &lt;enumeration value="Ath 1-0"/>
 *             &lt;enumeration value="Ath 10-0"/>
 *             &lt;enumeration value="Ath 2-0"/>
 *             &lt;enumeration value="Ath 2-1"/>
 *             &lt;enumeration value="Ath 3-0"/>
 *             &lt;enumeration value="Ath 3-1"/>
 *             &lt;enumeration value="Ath 3-2"/>
 *             &lt;enumeration value="Ath 4-0"/>
 *             &lt;enumeration value="Ath 4-1"/>
 *             &lt;enumeration value="Ath 4-2"/>
 *             &lt;enumeration value="Ath 4-3"/>
 *             &lt;enumeration value="Ath 5-0"/>
 *             &lt;enumeration value="Ath 5-1"/>
 *             &lt;enumeration value="Ath 5-2"/>
 *             &lt;enumeration value="Ath 6-0"/>
 *             &lt;enumeration value="Ath 6-1"/>
 *             &lt;enumeration value="Ath 7-0"/>
 *             &lt;enumeration value="Ath 7-1"/>
 *             &lt;enumeration value="Ath 8-0"/>
 *             &lt;enumeration value="Ath 9-0"/>
 *             &lt;enumeration value="Atl"/>
 *             &lt;enumeration value="Atl - Atl"/>
 *             &lt;enumeration value="Atl - Dra"/>
 *             &lt;enumeration value="Atl - Mal"/>
 *             &lt;enumeration value="Atl 1-0"/>
 *             &lt;enumeration value="Atl 10-0"/>
 *             &lt;enumeration value="Atl 2-0"/>
 *             &lt;enumeration value="Atl 2-1"/>
 *             &lt;enumeration value="Atl 3-0"/>
 *             &lt;enumeration value="Atl 3-1"/>
 *             &lt;enumeration value="Atl 3-2"/>
 *             &lt;enumeration value="Atl 4-0"/>
 *             &lt;enumeration value="Atl 4-1"/>
 *             &lt;enumeration value="Atl 4-2"/>
 *             &lt;enumeration value="Atl 4-3"/>
 *             &lt;enumeration value="Atl 5-0"/>
 *             &lt;enumeration value="Atl 5-1"/>
 *             &lt;enumeration value="Atl 5-2"/>
 *             &lt;enumeration value="Atl 6-0"/>
 *             &lt;enumeration value="Atl 6-1"/>
 *             &lt;enumeration value="Atl 7-0"/>
 *             &lt;enumeration value="Atl 7-1"/>
 *             &lt;enumeration value="Atl 8-0"/>
 *             &lt;enumeration value="Atl 9-0"/>
 *             &lt;enumeration value="Atl or Dr"/>
 *             &lt;enumeration value="BARCEL'"/>
 *             &lt;enumeration value="Bar"/>
 *             &lt;enumeration value="Bar - Bar"/>
 *             &lt;enumeration value="Bar - Dra"/>
 *             &lt;enumeration value="Bar - Rea"/>
 *             &lt;enumeration value="Bar 1-0"/>
 *             &lt;enumeration value="Bar 10-0"/>
 *             &lt;enumeration value="Bar 2-0"/>
 *             &lt;enumeration value="Bar 2-1"/>
 *             &lt;enumeration value="Bar 3-0"/>
 *             &lt;enumeration value="Bar 3-1"/>
 *             &lt;enumeration value="Bar 3-2"/>
 *             &lt;enumeration value="Bar 4-0"/>
 *             &lt;enumeration value="Bar 4-1"/>
 *             &lt;enumeration value="Bar 4-2"/>
 *             &lt;enumeration value="Bar 4-3"/>
 *             &lt;enumeration value="Bar 5-0"/>
 *             &lt;enumeration value="Bar 5-1"/>
 *             &lt;enumeration value="Bar 5-2"/>
 *             &lt;enumeration value="Bar 6-0"/>
 *             &lt;enumeration value="Bar 6-1"/>
 *             &lt;enumeration value="Bar 7-0"/>
 *             &lt;enumeration value="Bar 7-1"/>
 *             &lt;enumeration value="Bar 8-0"/>
 *             &lt;enumeration value="Bar 9-0"/>
 *             &lt;enumeration value="Bar or Dr"/>
 *             &lt;enumeration value="Busquets"/>
 *             &lt;enumeration value="CARVALHO"/>
 *             &lt;enumeration value="CELTA V"/>
 *             &lt;enumeration value="Callejon"/>
 *             &lt;enumeration value="Cel - Cel"/>
 *             &lt;enumeration value="Cel - Dra"/>
 *             &lt;enumeration value="Cel - Sev"/>
 *             &lt;enumeration value="Cel 1-0"/>
 *             &lt;enumeration value="Cel 10-0"/>
 *             &lt;enumeration value="Cel 2-0"/>
 *             &lt;enumeration value="Cel 2-1"/>
 *             &lt;enumeration value="Cel 3-0"/>
 *             &lt;enumeration value="Cel 3-1"/>
 *             &lt;enumeration value="Cel 3-2"/>
 *             &lt;enumeration value="Cel 4-0"/>
 *             &lt;enumeration value="Cel 4-1"/>
 *             &lt;enumeration value="Cel 4-2"/>
 *             &lt;enumeration value="Cel 4-3"/>
 *             &lt;enumeration value="Cel 5-0"/>
 *             &lt;enumeration value="Cel 5-1"/>
 *             &lt;enumeration value="Cel 5-2"/>
 *             &lt;enumeration value="Cel 6-0"/>
 *             &lt;enumeration value="Cel 6-1"/>
 *             &lt;enumeration value="Cel 7-0"/>
 *             &lt;enumeration value="Cel 7-1"/>
 *             &lt;enumeration value="Cel 8-0"/>
 *             &lt;enumeration value="Cel 9-0"/>
 *             &lt;enumeration value="Coentrao"/>
 *             &lt;enumeration value="Correia"/>
 *             &lt;enumeration value="D  Villa"/>
 *             &lt;enumeration value="DEPORT'"/>
 *             &lt;enumeration value="DRAW 0-0"/>
 *             &lt;enumeration value="DRAW 1-1"/>
 *             &lt;enumeration value="DRAW 2-2"/>
 *             &lt;enumeration value="DRAW 3-3"/>
 *             &lt;enumeration value="Dep - Dep"/>
 *             &lt;enumeration value="Dep - Dra"/>
 *             &lt;enumeration value="Dep - Rea"/>
 *             &lt;enumeration value="Dep 1-0"/>
 *             &lt;enumeration value="Dep 10-0"/>
 *             &lt;enumeration value="Dep 2-0"/>
 *             &lt;enumeration value="Dep 2-1"/>
 *             &lt;enumeration value="Dep 3-0"/>
 *             &lt;enumeration value="Dep 3-1"/>
 *             &lt;enumeration value="Dep 3-2"/>
 *             &lt;enumeration value="Dep 4-0"/>
 *             &lt;enumeration value="Dep 4-1"/>
 *             &lt;enumeration value="Dep 4-2"/>
 *             &lt;enumeration value="Dep 4-3"/>
 *             &lt;enumeration value="Dep 5-0"/>
 *             &lt;enumeration value="Dep 5-1"/>
 *             &lt;enumeration value="Dep 5-2"/>
 *             &lt;enumeration value="Dep 6-0"/>
 *             &lt;enumeration value="Dep 6-1"/>
 *             &lt;enumeration value="Dep 7-0"/>
 *             &lt;enumeration value="Dep 7-1"/>
 *             &lt;enumeration value="Dep 8-0"/>
 *             &lt;enumeration value="Dep 9-0"/>
 *             &lt;enumeration value="Dra - Ath"/>
 *             &lt;enumeration value="Dra - Atl"/>
 *             &lt;enumeration value="Dra - Bar"/>
 *             &lt;enumeration value="Dra - Cel"/>
 *             &lt;enumeration value="Dra - Dep"/>
 *             &lt;enumeration value="Dra - Dra"/>
 *             &lt;enumeration value="Dra - Esp"/>
 *             &lt;enumeration value="Dra - Get"/>
 *             &lt;enumeration value="Dra - Gra"/>
 *             &lt;enumeration value="Dra - Lev"/>
 *             &lt;enumeration value="Dra - Mal"/>
 *             &lt;enumeration value="Dra - Osa"/>
 *             &lt;enumeration value="Dra - Rea"/>
 *             &lt;enumeration value="Dra - Sev"/>
 *             &lt;enumeration value="Dra - Val"/>
 *             &lt;enumeration value="Draw"/>
 *             &lt;enumeration value="ESSIEN, M"/>
 *             &lt;enumeration value="EVEN"/>
 *             &lt;enumeration value="Esp - Dra"/>
 *             &lt;enumeration value="Esp - Esp"/>
 *             &lt;enumeration value="Esp - Rea"/>
 *             &lt;enumeration value="Esp 1-0"/>
 *             &lt;enumeration value="Esp 10-0"/>
 *             &lt;enumeration value="Esp 2-0"/>
 *             &lt;enumeration value="Esp 2-1"/>
 *             &lt;enumeration value="Esp 3-0"/>
 *             &lt;enumeration value="Esp 3-1"/>
 *             &lt;enumeration value="Esp 3-2"/>
 *             &lt;enumeration value="Esp 4-0"/>
 *             &lt;enumeration value="Esp 4-1"/>
 *             &lt;enumeration value="Esp 4-2"/>
 *             &lt;enumeration value="Esp 4-3"/>
 *             &lt;enumeration value="Esp 5-0"/>
 *             &lt;enumeration value="Esp 5-1"/>
 *             &lt;enumeration value="Esp 5-2"/>
 *             &lt;enumeration value="Esp 6-0"/>
 *             &lt;enumeration value="Esp 6-1"/>
 *             &lt;enumeration value="Esp 7-0"/>
 *             &lt;enumeration value="Esp 7-1"/>
 *             &lt;enumeration value="Esp 8-0"/>
 *             &lt;enumeration value="Esp 9-0"/>
 *             &lt;enumeration value="Espanyol"/>
 *             &lt;enumeration value="Even"/>
 *             &lt;enumeration value="Fabregas"/>
 *             &lt;enumeration value="GETAFE"/>
 *             &lt;enumeration value="Get - Dra"/>
 *             &lt;enumeration value="Get - Get"/>
 *             &lt;enumeration value="Get - Rea"/>
 *             &lt;enumeration value="Get 1-0"/>
 *             &lt;enumeration value="Get 10-0"/>
 *             &lt;enumeration value="Get 2-0"/>
 *             &lt;enumeration value="Get 2-1"/>
 *             &lt;enumeration value="Get 3-0"/>
 *             &lt;enumeration value="Get 3-1"/>
 *             &lt;enumeration value="Get 3-2"/>
 *             &lt;enumeration value="Get 4-0"/>
 *             &lt;enumeration value="Get 4-1"/>
 *             &lt;enumeration value="Get 4-2"/>
 *             &lt;enumeration value="Get 4-3"/>
 *             &lt;enumeration value="Get 5-0"/>
 *             &lt;enumeration value="Get 5-1"/>
 *             &lt;enumeration value="Get 5-2"/>
 *             &lt;enumeration value="Get 6-0"/>
 *             &lt;enumeration value="Get 6-1"/>
 *             &lt;enumeration value="Get 7-0"/>
 *             &lt;enumeration value="Get 7-1"/>
 *             &lt;enumeration value="Get 8-0"/>
 *             &lt;enumeration value="Get 9-0"/>
 *             &lt;enumeration value="Gra - Dra"/>
 *             &lt;enumeration value="Gra - Gra"/>
 *             &lt;enumeration value="Gra - Mal"/>
 *             &lt;enumeration value="Gra 1-0"/>
 *             &lt;enumeration value="Gra 10-0"/>
 *             &lt;enumeration value="Gra 2-0"/>
 *             &lt;enumeration value="Gra 2-1"/>
 *             &lt;enumeration value="Gra 3-0"/>
 *             &lt;enumeration value="Gra 3-1"/>
 *             &lt;enumeration value="Gra 3-2"/>
 *             &lt;enumeration value="Gra 4-0"/>
 *             &lt;enumeration value="Gra 4-1"/>
 *             &lt;enumeration value="Gra 4-2"/>
 *             &lt;enumeration value="Gra 4-3"/>
 *             &lt;enumeration value="Gra 5-0"/>
 *             &lt;enumeration value="Gra 5-1"/>
 *             &lt;enumeration value="Gra 5-2"/>
 *             &lt;enumeration value="Gra 6-0"/>
 *             &lt;enumeration value="Gra 6-1"/>
 *             &lt;enumeration value="Gra 7-0"/>
 *             &lt;enumeration value="Gra 7-1"/>
 *             &lt;enumeration value="Gra 8-0"/>
 *             &lt;enumeration value="Gra 9-0"/>
 *             &lt;enumeration value="Granada"/>
 *             &lt;enumeration value="Higuain"/>
 *             &lt;enumeration value="INIESTA"/>
 *             &lt;enumeration value="K  Benzem"/>
 *             &lt;enumeration value="KAKA"/>
 *             &lt;enumeration value="Khedira"/>
 *             &lt;enumeration value="L  Modric"/>
 *             &lt;enumeration value="LEVANTE"/>
 *             &lt;enumeration value="Lev"/>
 *             &lt;enumeration value="Lev - Dra"/>
 *             &lt;enumeration value="Lev - Lev"/>
 *             &lt;enumeration value="Lev - Val"/>
 *             &lt;enumeration value="Lev 1-0"/>
 *             &lt;enumeration value="Lev 10-0"/>
 *             &lt;enumeration value="Lev 2-0"/>
 *             &lt;enumeration value="Lev 2-1"/>
 *             &lt;enumeration value="Lev 3-0"/>
 *             &lt;enumeration value="Lev 3-1"/>
 *             &lt;enumeration value="Lev 3-2"/>
 *             &lt;enumeration value="Lev 4-0"/>
 *             &lt;enumeration value="Lev 4-1"/>
 *             &lt;enumeration value="Lev 4-2"/>
 *             &lt;enumeration value="Lev 4-3"/>
 *             &lt;enumeration value="Lev 5-0"/>
 *             &lt;enumeration value="Lev 5-1"/>
 *             &lt;enumeration value="Lev 5-2"/>
 *             &lt;enumeration value="Lev 6-0"/>
 *             &lt;enumeration value="Lev 6-1"/>
 *             &lt;enumeration value="Lev 7-0"/>
 *             &lt;enumeration value="Lev 7-1"/>
 *             &lt;enumeration value="Lev 8-0"/>
 *             &lt;enumeration value="Lev 9-0"/>
 *             &lt;enumeration value="Lev or Dr"/>
 *             &lt;enumeration value="MALAGA"/>
 *             &lt;enumeration value="MALLOR'"/>
 *             &lt;enumeration value="Mal"/>
 *             &lt;enumeration value="Mal - Atl"/>
 *             &lt;enumeration value="Mal - Dra"/>
 *             &lt;enumeration value="Mal - Gra"/>
 *             &lt;enumeration value="Mal - Mal"/>
 *             &lt;enumeration value="Mal 1-0"/>
 *             &lt;enumeration value="Mal 10-0"/>
 *             &lt;enumeration value="Mal 2-0"/>
 *             &lt;enumeration value="Mal 2-1"/>
 *             &lt;enumeration value="Mal 3-0"/>
 *             &lt;enumeration value="Mal 3-1"/>
 *             &lt;enumeration value="Mal 3-2"/>
 *             &lt;enumeration value="Mal 4-0"/>
 *             &lt;enumeration value="Mal 4-1"/>
 *             &lt;enumeration value="Mal 4-2"/>
 *             &lt;enumeration value="Mal 4-3"/>
 *             &lt;enumeration value="Mal 5-0"/>
 *             &lt;enumeration value="Mal 5-1"/>
 *             &lt;enumeration value="Mal 5-2"/>
 *             &lt;enumeration value="Mal 6-0"/>
 *             &lt;enumeration value="Mal 6-1"/>
 *             &lt;enumeration value="Mal 7-0"/>
 *             &lt;enumeration value="Mal 7-1"/>
 *             &lt;enumeration value="Mal 8-0"/>
 *             &lt;enumeration value="Mal 9-0"/>
 *             &lt;enumeration value="Mal or $A"/>
 *             &lt;enumeration value="Mal or Dr"/>
 *             &lt;enumeration value="Marcelo"/>
 *             &lt;enumeration value="Mascheran"/>
 *             &lt;enumeration value="Messi, Li"/>
 *             &lt;enumeration value="Montoya"/>
 *             &lt;enumeration value="Morata, A"/>
 *             &lt;enumeration value="No Goal"/>
 *             &lt;enumeration value="ODD"/>
 *             &lt;enumeration value="Odd"/>
 *             &lt;enumeration value="Osa - Ath"/>
 *             &lt;enumeration value="Osa - Dra"/>
 *             &lt;enumeration value="Osa - Osa"/>
 *             &lt;enumeration value="Osa 1-0"/>
 *             &lt;enumeration value="Osa 10-0"/>
 *             &lt;enumeration value="Osa 2-0"/>
 *             &lt;enumeration value="Osa 2-1"/>
 *             &lt;enumeration value="Osa 3-0"/>
 *             &lt;enumeration value="Osa 3-1"/>
 *             &lt;enumeration value="Osa 3-2"/>
 *             &lt;enumeration value="Osa 4-0"/>
 *             &lt;enumeration value="Osa 4-1"/>
 *             &lt;enumeration value="Osa 4-2"/>
 *             &lt;enumeration value="Osa 4-3"/>
 *             &lt;enumeration value="Osa 5-0"/>
 *             &lt;enumeration value="Osa 5-1"/>
 *             &lt;enumeration value="Osa 5-2"/>
 *             &lt;enumeration value="Osa 6-0"/>
 *             &lt;enumeration value="Osa 6-1"/>
 *             &lt;enumeration value="Osa 7-0"/>
 *             &lt;enumeration value="Osa 7-1"/>
 *             &lt;enumeration value="Osa 8-0"/>
 *             &lt;enumeration value="Osa 9-0"/>
 *             &lt;enumeration value="Osasuna"/>
 *             &lt;enumeration value="Over 0.5"/>
 *             &lt;enumeration value="Over 1.5"/>
 *             &lt;enumeration value="Over 2.5"/>
 *             &lt;enumeration value="Over 3.5"/>
 *             &lt;enumeration value="Over 4.5"/>
 *             &lt;enumeration value="Ozil, Mes"/>
 *             &lt;enumeration value="PUYOL, CA"/>
 *             &lt;enumeration value="Pedro"/>
 *             &lt;enumeration value="Pepe"/>
 *             &lt;enumeration value="Pique, Ge"/>
 *             &lt;enumeration value="R  Albiol"/>
 *             &lt;enumeration value="Rea"/>
 *             &lt;enumeration value="Rea - Bar"/>
 *             &lt;enumeration value="Rea - Dep"/>
 *             &lt;enumeration value="Rea - Dra"/>
 *             &lt;enumeration value="Rea - Esp"/>
 *             &lt;enumeration value="Rea - Get"/>
 *             &lt;enumeration value="Rea - Rea"/>
 *             &lt;enumeration value="Rea 1-0"/>
 *             &lt;enumeration value="Rea 10-0"/>
 *             &lt;enumeration value="Rea 2-0"/>
 *             &lt;enumeration value="Rea 2-1"/>
 *             &lt;enumeration value="Rea 3-0"/>
 *             &lt;enumeration value="Rea 3-1"/>
 *             &lt;enumeration value="Rea 3-2"/>
 *             &lt;enumeration value="Rea 4-0"/>
 *             &lt;enumeration value="Rea 4-1"/>
 *             &lt;enumeration value="Rea 4-2"/>
 *             &lt;enumeration value="Rea 4-3"/>
 *             &lt;enumeration value="Rea 5-0"/>
 *             &lt;enumeration value="Rea 5-1"/>
 *             &lt;enumeration value="Rea 5-2"/>
 *             &lt;enumeration value="Rea 6-0"/>
 *             &lt;enumeration value="Rea 6-1"/>
 *             &lt;enumeration value="Rea 7-0"/>
 *             &lt;enumeration value="Rea 7-1"/>
 *             &lt;enumeration value="Rea 8-0"/>
 *             &lt;enumeration value="Rea 9-0"/>
 *             &lt;enumeration value="Rea or $A"/>
 *             &lt;enumeration value="Rea or Dr"/>
 *             &lt;enumeration value="Real Beti"/>
 *             &lt;enumeration value="Real Madr"/>
 *             &lt;enumeration value="Real Soci"/>
 *             &lt;enumeration value="Real Vall"/>
 *             &lt;enumeration value="Real Zara"/>
 *             &lt;enumeration value="Roberto"/>
 *             &lt;enumeration value="Rodriguez"/>
 *             &lt;enumeration value="Ronaldo"/>
 *             &lt;enumeration value="SEVILLA"/>
 *             &lt;enumeration value="Sanchez"/>
 *             &lt;enumeration value="Sev - Cel"/>
 *             &lt;enumeration value="Sev - Dra"/>
 *             &lt;enumeration value="Sev - Sev"/>
 *             &lt;enumeration value="Sev 1-0"/>
 *             &lt;enumeration value="Sev 10-0"/>
 *             &lt;enumeration value="Sev 2-0"/>
 *             &lt;enumeration value="Sev 2-1"/>
 *             &lt;enumeration value="Sev 3-0"/>
 *             &lt;enumeration value="Sev 3-1"/>
 *             &lt;enumeration value="Sev 3-2"/>
 *             &lt;enumeration value="Sev 4-0"/>
 *             &lt;enumeration value="Sev 4-1"/>
 *             &lt;enumeration value="Sev 4-2"/>
 *             &lt;enumeration value="Sev 4-3"/>
 *             &lt;enumeration value="Sev 5-0"/>
 *             &lt;enumeration value="Sev 5-1"/>
 *             &lt;enumeration value="Sev 5-2"/>
 *             &lt;enumeration value="Sev 6-0"/>
 *             &lt;enumeration value="Sev 6-1"/>
 *             &lt;enumeration value="Sev 7-0"/>
 *             &lt;enumeration value="Sev 7-1"/>
 *             &lt;enumeration value="Sev 8-0"/>
 *             &lt;enumeration value="Sev 9-0"/>
 *             &lt;enumeration value="Song, Ale"/>
 *             &lt;enumeration value="Tello, Cr"/>
 *             &lt;enumeration value="Tie"/>
 *             &lt;enumeration value="Under 0.5"/>
 *             &lt;enumeration value="Under 1.5"/>
 *             &lt;enumeration value="Under 2.5"/>
 *             &lt;enumeration value="Under 3.5"/>
 *             &lt;enumeration value="Under 4.5"/>
 *             &lt;enumeration value="Val"/>
 *             &lt;enumeration value="Val - Dra"/>
 *             &lt;enumeration value="Val - Lev"/>
 *             &lt;enumeration value="Val - Val"/>
 *             &lt;enumeration value="Val 1-0"/>
 *             &lt;enumeration value="Val 10-0"/>
 *             &lt;enumeration value="Val 2-0"/>
 *             &lt;enumeration value="Val 2-1"/>
 *             &lt;enumeration value="Val 3-0"/>
 *             &lt;enumeration value="Val 3-1"/>
 *             &lt;enumeration value="Val 3-2"/>
 *             &lt;enumeration value="Val 4-0"/>
 *             &lt;enumeration value="Val 4-1"/>
 *             &lt;enumeration value="Val 4-2"/>
 *             &lt;enumeration value="Val 4-3"/>
 *             &lt;enumeration value="Val 5-0"/>
 *             &lt;enumeration value="Val 5-1"/>
 *             &lt;enumeration value="Val 5-2"/>
 *             &lt;enumeration value="Val 6-0"/>
 *             &lt;enumeration value="Val 6-1"/>
 *             &lt;enumeration value="Val 7-0"/>
 *             &lt;enumeration value="Val 7-1"/>
 *             &lt;enumeration value="Val 8-0"/>
 *             &lt;enumeration value="Val 9-0"/>
 *             &lt;enumeration value="Val or $A"/>
 *             &lt;enumeration value="Val or Dr"/>
 *             &lt;enumeration value="Valencia"/>
 *             &lt;enumeration value="Varane, R"/>
 *             &lt;enumeration value="Xavi"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *       &lt;attribute name="priceUS" use="required">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal">
 *             &lt;enumeration value="-10.0"/>
 *             &lt;enumeration value="-11.11"/>
 *             &lt;enumeration value="-14.29"/>
 *             &lt;enumeration value="-16.67"/>
 *             &lt;enumeration value="-20.0"/>
 *             &lt;enumeration value="-22.22"/>
 *             &lt;enumeration value="-25.0"/>
 *             &lt;enumeration value="-28.57"/>
 *             &lt;enumeration value="-33.33"/>
 *             &lt;enumeration value="-36.36"/>
 *             &lt;enumeration value="-40.0"/>
 *             &lt;enumeration value="-50.0"/>
 *             &lt;enumeration value="-53.33"/>
 *             &lt;enumeration value="-57.14"/>
 *             &lt;enumeration value="-61.54"/>
 *             &lt;enumeration value="-66.67"/>
 *             &lt;enumeration value="-7.14"/>
 *             &lt;enumeration value="-72.73"/>
 *             &lt;enumeration value="-80.0"/>
 *             &lt;enumeration value="-83.33"/>
 *             &lt;enumeration value="-90.91"/>
 *             &lt;enumeration value="-95.24"/>
 *             &lt;enumeration value="100.0"/>
 *             &lt;enumeration value="1000.0"/>
 *             &lt;enumeration value="10000.0"/>
 *             &lt;enumeration value="105.0"/>
 *             &lt;enumeration value="110.0"/>
 *             &lt;enumeration value="1100.0"/>
 *             &lt;enumeration value="120.0"/>
 *             &lt;enumeration value="1200.0"/>
 *             &lt;enumeration value="125.0"/>
 *             &lt;enumeration value="12500.0"/>
 *             &lt;enumeration value="137.5"/>
 *             &lt;enumeration value="1400.0"/>
 *             &lt;enumeration value="150.0"/>
 *             &lt;enumeration value="15000.0"/>
 *             &lt;enumeration value="160.0"/>
 *             &lt;enumeration value="1600.0"/>
 *             &lt;enumeration value="162.5"/>
 *             &lt;enumeration value="175.0"/>
 *             &lt;enumeration value="1800.0"/>
 *             &lt;enumeration value="187.5"/>
 *             &lt;enumeration value="190.0"/>
 *             &lt;enumeration value="200.0"/>
 *             &lt;enumeration value="2000.0"/>
 *             &lt;enumeration value="20000.0"/>
 *             &lt;enumeration value="210.0"/>
 *             &lt;enumeration value="220.0"/>
 *             &lt;enumeration value="2200.0"/>
 *             &lt;enumeration value="225.0"/>
 *             &lt;enumeration value="240.0"/>
 *             &lt;enumeration value="250.0"/>
 *             &lt;enumeration value="2500.0"/>
 *             &lt;enumeration value="25000.0"/>
 *             &lt;enumeration value="260.0"/>
 *             &lt;enumeration value="275.0"/>
 *             &lt;enumeration value="2800.0"/>
 *             &lt;enumeration value="300.0"/>
 *             &lt;enumeration value="30000.0"/>
 *             &lt;enumeration value="3300.0"/>
 *             &lt;enumeration value="333.33"/>
 *             &lt;enumeration value="350.0"/>
 *             &lt;enumeration value="400.0"/>
 *             &lt;enumeration value="4000.0"/>
 *             &lt;enumeration value="40000.0"/>
 *             &lt;enumeration value="450.0"/>
 *             &lt;enumeration value="500.0"/>
 *             &lt;enumeration value="5000.0"/>
 *             &lt;enumeration value="550.0"/>
 *             &lt;enumeration value="600.0"/>
 *             &lt;enumeration value="650.0"/>
 *             &lt;enumeration value="6600.0"/>
 *             &lt;enumeration value="700.0"/>
 *             &lt;enumeration value="750.0"/>
 *             &lt;enumeration value="800.0"/>
 *             &lt;enumeration value="8000.0"/>
 *             &lt;enumeration value="850.0"/>
 *             &lt;enumeration value="900.0"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *       &lt;attribute name="priceDecimal" use="required">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal">
 *             &lt;enumeration value="1.07"/>
 *             &lt;enumeration value="1.1"/>
 *             &lt;enumeration value="1.11"/>
 *             &lt;enumeration value="1.14"/>
 *             &lt;enumeration value="1.17"/>
 *             &lt;enumeration value="1.2"/>
 *             &lt;enumeration value="1.22"/>
 *             &lt;enumeration value="1.25"/>
 *             &lt;enumeration value="1.29"/>
 *             &lt;enumeration value="1.33"/>
 *             &lt;enumeration value="1.36"/>
 *             &lt;enumeration value="1.4"/>
 *             &lt;enumeration value="1.5"/>
 *             &lt;enumeration value="1.53"/>
 *             &lt;enumeration value="1.57"/>
 *             &lt;enumeration value="1.62"/>
 *             &lt;enumeration value="1.67"/>
 *             &lt;enumeration value="1.73"/>
 *             &lt;enumeration value="1.8"/>
 *             &lt;enumeration value="1.83"/>
 *             &lt;enumeration value="1.91"/>
 *             &lt;enumeration value="1.95"/>
 *             &lt;enumeration value="10.0"/>
 *             &lt;enumeration value="101.0"/>
 *             &lt;enumeration value="11.0"/>
 *             &lt;enumeration value="12.0"/>
 *             &lt;enumeration value="126.0"/>
 *             &lt;enumeration value="13.0"/>
 *             &lt;enumeration value="15.0"/>
 *             &lt;enumeration value="151.0"/>
 *             &lt;enumeration value="17.0"/>
 *             &lt;enumeration value="19.0"/>
 *             &lt;enumeration value="2.0"/>
 *             &lt;enumeration value="2.05"/>
 *             &lt;enumeration value="2.1"/>
 *             &lt;enumeration value="2.2"/>
 *             &lt;enumeration value="2.25"/>
 *             &lt;enumeration value="2.38"/>
 *             &lt;enumeration value="2.5"/>
 *             &lt;enumeration value="2.6"/>
 *             &lt;enumeration value="2.63"/>
 *             &lt;enumeration value="2.75"/>
 *             &lt;enumeration value="2.88"/>
 *             &lt;enumeration value="2.9"/>
 *             &lt;enumeration value="201.0"/>
 *             &lt;enumeration value="21.0"/>
 *             &lt;enumeration value="23.0"/>
 *             &lt;enumeration value="251.0"/>
 *             &lt;enumeration value="26.0"/>
 *             &lt;enumeration value="29.0"/>
 *             &lt;enumeration value="3.0"/>
 *             &lt;enumeration value="3.1"/>
 *             &lt;enumeration value="3.2"/>
 *             &lt;enumeration value="3.25"/>
 *             &lt;enumeration value="3.4"/>
 *             &lt;enumeration value="3.5"/>
 *             &lt;enumeration value="3.6"/>
 *             &lt;enumeration value="3.75"/>
 *             &lt;enumeration value="301.0"/>
 *             &lt;enumeration value="34.0"/>
 *             &lt;enumeration value="4.0"/>
 *             &lt;enumeration value="4.33"/>
 *             &lt;enumeration value="4.5"/>
 *             &lt;enumeration value="401.0"/>
 *             &lt;enumeration value="41.0"/>
 *             &lt;enumeration value="5.0"/>
 *             &lt;enumeration value="5.5"/>
 *             &lt;enumeration value="51.0"/>
 *             &lt;enumeration value="6.0"/>
 *             &lt;enumeration value="6.5"/>
 *             &lt;enumeration value="67.0"/>
 *             &lt;enumeration value="7.0"/>
 *             &lt;enumeration value="7.5"/>
 *             &lt;enumeration value="8.0"/>
 *             &lt;enumeration value="8.5"/>
 *             &lt;enumeration value="81.0"/>
 *             &lt;enumeration value="9.0"/>
 *             &lt;enumeration value="9.5"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *       &lt;attribute name="price" use="required">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *             &lt;enumeration value="1/10"/>
 *             &lt;enumeration value="1/14"/>
 *             &lt;enumeration value="1/2"/>
 *             &lt;enumeration value="1/3"/>
 *             &lt;enumeration value="1/4"/>
 *             &lt;enumeration value="1/5"/>
 *             &lt;enumeration value="1/6"/>
 *             &lt;enumeration value="1/7"/>
 *             &lt;enumeration value="1/9"/>
 *             &lt;enumeration value="10/1"/>
 *             &lt;enumeration value="10/11"/>
 *             &lt;enumeration value="10/3"/>
 *             &lt;enumeration value="100/1"/>
 *             &lt;enumeration value="11/1"/>
 *             &lt;enumeration value="11/10"/>
 *             &lt;enumeration value="11/2"/>
 *             &lt;enumeration value="11/4"/>
 *             &lt;enumeration value="11/5"/>
 *             &lt;enumeration value="11/8"/>
 *             &lt;enumeration value="12/1"/>
 *             &lt;enumeration value="12/5"/>
 *             &lt;enumeration value="125/1"/>
 *             &lt;enumeration value="13/2"/>
 *             &lt;enumeration value="13/5"/>
 *             &lt;enumeration value="13/8"/>
 *             &lt;enumeration value="14/1"/>
 *             &lt;enumeration value="15/2"/>
 *             &lt;enumeration value="15/8"/>
 *             &lt;enumeration value="150/1"/>
 *             &lt;enumeration value="16/1"/>
 *             &lt;enumeration value="17/2"/>
 *             &lt;enumeration value="18/1"/>
 *             &lt;enumeration value="19/10"/>
 *             &lt;enumeration value="2/1"/>
 *             &lt;enumeration value="2/5"/>
 *             &lt;enumeration value="2/7"/>
 *             &lt;enumeration value="2/9"/>
 *             &lt;enumeration value="20/1"/>
 *             &lt;enumeration value="20/21"/>
 *             &lt;enumeration value="200/1"/>
 *             &lt;enumeration value="21/10"/>
 *             &lt;enumeration value="21/20"/>
 *             &lt;enumeration value="22/1"/>
 *             &lt;enumeration value="25/1"/>
 *             &lt;enumeration value="250/1"/>
 *             &lt;enumeration value="28/1"/>
 *             &lt;enumeration value="3/1"/>
 *             &lt;enumeration value="300/1"/>
 *             &lt;enumeration value="33/1"/>
 *             &lt;enumeration value="4/1"/>
 *             &lt;enumeration value="4/11"/>
 *             &lt;enumeration value="4/5"/>
 *             &lt;enumeration value="4/6"/>
 *             &lt;enumeration value="4/7"/>
 *             &lt;enumeration value="40/1"/>
 *             &lt;enumeration value="400/1"/>
 *             &lt;enumeration value="5/1"/>
 *             &lt;enumeration value="5/2"/>
 *             &lt;enumeration value="5/4"/>
 *             &lt;enumeration value="5/6"/>
 *             &lt;enumeration value="50/1"/>
 *             &lt;enumeration value="6/1"/>
 *             &lt;enumeration value="6/4"/>
 *             &lt;enumeration value="6/5"/>
 *             &lt;enumeration value="66/1"/>
 *             &lt;enumeration value="7/1"/>
 *             &lt;enumeration value="7/2"/>
 *             &lt;enumeration value="7/4"/>
 *             &lt;enumeration value="8/1"/>
 *             &lt;enumeration value="8/11"/>
 *             &lt;enumeration value="8/13"/>
 *             &lt;enumeration value="8/15"/>
 *             &lt;enumeration value="8/5"/>
 *             &lt;enumeration value="80/1"/>
 *             &lt;enumeration value="9/1"/>
 *             &lt;enumeration value="9/2"/>
 *             &lt;enumeration value="9/4"/>
 *             &lt;enumeration value="Evs"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *       &lt;attribute name="name" use="required">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *             &lt;enumeration value="0-1 Goal"/>
 *             &lt;enumeration value="1st Half"/>
 *             &lt;enumeration value="2-3 Goals"/>
 *             &lt;enumeration value="2nd Half"/>
 *             &lt;enumeration value="4+ Goals"/>
 *             &lt;enumeration value="Alba, Jordi"/>
 *             &lt;enumeration value="Albiol, Raul"/>
 *             &lt;enumeration value="Alcantara, Thiago"/>
 *             &lt;enumeration value="Alonso, Xabi"/>
 *             &lt;enumeration value="Alves, Daniel"/>
 *             &lt;enumeration value="Arbeloa, Alvaro"/>
 *             &lt;enumeration value="Athletic Bilbao"/>
 *             &lt;enumeration value="Athletic Bilbao - Athletic Bilbao"/>
 *             &lt;enumeration value="Athletic Bilbao - Draw"/>
 *             &lt;enumeration value="Athletic Bilbao - Osasuna"/>
 *             &lt;enumeration value="Athletic Bilbao 1-0"/>
 *             &lt;enumeration value="Athletic Bilbao 10-0"/>
 *             &lt;enumeration value="Athletic Bilbao 2-0"/>
 *             &lt;enumeration value="Athletic Bilbao 2-1"/>
 *             &lt;enumeration value="Athletic Bilbao 3-0"/>
 *             &lt;enumeration value="Athletic Bilbao 3-1"/>
 *             &lt;enumeration value="Athletic Bilbao 3-2"/>
 *             &lt;enumeration value="Athletic Bilbao 4-0"/>
 *             &lt;enumeration value="Athletic Bilbao 4-1"/>
 *             &lt;enumeration value="Athletic Bilbao 4-2"/>
 *             &lt;enumeration value="Athletic Bilbao 4-3"/>
 *             &lt;enumeration value="Athletic Bilbao 5-0"/>
 *             &lt;enumeration value="Athletic Bilbao 5-1"/>
 *             &lt;enumeration value="Athletic Bilbao 5-2"/>
 *             &lt;enumeration value="Athletic Bilbao 6-0"/>
 *             &lt;enumeration value="Athletic Bilbao 6-1"/>
 *             &lt;enumeration value="Athletic Bilbao 7-0"/>
 *             &lt;enumeration value="Athletic Bilbao 7-1"/>
 *             &lt;enumeration value="Athletic Bilbao 8-0"/>
 *             &lt;enumeration value="Athletic Bilbao 9-0"/>
 *             &lt;enumeration value="Atletico Madrid"/>
 *             &lt;enumeration value="Atletico Madrid - Atletico Madrid"/>
 *             &lt;enumeration value="Atletico Madrid - Draw"/>
 *             &lt;enumeration value="Atletico Madrid - Malaga"/>
 *             &lt;enumeration value="Atletico Madrid 1-0"/>
 *             &lt;enumeration value="Atletico Madrid 10-0"/>
 *             &lt;enumeration value="Atletico Madrid 2-0"/>
 *             &lt;enumeration value="Atletico Madrid 2-1"/>
 *             &lt;enumeration value="Atletico Madrid 3-0"/>
 *             &lt;enumeration value="Atletico Madrid 3-1"/>
 *             &lt;enumeration value="Atletico Madrid 3-2"/>
 *             &lt;enumeration value="Atletico Madrid 4-0"/>
 *             &lt;enumeration value="Atletico Madrid 4-1"/>
 *             &lt;enumeration value="Atletico Madrid 4-2"/>
 *             &lt;enumeration value="Atletico Madrid 4-3"/>
 *             &lt;enumeration value="Atletico Madrid 5-0"/>
 *             &lt;enumeration value="Atletico Madrid 5-1"/>
 *             &lt;enumeration value="Atletico Madrid 5-2"/>
 *             &lt;enumeration value="Atletico Madrid 6-0"/>
 *             &lt;enumeration value="Atletico Madrid 6-1"/>
 *             &lt;enumeration value="Atletico Madrid 7-0"/>
 *             &lt;enumeration value="Atletico Madrid 7-1"/>
 *             &lt;enumeration value="Atletico Madrid 8-0"/>
 *             &lt;enumeration value="Atletico Madrid 9-0"/>
 *             &lt;enumeration value="Atletico Madrid Or Draw"/>
 *             &lt;enumeration value="Barcelona"/>
 *             &lt;enumeration value="Barcelona - Barcelona"/>
 *             &lt;enumeration value="Barcelona - Draw"/>
 *             &lt;enumeration value="Barcelona - Real Madrid"/>
 *             &lt;enumeration value="Barcelona 1-0"/>
 *             &lt;enumeration value="Barcelona 10-0"/>
 *             &lt;enumeration value="Barcelona 2-0"/>
 *             &lt;enumeration value="Barcelona 2-1"/>
 *             &lt;enumeration value="Barcelona 3-0"/>
 *             &lt;enumeration value="Barcelona 3-1"/>
 *             &lt;enumeration value="Barcelona 3-2"/>
 *             &lt;enumeration value="Barcelona 4-0"/>
 *             &lt;enumeration value="Barcelona 4-1"/>
 *             &lt;enumeration value="Barcelona 4-2"/>
 *             &lt;enumeration value="Barcelona 4-3"/>
 *             &lt;enumeration value="Barcelona 5-0"/>
 *             &lt;enumeration value="Barcelona 5-1"/>
 *             &lt;enumeration value="Barcelona 5-2"/>
 *             &lt;enumeration value="Barcelona 6-0"/>
 *             &lt;enumeration value="Barcelona 6-1"/>
 *             &lt;enumeration value="Barcelona 7-0"/>
 *             &lt;enumeration value="Barcelona 7-1"/>
 *             &lt;enumeration value="Barcelona 8-0"/>
 *             &lt;enumeration value="Barcelona 9-0"/>
 *             &lt;enumeration value="Barcelona Or Draw"/>
 *             &lt;enumeration value="Benzema, Karim"/>
 *             &lt;enumeration value="Busquets, Sergio"/>
 *             &lt;enumeration value="Callejon, Jose Maria"/>
 *             &lt;enumeration value="Carvalho, Ricardo"/>
 *             &lt;enumeration value="Celta Vigo"/>
 *             &lt;enumeration value="Celta Vigo - Celta Vigo"/>
 *             &lt;enumeration value="Celta Vigo - Draw"/>
 *             &lt;enumeration value="Celta Vigo - Sevilla"/>
 *             &lt;enumeration value="Celta Vigo 1-0"/>
 *             &lt;enumeration value="Celta Vigo 10-0"/>
 *             &lt;enumeration value="Celta Vigo 2-0"/>
 *             &lt;enumeration value="Celta Vigo 2-1"/>
 *             &lt;enumeration value="Celta Vigo 3-0"/>
 *             &lt;enumeration value="Celta Vigo 3-1"/>
 *             &lt;enumeration value="Celta Vigo 3-2"/>
 *             &lt;enumeration value="Celta Vigo 4-0"/>
 *             &lt;enumeration value="Celta Vigo 4-1"/>
 *             &lt;enumeration value="Celta Vigo 4-2"/>
 *             &lt;enumeration value="Celta Vigo 4-3"/>
 *             &lt;enumeration value="Celta Vigo 5-0"/>
 *             &lt;enumeration value="Celta Vigo 5-1"/>
 *             &lt;enumeration value="Celta Vigo 5-2"/>
 *             &lt;enumeration value="Celta Vigo 6-0"/>
 *             &lt;enumeration value="Celta Vigo 6-1"/>
 *             &lt;enumeration value="Celta Vigo 7-0"/>
 *             &lt;enumeration value="Celta Vigo 7-1"/>
 *             &lt;enumeration value="Celta Vigo 8-0"/>
 *             &lt;enumeration value="Celta Vigo 9-0"/>
 *             &lt;enumeration value="Coentrao, Fabio"/>
 *             &lt;enumeration value="Correia, Adriano"/>
 *             &lt;enumeration value="Deportivo"/>
 *             &lt;enumeration value="Deportivo - Deportivo"/>
 *             &lt;enumeration value="Deportivo - Draw"/>
 *             &lt;enumeration value="Deportivo - Real Zaragoza"/>
 *             &lt;enumeration value="Deportivo 1-0"/>
 *             &lt;enumeration value="Deportivo 10-0"/>
 *             &lt;enumeration value="Deportivo 2-0"/>
 *             &lt;enumeration value="Deportivo 2-1"/>
 *             &lt;enumeration value="Deportivo 3-0"/>
 *             &lt;enumeration value="Deportivo 3-1"/>
 *             &lt;enumeration value="Deportivo 3-2"/>
 *             &lt;enumeration value="Deportivo 4-0"/>
 *             &lt;enumeration value="Deportivo 4-1"/>
 *             &lt;enumeration value="Deportivo 4-2"/>
 *             &lt;enumeration value="Deportivo 4-3"/>
 *             &lt;enumeration value="Deportivo 5-0"/>
 *             &lt;enumeration value="Deportivo 5-1"/>
 *             &lt;enumeration value="Deportivo 5-2"/>
 *             &lt;enumeration value="Deportivo 6-0"/>
 *             &lt;enumeration value="Deportivo 6-1"/>
 *             &lt;enumeration value="Deportivo 7-0"/>
 *             &lt;enumeration value="Deportivo 7-1"/>
 *             &lt;enumeration value="Deportivo 8-0"/>
 *             &lt;enumeration value="Deportivo 9-0"/>
 *             &lt;enumeration value="Draw"/>
 *             &lt;enumeration value="Draw - Athletic Bilbao"/>
 *             &lt;enumeration value="Draw - Atletico Madrid"/>
 *             &lt;enumeration value="Draw - Barcelona"/>
 *             &lt;enumeration value="Draw - Celta Vigo"/>
 *             &lt;enumeration value="Draw - Deportivo"/>
 *             &lt;enumeration value="Draw - Draw"/>
 *             &lt;enumeration value="Draw - Espanyol"/>
 *             &lt;enumeration value="Draw - Getafe"/>
 *             &lt;enumeration value="Draw - Granada"/>
 *             &lt;enumeration value="Draw - Levante"/>
 *             &lt;enumeration value="Draw - Malaga"/>
 *             &lt;enumeration value="Draw - Mallorca"/>
 *             &lt;enumeration value="Draw - Osasuna"/>
 *             &lt;enumeration value="Draw - Real Betis"/>
 *             &lt;enumeration value="Draw - Real Madrid"/>
 *             &lt;enumeration value="Draw - Real Sociedad"/>
 *             &lt;enumeration value="Draw - Real Valladolid"/>
 *             &lt;enumeration value="Draw - Real Zaragoza"/>
 *             &lt;enumeration value="Draw - Sevilla"/>
 *             &lt;enumeration value="Draw - Valencia"/>
 *             &lt;enumeration value="Draw 0-0"/>
 *             &lt;enumeration value="Draw 1-1"/>
 *             &lt;enumeration value="Draw 2-2"/>
 *             &lt;enumeration value="Draw 3-3"/>
 *             &lt;enumeration value="Espanyol"/>
 *             &lt;enumeration value="Espanyol - Draw"/>
 *             &lt;enumeration value="Espanyol - Espanyol"/>
 *             &lt;enumeration value="Espanyol - Real Valladolid"/>
 *             &lt;enumeration value="Espanyol 1-0"/>
 *             &lt;enumeration value="Espanyol 10-0"/>
 *             &lt;enumeration value="Espanyol 2-0"/>
 *             &lt;enumeration value="Espanyol 2-1"/>
 *             &lt;enumeration value="Espanyol 3-0"/>
 *             &lt;enumeration value="Espanyol 3-1"/>
 *             &lt;enumeration value="Espanyol 3-2"/>
 *             &lt;enumeration value="Espanyol 4-0"/>
 *             &lt;enumeration value="Espanyol 4-1"/>
 *             &lt;enumeration value="Espanyol 4-2"/>
 *             &lt;enumeration value="Espanyol 4-3"/>
 *             &lt;enumeration value="Espanyol 5-0"/>
 *             &lt;enumeration value="Espanyol 5-1"/>
 *             &lt;enumeration value="Espanyol 5-2"/>
 *             &lt;enumeration value="Espanyol 6-0"/>
 *             &lt;enumeration value="Espanyol 6-1"/>
 *             &lt;enumeration value="Espanyol 7-0"/>
 *             &lt;enumeration value="Espanyol 7-1"/>
 *             &lt;enumeration value="Espanyol 8-0"/>
 *             &lt;enumeration value="Espanyol 9-0"/>
 *             &lt;enumeration value="Essien, Michael"/>
 *             &lt;enumeration value="Even"/>
 *             &lt;enumeration value="Fabregas, Cesc"/>
 *             &lt;enumeration value="Getafe"/>
 *             &lt;enumeration value="Getafe - Draw"/>
 *             &lt;enumeration value="Getafe - Getafe"/>
 *             &lt;enumeration value="Getafe - Real Zaragoza"/>
 *             &lt;enumeration value="Getafe 1-0"/>
 *             &lt;enumeration value="Getafe 10-0"/>
 *             &lt;enumeration value="Getafe 2-0"/>
 *             &lt;enumeration value="Getafe 2-1"/>
 *             &lt;enumeration value="Getafe 3-0"/>
 *             &lt;enumeration value="Getafe 3-1"/>
 *             &lt;enumeration value="Getafe 3-2"/>
 *             &lt;enumeration value="Getafe 4-0"/>
 *             &lt;enumeration value="Getafe 4-1"/>
 *             &lt;enumeration value="Getafe 4-2"/>
 *             &lt;enumeration value="Getafe 4-3"/>
 *             &lt;enumeration value="Getafe 5-0"/>
 *             &lt;enumeration value="Getafe 5-1"/>
 *             &lt;enumeration value="Getafe 5-2"/>
 *             &lt;enumeration value="Getafe 6-0"/>
 *             &lt;enumeration value="Getafe 6-1"/>
 *             &lt;enumeration value="Getafe 7-0"/>
 *             &lt;enumeration value="Getafe 7-1"/>
 *             &lt;enumeration value="Getafe 8-0"/>
 *             &lt;enumeration value="Getafe 9-0"/>
 *             &lt;enumeration value="Granada"/>
 *             &lt;enumeration value="Granada - Draw"/>
 *             &lt;enumeration value="Granada - Granada"/>
 *             &lt;enumeration value="Granada - Mallorca"/>
 *             &lt;enumeration value="Granada 1-0"/>
 *             &lt;enumeration value="Granada 10-0"/>
 *             &lt;enumeration value="Granada 2-0"/>
 *             &lt;enumeration value="Granada 2-1"/>
 *             &lt;enumeration value="Granada 3-0"/>
 *             &lt;enumeration value="Granada 3-1"/>
 *             &lt;enumeration value="Granada 3-2"/>
 *             &lt;enumeration value="Granada 4-0"/>
 *             &lt;enumeration value="Granada 4-1"/>
 *             &lt;enumeration value="Granada 4-2"/>
 *             &lt;enumeration value="Granada 4-3"/>
 *             &lt;enumeration value="Granada 5-0"/>
 *             &lt;enumeration value="Granada 5-1"/>
 *             &lt;enumeration value="Granada 5-2"/>
 *             &lt;enumeration value="Granada 6-0"/>
 *             &lt;enumeration value="Granada 6-1"/>
 *             &lt;enumeration value="Granada 7-0"/>
 *             &lt;enumeration value="Granada 7-1"/>
 *             &lt;enumeration value="Granada 8-0"/>
 *             &lt;enumeration value="Granada 9-0"/>
 *             &lt;enumeration value="Higuain, Gonzalo"/>
 *             &lt;enumeration value="Iniesta, Andres"/>
 *             &lt;enumeration value="Kaka,"/>
 *             &lt;enumeration value="Khedira, Sami"/>
 *             &lt;enumeration value="Levante"/>
 *             &lt;enumeration value="Levante - Draw"/>
 *             &lt;enumeration value="Levante - Levante"/>
 *             &lt;enumeration value="Levante - Valencia"/>
 *             &lt;enumeration value="Levante 1-0"/>
 *             &lt;enumeration value="Levante 10-0"/>
 *             &lt;enumeration value="Levante 2-0"/>
 *             &lt;enumeration value="Levante 2-1"/>
 *             &lt;enumeration value="Levante 3-0"/>
 *             &lt;enumeration value="Levante 3-1"/>
 *             &lt;enumeration value="Levante 3-2"/>
 *             &lt;enumeration value="Levante 4-0"/>
 *             &lt;enumeration value="Levante 4-1"/>
 *             &lt;enumeration value="Levante 4-2"/>
 *             &lt;enumeration value="Levante 4-3"/>
 *             &lt;enumeration value="Levante 5-0"/>
 *             &lt;enumeration value="Levante 5-1"/>
 *             &lt;enumeration value="Levante 5-2"/>
 *             &lt;enumeration value="Levante 6-0"/>
 *             &lt;enumeration value="Levante 6-1"/>
 *             &lt;enumeration value="Levante 7-0"/>
 *             &lt;enumeration value="Levante 7-1"/>
 *             &lt;enumeration value="Levante 8-0"/>
 *             &lt;enumeration value="Levante 9-0"/>
 *             &lt;enumeration value="Levante Or Draw"/>
 *             &lt;enumeration value="Malaga"/>
 *             &lt;enumeration value="Malaga - Atletico Madrid"/>
 *             &lt;enumeration value="Malaga - Draw"/>
 *             &lt;enumeration value="Malaga - Malaga"/>
 *             &lt;enumeration value="Malaga 1-0"/>
 *             &lt;enumeration value="Malaga 10-0"/>
 *             &lt;enumeration value="Malaga 2-0"/>
 *             &lt;enumeration value="Malaga 2-1"/>
 *             &lt;enumeration value="Malaga 3-0"/>
 *             &lt;enumeration value="Malaga 3-1"/>
 *             &lt;enumeration value="Malaga 3-2"/>
 *             &lt;enumeration value="Malaga 4-0"/>
 *             &lt;enumeration value="Malaga 4-1"/>
 *             &lt;enumeration value="Malaga 4-2"/>
 *             &lt;enumeration value="Malaga 4-3"/>
 *             &lt;enumeration value="Malaga 5-0"/>
 *             &lt;enumeration value="Malaga 5-1"/>
 *             &lt;enumeration value="Malaga 5-2"/>
 *             &lt;enumeration value="Malaga 6-0"/>
 *             &lt;enumeration value="Malaga 6-1"/>
 *             &lt;enumeration value="Malaga 7-0"/>
 *             &lt;enumeration value="Malaga 7-1"/>
 *             &lt;enumeration value="Malaga 8-0"/>
 *             &lt;enumeration value="Malaga 9-0"/>
 *             &lt;enumeration value="Malaga Or Atletico Madrid"/>
 *             &lt;enumeration value="Malaga Or Draw"/>
 *             &lt;enumeration value="Mallorca"/>
 *             &lt;enumeration value="Mallorca - Draw"/>
 *             &lt;enumeration value="Mallorca - Granada"/>
 *             &lt;enumeration value="Mallorca - Mallorca"/>
 *             &lt;enumeration value="Mallorca 1-0"/>
 *             &lt;enumeration value="Mallorca 10-0"/>
 *             &lt;enumeration value="Mallorca 2-0"/>
 *             &lt;enumeration value="Mallorca 2-1"/>
 *             &lt;enumeration value="Mallorca 3-0"/>
 *             &lt;enumeration value="Mallorca 3-1"/>
 *             &lt;enumeration value="Mallorca 3-2"/>
 *             &lt;enumeration value="Mallorca 4-0"/>
 *             &lt;enumeration value="Mallorca 4-1"/>
 *             &lt;enumeration value="Mallorca 4-2"/>
 *             &lt;enumeration value="Mallorca 4-3"/>
 *             &lt;enumeration value="Mallorca 5-0"/>
 *             &lt;enumeration value="Mallorca 5-1"/>
 *             &lt;enumeration value="Mallorca 5-2"/>
 *             &lt;enumeration value="Mallorca 6-0"/>
 *             &lt;enumeration value="Mallorca 6-1"/>
 *             &lt;enumeration value="Mallorca 7-0"/>
 *             &lt;enumeration value="Mallorca 7-1"/>
 *             &lt;enumeration value="Mallorca 8-0"/>
 *             &lt;enumeration value="Mallorca 9-0"/>
 *             &lt;enumeration value="Marcelo,"/>
 *             &lt;enumeration value="Mascherano, Javier"/>
 *             &lt;enumeration value="Messi, Lionel"/>
 *             &lt;enumeration value="Modric, Luka"/>
 *             &lt;enumeration value="Montoya, Martin"/>
 *             &lt;enumeration value="Morata, Alvaro"/>
 *             &lt;enumeration value="No Goal"/>
 *             &lt;enumeration value="No Goalscorer"/>
 *             &lt;enumeration value="Odd"/>
 *             &lt;enumeration value="Osasuna"/>
 *             &lt;enumeration value="Osasuna - Athletic Bilbao"/>
 *             &lt;enumeration value="Osasuna - Draw"/>
 *             &lt;enumeration value="Osasuna - Osasuna"/>
 *             &lt;enumeration value="Osasuna 1-0"/>
 *             &lt;enumeration value="Osasuna 10-0"/>
 *             &lt;enumeration value="Osasuna 2-0"/>
 *             &lt;enumeration value="Osasuna 2-1"/>
 *             &lt;enumeration value="Osasuna 3-0"/>
 *             &lt;enumeration value="Osasuna 3-1"/>
 *             &lt;enumeration value="Osasuna 3-2"/>
 *             &lt;enumeration value="Osasuna 4-0"/>
 *             &lt;enumeration value="Osasuna 4-1"/>
 *             &lt;enumeration value="Osasuna 4-2"/>
 *             &lt;enumeration value="Osasuna 4-3"/>
 *             &lt;enumeration value="Osasuna 5-0"/>
 *             &lt;enumeration value="Osasuna 5-1"/>
 *             &lt;enumeration value="Osasuna 5-2"/>
 *             &lt;enumeration value="Osasuna 6-0"/>
 *             &lt;enumeration value="Osasuna 6-1"/>
 *             &lt;enumeration value="Osasuna 7-0"/>
 *             &lt;enumeration value="Osasuna 7-1"/>
 *             &lt;enumeration value="Osasuna 8-0"/>
 *             &lt;enumeration value="Osasuna 9-0"/>
 *             &lt;enumeration value="Over 0.5 Goals"/>
 *             &lt;enumeration value="Over 1.5"/>
 *             &lt;enumeration value="Over 1.5 Goals"/>
 *             &lt;enumeration value="Over 2.5 Goals"/>
 *             &lt;enumeration value="Over 3.5 Goals"/>
 *             &lt;enumeration value="Over 4.5 Goals"/>
 *             &lt;enumeration value="Ozil, Mesut"/>
 *             &lt;enumeration value="Pedro,"/>
 *             &lt;enumeration value="Pepe,"/>
 *             &lt;enumeration value="Pique, Gerard"/>
 *             &lt;enumeration value="Puyol, Carles"/>
 *             &lt;enumeration value="Real Betis"/>
 *             &lt;enumeration value="Real Betis - Draw"/>
 *             &lt;enumeration value="Real Betis - Real Betis"/>
 *             &lt;enumeration value="Real Betis - Real Sociedad"/>
 *             &lt;enumeration value="Real Betis 1-0"/>
 *             &lt;enumeration value="Real Betis 10-0"/>
 *             &lt;enumeration value="Real Betis 2-0"/>
 *             &lt;enumeration value="Real Betis 2-1"/>
 *             &lt;enumeration value="Real Betis 3-0"/>
 *             &lt;enumeration value="Real Betis 3-1"/>
 *             &lt;enumeration value="Real Betis 3-2"/>
 *             &lt;enumeration value="Real Betis 4-0"/>
 *             &lt;enumeration value="Real Betis 4-1"/>
 *             &lt;enumeration value="Real Betis 4-2"/>
 *             &lt;enumeration value="Real Betis 4-3"/>
 *             &lt;enumeration value="Real Betis 5-0"/>
 *             &lt;enumeration value="Real Betis 5-1"/>
 *             &lt;enumeration value="Real Betis 5-2"/>
 *             &lt;enumeration value="Real Betis 6-0"/>
 *             &lt;enumeration value="Real Betis 6-1"/>
 *             &lt;enumeration value="Real Betis 7-0"/>
 *             &lt;enumeration value="Real Betis 7-1"/>
 *             &lt;enumeration value="Real Betis 8-0"/>
 *             &lt;enumeration value="Real Betis 9-0"/>
 *             &lt;enumeration value="Real Betis Or Draw"/>
 *             &lt;enumeration value="Real Madrid"/>
 *             &lt;enumeration value="Real Madrid - Barcelona"/>
 *             &lt;enumeration value="Real Madrid - Draw"/>
 *             &lt;enumeration value="Real Madrid - Real Madrid"/>
 *             &lt;enumeration value="Real Madrid 1-0"/>
 *             &lt;enumeration value="Real Madrid 10-0"/>
 *             &lt;enumeration value="Real Madrid 2-0"/>
 *             &lt;enumeration value="Real Madrid 2-1"/>
 *             &lt;enumeration value="Real Madrid 3-0"/>
 *             &lt;enumeration value="Real Madrid 3-1"/>
 *             &lt;enumeration value="Real Madrid 3-2"/>
 *             &lt;enumeration value="Real Madrid 4-0"/>
 *             &lt;enumeration value="Real Madrid 4-1"/>
 *             &lt;enumeration value="Real Madrid 4-2"/>
 *             &lt;enumeration value="Real Madrid 4-3"/>
 *             &lt;enumeration value="Real Madrid 5-0"/>
 *             &lt;enumeration value="Real Madrid 5-1"/>
 *             &lt;enumeration value="Real Madrid 5-2"/>
 *             &lt;enumeration value="Real Madrid 6-0"/>
 *             &lt;enumeration value="Real Madrid 6-1"/>
 *             &lt;enumeration value="Real Madrid 7-0"/>
 *             &lt;enumeration value="Real Madrid 7-1"/>
 *             &lt;enumeration value="Real Madrid 8-0"/>
 *             &lt;enumeration value="Real Madrid 9-0"/>
 *             &lt;enumeration value="Real Madrid Or Barcelona"/>
 *             &lt;enumeration value="Real Madrid Or Draw"/>
 *             &lt;enumeration value="Real Sociedad"/>
 *             &lt;enumeration value="Real Sociedad - Draw"/>
 *             &lt;enumeration value="Real Sociedad - Real Betis"/>
 *             &lt;enumeration value="Real Sociedad - Real Sociedad"/>
 *             &lt;enumeration value="Real Sociedad 1-0"/>
 *             &lt;enumeration value="Real Sociedad 10-0"/>
 *             &lt;enumeration value="Real Sociedad 2-0"/>
 *             &lt;enumeration value="Real Sociedad 2-1"/>
 *             &lt;enumeration value="Real Sociedad 3-0"/>
 *             &lt;enumeration value="Real Sociedad 3-1"/>
 *             &lt;enumeration value="Real Sociedad 3-2"/>
 *             &lt;enumeration value="Real Sociedad 4-0"/>
 *             &lt;enumeration value="Real Sociedad 4-1"/>
 *             &lt;enumeration value="Real Sociedad 4-2"/>
 *             &lt;enumeration value="Real Sociedad 4-3"/>
 *             &lt;enumeration value="Real Sociedad 5-0"/>
 *             &lt;enumeration value="Real Sociedad 5-1"/>
 *             &lt;enumeration value="Real Sociedad 5-2"/>
 *             &lt;enumeration value="Real Sociedad 6-0"/>
 *             &lt;enumeration value="Real Sociedad 6-1"/>
 *             &lt;enumeration value="Real Sociedad 7-0"/>
 *             &lt;enumeration value="Real Sociedad 7-1"/>
 *             &lt;enumeration value="Real Sociedad 8-0"/>
 *             &lt;enumeration value="Real Sociedad 9-0"/>
 *             &lt;enumeration value="Real Sociedad Or Draw"/>
 *             &lt;enumeration value="Real Sociedad Or Real Betis"/>
 *             &lt;enumeration value="Real Valladolid"/>
 *             &lt;enumeration value="Real Valladolid - Draw"/>
 *             &lt;enumeration value="Real Valladolid - Espanyol"/>
 *             &lt;enumeration value="Real Valladolid - Real Valladolid"/>
 *             &lt;enumeration value="Real Valladolid 1-0"/>
 *             &lt;enumeration value="Real Valladolid 10-0"/>
 *             &lt;enumeration value="Real Valladolid 2-0"/>
 *             &lt;enumeration value="Real Valladolid 2-1"/>
 *             &lt;enumeration value="Real Valladolid 3-0"/>
 *             &lt;enumeration value="Real Valladolid 3-1"/>
 *             &lt;enumeration value="Real Valladolid 3-2"/>
 *             &lt;enumeration value="Real Valladolid 4-0"/>
 *             &lt;enumeration value="Real Valladolid 4-1"/>
 *             &lt;enumeration value="Real Valladolid 4-2"/>
 *             &lt;enumeration value="Real Valladolid 4-3"/>
 *             &lt;enumeration value="Real Valladolid 5-0"/>
 *             &lt;enumeration value="Real Valladolid 5-1"/>
 *             &lt;enumeration value="Real Valladolid 5-2"/>
 *             &lt;enumeration value="Real Valladolid 6-0"/>
 *             &lt;enumeration value="Real Valladolid 6-1"/>
 *             &lt;enumeration value="Real Valladolid 7-0"/>
 *             &lt;enumeration value="Real Valladolid 7-1"/>
 *             &lt;enumeration value="Real Valladolid 8-0"/>
 *             &lt;enumeration value="Real Valladolid 9-0"/>
 *             &lt;enumeration value="Real Zaragoza"/>
 *             &lt;enumeration value="Real Zaragoza - Deportivo"/>
 *             &lt;enumeration value="Real Zaragoza - Draw"/>
 *             &lt;enumeration value="Real Zaragoza - Getafe"/>
 *             &lt;enumeration value="Real Zaragoza - Real Zaragoza"/>
 *             &lt;enumeration value="Real Zaragoza 1-0"/>
 *             &lt;enumeration value="Real Zaragoza 10-0"/>
 *             &lt;enumeration value="Real Zaragoza 2-0"/>
 *             &lt;enumeration value="Real Zaragoza 2-1"/>
 *             &lt;enumeration value="Real Zaragoza 3-0"/>
 *             &lt;enumeration value="Real Zaragoza 3-1"/>
 *             &lt;enumeration value="Real Zaragoza 3-2"/>
 *             &lt;enumeration value="Real Zaragoza 4-0"/>
 *             &lt;enumeration value="Real Zaragoza 4-1"/>
 *             &lt;enumeration value="Real Zaragoza 4-2"/>
 *             &lt;enumeration value="Real Zaragoza 4-3"/>
 *             &lt;enumeration value="Real Zaragoza 5-0"/>
 *             &lt;enumeration value="Real Zaragoza 5-1"/>
 *             &lt;enumeration value="Real Zaragoza 5-2"/>
 *             &lt;enumeration value="Real Zaragoza 6-0"/>
 *             &lt;enumeration value="Real Zaragoza 6-1"/>
 *             &lt;enumeration value="Real Zaragoza 7-0"/>
 *             &lt;enumeration value="Real Zaragoza 7-1"/>
 *             &lt;enumeration value="Real Zaragoza 8-0"/>
 *             &lt;enumeration value="Real Zaragoza 9-0"/>
 *             &lt;enumeration value="Roberto, Sergi"/>
 *             &lt;enumeration value="Rodriguez, Jose"/>
 *             &lt;enumeration value="Ronaldo, Cristiano"/>
 *             &lt;enumeration value="Sanchez, Alexis"/>
 *             &lt;enumeration value="Sevilla"/>
 *             &lt;enumeration value="Sevilla - Celta Vigo"/>
 *             &lt;enumeration value="Sevilla - Draw"/>
 *             &lt;enumeration value="Sevilla - Sevilla"/>
 *             &lt;enumeration value="Sevilla 1-0"/>
 *             &lt;enumeration value="Sevilla 10-0"/>
 *             &lt;enumeration value="Sevilla 2-0"/>
 *             &lt;enumeration value="Sevilla 2-1"/>
 *             &lt;enumeration value="Sevilla 3-0"/>
 *             &lt;enumeration value="Sevilla 3-1"/>
 *             &lt;enumeration value="Sevilla 3-2"/>
 *             &lt;enumeration value="Sevilla 4-0"/>
 *             &lt;enumeration value="Sevilla 4-1"/>
 *             &lt;enumeration value="Sevilla 4-2"/>
 *             &lt;enumeration value="Sevilla 4-3"/>
 *             &lt;enumeration value="Sevilla 5-0"/>
 *             &lt;enumeration value="Sevilla 5-1"/>
 *             &lt;enumeration value="Sevilla 5-2"/>
 *             &lt;enumeration value="Sevilla 6-0"/>
 *             &lt;enumeration value="Sevilla 6-1"/>
 *             &lt;enumeration value="Sevilla 7-0"/>
 *             &lt;enumeration value="Sevilla 7-1"/>
 *             &lt;enumeration value="Sevilla 8-0"/>
 *             &lt;enumeration value="Sevilla 9-0"/>
 *             &lt;enumeration value="Song, Alexandre"/>
 *             &lt;enumeration value="Tello, Cristian"/>
 *             &lt;enumeration value="Tie"/>
 *             &lt;enumeration value="Under 0.5 Goals"/>
 *             &lt;enumeration value="Under 1.5"/>
 *             &lt;enumeration value="Under 1.5 Goals"/>
 *             &lt;enumeration value="Under 2.5 Goals"/>
 *             &lt;enumeration value="Under 3.5 Goals"/>
 *             &lt;enumeration value="Under 4.5 Goals"/>
 *             &lt;enumeration value="Valencia"/>
 *             &lt;enumeration value="Valencia - Draw"/>
 *             &lt;enumeration value="Valencia - Levante"/>
 *             &lt;enumeration value="Valencia - Valencia"/>
 *             &lt;enumeration value="Valencia 1-0"/>
 *             &lt;enumeration value="Valencia 10-0"/>
 *             &lt;enumeration value="Valencia 2-0"/>
 *             &lt;enumeration value="Valencia 2-1"/>
 *             &lt;enumeration value="Valencia 3-0"/>
 *             &lt;enumeration value="Valencia 3-1"/>
 *             &lt;enumeration value="Valencia 3-2"/>
 *             &lt;enumeration value="Valencia 4-0"/>
 *             &lt;enumeration value="Valencia 4-1"/>
 *             &lt;enumeration value="Valencia 4-2"/>
 *             &lt;enumeration value="Valencia 4-3"/>
 *             &lt;enumeration value="Valencia 5-0"/>
 *             &lt;enumeration value="Valencia 5-1"/>
 *             &lt;enumeration value="Valencia 5-2"/>
 *             &lt;enumeration value="Valencia 6-0"/>
 *             &lt;enumeration value="Valencia 6-1"/>
 *             &lt;enumeration value="Valencia 7-0"/>
 *             &lt;enumeration value="Valencia 7-1"/>
 *             &lt;enumeration value="Valencia 8-0"/>
 *             &lt;enumeration value="Valencia 9-0"/>
 *             &lt;enumeration value="Valencia Or Draw"/>
 *             &lt;enumeration value="Valencia Or Levante"/>
 *             &lt;enumeration value="Varane, Raphael"/>
 *             &lt;enumeration value="Villa, David"/>
 *             &lt;enumeration value="Xavi,"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *       &lt;attribute name="id" use="required">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal">
 *             &lt;enumeration value="128238106.2"/>
 *             &lt;enumeration value="128238107.2"/>
 *             &lt;enumeration value="128238108.2"/>
 *             &lt;enumeration value="128238111.2"/>
 *             &lt;enumeration value="128238112.2"/>
 *             &lt;enumeration value="128238113.2"/>
 *             &lt;enumeration value="128238114.2"/>
 *             &lt;enumeration value="128238115.2"/>
 *             &lt;enumeration value="128238116.2"/>
 *             &lt;enumeration value="128238120.2"/>
 *             &lt;enumeration value="128238121.2"/>
 *             &lt;enumeration value="128238122.2"/>
 *             &lt;enumeration value="128238123.2"/>
 *             &lt;enumeration value="128238124.2"/>
 *             &lt;enumeration value="128238125.2"/>
 *             &lt;enumeration value="128238126.2"/>
 *             &lt;enumeration value="128238127.2"/>
 *             &lt;enumeration value="128238128.2"/>
 *             &lt;enumeration value="128238129.2"/>
 *             &lt;enumeration value="128238130.2"/>
 *             &lt;enumeration value="128238131.2"/>
 *             &lt;enumeration value="128238132.2"/>
 *             &lt;enumeration value="128238133.2"/>
 *             &lt;enumeration value="128238134.2"/>
 *             &lt;enumeration value="128238135.2"/>
 *             &lt;enumeration value="128238136.2"/>
 *             &lt;enumeration value="128238137.2"/>
 *             &lt;enumeration value="128238138.2"/>
 *             &lt;enumeration value="128238139.2"/>
 *             &lt;enumeration value="128238140.2"/>
 *             &lt;enumeration value="128238141.2"/>
 *             &lt;enumeration value="128238142.2"/>
 *             &lt;enumeration value="128238143.2"/>
 *             &lt;enumeration value="128238144.2"/>
 *             &lt;enumeration value="128238145.2"/>
 *             &lt;enumeration value="128238146.2"/>
 *             &lt;enumeration value="128238147.2"/>
 *             &lt;enumeration value="128238148.2"/>
 *             &lt;enumeration value="128238149.2"/>
 *             &lt;enumeration value="128238150.2"/>
 *             &lt;enumeration value="128238151.2"/>
 *             &lt;enumeration value="128238152.2"/>
 *             &lt;enumeration value="128238153.2"/>
 *             &lt;enumeration value="128238154.2"/>
 *             &lt;enumeration value="128238155.2"/>
 *             &lt;enumeration value="128238156.2"/>
 *             &lt;enumeration value="128238157.2"/>
 *             &lt;enumeration value="128238158.2"/>
 *             &lt;enumeration value="128238159.2"/>
 *             &lt;enumeration value="128238160.2"/>
 *             &lt;enumeration value="128238161.2"/>
 *             &lt;enumeration value="128238162.2"/>
 *             &lt;enumeration value="128238163.2"/>
 *             &lt;enumeration value="128238164.2"/>
 *             &lt;enumeration value="128238165.2"/>
 *             &lt;enumeration value="128238166.2"/>
 *             &lt;enumeration value="128238167.2"/>
 *             &lt;enumeration value="128238168.2"/>
 *             &lt;enumeration value="128238169.2"/>
 *             &lt;enumeration value="128238170.2"/>
 *             &lt;enumeration value="128238171.2"/>
 *             &lt;enumeration value="128238172.2"/>
 *             &lt;enumeration value="128238173.2"/>
 *             &lt;enumeration value="128238174.2"/>
 *             &lt;enumeration value="128238175.2"/>
 *             &lt;enumeration value="128238176.2"/>
 *             &lt;enumeration value="128238198.2"/>
 *             &lt;enumeration value="128238199.2"/>
 *             &lt;enumeration value="128238200.2"/>
 *             &lt;enumeration value="128238201.2"/>
 *             &lt;enumeration value="128238202.2"/>
 *             &lt;enumeration value="128238203.2"/>
 *             &lt;enumeration value="128238204.2"/>
 *             &lt;enumeration value="128238205.2"/>
 *             &lt;enumeration value="128238206.2"/>
 *             &lt;enumeration value="128238207.2"/>
 *             &lt;enumeration value="128238208.2"/>
 *             &lt;enumeration value="128238209.2"/>
 *             &lt;enumeration value="128238210.2"/>
 *             &lt;enumeration value="128238211.2"/>
 *             &lt;enumeration value="128238212.2"/>
 *             &lt;enumeration value="128238213.2"/>
 *             &lt;enumeration value="128238214.2"/>
 *             &lt;enumeration value="128238215.2"/>
 *             &lt;enumeration value="128238216.2"/>
 *             &lt;enumeration value="128238217.2"/>
 *             &lt;enumeration value="128238279.2"/>
 *             &lt;enumeration value="128238280.2"/>
 *             &lt;enumeration value="128238281.2"/>
 *             &lt;enumeration value="128238282.2"/>
 *             &lt;enumeration value="128238283.2"/>
 *             &lt;enumeration value="128238284.2"/>
 *             &lt;enumeration value="128238285.2"/>
 *             &lt;enumeration value="128238286.2"/>
 *             &lt;enumeration value="128238287.2"/>
 *             &lt;enumeration value="128238288.2"/>
 *             &lt;enumeration value="128238289.2"/>
 *             &lt;enumeration value="128238290.2"/>
 *             &lt;enumeration value="128238291.2"/>
 *             &lt;enumeration value="128238292.2"/>
 *             &lt;enumeration value="128238293.2"/>
 *             &lt;enumeration value="128238294.2"/>
 *             &lt;enumeration value="128238295.2"/>
 *             &lt;enumeration value="128238296.2"/>
 *             &lt;enumeration value="128238297.2"/>
 *             &lt;enumeration value="128238319.2"/>
 *             &lt;enumeration value="128238321.2"/>
 *             &lt;enumeration value="128238322.2"/>
 *             &lt;enumeration value="128238323.2"/>
 *             &lt;enumeration value="128238324.2"/>
 *             &lt;enumeration value="128238325.2"/>
 *             &lt;enumeration value="128238326.2"/>
 *             &lt;enumeration value="128238327.2"/>
 *             &lt;enumeration value="128238328.2"/>
 *             &lt;enumeration value="128238329.2"/>
 *             &lt;enumeration value="128238330.2"/>
 *             &lt;enumeration value="128238331.2"/>
 *             &lt;enumeration value="128238332.2"/>
 *             &lt;enumeration value="128238333.2"/>
 *             &lt;enumeration value="128238334.2"/>
 *             &lt;enumeration value="128238335.2"/>
 *             &lt;enumeration value="128238336.2"/>
 *             &lt;enumeration value="128238337.2"/>
 *             &lt;enumeration value="128238338.2"/>
 *             &lt;enumeration value="128238360.2"/>
 *             &lt;enumeration value="128238361.2"/>
 *             &lt;enumeration value="128238362.2"/>
 *             &lt;enumeration value="128238364.2"/>
 *             &lt;enumeration value="128238365.2"/>
 *             &lt;enumeration value="128238366.2"/>
 *             &lt;enumeration value="128238368.2"/>
 *             &lt;enumeration value="128238370.2"/>
 *             &lt;enumeration value="128238371.2"/>
 *             &lt;enumeration value="128238373.2"/>
 *             &lt;enumeration value="128238374.2"/>
 *             &lt;enumeration value="128238376.2"/>
 *             &lt;enumeration value="128238377.2"/>
 *             &lt;enumeration value="128238378.2"/>
 *             &lt;enumeration value="128238379.2"/>
 *             &lt;enumeration value="128238380.2"/>
 *             &lt;enumeration value="128238381.2"/>
 *             &lt;enumeration value="128238382.2"/>
 *             &lt;enumeration value="128238383.2"/>
 *             &lt;enumeration value="128238384.2"/>
 *             &lt;enumeration value="128238385.2"/>
 *             &lt;enumeration value="128238386.2"/>
 *             &lt;enumeration value="128238387.2"/>
 *             &lt;enumeration value="128238388.2"/>
 *             &lt;enumeration value="128238389.2"/>
 *             &lt;enumeration value="128238390.2"/>
 *             &lt;enumeration value="128238391.2"/>
 *             &lt;enumeration value="128238392.2"/>
 *             &lt;enumeration value="128238395.2"/>
 *             &lt;enumeration value="128238396.2"/>
 *             &lt;enumeration value="128238397.2"/>
 *             &lt;enumeration value="128238398.2"/>
 *             &lt;enumeration value="128238399.2"/>
 *             &lt;enumeration value="128238400.2"/>
 *             &lt;enumeration value="128238401.2"/>
 *             &lt;enumeration value="128238402.2"/>
 *             &lt;enumeration value="128238403.2"/>
 *             &lt;enumeration value="128238404.2"/>
 *             &lt;enumeration value="128238405.2"/>
 *             &lt;enumeration value="128238406.2"/>
 *             &lt;enumeration value="128238407.2"/>
 *             &lt;enumeration value="128238411.2"/>
 *             &lt;enumeration value="128238412.2"/>
 *             &lt;enumeration value="128238413.2"/>
 *             &lt;enumeration value="128238420.2"/>
 *             &lt;enumeration value="128238421.2"/>
 *             &lt;enumeration value="128238753.2"/>
 *             &lt;enumeration value="128238754.2"/>
 *             &lt;enumeration value="128238755.2"/>
 *             &lt;enumeration value="128238756.2"/>
 *             &lt;enumeration value="128238757.2"/>
 *             &lt;enumeration value="128238758.2"/>
 *             &lt;enumeration value="128238759.2"/>
 *             &lt;enumeration value="128238760.2"/>
 *             &lt;enumeration value="128238761.2"/>
 *             &lt;enumeration value="128238762.2"/>
 *             &lt;enumeration value="128238763.2"/>
 *             &lt;enumeration value="128238764.2"/>
 *             &lt;enumeration value="128238765.2"/>
 *             &lt;enumeration value="128238766.2"/>
 *             &lt;enumeration value="128238767.2"/>
 *             &lt;enumeration value="128238768.2"/>
 *             &lt;enumeration value="128238769.2"/>
 *             &lt;enumeration value="128238770.2"/>
 *             &lt;enumeration value="128238771.2"/>
 *             &lt;enumeration value="128238813.2"/>
 *             &lt;enumeration value="128238814.2"/>
 *             &lt;enumeration value="128238815.2"/>
 *             &lt;enumeration value="128238816.2"/>
 *             &lt;enumeration value="128238817.2"/>
 *             &lt;enumeration value="128238818.2"/>
 *             &lt;enumeration value="128238819.2"/>
 *             &lt;enumeration value="128238820.2"/>
 *             &lt;enumeration value="128238821.2"/>
 *             &lt;enumeration value="128238822.2"/>
 *             &lt;enumeration value="128238823.2"/>
 *             &lt;enumeration value="128238824.2"/>
 *             &lt;enumeration value="128238825.2"/>
 *             &lt;enumeration value="128238826.2"/>
 *             &lt;enumeration value="128238827.2"/>
 *             &lt;enumeration value="128238828.2"/>
 *             &lt;enumeration value="128238829.2"/>
 *             &lt;enumeration value="128238830.2"/>
 *             &lt;enumeration value="128238831.2"/>
 *             &lt;enumeration value="128238844.2"/>
 *             &lt;enumeration value="128238845.2"/>
 *             &lt;enumeration value="128238846.2"/>
 *             &lt;enumeration value="128238847.2"/>
 *             &lt;enumeration value="128238848.2"/>
 *             &lt;enumeration value="128238849.2"/>
 *             &lt;enumeration value="128238850.2"/>
 *             &lt;enumeration value="128238851.2"/>
 *             &lt;enumeration value="128238852.2"/>
 *             &lt;enumeration value="128238853.2"/>
 *             &lt;enumeration value="128238854.2"/>
 *             &lt;enumeration value="128238855.2"/>
 *             &lt;enumeration value="128238856.2"/>
 *             &lt;enumeration value="128238857.2"/>
 *             &lt;enumeration value="128238858.2"/>
 *             &lt;enumeration value="128238859.2"/>
 *             &lt;enumeration value="128238860.2"/>
 *             &lt;enumeration value="128238861.2"/>
 *             &lt;enumeration value="128238862.2"/>
 *             &lt;enumeration value="128238919.2"/>
 *             &lt;enumeration value="128238921.2"/>
 *             &lt;enumeration value="128238922.2"/>
 *             &lt;enumeration value="128238925.2"/>
 *             &lt;enumeration value="128238926.2"/>
 *             &lt;enumeration value="128238927.2"/>
 *             &lt;enumeration value="128238928.2"/>
 *             &lt;enumeration value="128238929.2"/>
 *             &lt;enumeration value="128238930.2"/>
 *             &lt;enumeration value="128238931.2"/>
 *             &lt;enumeration value="128238932.2"/>
 *             &lt;enumeration value="128238935.2"/>
 *             &lt;enumeration value="128239013.2"/>
 *             &lt;enumeration value="128239014.2"/>
 *             &lt;enumeration value="128239015.2"/>
 *             &lt;enumeration value="128239016.2"/>
 *             &lt;enumeration value="128239017.2"/>
 *             &lt;enumeration value="128239018.2"/>
 *             &lt;enumeration value="128239019.2"/>
 *             &lt;enumeration value="128239020.2"/>
 *             &lt;enumeration value="128239021.2"/>
 *             &lt;enumeration value="128239022.2"/>
 *             &lt;enumeration value="128239023.2"/>
 *             &lt;enumeration value="128239024.2"/>
 *             &lt;enumeration value="128239025.2"/>
 *             &lt;enumeration value="128239026.2"/>
 *             &lt;enumeration value="128239027.2"/>
 *             &lt;enumeration value="128239028.2"/>
 *             &lt;enumeration value="128239029.2"/>
 *             &lt;enumeration value="128239030.2"/>
 *             &lt;enumeration value="128239031.2"/>
 *             &lt;enumeration value="128239032.2"/>
 *             &lt;enumeration value="128239033.2"/>
 *             &lt;enumeration value="128239034.2"/>
 *             &lt;enumeration value="128239035.2"/>
 *             &lt;enumeration value="128239036.2"/>
 *             &lt;enumeration value="128239037.2"/>
 *             &lt;enumeration value="128239038.2"/>
 *             &lt;enumeration value="128239039.2"/>
 *             &lt;enumeration value="128239040.2"/>
 *             &lt;enumeration value="128239041.2"/>
 *             &lt;enumeration value="128239042.2"/>
 *             &lt;enumeration value="128239043.2"/>
 *             &lt;enumeration value="128239044.2"/>
 *             &lt;enumeration value="128239045.2"/>
 *             &lt;enumeration value="128239046.2"/>
 *             &lt;enumeration value="128239047.2"/>
 *             &lt;enumeration value="128239048.2"/>
 *             &lt;enumeration value="128239049.2"/>
 *             &lt;enumeration value="128239050.2"/>
 *             &lt;enumeration value="128298864.2"/>
 *             &lt;enumeration value="128298866.2"/>
 *             &lt;enumeration value="128298869.2"/>
 *             &lt;enumeration value="128298891.2"/>
 *             &lt;enumeration value="128298894.2"/>
 *             &lt;enumeration value="128298896.2"/>
 *             &lt;enumeration value="128298898.2"/>
 *             &lt;enumeration value="128298900.2"/>
 *             &lt;enumeration value="128298902.2"/>
 *             &lt;enumeration value="128298904.2"/>
 *             &lt;enumeration value="128298908.2"/>
 *             &lt;enumeration value="128298911.2"/>
 *             &lt;enumeration value="128298913.2"/>
 *             &lt;enumeration value="128298916.2"/>
 *             &lt;enumeration value="128298918.2"/>
 *             &lt;enumeration value="128298920.2"/>
 *             &lt;enumeration value="128298925.2"/>
 *             &lt;enumeration value="128298927.2"/>
 *             &lt;enumeration value="128298930.2"/>
 *             &lt;enumeration value="128298932.2"/>
 *             &lt;enumeration value="128298935.2"/>
 *             &lt;enumeration value="128298937.2"/>
 *             &lt;enumeration value="128298939.2"/>
 *             &lt;enumeration value="128298940.2"/>
 *             &lt;enumeration value="128298941.2"/>
 *             &lt;enumeration value="128298942.2"/>
 *             &lt;enumeration value="128298943.2"/>
 *             &lt;enumeration value="128298944.2"/>
 *             &lt;enumeration value="128298945.2"/>
 *             &lt;enumeration value="128298946.2"/>
 *             &lt;enumeration value="128298947.2"/>
 *             &lt;enumeration value="128298948.2"/>
 *             &lt;enumeration value="128298950.2"/>
 *             &lt;enumeration value="128298952.2"/>
 *             &lt;enumeration value="128298954.2"/>
 *             &lt;enumeration value="128298955.2"/>
 *             &lt;enumeration value="128298956.2"/>
 *             &lt;enumeration value="128298957.2"/>
 *             &lt;enumeration value="128298958.2"/>
 *             &lt;enumeration value="128298959.2"/>
 *             &lt;enumeration value="128298961.2"/>
 *             &lt;enumeration value="128298963.2"/>
 *             &lt;enumeration value="128298964.2"/>
 *             &lt;enumeration value="128298965.2"/>
 *             &lt;enumeration value="128298966.2"/>
 *             &lt;enumeration value="128298967.2"/>
 *             &lt;enumeration value="128298968.2"/>
 *             &lt;enumeration value="128299021.2"/>
 *             &lt;enumeration value="128299026.2"/>
 *             &lt;enumeration value="128299028.2"/>
 *             &lt;enumeration value="128299031.2"/>
 *             &lt;enumeration value="128299035.2"/>
 *             &lt;enumeration value="128299036.2"/>
 *             &lt;enumeration value="128299040.2"/>
 *             &lt;enumeration value="128299044.2"/>
 *             &lt;enumeration value="128299050.2"/>
 *             &lt;enumeration value="128299067.2"/>
 *             &lt;enumeration value="128299068.2"/>
 *             &lt;enumeration value="128299070.2"/>
 *             &lt;enumeration value="128299073.2"/>
 *             &lt;enumeration value="128299075.2"/>
 *             &lt;enumeration value="128299614.2"/>
 *             &lt;enumeration value="128299615.2"/>
 *             &lt;enumeration value="128299616.2"/>
 *             &lt;enumeration value="128299619.2"/>
 *             &lt;enumeration value="128299620.2"/>
 *             &lt;enumeration value="128299621.2"/>
 *             &lt;enumeration value="128299622.2"/>
 *             &lt;enumeration value="128299623.2"/>
 *             &lt;enumeration value="128299624.2"/>
 *             &lt;enumeration value="128299625.2"/>
 *             &lt;enumeration value="128299626.2"/>
 *             &lt;enumeration value="128299627.2"/>
 *             &lt;enumeration value="128299628.2"/>
 *             &lt;enumeration value="128299629.2"/>
 *             &lt;enumeration value="128299630.2"/>
 *             &lt;enumeration value="128299631.2"/>
 *             &lt;enumeration value="128299632.2"/>
 *             &lt;enumeration value="128299633.2"/>
 *             &lt;enumeration value="128299634.2"/>
 *             &lt;enumeration value="128299635.2"/>
 *             &lt;enumeration value="128299636.2"/>
 *             &lt;enumeration value="128299637.2"/>
 *             &lt;enumeration value="128299638.2"/>
 *             &lt;enumeration value="128299639.2"/>
 *             &lt;enumeration value="128299640.2"/>
 *             &lt;enumeration value="128299641.2"/>
 *             &lt;enumeration value="128299642.2"/>
 *             &lt;enumeration value="128299643.2"/>
 *             &lt;enumeration value="128299644.2"/>
 *             &lt;enumeration value="128299645.2"/>
 *             &lt;enumeration value="128299646.2"/>
 *             &lt;enumeration value="128299647.2"/>
 *             &lt;enumeration value="128299648.2"/>
 *             &lt;enumeration value="128299649.2"/>
 *             &lt;enumeration value="128299650.2"/>
 *             &lt;enumeration value="128299651.2"/>
 *             &lt;enumeration value="128299652.2"/>
 *             &lt;enumeration value="128299653.2"/>
 *             &lt;enumeration value="128299654.2"/>
 *             &lt;enumeration value="128299655.2"/>
 *             &lt;enumeration value="128299656.2"/>
 *             &lt;enumeration value="128299657.2"/>
 *             &lt;enumeration value="128299658.2"/>
 *             &lt;enumeration value="128299659.2"/>
 *             &lt;enumeration value="128299660.2"/>
 *             &lt;enumeration value="128299661.2"/>
 *             &lt;enumeration value="128299662.2"/>
 *             &lt;enumeration value="128299663.2"/>
 *             &lt;enumeration value="128299664.2"/>
 *             &lt;enumeration value="128299665.2"/>
 *             &lt;enumeration value="128299666.2"/>
 *             &lt;enumeration value="128299667.2"/>
 *             &lt;enumeration value="128299668.2"/>
 *             &lt;enumeration value="128299669.2"/>
 *             &lt;enumeration value="128299670.2"/>
 *             &lt;enumeration value="128299671.2"/>
 *             &lt;enumeration value="128299672.2"/>
 *             &lt;enumeration value="128299673.2"/>
 *             &lt;enumeration value="128299674.2"/>
 *             &lt;enumeration value="128299676.2"/>
 *             &lt;enumeration value="128299678.2"/>
 *             &lt;enumeration value="128300191.2"/>
 *             &lt;enumeration value="128300192.2"/>
 *             &lt;enumeration value="128300193.2"/>
 *             &lt;enumeration value="128300196.2"/>
 *             &lt;enumeration value="128300197.2"/>
 *             &lt;enumeration value="128300198.2"/>
 *             &lt;enumeration value="128300199.2"/>
 *             &lt;enumeration value="128300200.2"/>
 *             &lt;enumeration value="128300201.2"/>
 *             &lt;enumeration value="128300202.2"/>
 *             &lt;enumeration value="128300203.2"/>
 *             &lt;enumeration value="128300204.2"/>
 *             &lt;enumeration value="128300205.2"/>
 *             &lt;enumeration value="128300206.2"/>
 *             &lt;enumeration value="128300207.2"/>
 *             &lt;enumeration value="128300208.2"/>
 *             &lt;enumeration value="128300209.2"/>
 *             &lt;enumeration value="128300210.2"/>
 *             &lt;enumeration value="128300211.2"/>
 *             &lt;enumeration value="128300212.2"/>
 *             &lt;enumeration value="128300213.2"/>
 *             &lt;enumeration value="128300214.2"/>
 *             &lt;enumeration value="128300215.2"/>
 *             &lt;enumeration value="128300216.2"/>
 *             &lt;enumeration value="128300217.2"/>
 *             &lt;enumeration value="128300218.2"/>
 *             &lt;enumeration value="128300219.2"/>
 *             &lt;enumeration value="128300220.2"/>
 *             &lt;enumeration value="128300221.2"/>
 *             &lt;enumeration value="128300222.2"/>
 *             &lt;enumeration value="128300223.2"/>
 *             &lt;enumeration value="128300224.2"/>
 *             &lt;enumeration value="128300225.2"/>
 *             &lt;enumeration value="128300226.2"/>
 *             &lt;enumeration value="128300227.2"/>
 *             &lt;enumeration value="128300228.2"/>
 *             &lt;enumeration value="128300229.2"/>
 *             &lt;enumeration value="128300230.2"/>
 *             &lt;enumeration value="128300231.2"/>
 *             &lt;enumeration value="128300232.2"/>
 *             &lt;enumeration value="128300233.2"/>
 *             &lt;enumeration value="128300234.2"/>
 *             &lt;enumeration value="128300235.2"/>
 *             &lt;enumeration value="128300236.2"/>
 *             &lt;enumeration value="128300237.2"/>
 *             &lt;enumeration value="128300238.2"/>
 *             &lt;enumeration value="128300239.2"/>
 *             &lt;enumeration value="128300240.2"/>
 *             &lt;enumeration value="128300241.2"/>
 *             &lt;enumeration value="128300242.2"/>
 *             &lt;enumeration value="128300243.2"/>
 *             &lt;enumeration value="128300244.2"/>
 *             &lt;enumeration value="128300245.2"/>
 *             &lt;enumeration value="128300246.2"/>
 *             &lt;enumeration value="128300247.2"/>
 *             &lt;enumeration value="128300248.2"/>
 *             &lt;enumeration value="128300249.2"/>
 *             &lt;enumeration value="128300250.2"/>
 *             &lt;enumeration value="128300251.2"/>
 *             &lt;enumeration value="128300252.2"/>
 *             &lt;enumeration value="128300253.2"/>
 *             &lt;enumeration value="128300486.2"/>
 *             &lt;enumeration value="128300487.2"/>
 *             &lt;enumeration value="128300488.2"/>
 *             &lt;enumeration value="128300494.2"/>
 *             &lt;enumeration value="128300495.2"/>
 *             &lt;enumeration value="128300496.2"/>
 *             &lt;enumeration value="128300506.2"/>
 *             &lt;enumeration value="128300507.2"/>
 *             &lt;enumeration value="128300508.2"/>
 *             &lt;enumeration value="128300509.2"/>
 *             &lt;enumeration value="128300510.2"/>
 *             &lt;enumeration value="128300511.2"/>
 *             &lt;enumeration value="128300512.2"/>
 *             &lt;enumeration value="128300514.2"/>
 *             &lt;enumeration value="128300516.2"/>
 *             &lt;enumeration value="128300517.2"/>
 *             &lt;enumeration value="128300518.2"/>
 *             &lt;enumeration value="128300519.2"/>
 *             &lt;enumeration value="128300520.2"/>
 *             &lt;enumeration value="128300521.2"/>
 *             &lt;enumeration value="128300522.2"/>
 *             &lt;enumeration value="128300523.2"/>
 *             &lt;enumeration value="128300524.2"/>
 *             &lt;enumeration value="128300525.2"/>
 *             &lt;enumeration value="128300526.2"/>
 *             &lt;enumeration value="128300529.2"/>
 *             &lt;enumeration value="128300531.2"/>
 *             &lt;enumeration value="128300532.2"/>
 *             &lt;enumeration value="128300533.2"/>
 *             &lt;enumeration value="128300534.2"/>
 *             &lt;enumeration value="128300535.2"/>
 *             &lt;enumeration value="128300536.2"/>
 *             &lt;enumeration value="128300537.2"/>
 *             &lt;enumeration value="128300538.2"/>
 *             &lt;enumeration value="128300539.2"/>
 *             &lt;enumeration value="128300540.2"/>
 *             &lt;enumeration value="128300542.2"/>
 *             &lt;enumeration value="128300543.2"/>
 *             &lt;enumeration value="128300545.2"/>
 *             &lt;enumeration value="128300547.2"/>
 *             &lt;enumeration value="128300548.2"/>
 *             &lt;enumeration value="128300549.2"/>
 *             &lt;enumeration value="128300550.2"/>
 *             &lt;enumeration value="128300551.2"/>
 *             &lt;enumeration value="128300552.2"/>
 *             &lt;enumeration value="128300553.2"/>
 *             &lt;enumeration value="128300554.2"/>
 *             &lt;enumeration value="128300555.2"/>
 *             &lt;enumeration value="128300556.2"/>
 *             &lt;enumeration value="128300557.2"/>
 *             &lt;enumeration value="128300568.2"/>
 *             &lt;enumeration value="128300569.2"/>
 *             &lt;enumeration value="128300571.2"/>
 *             &lt;enumeration value="128300573.2"/>
 *             &lt;enumeration value="128300574.2"/>
 *             &lt;enumeration value="128300575.2"/>
 *             &lt;enumeration value="128300576.2"/>
 *             &lt;enumeration value="128300577.2"/>
 *             &lt;enumeration value="128300578.2"/>
 *             &lt;enumeration value="128300582.2"/>
 *             &lt;enumeration value="128300584.2"/>
 *             &lt;enumeration value="128300585.2"/>
 *             &lt;enumeration value="128300837.2"/>
 *             &lt;enumeration value="128300838.2"/>
 *             &lt;enumeration value="128300842.2"/>
 *             &lt;enumeration value="128300843.2"/>
 *             &lt;enumeration value="128300844.2"/>
 *             &lt;enumeration value="128300845.2"/>
 *             &lt;enumeration value="128300848.2"/>
 *             &lt;enumeration value="128300850.2"/>
 *             &lt;enumeration value="128300856.2"/>
 *             &lt;enumeration value="128300859.2"/>
 *             &lt;enumeration value="128300865.2"/>
 *             &lt;enumeration value="128300867.2"/>
 *             &lt;enumeration value="128300879.2"/>
 *             &lt;enumeration value="128300882.2"/>
 *             &lt;enumeration value="128300901.2"/>
 *             &lt;enumeration value="128300904.2"/>
 *             &lt;enumeration value="128300913.2"/>
 *             &lt;enumeration value="128300919.2"/>
 *             &lt;enumeration value="128300926.2"/>
 *             &lt;enumeration value="128300935.2"/>
 *             &lt;enumeration value="128300936.2"/>
 *             &lt;enumeration value="128300937.2"/>
 *             &lt;enumeration value="128300938.2"/>
 *             &lt;enumeration value="128300939.2"/>
 *             &lt;enumeration value="128300943.2"/>
 *             &lt;enumeration value="128300944.2"/>
 *             &lt;enumeration value="128300945.2"/>
 *             &lt;enumeration value="128300952.2"/>
 *             &lt;enumeration value="128300954.2"/>
 *             &lt;enumeration value="128300955.2"/>
 *             &lt;enumeration value="128300976.2"/>
 *             &lt;enumeration value="128300978.2"/>
 *             &lt;enumeration value="128301482.2"/>
 *             &lt;enumeration value="128301484.2"/>
 *             &lt;enumeration value="128301485.2"/>
 *             &lt;enumeration value="128301491.2"/>
 *             &lt;enumeration value="128301492.2"/>
 *             &lt;enumeration value="128301493.2"/>
 *             &lt;enumeration value="128301494.2"/>
 *             &lt;enumeration value="128301495.2"/>
 *             &lt;enumeration value="128301496.2"/>
 *             &lt;enumeration value="128301498.2"/>
 *             &lt;enumeration value="128301500.2"/>
 *             &lt;enumeration value="128301501.2"/>
 *             &lt;enumeration value="128301502.2"/>
 *             &lt;enumeration value="128301503.2"/>
 *             &lt;enumeration value="128301504.2"/>
 *             &lt;enumeration value="128301505.2"/>
 *             &lt;enumeration value="128301506.2"/>
 *             &lt;enumeration value="128301507.2"/>
 *             &lt;enumeration value="128301508.2"/>
 *             &lt;enumeration value="128301509.2"/>
 *             &lt;enumeration value="128301511.2"/>
 *             &lt;enumeration value="128301512.2"/>
 *             &lt;enumeration value="128301514.2"/>
 *             &lt;enumeration value="128301516.2"/>
 *             &lt;enumeration value="128301517.2"/>
 *             &lt;enumeration value="128301518.2"/>
 *             &lt;enumeration value="128301519.2"/>
 *             &lt;enumeration value="128301520.2"/>
 *             &lt;enumeration value="128301521.2"/>
 *             &lt;enumeration value="128301522.2"/>
 *             &lt;enumeration value="128301523.2"/>
 *             &lt;enumeration value="128301525.2"/>
 *             &lt;enumeration value="128301527.2"/>
 *             &lt;enumeration value="128301528.2"/>
 *             &lt;enumeration value="128301529.2"/>
 *             &lt;enumeration value="128301530.2"/>
 *             &lt;enumeration value="128301531.2"/>
 *             &lt;enumeration value="128301532.2"/>
 *             &lt;enumeration value="128301533.2"/>
 *             &lt;enumeration value="128301534.2"/>
 *             &lt;enumeration value="128301536.2"/>
 *             &lt;enumeration value="128301538.2"/>
 *             &lt;enumeration value="128301539.2"/>
 *             &lt;enumeration value="128301540.2"/>
 *             &lt;enumeration value="128301541.2"/>
 *             &lt;enumeration value="128301542.2"/>
 *             &lt;enumeration value="128301543.2"/>
 *             &lt;enumeration value="128301549.2"/>
 *             &lt;enumeration value="128301550.2"/>
 *             &lt;enumeration value="128301551.2"/>
 *             &lt;enumeration value="128301552.2"/>
 *             &lt;enumeration value="128301553.2"/>
 *             &lt;enumeration value="128301554.2"/>
 *             &lt;enumeration value="128301555.2"/>
 *             &lt;enumeration value="128301556.2"/>
 *             &lt;enumeration value="128301557.2"/>
 *             &lt;enumeration value="128301558.2"/>
 *             &lt;enumeration value="128301559.2"/>
 *             &lt;enumeration value="128301560.2"/>
 *             &lt;enumeration value="128301561.2"/>
 *             &lt;enumeration value="128301562.2"/>
 *             &lt;enumeration value="128302048.2"/>
 *             &lt;enumeration value="128302049.2"/>
 *             &lt;enumeration value="128302050.2"/>
 *             &lt;enumeration value="128302053.2"/>
 *             &lt;enumeration value="128302054.2"/>
 *             &lt;enumeration value="128302055.2"/>
 *             &lt;enumeration value="128302056.2"/>
 *             &lt;enumeration value="128302057.2"/>
 *             &lt;enumeration value="128302058.2"/>
 *             &lt;enumeration value="128302059.2"/>
 *             &lt;enumeration value="128302060.2"/>
 *             &lt;enumeration value="128302061.2"/>
 *             &lt;enumeration value="128302062.2"/>
 *             &lt;enumeration value="128302063.2"/>
 *             &lt;enumeration value="128302064.2"/>
 *             &lt;enumeration value="128302065.2"/>
 *             &lt;enumeration value="128302066.2"/>
 *             &lt;enumeration value="128302067.2"/>
 *             &lt;enumeration value="128302068.2"/>
 *             &lt;enumeration value="128302069.2"/>
 *             &lt;enumeration value="128302070.2"/>
 *             &lt;enumeration value="128302072.2"/>
 *             &lt;enumeration value="128302074.2"/>
 *             &lt;enumeration value="128302076.2"/>
 *             &lt;enumeration value="128302078.2"/>
 *             &lt;enumeration value="128302079.2"/>
 *             &lt;enumeration value="128302081.2"/>
 *             &lt;enumeration value="128302083.2"/>
 *             &lt;enumeration value="128302085.2"/>
 *             &lt;enumeration value="128302087.2"/>
 *             &lt;enumeration value="128302089.2"/>
 *             &lt;enumeration value="128302090.2"/>
 *             &lt;enumeration value="128302091.2"/>
 *             &lt;enumeration value="128302092.2"/>
 *             &lt;enumeration value="128302093.2"/>
 *             &lt;enumeration value="128302094.2"/>
 *             &lt;enumeration value="128302095.2"/>
 *             &lt;enumeration value="128302096.2"/>
 *             &lt;enumeration value="128302097.2"/>
 *             &lt;enumeration value="128302098.2"/>
 *             &lt;enumeration value="128302099.2"/>
 *             &lt;enumeration value="128302101.2"/>
 *             &lt;enumeration value="128302103.2"/>
 *             &lt;enumeration value="128302105.2"/>
 *             &lt;enumeration value="128302106.2"/>
 *             &lt;enumeration value="128302107.2"/>
 *             &lt;enumeration value="128302108.2"/>
 *             &lt;enumeration value="128302113.2"/>
 *             &lt;enumeration value="128302114.2"/>
 *             &lt;enumeration value="128302115.2"/>
 *             &lt;enumeration value="128302116.2"/>
 *             &lt;enumeration value="128302117.2"/>
 *             &lt;enumeration value="128302118.2"/>
 *             &lt;enumeration value="128302119.2"/>
 *             &lt;enumeration value="128302120.2"/>
 *             &lt;enumeration value="128302121.2"/>
 *             &lt;enumeration value="128302122.2"/>
 *             &lt;enumeration value="128302123.2"/>
 *             &lt;enumeration value="128302124.2"/>
 *             &lt;enumeration value="128302125.2"/>
 *             &lt;enumeration value="128302126.2"/>
 *             &lt;enumeration value="128302561.2"/>
 *             &lt;enumeration value="128302562.2"/>
 *             &lt;enumeration value="128302563.2"/>
 *             &lt;enumeration value="128302574.2"/>
 *             &lt;enumeration value="128302576.2"/>
 *             &lt;enumeration value="128302577.2"/>
 *             &lt;enumeration value="128302578.2"/>
 *             &lt;enumeration value="128302579.2"/>
 *             &lt;enumeration value="128302580.2"/>
 *             &lt;enumeration value="128302589.2"/>
 *             &lt;enumeration value="128302590.2"/>
 *             &lt;enumeration value="128302591.2"/>
 *             &lt;enumeration value="128302596.2"/>
 *             &lt;enumeration value="128302599.2"/>
 *             &lt;enumeration value="128302600.2"/>
 *             &lt;enumeration value="128302601.2"/>
 *             &lt;enumeration value="128302602.2"/>
 *             &lt;enumeration value="128302603.2"/>
 *             &lt;enumeration value="128302604.2"/>
 *             &lt;enumeration value="128302605.2"/>
 *             &lt;enumeration value="128302606.2"/>
 *             &lt;enumeration value="128302607.2"/>
 *             &lt;enumeration value="128302608.2"/>
 *             &lt;enumeration value="128302609.2"/>
 *             &lt;enumeration value="128302610.2"/>
 *             &lt;enumeration value="128302611.2"/>
 *             &lt;enumeration value="128302612.2"/>
 *             &lt;enumeration value="128302613.2"/>
 *             &lt;enumeration value="128302614.2"/>
 *             &lt;enumeration value="128302615.2"/>
 *             &lt;enumeration value="128302616.2"/>
 *             &lt;enumeration value="128302617.2"/>
 *             &lt;enumeration value="128302618.2"/>
 *             &lt;enumeration value="128302619.2"/>
 *             &lt;enumeration value="128302620.2"/>
 *             &lt;enumeration value="128302621.2"/>
 *             &lt;enumeration value="128302622.2"/>
 *             &lt;enumeration value="128302623.2"/>
 *             &lt;enumeration value="128302624.2"/>
 *             &lt;enumeration value="128302625.2"/>
 *             &lt;enumeration value="128302626.2"/>
 *             &lt;enumeration value="128302627.2"/>
 *             &lt;enumeration value="128302628.2"/>
 *             &lt;enumeration value="128302629.2"/>
 *             &lt;enumeration value="128302630.2"/>
 *             &lt;enumeration value="128302631.2"/>
 *             &lt;enumeration value="128302632.2"/>
 *             &lt;enumeration value="128302633.2"/>
 *             &lt;enumeration value="128302634.2"/>
 *             &lt;enumeration value="128302635.2"/>
 *             &lt;enumeration value="128302636.2"/>
 *             &lt;enumeration value="128302637.2"/>
 *             &lt;enumeration value="128302638.2"/>
 *             &lt;enumeration value="128302639.2"/>
 *             &lt;enumeration value="128302640.2"/>
 *             &lt;enumeration value="128302641.2"/>
 *             &lt;enumeration value="128302642.2"/>
 *             &lt;enumeration value="128302643.2"/>
 *             &lt;enumeration value="128302644.2"/>
 *             &lt;enumeration value="128302645.2"/>
 *             &lt;enumeration value="128302646.2"/>
 *             &lt;enumeration value="128302647.2"/>
 *             &lt;enumeration value="128302648.2"/>
 *             &lt;enumeration value="128302649.2"/>
 *             &lt;enumeration value="128302650.2"/>
 *             &lt;enumeration value="128302858.2"/>
 *             &lt;enumeration value="128302859.2"/>
 *             &lt;enumeration value="128302860.2"/>
 *             &lt;enumeration value="128302861.2"/>
 *             &lt;enumeration value="128302862.2"/>
 *             &lt;enumeration value="128302863.2"/>
 *             &lt;enumeration value="128302864.2"/>
 *             &lt;enumeration value="128302865.2"/>
 *             &lt;enumeration value="128302866.2"/>
 *             &lt;enumeration value="128302867.2"/>
 *             &lt;enumeration value="128302868.2"/>
 *             &lt;enumeration value="128302869.2"/>
 *             &lt;enumeration value="128302870.2"/>
 *             &lt;enumeration value="128302871.2"/>
 *             &lt;enumeration value="128302874.2"/>
 *             &lt;enumeration value="128302875.2"/>
 *             &lt;enumeration value="128302876.2"/>
 *             &lt;enumeration value="128302877.2"/>
 *             &lt;enumeration value="128302878.2"/>
 *             &lt;enumeration value="128302879.2"/>
 *             &lt;enumeration value="128302880.2"/>
 *             &lt;enumeration value="128302881.2"/>
 *             &lt;enumeration value="128302883.2"/>
 *             &lt;enumeration value="128302884.2"/>
 *             &lt;enumeration value="128302885.2"/>
 *             &lt;enumeration value="128302886.2"/>
 *             &lt;enumeration value="128302887.2"/>
 *             &lt;enumeration value="128302891.2"/>
 *             &lt;enumeration value="128302892.2"/>
 *             &lt;enumeration value="128302893.2"/>
 *             &lt;enumeration value="128302900.2"/>
 *             &lt;enumeration value="128302901.2"/>
 *             &lt;enumeration value="128303049.2"/>
 *             &lt;enumeration value="128303050.2"/>
 *             &lt;enumeration value="128303051.2"/>
 *             &lt;enumeration value="128303054.2"/>
 *             &lt;enumeration value="128303055.2"/>
 *             &lt;enumeration value="128303056.2"/>
 *             &lt;enumeration value="128303057.2"/>
 *             &lt;enumeration value="128303058.2"/>
 *             &lt;enumeration value="128303059.2"/>
 *             &lt;enumeration value="128303063.2"/>
 *             &lt;enumeration value="128303064.2"/>
 *             &lt;enumeration value="128303065.2"/>
 *             &lt;enumeration value="128303066.2"/>
 *             &lt;enumeration value="128303067.2"/>
 *             &lt;enumeration value="128303068.2"/>
 *             &lt;enumeration value="128303069.2"/>
 *             &lt;enumeration value="128303070.2"/>
 *             &lt;enumeration value="128303071.2"/>
 *             &lt;enumeration value="128303072.2"/>
 *             &lt;enumeration value="128303073.2"/>
 *             &lt;enumeration value="128303074.2"/>
 *             &lt;enumeration value="128303075.2"/>
 *             &lt;enumeration value="128303076.2"/>
 *             &lt;enumeration value="128303077.2"/>
 *             &lt;enumeration value="128303078.2"/>
 *             &lt;enumeration value="128303079.2"/>
 *             &lt;enumeration value="128303080.2"/>
 *             &lt;enumeration value="128303081.2"/>
 *             &lt;enumeration value="128303082.2"/>
 *             &lt;enumeration value="128303083.2"/>
 *             &lt;enumeration value="128303084.2"/>
 *             &lt;enumeration value="128303085.2"/>
 *             &lt;enumeration value="128303086.2"/>
 *             &lt;enumeration value="128303087.2"/>
 *             &lt;enumeration value="128303088.2"/>
 *             &lt;enumeration value="128303089.2"/>
 *             &lt;enumeration value="128303090.2"/>
 *             &lt;enumeration value="128303091.2"/>
 *             &lt;enumeration value="128303092.2"/>
 *             &lt;enumeration value="128303093.2"/>
 *             &lt;enumeration value="128303094.2"/>
 *             &lt;enumeration value="128303095.2"/>
 *             &lt;enumeration value="128303096.2"/>
 *             &lt;enumeration value="128303097.2"/>
 *             &lt;enumeration value="128303098.2"/>
 *             &lt;enumeration value="128303099.2"/>
 *             &lt;enumeration value="128303100.2"/>
 *             &lt;enumeration value="128303101.2"/>
 *             &lt;enumeration value="128303102.2"/>
 *             &lt;enumeration value="128303103.2"/>
 *             &lt;enumeration value="128303104.2"/>
 *             &lt;enumeration value="128303105.2"/>
 *             &lt;enumeration value="128303106.2"/>
 *             &lt;enumeration value="128303129.2"/>
 *             &lt;enumeration value="128303132.2"/>
 *             &lt;enumeration value="128303134.2"/>
 *             &lt;enumeration value="128303136.2"/>
 *             &lt;enumeration value="128303138.2"/>
 *             &lt;enumeration value="128303141.2"/>
 *             &lt;enumeration value="128303143.2"/>
 *             &lt;enumeration value="128303144.2"/>
 *             &lt;enumeration value="128303146.2"/>
 *             &lt;enumeration value="128303161.2"/>
 *             &lt;enumeration value="128303162.2"/>
 *             &lt;enumeration value="128303164.2"/>
 *             &lt;enumeration value="128303379.2"/>
 *             &lt;enumeration value="128303380.2"/>
 *             &lt;enumeration value="128303381.2"/>
 *             &lt;enumeration value="128303382.2"/>
 *             &lt;enumeration value="128303383.2"/>
 *             &lt;enumeration value="128303384.2"/>
 *             &lt;enumeration value="128303385.2"/>
 *             &lt;enumeration value="128303386.2"/>
 *             &lt;enumeration value="128303387.2"/>
 *             &lt;enumeration value="128303388.2"/>
 *             &lt;enumeration value="128303389.2"/>
 *             &lt;enumeration value="128303390.2"/>
 *             &lt;enumeration value="128303391.2"/>
 *             &lt;enumeration value="128303392.2"/>
 *             &lt;enumeration value="128303395.2"/>
 *             &lt;enumeration value="128303396.2"/>
 *             &lt;enumeration value="128303397.2"/>
 *             &lt;enumeration value="128303398.2"/>
 *             &lt;enumeration value="128303399.2"/>
 *             &lt;enumeration value="128303400.2"/>
 *             &lt;enumeration value="128303401.2"/>
 *             &lt;enumeration value="128303402.2"/>
 *             &lt;enumeration value="128303403.2"/>
 *             &lt;enumeration value="128303404.2"/>
 *             &lt;enumeration value="128303405.2"/>
 *             &lt;enumeration value="128303406.2"/>
 *             &lt;enumeration value="128303407.2"/>
 *             &lt;enumeration value="128303411.2"/>
 *             &lt;enumeration value="128303412.2"/>
 *             &lt;enumeration value="128303413.2"/>
 *             &lt;enumeration value="128303420.2"/>
 *             &lt;enumeration value="128303421.2"/>
 *             &lt;enumeration value="128303902.2"/>
 *             &lt;enumeration value="128303903.2"/>
 *             &lt;enumeration value="128303904.2"/>
 *             &lt;enumeration value="128303913.2"/>
 *             &lt;enumeration value="128303914.2"/>
 *             &lt;enumeration value="128303915.2"/>
 *             &lt;enumeration value="128303916.2"/>
 *             &lt;enumeration value="128303917.2"/>
 *             &lt;enumeration value="128303918.2"/>
 *             &lt;enumeration value="128303920.2"/>
 *             &lt;enumeration value="128303922.2"/>
 *             &lt;enumeration value="128303923.2"/>
 *             &lt;enumeration value="128303924.2"/>
 *             &lt;enumeration value="128303925.2"/>
 *             &lt;enumeration value="128303926.2"/>
 *             &lt;enumeration value="128303927.2"/>
 *             &lt;enumeration value="128303928.2"/>
 *             &lt;enumeration value="128303929.2"/>
 *             &lt;enumeration value="128303930.2"/>
 *             &lt;enumeration value="128303932.2"/>
 *             &lt;enumeration value="128303934.2"/>
 *             &lt;enumeration value="128303935.2"/>
 *             &lt;enumeration value="128303936.2"/>
 *             &lt;enumeration value="128303937.2"/>
 *             &lt;enumeration value="128303938.2"/>
 *             &lt;enumeration value="128303939.2"/>
 *             &lt;enumeration value="128303940.2"/>
 *             &lt;enumeration value="128303941.2"/>
 *             &lt;enumeration value="128303942.2"/>
 *             &lt;enumeration value="128303943.2"/>
 *             &lt;enumeration value="128303944.2"/>
 *             &lt;enumeration value="128303945.2"/>
 *             &lt;enumeration value="128303947.2"/>
 *             &lt;enumeration value="128303949.2"/>
 *             &lt;enumeration value="128303950.2"/>
 *             &lt;enumeration value="128303951.2"/>
 *             &lt;enumeration value="128303952.2"/>
 *             &lt;enumeration value="128303953.2"/>
 *             &lt;enumeration value="128303954.2"/>
 *             &lt;enumeration value="128303955.2"/>
 *             &lt;enumeration value="128303956.2"/>
 *             &lt;enumeration value="128303958.2"/>
 *             &lt;enumeration value="128303962.2"/>
 *             &lt;enumeration value="128303963.2"/>
 *             &lt;enumeration value="128303964.2"/>
 *             &lt;enumeration value="128303965.2"/>
 *             &lt;enumeration value="128303966.2"/>
 *             &lt;enumeration value="128303976.2"/>
 *             &lt;enumeration value="128303978.2"/>
 *             &lt;enumeration value="128303979.2"/>
 *             &lt;enumeration value="128303980.2"/>
 *             &lt;enumeration value="128303981.2"/>
 *             &lt;enumeration value="128303982.2"/>
 *             &lt;enumeration value="128303983.2"/>
 *             &lt;enumeration value="128303985.2"/>
 *             &lt;enumeration value="128303986.2"/>
 *             &lt;enumeration value="128303997.2"/>
 *             &lt;enumeration value="128303998.2"/>
 *             &lt;enumeration value="128304000.2"/>
 *             &lt;enumeration value="128304003.2"/>
 *             &lt;enumeration value="128304005.2"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *       &lt;attribute name="handicap-id">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal">
 *             &lt;enumeration value="3454443.2"/>
 *             &lt;enumeration value="3454444.2"/>
 *             &lt;enumeration value="3454445.2"/>
 *             &lt;enumeration value="3454460.2"/>
 *             &lt;enumeration value="3454461.2"/>
 *             &lt;enumeration value="3454462.2"/>
 *             &lt;enumeration value="3454465.2"/>
 *             &lt;enumeration value="3454466.2"/>
 *             &lt;enumeration value="3454467.2"/>
 *             &lt;enumeration value="3457160.2"/>
 *             &lt;enumeration value="3457161.2"/>
 *             &lt;enumeration value="3457162.2"/>
 *             &lt;enumeration value="3457163.2"/>
 *             &lt;enumeration value="3457164.2"/>
 *             &lt;enumeration value="3457165.2"/>
 *             &lt;enumeration value="3457166.2"/>
 *             &lt;enumeration value="3457167.2"/>
 *             &lt;enumeration value="3457168.2"/>
 *             &lt;enumeration value="3457169.2"/>
 *             &lt;enumeration value="3457170.2"/>
 *             &lt;enumeration value="3457171.2"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *       &lt;attribute name="handicap">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}byte">
 *             &lt;enumeration value="-1"/>
 *             &lt;enumeration value="1"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *       &lt;attribute name="had-value">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *             &lt;enumeration value="AWAY"/>
 *             &lt;enumeration value="DRAW"/>
 *             &lt;enumeration value="HOME"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *       &lt;attribute name="active-price-types" use="required">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *             &lt;enumeration value="CP"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
@XmlRootElement(name = "bet")
public class Bet {

    @XmlAttribute(name = "short-name", required = true)
    protected String shortName;
    @XmlAttribute(name = "priceUS", required = true)
    protected BigDecimal priceUS;
    @XmlAttribute(name = "priceDecimal", required = true)
    protected BigDecimal priceDecimal;
    @XmlAttribute(name = "price", required = true)
    protected String price;
    @XmlAttribute(name = "name", required = true)
    protected String name;
    @XmlAttribute(name = "id", required = true)
    protected BigDecimal id;
    @XmlAttribute(name = "handicap-id")
    protected BigDecimal handicapId;
    @XmlAttribute(name = "handicap")
    protected String handicap;
    @XmlAttribute(name = "had-value")
    protected String hadValue;
    @XmlAttribute(name = "active-price-types", required = true)
    protected String activePriceTypes;

    /**
     * Obtiene el valor de la propiedad shortName.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getShortName() {
        return shortName;
    }

    /**
     * Define el valor de la propiedad shortName.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setShortName(String value) {
        this.shortName = value;
    }

    /**
     * Obtiene el valor de la propiedad priceUS.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getPriceUS() {
        return priceUS;
    }

    /**
     * Define el valor de la propiedad priceUS.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setPriceUS(BigDecimal value) {
        this.priceUS = value;
    }

    /**
     * Obtiene el valor de la propiedad priceDecimal.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getPriceDecimal() {
        return priceDecimal;
    }

    /**
     * Define el valor de la propiedad priceDecimal.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setPriceDecimal(BigDecimal value) {
        this.priceDecimal = value;
    }

    /**
     * Obtiene el valor de la propiedad price.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPrice() {
        return price;
    }

    /**
     * Define el valor de la propiedad price.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPrice(String value) {
        this.price = value;
    }

    /**
     * Obtiene el valor de la propiedad name.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Define el valor de la propiedad name.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Obtiene el valor de la propiedad id.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getId() {
        return id;
    }

    /**
     * Define el valor de la propiedad id.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setId(BigDecimal value) {
        this.id = value;
    }

    /**
     * Obtiene el valor de la propiedad handicapId.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getHandicapId() {
        return handicapId;
    }

    /**
     * Define el valor de la propiedad handicapId.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setHandicapId(BigDecimal value) {
        this.handicapId = value;
    }

    /**
     * Obtiene el valor de la propiedad handicap.
     * 
     * @return
     *     possible object is
     *     {@link Byte }
     *     
     */
    public String getHandicap() {
        return handicap;
    }

    /**
     * Define el valor de la propiedad handicap.
     * 
     * @param value
     *     allowed object is
     *     {@link Byte }
     *     
     */
    public void setHandicap(String value) {
        this.handicap = value;
    }

    /**
     * Obtiene el valor de la propiedad hadValue.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHadValue() {
        return hadValue;
    }

    /**
     * Define el valor de la propiedad hadValue.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHadValue(String value) {
        this.hadValue = value;
    }

    /**
     * Obtiene el valor de la propiedad activePriceTypes.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getActivePriceTypes() {
        return activePriceTypes;
    }

    /**
     * Define el valor de la propiedad activePriceTypes.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setActivePriceTypes(String value) {
        this.activePriceTypes = value;
    }

}

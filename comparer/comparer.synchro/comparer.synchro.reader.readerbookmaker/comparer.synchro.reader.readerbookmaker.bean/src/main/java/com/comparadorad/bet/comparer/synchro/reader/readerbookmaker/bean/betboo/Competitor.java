//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantación de la referencia de enlace (JAXB) XML v2.2.6 
// Visite <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: AM.06.03 a las 11:12:51 AM CEST 
//


package com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.bean.betboo;

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
 *       &lt;attribute name="Team" use="required">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *             &lt;enumeration value="Adrian Sutil (Force India)"/>
 *             &lt;enumeration value="Brazil"/>
 *             &lt;enumeration value="Charles Pic (Caterham)"/>
 *             &lt;enumeration value="Daniel Ricciardo (Toro Rosso)"/>
 *             &lt;enumeration value="England U21"/>
 *             &lt;enumeration value="Esteban Gutierrez (Sauber)"/>
 *             &lt;enumeration value="Felipe Massa (Ferrari)"/>
 *             &lt;enumeration value="Fernando Alonso (Ferrari)"/>
 *             &lt;enumeration value="Germany U21"/>
 *             &lt;enumeration value="Giedo Van der Garde (Caterham)"/>
 *             &lt;enumeration value="Holland U21"/>
 *             &lt;enumeration value="Israel U21"/>
 *             &lt;enumeration value="Italy"/>
 *             &lt;enumeration value="Italy U21"/>
 *             &lt;enumeration value="Japan"/>
 *             &lt;enumeration value="Jean-Eric Vergne (Toro Rosso)"/>
 *             &lt;enumeration value="Jenson Button (McLaren)"/>
 *             &lt;enumeration value="Jules Bianchi (Marussia)"/>
 *             &lt;enumeration value="Kimi Raikkonen (Lotus)"/>
 *             &lt;enumeration value="Lewis Hamilton (Mercedes)"/>
 *             &lt;enumeration value="Mark Webber (Red Bull)"/>
 *             &lt;enumeration value="Max Chilton (Marussia)"/>
 *             &lt;enumeration value="Mexico"/>
 *             &lt;enumeration value="Nico Hulkenberg (Sauber)"/>
 *             &lt;enumeration value="Nico Rosberg (Mercedes)"/>
 *             &lt;enumeration value="Nigeria"/>
 *             &lt;enumeration value="Norway U21"/>
 *             &lt;enumeration value="Pastor Maldonado (Williams)"/>
 *             &lt;enumeration value="Paul di Resta (Force India)"/>
 *             &lt;enumeration value="Romain Grosjean (Lotus)"/>
 *             &lt;enumeration value="Russia U21"/>
 *             &lt;enumeration value="Sebastian Vettel (Red Bull)"/>
 *             &lt;enumeration value="Sergio Perez (McLaren)"/>
 *             &lt;enumeration value="Spain"/>
 *             &lt;enumeration value="Spain U21"/>
 *             &lt;enumeration value="Tahiti"/>
 *             &lt;enumeration value="Uruguay"/>
 *             &lt;enumeration value="Valtteri Bottas (Williams)"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *       &lt;attribute name="Odds" use="required">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal">
 *             &lt;enumeration value="1.25"/>
 *             &lt;enumeration value="1.35"/>
 *             &lt;enumeration value="1.42"/>
 *             &lt;enumeration value="1.55"/>
 *             &lt;enumeration value="1.62"/>
 *             &lt;enumeration value="10.0"/>
 *             &lt;enumeration value="100.0"/>
 *             &lt;enumeration value="12.0"/>
 *             &lt;enumeration value="15.0"/>
 *             &lt;enumeration value="2.15"/>
 *             &lt;enumeration value="2.2"/>
 *             &lt;enumeration value="2.9"/>
 *             &lt;enumeration value="250.0"/>
 *             &lt;enumeration value="3.2"/>
 *             &lt;enumeration value="3.75"/>
 *             &lt;enumeration value="3.9"/>
 *             &lt;enumeration value="32.0"/>
 *             &lt;enumeration value="4.3"/>
 *             &lt;enumeration value="4.5"/>
 *             &lt;enumeration value="5.0"/>
 *             &lt;enumeration value="50.0"/>
 *             &lt;enumeration value="500.0"/>
 *             &lt;enumeration value="6.0"/>
 *             &lt;enumeration value="65.0"/>
 *             &lt;enumeration value="7.0"/>
 *             &lt;enumeration value="8.0"/>
 *             &lt;enumeration value="80.0"/>
 *             &lt;enumeration value="950.0"/>
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
@XmlRootElement(name = "Competitor")
public class Competitor {

    @XmlAttribute(name = "Team", required = true)
    protected String team;
    @XmlAttribute(name = "Odds", required = true)
    protected BigDecimal odds;

    /**
     * Obtiene el valor de la propiedad team.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTeam() {
        return team;
    }

    /**
     * Define el valor de la propiedad team.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTeam(String value) {
        this.team = value;
    }

    /**
     * Obtiene el valor de la propiedad odds.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getOdds() {
        return odds;
    }

    /**
     * Define el valor de la propiedad odds.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setOdds(BigDecimal value) {
        this.odds = value;
    }

}

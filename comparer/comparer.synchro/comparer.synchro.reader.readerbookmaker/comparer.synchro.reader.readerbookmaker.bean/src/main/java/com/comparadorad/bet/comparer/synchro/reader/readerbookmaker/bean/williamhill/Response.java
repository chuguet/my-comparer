//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2012.12.11 at 05:21:53 PM CET 
//


package com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.bean.williamhill;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{}williamhill"/>
 *       &lt;/sequence>
 *       &lt;attribute name="request" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="message" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="debug" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="code" use="required" type="{http://www.w3.org/2001/XMLSchema}byte" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "williamhill"
})
@XmlRootElement(name = "response")
public class Response {

    @XmlElement(required = true)
    protected Williamhill williamhill;
    @XmlAttribute(name = "request", required = true)
    protected String request;
    @XmlAttribute(name = "message", required = true)
    protected String message;
    @XmlAttribute(name = "debug", required = true)
    protected String debug;
    @XmlAttribute(name = "code", required = true)
    protected byte code;

    /**
     * Gets the value of the williamhill property.
     * 
     * @return
     *     possible object is
     *     {@link Williamhill }
     *     
     */
    public Williamhill getWilliamhill() {
        return williamhill;
    }

    /**
     * Sets the value of the williamhill property.
     * 
     * @param value
     *     allowed object is
     *     {@link Williamhill }
     *     
     */
    public void setWilliamhill(Williamhill value) {
        this.williamhill = value;
    }

    /**
     * Gets the value of the request property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRequest() {
        return request;
    }

    /**
     * Sets the value of the request property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRequest(String value) {
        this.request = value;
    }

    /**
     * Gets the value of the message property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMessage() {
        return message;
    }

    /**
     * Sets the value of the message property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMessage(String value) {
        this.message = value;
    }

    /**
     * Gets the value of the debug property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDebug() {
        return debug;
    }

    /**
     * Sets the value of the debug property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDebug(String value) {
        this.debug = value;
    }

    /**
     * Gets the value of the code property.
     * 
     */
    public byte getCode() {
        return code;
    }

    /**
     * Sets the value of the code property.
     * 
     */
    public void setCode(byte value) {
        this.code = value;
    }

}

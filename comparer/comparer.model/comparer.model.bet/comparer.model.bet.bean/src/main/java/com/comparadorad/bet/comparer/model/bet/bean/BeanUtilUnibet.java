package com.comparadorad.bet.comparer.model.bet.bean;

import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.io.IOUtils;
import org.apache.commons.io.input.CloseShieldInputStream;
import org.codehaus.jackson.JsonNode;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.mongodb.Bytes;

@Component
@Scope("singleton")
public class BeanUtilUnibet {

	private JsonNode ficheroPadre;

	public JsonNode getFicheroPadre() {
		return ficheroPadre;
	}

	public void setFicheroPadre(JsonNode ficheroPadre) throws IOException {
		this.ficheroPadre = ficheroPadre;
	}
	
}

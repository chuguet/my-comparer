package com.comparadorad.bet.comparer.communication.email.build;

import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.junit.Test;

import com.comparadorad.bet.comparer.communication.email.AbstractTest;
import com.comparadorad.bet.comparer.communication.email.beans.ValueBetTo;
import com.comparadorad.bet.comparer.communication.email.exception.BuildEmailException;

public class BuildValueBetsEmailTest extends AbstractTest {

	@SuppressWarnings("rawtypes")
	@Inject
	private BuildValueBetsEmail betsEmail;

	@SuppressWarnings("unchecked")
	@Test
	public final void test() throws BuildEmailException {
		List<ValueBetTo> valuetBetTos = new ArrayList<ValueBetTo>();
		valuetBetTos.add(new ValueBetTo("evento 1", "Tipo de apuesta 1", "GANADOR_1", "BOOKMAKER_1", 0f, 0f, 0f));
		valuetBetTos.add(new ValueBetTo("evento 2", "Tipo de apuesta 2", "GANADOR_2", "BOOKMAKER_2", 1f, 1f, 1f));
		valuetBetTos.add(new ValueBetTo("evento 3", "Tipo de apuesta 3", "GANADOR_3", "BOOKMAKER_3", 2f, 2f, 2f));
		assertNotNull(betsEmail);
		assertNotNull(betsEmail.makeMail(valuetBetTos));
	}

}

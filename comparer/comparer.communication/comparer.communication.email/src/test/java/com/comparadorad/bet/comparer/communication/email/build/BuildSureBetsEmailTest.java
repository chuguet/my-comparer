package com.comparadorad.bet.comparer.communication.email.build;

import javax.inject.Inject;

import org.junit.Test;

import com.comparadorad.bet.comparer.communication.email.AbstractTest;
import com.comparadorad.bet.comparer.communication.email.exception.BuildEmailException;

public class BuildSureBetsEmailTest extends AbstractTest {
	
	@SuppressWarnings("rawtypes")
	@Inject
	private BuildSureBetsEmail betsEmail;
	
	@Test
	public final void test() throws BuildEmailException {
		
//		List<SureBetTo> sureBetTos = new ArrayList<SureBetTo>();
//		sureBetTos.add(new SureBetTo("evento 1", "Tipo de apuesta 1", "GANADOR_1", "BOOKMAKER_1", 0f, 0f, 0f));
//		sureBetTos.add(new SureBetTo("evento 2", "Tipo de apuesta 2", "GANADOR_2", "BOOKMAKER_2", 1f, 1f, 1f));
//		sureBetTos.add(new SureBetTo("evento 3", "Tipo de apuesta 3", "GANADOR_3", "BOOKMAKER_3", 2f, 2f, 2f));
//		assertNotNull(betsEmail);
//		assertNotNull(betsEmail.makeMail(sureBetTos));
		
	}

}

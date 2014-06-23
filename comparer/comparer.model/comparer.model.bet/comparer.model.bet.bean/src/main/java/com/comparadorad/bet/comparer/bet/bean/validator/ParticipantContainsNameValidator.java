package com.comparadorad.bet.comparer.bet.bean.validator;

import java.util.Set;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.comparadorad.bet.comparer.model.bet.bean.RtParticipant;

public class ParticipantContainsNameValidator implements
		ConstraintValidator<AllContainsName, Set<RtParticipant>> {

	@Override
	public void initialize(AllContainsName constraintAnnotation) {
		// nothing to do
	}

	@Override
	public boolean isValid(Set<RtParticipant> participants,
			ConstraintValidatorContext context) {
		boolean result = true;
		for (RtParticipant participant : participants) {
			if (participant.getCfgParticipant() == null) {
				result = false;
				break;
			}
		}
		return result;
	}

}

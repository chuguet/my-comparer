package com.comparadorad.bet.comparer.model.securebet.validator;

import javax.inject.Inject;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.comparadorad.bet.comparer.model.bet.service.IRtMatchService;
import com.comparadorad.bet.comparer.model.securebet.bean.InfoMatch;

public class MatchValidatorExistBD implements
		ConstraintValidator<MatchExistInBD, InfoMatch> {

	@Inject
	private IRtMatchService matchService;

	@Override
	public void initialize(MatchExistInBD constraintAnnotation) {
		// nothing to do
	}

	@Override
	public boolean isValid(InfoMatch infoMatch,
			ConstraintValidatorContext context) {
		return matchService.exists(infoMatch.getObjectId());
	}
}

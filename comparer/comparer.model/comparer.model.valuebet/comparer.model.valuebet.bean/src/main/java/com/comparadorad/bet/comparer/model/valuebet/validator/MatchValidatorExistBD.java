package com.comparadorad.bet.comparer.model.valuebet.validator;

import javax.inject.Inject;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.comparadorad.bet.comparer.model.bet.service.IRtMatchService;
import com.comparadorad.bet.comparer.model.valuebet.bean.InfoMatch;

public class MatchValidatorExistBD implements
		ConstraintValidator<MatchExistInBD, InfoMatch> {

	@Inject
	private IRtMatchService matchService;

	@Override
	public void initialize(MatchExistInBD constraintAnnotation) {
		// nothing to do
	}

	@Override
	public boolean isValid(InfoMatch value, ConstraintValidatorContext context) {
		return matchService.existsCustom(value.getObjectId().toString());
	}

}

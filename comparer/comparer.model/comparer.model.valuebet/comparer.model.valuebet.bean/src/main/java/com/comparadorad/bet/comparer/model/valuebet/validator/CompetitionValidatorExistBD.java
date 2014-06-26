package com.comparadorad.bet.comparer.model.valuebet.validator;

import javax.inject.Inject;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.comparadorad.bet.comparer.model.config.bean.CfgCompetition;
import com.comparadorad.bet.comparer.model.repository.CfgCompetitionRepository;

public class CompetitionValidatorExistBD implements
		ConstraintValidator<MatchExistInBD, CfgCompetition> {
	@Inject
	private CfgCompetitionRepository competitionRepository;

	@Override
	public void initialize(MatchExistInBD constraintAnnotation) {
		// nothing to do
	}

	@Override
	public boolean isValid(CfgCompetition competition,
			ConstraintValidatorContext context) {
		return competitionRepository.exists(competition.getObjectId());
	}

}

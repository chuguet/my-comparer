package com.comparadorad.bet.comparer.model.activator.service;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.comparadorad.bet.comparer.util.commons.profile.ProfileConstant;

@Component
@Scope("singleton")
final class TestActivatorMatch extends AbstractActivatorMatch {

	@Override
	public String getEnviroment() {
		return ProfileConstant.TEST;
	}

}

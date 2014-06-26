package com.comparadorad.bet.comparer.model.securebet.permission.service;

import org.springframework.stereotype.Service;

@Service
class SecureBetPermission implements ISecureBetPermission {

	@Override
	public Boolean canReadSecureBet() {
		return Boolean.TRUE;
	}

}

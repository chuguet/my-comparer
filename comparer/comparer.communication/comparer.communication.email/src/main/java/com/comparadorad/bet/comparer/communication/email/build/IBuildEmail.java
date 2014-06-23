/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.communication.email.build;

import java.util.List;

import com.comparadorad.bet.comparer.communication.email.beans.IEmailParameter;
import com.comparadorad.bet.comparer.communication.email.exception.BuildEmailException;

/**
 * The Interface IBuildEmail.
 */
public interface IBuildEmail<I extends List<? extends IEmailParameter>> {
	
	/**
	 * Make mail.
	 *
	 * @return the file
	 * @throws BuildEmailException the build email exception
	 */
	String makeMail(I i) throws BuildEmailException;
	

}

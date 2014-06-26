/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.model.core.repository;

import java.math.BigInteger;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.comparadorad.bet.comparer.model.core.bean.IDocument;

/**
 * The Interface IGenericRepository.
 * 
 * @param <T>
 *            the generic type
 */
public interface IGenericRepository<T extends IDocument> extends
		MongoRepository<T, BigInteger> {

}

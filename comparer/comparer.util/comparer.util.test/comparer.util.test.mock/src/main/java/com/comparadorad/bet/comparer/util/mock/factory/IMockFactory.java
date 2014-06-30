/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.util.mock.factory;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.NamedBean;

/**
 * A factory for creating IMock objects.
 *
 * @param <I> the generic type
 */
public interface IMockFactory<I> extends FactoryBean<I>,NamedBean {

}

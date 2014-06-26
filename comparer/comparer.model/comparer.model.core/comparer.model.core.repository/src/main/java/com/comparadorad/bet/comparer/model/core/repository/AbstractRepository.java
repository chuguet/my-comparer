/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.model.core.repository;

import java.util.Set;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;

import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.convert.MappingMongoConverter;

import com.comparadorad.bet.comparer.model.core.bean.AbstractId;
import com.comparadorad.bet.comparer.model.core.bean.IDocument;
import com.comparadorad.bet.comparer.model.core.repository.exception.ObjectWithRecursiveDataException;
import com.comparadorad.bet.comparer.model.core.repository.exception.ValidationObjectException;
import com.comparadorad.bet.comparer.util.commons.profile.ProfileConstant;
import com.mongodb.BasicDBObject;

/**
 * The Class AbstractCfgRepository.
 * 
 * @param <T>
 *            the generic type
 */
public abstract class AbstractRepository<T extends IDocument> {

	private static final Log LOG = LogFactory.getLog(AbstractRepository.class);
	/** The mapping mongo converter. */
	@Inject
	private MappingMongoConverter mappingMongoConverter;

	/** The mongo template. */
	@Inject
	private MongoTemplate mongoTemplate;
	/** The validator. */
	@Inject
	@Resource(name = "localValidatorFactoryBean")
	private Validator validator;

	@Inject
	private ApplicationContext applicationContext;

	/**
	 * Gets the converted id.
	 * 
	 * @param abstractId
	 *            the abstract id
	 * @return the converted id
	 */
	public Object getConvertedId(AbstractId abstractId) {
		Object convertedId = null;
		Object convertedObj = mappingMongoConverter
				.convertToMongoType(abstractId);
		if (convertedObj instanceof BasicDBObject) {
			convertedId = ((BasicDBObject) convertedObj).get("_id");
		} else {
			convertedId = abstractId.getObjectId();
		}
		return convertedId;
	}

	protected String getActiveAndCondition() {
		return "coreActiveElement.active";
	}

	/**
	 * Gets the mongo template.
	 * 
	 * @return the mongo template
	 */
	public MongoTemplate getMongoTemplate() {
		return mongoTemplate;
	}

	/**
	 * Save.
	 * 
	 * @param entity
	 *            the entity
	 */
	public void save(T entity) {
		Boolean validate = Boolean.TRUE;

		if (ArrayUtils.contains(applicationContext.getEnvironment()
				.getActiveProfiles(), ProfileConstant.TEST)) {
			validate = Boolean.FALSE;
		}

		if (validate) {
			Set<ConstraintViolation<T>> constraintViolations;
			constraintViolations = validator.validate(entity);

			if (constraintViolations.size() == 0) {
				try {
					getMongoTemplate().save(entity);
				} catch (StackOverflowError e) {
					LOG.error(e.getMessage());
					throw new ObjectWithRecursiveDataException(e);
				}
			} else {
				throw new ValidationObjectException(constraintViolations);
			}
		} else {
			getMongoTemplate().save(entity);
		}

	}

	// public void save(Iterable<T> pEntities){
	//
	// Boolean validate = Boolean.TRUE;
	// for (String profile :
	// applicationContext.getEnvironment().getActiveProfiles()) {
	// if(profile.equals(ProfileConstant.TEST)){
	// validate = Boolean.FALSE;
	// }
	// }
	// Set<ConstraintViolation<T>> constraintViolations;
	// for (T entry : pEntities) {
	// if(validate){
	// constraintViolations = validator.validate(entry);
	//
	// if (constraintViolations.size() == 0) {
	// try {
	// getMongoTemplate().save(entry);
	// } catch (StackOverflowError e) {
	// LOG.error(e.getMessage());
	// throw new ObjectWithRecursiveDataException(e);
	// }
	// } else {
	// throw new ValidationObjectException(constraintViolations);
	// }
	// }else{
	// getMongoTemplate().save(entry);
	// }
	//
	//
	// }
	//
	//
	// }

}

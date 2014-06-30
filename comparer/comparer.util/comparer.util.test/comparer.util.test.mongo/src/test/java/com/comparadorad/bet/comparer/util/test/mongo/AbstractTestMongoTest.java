package com.comparadorad.bet.comparer.util.test.mongo;

import java.util.HashMap;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.data.repository.CrudRepository;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import com.comparadorad.bet.comparer.model.config.bean.CfgParticipant;
import com.comparadorad.bet.comparer.model.core.bean.IDocument;
import com.comparadorad.bet.comparer.model.repository.CfgParticipantRepository;
import com.comparadorad.bet.comparer.util.commons.profile.ProfileConstant;
import com.comparadorad.bet.comparer.util.test.mongo.config.TestMongoConfigTest;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { TestMongoConfigTest.class }, loader = AnnotationConfigContextLoader.class)
@ActiveProfiles({ProfileConstant.TEST, ProfileConstant.TEST_NO_CREATE_DATA})
public class AbstractTestMongoTest extends AbstractTestMongo {

	@Inject
	private CfgParticipantRepository cfgParticipantRepository;
	
	@Test
	public final void test() {
		
	}

	@SuppressWarnings("rawtypes")
	@Override
	public HashMap<Class<? extends IDocument>, CrudRepository> getRepository(){
		HashMap<Class<? extends IDocument>, CrudRepository> result = new HashMap<Class<? extends IDocument>, CrudRepository>();
		result.put(CfgParticipant.class,cfgParticipantRepository);
		return result;
	}

	@Override
	public Class getLoaderClass() {
		return TestMongoConfigTest.class;
	}

	@Override
	public String getAditionalNameForLoad() {
		return "";
	}

}

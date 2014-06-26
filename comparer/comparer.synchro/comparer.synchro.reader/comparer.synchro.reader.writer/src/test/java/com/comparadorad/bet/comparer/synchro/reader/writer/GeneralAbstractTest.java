package com.comparadorad.bet.comparer.synchro.reader.writer;

import org.junit.runner.RunWith;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import com.comparadorad.bet.comparer.synchro.reader.writer.config.SynchroReaderWriterConfig;
import com.comparadorad.bet.comparer.util.commons.profile.ProfileConstant;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SynchroReaderWriterConfig.class, loader = AnnotationConfigContextLoader.class)
@ActiveProfiles({ ProfileConstant.TEST,
		ProfileConstant.TEST_SAVE_RTMATCH_VALIDATION_ENABLED })
public abstract class GeneralAbstractTest {

}

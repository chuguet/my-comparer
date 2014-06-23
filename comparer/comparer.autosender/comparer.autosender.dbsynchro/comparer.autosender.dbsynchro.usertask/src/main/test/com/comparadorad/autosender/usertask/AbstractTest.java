package com.comparadorad.autosender.usertask;

import org.junit.runner.RunWith;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import com.comparadorad.bet.comparer.synchro.reader.process.config.SynchroReaderProcessConfig;
import com.comparadorad.bet.comparer.util.commons.profile.ProfileConstant;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SynchroReaderProcessConfig.class, loader = AnnotationConfigContextLoader.class)
@ActiveProfiles(ProfileConstant.TEST)
public class AbstractTest {

}

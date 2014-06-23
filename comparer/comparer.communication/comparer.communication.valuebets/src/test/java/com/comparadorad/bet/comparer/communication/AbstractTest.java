package com.comparadorad.bet.comparer.communication;

import org.junit.runner.RunWith;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.comparadorad.bet.comparer.communication.config.CommunicationValueBetsConfigTest;
import com.comparadorad.bet.comparer.util.commons.profile.ProfileConstant;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { CommunicationValueBetsConfigTest.class })
@ActiveProfiles({ProfileConstant.TEST })
public abstract class AbstractTest {
}

package com.comparadorad.bet.comparer.communication.surebets;

import org.junit.runner.RunWith;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.comparadorad.bet.comparer.communication.surebets.config.CommunicationSurebetsConfigTest;
import com.comparadorad.bet.comparer.util.commons.profile.ProfileConstant;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { CommunicationSurebetsConfigTest.class })
@ActiveProfiles({ProfileConstant.TEST})
public abstract class AbstractCommunicationSurebets {

}

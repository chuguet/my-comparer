package com.comparadorad.bet.comparer.synchro.toolbar.filter.config;

import org.junit.runner.RunWith;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.comparadorad.bet.comparer.util.commons.profile.ProfileConstant;

@ContextConfiguration(classes = { ToolbarFilterConfig.class })
@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles(ProfileConstant.TEST)
public abstract class AbstractToolbarFilter {

}

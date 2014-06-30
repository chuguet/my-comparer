package com.comparadorad.bet.comparer.util.cache;

import org.junit.runner.RunWith;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import com.comparadorad.bet.comparer.util.cache.config.CacheConfig;
import com.comparadorad.bet.comparer.util.commons.profile.ProfileConstant;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = CacheConfig.class, loader = AnnotationConfigContextLoader.class)
@ActiveProfiles({ProfileConstant.TEST })
public abstract class AbstractCacheTest {

}

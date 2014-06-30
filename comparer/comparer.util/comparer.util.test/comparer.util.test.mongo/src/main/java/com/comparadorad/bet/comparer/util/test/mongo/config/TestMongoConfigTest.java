package com.comparadorad.bet.comparer.util.test.mongo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Profile;

import com.comparadorad.bet.comparer.model.repository.config.ConfigRepositoryConfig;
import com.comparadorad.bet.comparer.util.commons.profile.ProfileConstant;


@Configuration
@Import({ConfigRepositoryConfig.class})
@Profile(value = { ProfileConstant.TEST })
public class TestMongoConfigTest extends AbstractTestMongoConfig {

}

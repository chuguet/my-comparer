package comparer.synchro.reader.readerbookmaker.convert.test;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

public class InitClass {

	@SuppressWarnings("unused")
	@Bean
	@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
	private DozerBeanMapper getDozer() {
		return new DozerBeanMapper();
	}

}

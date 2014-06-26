package com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.convert.config;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.dozer.CustomConverter;
import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

import com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.convert.converter.CustomConvertReader;

@Configuration
public class ConvertReaderBookmakerConfig extends
		AbstractConvertReaderBookmaker {

	/** The Constant LOG. */
	private static final Log LOG = LogFactory
			.getLog(ConvertReaderBookmakerConfig.class);

	 

	 
	 
	/** The lst custom convert process. */
	@Inject
	private List<CustomConvertReader> lstCustomConvertReader;

	/**
	 * Property sources placeholder configurer.
	 * 
	 * @return the property sources placeholder configurer
	 */
	@Bean
	public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
		return new PropertySourcesPlaceholderConfigurer();
	}

	/**
	 * Gets the mapper config.
	 * 
	 * @return the mapper config
	 */
	@Bean(name = "reader")
	@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
	public Mapper getMapperConfig() {
		DozerBeanMapper mapper = new DozerBeanMapper();
		List<String> mappingFileUrls = new ArrayList<String>();
		Map<String, CustomConverter> customConvertersWithId = new HashMap<String, CustomConverter>();
//		List<String> mappingFiles = getMappingsFiles();
//		for (String string : mappingFiles) {
//			LOG.info("Cargando fichero de mapeo de dozer: " + string);
//			mappingFileUrls.add(string);
//		}
		mappingFileUrls.add(ConfigurationFilesDozer.FILE_CONFIGURATION_DOZER_CONFIGURATION.fileName());
		mappingFileUrls.add(ConfigurationFilesDozer.FILE_CONFIGURATION_DOZER_WILLIAMHILL.fileName());
		mappingFileUrls.add(ConfigurationFilesDozer.FILE_CONFIGURATION_DOZER_BETCLIK.fileName());
		mappingFileUrls.add(ConfigurationFilesDozer.FILE_CONFIGURATION_DOZER_NORDICBET.fileName());

		mapper.setMappingFiles(mappingFileUrls);

		for (CustomConvertReader element : lstCustomConvertReader) {
			//LOG.info(element.getName());
			customConvertersWithId.put(element.getName(), element);
		}

		mapper.setCustomConvertersWithId(customConvertersWithId);
		return mapper;
	}

//	private List<String> getMappingsFiles() {
//		List<String> mappingList = new ArrayList<String>();
//
//		String fileDirectory = ConvertReaderBookmakerConfig.class.getResource(
//				"ConvertReaderBookmakerConfig.class").getPath();
//		Collection<File> file = FileUtils.listFiles(
//				new File(fileDirectory).getParentFile(),
//				new WildcardFileFilter("*-mappings.xml"),
//				TrueFileFilter.INSTANCE);
//
//		Iterator<?> it = file.iterator();
//		while (it.hasNext()) {
//			File fich = (File) it.next();
//			mappingList.add(fich.getAbsolutePath());
//		}
//		
//		return mappingList;
//
//	}

}

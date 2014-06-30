/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparador.bet.comparer.test.core;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.junit.runner.RunWith;
import org.springframework.data.repository.CrudRepository;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import com.comparadorad.bet.comparer.model.config.bean.CfgBetType;
import com.comparadorad.bet.comparer.model.config.bean.CfgBetTypeEvent;
import com.comparadorad.bet.comparer.model.config.bean.CfgBookmaker;
import com.comparadorad.bet.comparer.model.config.bean.CfgCompetition;
import com.comparadorad.bet.comparer.model.config.bean.CfgCompetitionEvent;
import com.comparadorad.bet.comparer.model.config.bean.CfgCompetitionSynonyms;
import com.comparadorad.bet.comparer.model.config.bean.CfgParticipant;
import com.comparadorad.bet.comparer.model.config.bean.CfgParticipantSynonyms;
import com.comparadorad.bet.comparer.model.config.bean.CfgRegion;
import com.comparadorad.bet.comparer.model.config.bean.CfgSport;
import com.comparadorad.bet.comparer.model.config.bean.CfgSportActive;
import com.comparadorad.bet.comparer.model.config.bean.CfgSportSynonyms;
import com.comparadorad.bet.comparer.model.config.bean.bmconf.CfgBookmakerConfiguration;
import com.comparadorad.bet.comparer.model.core.bean.IDocument;
import com.comparadorad.bet.comparer.model.repository.CfgBetTypeEventRepository;
import com.comparadorad.bet.comparer.model.repository.CfgBetTypeRepository;
import com.comparadorad.bet.comparer.model.repository.CfgBookmakerRepository;
import com.comparadorad.bet.comparer.model.repository.CfgCompetitionEventRepository;
import com.comparadorad.bet.comparer.model.repository.CfgCompetitionRepository;
import com.comparadorad.bet.comparer.model.repository.CfgCompetitionSynonymsRepository;
import com.comparadorad.bet.comparer.model.repository.CfgParticipantRepository;
import com.comparadorad.bet.comparer.model.repository.CfgParticipantSynonymsRepository;
import com.comparadorad.bet.comparer.model.repository.CfgRegionRepository;
import com.comparadorad.bet.comparer.model.repository.CfgSportActiveRepository;
import com.comparadorad.bet.comparer.model.repository.CfgSportRepository;
import com.comparadorad.bet.comparer.model.repository.CfgSportSynonymsRepository;
import com.comparadorad.bet.comparer.model.securebet.bean.CfgSureBet;
import com.comparadorad.bet.comparer.model.securebet.repository.CfgSureBetRepository;
import com.comparadorad.bet.comparer.synchro.reader.processbookmaker.xml.resolver.impl.IXmlToRtMatchResolver;
import com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.core.data.XmlBetFileReaderResult;
import com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.core.exception.XmlReaderException;
import com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.core.readers.IXMLFileReader;
import com.comparadorad.bet.comparer.synchro.reader.url.maker.bean.BeanAdditionalXmlInfoReader;
import com.comparadorad.bet.comparer.synchro.valuebet.process.IProcessValueBet;
import com.comparadorad.bet.comparer.synchro.valuebet.reader.IReaderValueBet;
import com.comparadorad.bet.comparer.synchro.valuebet.writer.IWriterValueBet;
import com.comparadorad.bet.comparer.test.core.config.TestCoreConfig;
import com.comparadorad.bet.comparer.util.commons.profile.ProfileConstant;
import com.comparadorad.bet.comparer.util.test.mongo.AbstractTestMongo;

/**
 * The Class AbstractTest.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = TestCoreConfig.class, loader = AnnotationConfigContextLoader.class)
@ActiveProfiles({ProfileConstant.TEST, ProfileConstant.TEST_NO_CREATE_DATA, ProfileConstant.TEST_SAVE_RTMATCH_VALIDATION_ENABLED})
public abstract class AbstractTest extends AbstractTestMongo {

	private static final String PREFIX = "-TestCore";

	/** The file reader. */
	@Inject
	protected List<IXMLFileReader> fileReader;
	
	/** The reader value bet. */
	@Inject
	protected IReaderValueBet readerValueBet;
	
	/** The process value bet. */
	@Inject
	protected IProcessValueBet processValueBet;
	
	/** The writer value bet. */
	@Inject
	protected IWriterValueBet writerValueBet;
	
	/** The match resolver. */
	@Inject
	protected IXmlToRtMatchResolver matchResolver;
	
	/** The competition repository. */
	@Inject
	protected CfgCompetitionRepository competitionRepository;
	
	/** The participant repository. */
	@Inject
	protected CfgParticipantRepository participantRepository;
	
	/** The sport repository. */
	@Inject
	protected CfgSportRepository sportRepository;
	
	@Inject
	protected CfgSportActiveRepository sportActiveRepository;
	
	/** The competition synonyms repository. */
	@Inject
	protected CfgCompetitionSynonymsRepository competitionSynonymsRepository;
	
	@Inject
	protected CfgCompetitionEventRepository competitionEventRepository;
	
	/** The participant synonyms repository. */
	@Inject
	protected CfgParticipantSynonymsRepository participantSynonymsRepository;
	
	/** The sport synonyms repository. */
	@Inject
	protected CfgSportSynonymsRepository sportSynonymsRepository;
	
	@Inject
	protected CfgBetTypeRepository betTypeRepository;
	
	@Inject
	protected CfgBetTypeEventRepository betTypeEventRepository;
	
	@Inject
	protected CfgBookmakerRepository bookmakerRepository;
	
	@Inject
	protected CfgRegionRepository regionRepository;
	
	@Inject
	protected CfgSureBetRepository sureBetRepository;
	
	/**
	 * Gets the project dir.
	 * 
	 * @return the project dir
	 */
	protected static String getProjectDir() {
		return System.getProperty("user.dir");
	}
	
	/**
	 * Read xml.
	 * 
	 * @param pReader
	 *            the reader
	 * @param pXmlLocation
	 *            the xml location
	 * @param bookmakerConfiguration
	 *            the bookmaker configuration
	 * @return the xml bet file reader result
	 * @throws FileNotFoundException
	 *             the file not found exception
	 * @throws XmlReaderException
	 *             the xml reader exception
	 */
	protected XmlBetFileReaderResult readXML(int pReader, String pXmlLocation,
			CfgBookmakerConfiguration bookmakerConfiguration, BeanAdditionalXmlInfoReader pBeanAdditionalXmlInfoReader)
			throws FileNotFoundException, XmlReaderException {
		return fileReader.get(pReader).read(
				new FileInputStream(new File(pXmlLocation)),
				bookmakerConfiguration, pBeanAdditionalXmlInfoReader, "");

	}
	
	/**
	 * Gets the json.
	 *
	 * @param objectToJson the object to json
	 * @return the json
	 * @throws JsonGenerationException the json generation exception
	 * @throws JsonMappingException the json mapping exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	protected String getJson(Object objectToJson)
			throws JsonGenerationException, JsonMappingException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(objectToJson);
		return json;
	}
	
	
	/* (non-Javadoc)
	 * @see com.comparadorad.bet.comparer.util.test.mongo.AbstractTestMongo#getRepository()
	 */
	protected HashMap<Class<? extends IDocument>, CrudRepository> getRepository() {
		HashMap<Class<? extends IDocument>, CrudRepository> result = new HashMap<Class<? extends IDocument>, CrudRepository>();
		result.put(CfgCompetition.class, competitionRepository);
		result.put(CfgCompetitionSynonyms.class, competitionSynonymsRepository);
		result.put(CfgCompetitionEvent.class, competitionEventRepository);
		result.put(CfgSport.class, sportRepository);
		result.put(CfgSportSynonyms.class, sportSynonymsRepository);
		result.put(CfgSportActive.class, sportActiveRepository);
		result.put(CfgParticipant.class, participantRepository);
		result.put(CfgParticipantSynonyms.class, participantSynonymsRepository);
		result.put(CfgBetType.class, betTypeRepository);
		result.put(CfgBetTypeEvent.class, betTypeEventRepository);
		result.put(CfgBookmaker.class, bookmakerRepository);
		result.put(CfgRegion.class, regionRepository);
		result.put(CfgSureBet.class, sureBetRepository);
		return result;
	}

	/* (non-Javadoc)
	 * @see com.comparadorad.bet.comparer.util.test.mongo.AbstractTestMongo#getLoaderClass()
	 */
	protected Class<?> getLoaderClass() {
		return TestCoreConfig.class;
	}
	
	protected String getAditionalNameForLoad() {
		return PREFIX;
	}
	
}
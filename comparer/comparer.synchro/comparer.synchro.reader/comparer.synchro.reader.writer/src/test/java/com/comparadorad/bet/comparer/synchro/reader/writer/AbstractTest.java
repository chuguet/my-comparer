/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.reader.writer;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.List;

import org.junit.runner.RunWith;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import com.comparadorad.bet.comparer.model.core.bean.IDocument;
import com.comparadorad.bet.comparer.synchro.reader.writer.config.SynchroReaderWriterConfig;
import com.comparadorad.bet.comparer.util.commons.profile.ProfileConstant;
import com.comparadorad.bet.comparer.util.commons.xstream.XStreamUtil;
import com.comparadorad.bet.comparer.util.test.mongo.AbstractTestMongo;
import com.thoughtworks.xstream.XStream;

/**
 * The Class AbstractTest.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SynchroReaderWriterConfig.class, loader = AnnotationConfigContextLoader.class)
@ActiveProfiles({ ProfileConstant.TEST,
		ProfileConstant.TEST_SAVE_RTMATCH_VALIDATION_ENABLED })
public abstract class AbstractTest extends AbstractTestMongo {

	/**
	 * Gets the bean from xml.
	 * 
	 * @param fileId
	 *            the file id
	 * @return the bean from xml
	 * @throws FileNotFoundException
	 *             the file not found exception
	 */
	@SuppressWarnings("unchecked")
	public List<IDocument> getBeanFromXml(String fileId)
			throws FileNotFoundException {
		XStream xsTream = XStreamUtil.createXStream();
		String fileName = getClass().getSimpleName() + "." + fileId + ".xml";
		InputStream input = getClass().getResourceAsStream(fileName);
		if (input == null) {
			throw new FileNotFoundException("No existe el fichero:" + fileName);
		}
		return (List<IDocument>) xsTream.fromXML(input);
	}

}

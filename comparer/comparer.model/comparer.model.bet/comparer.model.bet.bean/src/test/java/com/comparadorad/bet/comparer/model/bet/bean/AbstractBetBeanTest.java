/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.model.bet.bean;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import com.comparadorad.bet.comparer.model.bet.config.BetBeanConfig;
import com.comparadorad.bet.comparer.model.core.bean.I18n;
import com.comparadorad.bet.comparer.model.core.bean.I18nField;
import com.comparadorad.bet.comparer.model.core.bean.IDocument;
import com.comparadorad.bet.comparer.util.commons.profile.ProfileConstant;
import com.comparadorad.bet.comparer.util.commons.xstream.XStreamUtil;
import com.thoughtworks.xstream.XStream;

/**
 * The Class AbstractBetBeanTest.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = BetBeanConfig.class, loader = AnnotationConfigContextLoader.class)
@ActiveProfiles(ProfileConstant.TEST)
public abstract class AbstractBetBeanTest {

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

	/**
	 * Gets the valid i18n. Convenience method.
	 * 
	 * @return the valid i18n
	 */
	public I18n getValidI18n() {
		I18n i18n = new I18n();
		Set<I18nField> i18nfields = new HashSet<I18nField>();
		i18nfields.add(new I18nField("i18n", new Locale("Sp", "ES")));
		i18n.setI18nFields(i18nfields);
		return i18n;
	}

	/**
	 * Test.
	 */
	@Test
	public abstract void test();

}

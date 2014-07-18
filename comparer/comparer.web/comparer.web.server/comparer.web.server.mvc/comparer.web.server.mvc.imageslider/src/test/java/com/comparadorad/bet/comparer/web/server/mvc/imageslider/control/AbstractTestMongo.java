package com.comparadorad.bet.comparer.web.server.mvc.imageslider.control;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

import javax.inject.Inject;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.After;
import org.junit.Before;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.repository.CrudRepository;

import com.comparadorad.bet.comparer.model.core.bean.IDocument;
import com.comparadorad.bet.comparer.util.commons.io.JarFileUtils;
import com.comparadorad.bet.comparer.util.commons.io.JarFileUtils.FileContent;
import com.comparadorad.bet.comparer.util.commons.xstream.XStreamUtil;
import com.comparadorad.bet.comparer.util.test.mongo.exception.TestMongoException;

public abstract class AbstractTestMongo extends AbstractTrMvcControllerTest{

	private static final Log LOG = LogFactory.getLog(AbstractTestMongo.class);

	private static final String FILE_EXTENSION = "dbread.xml";

	@Inject
	private MongoTemplate mongoTemplate;

	@Before
	public void create() throws TestMongoException {
		LOG.info("Se inicia la creacion de la BBDD");
		getRepository().entrySet();
		for (@SuppressWarnings("rawtypes")
		Entry<Class<? extends IDocument>, CrudRepository> element : getRepository()
				.entrySet()) {
			saveToRepository(element.getKey(), element.getValue());
		}
		LOG.info("Se finaliza la creacion de la BBDD");
	}

	@After
	public void drop() {
		LOG.info("Se inicia el borrado de la BBDD");
		for (@SuppressWarnings("rawtypes")
		Entry<Class<? extends IDocument>, CrudRepository> element : getRepository()
				.entrySet()) {
			mongoTemplate.dropCollection(element.getKey());
		}
		LOG.info("Se finaliza el borrado de la BBDD");
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	private void saveToRepository(Class<? extends IDocument> pClass,
			CrudRepository crudRepository) throws TestMongoException {
		try {
			List<FileContent> fileContents = JarFileUtils
					.listFilesFromClassDir(pClass.getSimpleName()+getAditionalNameForLoad(),
							FILE_EXTENSION, getLoaderClass());
			if (fileContents == null || fileContents.isEmpty()) {
				throw new TestMongoException("No existen datos para:"
						+ pClass.getSimpleName());
			}
			for (FileContent fileContent : fileContents) {
				String fileContentStr = new String(fileContent.getFileContent());
				if (fileContentStr.contains(pClass.getName())) {
					List result = (List) XStreamUtil.fromXML(fileContentStr);
					if (result != null && !result.isEmpty()) {
						if (result.get(0).getClass().getName()
								.equals(pClass.getName())) {
							crudRepository.save(result);
						}
					}
				}
			}
		} catch (RuntimeException e) {
			LOG.error(e.getMessage(), e);
			throw new TestMongoException("Error en la carga de:"
					+ pClass.getSimpleName(), e);
		} catch (IOException e) {
			LOG.error(e.getMessage(), e);
			throw new TestMongoException("Error en la carga de:"
					+ pClass.getSimpleName(), e);
		}
	}

	@SuppressWarnings("rawtypes")
	protected abstract HashMap<Class<? extends IDocument>, CrudRepository> getRepository();

	protected abstract Class<?> getLoaderClass();
	
	protected String getAditionalNameForLoad() {
		return "";
	}

}

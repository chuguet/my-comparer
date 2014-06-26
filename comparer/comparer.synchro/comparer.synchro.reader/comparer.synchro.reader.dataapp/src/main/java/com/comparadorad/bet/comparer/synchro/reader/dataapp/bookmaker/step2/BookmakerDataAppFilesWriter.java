/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.reader.dataapp.bookmaker.step2;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.batch.item.ItemWriter;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.comparadorad.bet.comparer.model.config.bean.CfgBookmaker;
import com.comparadorad.bet.comparer.model.config.bean.ICfgSynonyms;
import com.comparadorad.bet.comparer.model.core.bean.CoreActiveElement;
import com.comparadorad.bet.comparer.model.core.bean.IActivable;
import com.comparadorad.bet.comparer.model.core.bean.IDocument;
import com.comparadorad.bet.comparer.model.core.bean.ObjectState.ObjectStateEnum;
import com.comparadorad.bet.comparer.model.core.repository.AbstractRepository;
import com.comparadorad.bet.comparer.model.core.repository.exception.ValidationObjectException;
import com.comparadorad.bet.comparer.model.core.service.IGenericCrudService;
import com.comparadorad.bet.comparer.model.log.bean.LogEvent.LogState;
import com.comparadorad.bet.comparer.model.log.service.ILogEventBookmakerMasterWordsService;
import com.comparadorad.bet.comparer.synchro.reader.app.bookmaker.StepProcessData;
import com.comparadorad.bet.comparer.synchro.reader.dataapp.bookmaker.creator.CfgCreatorData;
import com.comparadorad.bet.comparer.synchro.reader.dataapp.config.SynchroReaderDataAppParams;
import com.comparadorad.bet.comparer.util.commons.path.TargetPathUtil;
import com.comparadorad.bet.comparer.util.commons.profile.ProfileConstant;
import com.comparadorad.bet.comparer.util.commons.profile.ProfileUtil;
import com.comparadorad.bet.comparer.util.commons.xstream.XStreamUtil;

/**
 * The Class BookmakerFilesWriter.
 */
@Service
public final class BookmakerDataAppFilesWriter extends
		AbstractBookmakerDataAppProcess implements
		ItemWriter<StepProcessData<CfgCreatorDataProcess>> {

	/** The Constant LOG. */
	private static final Log LOG = LogFactory
			.getLog(BookmakerDataAppFilesWriter.class);

	/** The application context. */
	@Inject
	private ApplicationContext applicationContext;

	/** The log event bookmaker service. */
	@Inject
	private ILogEventBookmakerMasterWordsService logEventBookmakerMasterWordsService;

	/** The synchro reader data app params. */
	@Inject
	private SynchroReaderDataAppParams synchroReaderDataAppParams;

	/** Gets the crud service. */
	@SuppressWarnings("rawtypes")
	private IGenericCrudService genericCrudService;

	/** The sport synonyms service. */
	@Inject
	private NameService nameService;

	/**
	 * Instantiates a new factory writer.
	 */
	private BookmakerDataAppFilesWriter() {
		super();
	}

	/**
	 * Path file.
	 * 
	 * @param pObject
	 *            the object
	 * @param bookmaker
	 *            the bookmaker
	 * @param create
	 *            the create
	 * @param isDoubt
	 *            the is doubt
	 * @return the string
	 */
	private String pathFile(Object pObject, CfgBookmaker bookmaker,
			boolean create, boolean isDoubt) {
		String action = ".create";
		if (!create) {
			action = ".update";
		}
		String doubtStr = "";
		if (isDoubt) {
			doubtStr = ".doubt";
		}
		return TargetPathUtil.getDbReadpathFile(
				pObject,
				false,
				true,
				new StringBuffer().append(bookmaker.getObjectId())
						.append(action).append(doubtStr).toString(),
				this.getClass());
	}

	/**
	 * Save data.
	 * 
	 * @param creatorDatas
	 *            the creator datas
	 * @param bookmaker
	 *            the bookmaker
	 * @param isDoubt
	 *            the is doubt
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private void saveData(List creatorDatas, CfgBookmaker bookmaker,
			boolean isDoubt) {
		List<IDocument> documents = new ArrayList<IDocument>();
		List<ICfgSynonyms> synonyms = new ArrayList<ICfgSynonyms>();
		for (CfgCreatorData<?, ?> creatorData : (List<CfgCreatorData>) creatorDatas) {
			if (synchroReaderDataAppParams.isCorrectDatabaseData()) {
				if (!creatorData.getLogEventBookmakerMasterWords()
						.getLogState().equals(LogState.DATA_ERROR)) {
					creatorData.getLogEventBookmakerMasterWords().setLogState(
							LogState.DATA_APP_READED);
				} else {
					creatorData.setAddDataToDbreadFile(false);
				}
				if (creatorData.isAddDataToDbreadFile()) {
					// TODO controlar si no se salva porque el id es repetido
					// (caso de ejecución con varios hilos)
					// no cambie el estado del evento en la base datoso
					if (creatorData.getModelData() != null
							&& creatorData.getModelData().getObjectState() != null
							&& creatorData.getModelData().getObjectState()
									.isNew()) {

						boolean setAsActive = true;
						// Es alta
						if (!bookmaker.getBookmakerConfiguration()
								.getBookmakerMasterWordConfig()
								.isCouldCreateMasterWord()) {
							// Si no podemos dar de alta lo damos de alta como
							// desactivado
							setAsActive = false;

						}
						creatorData.getModelData().setCoreActiveElement(
								new CoreActiveElement(setAsActive));
						((IActivable) creatorData.getSynonyms())
								.setCoreActiveElement(new CoreActiveElement(
										setAsActive));

						creatorData
								.getModelData()
								.getHistoric()
								.getHistoricList()
								.get(0)
								.setDataRef(
										new CfgBookmaker(bookmaker
												.getObjectId()));
					}
					// Si el objeto padre de los sinonimos no se ha modificado
					// es que es una actualizacion con lo que solo damos de alta
					// los sinonimos y no el deporte que no ha sido cambiado.
					// checkUpdate(creatorData);
					LOG.info("El estado del objeto padre es: "
							+ creatorData.getModelData().getObjectState()
									.getObjectState());
					if (creatorData.getModelData().getObjectState()
							.getObjectState()
							.equals(ObjectStateEnum.NOT_MODIFIED)
							|| creatorData.getModelData().getObjectState()
									.getObjectState()
									.equals(ObjectStateEnum.UPDATED)) {
						try {
							genericRepository.save(creatorData.getSynonyms());
							creatorData.getLogEventBookmakerMasterWords()
									.setLogState(LogState.DATA_APP_DB_UPDATED);
						} catch (ValidationObjectException e) {
							LOG.error("Se ha producido una excepción de validación en el elemento " + creatorData.getModelData().getName(null));
						}
						
					} else {
						try {
							genericRepository.save(creatorData.getModelData());
							genericRepository.save(creatorData.getSynonyms());
							creatorData.getLogEventBookmakerMasterWords()
									.setLogState(LogState.DATA_APP_DB_UPDATED);
						} catch (ValidationObjectException e) {
							LOG.error("Se ha producido una excepción de validación en el elemento " + creatorData.getModelData().getName(null));
						}
					}
				}
			} else {
				creatorData.getLogEventBookmakerMasterWords().setLogState(
						LogState.DATA_ERROR);
			}
			// logEventBookmakerMasterWordsService.save(creatorData
			// .getLogEventBookmakerMasterWords());

			// Borramos la palabra tratada, para que no se almacene mucha basura
			// en la coleccion.
			logEventBookmakerMasterWordsService.delete(creatorData
					.getLogEventBookmakerMasterWords());
			if (creatorData.isAddDataToDbreadFile()) {
				documents.add(creatorData.getModelData());
				synonyms.add(creatorData.getSynonyms());
			}
		}

		// Solo guardamos los xml en caso de que no nos encontremos en
		// produccion o preproduccion.
		if (!ProfileUtil.containsProfile(ProfileConstant.PRODUCTION,
				applicationContext.getEnvironment().getActiveProfiles())
				&& !ProfileUtil
						.containsProfile(ProfileConstant.PREPRODUCTION,
								applicationContext.getEnvironment()
										.getActiveProfiles())) {
			LOG.debug("Escribimos los xml del elemento recien creado");
			XStreamUtil.writeObject(documents,
					pathFile(documents, bookmaker, true, isDoubt));
			XStreamUtil.writeObject(synonyms,
					pathFile(synonyms, bookmaker, true, isDoubt));
			LOG.debug("Fin generación de nombres");

		}
	}

	/** The generic repository. */
	@Inject
	private GenericRepository genericRepository;

	/**
	 * The Class GenericRepository.
	 */
	@Repository
	public static class GenericRepository extends AbstractRepository {

	}

	/**
	 * Write.
	 * 
	 * @param stepProcessDatas
	 *            the step process datas
	 * @throws Exception
	 *             the exception {@inheritDoc}
	 */
	@Override
	public void write(
			List<? extends StepProcessData<CfgCreatorDataProcess>> stepProcessDatas)
			throws Exception {
		BookmakerStep2Data bookmakerStep2Data = BookmakerStep2Data
				.getInstance(getExecutionContext());
		CfgBookmaker bookmaker = null;
		for (StepProcessData<CfgCreatorDataProcess> processData : stepProcessDatas) {
			bookmaker = processData.getCfgBookmaker();

			for (String key : processData.getData().getMapCreatorDataList()
					.keySet()) {
				CfgCreatorDataList creatorDataList = processData.getData()
						.getMapCreatorDataList().get(key);
				saveData(creatorDataList.getCreatorDataList(), bookmaker,
						creatorDataList.isDoubtList());
			}
		}
		LOG.debug(getStepMessageChain(bookmaker) + "Setting XmlDataFiles: "
				+ stepProcessDatas.size());
	}

	/**
	 * Gets the i generic service.
	 * 
	 * @return the i generic service
	 */
	protected IGenericCrudService getIGenericService() {
		return genericCrudService;
	}

}

/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.reader.dataapp.bookmaker.creator;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.ParameterizedType;
import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.regex.Pattern;

import javax.inject.Inject;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.comparadorad.bet.comparer.model.config.bean.AbstractCfgSynonymWord;
import com.comparadorad.bet.comparer.model.config.bean.AbstractCfgSynonymWord.CfgSynonymWordHistoricData;
import com.comparadorad.bet.comparer.model.config.bean.AbstractCfgSynonyms;
import com.comparadorad.bet.comparer.model.config.bean.CfgBookmaker;
import com.comparadorad.bet.comparer.model.config.bean.CfgCompetitionSynonyms;
import com.comparadorad.bet.comparer.model.config.bean.CfgHistoricUser;
import com.comparadorad.bet.comparer.model.config.bean.CfgMaster;
import com.comparadorad.bet.comparer.model.config.bean.CfgMaster.CfgMasterId;
import com.comparadorad.bet.comparer.model.config.bean.ICfgSynonyms;
import com.comparadorad.bet.comparer.model.config.service.ICfgCompetitionSynonymsService;
import com.comparadorad.bet.comparer.model.config.service.ISynonymsService;
import com.comparadorad.bet.comparer.model.core.bean.AbstractI18nTable;
import com.comparadorad.bet.comparer.model.core.bean.AbstractId;
import com.comparadorad.bet.comparer.model.core.bean.IDocument;
import com.comparadorad.bet.comparer.model.core.bean.IModel;
import com.comparadorad.bet.comparer.model.core.bean.ObjectState.ObjectStateEnum;
import com.comparadorad.bet.comparer.model.core.service.IGenericCrudService;
import com.comparadorad.bet.comparer.synchro.reader.dataapp.bookmaker.comparer.DataComparer;
import com.comparadorad.bet.comparer.synchro.reader.dataapp.bookmaker.comparer.impl.DataComparerImpl;
import com.comparadorad.bet.comparer.synchro.reader.dataapp.bookmaker.creator.bean.StrikeAMatchData;
import com.comparadorad.bet.comparer.synchro.reader.dataapp.bookmaker.creator.normalizer.INormalizer;
import com.comparadorad.bet.comparer.synchro.reader.model.AbstractXmlData;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlMatchParticipant;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlTournament;

/**
 * The Class AbstractCfgCreator.
 * 
 * @param <T>
 *            the generic type
 * @param <I>
 *            the generic type
 */
abstract class AbstractCfgCreator<T extends IModel, I extends ICfgSynonyms> {

	/** The Constant DATA_APP. */
	protected static final String DATA_APP = "DATA_APP";

	/** The Constant LOG. */
	private static final Log LOG = LogFactory.getLog(CfgCompetitionCreator.class);

	/** The destiny path. */
	protected String destinyPath = "d:\\synonyms.csv";

	/** The data comparer. */
	private final DataComparer<I> dataComparer = (DataComparer<I>) new DataComparerImpl();

	private String palabraInicial;

	/** The competition synonyms service. */
	@Inject
	private ICfgCompetitionSynonymsService competitionSynonymsService;

	/**
	 * Gets the random.
	 * 
	 * @return the random
	 */
	public static BigInteger getRandom() {
		Random prng = new SecureRandom(); // self-seeding
		BigInteger result = BigInteger.probablePrime(30, prng);
		return result;
	}

	/** The master. */
	private CfgMaster master;

	/** The master list. */
	private List<CfgMaster> masterList;

	/** The normalizer. */
	@Autowired
	protected List<INormalizer> normalizer;

	/**
	 * Gets the cfg master id.
	 * 
	 * @return the cfg master id
	 */
	protected abstract CfgMasterId getCfgMasterId();

	/**
	 * Gets the crud service.
	 * 
	 * @return the crud service
	 */
	protected abstract IGenericCrudService<T> getCrudService();

	/**
	 * Gets the master.
	 * 
	 * @return the master
	 */
	public CfgMaster getMaster() {
		return getMaster(getFirstGenericParamClass());
	}

	/**
	 * Gets the master.
	 * 
	 * @param theClass
	 *            the the class
	 * @return the master
	 */
	private CfgMaster getMaster(final Class theClass) {
		if (master == null) {
			String masterId = theClass.getSimpleName();
			if (masterList != null) {
				for (CfgMaster pmaster : masterList) {
					if (masterId.equals(pmaster.getNameId())) {
						master = pmaster;
						break;
					}
				}
			}
		}
		return master;
	}

	/**
	 * Gets the new object dictionary id.
	 * 
	 * @param parentObjectId
	 *            the parent object id
	 * @return the new object dictionary id
	 */
	protected BigInteger getNewObjectDictionaryId(final BigInteger parentObjectId) {
		BigInteger newObjectId = null;
		if (getSynonymsCrudService().findOne(parentObjectId) == null) {
			newObjectId = parentObjectId;
		} else {
			boolean isNew = false;
			while (!isNew) {
				newObjectId = getRandom();
				Object result = getCrudService().findOne(newObjectId);
				if (result == null) {
					isNew = true;
				}
			}
		}
		return newObjectId;
	}

	/**
	 * Gets the new object id.
	 * 
	 * @return the new object id
	 */
	private BigInteger getNewObjectId() {
		BigInteger newObjectId = null;
		boolean isNew = false;
		while (!isNew) {
			newObjectId = getRandom();
			Object result = getCrudService().findOne(newObjectId);
			if (result == null) {
				isNew = true;
			}
		}
		return newObjectId;
	}

	/**
	 * Normalizar posible sinonimo.
	 * 
	 * @param palabra
	 *            the palabra
	 * @return the list
	 */
	private List<String> normalizarPosibleSinonimo(final String palabra) {
		LOG.debug("Iniciamos la creación de nuevas palabras para tener un abanico mas grande de sinonimos");
		List<String> listaPalabrasNormalizada = new ArrayList<String>();

		listaPalabrasNormalizada.add(palabra);

		for (INormalizer normalizer : this.normalizer) {
			listaPalabrasNormalizada = normalizer.normalize(listaPalabrasNormalizada);
		}

		return listaPalabrasNormalizada;
	}

	/**
	 * Gets the synonyms db.
	 * 
	 * @param xmlData
	 *            the xml data
	 * @return the synonyms db
	 */
	private List<I> getSynonymsDb(AbstractXmlData<?> xmlData) {
		// Para el caso de competicion buscamos por deporte y competicion
		List<I> synonymsDb = null;
		if (xmlData instanceof XmlTournament) {
			LOG.debug("El elemento es una competicion con lo que obtengo todos los sinonimos de la coleccion a partir del deporte asociado con el tiempo configurado de retardo.");
			XmlTournament tournament = (XmlTournament) xmlData;
			synonymsDb = getSynonymsCrudService().customFindAllTournament(tournament.getName(), tournament.getXmlSport().getCfgObjectId());
		} else if (xmlData instanceof XmlMatchParticipant) {
			LOG.debug("El elemento es un participante con lo que obtengo solo los sinonimos de la coleccion segun nombre de participante, competicion y deporte asociados");
			XmlMatchParticipant participant = (XmlMatchParticipant) xmlData;
			synonymsDb = getSynonymsCrudService().customFindAllParticipant(participant.getXmlTournament().getCfgObjectId());

		} else {
			LOG.debug("El elemento no es una competicion con lo que obtengo todos los sinonimos de la coleccion");
			synonymsDb = getSynonymsCrudService().customFindAll();
		}

		return synonymsDb;
	}

	private String normalizeInitialWord(String palabra) {
		String result = palabra;
		result = result.replaceAll("Ö", "O");
		result = result.replaceAll("ö", "o");
		result = result.replaceAll("Ä", "A");
		result = result.replaceAll("ä", "a");
		result = result.replaceAll("[^\\x00-\\x7f]", "");
		result = result.trim();
		
		return result;
	}
	
	/**
	 * Gets the synonyms.
	 * 
	 * @param xmlData
	 *            the xml data
	 * @param dataBookmaker
	 *            the data bookmaker
	 * @return the synonyms
	 */
	protected I getSynonyms(AbstractXmlData<?> xmlData, CfgBookmaker dataBookmaker) {
		I result = null;
		LOG.debug("Dejamos la palabra inicial en minusculas y la comparamos con lo que encontremos en BD tambien en minusculas, asi minimizamos el numero de comparaciones, luego se almacena como llegue");
		String palabraInicial = xmlData.getName().trim();
		String palabraInicialMinuscula = palabraInicial.toLowerCase();
		palabraInicialMinuscula = normalizeInitialWord(palabraInicialMinuscula);
		LOG.debug("Recuperamos sinonimos de la BD");
		List<I> synonymsDb = getSynonymsDb(xmlData);

		if (synonymsDb != null && !synonymsDb.isEmpty()) {
			// Normalizamos la palabra que ha generado el error de no encontrado
			// para tener mas elementos
			// sobre los que podamos pasar el comparador de sinonimos.
			LOG.debug("Normalizamos la palabra de entrada para sacar el mayor numero de posibles sinonimos");

			List<String> listaPalabrasAnalizar = normalizarPosibleSinonimo(palabraInicialMinuscula);

			List<StrikeAMatchData<I>> listaSinonimosEncontrados = compararCadenas(synonymsDb, listaPalabrasAnalizar);

			if (!listaSinonimosEncontrados.isEmpty()) {
				LOG.debug("Se han encontrado sinonimos");
				Collections.sort(listaSinonimosEncontrados, Collections.reverseOrder());
				StrikeAMatchData<I> bestMatch = listaSinonimosEncontrados.get(0);

				CfgSynonymWordHistoricData cfgSynonymWordHistoricData = new CfgSynonymWordHistoricData(bestMatch.getStrike(),
						bestMatch.getBestAlgorithm());
				bestMatch.setWordA(palabraInicial);
				LOG.debug("Guardamos como nuevo sinonimo de " + bestMatch.getWordB() + " la palabra " + palabraInicial);
				// Generamos una entrada el el fichero csv de sinonimos
				escribirCvs(bestMatch);

				List<String> sinonimosCandidatos = new ArrayList<String>();
				for (StrikeAMatchData<I> sinonimoCandidato : listaSinonimosEncontrados) {
					String idPadre = sinonimoCandidato.getSynonyms().getParent();
					if (!sinonimosCandidatos.contains(idPadre)) {
						LOG.debug("Añadimos como sinonimo candidato el id de sinonimo: " + idPadre);
						sinonimosCandidatos.add(idPadre);
					}

				}
				result = bestMatch.getSynonyms();
				if (!sinonimosCandidatos.isEmpty()) {
					if (xmlData instanceof XmlTournament) {
						if (((XmlTournament) xmlData).getParticipantNames() != null) {
							LOG.debug("La competicion no puede ser verificada por lo que la damos de alta pero no verificada");
							result.addSynonimWord(palabraInicial, sinonimosCandidatos, dataBookmaker,
									((XmlTournament) xmlData).getParticipantNames(), CfgHistoricUser.NOT_VERIFIED.nameId(),
									cfgSynonymWordHistoricData);
						}
					} else {
						result.addSynonimWord(palabraInicial, sinonimosCandidatos, dataBookmaker, CfgHistoricUser.NOT_VERIFIED.nameId(),
								cfgSynonymWordHistoricData);
					}
				} else {
					result.addSynonimWord(palabraInicial, dataBookmaker, CfgHistoricUser.NOT_VERIFIED.nameId(), cfgSynonymWordHistoricData);
				}
			}
		}

		if (result instanceof AbstractCfgSynonyms) {
			IDocument relatedDocument = ((AbstractCfgSynonyms) result).getRelatedDocument();
			if (relatedDocument instanceof AbstractId) {
				((AbstractId) relatedDocument).setObjectState(ObjectStateEnum.NOT_MODIFIED);
			}
		}

		return result;
	}

	private List<StrikeAMatchData<I>> compararCadenas(final List<I> synonymsDb, final List<String> listaPalabrasAnalizar) {
		List<StrikeAMatchData<I>> listaSinonimosEncontrados = new ArrayList<StrikeAMatchData<I>>();
		for (I synonyms : synonymsDb) {
			if (synonyms.getSynonimWords() != null && !synonyms.getSynonimWords().isEmpty()) {
				for (AbstractCfgSynonymWord synonymWord : synonyms.getSynonimWords()) {

					if (synonymWord != null) {
						// para cada una de las palabras de las que hemos
						// normalizado comprobamos las coincidencias para sacar
						// el mejor sinonimo
						for (String palabraNormalizada : listaPalabrasAnalizar) {
							// Primero hacemos el strike con la "frase" completa
							// sin
							// modificaciones
							StrikeAMatchData<I> strikeAMatchData = new StrikeAMatchData<I>(palabraNormalizada,
									synonymWord.getWord().trim().toLowerCase(), synonyms, synonymWord);
							dataComparer.compareStrings(getMaster(), strikeAMatchData);

							// Si no hemos encontrado sinonimo para ninguno de
							// los
							// algoritmos no tenemos en cuenta esa palabra
							if (strikeAMatchData.getSinonimo() > 0 && strikeAMatchData.getSumma() > getMaster().getAlgorithmPrecission()) {
								// Solo agregamos palabras si no son exactamente
								// iguales.
								if (!strikeAMatchData.getWordA().equals(strikeAMatchData.getWordB())) {
									listaSinonimosEncontrados.add(strikeAMatchData);
								}
							}
						}

					}

				}
			}
		}
		return listaSinonimosEncontrados;
	}

	/**
	 * Escribir cvs.
	 * 
	 * @param bestMatch
	 *            the best match
	 */
	private void escribirCvs(final StrikeAMatchData bestMatch) {
		// Generamos una entrada el el fichero csv de sinonimos
		FileWriter fichero = null;
		PrintWriter pw = null;
		LOG.debug("Generamos el cvs de sinonimos");
		try {
			fichero = new FileWriter(destinyPath, true);
			pw = new PrintWriter(fichero);
			pw.append(bestMatch.getWordA() + ";" + bestMatch.getWordB() + ";" + bestMatch.getSumma() + ";" + bestMatch.getBestAlgorithm());
			pw.println();
		} catch (IOException e) {
			LOG.error(new StringBuffer().append("Error al generar el fichero de sinonimos. - ").append(e.getMessage()));
		} finally {
			try {
				if (null != fichero) {
					fichero.close();
					pw.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

	/**
	 * Gets the first generic param class.
	 * 
	 * @return the first generic param class
	 */
	public Class getFirstGenericParamClass() {

		ParameterizedType superclass = (ParameterizedType) getClass().getGenericSuperclass();
		return (Class<?>) ((ParameterizedType) superclass).getActualTypeArguments()[0];
	}

	/**
	 * Gets the synonyms crud service.
	 * 
	 * @return the synonyms crud service
	 */
	protected abstract ISynonymsService<I> getSynonymsCrudService();

	/**
	 * Sets the master list.
	 * 
	 * @param pMasterList
	 *            the new master list
	 */
	public void setMasterList(List<CfgMaster> pMasterList) {
		masterList = pMasterList;
	}

	/**
	 * Sets the new object id.
	 * 
	 * @param objectId
	 *            the new new object id
	 */
	protected void setNewObjectId(AbstractI18nTable objectId) {
		objectId.setObjectId(getNewObjectId());
		objectId.setObjectState(ObjectStateEnum.NEW);
	}
}

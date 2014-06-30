/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparador.bet.comparer.test.core.mainTest;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.inject.Inject;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Before;
import org.junit.Test;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;

import com.comparador.bet.comparer.test.core.AbstractTest;
import com.comparadorad.bet.comparer.model.bet.bean.RtMatch;
import com.comparadorad.bet.comparer.model.bet.repository.RtMatchRepository;
import com.comparadorad.bet.comparer.model.bet.service.RtMatchService;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlMatch;
import com.comparadorad.bet.comparer.synchro.reader.processbookmaker.exception.BetBySportNotAllowedException;
import com.comparadorad.bet.comparer.synchro.reader.processbookmaker.xml.resolver.bean.XmlToRtResolverData;
import com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.core.data.XmlBetFileReaderResult;
import com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.core.exception.XmlReaderException;
import com.comparadorad.bet.comparer.synchro.reader.writer.service.ISynchroMatchWriterService;
import com.comparadorad.bet.comparer.synchro.securebet.core.beans.SureBetsMatch;
import com.comparadorad.bet.comparer.synchro.valuebet.core.bean.result.ResultValueBet;
import com.comparadorad.bet.comparer.test.bean.beans.BeanBookmaker;
import com.comparadorad.bet.comparer.test.bean.beans.BeanLectura;

/**
 * The Class AbstractTemplateMainTest.
 */
public abstract class AbstractTemplateMainTest extends AbstractTest {

	/** The eventos leidos. */
	private List<BeanLectura> eventosLeidos = new ArrayList<BeanLectura>();

	/** The eventos procesados. */
	private List<RtMatch> eventosProcesados = new ArrayList<RtMatch>();

	private RtMatch valueBetMatchReaded = new RtMatch();

	private ResultValueBet resultValueBet = new ResultValueBet();

	private SureBetsMatch calculateSecureBetBean = new SureBetsMatch();

	/** The match repository. */
	@Inject
	private RtMatchRepository matchRepository;

	/** The match service. */
	@Inject
	private RtMatchService matchService;

	@Inject
	private ISynchroMatchWriterService writerService;

	/** The Constant LOG. */
	private static final Log LOG = LogFactory.getLog(AbstractTemplateMainTest.class);

	/**
	 * Inits the.
	 */
	@Before
	public void init() {
		leerBookmaker(getBookmakersData());
		procesadoEventos();
		guardadoEventosBD();
		consultarEventosBD();
//		leerValueBets();
//		procesarValueBet();
//		escribirValueBet();
//		leerSureBets();
//		procesarSureBets();
	}

	/**
	 * Se consultan los eventos de BD, se sobreescribe la lista de eventos que
	 * habiamos procesado guardando en ella los eventos que acabamos de leer de
	 * BD
	 */
	private void consultarEventosBD() {
		eventosProcesados = matchRepository.findAll();

	}

	protected abstract List<BeanBookmaker> getBookmakersData();

	/**
	 * Verificar lectura xml.
	 */
	@Test
	public abstract void verificarLecturaXml();

	/**
	 * Verificar xml bookmakers.
	 */
	@Test
	public abstract void verificarXmlGuardadosBD();

	@Test
	public abstract void verificarValueBetGenerada();

//	@Test
//	public abstract void verificarSureBetGenerada();

	/**
	 * Leer bookmaker.
	 * 
	 * @param idBookmaker
	 *            the id bookmaker
	 * @param xmlLocation
	 *            the xml location
	 * @param ordenBookmaker
	 *            the orden bookmaker
	 * @param bookmaker
	 *            the bookmaker
	 */
	private void leerBookmaker(List<BeanBookmaker> bookmakersList) {
		try {
			for (BeanBookmaker bookmakerData : bookmakersList) {
				XmlBetFileReaderResult xmlrBetFileReaderResult = readXML(bookmakerData.getOrdenBookmaker(), bookmakerData.getXmlLocation(),
						bookmakerData.getBookmaker().getBookmakerConfiguration(), bookmakerData.getBeanAdditionalXmlInfoReader());
				Collection<XmlMatch> matches = xmlrBetFileReaderResult.getXmlBookmakerEvents().getXmlMatchs();
				for (XmlMatch match : matches) {
					// Modificamos dinamicamente la fecha para que el reader de
					// valueBet pueda localizar partidos validos
					// match.setStartDate(new XmlDate(new Date(new Date()
					// .getTime() + 7300000l), "GMT+1", new Date(
					// new Date().getTime() + 7300000l)));
					BeanLectura beanLectura = new BeanLectura();
					beanLectura.setBookmaker(bookmakerData.getBookmaker());
					beanLectura.setXmlMatch(match);
					eventosLeidos.add(beanLectura);
				}
			}

		} catch (FileNotFoundException e) {
			LOG.error("No se ha encontrado el fichero de carga del reader");
		} catch (XmlReaderException e) {
			LOG.error("Error en el reader");
		}
	}

	/**
	 * Procesado eventos.
	 */
	private void procesadoEventos() {
		for (BeanLectura match : eventosLeidos) {
			try {
				eventosProcesados.add(matchResolver.resolve(match.getXmlMatch(), null, new XmlToRtResolverData(match.getBookmaker())));
			} catch (BetBySportNotAllowedException e) {
				LOG.error(e.getMessage());
			}
		}
	}

	/**
	 * Guardado eventos bd.
	 */
	private void guardadoEventosBD() {
		matchService.deleteAll();
		if (eventosProcesados != null && eventosProcesados.size() > 0) {
			// matchService.save(eventosProcesados);
			// writerService.write(pMatch);
			for (RtMatch match : eventosProcesados) {
				writerService.write(match);
			}
		}

	}

	private void leerValueBets() {
		try {
			valueBetMatchReaded = readerValueBet.read();
		} catch (UnexpectedInputException e) {
			LOG.error(e.getMessage());
		} catch (ParseException e) {
			LOG.error(e.getMessage());
		} catch (NonTransientResourceException e) {
			LOG.error(e.getMessage());
		} catch (Exception e) {
			LOG.error(e.getMessage());
		}
	}

	private void procesarValueBet() {
		try {
			if (valueBetMatchReaded != null) {
				resultValueBet = processValueBet.process(valueBetMatchReaded);
			}
		} catch (Exception e) {
			LOG.error(e.getMessage());
		}
	}

	private void escribirValueBet() {
		List<ResultValueBet> listaValueBet = new ArrayList<ResultValueBet>();
		listaValueBet.add(resultValueBet);
		if (resultValueBet != null && resultValueBet.getValueBetDatas().size() > 0) {
			try {
				writerValueBet.write(listaValueBet);
			} catch (Exception e) {
				LOG.error(e.getMessage());
			}
		}
	}

//	private void leerSureBets() {
//		try {
//			sureBetMatchReaded = readerSecureBet.read();
//		} catch (UnexpectedInputException e) {
//			LOG.error(e.getMessage());
//		} catch (ParseException e) {
//			LOG.error(e.getMessage());
//		} catch (NonTransientResourceException e) {
//			LOG.error(e.getMessage());
//		} catch (Exception e) {
//			LOG.error(e.getMessage());
//		}
//	}
//
//	private void procesarSureBets() {
//		if (sureBetMatchReaded != null && sureBetMatchReaded.getRtMatch() != null) {
//			calculateSecureBetBean = processSecureBet.calculate(sureBetMatchReaded);
//		}
//	}

	/**
	 * Gets the eventos leidos.
	 * 
	 * @return the eventos leidos
	 */
	protected List<BeanLectura> getEventosLeidos() {
		return eventosLeidos;
	}

	/**
	 * Gets the eventos procesados.
	 * 
	 * @return the eventos procesados
	 */
	protected List<RtMatch> getEventosProcesados() {
		return eventosProcesados;
	}

	/**
	 * Gets the rt match repository.
	 * 
	 * @return the rt match repository
	 */
	protected RtMatchRepository getRtMatchRepository() {
		return matchRepository;
	}

	protected ResultValueBet getResultValueBet() {
		return resultValueBet;
	}

	protected SureBetsMatch getCalculateSecureBetBean() {
		return calculateSecureBetBean;
	}

}

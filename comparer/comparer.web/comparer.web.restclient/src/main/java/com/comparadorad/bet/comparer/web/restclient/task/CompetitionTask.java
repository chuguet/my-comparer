package com.comparadorad.bet.comparer.web.restclient.task;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.JavaType;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.http.HttpEntity;

import com.comparadorad.bet.comparer.web.client.gwt.common.bean.LinkTo;
import com.comparadorad.bet.comparer.web.client.gwt.common.bean.ObjectToId;
import com.comparadorad.bet.comparer.web.client.gwt.common.bean.cfg.request.CompetitionRequestTo;
import com.comparadorad.bet.comparer.web.client.gwt.common.bean.tab.response.TabResponseTo;
import com.comparadorad.bet.comparer.web.client.gwt.common.bean.table.TableResponseCellTo;
import com.comparadorad.bet.comparer.web.client.gwt.common.bean.table.TableResponseRowTo;
import com.comparadorad.bet.comparer.web.client.gwt.common.bean.table.TableResponseTo;
import com.comparadorad.bet.comparer.web.restclient.core.IRestClient;
import com.comparadorad.bet.comparer.web.restclient.core.RestClient;
import com.comparadorad.bet.comparer.web.restclient.exec.RequestSender;
import com.comparadorad.bet.comparer.web.restclient.util.RestTemplateUtil;

/**
 * Task for process a competition.
 * 
 * @author rdomingo
 * 
 */
@SuppressWarnings({ "unused", "unchecked" })
public class CompetitionTask extends AbstractLevelTask {
	/** The Constant LOG. */
	public static final Log LOG = LogFactory.getLog(CompetitionTask.class);

	private String idCompetition;

	public CompetitionTask(AnnotationConfigApplicationContext pContext,
			String competition, Boolean writeURLs) {
		super(pContext, writeURLs);
		idCompetition = competition;
	}

	public void run() {

		CompetitionRequestTo competitionRequestTo = new CompetitionRequestTo();
		competitionRequestTo.setCompetitionId(new ObjectToId(idCompetition));

		HttpEntity<Object> requestEntity = new HttpEntity<Object>(
				competitionRequestTo, requestHeaders);

		// Head
		processHead(competitionRequestTo);

		// GetTypes
		requestEntity = new HttpEntity<Object>(competitionRequestTo,
				requestHeaders);
		processGetTypes(requestEntity, competitionRequestTo);

		// getMatchs
		competitionRequestTo = new CompetitionRequestTo();
		competitionRequestTo.setCompetitionId(new ObjectToId(idCompetition));
		requestEntity = new HttpEntity<Object>(competitionRequestTo,
				requestHeaders);
		processMatch(requestEntity, competitionRequestTo);

		LOG.debug("ID COMPETITION END ---> " + idCompetition);

		RestTemplateUtil.writeToFile(clientConfig.getRestFileLog(),
				"COMPETITION STARTED TO PROCESS -- " + idCompetition);
	}

	/**
	 * Process the head request
	 * 
	 * @param competitionRequestTo
	 */
	private void processHead(final CompetitionRequestTo competitionRequestTo) {

		RestClient localRestClient = appContext.getBean(RestClient.class);

		HttpEntity<Object> requestEntity = new HttpEntity<Object>(
				competitionRequestTo, requestHeaders);

		try {
			RestTemplateUtil.executorServiceSender
					.submit(new RequestSender(
							localRestClient,
							".results/ResultsModule/rest/competitionLongTermController/getHead",
							requestEntity, writeURLs)).get();
		} catch (Exception e) {
			RestTemplateUtil.writeToFile(localRestClient.getConfig()
					.getRestFileLog(), "[ERROR] " + e.getMessage());
		}

		LOG.debug("ID COMPETITION ---> " + idCompetition + " GET HEAD");

	}

	/**
	 * Process the getTypes request
	 * 
	 * @param requestEntity
	 * @param competitionRequestTo
	 */
	private void processGetTypes(final HttpEntity<Object> requestEntity,
			final CompetitionRequestTo competitionRequestTo) {

		RestClient localRestClient = appContext.getBean(RestClient.class);

		String body;
		try {
			body = RestTemplateUtil.executorServiceSender
					.submit(new RequestSender(
							localRestClient,
							".results/ResultsModule/rest/competitionEventController/getBetTypes",
							requestEntity, writeURLs)).get();

			LOG.debug("ID COMPETITION ---> " + idCompetition + " GET TYPES");
			TabResponseTo typesResponse = RestTemplateUtil.fromJsonToJava(body,
					TabResponseTo.class);

			if (typesResponse != null && typesResponse.getTabs().size() > 0) {
				for (int i = 0; i < typesResponse.getTabs().size(); ++i) {
					processGetOdds(idCompetition, typesResponse.getTabs()
							.get(i).getId(), localRestClient);
					LOG.debug("ID COMPETITION ---> " + idCompetition
							+ " GET ODDS");
				}
			}

		} catch (Exception e) {
			RestTemplateUtil.writeToFile(localRestClient.getConfig()
					.getRestFileLog(), "[ERROR] " + e.getMessage());
		}
	}

	/**
	 * Process the getOdds request
	 * 
	 * @param competitionId
	 * @param initialTabsId
	 */
	private void processGetOdds(final String competitionId,
			final ObjectToId initialTabsId, IRestClient localRestClient) {

		CompetitionRequestTo competitionRequestTo = new CompetitionRequestTo();
		competitionRequestTo.setCompetitionId(new ObjectToId(competitionId));

		competitionRequestTo.setBetTypeIdFirstLevel(initialTabsId);
		HttpEntity<Object> requestEntity = new HttpEntity<Object>(
				competitionRequestTo, requestHeaders);
		try {

			String body = RestTemplateUtil.executorServiceSender
					.submit(new RequestSender(
							localRestClient,
							".results/ResultsModule/rest/competitionEventController/getBetOdds",
							requestEntity, writeURLs)).get();

			if (body != null
					&& localRestClient.getConfig().getRequestLevel() >= IRestLevel.LEVEL_4) {
				LOG.debug("Odds Body: " + body);
				ObjectMapper mapper = new ObjectMapper();
				JavaType type = mapper.getTypeFactory()
						.constructCollectionType(List.class,
								TableResponseTo.class);
				List<TableResponseTo> lmap = (List<TableResponseTo>) RestTemplateUtil
						.fromJsonToJavaList(body, TableResponseTo.class);
				if (lmap != null && lmap.size() > 0) {
					for (TableResponseTo tableResponseTo : lmap) {
						List<TableResponseRowTo> rows = tableResponseTo
								.getRows();
						if (rows != null && rows.size() > 0) {
							for (TableResponseRowTo lrrt : rows) {
								RestTemplateUtil.executorService
										.execute(new EventDetailTask(
												appContext, localRestClient,
												lrrt.getObjectToId(), writeURLs));
								List<TableResponseCellTo> ltrct = lrrt
										.getCellList();
							}
						}
					}
				}
			}

		} catch (Exception e) {
			RestTemplateUtil.writeToFile(localRestClient.getConfig()
					.getRestFileLog(), "[ERROR] " + e.getMessage());
		}

	}

	/**
	 * Process Match request
	 * 
	 * @param requestEntity
	 * @param competitionRequestTo
	 */
	private void processMatch(final HttpEntity<Object> requestEntity,
			final CompetitionRequestTo competitionRequestTo) {
		RestClient localRestClient = appContext.getBean(RestClient.class);

		try {
			String body = RestTemplateUtil.executorServiceSender
					.submit(new RequestSender(
							localRestClient,
							".results/ResultsModule/rest/competitionLongTermController/getMatchs",
							requestEntity, writeURLs)).get();

			if (body != null
					&& body.length() > 0
					&& localRestClient.getConfig().getRequestLevel() >= IRestLevel.LEVEL_4) {
				ObjectMapper mapper = new ObjectMapper();
				TableResponseTo trt = (TableResponseTo) RestTemplateUtil
						.fromJsonToJava(body, TableResponseTo.class);
				if (trt.getRows() != null && trt.getRows().size() > 0) {
					for (TableResponseRowTo trrt : trt.getRows()) {
						List<TableResponseCellTo> ltrct = trrt.getCellList();
						for (TableResponseCellTo cellI : ltrct) {
							LinkTo linkTo = cellI.getLinkTo();
							if (linkTo != null
									&& linkTo.getObjectToId() != null) {
								RestTemplateUtil.executorService
										.execute(new EventDetailTask(
												appContext, localRestClient,
												linkTo.getObjectToId(),
												writeURLs));
								LOG.debug("ID COMPETITION ---> "
										+ idCompetition + "GET TYPES");
							}
						}
					}
				}
			}

		} catch (Exception e) {
			RestTemplateUtil.writeToFile(localRestClient.getConfig()
					.getRestFileLog(), "[ERROR] " + e.getMessage());
		}

	}

	/**
	 * Process the bet detail.
	 * 
	 * @param eventId
	 */
	private void apuestasDelEventoDetalladas(ObjectToId eventId,
			RestClient localRestClient) {

	}

}

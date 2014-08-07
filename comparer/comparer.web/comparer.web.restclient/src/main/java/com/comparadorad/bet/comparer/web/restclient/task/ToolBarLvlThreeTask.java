package com.comparadorad.bet.comparer.web.restclient.task;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.http.HttpEntity;

import com.comparadorad.bet.comparer.web.client.gwt.toolbar.sports.bean.Level;
import com.comparadorad.bet.comparer.web.client.gwt.toolbar.sports.bean.ToolbarElementListTo;
import com.comparadorad.bet.comparer.web.client.gwt.toolbar.sports.bean.ToolbarElementTo;
import com.comparadorad.bet.comparer.web.restclient.exec.RequestSender;
import com.comparadorad.bet.comparer.web.restclient.util.RestTemplateUtil;

/**
 * Task for process the toolbar navigation's third level. Process the
 * competitions.
 * 
 * @author rdomingo
 * 
 */
public class ToolBarLvlThreeTask extends AbstractLevelTask {
	/** The Constant LOG. */
	public static final Log LOG = LogFactory.getLog(ToolBarLvlThreeTask.class);

	private ToolbarElementTo toolBarElement;

	public ToolBarLvlThreeTask(AnnotationConfigApplicationContext appContext,
			ToolbarElementTo element, Boolean writeURLs) {
		super(appContext, writeURLs);
		toolBarElement = element;
	}

	@Override
	public void run() {

		ToolbarElementTo toolBarElementTo = new ToolbarElementTo();
		toolBarElementTo.setLevel(Level.NIVEL_3);
		toolBarElementTo.setRegionId(toolBarElement.getRegionId());
		toolBarElementTo.setSportId(toolBarElement.getSportId());
		HttpEntity<Object> requestEntity = new HttpEntity<Object>(
				toolBarElementTo, requestHeaders);
		String body;
		try {

			body = RestTemplateUtil.executorServiceSender
					.submit(new RequestSender(
							restClient,
							".toolbar/ToolbarModule/rest/toolbarElementController/toolbarElementList",
							requestEntity, writeURLs)).get();

			ToolbarElementListTo toolbarElementListTo = RestTemplateUtil
					.fromJsonToJava(body, ToolbarElementListTo.class);
			if (toolbarElementListTo != null
					&& restClient.getConfig().getRequestLevel() >= IRestLevel.LEVEL_3) {
				List<ToolbarElementTo> allToolBarElements = toolbarElementListTo
						.getToolbarElementList();

				for (ToolbarElementTo toolBarElement : allToolBarElements) {
					RestTemplateUtil.executorService
							.execute(new CompetitionTask(appContext,
									toolBarElement.getCompetitionId(),
									writeURLs));

					LOG.debug("Thread ID: " + Thread.currentThread().getId()
							+ " - Competition Name: "
							+ toolBarElement.getElementName()
							+ ", Competition del Tab: "
							+ toolBarElement.getCompetitionId());

				}
			}

		} catch (Exception e) {
			RestTemplateUtil.writeToFile(restClient.getConfig()
					.getRestFileLog(), "[ERROR] " + e.getMessage());
		}

	}

}

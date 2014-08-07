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
 * Task ToolBarLvlTwoTaskthe toolbar navigation's second level. Process the
 * regions.
 * 
 * @author rdomingo
 * 
 */
public class ToolBarLvlTwoTask extends AbstractLevelTask {

	/** The Constant LOG. */
	final Log LOG = LogFactory.getLog(ToolBarLvlTwoTask.class);

	private ToolbarElementTo toolBarElement;

	public ToolBarLvlTwoTask(AnnotationConfigApplicationContext appContext,
			ToolbarElementTo element, Boolean writeURLs) {
		super(appContext, writeURLs);
		toolBarElement = element;
		// nextLevelExecutor = Executors.newScheduledThreadPool(3);
	}

	@Override
	public void run() {

		ToolbarElementTo toolBarElementTo = new ToolbarElementTo();
		toolBarElementTo.setLevel(Level.NIVEL_2);
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

			ToolbarElementListTo toolbarElementListTo2 = RestTemplateUtil
					.fromJsonToJava(body, ToolbarElementListTo.class);
			if (toolbarElementListTo2 != null
					&& restClient.getConfig().getRequestLevel() >= IRestLevel.LEVEL_2) {
				List<ToolbarElementTo> allCountries = toolbarElementListTo2
						.getToolbarElementList();

				LOG.debug(toolBarElement.getSportId() + " -------> "
						+ allCountries.size());
				for (ToolbarElementTo tbe : allCountries) {
					LOG.debug("Thread ID: " + Thread.currentThread().getId()
							+ " - launch country: " + tbe.getElementName()
							+ " on sport: " + tbe.getSportId());

					RestTemplateUtil.executorService
							.execute(new ToolBarLvlThreeTask(appContext, tbe,
									writeURLs));
				}
			}

		} catch (Exception e) {
			RestTemplateUtil.writeToFile(restClient.getConfig()
					.getRestFileLog(), "[ERROR] " + e.getMessage());
		}

	}

}

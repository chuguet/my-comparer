package com.comparadorad.bet.comparer.web.restclient.task;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.http.HttpEntity;

import com.comparadorad.bet.comparer.web.client.gwt.imageslider.bean.request.ImageSliderRequestTo;
import com.comparadorad.bet.comparer.web.client.gwt.toolbar.sports.bean.Level;
import com.comparadorad.bet.comparer.web.client.gwt.toolbar.sports.bean.ToolbarElementListTo;
import com.comparadorad.bet.comparer.web.client.gwt.toolbar.sports.bean.ToolbarElementTo;
import com.comparadorad.bet.comparer.web.restclient.exec.RequestSender;
import com.comparadorad.bet.comparer.web.restclient.util.RestTemplateUtil;

/**
 * Task for process the toolbar navigation's first level. Process the sports.
 * 
 * @author rdomingo
 * 
 */
public class ToolBarLvlOneTask extends AbstractLevelTask {

	/** The Constant LOG. */
	public static final Log LOG = LogFactory.getLog(ToolBarLvlOneTask.class);

	public ToolBarLvlOneTask(AnnotationConfigApplicationContext appContext,
			Boolean writeURLs) {
		super(appContext, writeURLs);
	}

	/**
	 * {@inheritDoc}
	 */
	public void run() {

		// RestTemplateUtil.writeToFile(clientConfig.getRestFileLog(),
		// "Begin - Thread-ID [" + Thread.currentThread().getId()
		// + "] -- LEVEL 1 -START-");

		ToolbarElementTo toolBarElementTo = new ToolbarElementTo();
		toolBarElementTo.setLevel(Level.NIVEL_1);

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

			// getEventData
			ImageSliderRequestTo imageSliderRequestTo = new ImageSliderRequestTo();
			requestEntity = new HttpEntity<Object>(imageSliderRequestTo,
					requestHeaders);

			body = RestTemplateUtil.executorServiceSender
					.submit(new RequestSender(
							restClient,
							".islider/ImgSliderModule/rest/imageSliderController/getEventData",
							requestEntity, writeURLs)).get();

			if (toolbarElementListTo != null
					&& restClient.getConfig().getRequestLevel() >= IRestLevel.LEVEL_1) {
				List<ToolbarElementTo> allSports = toolbarElementListTo
						.getToolbarElementList();

				for (ToolbarElementTo sport : allSports) {
					LOG.debug("Thread ID: " + Thread.currentThread().getId()
							+ " - launch sport: " + sport.getElementName()
							+ " with ID: " + sport.getSportId());

					RestTemplateUtil.executorService
							.execute(new ToolBarLvlTwoTask(appContext, sport,
									writeURLs));

					RestTemplateUtil.executorService
							.execute(new SportsCountriesTask(appContext, sport
									.getSportId(), writeURLs));

				}
			}

		} catch (Exception e) {
			RestTemplateUtil.writeToFile(restClient.getConfig()
					.getRestFileLog(), "[ERROR] " + e.getMessage());
		}
	}
}

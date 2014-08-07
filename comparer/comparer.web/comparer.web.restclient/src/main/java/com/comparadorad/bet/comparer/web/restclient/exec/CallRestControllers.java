package com.comparadorad.bet.comparer.web.restclient.exec;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

import com.comparadorad.bet.comparer.util.commons.profile.ProfileConstant;
import com.comparadorad.bet.comparer.web.restclient.config.RestClientConfig;
import com.comparadorad.bet.comparer.web.restclient.core.RestClient;
import com.comparadorad.bet.comparer.web.restclient.task.ToolBarLvlOneTask;
import com.comparadorad.bet.comparer.web.restclient.util.RestTemplateUtil;

/**
 * Call all Controllers to actualize Cache.
 * 
 * TODO: This method is only at the begin TODO: It will be do with Threads, but
 * restClient is unique (injected) and not may be shared between threads...it
 * will must be one restClient for thread declared in the Scheduler
 * 
 * @author farce
 * 
 */
@SuppressWarnings("unused")
public class CallRestControllers {

	/** The Constant LOG. */
	public static final Log LOG = LogFactory.getLog(CallRestControllers.class);

	private static RestClient restClient;
	private static RestClientConfig clientConfig;
	private HttpHeaders requestHeaders = null;
	private AnnotationConfigApplicationContext ctx = null;

	/**
	 * Main Method to do execution.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		new CallRestControllers().execute();

	}

	/**
	 * Main Method in a not static context.
	 */
	protected void execute() {
		ctx = new AnnotationConfigApplicationContext();
		ctx.getEnvironment().setActiveProfiles(ProfileConstant.TEST);
		ctx.register(RestClientConfig.class);
		ctx.refresh();

		restClient = ctx.getBean(RestClient.class);
		clientConfig = ctx.getBean(RestClientConfig.class);

		requestHeaders = new HttpHeaders();
		requestHeaders.setContentType(MediaType.APPLICATION_JSON);

		RestTemplateUtil.executorService.execute(new ToolBarLvlOneTask(ctx,
				true));
	}
}

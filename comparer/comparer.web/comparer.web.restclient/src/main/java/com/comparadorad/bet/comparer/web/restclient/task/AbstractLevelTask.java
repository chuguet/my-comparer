package com.comparadorad.bet.comparer.web.restclient.task;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

import com.comparadorad.bet.comparer.web.restclient.config.RestClientConfig;
import com.comparadorad.bet.comparer.web.restclient.core.IRestClient;
import com.comparadorad.bet.comparer.web.restclient.core.RestClient;

/**
 * Class with the generic behavior for rest task.
 * 
 * @author rdomingo
 * 
 */
public abstract class AbstractLevelTask implements Runnable {

	protected AnnotationConfigApplicationContext appContext;

	protected HttpHeaders requestHeaders = null;

	protected RestClientConfig clientConfig;
	protected IRestClient restClient;

	protected Boolean writeURLs;


	/**
	 * Task constructor. Create a new instance of the rest client and
	 * initializes the task executor with a single executor thread. Sets the
	 * default values for the client configuration and for the httHeader.
	 * Configurations are loaded by spring.
	 */
	public AbstractLevelTask(AnnotationConfigApplicationContext context,
			Boolean writeURLs) {
		appContext = context;

		restClient = appContext.getBean(RestClient.class);
		this.writeURLs = writeURLs;
		clientConfig = appContext.getBean(RestClientConfig.class);

		requestHeaders = new HttpHeaders();
		requestHeaders.setContentType(MediaType.APPLICATION_JSON);

	}

}

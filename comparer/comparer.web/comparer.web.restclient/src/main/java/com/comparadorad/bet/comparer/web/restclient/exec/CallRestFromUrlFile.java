package com.comparadorad.bet.comparer.web.restclient.exec;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

import com.comparadorad.bet.comparer.util.commons.profile.ProfileConstant;
import com.comparadorad.bet.comparer.web.restclient.config.RestClientConfig;
import com.comparadorad.bet.comparer.web.restclient.core.RestClient;
import com.comparadorad.bet.comparer.web.restclient.util.RestTemplateUtil;

public class CallRestFromUrlFile {
	/** The Constant LOG. */
	public static final Log LOG = LogFactory.getLog(CallRestControllers.class);

	// Al ser un main (no un test) no he sabido instanciar el contexto
	// sino es con un new, por eso no puedo inyectar los beans.
	private static RestClient restClient;
	private static RestClientConfig clientConfig;
	private HttpHeaders requestHeaders = null;
	private AnnotationConfigApplicationContext ctx = null;

	private Integer fileNumberRecords = 0;

	/**
	 * Main Method to do execution.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		new CallRestFromUrlFile().execute();
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

		// Integer numberOfThreads = Runtime.getRuntime().availableProcessors();
		//
		// RestTemplateUtil.writeToFile(clientConfig.getRestFileLog(),
		// "START EXECUTION - THREADS AVAILABLE " + numberOfThreads);
		// executor = Executors.newScheduledThreadPool(numberOfThreads);

		try {
			readFromFile();
		} catch (Exception e) {
			RestTemplateUtil.writeToFile(restClient.getConfig()
					.getRestFileLog(), "[ERROR] " + e.getMessage());
		}
	}

	/**
	 * Read file line by line and adds execution tasks to the scheduler for been
	 * process.
	 * 
	 * @throws IOException
	 */
	public void readFromFile() throws IOException

	{
		InputStream fstream = null;
		BufferedReader br = null;

		String urlToSend;
		String entityObjectClass;
		String jsonBody;

		HttpEntity<Object> requestToSend;

		StringTokenizer stTokenizer;

		try {
			fstream = new FileInputStream(restClient.getConfig()
					.getRestFileLogURLs());
			br = new BufferedReader(new InputStreamReader(fstream));

			String strLine;
			/* read log line by line */
			while ((strLine = br.readLine()) != null) {
				RestClient localRestClient = ctx.getBean(RestClient.class);
				stTokenizer = new StringTokenizer(strLine,
						RestTemplateUtil.SEPARATOR);
				stTokenizer.nextToken();
				urlToSend = stTokenizer.nextToken();
				entityObjectClass = stTokenizer.nextToken();
				jsonBody = stTokenizer.nextToken();

				requestToSend = new HttpEntity<Object>(
						RestTemplateUtil.fromJsonToJava(jsonBody,
								Class.forName(entityObjectClass)),
						requestHeaders);

				String[] st = urlToSend.split("/");
				RestTemplateUtil.writeToFile(clientConfig.getRestFileLog(),
						"[URL-READ] " + st[st.length - 1] + jsonBody);

				RestTemplateUtil.executorService.execute(new RestCallTask(
						fileNumberRecords, urlToSend, requestToSend,
						localRestClient));

				fileNumberRecords++;
			}

			RestTemplateUtil.writeToFile(clientConfig.getRestFileLog(),
					" [READ-END] clousing file...");

			fstream.close();
			br.close();
		} catch (Exception e) {
			System.err.println("Error: " + e.getMessage());
			fstream.close();
			br.close();
		}
	}

	/**
	 * Inner class for launch a http request
	 * 
	 * @author rdomingo
	 * 
	 */
	private class RestCallTask implements Runnable {
		private Integer urlNumber = 0;
		private RestClient localRestClient;

		private String url;
		private HttpEntity<Object> request;

		public RestCallTask(Integer urlCount, String urlRest,
				HttpEntity<Object> requestEntity, RestClient restClient) {
			urlNumber = urlCount;
			localRestClient = restClient;
			url = urlRest.replace(localRestClient.getConfig().getUrl(), "");
			request = requestEntity;

		}

		@Override
		public void run() {

			String response;

			try {

				response = RestTemplateUtil.executorServiceSender.submit(
						new RequestSender(localRestClient, url, request, false))
						.get();

				String[] st = url.split("/");
				RestTemplateUtil
						.writeToFile(clientConfig.getRestFileLog(), "Url "
								+ urlNumber + "/" + fileNumberRecords + " "
								+ st[st.length - 1] + " - " + request.getBody());

				if (!response.isEmpty()) {

					LOG.debug("Url " + urlNumber + "/" + fileNumberRecords
							+ " " + st[st.length - 1] + " - "
							+ request.getBody());
				} else {
					LOG.debug("[ NO RESPONSE RECEIVED ]");
				}

			} catch (InterruptedException e) {
				RestTemplateUtil.writeToFile(restClient.getConfig()
						.getRestFileLog(), "[ERROR] " + e.getMessage());
			} catch (ExecutionException e) {
				RestTemplateUtil.writeToFile(restClient.getConfig()
						.getRestFileLog(), "[ERROR] " + e.getMessage());
			}

		}

	}
}

package com.comparadorad.bet.comparer.web.restclient.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.StringTokenizer;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.JavaType;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Component;

import com.comparadorad.bet.comparer.util.commons.profile.ProfileConstant;
import com.comparadorad.bet.comparer.web.restclient.config.RestClientConfig;
import com.comparadorad.bet.comparer.web.restclient.core.RestClient;
import com.comparadorad.bet.comparer.web.restclient.exception.RestClientException;

/**
 * Utility Class in the call to RestClient Process
 * 
 * @author farce
 * 
 */
@Component
public class RestTemplateUtil {
	/** The Constant LOG. */
	public static final Log LOG = LogFactory.getLog(RestTemplateUtil.class);

	public static final String TOKEN_BASE_URL = "baseURL";

	public static final String TOKEN_HTTP_BODY = "body";

	public static final String TOKEN_HTTP_HEADER = "header";

	public static final String SEPARATOR = ";";

	public static ExecutorService executorService;

	public static ExecutorService executorServiceSender;

	public static String path = "";

	public static String currentProcessTime = "";

	private static AtomicInteger errorCount = new AtomicInteger(0);

	// De manera estatica carga al iniciar la configuracion de la aplicacion
	// referente a el manejo de procesos
	static {

		Date now = new Date();
		SimpleDateFormat formateador = new SimpleDateFormat("ddMM-hh_mm");
		currentProcessTime = formateador.format(now);

		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
		ctx.getEnvironment().setActiveProfiles(ProfileConstant.TEST);
		ctx.register(RestClientConfig.class);
		ctx.refresh();

		RestClientConfig clientConfig = ctx.getBean(RestClientConfig.class);

		path = clientConfig.getRestFileLog();

		Integer maxThreads = Integer.valueOf(clientConfig.getThreadsNumber());

		if (maxThreads > 0) {
			executorServiceSender = Executors
					.newScheduledThreadPool(maxThreads);

			executorService = Executors.newFixedThreadPool(maxThreads * 4);

			// Proceso para cerrar los pools cuando no se ejecute ninguna tarea
			// ni existan en cola
			final ScheduledExecutorService terminator = Executors
					.newSingleThreadScheduledExecutor();

			terminator.scheduleWithFixedDelay(new Runnable() {

				@Override
				public void run() {
					if (((ThreadPoolExecutor) executorServiceSender).getQueue()
							.size() == 0
							&& ((ThreadPoolExecutor) executorServiceSender)
									.getActiveCount() == 0) {

						System.out.println("Clousing Executors...");
						System.out.println("Numero de errores: " + errorCount);
						executorServiceSender.shutdown();
						executorService.shutdown();
						terminator.shutdown();

					}
				}
			}, 2, 2, TimeUnit.MINUTES);

		}

	}

	/**
	 * Calls RestTemplate client with HttpEntity object (headers and Object with
	 * parameters)
	 * 
	 * @param urlSuffix
	 *            , url of controller RequestMappins, after, url base from
	 *            server
	 * @param requestEntity
	 *            , HttpEntity with headers and Object containing parameters
	 * @return String with response body.
	 */
	public static synchronized String callingRest(RestClient restClient,
			String urlSuffix, HttpEntity<Object> requestEntity) {
		try {
			return restClient.callController(urlSuffix, requestEntity, true, 0);

		} catch (RestClientException e) {
			LOG.error("Error. Mesage: " + e.getMessage());
			RestTemplateUtil.writeToFile(path,
					e.getMessage() + requestEntity.getBody());
			return "";
		}
	}

	/**
	 * Calls RestTemplate client with HttpEntity object (headers and Object with
	 * parameters)
	 * 
	 * @param urlSuffix
	 *            , url of controller RequestMappins, after, url base from
	 *            server
	 * @param requestEntity
	 *            , HttpEntity with headers and Object containing parameters
	 * @return String with response body.
	 */
	public static synchronized String callingRest(RestClient restClient,
			String urlSuffix, HttpEntity<Object> requestEntity, Boolean saveUrls) {
		try {
			return restClient.callController(urlSuffix, requestEntity,
					saveUrls, 0);

		} catch (RestClientException e) {
			LOG.error("Error. Mesage: " + e.getMessage());
			RestTemplateUtil.writeToFile(path,
					e.getMessage() + requestEntity.getBody());
			return "";
		}
	}

	/**
	 * Call to mapper to do the transformation of a String filling attributes os
	 * Class c
	 * 
	 * @param body
	 * @param c
	 * @return
	 */
	@SuppressWarnings({ "unchecked" })
	public synchronized static <T> T fromJsonToJava(String body, Class<?> T) {
		ObjectMapper mapper = new ObjectMapper();
		try {
			return (T) mapper.readValue(body, T);
		} catch (JsonParseException e) {
			LOG.error("Error. Mesage: " + e.getMessage());
			RestTemplateUtil.writeToFile(path, e.getMessage() + body);
		} catch (JsonMappingException e) {
			LOG.error("Error. Mesage: " + e.getMessage());
			RestTemplateUtil.writeToFile(path, e.getMessage() + body);
		} catch (IOException e) {
			LOG.error("Error. Mesage: " + e.getMessage());
			RestTemplateUtil.writeToFile(path, e.getMessage() + body);
		}

		return null;
	}

	/**
	 * Json to Java when the object has inner lists.
	 * 
	 * @param body
	 */
	public static List<?> fromJsonToJavaList(String body, Class<?> T) {
		ObjectMapper mapper = new ObjectMapper();
		JavaType type = mapper.getTypeFactory().constructCollectionType(
				List.class, T);
		try {
			return mapper.readValue(body, type);
		} catch (JsonParseException e) {
			LOG.error("Error. Mesage: " + e.getMessage());
			RestTemplateUtil.writeToFile(path, e.getMessage() + body);
		} catch (JsonMappingException e) {
			LOG.error("Error. Mesage: " + e.getMessage());
			RestTemplateUtil.writeToFile(path, e.getMessage() + body);
		} catch (IOException e) {
			LOG.error("Error. Mesage: " + e.getMessage());
			RestTemplateUtil.writeToFile(path, e.getMessage() + body);
		}

		// TODO: Ojo, que no devuelve nada
		return null;
	}

	/**
	 * Transforms Java Object to Json Representation
	 * 
	 * @param object
	 * @return
	 */
	public static String fromJavaToJson(Object object) {
		ObjectMapper mapper = new ObjectMapper();
		try {
			return mapper.writeValueAsString(object);
		} catch (JsonGenerationException e) {
			LOG.error("Error. Mesage: " + e.getMessage());
			RestTemplateUtil.writeToFile(path, e.getMessage());
		} catch (JsonMappingException e) {
			LOG.error("Error. Mesage: " + e.getMessage());
			RestTemplateUtil.writeToFile(path, e.getMessage());
		} catch (IOException e) {
			LOG.error("Error. Mesage: " + e.getMessage());
			RestTemplateUtil.writeToFile(path, e.getMessage());
		}
		return "-- null -- ";
	}

	/**
	 * Write to File
	 * 
	 * @param filePath
	 * @param fileContent
	 */
	public static void writeToFile(String filePath, String fileContent) {
		// get which file you want to read and write
		File file = new File(filePath + "-" + currentProcessTime + ".log");

		if (fileContent.contains("[ERROR]")) {
			errorCount.set(errorCount.get() + 1);
		}

		try {

			// check whether the file is existed or not
			if (file.exists()) {
				// create a new file if the file is not existed
				file.createNewFile();
			}

			// new a writer and point the writer to the file

			FileWriter fileWritter = new FileWriter(filePath + "-"
					+ currentProcessTime + ".log", true);
			BufferedWriter writer = new BufferedWriter(fileWritter);

			// writer the content to the file
			StringTokenizer st = new StringTokenizer("["
					+ new Date().toString() + "] " + fileContent, "\n");
			while (st.hasMoreTokens()) {
				String line = st.nextToken();
				writer.write(line);
				writer.newLine();
			}

			// always remember to close the writer
			writer.close();
		} catch (IOException e) {
			LOG.error("Error: " + e.getMessage());
			RestTemplateUtil.writeToFile(path, e.getMessage());
		}
	}

	/**
	 * Write to File
	 * 
	 * @param filePath
	 * @param fileContent
	 */
	public static void writeURLToFile(String filePath, String url,
			HttpEntity<Object> requestEntity) {

		// get which file you want to read and write
		File file = new File(filePath + "-" + currentProcessTime + ".log");

		String fileContent = "";

		try {

			// check whether the file is existed or not
			if (file.exists()) {
				// create a new file if the file is not existed
				file.createNewFile();
			}
			fileContent += url + SEPARATOR;
			fileContent += requestEntity.getBody().getClass().getName()
					+ SEPARATOR;
			fileContent += RestTemplateUtil.fromJavaToJson(requestEntity
					.getBody()) + "\n";

			// new a writer and point the writer to the file

			FileWriter fileWritter = new FileWriter(filePath + "-"
					+ currentProcessTime + ".log", true);
			BufferedWriter writer = new BufferedWriter(fileWritter);

			// writer the content to the file
			StringTokenizer st = new StringTokenizer(fileContent, "\n");
			while (st.hasMoreTokens()) {
				String line = st.nextToken();
				writer.write(line);
				writer.newLine();
			}

			// always remember to close the writer
			writer.close();
		} catch (IOException e) {
			LOG.error("Error: " + e.getMessage());
			RestTemplateUtil.writeToFile(path, e.getMessage());
		}
	}

}

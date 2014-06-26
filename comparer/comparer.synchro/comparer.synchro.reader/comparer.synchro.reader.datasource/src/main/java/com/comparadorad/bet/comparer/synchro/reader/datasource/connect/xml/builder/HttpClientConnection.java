/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */

package com.comparadorad.bet.comparer.synchro.reader.datasource.connect.xml.builder;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Authenticator;
import java.net.InetSocketAddress;
import java.net.PasswordAuthentication;
import java.net.Proxy;
import java.net.URL;
import java.net.URLConnection;
import java.security.cert.X509Certificate;
import java.util.concurrent.TimeUnit;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import javax.net.ssl.TrustManager;

import org.apache.commons.httpclient.DefaultHttpMethodRetryHandler;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.HttpMethodBase;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.URI;
import org.apache.commons.httpclient.UsernamePasswordCredentials;
import org.apache.commons.httpclient.auth.AuthScope;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.params.HttpMethodParams;
import org.apache.commons.httpclient.protocol.Protocol;
import org.apache.commons.io.IOUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.comparadorad.bet.comparer.synchro.reader.datasource.config.ProxyPassConfig;

/**
 * @author Juan Carlos
 *         http://www.adictosaltrabajo.com/tutoriales/tutoriales.php?
 *         pagina=HTTPClient
 * 
 */
public class HttpClientConnection {

	private static final Log LOG = LogFactory
			.getLog(HttpClientConnection.class);

	/**
	 * The Class HttpClientConnectionException.
	 */
	public class HttpClientConnectionException extends Exception {

		/** The http code. */
		private int httpCode;

		/**
		 * Gets the http code.
		 * 
		 * @return the http code
		 */
		public int getHttpCode() {
			return httpCode;
		}

		/**
		 * Instantiates a new http client connection exception.
		 * 
		 * @param pMessage
		 *            the message
		 * @param pHttpCode
		 *            the http code
		 */
		public HttpClientConnectionException(String pMessage, int pHttpCode) {
			super(pMessage);
			this.httpCode = pHttpCode;
		}

	}

	/**
	 * Authentication for the web (different of the proxy) The Class
	 * HttpClientConnectionAuthentication.
	 */
	public static class HttpClientConnectionAuthentication {

		/** The user. */
		private String user;

		/**
		 * Gets the user.
		 * 
		 * @return the user
		 */
		public String getUser() {
			return user;
		}

		/**
		 * Gets the password.
		 * 
		 * @return the password
		 */
		public String getPassword() {
			return password;
		}

		/**
		 * Instantiates a new http client connection authentication.
		 * 
		 * @param pUser
		 *            the user
		 * @param pPassword
		 *            the password
		 */
		public HttpClientConnectionAuthentication(String pUser, String pPassword) {
			super();
			user = pUser;
			password = pPassword;
		}

		/** The password. */
		private String password;
	}

	/**
	 * Por defecto haremos una petición HTTP GET. Cambiar a false para
	 * peticiones HTTP POST
	 */
	private boolean byGet = false;

	/** The number try reconnect. */
	private int numberTryReconnect = 3;

	/**
	 * Instantiates a new http client connection.
	 */
	public HttpClientConnection() {
		super();
	}

	/**
	 * Instantiates a new http client connection.
	 * 
	 * @param pByGet
	 *            the by get
	 */
	public HttpClientConnection(boolean pByGet) {
		super();
		byGet = pByGet;
	}

	/**
	 * Do connection.
	 * 
	 * @param url
	 *            the url
	 * @param proxyPassConfig
	 *            the proxy pass config
	 * @return the input stream
	 * @throws HttpException
	 *             the http exception
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 * @throws HttpClientConnectionException
	 *             the http client connection exception
	 */
	public InputStream doConnection(String url, ProxyPassConfig proxyPassConfig)
			throws HttpException, IOException, HttpClientConnectionException {
		return doConnection(url, proxyPassConfig, null);
	}

	/**
	 * Punto de inicio de ejecución del ejemplo.
	 * 
	 * @param url
	 *            the url
	 * @param proxyPassConfig
	 *            the proxy pass config
	 * @param httpClientConnectionAuthentication
	 *            the http client connection authentication
	 * @return the input stream
	 * @throws HttpException
	 *             the http exception
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 * @throws HttpClientConnectionException
	 *             the http client connection exception
	 */
	public InputStream doConnection(
			String url,
			ProxyPassConfig proxyPassConfig,
			final HttpClientConnectionAuthentication httpClientConnectionAuthentication)
			throws HttpException, IOException, HttpClientConnectionException {
		InputStream result = null;
		HttpClient httpClient = null; // Objeto a través del cual realizamos las
										// peticiones
		HttpMethodBase request = null; // Objeto para realizar las peticiines
										// HTTP GET o POST
		int status = 0; // Código de la respuesta HTTP
		
		
		// Instanciamos el objeto
		if (url.contains("https")) {
			try {
			    // Create a trust manager that does not validate certificate chains
			    final TrustManager[] trustAllCerts = new TrustManager[] { new X509TrustManager() {
			        @Override
			        public void checkClientTrusted( final X509Certificate[] chain, final String authType ) {
			        }
			        @Override
			        public void checkServerTrusted( final X509Certificate[] chain, final String authType ) {
			        }
			        @Override
			        public X509Certificate[] getAcceptedIssuers() {
			            return null;
			        }
			    } };
			    
			    // Install the all-trusting trust manager
			    final SSLContext sslContext = SSLContext.getInstance( "SSL" );
			    sslContext.init( null, trustAllCerts, new java.security.SecureRandom() );
			    // Create an ssl socket factory with our all-trusting manager
			    final SSLSocketFactory sslSocketFactory = sslContext.getSocketFactory();
			    
			    Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress(proxyPassConfig.getHost(), proxyPassConfig.getPort()));
			    getProxyAuthenticator(proxyPassConfig.getUser(),
						proxyPassConfig.getPassword());
			    
			    // All set up, we can get a resource through https now:
			    final URLConnection urlCon = new URL(url).openConnection(proxy);
			    
			    urlCon.setConnectTimeout(10000);
			    // Tell the url connection object to use our socket factory which bypasses security checks
			    ( (HttpsURLConnection) urlCon ).setSSLSocketFactory( sslSocketFactory );
			    
			    result = urlCon.getInputStream();
			    
			} catch ( final Exception e ) {
			    e.printStackTrace();
			}
		}  else {
			httpClient = new HttpClient();
			if (byGet) {
				// Invocamos por GET

				// Â¿ Nos conectamos a un servidor seguro ?
				// Observe que si están bien instalado JSSE (Java Secure Socket
				// Extension),
				// el código es exactamente igual
				URI uri = new URI(url, false);
				request = new GetMethod(uri.getEscapedURI());

				// Le indicamos que realize automáticamente el seguimiento de las
				// redirecciones
				// en caso de que existan.
				//request.setFollowRedirects(true);

				// Añadimos los parámetros que deseemos a la petición
				// GET: http://dominio/pagina?nombre=Carlos+Garc%C3%ADa
				// NameValuePair params[] = { new NameValuePair("nombre",
				// "Carlos GarcÃ­a") };
				// request.setQueryString(params);
			} else {
				// Invocamos por POST
				URI uri = new URI(url, false);
				request = new PostMethod(uri.getEscapedURI());

				// Añadimos los parámetros que deseemos a la petición
				// ((PostMethod) request).addParameter("nombre", "Carlos GarcÃ­a");
			}
			// Especificamos que salimos a través de un Proxy.
			if (proxyPassConfig != null && proxyPassConfig.isActive()
					&& proxyPassConfig.getHost() != null) {
				httpClient.getHostConfiguration().setProxy(
						proxyPassConfig.getHost(), proxyPassConfig.getPort());
				if (proxyPassConfig.getUser() != null) {
					httpClient.getState()
							.setProxyCredentials(
									new AuthScope(proxyPassConfig.getHost(),
											proxyPassConfig.getPort(),
											AuthScope.ANY_REALM),
									new UsernamePasswordCredentials(proxyPassConfig
											.getUser(), proxyPassConfig
											.getPassword()));

					getProxyAuthenticator(proxyPassConfig.getUser(),
							proxyPassConfig.getPassword());
				}
			}

			try {
				
					
				// Si su servidor requiere autentificación necesitará una lÃ­nea
				// como
				// la siguiente
				if (httpClientConnectionAuthentication != null
						&& httpClientConnectionAuthentication.getUser() != null) {
					UsernamePasswordCredentials credentials = new UsernamePasswordCredentials(
							httpClientConnectionAuthentication.getUser(),
							httpClientConnectionAuthentication.getPassword());
					httpClient.getState().setCredentials(
							new AuthScope(request.getURI().getHost(), request
									.getURI().getPort(), AuthScope.ANY_REALM),
							credentials);

					// Indicamos que se autentifique si fuese requerido
					request.setDoAuthentication(true);
				}

				// Indicamos reintente 3 veces en caso de que haya errores.
				request.getParams().setParameter(
						HttpMethodParams.RETRY_HANDLER,
						new DefaultHttpMethodRetryHandler(getNumberTryReconnect(),
								true));

				// Leemos el código de la respuesta HTTP que nos devuelve el
				// servidor
				LOG.debug("[ThreadId: "+Thread.currentThread().getId() +"] |"+"Connecting to: " + url);
				long startTime = System.currentTimeMillis();
				
				//timeout
				httpClient.getHttpConnectionManager().getParams().setSoTimeout(10000);
//				httpClient.setConnectionTimeout(10000);
				
				
				status = httpClient.executeMethod(request);

//				if ((status == HttpStatus.SC_MOVED_TEMPORARILY)
//						|| (status == HttpStatus.SC_MOVED_PERMANENTLY)
//						|| (status == HttpStatus.SC_SEE_OTHER)
//						|| (status == HttpStatus.SC_TEMPORARY_REDIRECT)) {
//					Header header = request.getResponseHeader("location");
//					if (header != null) {
//						String newuri = header.getValue();
//						if ((newuri == null) || (newuri.equals(""))) {
//							newuri = "/";
//						}
//						System.out.println("Redirect target: " + newuri);
//						GetMethod redirect = new GetMethod(newuri);
	//
//						httpClient.executeMethod(redirect);
//						System.out.println("Redirect: "
//								+ redirect.getStatusLine().toString());
//						// release any connection resources used by the method
//						redirect.releaseConnection();
//					} else {
//						System.out.println("Invalid redirect");
//						System.exit(1);
//					}
//				}

				// Vemos si la petición se ha realizado satisfactoriamente
				if (status != HttpStatus.SC_OK) {
					LOG.warn("Error\t" + request.getStatusCode() + "\t"
							+ request.getStatusText() + "\t"
							+ request.getStatusLine() + " URL: "
							+ request.getURI().toString());
					throw new HttpClientConnectionException(
							request.getStatusText(), request.getStatusCode());

				} else {
					byte[] tmpRes = IOUtils.toByteArray(request
							.getResponseBodyAsStream());
					result = new ByteArrayInputStream(tmpRes);
					long finishTime = System.currentTimeMillis();
					long elapsedTime = finishTime - startTime; // elapsed time in
					// milliseconds
					LOG.debug("Time for connection: "
							+ TimeUnit.MILLISECONDS.toSeconds(elapsedTime));
				}
			} finally {
				// Liberamos la conexión. (También libera los stream asociados)
				if (request != null) {
					request.releaseConnection();
				}
			}
		}
		

return result;
	}

	/**
	 * Gets the authenticator.
	 * 
	 * @param user
	 *            the user
	 * @param password
	 *            the password
	 * @return the authenticator
	 */
	protected void getProxyAuthenticator(final String user,
			final String password) {
		if (user != null && !"".equals(user) && password != null
				&& !"".equals(password)) {
			Authenticator.setDefault(new Authenticator() {
				@Override
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(user, password
							.toCharArray());
				}
			});
		}
	}

	/**
	 * Gets the number try reconnect.
	 * 
	 * @return the number try reconnect
	 */
	public int getNumberTryReconnect() {
		return numberTryReconnect;
	}

	/**
	 * Sets the number try reconnect.
	 * 
	 * @param pNumberTryReconnect
	 *            the new number try reconnect
	 */
	public void setNumberTryReconnect(int pNumberTryReconnect) {
		numberTryReconnect = pNumberTryReconnect;
	}
}
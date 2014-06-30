package com.comparadorad.bet.comparer.util.commons.resource;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.ClassRelativeResourceLoader;
import org.springframework.core.io.Resource;

public final class RelativeUtil {

	/** The Constant LOG. */
	private static final Log LOG = LogFactory.getLog(RelativeUtil.class);

	/**
	 * Make resource.
	 *
	 * @param path the path
	 * @param propertiesPath the properties path
	 * @return the resource
	 */
	public static List<Resource> makeResource(final String path,
			final String... propertiesPath) {
		Resource resource;
		ClassRelativeResourceLoader loader;
		String file;
		Boolean flag;
		List<Resource> result = new ArrayList<Resource>();

		for (int i = 0; i < propertiesPath.length; i++) {

			flag = Boolean.FALSE;
			file = propertiesPath[i];

			LOG.debug(new StringBuffer("It tries to load the file: ").append(
					path).append(file));

			loader = new ClassRelativeResourceLoader(RelativeUtil.class);
			resource = loader.getResource(new StringBuffer(path).append(file)
					.toString());

			if (resource.exists()) {
				flag = Boolean.TRUE;
			} else {

				LOG.error(new StringBuffer("It is not possible to load: ")
						.append(path).append(file));

				LOG.debug(new StringBuffer("It tries to load the file: ")
						.append(file));

				resource = new ClassPathResource(file);

				if (resource.exists()) {
					flag = Boolean.TRUE;
				} else {
					LOG.error(new StringBuffer("It is not possible to load: ")
							.append(file));
				}
			}

			if (flag) {
				result.add(resource);
			}

		}
		return result;
	}

	/**
	 * Convert resource to map.
	 *
	 * @param resources the resources
	 * @return the map
	 */
	public static Map<String, Object> convertResourceToMap(
			List<Resource> resources) {
		String key;
		Enumeration<Object> enumeration;
		Map<String, Object> result = new HashMap<String, Object>();
		List<String> keyList = new ArrayList<String>();
		Properties prop = new Properties();

		try {
			for (Resource resource : resources) {

				prop.load(resource.getInputStream());
				enumeration = prop.keys();
				
				while (enumeration.hasMoreElements()) {
					key =  (String) enumeration.nextElement();
					result.put(key,  prop.get(key));
				}

			}
		} catch (IOException e) {
			LOG.error(e);
		}

		return result;
	}
}


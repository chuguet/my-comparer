/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.util.commons.io;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.IOUtils;

/**
 * The Class JarUtil.
 */
public class JarUtil {

	/**
	 * The Class JarUtilException.
	 */
	public static class JarUtilException extends RuntimeException {

		/**
		 * Instantiates a new jar util exception.
		 */
		public JarUtilException() {
			super();

		}

		/**
		 * Instantiates a new jar util exception.
		 * 
		 * @param pMessage
		 *            the message
		 */
		public JarUtilException(String pMessage) {
			super(pMessage);

		}

		/**
		 * Instantiates a new jar util exception.
		 * 
		 * @param pMessage
		 *            the message
		 * @param pCause
		 *            the cause
		 */
		public JarUtilException(String pMessage, Throwable pCause) {
			super(pMessage, pCause);

		}

		/**
		 * Instantiates a new jar util exception.
		 * 
		 * @param pCause
		 *            the cause
		 */
		public JarUtilException(Throwable pCause) {
			super(pCause);

		}

	}

	/**
	 * Close jar file.
	 * 
	 * @param jarFile
	 *            the jar file
	 */
	private static void closeJarFile(final ZipFile jarFile) {
		if (jarFile != null) {
			try {
				jarFile.close();
			} catch (IOException ioe) {
				throw new JarUtilException(ioe);
			}
		}
	}

	/**
	 * Extract class from jar.
	 * 
	 * @param jar
	 *            the jar
	 * @param packageName
	 *            the package name
	 * @param wildcards
	 *            the wildcards
	 * @param classes
	 *            the classes
	 * @param jarEntry
	 *            the jar entry
	 * @param zf
	 *            the zf
	 * @throws Error
	 *             the error
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	private static void extractClassFromJar(final String jar,
			final String packageName, String[] wildcards,
			final List<byte[]> classes, ZipEntry jarEntry, ZipFile zf)
			throws Error, IOException {
		String fileName = jarEntry.getName().replaceAll("/", ".");
		if (fileName.startsWith(packageName)) {
			for (String wildCard : wildcards) {
				if (FilenameUtils.wildcardMatch(fileName, wildCard)) {
					classes.add(IOUtils.toByteArray(zf.getInputStream(jarEntry)));
				}
			}
		}
	}

	/**
	 * Gets the files from jar file.
	 * 
	 * @param jar
	 *            the jar
	 * @param packageName
	 *            the package name
	 * @param wildcards
	 *            the wildcards
	 * @return the files from jar file
	 * @throws Error
	 *             the error
	 */
	public static List<byte[]> getFilesFromJARFile(String jar,
			String packageName, String[] wildcards) throws Error {
		final List<byte[]> classes = new ArrayList<byte[]>();
		ZipFile zipFile = null;
		try {
			zipFile = new ZipFile(new File(jar));
			ZipEntry jarEntry;

			Enumeration entries = zipFile.entries();
			while (entries.hasMoreElements()) {
				jarEntry = (ZipEntry) entries.nextElement();
				if (jarEntry != null) {
					extractClassFromJar(jar, packageName, wildcards, classes,
							jarEntry, zipFile);
				}
			}
			closeJarFile(zipFile);
		} catch (IOException ioe) {
			throw new JarUtilException("Unable to get Jar input stream from '"
					+ jar + "'", ioe);
		} finally {
			closeJarFile(zipFile);
		}
		return classes;
	}
}

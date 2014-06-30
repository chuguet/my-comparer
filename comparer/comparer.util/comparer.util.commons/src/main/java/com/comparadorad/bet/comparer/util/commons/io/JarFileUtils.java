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
import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.filefilter.TrueFileFilter;
import org.apache.commons.io.filefilter.WildcardFileFilter;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * The Class JarFileUtils.
 */
public class JarFileUtils {

	private final static String ASTERISK = "*";

	private final static String CLASS = ".class";

	private final static String JAR = "jar!";

	/**
	 * The Class FileContent.
	 */
	public static class FileContent {

		/** The file content. */
		private byte[] fileContent;

		/** The file name. */
		private String fileName;

		/**
		 * Instantiates a new file content.
		 */
		public FileContent() {
			super();
		}

		/**
		 * Instantiates a new file content.
		 * 
		 * @param pFileName
		 *            the file name
		 * @param pFileContent
		 *            the file content
		 */
		public FileContent(String pFileName, byte[] pFileContent) {
			super();
			fileName = pFileName;
			fileContent = pFileContent;
		}

		/**
		 * Gets the file content.
		 * 
		 * @return the file content
		 */
		public byte[] getFileContent() {
			return fileContent;
		}

		/**
		 * Gets the file name.
		 * 
		 * @return the file name
		 */
		public String getFileName() {
			return fileName;
		}

		/**
		 * Sets the file content.
		 * 
		 * @param pFileContent
		 *            the new file content
		 */
		public void setFileContent(byte[] pFileContent) {
			fileContent = pFileContent;
		}

		/**
		 * Sets the file name.
		 * 
		 * @param pFileName
		 *            the new file name
		 */
		public void setFileName(String pFileName) {
			fileName = pFileName;
		}
	}

	/** The Constant LOG. */
	private static final Log LOG = LogFactory.getLog(JarFileUtils.class);

	/**
	 * Gets the files from class dir.
	 * 
	 * @param fileId
	 *            the file id
	 * @param fileExtension
	 *            the file extension
	 * @param callingClass
	 *            the calling class
	 * @return the files from class dir
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	private static Collection<?> getFilesFromClassDir(final String fileId,
			final String fileExtension, Class<?> callingClass)
			throws IOException {
		String fileDirectory = callingClass.getResource(
				callingClass.getSimpleName() + ".class").getPath();
		Collection<?> files = null;
		LOG.debug(new StringBuffer().append("Nombre de fichero a cargar: ")
				.append(fileId).append("*").append(fileExtension).toString());
		if (fileDirectory.contains("jar!")) {
			files = JarUtil.getFilesFromJARFile(callingClass
					.getProtectionDomain().getCodeSource().getLocation()
					.getPath(), callingClass.getPackage().getName(),
					new String[] { "*" + fileId + "*" + fileExtension });
		} else {
			files = FileUtils.listFiles(
					new File(fileDirectory).getParentFile(),
					new WildcardFileFilter(fileId + "*" + fileExtension),
					TrueFileFilter.INSTANCE);
		}
		if (files.size() == 0) {
			throw new IOException(new StringBuffer()
					.append("No se ha encontrado el fichero: ").append(fileId)
					.append("*").append(fileExtension)
					.append(" en localidad: ")
					.append(new File(fileDirectory).getParentFile()).toString());
		}
		return files;
	}

	/**
	 * List files.
	 * 
	 * @param fileId
	 *            the file id
	 * @param fileExtension
	 *            the file extension
	 * @param callingClass
	 *            the calling class
	 * @return the list
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	public static List<FileContent> listFilesFromClassDir(final String fileId,
			final String fileExtension, Class<?> callingClass)
			throws IOException {
		Collection<?> files = getFilesFromClassDir(fileId, fileExtension,
				callingClass);
		List<FileContent> result = null;
		if (files != null && !files.isEmpty()) {
			result = new ArrayList<FileContent>();
			for (Object object : files) {
				FileContent fileContent = new FileContent();
				if (object instanceof File) {
					fileContent.setFileContent(FileUtils
							.readFileToByteArray((File) object));
					fileContent.setFileName(((File) object).getName());
				} else {
					fileContent.setFileContent((byte[]) object);
				}
				result.add(fileContent);
			}
		}
		return result;
	}

	/**
	 * Resolve file.
	 * 
	 * @param fileId
	 *            the file id
	 * @param fileExtension
	 *            the file extension
	 * @param filePositionIndex
	 *            the file position index
	 * @param callingClass
	 *            the calling class
	 * @return the byte[]
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	public static byte[] resolveFile(final String fileId,
			final String fileExtension, Map<String, Integer> filePositionIndex,
			Class<?> callingClass) throws IOException {

		if (fileId == null || "".equals(fileId)) {
			return null;
		}
		byte[] result = null;
		String fileDirectory = callingClass.getResource(
				callingClass.getSimpleName() + CLASS).getPath();

		try {
			Collection<?> files = null;
			if (fileDirectory.contains(JAR)) {
				files = JarUtil.getFilesFromJARFile(callingClass
						.getProtectionDomain().getCodeSource().getLocation()
						.getPath(), callingClass.getPackage().getName(),
						new String[] { ASTERISK + fileId + ASTERISK
								+ fileExtension });
			} else {
				files = FileUtils.listFiles(
						new File(fileDirectory).getParentFile(),
						new WildcardFileFilter(fileId + ASTERISK
								+ fileExtension), TrueFileFilter.INSTANCE);
			}
			if (files != null && !files.isEmpty()) {
				Integer index = files.size() - 1;
				if (filePositionIndex.get(fileId) != null) {
					index = filePositionIndex.get(fileId);
				}
				if (index >= files.size()) {
					// we start for the first file if arrived to the end
					index = 0;
				}
				Object file = CollectionUtils.get(files, index);
				if (file instanceof File) {
					result = FileUtils.readFileToByteArray((File) file);
					LOG.debug("Returning file: " + ((File) file).getName());
				} else {
					result = (byte[]) file;
				}
				// LOG.debug("--" + new String(result));
				index++;
				filePositionIndex.put(fileId, index);
			}
		} catch (RuntimeException e) {
			LOG.error("Xml dummy file:" + fileDirectory);
			throw e;
		}
		return result;
	}
}

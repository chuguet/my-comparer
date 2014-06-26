/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.databaseclean.validators;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import javax.inject.Inject;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.comparadorad.bet.comparer.model.bet.bean.RtMatch;
import com.comparadorad.bet.comparer.synchro.databaseclean.data.DataConfiguration;

/**
 * The Class AbstractCleaner.
 */
abstract class AbstractDatabaseCleaner implements IDatabaseCleaner {

	/** The Constant DATE_FORMATTER. */
	private static final SimpleDateFormat DATE_FORMATTER = new SimpleDateFormat(
			"yyyy_MM_dd");

	/** The Constant LOG. */
	private static final Log LOG = LogFactory.getLog(AbstractDatabaseCleaner.class);

	/** The Constant TIME_FORMATTER. */
	private static final SimpleDateFormat TIME_FORMATTER = new SimpleDateFormat(
			"HH_mm_ss");

	/** The Constant GENERIC_PATH. */
	@Inject
	protected DataConfiguration dataProperties;

	/**
	 * Creates the zip path.
	 * 
	 * @return the string
	 */
	private String createZipPath() {
		Date currentDate = new Date();
		String folderName = new StringBuffer(dataProperties.getGenericPath())
				.append(DATE_FORMATTER.format(currentDate)).toString();
		new File(dataProperties.getGenericPath()).mkdir();
		new File(folderName).mkdir();
		return new StringBuffer(folderName).append("\\")
				.append(TIME_FORMATTER.format(currentDate)).append(".zip")
				.toString();
	}

	protected Integer calculateSkip(Integer skip, Long totalElements, Integer limitQuery) {
		skip += limitQuery;
		if (skip > totalElements) {
			skip = 0;
		}
		return skip;
	}

	/**
	 * Export matches to zip.
	 * 
	 * @param pastMatches
	 *            the past matches
	 */
	protected void exportMatchesToZip(Map<String, byte[]> jsonMatchs) {
		try {
			if (!jsonMatchs.keySet().isEmpty()) {
				String zipPath = createZipPath();
				LOG.info("Se genera las carpetas y la ruta del fichero ZIP");
				ZipOutputStream zipOut = new ZipOutputStream(
						new FileOutputStream(new File(zipPath)));
				ZipEntry zipEntry;

				for (String idMatch : jsonMatchs.keySet()) {
					zipEntry = new ZipEntry(new StringBuffer("MATCH_")
							.append(idMatch).append(".json").toString());
					zipOut.putNextEntry(zipEntry);
					zipOut.write(jsonMatchs.get(idMatch));
					zipOut.closeEntry();
				}

				zipOut.close();
				LOG.info(new StringBuffer(
						"Se genera el fichero zip y los ficheros json de los matchs.")
						.append(" Se zipean ")
						.append(jsonMatchs.keySet().size())
						.append(" partidos.").toString());
				LOG.info(new StringBuffer("Hay ")
						.append(jsonMatchs.keySet().size())
						.append(" partidos antiguos.").toString());
			} else {
				LOG.info("No hay partidos atrasados.");
			}
		} catch (IOException e) {
			LOG.error(e.getMessage());
		}
	}

	/**
	 * Past match.
	 * 
	 * @param match
	 *            the match
	 * @return true, if successful
	 */
	protected boolean isPastMatch(RtMatch match) {
		return match.getStartDate().getZeroGmtMatchDate().before(new Date());
	}

}

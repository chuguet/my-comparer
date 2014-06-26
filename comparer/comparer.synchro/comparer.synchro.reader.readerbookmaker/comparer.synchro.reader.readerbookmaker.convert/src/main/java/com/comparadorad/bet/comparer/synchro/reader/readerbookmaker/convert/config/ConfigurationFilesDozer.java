/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.convert.config;

/**
 * The Enum ConfigurationFilesDozer.
 */
public enum ConfigurationFilesDozer {

	/** The FIL e_ configuratio n_ doze r_ configuration. */
	FILE_CONFIGURATION_DOZER_CONFIGURATION(
			"dozer-bean-configuration-mappings.xml"),

	/** The FIL e_ configuratio n_ doze r_ betclik. */
	FILE_CONFIGURATION_DOZER_BETCLIK("dozer-bean-betclick-mappings.xml"),

	/** The FIL e_ configuratio n_ doze r_ williamhill. */
	FILE_CONFIGURATION_DOZER_WILLIAMHILL("dozer-bean-williamhill-mappings.xml"),

	/** The FIL e_ configuratio n_ doze r_ nordicbet. */
	FILE_CONFIGURATION_DOZER_NORDICBET("dozer-bean-nordicbet-mappings.xml");

	/** The file. */
	private final String file;

	/**
	 * Instantiates a new configuration files dozer.
	 * 
	 * @param file
	 *            the file
	 */
	ConfigurationFilesDozer(String file) {
		this.file = file;
	}

	/**
	 * File name.
	 * 
	 * @return the string
	 */
	public String fileName() {
		return file;
	}

}

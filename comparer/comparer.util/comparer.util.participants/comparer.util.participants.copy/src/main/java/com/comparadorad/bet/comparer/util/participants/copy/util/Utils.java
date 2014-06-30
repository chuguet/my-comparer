package com.comparadorad.bet.comparer.util.participants.copy.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.StringTokenizer;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Utility Class.
 * 
 * @author farce
 *
 */
public class Utils {
	
	/** The Constant LOG. */
	private static final Log LOG = LogFactory
			.getLog(Utils.class);

	/**
	 * Write to File
	 * @param filePath
	 * @param fileContent
	 */
	public static void writeToFile(String filePath, String fileContent) {
		// get which file you want to read and write
		File file = new File(filePath);
 
		try {
 
			// check whether the file is existed or not
			if (file.exists()) {
				// create a new file if the file is not existed
				file.createNewFile();
			}
 
			// new a writer and point the writer to the file
			
			FileWriter fileWritter = new FileWriter(filePath, true);
			BufferedWriter writer = new BufferedWriter(fileWritter);
 
			// writer the content to the file
			StringTokenizer st = new StringTokenizer(fileContent, "\n");
			while(st.hasMoreTokens()) {
				String line = st.nextToken();
				writer.write(line);
				writer.newLine();
			}			
			
			// always remember to close the writer
			writer.close();
		} catch (IOException e) {
			LOG.info("Error: " + e.getMessage());
			e.printStackTrace();
		} 		
	}
}

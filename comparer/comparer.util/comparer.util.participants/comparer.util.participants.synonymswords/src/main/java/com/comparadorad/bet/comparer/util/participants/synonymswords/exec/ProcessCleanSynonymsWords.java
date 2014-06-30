/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.util.participants.synonymswords.exec;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import org.apache.commons.lang.math.NumberUtils;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.comparadorad.bet.comparer.model.config.service.ICfgParticipantSynonymsService;
import com.comparadorad.bet.comparer.util.commons.profile.ProfileConstant;
import com.comparadorad.bet.comparer.util.logger.core.ComparerWrapperLog;
import com.comparadorad.bet.comparer.util.participants.synonymswords.config.SynonymsWordsParticipantsConfiguration;

/**
 * The Class ProcessCleanParticipants.
 */
public class ProcessCleanSynonymsWords {

	private static final SimpleDateFormat DATE_FORMATTER = new SimpleDateFormat("mm:ss");
	
	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		new ProcessCleanSynonymsWords().process(args);
	}

	/** The context. */
	private AnnotationConfigApplicationContext context = null;
	
	/**
	 * Exit with message.
	 *
	 * @param LOG the lOG
	 * @param message the message
	 */
	private void exitWithMessage(ComparerWrapperLog LOG, String message) {
		LOG.info(Thread.currentThread(), message);
		System.exit(0);					
	}

	/**
	 * Exit with message before spring.
	 *
	 * @param message the message
	 */
	private void exitWithMessageBeforeSpring(String message) {
		System.out.println(message);
		System.exit(0);
	}
	
	/**
	 * Process.
	 *
	 * @param args the args
	 */
	private void process(String[] args) {
		Scanner pauser = new Scanner (System.in);
		// Control de los parámetros de entrada
		if (args.length != 2) {
			StringBuilder sbMessage = new StringBuilder();
			sbMessage.append("Ejecutar la Aplicación con dos parametros:");
			sbMessage.append("\n1) Id bookmaker");
			sbMessage.append("\n2) Tipo de Entorno [TEST, DEV, PREPRODUCTION, PRODUCTION]");
			exitWithMessageBeforeSpring(sbMessage.toString());
		}
		
		// Carga del contexto en ámbito no estático.
		context = new AnnotationConfigApplicationContext();
		if(args[1].toLowerCase().equals(ProfileConstant.TEST)){
			context.getEnvironment().setActiveProfiles(ProfileConstant.TEST);
		} else if(args[1].toLowerCase().equals(ProfileConstant.DEV)){
			context.getEnvironment().setActiveProfiles(ProfileConstant.DEV);
		} else if(args[1].toLowerCase().equals(ProfileConstant.PREPRODUCTION)){
			context.getEnvironment().setActiveProfiles(ProfileConstant.PREPRODUCTION);
		} else if(args[1].toLowerCase().equals(ProfileConstant.PRODUCTION)){
			context.getEnvironment().setActiveProfiles(ProfileConstant.PRODUCTION);
		} else {
			exitWithMessageBeforeSpring("El entorno introducido no existe.");
		}
		context.register(SynonymsWordsParticipantsConfiguration.class);
		context.refresh();
		
		ICfgParticipantSynonymsService participantSynonymsService = (ICfgParticipantSynonymsService)context.getBean(ICfgParticipantSynonymsService.class);
		ComparerWrapperLog LOG = (ComparerWrapperLog)context.getBean(ComparerWrapperLog.class);
		if(participantSynonymsService==null) {
			exitWithMessage(LOG, "Error en la carga de los servicios Spring.");
		}
		
		Date start = new Date();
		LOG.info(Thread.currentThread(), "Se ha completado la carga del contexto de spring se procede a limpiar los synonyms words");
		
		if(NumberUtils.isNumber(args[0])){
			participantSynonymsService.cleanSynonymWordsFromBookmaker(args[0]);
			LOG.info(Thread.currentThread(), "Se ha completado la limpieza synonyms words");
			Date end = new Date();
			LOG.info(Thread.currentThread(), new StringBuffer("Se ha tardado ").append(DATE_FORMATTER.format(new Date(end.getTime()-start.getTime()))).toString());
			LOG.info(Thread.currentThread(), "Para finalizar pulse cualquier tecla");
			pauser.nextLine();
		} else{
			exitWithMessage(LOG, "El id introducido no es numerico.");
		}
	}
}

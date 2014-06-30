package com.comparadorad.bet.comparer.util.participants.copy.exec;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

import java.io.File;
import java.util.List;
import java.util.Map;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.comparadorad.bet.comparer.model.config.bean.CfgCompetition;
import com.comparadorad.bet.comparer.model.config.bean.CfgParticipant;
import com.comparadorad.bet.comparer.model.config.bean.CfgParticipantSynonyms;
import com.comparadorad.bet.comparer.util.commons.profile.ProfileConstant;
import com.comparadorad.bet.comparer.util.logger.core.ComparerWrapperLog;
import com.comparadorad.bet.comparer.util.participants.copy.mongodb.CopyParticipantsConfig;
import com.comparadorad.bet.comparer.util.participants.copy.service.CopyParticipantsService;
import com.comparadorad.bet.comparer.util.participants.copy.service.ICopyParticipantsService;

/**
 * Execute the copy process of participants from one competition to other.
 * 
 * @author farce
 *
 */
public class ProcessCopyParticipants {	
	
	private static final String OUTPUT_FILE = "\\CopyOut.log";
	
	private AnnotationConfigApplicationContext context = null;
	private String outputFilePath = "";
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new ProcessCopyParticipants().process(args);
	}

	/**
	 * Do all copy process.
	 * 
	 * @param args, line command arguments.
	 */
	private void process(String[] args) {		
		Integer participantsTargetSynonymsSize;
		// Control de los parámetros de entrada
		if(args.length<3) {
			StringBuilder sbMessage = new StringBuilder();
			sbMessage.append("Ejecutar la Aplicación con tres parametros:");
			sbMessage.append("\n1) Id Competicion Fuente");
			sbMessage.append("\n2) Id competicion Destino");
			sbMessage.append("\n3) Tipo de Entorno [TEST, DEV, PREPRODUCTION, PRODUCTION]");
			sbMessage.append("\n4) Directorio de Salida (Opcional, por defecto directorio actual)");
			exitWithMessageBeforeSpring(sbMessage.toString());
		}
		
		if(args.length==4) {
			outputFilePath = args[3];			
		} else {
			File currentDir = new File(".");
			outputFilePath = currentDir.getAbsolutePath();
		}
		outputFilePath += OUTPUT_FILE;

		// Recoge los ids de las competiciones.
		String idCompetitionSource = args[0];
		String idCompetitionTarget = args[1];			
		
		// Carga del contexto en ámbito no estático.
		context = new AnnotationConfigApplicationContext();
		if(args[2].toLowerCase().equals(ProfileConstant.TEST)){
			context.getEnvironment().setActiveProfiles(ProfileConstant.TEST);
		} else if(args[2].toLowerCase().equals(ProfileConstant.DEV)){
			context.getEnvironment().setActiveProfiles(ProfileConstant.DEV);
		} else if(args[2].toLowerCase().equals(ProfileConstant.PREPRODUCTION)){
			context.getEnvironment().setActiveProfiles(ProfileConstant.PREPRODUCTION);
		} else if(args[2].toLowerCase().equals(ProfileConstant.PRODUCTION)){
			context.getEnvironment().setActiveProfiles(ProfileConstant.PRODUCTION);
		} else {
			exitWithMessageBeforeSpring("El entorno introducido no existe.");
		}
		context.register(CopyParticipantsConfig.class);
		context.refresh();
		assertThat(context, is(notNullValue()));
						
		// Se obtiene el servicio
		ICopyParticipantsService icps = (ICopyParticipantsService)context.getBean(CopyParticipantsService.class);
		ComparerWrapperLog LOG = (ComparerWrapperLog)context.getBean(ComparerWrapperLog.class);
		if(icps==null) {
			exitWithMessage(LOG, "Error en la carga de los servicios Spring.");
		}
		
		
		LOG.info(Thread.currentThread(), "-----------ANTES DEL COPIADO DE PARTICIPANTES-----------");
		// Por pasos: 
		// 1) Obtener competiciones
		CfgCompetition sourceCompetition = icps.getCompetitionById(idCompetitionSource);
		if(sourceCompetition == null) {
			exitWithMessage(LOG, "No se ha encontrado ninguna competición con id " + idCompetitionSource);
		}
		LOG.info(Thread.currentThread(), "COMPETICION SOURCE - [" + idCompetitionSource + "] : " + sourceCompetition.getCfgName());
		LOG.info(Thread.currentThread(), "COMPETICION SOURCE PARTICIPANTS NAMES - [" + sourceCompetition.getParticipantNames().size() + "]");
		
		CfgCompetition targetCompetition = icps.getCompetitionById(idCompetitionTarget);
		if(targetCompetition == null) {
			exitWithMessage(LOG, "No se ha encontrado ninguna competición con id " + idCompetitionTarget);
		}
		LOG.info(Thread.currentThread(), "COMPETICION TARGET - [" + idCompetitionTarget + "] : " + targetCompetition.getCfgName());	
		LOG.info(Thread.currentThread(), "COMPETICION TARGET PARTICIPANTS NAMES - [" + targetCompetition.getParticipantNames().size() + "]");
		
		List<CfgParticipant> participantsSource = icps.findParticipantsByCompetitionId(idCompetitionSource, true);
		if(participantsSource==null) {
			exitWithMessage(LOG, "No se ha encontrado participantes con id " + idCompetitionSource);
		}
		LOG.info(Thread.currentThread(), "COMPETICION SOURCE PARTICIPANTS - [" + idCompetitionSource + "] : " + participantsSource.size());	
		
		// Se listan los participantes de destino:
		Map<CfgParticipant, List<CfgParticipantSynonyms>> participantsTargetSynonyms= null;
		List<CfgParticipant> participantsTarget = icps.findParticipantsByCompetitionId(idCompetitionTarget, false);
		if(participantsTarget!=null) {	
			LOG.info(Thread.currentThread(), "COMPETICION TARGET PARTICIPANTS - [" + idCompetitionTarget + "] : " + participantsTarget.size());			
			participantsTargetSynonyms= icps.findParticipantSynonyms(participantsTarget, false);
		} else{
			LOG.info(Thread.currentThread(), "COMPETICION TARGET PARTICIPANTS - [" + idCompetitionTarget + "] : 0");	
		}

		
		Map<CfgParticipant, List<CfgParticipantSynonyms>> participantsSourceSynonyms= icps.findParticipantSynonyms(participantsSource, true);
		Integer participantsSourceSynonymsSize = countSynonyms(participantsSourceSynonyms);
		LOG.info(Thread.currentThread(), "COMPETICION SOURCE PARTICIPANTS SYNONYMS (ONLY ACTIVES) - [" + participantsSourceSynonymsSize + "]");
		
		participantsTargetSynonymsSize = countSynonyms(participantsTargetSynonyms);
		LOG.info(Thread.currentThread(), "COMPETICION TARGET PARTICIPANTS SYNONYMS (ACTIVES AND NOT TO DELETE) - [" + participantsTargetSynonymsSize + "]");		
		
		icps.doCopyParticipants(sourceCompetition, targetCompetition, participantsSourceSynonyms, participantsTargetSynonyms, outputFilePath);	
		
		//DESPUES DEL COPIADO
		sourceCompetition = icps.getCompetitionById(idCompetitionSource);
		targetCompetition = icps.getCompetitionById(idCompetitionTarget);
		participantsSource = icps.findParticipantsByCompetitionId(idCompetitionSource, true);
		participantsTarget = icps.findParticipantsByCompetitionId(idCompetitionTarget, true);
		participantsSourceSynonymsSize = countSynonyms(icps.findParticipantSynonyms(participantsSource, true));
		participantsTargetSynonymsSize = countSynonyms(icps.findParticipantSynonyms(participantsTarget, true));
		LOG.info(Thread.currentThread(), "-----------DESPUES DEL COPIADO DE PARTICIPANTES-----------");
		LOG.info(Thread.currentThread(), "COMPETICION SOURCE - [" + idCompetitionSource + "] : " + sourceCompetition.getCfgName());
		LOG.info(Thread.currentThread(), "COMPETICION SOURCE PARTICIPANTS NAMES - [" + sourceCompetition.getParticipantNames().size() + "]");
		LOG.info(Thread.currentThread(), "COMPETICION TARGET - [" + idCompetitionTarget + "] : " + targetCompetition.getCfgName());
		LOG.info(Thread.currentThread(), "COMPETICION TARGET PARTICIPANTS NAMES - [" + targetCompetition.getParticipantNames().size() + "]");
		LOG.info(Thread.currentThread(), "COMPETICION SOURCE PARTICIPANTS - [" + idCompetitionSource+ "] : " + participantsSource.size());	
		LOG.info(Thread.currentThread(), "COMPETICION TARGET PARTICIPANTS - [" + idCompetitionTarget + "] : " + participantsTarget.size());	
		LOG.info(Thread.currentThread(), "COMPETICION SOURCE PARTICIPANTS SYNONYMS (ONLY ACTIVES) - [" + participantsSourceSynonymsSize + "]");
		LOG.info(Thread.currentThread(), "COMPETICION TARGET PARTICIPANTS SYNONYMS (ONLY ACTIVES) - [" + participantsTargetSynonymsSize + "]");	
	}
	
	private Integer countSynonyms( Map<CfgParticipant, List<CfgParticipantSynonyms>> participants){
		Integer result = 0;
		for(CfgParticipant participant : participants.keySet()){
			result+=participants.get(participant).size();
		}
		return result;
	}
	/**
	 * When initial parameters are not valid, exits showing this message.
	 * 
	 * @param message, message to show before exit.
	 */
	private void exitWithMessage(ComparerWrapperLog LOG, String message) {
		LOG.info(Thread.currentThread(), message);
		System.exit(0);					
	}
	
	private void exitWithMessageBeforeSpring(String message) {
		System.out.println(message);
		System.exit(0);					
	}
}

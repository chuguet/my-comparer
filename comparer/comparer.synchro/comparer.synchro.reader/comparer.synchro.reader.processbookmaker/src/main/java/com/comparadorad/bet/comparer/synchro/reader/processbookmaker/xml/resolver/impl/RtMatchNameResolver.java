package com.comparadorad.bet.comparer.synchro.reader.processbookmaker.xml.resolver.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.comparadorad.bet.comparer.model.bet.bean.RtMatch;
import com.comparadorad.bet.comparer.model.bet.bean.RtMatchId;
import com.comparadorad.bet.comparer.model.bet.bean.RtParticipant;
import com.comparadorad.bet.comparer.model.config.bean.CfgCompetition;
import com.comparadorad.bet.comparer.model.config.bean.CfgCompetitionEvent;
import com.comparadorad.bet.comparer.model.core.bean.I18nField;

@Component
public class RtMatchNameResolver {

	/** The participants separator. */
	@Value("${RtMatch.name.participantsSeparator}")
	private String participantsSeparator;

	/** The participants competition separator. */
	@Value("${RtMatch.name.participantsCompetitionSeparator}")
	private String participantsCompetitionSeparator;

	/** The Constant SEPARATOR. */
	private final static String SEPARATOR = " ";

	/**
	 * Resolve name field.
	 * 
	 * @param rtMatchId
	 *            the rt match id
	 * @param rtMatch
	 *            the rt match
	 * @return the rt match
	 */
	public RtMatch resolveNameField(final RtMatch rtMatch) {

		RtMatch result = (RtMatch) rtMatch.clone();
		RtMatchId rtMatchId = rtMatch.getMatchId();

		// Largo plazo
		if (rtMatch.getCompetitionEvent().getLongTerm() != null) {
			if (rtMatch.getCompetitionEvent().getLongTerm().getLongTerm()) {
				result = resolveSeveralParticipants(rtMatchId, rtMatch);
				// Corto plazo
			} else {
				if (rtMatchId.getParticipiants() != null
						&& rtMatchId.getParticipiants().size() > 0) {
					if (rtMatchId.getParticipiants().size() > 2) {
						result = resolveSeveralParticipants(rtMatchId, rtMatch);
					} else {
						if (rtMatchId.getParticipiants().size() == 1) {
							result = resolveUniqueParticipant(rtMatchId,
									rtMatch);
						} else {
							result = resolveTwoParticipants(rtMatchId, rtMatch);
						}
					}

				}
			}
		}

		return result;
	}

	/**
	 * Resolve two participants.
	 * 
	 * @param rtMatchId
	 *            the rt match id
	 * @param rtMatch
	 *            the rt match
	 * @return the rt match
	 */
	private RtMatch resolveTwoParticipants(final RtMatchId rtMatchId,
			final RtMatch rtMatch) {
		RtMatch result = (RtMatch) rtMatch.clone();
		result.setI18n(null);
		// if (StringUtils.isNotEmpty(rtMatch.getName(null))) {
		// String[] participantes = rtMatch.getName(null).split(" ");
		// // result.setName(new
		// StringBuffer().append(participantes[0]).append(" ")
		// //
		// .append(participantsSeparator).append(" ").append(participantes[2])
		// // .toString());
		// result.setName(result.getName(null));
		// // if (rtMatch.getName(null).contains("-")) {
		// // result.setName(rtMatch.getName(null).replaceAll("-",
		// // participantsSeparator));
		// // } else {
		// // result.setName(rtMatch.getName(null));
		// // }
		// // } else if (rtMatch.getName(null).contains("vs")) {
		// // result.setName(rtMatch.getName(null));
		// // }
		//
		// } else {
		List<RtParticipant> listaParticipantes = new ArrayList<RtParticipant>();
		for (RtParticipant participant : rtMatchId.getParticipiants()) {
			listaParticipantes.add(participant);
		}
		if (!listaParticipantes.isEmpty()) {
			if (listaParticipantes.get(0).isHomeParticipant()) {
				result.setName(new StringBuffer()
				.append(listaParticipantes.get(0).getCfgParticipant()
						.getI18n().getI18nField(null).getString())
				.append(" ")
				.append(participantsSeparator)
				.append(" ")
				.append(listaParticipantes.get(1).getCfgParticipant()
						.getI18n().getI18nField(null).getString())
				.toString());
			} else {
				result.setName(new StringBuffer()
				.append(listaParticipantes.get(1).getCfgParticipant()
						.getI18n().getI18nField(null).getString())
				.append(" ")
				.append(participantsSeparator)
				.append(" ")
				.append(listaParticipantes.get(0).getCfgParticipant()
						.getI18n().getI18nField(null).getString())
				.toString());
			}
			
			// for (I18nField nombreParticipanteA : listaParticipantes.get(0)
			// .getCfgParticipant().getI18n().getI18nFields()) {
			// for (I18nField nombreParticipanteB : listaParticipantes
			// .get(1).getCfgParticipant().getI18n()
			// .getI18nFields()) {
			// if (nombreParticipanteA.getLocale() != null
			// && nombreParticipanteB.getLocale() != null) {
			// if (nombreParticipanteA.getLocale() != null
			// && nombreParticipanteA.getLocale().equals(
			// nombreParticipanteB.getLocale())) {
			// StringBuffer nombreParticipante = new StringBuffer();
			// nombreParticipante.append(nombreParticipanteA)
			// .append(participantsSeparator)
			// .append(nombreParticipanteB);
			// result.setName(nombreParticipante.toString(),
			// nombreParticipanteA.getLocale());
			// break;
			// }
			// } else {
			// if (listaParticipantes.get(0).isAwayParticipant()) {
			// result.setName(nombreParticipanteB.getString()
			// + SEPARATOR + participantsSeparator
			// + SEPARATOR
			// + nombreParticipanteA.getString());
			// } else {
			// result.setName(nombreParticipanteA.getString()
			// + SEPARATOR + participantsSeparator
			// + SEPARATOR
			// + nombreParticipanteB.getString());
			// }
			//
			// }
			//
			// }
			// }
		}
		// }

		return result;
	}

	/**
	 * Resolve unique participant.
	 * 
	 * @param rtMatchId
	 *            the rt match id
	 * @param rtMatch
	 *            the rt match
	 * @return the rt match
	 */
	private RtMatch resolveUniqueParticipant(final RtMatchId rtMatchId,
			final RtMatch rtMatch) {
		RtMatch result = (RtMatch) rtMatch.clone();
		result.setI18n(null);
		CfgCompetition competition = rtMatchId.getCompetition();

		if (competition != null && competition.getI18n() != null) {
			for (I18nField competitionNames : competition.getI18n()
					.getI18nFields()) {
				if (competition.getCompetitionEvents() != null) {
					for (CfgCompetitionEvent competitionEvent : competition
							.getCompetitionEvents()) {
						if (competitionEvent.compareTo(rtMatch
								.getCompetitionEvent()) == 0) {
							for (I18nField competitionEventName : competitionEvent
									.getI18n().getI18nFields()) {
								if (competitionNames.getLocale() != null
										&& competitionNames.getLocale().equals(
												competitionEventName
														.getLocale())) {
									List<RtParticipant> listaParticipantes = new ArrayList<RtParticipant>();
									for (RtParticipant participant : rtMatchId
											.getParticipiants()) {
										listaParticipantes.add(participant);
									}
									for (I18nField nombreParticipante : listaParticipantes
											.get(0).getCfgParticipant()
											.getI18n().getI18nFields()) {
										if (nombreParticipante.getLocale() != null
												&& competitionNames.getLocale() != null
												&& competitionEventName
														.getLocale() != null) {
											if (nombreParticipante.getLocale() != null
													&& nombreParticipante
															.getLocale()
															.equals(competitionNames
																	.getLocale())) {
												StringBuffer resultado = new StringBuffer();
												resultado
														.append(competitionNames
																.getString())
														.append(SEPARATOR)
														.append(participantsCompetitionSeparator)
														.append(SEPARATOR)
														.append(competitionEventName
																.getString())
														.append(SEPARATOR)
														.append(participantsCompetitionSeparator)
														.append(SEPARATOR)
														.append(nombreParticipante
																.getString());
												result.setName(resultado
														.toString(),
														nombreParticipante
																.getLocale());
												break;
											}
										} else {
											StringBuffer resultado = new StringBuffer();
											resultado
													.append(competitionNames
															.getString())
													.append(SEPARATOR)
													.append(participantsCompetitionSeparator)
													.append(SEPARATOR)
													.append(competitionEventName
															.getString())
													.append(SEPARATOR)
													.append(participantsCompetitionSeparator)
													.append(SEPARATOR)
													.append(nombreParticipante
															.getString());
											result.setName(resultado.toString());
										}

									}
									break;
								}
							}
							break;
						}
					}
				} else {
					if (competitionNames.getLocale() != null) {
						result.setName(competitionNames.getString(),
								competitionNames.getLocale());
					} else {
						result.setName(competitionNames.getString());
					}
				}
			}
		}
		return result;
	}

	/**
	 * Resolve several participants.
	 * 
	 * @param rtMatchId
	 *            the rt match id
	 * @param rtMatch
	 *            the rt match
	 * @return the rt match
	 */
	private RtMatch resolveSeveralParticipants(final RtMatchId rtMatchId,
			final RtMatch rtMatch) {
		RtMatch result = (RtMatch) rtMatch.clone();
		result.setI18n(null);
		CfgCompetition competition = rtMatchId.getCompetition();

		for (I18nField competitionNames : competition.getI18n().getI18nFields()) {
			if (competition.getCompetitionEvents() != null) {
				for (CfgCompetitionEvent competitionEvent : competition
						.getCompetitionEvents()) {
					if (competitionEvent.compareTo(rtMatch
							.getCompetitionEvent()) == 0) {
						for (I18nField competitionEventName : competitionEvent
								.getI18n().getI18nFields()) {
							if (competitionNames.getLocale() != null
									&& competitionEventName.getLocale() != null
									&& competitionNames.getLocale().equals(
											competitionEventName.getLocale())) {

								StringBuffer resultado = new StringBuffer();
								resultado
										.append(competitionNames.getString())
										.append(SEPARATOR)
										.append(participantsCompetitionSeparator)
										.append(SEPARATOR)
										.append(competitionEventName
												.getString())
										.append(SEPARATOR)
										.append(participantsCompetitionSeparator);
								result.setName(resultado.toString(),
										competitionNames.getLocale());
								break;
							} else {
								StringBuffer resultado = new StringBuffer();
								resultado
										.append(competitionNames.getString())
										.append(SEPARATOR)
										.append(participantsCompetitionSeparator)
										.append(SEPARATOR)
										.append(competitionEventName
												.getString())
										.append(SEPARATOR)
										.append(participantsCompetitionSeparator);
								result.setName(resultado.toString());
								break;
							}
						}
					}
				}
			} else {
				if (competitionNames.getLocale() != null) {
					result.setName(competitionNames.getString(),
							competitionNames.getLocale());
				} else {
					result.setName(competitionNames.getString());
				}
			}

		}
		return result;
	}

}

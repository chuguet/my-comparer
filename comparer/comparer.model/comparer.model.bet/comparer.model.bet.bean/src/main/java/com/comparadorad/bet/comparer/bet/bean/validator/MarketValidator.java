/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.bet.bean.validator;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.comparadorad.bet.comparer.model.bet.bean.AsianResult;
import com.comparadorad.bet.comparer.model.bet.bean.MasMenos;
import com.comparadorad.bet.comparer.model.bet.bean.Result;
import com.comparadorad.bet.comparer.model.bet.bean.Rt1X2Attribute;
import com.comparadorad.bet.comparer.model.bet.bean.Rt1X2HandicapAttribute;
import com.comparadorad.bet.comparer.model.bet.bean.RtAsianHandicapAttribute;
import com.comparadorad.bet.comparer.model.bet.bean.RtBet;
import com.comparadorad.bet.comparer.model.bet.bean.RtGanadorPartidoAttribute;
import com.comparadorad.bet.comparer.model.bet.bean.RtMarket;
import com.comparadorad.bet.comparer.model.bet.bean.RtMasMenosAttribute;
import com.comparadorad.bet.comparer.model.config.bean.CfgBetType;
import com.comparadorad.bet.comparer.model.config.bean.CfgBetType.CfgBetTypeId;
import com.comparadorad.bet.comparer.model.config.bean.CfgBookmaker;

/**
 * The Class MarketValidator.
 */
public class MarketValidator implements
		ConstraintValidator<CorrectMarket, Set<RtMarket>> {

	private static final Log LOG = LogFactory.getLog(MarketValidator.class);

	/**
	 * Gets the bets grouped by bookmaker and bet value. Para separar todos los
	 * RtBet de un RtMarket en apuestas individuales (wagers/bets) hay que
	 * dividirlos por bookmaker y por valor de apuesta (donde valor de apuesta
	 * se refiere a los handicaps y el totalGoalValue de las apuestas Handicap
	 * Asiatico, 1X2 Handicap y MasMenos). Este metodo devuelve un Map donde el
	 * key es el id de un bookmaker concatenado con el/los valor/es de apuesta.
	 * 
	 * @param bets
	 *            the bets
	 * @param betType
	 *            the bet type
	 * @return the bets grouped by bookmaker and bet value
	 */
	private Map<String, Set<RtBet>> getBetsGroupedByBookmakerAndBetValue(
			final Set<RtBet> bets, CfgBetType betType) {
		Map<String, Set<RtBet>> mapWithIndividualBets = new HashMap<String, Set<RtBet>>();
		for (RtBet rtBet : bets) {
			String bookmakerId = rtBet.getBookmaker().getObjectId().toString();
			Double handicap = 0.0;

			if (betType.getObjectId().toString()
					.equals(CfgBetType.CfgBetTypeId.HANDICAP_ASIATICO.id())) {


				RtAsianHandicapAttribute attr = (RtAsianHandicapAttribute) rtBet
						.getAttribute();
				handicap = attr.getFinalValue();
			} else if (betType.getObjectId().toString()
					.equals(CfgBetType.CfgBetTypeId.UNO_X_DOS_HANDICAP.id())) {


				Rt1X2HandicapAttribute attr = (Rt1X2HandicapAttribute) rtBet
						.getAttribute();
				handicap = attr.getFinalValue();
			} else if (betType.getObjectId().toString()
					.equals(CfgBetType.CfgBetTypeId.MAS_MENOS.id())) {


				RtMasMenosAttribute attr = (RtMasMenosAttribute) rtBet
						.getAttribute();
				handicap = attr.getFinalValue();
			}
			String individualBetId = new StringBuffer().append(bookmakerId)
					.append("Handicap:").append(handicap).toString();

			if (mapWithIndividualBets.containsKey(individualBetId)) {
				mapWithIndividualBets.get(individualBetId).add(rtBet);
			} else {
				Set<RtBet> newBetSet = new HashSet<RtBet>();
				newBetSet.add(rtBet);
				mapWithIndividualBets.put(individualBetId, newBetSet);
			}
		}
		return mapWithIndividualBets;
	}

	/**
	 * Gets the bookmaker from rt bet set.
	 * 
	 * @param bets
	 *            the bets
	 * @return the bookmaker from rt bet set
	 */
	private CfgBookmaker getBookmakerFromRtBetSet(Set<RtBet> bets) {
		CfgBookmaker cfgBookmaker = null;
		for (RtBet rtBet : bets) {
			cfgBookmaker = rtBet.getBookmaker();
			if (cfgBookmaker != null) {
				break;
			}
		}
		return cfgBookmaker;
	}

	/**
	 * Gets the violation message invalid bet attributes in wager.
	 * 
	 * @param rtMarket
	 *            the rt market
	 * @param wager
	 *            the bet set
	 * @return the violation message invalid bet attributes in wager
	 */
	private String getViolationMessageInvalidBetAttributesInWager(
			RtMarket rtMarket, Set<RtBet> wager) {
		
		StringBuffer buffer = new StringBuffer("Mercado invalido: Una apuesta de tipo ")
			.append(rtMarket.getBetType().getNameId())
			.append(" del bookmaker con nombre: ")
			.append(getBookmakerFromRtBetSet(wager).getNameId())
			.append(", id: ")
			.append(getBookmakerFromRtBetSet(wager).getObjectId())
			.append(", no tiene todos los atributos necesarios.");
		
		LOG.debug(buffer);
		
		return buffer.toString();
	}

	/**
	 * Gets the violation message invalid num bets in market.
	 * 
	 * @param rtMarket
	 *            the rt market
	 * @return the violation message invalid num bets in market
	 */
	private String getViolationMessageInvalidNumBetsInMarket(RtMarket rtMarket) {
		
		StringBuffer buffer = new StringBuffer("Mercado invalido: El tipo de apuesta : ")
			.append(rtMarket.getBetType().getNameId())
			.append(" tiene un numero invalido de RtBet: ")
			.append(rtMarket.getBets().size()); 
		
		LOG.debug(buffer);
		
		return buffer.toString();
	}

	/**
	 * Gets the violation message invalid num bets in wager.
	 * 
	 * @param rtMarket
	 *            the rt market
	 * @param wager
	 *            the bet set
	 * @return the violation message invalid num bets in wager
	 */
	private String getViolationMessageInvalidNumBetsInWager(RtMarket rtMarket,
			Set<RtBet> wager) {

		StringBuffer buffer = new StringBuffer(
				"Mercado invalido: Una apuesta de tipo ")
				.append(rtMarket.getBetType().getNameId())
				.append(" del bookmaker con nombre: ")
				.append(getBookmakerFromRtBetSet(wager).getNameId())
				.append(", id: ")
				.append(getBookmakerFromRtBetSet(wager).getObjectId())
				.append(", tiene un numero de RtBbet invalido: ")
				.append(wager.size());

		LOG.debug(buffer);

		return buffer.toString();
	}

	/**
	 * Gets the violation message invalid odds in bet.
	 * 
	 * @param rtMarket
	 *            the rt market
	 * @param betSet
	 *            the bet set
	 * @return the violation message invalid odds in bet
	 */
	private String getViolationMessageInvalidOddsInBet(RtMarket rtMarket,
			Set<RtBet> betSet) {
		StringBuffer buffer = new StringBuffer(
				"Mercado invalido: La apuesta de tipo ")
				.append(rtMarket.getBetType().getNameId())
				.append(" del bookmaker con nombre: ")
				.append(getBookmakerFromRtBetSet(betSet).getNameId())
				.append(", id: ")
				.append(getBookmakerFromRtBetSet(betSet).getObjectId())
				.append(", tiene cuotas invalidas.");

		LOG.debug(buffer);
		
		return buffer.toString();
	}

	/**
	 * Initialize.
	 * 
	 * @param constraintAnnotation
	 *            the constraint annotation {@inheritDoc}
	 */
	@Override
	public void initialize(CorrectMarket constraintAnnotation) {
		// nothing to do
	}

	/**
	 * Verifica si la apuesta es de tipo largo plazo para las cuales no se
	 * aplica la validación de cuotas.
	 * 
	 * @param betType
	 *            Indica el tipo de apuesta.
	 * @return Boolean que indica si es largo plazo o no.
	 */
	private Boolean isLongTerm(CfgBetType betType) {
		Boolean flag;
		if (betType.getNameId().equals(CfgBetTypeId.GANADOR.nameId())
				|| betType.getNameId().equals(
						CfgBetTypeId.MAXIMO_GOLEADOR.nameId())) {
			flag = Boolean.TRUE;
		} else {
			flag = Boolean.FALSE;
		}
		return flag;
	}

	/**
	 * Checks if is market valid.
	 * 
	 * @param rtMarket
	 *            the rt market
	 * @param context
	 *            the context
	 * @return the boolean
	 */
	private Boolean isMarketValid(RtMarket rtMarket,
			ConstraintValidatorContext context) {

		Boolean valid = Boolean.TRUE;

		if (!validNumBetsInMarket(rtMarket.getBetType(), rtMarket.getBets())) {
			valid = Boolean.FALSE;
			context.buildConstraintViolationWithTemplate(
					getViolationMessageInvalidNumBetsInMarket(rtMarket))
					.addConstraintViolation();
		} else {
			Map<String, Set<RtBet>> betsGroupedByBookmakerAndBetValue = getBetsGroupedByBookmakerAndBetValue(
					rtMarket.getBets(), rtMarket.getBetType());
			for (Set<RtBet> wager : betsGroupedByBookmakerAndBetValue.values()) {

				if (!validNumBetsInWager(rtMarket.getBetType(), wager)) {
					valid = Boolean.FALSE;
					context.buildConstraintViolationWithTemplate(
							getViolationMessageInvalidNumBetsInWager(rtMarket,
									wager)).addConstraintViolation();
				} else if (!validBetAttributesInWager(rtMarket.getBetType(),
						wager)) {
					valid = Boolean.FALSE;
					rtMarket.setValid(Boolean.FALSE);
					context.buildConstraintViolationWithTemplate(
							getViolationMessageInvalidBetAttributesInWager(
									rtMarket, wager)).addConstraintViolation();
				} else if (!validOddsInWager(rtMarket.getBetType(), wager)) {
					valid = Boolean.FALSE;
					context.buildConstraintViolationWithTemplate(
							getViolationMessageInvalidOddsInBet(rtMarket, wager))
							.addConstraintViolation();
				}
			}
		}
		if (!valid) {
			rtMarket.setValid(Boolean.FALSE);
		}
		return valid;
	}

	/**
	 * Checks if is valid. En cuanto encuentre un error de un mercado ya no se
	 * procesa mas. Esto hace que se guarda un mensaje de error dentro del
	 * Set<ConstraintViolation> por cada mercado que falla.
	 * 
	 * @param markets
	 *            the markets
	 * @param context
	 *            the context
	 * @return true, if is valid {@inheritDoc}
	 */
	@Override
	public boolean isValid(Set<RtMarket> markets,
			ConstraintValidatorContext context) {

		Boolean valid = Boolean.TRUE;
		context.disableDefaultConstraintViolation();

		if (markets != null && markets.size() > 0) {
			for (RtMarket rtMarket : markets) {
				valid = isMarketValid(rtMarket, context) && valid;
			}
		} else {
			valid = Boolean.FALSE;
		}
		return valid;
	}

	/**
	 * Validate bet attributes in wager. Este metodo verifica que los atributos
	 * de los bets de un bookmaker son completos. Por ejemplo, si el tipo de
	 * apuesta es Ganador de partido o Handicap asiatico tiene que existir un
	 * bet con atributo ONE y otro bet con atributo TWO. Las apuestas Ganador y
	 * Maximo Goleador no requieren un control de este tipo.
	 * 
	 * @param betType
	 *            the bet type
	 * @param wager
	 *            the bets
	 * @return true, if successful
	 */
	private boolean validBetAttributesInWager(CfgBetType betType,
			Set<RtBet> wager) {

		Boolean valid = Boolean.TRUE;

		

		if (betType.getObjectId().toString()
				.equals(CfgBetType.CfgBetTypeId.UNO_X_DOS.id())) {
			boolean one = false;
			boolean draw = false;
			boolean two = false;

			

			for (RtBet bet : wager) {
				Rt1X2Attribute attr = (Rt1X2Attribute) bet.getAttribute();
				if (attr.getResult() == Result.ONE) {
					one = true;
				} else if (attr.getResult() == Result.DRAW) {
					draw = true;
				} else if (attr.getResult() == Result.TWO) {
					two = true;
				}
			}
			valid = one && draw && two;
		} else if (betType.getObjectId().toString()
				.equals(CfgBetType.CfgBetTypeId.UNO_X_DOS_HANDICAP.id())) {
			boolean one = false;
			boolean draw = false;
			boolean two = false;

			

			for (RtBet bet : wager) {
				Rt1X2HandicapAttribute attr = (Rt1X2HandicapAttribute) bet
						.getAttribute();
				if (attr.getResult() == Result.ONE) {
					one = true;
				} else if (attr.getResult() == Result.DRAW) {
					draw = true;
				} else if (attr.getResult() == Result.TWO) {
					two = true;
				}
			}
			valid = one && draw && two;
		} else if (betType.getObjectId().toString()
				.equals(CfgBetType.CfgBetTypeId.GANADOR_PARTIDO.id())) {
			boolean one = false;
			boolean two = false;

			

			for (RtBet bet : wager) {
				RtGanadorPartidoAttribute attr = (RtGanadorPartidoAttribute) bet
						.getAttribute();
				if (attr.getResult() == Result.ONE) {
					one = true;
				} else if (attr.getResult() == Result.TWO) {
					two = true;
				}
			}
			valid = one && two;
		} else if (betType.getObjectId().toString()
				.equals(CfgBetType.CfgBetTypeId.HANDICAP_ASIATICO.id())) {
			boolean one = false;
			boolean two = false;

			

			for (RtBet bet : wager) {
				RtAsianHandicapAttribute attr = (RtAsianHandicapAttribute) bet
						.getAttribute();
				if (attr.getAsianResult() == AsianResult.ONE) {
					one = true;
				} else if (attr.getAsianResult() == AsianResult.TWO) {
					two = true;
				}
			}
			valid = one && two;
		} else if (betType.getObjectId().toString()
				.equals(CfgBetType.CfgBetTypeId.MAS_MENOS.id())) {
			boolean mas = false;
			boolean menos = false;

			

			for (RtBet bet : wager) {
				RtMasMenosAttribute attr = (RtMasMenosAttribute) bet
						.getAttribute();
				if (attr.getMasMenos() == MasMenos.MAS) {
					mas = true;
				} else if (attr.getMasMenos() == MasMenos.MENOS) {
					menos = true;
				}
			}
			valid = mas && menos;
		}

		

		return valid;
	}

	/**
	 * Valid num bets in market.
	 * 
	 * @param betType
	 *            the bet type
	 * @param bets
	 *            the bets
	 * @return the boolean
	 */
	private Boolean validNumBetsInMarket(final CfgBetType betType,
			final Set<RtBet> bets) {
		Boolean valid = Boolean.TRUE;

		

		if (betType.getObjectId().toString()
				.equals(CfgBetType.CfgBetTypeId.UNO_X_DOS.id())
				|| betType
						.getObjectId()
						.toString()
						.equals(CfgBetType.CfgBetTypeId.UNO_X_DOS_HANDICAP.id())) {

			

			if (bets.size() % 3 != 0 || bets.size() < 3) {
				valid = Boolean.FALSE;
			}
		} else if (betType.getObjectId().toString()
				.equals(CfgBetType.CfgBetTypeId.GANADOR_PARTIDO.id())
				|| betType.getObjectId().toString()
						.equals(CfgBetType.CfgBetTypeId.HANDICAP_ASIATICO.id())
				|| betType.getObjectId().toString()
						.equals(CfgBetType.CfgBetTypeId.MAS_MENOS.id())) {

			

			if (bets.size() % 2 != 0 || bets.size() < 2) {
				valid = Boolean.FALSE;
			}
		} else if (betType.getObjectId().toString()
				.equals(CfgBetType.CfgBetTypeId.GANADOR.id())
				|| betType.getObjectId().toString()
						.equals(CfgBetType.CfgBetTypeId.MAXIMO_GOLEADOR.id())) {

			

			if (bets.size() < 2) {
				valid = Boolean.FALSE;
			}
		}

		return valid;
	}

	/**
	 * Valid num bets in wager. Este metodo verifica que el numero de bets de un
	 * bookmaker es correcto. Por ejemplo: si el tipo de apuesta es Ganador de
	 * partido o Handicap asiatico tiene que haber dos bets; uno para el local y
	 * otro para el visitante.
	 * 
	 * @param betType
	 *            the bet type
	 * @param betsBelongingToOneBookmaker
	 *            the bets belonging to one bookmaker
	 * @return true, if successful
	 */
	private boolean validNumBetsInWager(final CfgBetType betType,
			final Set<RtBet> betsBelongingToOneBookmaker) {
		Boolean valid = Boolean.TRUE;

		

		if (betType.getObjectId().toString()
				.equals(CfgBetType.CfgBetTypeId.UNO_X_DOS.id())
				|| betType
						.getObjectId()
						.toString()
						.equals(CfgBetType.CfgBetTypeId.UNO_X_DOS_HANDICAP.id())) {

			

			valid = (betsBelongingToOneBookmaker.size() == 3);
		} else if (betType.getObjectId().toString()
				.equals(CfgBetType.CfgBetTypeId.GANADOR_PARTIDO.id())
				|| betType.getObjectId().toString()
						.equals(CfgBetType.CfgBetTypeId.HANDICAP_ASIATICO.id())
				|| betType.getObjectId().toString()
						.equals(CfgBetType.CfgBetTypeId.MAS_MENOS.id())) {

			

			valid = (betsBelongingToOneBookmaker.size() == 2);
		} else if (betType.getObjectId().toString()
				.equals(CfgBetType.CfgBetTypeId.GANADOR.id())
				|| betType.getObjectId().toString()
						.equals(CfgBetType.CfgBetTypeId.MAXIMO_GOLEADOR.id())) {

			

			valid = (betsBelongingToOneBookmaker.size() > 1);
		}
		return valid;
	}

	/**
	 * Valid odds in wager. Este metodo verifica que los odds de un bookmaker
	 * para una apuesta son válidas: que la suma de sus cuotas no superan 1.
	 * Solo se aplicara para apuestas de corto plazo.
	 * 
	 * @param betType
	 *            the bet type
	 * @param wager
	 *            the wager
	 * @return the boolean
	 */
	private Boolean validOddsInWager(CfgBetType betType, Set<RtBet> wager) {
		Boolean result = Boolean.TRUE;

		if (!isLongTerm(betType)) {
			Double quota = 0.0;
			for (RtBet bet : wager) {
				quota = quota + (1 / Double.valueOf(bet.getBetOdd().getOdds()));
			}
			result = quota > 1;
		}


		return result;
	}

}

/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.model.config.bean;

import java.math.BigInteger;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import com.comparadorad.bet.comparer.model.config.bean.bmconf.CfgBookmakerConfiguration;
import com.comparadorad.bet.comparer.model.config.bean.bmconf.CfgBookmakerXmlReader;
import com.comparadorad.bet.comparer.model.core.bean.AbstractI18nTableActivable;
import com.comparadorad.bet.comparer.model.core.bean.IDocument;
import com.comparadorad.bet.comparer.model.core.bean.IObjectIdEnum;

/**
 * The Class CfgBookmaker.
 */
@SuppressWarnings("serial")
@Document
public class CfgBookmaker extends AbstractI18nTableActivable implements IDocument {

	/**
	 * The Enum CfgBookmakerId.
	 */
	public enum CfgBookmakerId implements IObjectIdEnum {

		/** The _10 be t_ co m_ id. */
		_10BET_COM_ID("1", "0", "10Bet"), /** The _12 be t_ co m_ id. */
		_12BET_COM_ID("2", "0", "12Bet"), /** The _188 be t_ co m_ id. */
		_188BET_COM_ID("4", "0", "188Bet"), /** The _1 be t_ co m_ id. */
		_1BET_COM_ID("5", "0", "1Bet"),
		/** The _24 hpoke r_ co m_ id. */
		_24HPOKER_COM_ID("6", "0", "24hPoker"),
		/** The _32 redbe t_ co m_ id. */
		_32REDBET_COM_ID("7", "0", "32RedBet"),
		/** The _5 dime s_ co m_ id. */
		_5DIMES_COM_ID("8", "0", "5DTimes"),
		/** The _888 spor t_ co m_ id. */
		_888SPORT_COM_ID("9", "0", "888Sport"),
		/** The ADMIRALBE t_ co m_ id. */
		ADMIRALBET_COM_ID("10", "0", "AdmiralBet"),
		/** The ALLYOUBE t_ co m_ id. */
		ALLYOUBET_COM_ID("11", "0", "AllYouBet"),
		/** The BE t_ a t_ hom e_ co m_ id. */
		BET_AT_HOME_COM_ID("16", "0", "BetAtHome"),
		/** The BE t1128_ co m_ id. */
		BET1128_COM_ID("12", "0", "Bet1128"),
		/** The BE t24_ co m_ id. */
		BET24_COM_ID("13", "0", "Bet24"),
		/** The BE t3000_ co m_ id. */
		BET3000_COM_ID("14", "0", "Bet3000"),
		/** The BE t365_ co m_ id. */
		BET365_COM_ID("15", "0", "Bet365"),
		/** The BETBO o_ id. */
		BETBOO_ID("17", "0", "BetBoo"),
		/** The BETCHRONICL e_ co m_ id. */
		BETCHRONICLE_COM_ID("18", "0", "BetChronicle"),
		/** The BETCLI c_ co m_ id. */
		BETCLIC_COM_ID("19", "0", "BetClic"),
		/** The BETCRI s_ co m_ id. */
		BETCRIS_COM_ID("23", "0", "BetCris"),
		/** The BETCRUIS e_ co m_ id. */
		BETCRUISE_COM_ID("21", "0", "BetCruise"),
		/** The BETDA q_ co m_ id. */
		BETDAQ_COM_ID("24", "0", "BetDaq"),
		/** The BETDS i_ co m_ id. */
		BETDSI_COM_ID("112", "0", "Betdsi"),
		/** The BETFAI r_ co m_ id. */
		BETFAIR_COM_ID("25", "0", "BetFair"),
		/** The BETFRE d_ co m_ id. */
		BETFRED_COM_ID("26", "0", "BetFred"),
		/** The BETGU n_ co m_ id. */
		BETGUN_COM_ID("27", "0", "Betgun"),
		/** The BETINTERNE t_ co m_ id. */
		BETINTERNET_COM_ID("28", "0", "BetInternet"),
		/** The BETLEGEND s_ e u_ id. */
		BETLEGENDS_EU_ID("29", "0", "BetLegends"),
		/** The BETLINE r_ co m_ id. */
		BETLINER_COM_ID("30", "0", "Betliner"),
		/** The BETNG o_ co m_ id. */
		BETNGO_COM_ID("31", "0", "BetnGo"),
		/** The BETONLIN e_ co m_ id. */
		BETONLINE_COM_ID("33", "0", "BetOnline.com"),
		/** The BETONLIV e_ co m_ id. */
		BETONLIVE_COM_ID("32", "0", "BetOnLive"),
		/** The BETQ s_ co m_ id. */
		BETQS_COM_ID("34", "0", "BetQs"),
		/** The BETREDKINGS. */
		BETREDKINGS_ID("108", "0", "BetRedKings"),
		/** The BETSAF e_ co m_ id. */
		BETSAFE_COM_ID("35", "0", "BetSafe"),
		/** The BETSHO p_ co m_ id. */
		BETSHOP_COM_ID("36", "0", "BetShop"),
		/** The BETTBE t_ co m_ id. */
		BETTBET_COM_ID("37", "0", "BetBet"),
		/** The BETU s_ co m_ id. */
		BETUS_COM_ID("38", "0", "BetUs"),
		/** The BETVICTO r_ co m_ id. */
		BETVICTOR_COM_ID("39", "0", "BetVictor"),
		/** The BLUESQUAR e_ co m_ id. */
		BLUESQUARE_COM_ID("40", "0", "BlueSquare"),
		/** The BODO g_ co m_ id. */
		BODOG_COM_ID("41", "0", "BoDog"),
		/** The BOOKMAKE r_ e u_ id. */
		BOOKMAKER_EU_ID("42", "0", "BookmakerEu"),
		/** The BOYLESPORT s_ co m_ id. */
		BOYLESPORTS_COM_ID("43", "0", "BoyleSports"),
		/** The BWI n_ co m_ id. */
		BWIN_COM_ID("44", "0", "Bwin"),
		/** The CANBE t_ co m_ id. */
		CANBET_COM_ID("45", "0", "Canbet"),
		/** The CARIBSPORT s_ co m_ id. */
		CARIBSPORTS_COM_ID("46", "0", "CaribSports"),
		/** The CENTREBE t_ co m_ id. */
		CENTREBET_COM_ID("47", "0", "CentreBet"),
		/** The CORA l_ co m_ u k_ id. */
		CORAL_COM_UK_ID("48", "0", "Coral"),
		/** The DAFABE t_ co m_ id. */
		DAFABET_COM_ID("49", "0", "DafaBet"),
		/** The DANBOO k_ co m_ id. */
		DANBOOK_COM_ID("50", "0", "DanBook"),
		/** The DANSKESPI l_ d k_ id. */
		DANSKESPIL_DK_ID("51", "0", "DansKespil"),
		/** The DIGIBE t_ co m_ id. */
		DIGIBET_COM_ID("52", "0", "DigiBet"),
		/** The DOXXBE t_ co m_ id. */
		DOXXBET_COM_ID("53", "0", "DoxBet"),
		/** The EUROBE t_ co m_ id. */
		EUROBET_COM_ID("54", "0", "EuroBet"),
		/** The EUROSPORTBE t_ co m_ id. */
		EUROSPORTBET_COM_ID("55", "0", "EurosportBet"),
		/** The EXPEK t_ co m_ id. */
		EXPEKT_COM_ID("56", "0", "Expekt"),
		/** The FONBE t_ co m_ id. */
		FONBET_COM_ID("58", "0", "FonBet"),
		/** The GAMEBOOKER s_ co m_ id. */
		GAMEBOOKERS_COM_ID("59", "0", "GameBookers"),
		/** The GETWI n_ co m_ id. */
		GETWIN_COM_ID("60", "0", "GetWin"),
		/** The GLOBA l_ sport s_ be t_ id. */
		GLOBAL_SPORTS_BET_ID("61", "0", "GlobalSportsBet"),
		/** The GLOBE t_ co m_ id. */
		GLOBET_COM_ID("62", "0", "GloBet"),
		/** The GOLDBE t_ co m_ id. */
		GOLDBET_COM_ID("63", "0", "GoldBet"),
		/** The GUT s_ co m_ id. */
		GUTS_COM_ID("64", "0", "Guts"),
		/** The HKJ c_ co m_ id. */
		HKJC_COM_ID("65", "0", "Hkjc"),
		/** The IASBE t_ co m_ id. */
		IASBET_COM_ID("66", "0", "IasBet"),
		/** The IBCBE t_ co m_ id. */
		IBCBET_COM_ID("67", "0", "IbcBet"),
		/** The INTERAPUESTA s_ co m_ id. */
		INTERAPUESTAS_COM_ID("68", "0", "InterApuestas"),
		/** The INTERTOP s_ e u_ id. */
		INTERTOPS_EU_ID("69", "0", "Intertops"),
		/** The INTERWETTEN n_ co m_ id. */
		INTERWETTEN_COM_ID("109", "0", "Interwetten"),
		/** The JAX x_ co m_ id. */
		JAXX_COM_ID("70", "0", "Jaxx"),
		/** The JETBUL l_ co m_ id. */
		JETBULL_COM_ID("71", "0", "JetBull"),
		/** The LADBROKE s_ co m_ id. */
		LADBROKES_COM_ID("72", "0", "LadBrokes"),
		/** The MACAUSLO t_ co m_ id. */
		MACAUSLOT_COM_ID("73", "0", "MacAuslot"),
		/** The MANSIO n88_ co m_ id. */
		MANSION88_COM_ID("74", "0", "Mansion88"),
		/** The MIAPUEST a_ co m_ id. */
		MIAPUESTA_COM_ID("75", "0", "MiApuesta"),
		/** The MYBE t_ co m_ id. */
		MYBET_COM_ID("76", "0", "MyBet"),
		/** The NORDICBE t_ co m_ id. */
		NORDICBET_COM_ID("77", "0", "NordicBet"),
		/** The NORS k_ tippin g_ co m_ id. */
		NORSK_TIPPING_COM_ID("78", "0", "NorskTipping"),
		/** The NOXWI n_ co m_ id. */
		NOXWIN_COM_ID("79", "0", "NoxWin"),
		/** The OFFSIDEBE t_ co m_ id. */
		OFFSIDEBET_COM_ID("80", "0", "OffsideBet"),
		/** The PADDYPOWE r_ co m_ id. */
		PADDYPOWER_COM_ID("81", "0", "PaddyPower"),
		/** The PA f_ co m_ id. */
		PAF_COM_ID("82", "0", "Paf"),
		/** The PARIMATC h_ co m_ id. */
		PARIMATCH_COM_ID("83", "0", "PariMatch"),
		/** The PARIONSWE b_ fd j_ f r_ id. */
		PARIONSWEB_FDJ_FR_ID("84", "0", "ParionsWeb"),
		/** The PINNACLESPORT s_ co m_ id. */
		PINNACLESPORTS_COM_ID("85", "0", "PinnacleSports"),
		/** The REDBE t_ co m_ id. */
		REDBET_COM_ID("86", "0", "RedBet"),
		/** The SBOBE t_ co m_ id. */
		SBOBET_COM_ID("87", "0", "SboBet"),
		/** The SCANDICBOOKMAKER s_ co m_ id. */
		SCANDICBOOKMAKERS_COM_ID("88", "0", "ScandicBookmakers"),
		/** The SCOR e24_ co m_ id. */
		SCORE24_COM_ID("57", "0", "Score24"),
		/** The SINGAPOREPOOL s_ co m_ id. */
		SINGAPOREPOOLS_COM_ID("89", "0", "SingaporePools"),
		/** The SKYBE t_ co m_ id. */
		SKYBET_COM_ID("90", "0", "SkyBet"),
		/** The SKYBOO k_ co m_ id. */
		SKYBOOK_COM_ID("91", "0", "SkyBook"),
		/** The SNA i_ co m_ id. */
		SNAI_COM_ID("92", "0", "Snai"),
		/** The SPORTBE t_ co m_ id. */
		SPORTBET_COM_ID("93", "0", "SportBet"),
		/** The SPORTINGBE t_ id. */
		SPORTINGBET_ID("107", "0", "SportingBet"),
		/** The SPORTSBETTIN g_ a g_ id. */
		SPORTSBETTING_AG_ID("111", "0", "SportsBetting.ag"),
		/** The SPORTSBETTIN g_ co m_ id. */
		SPORTSBETTING_COM_ID("94", "0", "SportsBetting"),
		/** The SPORTSBOO k_ co m_ id. */
		SPORTSBOOK_COM_ID("95", "0", "SportsBook"),
		/** The SPORTSINTERACTIO n_ co m_ id. */
		SPORTSINTERACTION_COM_ID("96", "0", "SportsInteraction"),
		/** The STANJAME s_ co m_ id. */
		STANJAMES_COM_ID("97", "0", "StanJames"),
		/** The TA b_ co m_ a u_ id. */
		TAB_COM_AU_ID("98", "0", "TabComAu"),
		/** The THAISTSBE t_ co m_ id. */
		THAISTSBET_COM_ID("99", "0", "ThaistsBet"),
		/** The TITANBE t_ co m_ id. */
		TITANBET_COM_ID("100", "0", "TitanBet"),
		/** The TOTESPOR t_ co m_ id. */
		TOTESPORT_COM_ID("101", "0", "ToteSport"),
		/** The TOTOLOTE k_ p l_ id. */
		TOTOLOTEK_PL_ID("102", "0", "TotoLotek"),
		/** The TRIOBE t_ co m_ id. */
		TRIOBET_COM_ID("103", "0", "TrioBet"),
		/** The UNIBE t_ co m_ id. */
		UNIBET_COM_ID("104", "0", "UniBet"),
		/** The UWIN. */
		UWIN("110", "0", "Uwin"),
		/** The WILLIAMHIL l_ co m_ id. */
		WILLIAMHILL_COM_ID("105", "0", "WilliamHill"),
		/** The YOUWI n_ co m_ id. */
		YOUWIN_COM_ID("106", "0", "YouWin"),
		/** The LUCKIA. */
		LUCKIA("113", "0", "Luckia.es");

		/**
		 * Gets the cfg bookmaker id by id.
		 * 
		 * @param idBookmaker
		 *            the id bookmaker
		 * @return the cfg bookmaker id by id
		 */
		public static CfgBookmakerId getCfgBookmakerIdById(String idBookmaker) {
			CfgBookmakerId[] values = CfgBookmakerId.values();
			for (int i = 0; i < values.length; i++) {
				if (values[i].objectId().toString().equals(idBookmaker)) {
					return values[i];
				}
			}
			return null;
		}

		/** The name is. */
		private final String nameId;

		/** The object id. */
		private final BigInteger objectId;

		/** The group id. */
		private final BigInteger groupId;

		/**
		 * Instantiates a new cfg bookmaker id.
		 * 
		 * @param objectId
		 *            the object id
		 * @param groupId
		 *            the group id
		 * @param aNameId
		 *            the a name id
		 */
		CfgBookmakerId(BigInteger objectId, BigInteger groupId, String aNameId) {
			this.objectId = objectId;
			this.groupId = groupId;
			this.nameId = aNameId;
		}

		/**
		 * Instantiates a new cfg bookmaker id.
		 * 
		 * @param objectId
		 *            the object id
		 * @param groupId
		 *            the group id
		 * @param aNameId
		 *            the a name id
		 */
		CfgBookmakerId(String objectId, String groupId, String aNameId) {
			this.objectId = new BigInteger(objectId);
			this.groupId = new BigInteger(groupId);
			this.nameId = new String(aNameId);
		}

		/**
		 * Name id.
		 * 
		 * @return the string
		 */
		public String nameId() {
			return nameId;
		}

		/**
		 * Object id.
		 * 
		 * @return the big integer {@inheritDoc}
		 */
		@Override
		public BigInteger objectId() {
			return objectId;
		}

		/**
		 * Group id.
		 * 
		 * @return the big integer
		 */
		public BigInteger groupId() {
			return groupId;
		}
	}

	/** The Constant BOOKMAKER_IMG_EXTENSION. */
	public static final String BOOKMAKER_IMG_EXTENSION = ".jpg";

	/** The Constant BOOKMAKER_LARGE_IMG_PATH. */
	public static final String BOOKMAKER_LARGE_IMG_PATH = "comparer/bookmaker/large/";

	/** The Constant BOOKMAKER_MEDIUM_IMG_PATH. */
	public static final String BOOKMAKER_MEDIUM_IMG_PATH = "comparer/bookmaker/medium/";

	/** The Constant BOOKMAKER_SMALL_IMG_PATH. */
	public static final String BOOKMAKER_SMALL_IMG_PATH = "comparer/bookmaker/small/";

	/** The Constant LARGE_IMG_APPENDIX. */
	public static final String LARGE_IMG_APPENDIX = "_140x25";

	/** The Constant MEDIUM_IMG_APPENDIX. */
	public static final String MEDIUM_IMG_APPENDIX = "_105x20";

	/** The Constant SMALL_IMG_APPENDIX. */
	public static final String SMALL_IMG_APPENDIX = "_65x15";

	/** The bookmaker configuration. */
	@Field
	@NotNull
	@Valid
	private CfgBookmakerConfiguration bookmakerConfiguration;

	/** The bookmaker xml reader. */
	@Field
	@NotNull
	@Valid
	private CfgBookmakerXmlReader bookmakerXmlReader;

	/** The group id. */
	@Field
	@NotNull
	private BigInteger groupId;

	/** The resource. */
	@Field
	private CfgResource resource;

	/**
	 * Instantiates a new cfg bookmaker.
	 */
	public CfgBookmaker() {
		super();
	}

	/**
	 * Instantiates a new cfg bookmaker.
	 * 
	 * @param pObjectId
	 *            the object id
	 */
	public CfgBookmaker(BigInteger pObjectId) {
		super(pObjectId);
	}

	/**
	 * Instantiates a new cfg bookmaker.
	 * 
	 * @param pObjectId
	 *            the object id
	 * @param groupId
	 *            the group id
	 */
	public CfgBookmaker(BigInteger pObjectId, BigInteger groupId) {
		super(pObjectId);
		this.groupId = groupId;
	}

	/**
	 * Instantiates a new cfg bookmaker.
	 * 
	 * @param pObjectId
	 *            the object id
	 */
	public CfgBookmaker(IObjectIdEnum pObjectId) {
		super(pObjectId);
	}

	/**
	 * Instantiates a new cfg bookmaker.
	 * 
	 * @param pObjectId
	 *            the object id
	 */
	public CfgBookmaker(String pObjectId) {
		super(pObjectId);
	}

	/**
	 * Equals.
	 * 
	 * @param obj
	 *            the obj
	 * @return true, if successful {@inheritDoc}
	 */

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CfgBookmaker other = (CfgBookmaker) obj;
		if (this.getI18n() == null) {
			if (other.getI18n() != null)
				return false;
		} else if (!this.getI18n().equals(other.getI18n()))
			return false;
		if (this.getI18n() == null) {
			if (other.getI18n() != null)
				return false;
		} else if (!this.getI18n().equals(other.getI18n()))
			return false;
		return true;
	}

	/**
	 * Gets the bookmaker configuration.
	 * 
	 * @return the bookmaker configuration
	 */
	public CfgBookmakerConfiguration getBookmakerConfiguration() {
		return bookmakerConfiguration;
	}

	/**
	 * Gets the bookmaker xml reader.
	 * 
	 * @return the bookmaker xml reader
	 */
	public CfgBookmakerXmlReader getBookmakerXmlReader() {
		return bookmakerXmlReader;
	}

	/**
	 * Gets the group id.
	 * 
	 * @return the group id
	 */
	public BigInteger getGroupId() {
		return groupId;
	}

	/**
	 * Gets the resource.
	 * 
	 * @return the resource
	 */
	public CfgResource getResource() {
		return getResourceSmallImg();
	}

	/**
	 * Gets the resource big img.
	 * 
	 * @return the resource big img
	 */
	public CfgResource getResourceLargeImg() {
		if (resource == null) {
			if (this.getNameId() != null) {
				resource = new CfgResource(new StringBuffer().append(BOOKMAKER_LARGE_IMG_PATH).append(this.getNameId().toLowerCase())
						.append(LARGE_IMG_APPENDIX).append(BOOKMAKER_IMG_EXTENSION).toString());
			}
		}
		return resource;
	}

	/**
	 * Gets the resource meduim img.
	 * 
	 * @return the resource meduim img
	 */
	public CfgResource getResourceMeduimImg() {
		if (resource == null) {
			if (this.getNameId() != null) {
				resource = new CfgResource(new StringBuffer().append(BOOKMAKER_MEDIUM_IMG_PATH).append(this.getNameId().toLowerCase())
						.append(MEDIUM_IMG_APPENDIX).append(BOOKMAKER_IMG_EXTENSION).toString());
			}
		}
		return resource;
	}

	/**
	 * Gets the resource small img.
	 * 
	 * @return the resource small img
	 */
	public CfgResource getResourceSmallImg() {
		if (resource == null) {
			if (this.getNameId() != null) {
				resource = new CfgResource(new StringBuffer().append(BOOKMAKER_SMALL_IMG_PATH).append(this.getNameId().toLowerCase())
						.append(SMALL_IMG_APPENDIX).append(BOOKMAKER_IMG_EXTENSION).toString());
			}
		}
		return resource;
	}

	/**
	 * Hash code.
	 * 
	 * @return the int {@inheritDoc}
	 */

	@Override
	public int hashCode() {
		return Integer.valueOf(this.getObjectId().toString());
	}

	/**
	 * Sets the bookmaker configuration.
	 * 
	 * @param pBookmakerConfiguration
	 *            the new bookmaker configuration
	 */
	public void setBookmakerConfiguration(CfgBookmakerConfiguration pBookmakerConfiguration) {
		bookmakerConfiguration = pBookmakerConfiguration;
	}

	/**
	 * Sets the bookmaker xml reader.
	 * 
	 * @param pBookmakerXmlReader
	 *            the new bookmaker xml reader
	 */
	public void setBookmakerXmlReader(CfgBookmakerXmlReader pBookmakerXmlReader) {
		bookmakerXmlReader = pBookmakerXmlReader;
	}

	/**
	 * Sets the group id.
	 * 
	 * @param groupId
	 *            the new group id
	 */
	public void setGroupId(BigInteger groupId) {
		this.groupId = groupId;
	}

	/**
	 * Sets the resource.
	 * 
	 * @param pResource
	 *            the new resource
	 */
	public void setResource(CfgResource pResource) {
		resource = pResource;
	}

	/**
	 * To string.
	 * 
	 * @return the string {@inheritDoc}
	 */
	@Override
	public String toString() {
		return "CfgBookmaker [bookmakerConfiguration=" + bookmakerConfiguration + ", bookmakerXmlReader=" + bookmakerXmlReader
				+ ", resource=" + resource + "]";
	}

}

package com.comparadorad.bet.comparer.web.client.gwt.securebet.ui.view;

import com.comparadorad.bet.comparer.web.client.gwt.common.ui.tables.GenericTable;
import com.comparadorad.bet.comparer.web.client.gwt.core.prop.AppProperties;


public class SecureBetTableFactory {

	/** The instance. */
	private static SecureBetTableFactory instance;



	/**
	 * Gets the instance.
	 * 
	 * @return the instance
	 */
	public static SecureBetTableFactory getInstance() {
		if (instance == null) {
			synchronized (SecureBetTableFactory.class) {
				instance = new SecureBetTableFactory();
			}
		}
		return instance;
	}

	public GenericTable getSecureBetTable(){
		GenericTable result = null;
		String env =  AppProperties.getInstance().getGwtEnvironment();
		env = AppProperties._BETCOMPARAENV;
		if(env.equals(AppProperties._BETCOMPARAENV)){
			result = new SecureBetTableBetCompara();
		}else if(env.equals(AppProperties._BETCOMPARAZEROENV)){
			result = new SecureBetTableBetComparaZero();
		}

		return result;
	}



}

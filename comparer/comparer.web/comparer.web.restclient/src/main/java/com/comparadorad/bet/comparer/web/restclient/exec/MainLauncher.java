package com.comparadorad.bet.comparer.web.restclient.exec;

public class MainLauncher {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		if (args.length !=0 && args[0].equals("f")){
			new CallRestFromUrlFile().execute();	
		}else{
			new CallRestControllers().execute();
		}

	}

}

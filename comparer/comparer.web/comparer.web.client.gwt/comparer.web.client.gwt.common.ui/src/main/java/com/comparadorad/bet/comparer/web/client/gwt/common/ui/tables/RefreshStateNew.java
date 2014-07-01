package com.comparadorad.bet.comparer.web.client.gwt.common.ui.tables;

import com.comparadorad.bet.comparer.web.client.gwt.core.ui.GhxWaitModalWindow;

public class RefreshStateNew {

	private boolean refreshInProgress = false;
	
	private int numRefreshTries = 0;

	public boolean isRefreshInProgress() {
		return refreshInProgress;
	}

	public void setInProgress(boolean pInProgress) {
		if (pInProgress) {
			GhxWaitModalWindow.show("");
		} else {
			GhxWaitModalWindow.close();
		}
		refreshInProgress = pInProgress;
	}
	
	public void initRefreshProcess() {
		refreshInProgress = true;
	}
	
	public void finishRefreshProcess() {
		refreshInProgress = false;
	}
	
	public void increaseNumRefreshTries() {
		numRefreshTries++;
	}
	
	public int getNumRefreshTries() {
		return numRefreshTries;
	}
	
	public void resetNumRefreshTries() {
		numRefreshTries = 0;
	}
}

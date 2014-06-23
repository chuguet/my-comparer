package com.comparadorad.bet.comparer.autosender.core.responsebean;

import java.util.HashMap;
import java.util.Map;

public class CampaignListBean extends AbstractResponseBean {
	
	private Map<String,String> campaignNameAndcampaignId;

	public Map<String, String> getCampaignNameAndcampaignId() {
		if( campaignNameAndcampaignId == null ){
			campaignNameAndcampaignId = new HashMap<String, String>();
		}
		return campaignNameAndcampaignId;
	}

	public void setCampaignNameAndcampaignId(
			Map<String, String> campaignNameAndcampaignId) {
		this.campaignNameAndcampaignId = campaignNameAndcampaignId;
	}
	
	
	
	

}

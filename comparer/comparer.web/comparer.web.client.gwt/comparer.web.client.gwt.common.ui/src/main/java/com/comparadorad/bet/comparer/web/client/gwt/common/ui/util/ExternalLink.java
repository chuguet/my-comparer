package com.comparadorad.bet.comparer.web.client.gwt.common.ui.util;

import com.google.gwt.user.client.Window;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.types.Cursor;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.Img;
import com.smartgwt.client.widgets.Label;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;

public class ExternalLink extends Canvas {

	/** The id. */
	private String url;
	
	private String imgLocation;
	
	private String linkName;
	
	public ExternalLink(String pUrl, String pLinkName, String pImgLocation) {
		url = pUrl;
		imgLocation = pImgLocation;
		linkName = pLinkName;
		
		setWidth(40);
		setAutoHeight();
		setAlign(Alignment.CENTER);
		if (imgLocation != null) {
			Img img = new Img(imgLocation);
			img.setWidth(65);
			img.setHeight(10);
			img.setCursor(Cursor.HAND);
			addChild(img);
		}
		else if (linkName != null) {
			Label label = new Label(linkName);
			label.setWidth(80);
			label.setAutoHeight();
			label.setAutoFit(true);
			label.setCursor(Cursor.HAND);
			addChild(label);
		}
		addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				Window.open(url, "hej", null);
			}
		});
		
	}

	
	
	public String getUrl() {
		return url;
	}

	public void setUrl(String pUrl) {
		url = pUrl;
	}

	public String getImgLocation() {
		return imgLocation;
	}

	public void setImgLocation(String pImgLocation) {
		imgLocation = pImgLocation;
	}

	public String getLinkName() {
		return linkName;
	}

	public void setLinkName(String pLinkName) {
		linkName = pLinkName;
	}

	public void setId(String pId) {
		id = pId;
	}
	
	
}


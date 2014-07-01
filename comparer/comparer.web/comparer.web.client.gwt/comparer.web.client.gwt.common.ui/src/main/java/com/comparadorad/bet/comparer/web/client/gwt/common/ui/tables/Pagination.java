/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.web.client.gwt.common.ui.tables;

import java.util.ArrayList;
import java.util.List;

import com.allen_sauer.gwt.log.client.Log;
import com.comparadorad.bet.comparer.web.client.gwt.common.ui.Messages;
import com.google.gwt.core.client.GWT;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.types.Cursor;
import com.smartgwt.client.widgets.Label;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;

/**
 * The Class Pagination.
 */
public class Pagination extends VLayout {

	/** The messages. */
	protected static Messages messages = GWT.create(Messages.class);

	/** The Constant NEXT_PREVIOUS_LABEL_HEIGHT. */
	private static final int NEXT_PREVIOUS_LABEL_HEIGHT = 15;

	/** The Constant NEXT_PREVIOUS_LABEL_WIDTH. */
	private static final int NEXT_PREVIOUS_LABEL_WIDTH = 15;

	/** The Constant PAGE_LABEL_HEIGHT. */
	private static final int PAGE_LABEL_HEIGHT = 10;

	/** The Constant PAGE_LABEL_ID. */
	private static final String PAGE_LABEL_ID = "id";

	/** The Constant PAGE_LABEL_WIDTH. */
	private static final int PAGE_LABEL_WIDTH = 100;

	/** The Constant TITLE_NEXT_PAGE. */
	private static final String TITLE_NEXT_PAGE = messages.siguientes();

	/** The Constant TITLE_PREVIOUS_PAGE. */
	private static final String TITLE_PREVIOUS_PAGE = messages.anteriores();

	/** The current label num. */
	private int currentLabelNum = 0;

	/** The current page num. */
	private long currentPageNum = 0;

	/** The first page label text. */
	private long firstPageLabelText = 0;

	/** The h layout. */
	private HLayout hLayout;

	/** The label num value bets. */
	private Label labelNumValueBets;

	/** The labels. */
	List<Label> labels;

	/** The last page label text. */
	private long lastPageLabelText = 0;

	/** The next page. */
	private Label nextPage;;

	/** The num value bets. */
	private long numRecords;

	/** The previous page. */
	private Label previousPage;

	/** The title total number of records. */
	private String titleTotalNumberOfRecords = "";

	/** The tooltip text. */
	private String tooltipText = "";

	/** The total num pages. */
	private long totalNumPages = 0;

	/**
	 * Instantiates a new pagination.
	 * 
	 * @param titleTotalNumberOfRecords
	 *            the title total number of records
	 * @param tooltipText
	 *            the tooltip text
	 * @param inicialPageNum
	 *            the inicial page num
	 */
	public Pagination(String titleTotalNumberOfRecords, String tooltipText,
			Long inicialPageNum) {
		if (inicialPageNum != null) {
			currentPageNum = inicialPageNum;
			currentLabelNum = (int) (inicialPageNum % 10);
			firstPageLabelText = inicialPageNum - currentLabelNum;
		}
		this.tooltipText = tooltipText;
		this.titleTotalNumberOfRecords = titleTotalNumberOfRecords;

		setAlign(Alignment.CENTER);
		setLayoutAlign(Alignment.CENTER);

		hLayout = new HLayout();
		hLayout.setAlign(Alignment.CENTER);
		hLayout.setLayoutAlign(Alignment.CENTER);

		labelNumValueBets = new Label(titleTotalNumberOfRecords);
		labelNumValueBets.setWrap(false);
		labelNumValueBets.setAlign(Alignment.CENTER);
		labelNumValueBets.setAutoFit(true);

		nextPage = new Label(TITLE_NEXT_PAGE);
		nextPage.setCursor(Cursor.HAND);
		nextPage.setWidth(PAGE_LABEL_WIDTH);
		nextPage.setHeight(PAGE_LABEL_HEIGHT);
		nextPage.setWrap(false);
		nextPage.setAlign(Alignment.CENTER);
		nextPage.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent pEvent) {
				Log.debug("nextPageClick");
				updatePagination(labels.get(currentLabelNum + 1));
			}
		});

		previousPage = new Label(TITLE_PREVIOUS_PAGE);
		previousPage.setCursor(Cursor.HAND);
		previousPage.setWidth(PAGE_LABEL_WIDTH);
		previousPage.setHeight(PAGE_LABEL_HEIGHT);
		previousPage.setWrap(false);
		previousPage.setAlign(Alignment.CENTER);
		previousPage.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent pEvent) {
				updatePagination(labels.get(currentLabelNum - 1));
			}
		});

		hLayout.setMembersMargin(10);
		hLayout.setMargin(30);
		hLayout.addMember(previousPage);
		labels = new ArrayList<Label>();
		for (int id = 0; id < 10; id++) {
			Label label = new Label();
			labels.add(label);
			label.setID(new StringBuffer(PAGE_LABEL_ID).append(id).toString());
			final Label finalLabel = label;
			label.addClickHandler(new ClickHandler() {
				@Override
				public void onClick(ClickEvent pEvent) {
					Log.debug("onClick: finalLabel.getId() = "
							+ finalLabel.getID());
					updatePagination(finalLabel);
				}
			});
			label.setWidth(NEXT_PREVIOUS_LABEL_WIDTH);
			label.setHeight(NEXT_PREVIOUS_LABEL_HEIGHT);
			label.setAlign(Alignment.CENTER);
			label.setCursor(Cursor.HAND);
			hLayout.addMember(label);
		}
		hLayout.addMember(nextPage);
		addMember(hLayout);

		HLayout h = new HLayout();
		h.setAlign(Alignment.CENTER);
		h.setLayoutAlign(Alignment.CENTER);
		h.addMember(labelNumValueBets);
		addMember(h);

		restylePageNumberLabels(0);
	}

	/**
	 * Block access to next pages.
	 */
	public void blockAccessToNextPages() {
		Log.debug("blockAccessToNextPages");
		nextPage.setDisabled(true);
		previousPage.setDisabled(true);
		for (int i = 1; i < 10; i++) {
			labels.get(i).setDisabled(true);
		}
		// TODO definar texto del tooltip y ponerlo en Messages
		hLayout.setTooltip(tooltipText);
	}

	/**
	 * Gets the current label num.
	 * 
	 * @return the current label num
	 */
	public int getCurrentLabelNum() {
		return currentLabelNum;
	}

	/**
	 * Gets the integer id.
	 * 
	 * @param pId
	 *            the id
	 * @return the integer id
	 */
	private String getIntegerId(String pId) {
		// Quitando letras
		return pId.replaceAll("\\D+", "");
	};

	/**
	 * Gets the num value bets.
	 * 
	 * @return the num value bets
	 */
	public long getNumRecords() {
		return numRecords;
	}

	/**
	 * Gets the page num.
	 * 
	 * @return the page num
	 */
	public long getPageNum() {
		return currentPageNum;
	}

	/**
	 * Gets the total num pages.
	 * 
	 * @return the total num pages
	 */
	public long getTotalNumPages() {
		return totalNumPages;
	}

	/**
	 * Next previous label control.
	 * 
	 * @param pLabelNum
	 *            the label num
	 */
	private void nextPreviousLabelControl(int pLabelNum) {
		Log.debug("nextPreviousLabelControl");
		if (currentPageNum == 0) {
			previousPage.setDisabled(true);
			previousPage.setContents(" ");
		} else if (previousPage.getDisabled()) {
			previousPage.setDisabled(false);
			previousPage.setContents(TITLE_PREVIOUS_PAGE);
		}
		if (currentPageNum == totalNumPages - 1) {
			nextPage.setDisabled(true);
			nextPage.setContents(" ");
		} else if (nextPage.getDisabled()) {
			nextPage.setDisabled(false);
			nextPage.setContents(TITLE_NEXT_PAGE);
		}
	}

	/**
	 * Re name label nums.
	 * 
	 * @param labelNum
	 *            the label num
	 */
	private void reNameLabelNums(final int labelNum) {
		if (labelNum >= 6) {
			firstPageLabelText = firstPageLabelText + (labelNum - 5);
		} else {
			firstPageLabelText = firstPageLabelText + (labelNum - 6);
		}
		// Control de limites
		if (firstPageLabelText < 0) {
			firstPageLabelText = 0;
		}
		lastPageLabelText = firstPageLabelText + 9;
		if (lastPageLabelText > totalNumPages - 1) {
			lastPageLabelText = totalNumPages - 1;
			if (totalNumPages >= 10) {
				firstPageLabelText = lastPageLabelText - 9; // no avanza
			} else {
				firstPageLabelText = 0;
			}
		}
		long title = firstPageLabelText + 1;
		for (int i = 0; i < 10; i++) {
			if (currentPageNum == (title - 1)) {
				currentLabelNum = i;
				restylePageNumberLabels(i);
			}
			if (i < lastPageLabelText + 1) {
				labels.get(i).setContents(Long.toString(title));
				if (labels.get(i).isDisabled()) {
					labels.get(i).setContents(Long.toString(title));
					labels.get(i).setDisabled(false);
					labels.get(i).show();
				}
			} else {
				labels.get(i).setDisabled(true);
				labels.get(i).setContents(" ");
				labels.get(i).hide();
			}
			title++;
		}
	}

	/**
	 * Restyle page number labels.
	 * 
	 * @param i
	 *            the i
	 */
	private void restylePageNumberLabels(int i) {
		for (Label label : labels) {
			label.setStyleName("paginationUnMarkedNumber");
		}
		labels.get(i).setStyleName("paginationMarkedNumber");
	}

	/**
	 * Sets the current label num.
	 * 
	 * @param pCurrentLabelNum
	 *            the new current label num
	 */
	public void setCurrentLabelNum(int pCurrentLabelNum) {
		currentLabelNum = pCurrentLabelNum;
	}

	/**
	 * Sets the num value bets.
	 * 
	 * @param pNumRecords
	 *            the new num value bets
	 */
	public void setNumRecords(long pNumRecords) {
		if (numRecords != pNumRecords) {
			numRecords = pNumRecords;
			labelNumValueBets.setContents(new StringBuffer()
					.append(titleTotalNumberOfRecords).append(numRecords)
					.toString());
		}
		long tempTotalNumPages = (long) Math.ceil(((double) numRecords) / 10);
		Log.debug("totalNumPages = " + tempTotalNumPages);
		if (tempTotalNumPages != totalNumPages) {
			totalNumPages = tempTotalNumPages;
			if (currentPageNum > totalNumPages - 1) {
				currentPageNum = totalNumPages - 1;
			}
			reNameLabelNums(currentLabelNum);
		}
		nextPreviousLabelControl(currentLabelNum);
	}

	/**
	 * Sets the page num.
	 * 
	 * @param pPageNum
	 *            the new page num
	 */
	public void setPageNum(final long pPageNum) {
		currentPageNum = pPageNum;
	}

	/**
	 * Update pagination.
	 * 
	 * @param label
	 *            the label
	 */
	protected void updatePagination(final Label label) {
		int labelNum = Integer.parseInt(getIntegerId(label.getID()));
		int pageNum = Integer.parseInt(label.getTitle()) - 1;
		currentLabelNum = labelNum;
		currentPageNum = pageNum;
		reNameLabelNums(labelNum);
		nextPreviousLabelControl(labelNum);
	}

}

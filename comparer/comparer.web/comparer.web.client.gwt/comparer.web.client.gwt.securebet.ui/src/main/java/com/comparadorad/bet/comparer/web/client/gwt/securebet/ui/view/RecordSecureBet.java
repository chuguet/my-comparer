/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.web.client.gwt.securebet.ui.view;

import java.util.ArrayList;
import java.util.List;

import com.allen_sauer.gwt.log.client.Log;
import com.comparadorad.bet.comparer.web.client.gwt.common.bean.ExternalLinkTo;
import com.comparadorad.bet.comparer.web.client.gwt.common.bean.table.TableResponseCellTo;
import com.comparadorad.bet.comparer.web.client.gwt.common.bean.table.TableResponseRowTo;
import com.comparadorad.bet.comparer.web.client.gwt.common.ui.tables.ColName;
import com.comparadorad.bet.comparer.web.client.gwt.common.ui.tables.GenericRecord;
import com.comparadorad.bet.comparer.web.client.gwt.securebet.ui.view.calculator.GenerateBeanCalculatorUtil;

/**
 * The Class RecordSecureBet.
 */
public class RecordSecureBet extends GenericRecord {

	/** The Constant EXP_RESP_ROW_SIZE. */
	private static final int EXP_RESP_ROW_SIZE = 6;

	/** The Constant MULT_EXT_LINK_CONT. */
	private static final String MULT_EXT_LINK_CONT = "multExtLinkCont";

	/**
	 * Instantiates a new record secure bet.
	 * 
	 * @param pRowData
	 *            the row data
	 */
	public RecordSecureBet(TableResponseRowTo pRowData) {
		if (rowSizeAsExpected(pRowData.getCellList(), EXP_RESP_ROW_SIZE)) {
			setRecordId(pRowData.getObjectToId().getId());
			setIntLink(ColName.getCol(0), pRowData.getCellList().get(0));
			setDate(ColName.getCol(0), pRowData.getCellList().get(0));
			setValueStrWithSpace(ColName.getCol(1), pRowData.getCellList().get(1));
			setValueStr(ColName.getCol(2), pRowData.getCellList().get(2));
			setMultipleExtLink(ColName.getCol(3), pRowData.getCellList().get(3));
			setMultipleExtLink(ColName.getCol(4), pRowData.getCellList().get(4));
			setValueStr(ColName.getCol(5), pRowData.getCellList().get(5));

			// TODO poner aqui la imagen y no lo de la columna 5
			setValueStr(ColName.getCol(6), pRowData.getCellList().get(5));
			setAttribute("calculator", GenerateBeanCalculatorUtil.generateBean(pRowData));
			Log.debug(getAttributeAsObject("calculator").toString());
		}
	}

	/**
	 * Gets the ext link img.
	 * 
	 * @param fieldName
	 *            the field name
	 * @param cont
	 *            the cont
	 * @return the ext link img
	 */
	public String getExtLinkImg(String fieldName, int cont) {
		return getAttributeAsString(fieldName + EXT_LINK_IMG + cont);
	}

	/**
	 * Gets the ext link action analytics.
	 * 
	 * @param fieldName
	 *            the field name
	 * @param cont
	 *            the cont
	 * @return the ext link action analytics
	 */
	public String getExtLinkActionAnalytics(String fieldName, int cont) {
		return getAttributeAsString(fieldName + EXT_LINK_ACTION + cont);
	}

	/**
	 * Gets the ext link category analytics.
	 * 
	 * @param fieldName
	 *            the field name
	 * @param cont
	 *            the cont
	 * @return the ext link category analytics
	 */
	public String getExtLinkCategoryAnalytics(String fieldName, int cont) {
		return getAttributeAsString(fieldName + EXT_LINK_CATEGORY + cont);
	}

	/**
	 * Gets the ext link text.
	 * 
	 * @param fieldName
	 *            the field name
	 * @param cont
	 *            the cont
	 * @return the ext link text
	 */
	public String getExtLinkText(String fieldName, int cont) {
		return getAttributeAsString(fieldName + EXT_LINK_TEXT + cont);
	}

	/**
	 * Gets the ext link url.
	 * 
	 * @param fieldName
	 *            the field name
	 * @param cont
	 *            the cont
	 * @return the ext link url
	 */
	public String getExtLinkUrl(String fieldName, int cont) {
		return getAttributeAsString(fieldName + EXT_LINK_URL + cont);
	}

	/**
	 * Gets the mult ext link cont.
	 * 
	 * @param fieldName
	 *            the field name
	 * @return the mult ext link cont
	 */
	public int getMultExtLinkCont(String fieldName) {
		return getAttributeAsInt(fieldName + MULT_EXT_LINK_CONT);
	}

	/**
	 * Sets the date.
	 * 
	 * @param fieldName
	 *            the field name
	 * @param cellData
	 *            the cell data
	 * @return true, if successful {@inheritDoc}
	 */
	@Override
	protected boolean setDate(String fieldName, TableResponseCellTo cellData) {
		String oldValue = null;
		String newValue = null;
		if (cellData.getValueTo() != null && cellData.getValueTo().getDate() != null) {
			oldValue = getAttributeAsString(fieldName + DATE);
			newValue = cellData.getValueTo().getDate();
			setAttribute(fieldName + DATE, newValue);
		} else {
			Log.error("Expected value 'date' but was null");
		}
		return oldValue != null && !oldValue.equalsIgnoreCase(newValue);
	}

	/**
	 * Sets the int link.
	 * 
	 * @param fieldName
	 *            the field name
	 * @param cellData
	 *            the cell data
	 * @return true, if successful {@inheritDoc}
	 */
	@Override
	protected boolean setIntLink(String fieldName, TableResponseCellTo cellData) {
		String oldValue = null;
		String newValue = null;
		boolean changed = false;
		if (cellData.getLinkTo() != null && cellData.getLinkTo().getName() != null) {
			oldValue = getAttributeAsString(fieldName + INT_LINK_TEXT);
			newValue = cellData.getLinkTo().getName();
			setAttribute(fieldName + INT_LINK_TEXT, newValue);
			changed = oldValue != null && !oldValue.equalsIgnoreCase(newValue);
		} else {
			Log.error("Expected value 'intLinkText' but was null");
		}
		if (cellData.getLinkTo() != null && cellData.getLinkTo().getObjectToId() != null
				&& cellData.getLinkTo().getObjectToId().getId() != null) {
			oldValue = getAttributeAsString(fieldName + INT_LINK_ID);
			newValue = cellData.getLinkTo().getObjectToId().getId();
			setAttribute(fieldName + INT_LINK_ID, newValue);
		} else {
			Log.error("Expected value 'intLinkId' but was null");
		}
		if (cellData.getLinkTo() != null && cellData.getLinkTo().getObjectToIdAux() != null
				&& cellData.getLinkTo().getObjectToIdAux().getId() != null) {
			oldValue = getAttributeAsString(fieldName + INT_LINK_ID_AUX);
			newValue = cellData.getLinkTo().getObjectToIdAux().getId();
			setAttribute(fieldName + INT_LINK_ID_AUX, newValue);
		}
		if (cellData.getLinkTo() != null && cellData.getLinkTo().getObjectToIdAux2() != null
				&& cellData.getLinkTo().getObjectToIdAux2().getId() != null) {
			oldValue = getAttributeAsString(fieldName + INT_LINK_ID_AUX_2);
			newValue = cellData.getLinkTo().getObjectToIdAux2().getId();
			setAttribute(fieldName + INT_LINK_ID_AUX_2, newValue);
		} else {
			Log.error("Expected value 'intLinkIdAux' but was null");
		}
		return changed || (oldValue != null && !oldValue.equalsIgnoreCase(newValue));
	}

	/**
	 * Sets the multiple ext link.
	 * 
	 * @param fieldName
	 *            the field name
	 * @param cellData
	 *            the cell data
	 * @return true, if successful
	 */
	protected boolean setMultipleExtLink(String fieldName, TableResponseCellTo cellData) {
		String oldValue = null;
		String newValue = null;
		boolean changed = false;
		if (cellData.getExternalLinkToList() != null) {
			setAttribute(fieldName + MULT_EXT_LINK_CONT, cellData.getExternalLinkToList().size());
			int linkCont = 0;
			for (ExternalLinkTo link : cellData.getExternalLinkToList()) {
				if (link.getLinkImgLocation() != null) {
					oldValue = getAttributeAsString(fieldName + EXT_LINK_IMG + linkCont);
					newValue = link.getLinkImgLocation();
					setAttribute(fieldName + EXT_LINK_IMG + linkCont, newValue);
					changed = oldValue != null && !oldValue.equalsIgnoreCase(newValue);
				}
				if (link.getLinkText() != null) {
					oldValue = getAttributeAsString(fieldName + EXT_LINK_TEXT + linkCont);
					newValue = link.getLinkText();
					setAttribute(fieldName + EXT_LINK_TEXT + linkCont, newValue);
					changed = changed || (oldValue != null && !oldValue.equalsIgnoreCase(newValue));
				}
				if (link.getActionAnalytics() != null) {
					oldValue = getAttributeAsString(fieldName + EXT_LINK_ACTION + linkCont);
					newValue = link.getActionAnalytics();
					setAttribute(fieldName + EXT_LINK_ACTION + linkCont, newValue);
					changed = changed || (oldValue != null && !oldValue.equalsIgnoreCase(newValue));
				}
				if (link.getCategoryAnalytics() != null) {
					oldValue = getAttributeAsString(fieldName + EXT_LINK_CATEGORY + linkCont);
					newValue = link.getCategoryAnalytics();
					setAttribute(fieldName + EXT_LINK_CATEGORY + linkCont, newValue);
					changed = changed || (oldValue != null && !oldValue.equalsIgnoreCase(newValue));
				}

				if (link.getUrl() != null) {
					oldValue = getAttributeAsString(fieldName + EXT_LINK_URL + linkCont);
					newValue = link.getUrl();
					setAttribute(fieldName + EXT_LINK_URL + linkCont, newValue);
					changed = changed || (oldValue != null && !oldValue.equalsIgnoreCase(newValue));
				} else {
					Log.error("Expected value 'linkUrl' but was null");
				}
				linkCont++;
			}
		} else {
			Log.error("Expected value 'extLinkList' but was null");
		}
		return changed;
	}

	/**
	 * Update.
	 * 
	 * @param pRowData
	 *            the row data
	 * @return the list {@inheritDoc}
	 */
	public List<Integer> update(TableResponseRowTo pRowData) {
		boolean changed = false;
		List<Integer> cellNumsToUpdate = new ArrayList<Integer>();
		changed = setDate(ColName.getCol(0), pRowData.getCellList().get(0));
		if (changed) {
			cellNumsToUpdate.add(0);
		}
		changed = setValueStrWithSpace(ColName.getCol(1), pRowData.getCellList().get(1));
		if (changed) {
			cellNumsToUpdate.add(1);
		}
		changed = setValueStr(ColName.getCol(2), pRowData.getCellList().get(2));
		if (changed) {
			cellNumsToUpdate.add(2);
		}
		changed = setMultipleExtLink(ColName.getCol(3), pRowData.getCellList().get(3));
		if (changed) {
			cellNumsToUpdate.add(3);
		}
		changed = setMultipleExtLink(ColName.getCol(4), pRowData.getCellList().get(4));
		if (changed) {
			cellNumsToUpdate.add(4);
		}
		changed = setValueStr(ColName.getCol(5), pRowData.getCellList().get(5));
		if (changed) {
			cellNumsToUpdate.add(5);
		}
		return cellNumsToUpdate;
	}

}

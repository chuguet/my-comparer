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
import com.comparadorad.bet.comparer.web.client.gwt.common.bean.ObjectToId;
import com.comparadorad.bet.comparer.web.client.gwt.common.bean.literal.CommonLiterals;
import com.comparadorad.bet.comparer.web.client.gwt.common.bean.table.TableResponseCellTo;
import com.comparadorad.bet.comparer.web.client.gwt.common.bean.table.TableResponseRowTo;
import com.comparadorad.bet.comparer.web.client.gwt.common.ui.Messages;
import com.google.gwt.core.client.GWT;
import com.smartgwt.client.widgets.grid.ListGridRecord;

/**
 * The Class GenericRecord.
 */
public class GenericRecord extends ListGridRecord {

	/** The Constant ASCENDING_SORT_VALUE. */
	protected final static String ASCENDING_SORT_VALUE = "ascendingSortValue";

	/** The Constant DATE. */
	protected static final String DATE = "date";

	/** The Constant DESCENDING_SORT_VALUE. */
	protected final static String DESCENDING_SORT_VALUE = "descendingSortValue";

	/** The Constant EXT_LINK_IMG. */
	protected static final String EXT_LINK_IMG = "extLinkImg";

	/** The Constant EXT_LINK_TEXT. */
	protected static final String EXT_LINK_TEXT = "extLinkText";

	/** The Constant EXT_LINK_URL. */
	protected static final String EXT_LINK_URL = "extLinkUrl";

	protected static final String EXT_LINK_ACTION = "extLinkActionAnalytics";
	
	protected static final String EXT_LINK_CATEGORY = "extLinkCategoryAnalytics";

	/** The Constant IMG_LOCATION. */
	protected static final String IMG_LOCATION = "location";

	/** The Constant INT_LINK_ID. */
	protected static final String INT_LINK_ID = "intLinkId";

	/** The Constant INT_LINK_ID_AUX. */
	protected static final String INT_LINK_ID_AUX = "intLinkIdAux";

	/** The Constant INT_LINK_ID_AUX_2. */
	protected static final String INT_LINK_ID_AUX_2 = "intLinkIdAux2";

	/** The Constant INT_LINK_TEXT. */
	protected static final String INT_LINK_TEXT = "intLinkText";

	/** The Constant LITERAL. */
	private static final String LITERAL = "literal";

	/** The messages. */
	protected static Messages messages = GWT.create(Messages.class);

	/** The Constant RECORD_ID. */
	protected static final String RECORD_ID = "recordId";

	/** The Constant VALUE. */
	protected static final String VALUE = "value";

	/**
	 * Gets the record id attribute name.
	 * 
	 * @return the record id attribute name
	 */
	public static String getRecordIdAttributeName() {
		return RECORD_ID;
	}

	/**
	 * Generate html string with new lines at seperator symbol.
	 * 
	 * @param originalString
	 *            the original string
	 * @param seperatorSymbol
	 *            the seperator symbol
	 * @return the string
	 */
	protected String generateHtmlStringWithNewLinesAtSeperatorSymbol(String originalString, char seperatorSymbol) {
		StringBuffer result = new StringBuffer();
		for (char c : originalString.toCharArray()) {
			if (c == seperatorSymbol) {
				result.append("</br>");
			} else {
				result.append(c);
			}
		}
		return result.toString();
	}

	/**
	 * Gets the ascending sort value.
	 * 
	 * @param fieldName
	 *            the field name
	 * @return the ascending sort value
	 */
	public double getAscendingSortValue(String fieldName) {
		return Double.parseDouble(normalizeValue(getAttributeAsString(fieldName + ASCENDING_SORT_VALUE)));
	}

	/**
	 * Gets the date.
	 * 
	 * @param fieldName
	 *            the field name
	 * @return the date
	 */
	protected String getDate(String fieldName) {
		return getAttributeAsString(fieldName + DATE);
	}

	/**
	 * Gets the descending sort value.
	 * 
	 * @param fieldName
	 *            the field name
	 * @return the descending sort value
	 */
	public double getDescendingSortValue(String fieldName) {
		return Double.parseDouble(normalizeValue(getAttributeAsString(fieldName + DESCENDING_SORT_VALUE)));
	}

	/**
	 * Gets the ext link img.
	 * 
	 * @param fieldName
	 *            the field name
	 * @return the ext link img
	 */
	public String getExtLinkImg(String fieldName) {
		return getAttributeAsString(fieldName + EXT_LINK_IMG);
	}

	/**
	 * Gets the ext link text.
	 * 
	 * @param fieldName
	 *            the field name
	 * @return the ext link text
	 */
	public String getExtLinkText(String fieldName) {
		return getAttributeAsString(fieldName + EXT_LINK_TEXT);
	}

	/**
	 * Gets the ext link url.
	 * 
	 * @param fieldName
	 *            the field name
	 * @return the ext link url
	 */
	public String getExtLinkUrl(String fieldName) {
		return getAttributeAsString(fieldName + EXT_LINK_URL);
	}
	
	public String getExtLinkActionAnalytics(String fieldName) {
		return getAttributeAsString(fieldName + EXT_LINK_ACTION);
	}
	
	public String getExtLinkCategoryAnalytics(String fieldName) {
		return getAttributeAsString(fieldName + EXT_LINK_CATEGORY);
	}

	/**
	 * Gets the img location.
	 * 
	 * @param fieldName
	 *            the field name
	 * @return the img location
	 */
	protected String getImgLocation(String fieldName) {
		return getAttribute(fieldName + IMG_LOCATION);
	}

	/**
	 * Gets the int link id.
	 * 
	 * @param fieldName
	 *            the field name
	 * @return the int link id
	 */
	public String getIntLinkId(String fieldName) {
		return getAttributeAsString(fieldName + INT_LINK_ID);
	}

	/**
	 * Gets the int link id aux.
	 * 
	 * @param fieldName
	 *            the field name
	 * @return the int link id aux
	 */
	public String getIntLinkIdAux(String fieldName) {
		return getAttributeAsString(fieldName + INT_LINK_ID_AUX);
	}

	/**
	 * Gets the int link id aux2.
	 * 
	 * @param fieldName
	 *            the field name
	 * @return the int link id aux2
	 */
	public String getIntLinkIdAux2(String fieldName) {
		return getAttributeAsString(fieldName + INT_LINK_ID_AUX_2);
	}

	/**
	 * Gets the int link text.
	 * 
	 * @param fieldName
	 *            the field name
	 * @return the int link text
	 */
	public String getIntLinkText(String fieldName) {
		return getAttributeAsString(fieldName + INT_LINK_TEXT);
	}

	/**
	 * Gets the random payout.
	 * 
	 * @return the random payout
	 */
	public String getRandomPayout() {
		StringBuffer result = new StringBuffer();
		result.append("" + (int) ((Math.random() * 9) + 90));
		result.append("%");
		return result.toString();
	}

	/**
	 * Gets the record id.
	 * 
	 * @return the record id
	 */
	public String getRecordId() {
		return getAttributeAsString(RECORD_ID);
	}

	/**
	 * Gets the value str.
	 * 
	 * @param fieldName
	 *            the field name
	 * @return the value str
	 */
	protected String getValueStr(String fieldName) {
		return getAttributeAsString(fieldName + VALUE);
	}

	/**
	 * Normalize value.
	 * 
	 * @param value
	 *            the value
	 * @return the string
	 */
	protected String normalizeValue(String value) {
		String result = value.replaceAll(",", ".");
		result = value.replaceAll("%", "");
		result = result.trim();
		return result;
	}

	/**
	 * Row size as expected.
	 * 
	 * @param cellList
	 *            the cell list
	 * @param expectedRowSize
	 *            the expected row size
	 * @return true, if successful
	 */
	protected boolean rowSizeAsExpected(List<TableResponseCellTo> cellList, int expectedRowSize) {
		boolean rowSizeAsExpected = cellList != null && cellList.size() == expectedRowSize;
		if (!rowSizeAsExpected) {
			Log.error("Expected number of cells in response is " + expectedRowSize + ", but was "
					+ (cellList != null ? cellList.size() : null));
		}
		return rowSizeAsExpected;
	}

	/**
	 * Sets the date.
	 * 
	 * @param fieldName
	 *            the field name
	 * @param cellData
	 *            the cell data
	 * @return true, if successful
	 */
	protected boolean setDate(String fieldName, TableResponseCellTo cellData) {
		String oldValue = null;
		String newValue = null;
		if (cellData.getValueTo() != null && cellData.getValueTo().getDate() != null) {
			oldValue = getAttributeAsString(fieldName + DATE);
			newValue = cellData.getValueTo().getDate();
			setAttribute(fieldName, newValue);
			setAttribute(fieldName + DATE, newValue);
		} else {
			Log.error("Expected value 'date' but was null");
		}
		return oldValue != null && !oldValue.equalsIgnoreCase(newValue);
	}

	/**
	 * Sets the direct value.
	 * 
	 * @param fieldName
	 *            the field name
	 * @param value
	 *            the value
	 */
	protected void setDirectValue(String fieldName, String value) {
		setAttribute(fieldName, value);
	}

	/**
	 * Sets the ext link.
	 * 
	 * @param fieldName
	 *            the field name
	 * @param cellData
	 *            the cell data
	 * @return true, if successful
	 */
	protected boolean setExtLink(String fieldName, TableResponseCellTo cellData) {
		String oldValue = null;
		String newValue = null;
		boolean changed = false;
		if (cellData.getExternalLinkTo() != null) {
			if (cellData.getExternalLinkTo().getLinkImgLocation() != null) {
				oldValue = getAttributeAsString(fieldName + EXT_LINK_IMG);
				newValue = cellData.getExternalLinkTo().getLinkImgLocation();
				setAttribute(fieldName + EXT_LINK_IMG, newValue);
				changed = oldValue != null && !oldValue.equalsIgnoreCase(newValue);
			}
			if (cellData.getExternalLinkTo().getLinkText() != null) {
				oldValue = getAttributeAsString(fieldName + EXT_LINK_TEXT);
				newValue = cellData.getExternalLinkTo().getLinkText();
				setAttribute(fieldName + EXT_LINK_TEXT, newValue);
				changed = changed || (oldValue != null && !oldValue.equalsIgnoreCase(newValue));
			}
			if (cellData.getExternalLinkTo().getActionAnalytics() != null) {
				oldValue = getAttributeAsString(fieldName + EXT_LINK_ACTION);
				newValue = cellData.getExternalLinkTo().getActionAnalytics();
				setAttribute(fieldName + EXT_LINK_ACTION, newValue);
				changed = oldValue != null && (oldValue != null && !oldValue.equalsIgnoreCase(newValue));
			}
			if (cellData.getExternalLinkTo().getCategoryAnalytics() != null) {
				oldValue = getAttributeAsString(fieldName + EXT_LINK_CATEGORY);
				newValue = cellData.getExternalLinkTo().getCategoryAnalytics();
				setAttribute(fieldName + EXT_LINK_CATEGORY, newValue);
				changed = oldValue != null && (oldValue != null && !oldValue.equalsIgnoreCase(newValue));
			}
			if (cellData.getExternalLinkTo().getUrl() != null) {
				oldValue = getAttributeAsString(fieldName + EXT_LINK_URL);
				newValue = cellData.getExternalLinkTo().getUrl();
				setAttribute(fieldName + EXT_LINK_URL, newValue);
				changed = changed || (oldValue != null && !oldValue.equalsIgnoreCase(newValue));
			} else {
				Log.error("Expected value 'linkUrl' but was null");
			}
		} else {
			Log.error("Expected value 'extLink' but was null");
		}
		return changed;
	}

	/**
	 * Sets the ext link update only on text changed.
	 * 
	 * @param fieldName
	 *            the field name
	 * @param cellData
	 *            the cell data
	 * @return true, if successful
	 */
	protected boolean setExtLinkUpdateOnlyOnTextChanged(String fieldName, TableResponseCellTo cellData) {
		String oldValue = null;
		String newValue = null;
		boolean changed = false;
		if (cellData.getExternalLinkTo() != null) {
			if (cellData.getExternalLinkTo().getLinkText() != null) {
				oldValue = getAttributeAsString(fieldName + EXT_LINK_TEXT);
				newValue = cellData.getExternalLinkTo().getLinkText();
				setAttribute(fieldName + EXT_LINK_TEXT, newValue);
				changed = oldValue != null && !oldValue.equalsIgnoreCase(newValue);
			}
			// Only if the text value has changed will we change image and url
			if (changed) {
				if (cellData.getExternalLinkTo().getLinkImgLocation() != null) {
					oldValue = getAttributeAsString(fieldName + EXT_LINK_IMG);
					newValue = cellData.getExternalLinkTo().getLinkImgLocation();
					setAttribute(fieldName + EXT_LINK_IMG, newValue);
					changed = changed || (oldValue != null && !oldValue.equalsIgnoreCase(newValue));
				}
				if (cellData.getExternalLinkTo().getActionAnalytics() != null) {
					oldValue = getAttributeAsString(fieldName + EXT_LINK_ACTION);
					newValue = cellData.getExternalLinkTo().getActionAnalytics();
					setAttribute(fieldName + EXT_LINK_ACTION, newValue);
					changed = changed || (oldValue != null && !oldValue.equalsIgnoreCase(newValue));
				}
				if (cellData.getExternalLinkTo().getCategoryAnalytics() != null) {
					oldValue = getAttributeAsString(fieldName + EXT_LINK_CATEGORY);
					newValue = cellData.getExternalLinkTo().getCategoryAnalytics();
					setAttribute(fieldName + EXT_LINK_CATEGORY, newValue);
					changed = changed || (oldValue != null && !oldValue.equalsIgnoreCase(newValue));
				}
				if (cellData.getExternalLinkTo().getUrl() != null) {
					oldValue = getAttributeAsString(fieldName + EXT_LINK_URL);
					newValue = cellData.getExternalLinkTo().getUrl();
					setAttribute(fieldName + EXT_LINK_URL, newValue);
					changed = changed || (oldValue != null && !oldValue.equalsIgnoreCase(newValue));
				} else {
					Log.error("Expected value 'linkUrl' but was null");
				}
			}
		} else {
			Log.error("Expected value 'extLink' but was null");
		}
		return changed;
	}

	/**
	 * Sets the int link.
	 * 
	 * @param fieldName
	 *            the field name
	 * @param cellData
	 *            the cell data
	 * @return true, if successful
	 */
	protected boolean setIntLink(String fieldName, TableResponseCellTo cellData) {
		String oldValue = null;
		String newValue = null;
		boolean changed = false;
		if (cellData.getLinkTo() != null && cellData.getLinkTo().getName() != null) {
			oldValue = getAttributeAsString(fieldName + INT_LINK_TEXT);
			newValue = cellData.getLinkTo().getName();
			setAttribute(fieldName, newValue);
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
		return changed || (oldValue != null && !oldValue.equalsIgnoreCase(newValue));
	}

	/**
	 * Sets the literal.
	 * 
	 * @param fieldName
	 *            the field name
	 * @param cellData
	 *            the cell data
	 * @return true, if successful
	 */
	protected boolean setLiteral(String fieldName, TableResponseCellTo cellData) {
		String oldValue = null;
		String newValue = null;
		if (cellData.getValueTo() != null && cellData.getValueTo().getLiteral() != null) {
			oldValue = getAttributeAsString(fieldName + LITERAL);
			newValue = cellData.getValueTo().getLiteral();
			// Solo utilicamos el campo 'literal' para mandar 'local', 'empate'
			// o 'visitante'
			if (newValue.equalsIgnoreCase(CommonLiterals.getLocal())) {
				newValue = messages.local();
			} else if (newValue.equalsIgnoreCase(CommonLiterals.getEmpate())) {
				newValue = messages.empate();
			} else if (newValue.equalsIgnoreCase(CommonLiterals.getVisitante())) {
				newValue = messages.visitante();
			} else {
				Log.error("The literal value could not be resolved");
			}
			setAttribute(fieldName, newValue);
			setAttribute(fieldName + LITERAL, newValue);
		} else {
			Log.error("Expected value 'literal' but was null");
		}
		return oldValue != null && !oldValue.equalsIgnoreCase(newValue);
	}

	/**
	 * Sets the record id.
	 * 
	 * @param objectToId
	 *            the new record id
	 */
	protected void setRecordId(ObjectToId objectToId) {
		if (objectToId != null && objectToId.getId() != null) {
			setAttribute(RECORD_ID, objectToId);
		} else {
			Log.error("Expected value 'recordId' but was null");
		}
	}

	/**
	 * Sets the record id.
	 * 
	 * @param id
	 *            the new record id
	 */
	public void setRecordId(String id) {
		setAttribute(RECORD_ID, id);
	}

	/**
	 * Sets the value str.
	 * 
	 * @param fieldName
	 *            the field name
	 * @param cellData
	 *            the cell data
	 * @return true, if successful
	 */
	protected boolean setValueStr(String fieldName, TableResponseCellTo cellData) {
		String oldValue = null;
		String newValue = null;
		if (cellData.getValueTo() != null && cellData.getValueTo().getValueStr() != null) {
			String cellValueStr = cellData.getValueTo().getValueStr();
			oldValue = getAttributeAsString(fieldName + VALUE);
			newValue = cellValueStr;
			setAttribute(fieldName, newValue);
			setAttribute(fieldName + VALUE, newValue);
		} else {
			Log.error("Expected value 'valueStr' but was null");
		}
		return oldValue != null && !oldValue.equalsIgnoreCase(newValue);
	}

	/**
	 * Sets the value str with space.
	 * 
	 * @param fieldName
	 *            the field name
	 * @param cellData
	 *            the cell data
	 * @return true, if successful
	 */
	protected boolean setValueStrWithSpace(String fieldName, TableResponseCellTo cellData) {
		String oldValue = null;
		String newValue = null;
		if (cellData.getValueTo() != null && cellData.getValueTo().getValueStr() != null) {
			String cellValueStr = cellData.getValueTo().getValueStr();
			oldValue = getAttributeAsString(fieldName + VALUE);
			newValue = generateHtmlStringWithNewLinesAtSeperatorSymbol(cellValueStr, '|');
			setAttribute(fieldName, newValue);
			setAttribute(fieldName + VALUE, newValue);
		} else {
			Log.error("Expected value 'valueStr' but was null");
		}
		return oldValue != null && !oldValue.equalsIgnoreCase(newValue);
	}

	/**
	 * Update.
	 * 
	 * @param pRowData
	 *            the row data
	 * @return the list
	 */
	public List<Integer> update(TableResponseRowTo pRowData) {
		return new ArrayList<Integer>();
	}

}

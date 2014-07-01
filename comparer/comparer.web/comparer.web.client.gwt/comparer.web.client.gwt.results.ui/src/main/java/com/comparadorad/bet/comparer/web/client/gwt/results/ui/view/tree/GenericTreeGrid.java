/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.web.client.gwt.results.ui.view.tree;

import com.allen_sauer.gwt.log.client.Log;
import com.comparadorad.bet.comparer.web.client.gwt.common.ui.tables.ColName;
import com.comparadorad.bet.comparer.web.client.gwt.common.ui.util.InternalLinkContextMenu;
import com.comparadorad.bet.comparer.web.client.gwt.core.ipc.AppLinkUtil;
import com.comparadorad.bet.comparer.web.client.gwt.core.ipc.InternalLinkEventNames;
import com.comparadorad.bet.comparer.web.client.gwt.results.ui.Messages;
import com.google.gwt.core.client.GWT;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.types.Autofit;
import com.smartgwt.client.types.ListGridFieldType;
import com.smartgwt.client.types.Overflow;
import com.smartgwt.client.widgets.grid.HoverCustomizer;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.client.widgets.grid.events.CellClickEvent;
import com.smartgwt.client.widgets.grid.events.CellClickHandler;
import com.smartgwt.client.widgets.grid.events.CellContextClickEvent;
import com.smartgwt.client.widgets.grid.events.CellContextClickHandler;
import com.smartgwt.client.widgets.tree.TreeGrid;
import com.smartgwt.client.widgets.tree.TreeGridField;

/**
 * The Class GenericTreeGrid.
 */
public class GenericTreeGrid extends TreeGrid {

	/** The Constant CELL_HEIGHT. */
	private static final int CELL_HEIGHT = 22;

	/** The Constant COL_INDEX_LINK. */
	private final static int COL_INDEX_LINK = 1;

	/** The Constant MAX_RECORDS. */
	protected final static int MAX_RECORDS = 10000;

	/** The messages. */
	protected static Messages messages = GWT.create(Messages.class);

	/** The Constant MIN_HEIGHT. */
	private static final int MIN_HEIGHT = 1;

	/** The Constant NODO_BET_TYPE. */
	protected final static String NODO_BET_TYPE = "NodoBetType";

	/** The Constant NODO_COMP. */
	protected final static String NODO_COMP = "NodoComp";

	/** The Constant NODO_ERROR. */
	protected final static String NODO_ERROR = "NodoError";

	/** The Constant NODO_EVENT. */
	protected final static String NODO_EVENT = "NodoEvent";

	/** The Constant OPEN_CLOSE_NODE_ICON_SIZE. */
	protected final static int OPEN_CLOSE_NODE_ICON_SIZE = 15;

	/** The Constant RES_ARBOL_BANDERA. */
	protected final static String RES_ARBOL_BANDERA = "resArbolBandera";

	/** The Constant RES_ARBOL_INFO. */
	protected final static String RES_ARBOL_INFO = "resArbolInfo";

	/** The Constant RES_ARBOL_LINK. */
	protected final static String RES_ARBOL_LINK = "resArbolLink";

	/** The Constant RES_ARBOL_NORMAL. */
	protected final static String RES_ARBOL_NORMAL = "resArbolNormal";

	/** The Constant RES_ARBOL_SPECIAL. */
	protected final static String RES_ARBOL_SPECIAL = "resArbolSpecial";

	/** The Constant WIDTH. */
	protected final static int WIDTH = 680;

	/** The Constant WIDTH_COL0. */
	protected final static int WIDTH_COL0 = 40;

	/** The Constant WIDTH_COL1. */
	protected final static int WIDTH_COL1 = 310;

	/** The Constant WIDTH_COL2. */
	protected final static int WIDTH_COL2 = 165;

	/** The Constant WIDTH_COL3. */
	protected final static int WIDTH_COL3 = 30;

	/** The Constant WIDTH_COL4. */
	protected final static int WIDTH_COL4 = 135;

	/** The col0 flag. */
	protected TreeGridField col0Flag;

	/** The col1 tree. */
	protected TreeGridField col1Tree;

	/** The col2 comp. */
	protected TreeGridField col2Comp;

	/** The col3 info. */
	protected TreeGridField col3Info;

	/** The col4 events. */
	protected TreeGridField col4Events;

	/** The link util. */
	private AppLinkUtil linkUtil = new AppLinkUtil();

	/** The menu. */
	InternalLinkContextMenu menu = new InternalLinkContextMenu();

	/**
	 * Instantiates a new generic tree grid.
	 */
	public GenericTreeGrid() {

		setWidth(WIDTH);
		setHeight(MIN_HEIGHT);
		setCellHeight(CELL_HEIGHT);
		setShowHeader(false);
		setShowEmptyMessage(false);

		// Sacado del doc: "When embedding components will result in variable
		// height records, you should switch on virtualScrolling. This flag
		// should be manually enabled when calling
		// ListGrid.addEmbeddedComponent(...) if embedded components can cause
		// record sizes to expand beyond specified cellHeight".
		// OJO!!! en nuestro caso, como tenemos el
		// setAutoFitData(Autofit.VERTICAL) nunca vamos a utilizar el scroll.
		// Poniendo setVirtualScrolling(true) resulta en Bug 2929 ya que el
		// manejo interno del cellHeight cambia.
		// setFixedRecordHeights(false) también resulta en Bug 2929.

		/*
		 * Al poner setAutoFitData(Autofit.VERTICAL), el grid se limita a
		 * mostrar solo 50 records (el valor por defecto). Aumentamos el número
		 * con setAutoFitMaxRecords(MAX_RECORDS) donde MAX_RECORDS es un número
		 * muy alto
		 */
		setAutoFitData(Autofit.VERTICAL);
		setAutoFitMaxRecords(MAX_RECORDS);
		setOverflow(Overflow.HIDDEN);
		setBodyOverflow(Overflow.HIDDEN);

		setShowConnectors(false);
		setNodeIcon(null);
		setFolderIcon(null);
		setShowOpenIcons(false);
		setShowDropIcons(false);
		setClosedIconSuffix("");
		setOpenerImage("comparer/icons/node.png");
		setOpenerIconSize(new Integer(OPEN_CLOSE_NODE_ICON_SIZE));

		setAlternateRecordStyles(false);
		setShowRollOver(false);
		setShowSelectedStyle(false);
		setIconSize(OPEN_CLOSE_NODE_ICON_SIZE);

		col0Flag = new TreeGridField(ColName.getCol(0));
		col1Tree = new TreeGridField(ColName.getCol(1));
		col2Comp = new TreeGridField(ColName.getCol(2));
		col3Info = new TreeGridField(ColName.getCol(3));
		col4Events = new TreeGridField(ColName.getCol(4));

		col0Flag.setWidth(WIDTH_COL0);
		col1Tree.setWidth(WIDTH_COL1);
		col2Comp.setWidth(WIDTH_COL2);
		col3Info.setWidth(WIDTH_COL3);
		col4Events.setWidth(WIDTH_COL4);

		col0Flag.setType(ListGridFieldType.IMAGE);
		col0Flag.setImageHeight(16);
		col0Flag.setImageWidth(23);
		col1Tree.setTreeField(true);
		col3Info.setType(ListGridFieldType.IMAGE);
		col3Info.setImageHeight(16);
		col3Info.setImageWidth(16);

		col0Flag.setAlign(Alignment.CENTER);
		col1Tree.setAlign(Alignment.CENTER);
		col2Comp.setAlign(Alignment.RIGHT);
		col3Info.setAlign(Alignment.CENTER);
		col4Events.setAlign(Alignment.RIGHT);

		col3Info.setShowHover(true);
		col3Info.setHoverCustomizer(new HoverCustomizer() {
			@Override
			public String hoverHTML(Object pValue, ListGridRecord pRecord,
					int pRowNum, int pColNum) {
				String tooltip = null;
				if (!pValue.toString().equalsIgnoreCase("&nbsp;")) {
					// Sólo mostramos el tooltip si esta el icono de info en la
					// celda (cuando pValue no devuelve &nbsp;)
					tooltip = messages.paraAccederATodosLosEventosYApuestas();
				}
				return tooltip;
			}
		});

		addCellClickHandler(new CellClickHandler() {

			@Override
			public void onCellClick(CellClickEvent pEvent) {
				GenericTreeNode node = (GenericTreeNode) pEvent.getRecord();
				if (pEvent.getColNum() == COL_INDEX_LINK
						&& !(pEvent.getRecord() instanceof TreeNodeError)) {
					onInternalLinkClick(node, pEvent);
				}
			};
		});

		addCellContextClickHandler(new CellContextClickHandler() {

			@Override
			public void onCellContextClick(CellContextClickEvent pEvent) {
				GenericTreeNode node = (GenericTreeNode) pEvent.getRecord();
				if (pEvent.getColNum() == COL_INDEX_LINK
						&& !(pEvent.getRecord() instanceof TreeNodeError)
						&& node.getIntLinkIpcName(getFieldName(pEvent
								.getColNum())) != null) {
					showContextMenu(node, pEvent);
				} else {
					setContextMenu(null);
				}
			}

		});

		setFields(col0Flag, col1Tree, col2Comp, col3Info, col4Events);

	}

	/**
	 * On internal link click.
	 * 
	 * @param node
	 *            the node
	 * @param pEvent
	 *            the event
	 */
	protected void onInternalLinkClick(final GenericTreeNode node,
			CellClickEvent pEvent) {
		Log.debug("Tipo de evento: onInternalLinkClick");

		int colNum = pEvent.getColNum();
		String id = node.getIntLinkId(getFieldName(colNum));
		String idAux = "";
		if (node.getIntLinkIdAux(getFieldName(colNum)) != null) {
			idAux = node.getIntLinkIdAux(getFieldName(colNum));
		}
		String eventNameStr = node.getIntLinkIpcName(getFieldName(colNum));
		InternalLinkEventNames eventName = InternalLinkEventNames
				.getInternalLinkEventName(eventNameStr);

		if (pEvent.isCtrlKeyDown() && pEvent.isLeftButtonDown()) {
			linkUtil.openInternalLinkInNewWindow(id, idAux, null, eventName);
		} else {
			linkUtil.openInternalLinkInCurrentWindow(id, idAux, eventName);
		}

	}

	/**
	 * Show context menu.
	 * 
	 * @param node
	 *            the node
	 * @param pEvent
	 *            the event
	 */
	protected void showContextMenu(final GenericTreeNode node,
			CellContextClickEvent pEvent) {
		Log.debug("Tipo de evento: showContextMenu");
		int colNum = pEvent.getColNum();
		String id = node.getIntLinkId(getFieldName(colNum));
		String idAux = "";
		if (node.getIntLinkIdAux(getFieldName(colNum)) != null) {
			idAux = node.getIntLinkIdAux(getFieldName(colNum));
		}

		String eventNameStr = node.getIntLinkIpcName(getFieldName(colNum));
		InternalLinkEventNames eventName = InternalLinkEventNames
				.getInternalLinkEventName(eventNameStr);

		menu.setId(id);
		menu.setIdAux(idAux);
		menu.setEventName(eventName);

		setContextMenu(menu);
	}

}

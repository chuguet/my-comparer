package com.comparadorad.bet.comparer.web.server.mvc.match.comparator;

import java.util.Comparator;
import java.util.Locale;

import com.comparadorad.bet.comparer.web.client.gwt.common.bean.table.TableResponseTo;
import com.comparadorad.bet.comparer.web.server.mvc.core.beans.DateUtilJava;

public class TableResponseToSportCountryComparator implements
		Comparator<TableResponseTo> {

	private Locale locale;

	public TableResponseToSportCountryComparator(Locale pLocale) {
		this.locale = pLocale;
	}

	@Override
	public int compare(TableResponseTo o1, TableResponseTo o2) {
		return DateUtilJava
				.stringToDateWithWordsMonth(
						o1.getRows().get(0).getCellList().get(0).getValueTo()
								.getDate(), locale).compareTo(
						DateUtilJava.stringToDateWithWordsMonth(o2.getRows()
								.get(0).getCellList().get(0).getValueTo()
								.getDate(), locale));
	}

}

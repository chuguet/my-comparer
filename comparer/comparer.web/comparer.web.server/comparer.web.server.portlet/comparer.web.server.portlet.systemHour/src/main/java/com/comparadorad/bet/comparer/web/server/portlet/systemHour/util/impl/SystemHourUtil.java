package com.comparadorad.bet.comparer.web.server.portlet.systemHour.util.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.TimeZone;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.comparadorad.bet.comparer.web.server.portlet.systemHour.util.ISystemHourUtil;

public class SystemHourUtil implements ISystemHourUtil {

	/** The Constant LOG. */
	private static final Log LOG = LogFactory.getLog(SystemHourUtil.class);

//	private static final String TIMEZONE_ID_PREFIXES = "^(Africa|America|Asia|Atlantic|Australia|Europe|Indian|Pacific|GMT|UTC)/.*";

	private List<TimeZone> timeZones = null;

	@Override
	public List<TimeZone> getTimeZoneValues() {
		LOG.debug("Obtenemos la lista de zonas horarias para el combo");
		//if (timeZones == null) {
			initTimeZones();
		
		//}
		LOG.debug("Fin de la obtencion de la lista de zonas horarias para el combo");
		return timeZones;
	}

	private void initTimeZones() {
		timeZones = new ArrayList<TimeZone>();
		final String[] timeZoneIds = TimeZone.getAvailableIDs();
		for (final String id : timeZoneIds) {
			timeZones.add(TimeZone.getTimeZone(id));
//			if (id.matches(TIMEZONE_ID_PREFIXES)) {
//				timeZones.add(TimeZone.getTimeZone(id));
//			}
		}
		Collections.sort(timeZones, new Comparator<TimeZone>() {
			public int compare(final TimeZone a, final TimeZone b) {
				return a.getID().compareTo(b.getID());
			}
		});
	}

}

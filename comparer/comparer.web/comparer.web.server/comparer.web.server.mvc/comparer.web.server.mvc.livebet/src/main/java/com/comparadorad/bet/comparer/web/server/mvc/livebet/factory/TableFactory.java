package com.comparadorad.bet.comparer.web.server.mvc.livebet.factory;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.comparadorad.bet.comparer.model.config.bean.CfgBetType;
import com.comparadorad.bet.comparer.web.server.mvc.livebet.factory.table.IMakeTable;

@Service
public class TableFactory extends AbstractTableFactory {

	@Inject
	private List<IMakeTable> tables;

	@Override
	public IMakeTable makeTable(CfgBetType betType) {
		IMakeTable result = null;
		for (IMakeTable makeTable : tables) {
			if (betType.getNameId().equals(makeTable.getBetType().nameId())) {
				result = makeTable;
				break;
			}
		}
		return result;
	}

}

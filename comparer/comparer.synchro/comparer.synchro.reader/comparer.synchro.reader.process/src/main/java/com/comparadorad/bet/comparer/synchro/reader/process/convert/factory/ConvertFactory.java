package com.comparadorad.bet.comparer.synchro.reader.process.convert.factory;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Component;

import com.comparadorad.bet.comparer.model.config.bean.CfgBookmaker;
import com.comparadorad.bet.comparer.synchro.reader.process.convert.factory.bean.ConvertFactoryBean;
import com.comparadorad.bet.comparer.synchro.reader.process.convert.impl.IXmlBetTypeToCfgBetType;
import com.comparadorad.bet.comparer.synchro.reader.process.convert.impl.XmlBetTypeToCfgBetTypeEnum;

@Component
public class ConvertFactory extends AbstractConvertFactory {

	@Inject
	private List<IXmlBetTypeToCfgBetType> betTypes;

	@Override
	public Object getBetTypeInstance(CfgBookmaker pBookmaker,
			ConvertFactoryBean pConvertFactoryBean) {
		IXmlBetTypeToCfgBetType result = null;
		for (IXmlBetTypeToCfgBetType betType : betTypes) {
			if (betType.getXmlBetTypeToCfgBetTypeEnum() != null
					&& pBookmaker.getObjectId().equals(
							betType.getXmlBetTypeToCfgBetTypeEnum()
									.getBookmakerId())) {
				result = betType;
				break;
			} else if (betType.getXmlBetTypeToCfgBetTypeEnum() == XmlBetTypeToCfgBetTypeEnum.DEFAULT) {
				result = betType;
			}
		}
		return result;
	}
}

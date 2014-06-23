package com.comparadorad.bet.comparer.communication.email.mapper.converter;

import org.dozer.CustomConverter;

import com.comparadorad.bet.comparer.model.bet.bean.Rt1X2Attribute;
import com.comparadorad.bet.comparer.model.bet.bean.Rt1X2HandicapAttribute;
import com.comparadorad.bet.comparer.model.bet.bean.RtAsianHandicapAttribute;
import com.comparadorad.bet.comparer.model.bet.bean.RtGanadorPartidoAttribute;
import com.comparadorad.bet.comparer.model.bet.bean.RtMasMenosAttribute;

public class AttributeToResult implements CustomConverter  {

	@Override
	public Object convert(Object existingDestinationFieldValue,
			Object sourceFieldValue, Class<?> destinationClass,
			Class<?> sourceClass) {
		StringBuffer result = new StringBuffer();
		
		if(  sourceFieldValue instanceof Rt1X2Attribute   ){
			Rt1X2Attribute source = (Rt1X2Attribute) sourceFieldValue;
			result.append(source.getResult().getNameId());			
		}else if( sourceFieldValue instanceof Rt1X2HandicapAttribute ){
			Rt1X2HandicapAttribute source = (Rt1X2HandicapAttribute) sourceFieldValue;
			if( source.getResult() != null ){
				result.append(source.getResult().getNameId());	
			}					
		}else if( sourceFieldValue instanceof RtAsianHandicapAttribute ){
			RtAsianHandicapAttribute source = (RtAsianHandicapAttribute) sourceFieldValue;
			if( source.getAsianResult() != null ){
				result.append(source.getAsianResult().nameId());
			}					
		}else if( sourceFieldValue instanceof RtGanadorPartidoAttribute ){
			RtGanadorPartidoAttribute source = (RtGanadorPartidoAttribute) sourceFieldValue;
			if( source.getResult() != null ){
				result.append(source.getResult().getNameId());
			}			
		}else if( sourceFieldValue instanceof RtMasMenosAttribute ){
			RtMasMenosAttribute source = (RtMasMenosAttribute) sourceFieldValue;
			if( source.getMasMenos() != null ){
				result.append(source.getMasMenos().nameId());
			}						
		}
		return result.toString();
	}

}

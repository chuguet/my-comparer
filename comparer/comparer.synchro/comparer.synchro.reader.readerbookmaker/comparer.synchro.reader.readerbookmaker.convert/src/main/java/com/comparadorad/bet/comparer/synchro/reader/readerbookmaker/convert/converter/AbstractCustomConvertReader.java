package com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.convert.converter;

import org.dozer.Mapper;
import org.dozer.MappingException;

public abstract class AbstractCustomConvertReader implements CustomConvertReader{
	
	/** The mapper. */
	private Mapper mapper;
	
	@Override
	public Mapper getMapper() {
		return mapper;
	}
	
	@Override
	public void setMapper(Mapper pMapper) {
		mapper = pMapper;
	}
	
	public <T> T map(Object pArg0, Class<T> pArg1, String pArg2)
			throws MappingException {
		return mapper.map(pArg0, pArg1, pArg2);
	}
	
	

}

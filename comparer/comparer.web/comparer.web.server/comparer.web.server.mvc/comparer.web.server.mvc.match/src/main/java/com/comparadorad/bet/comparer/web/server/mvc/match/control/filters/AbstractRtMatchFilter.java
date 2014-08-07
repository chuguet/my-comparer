package com.comparadorad.bet.comparer.web.server.mvc.match.control.filters;

import java.util.List;

/**
 * Abstract Class to inherit for all Filters.
 * 
 * @author farce
 *
 */
abstract class AbstractRtMatchFilter<T> implements IRtMatchControllerFilter<T> {
	// Siguiente filtro.
	protected IRtMatchControllerFilter<T> nextFilter;
	
	/**
	 * Default Constructor
	 */
	public AbstractRtMatchFilter() {
		
	}
	
	// Método de la Interfaz que debe implementar.
	@Override
	/**
	 * {@inheritDoc}
	 */
	public abstract List<T> applyFilter(List<T> resultQuery);
	
	@Override
	/**
	 * {@inheritDoc}
	 */
	public IRtMatchControllerFilter<T> getNextFilter() {
		return nextFilter;
	}
	
	@Override
	/**
	 * {@inheritDoc}
	 */
	public void setNextFilet(IRtMatchControllerFilter<T> rtMatchFilterController_) {
		nextFilter = rtMatchFilterController_;
	}

}

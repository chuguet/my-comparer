/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.model.core.bean.sort;

import com.comparadorad.bet.comparer.model.core.bean.IObjectOrder;

/**
 * The Class ObjectOrderSort.
 */
public class ObjectOrderSort {

	/**
	 * Compare to.
	 *
	 * @param internalObject the internal object
	 * @param externalObject the external object
	 * @return the int
	 */
	public static int compareTo(@SuppressWarnings("rawtypes") IObjectOrder internalObject, @SuppressWarnings("rawtypes") IObjectOrder externalObject) {
		int result = 0;
		if( internalObject != null &&  externalObject != null ){
			if( internalObject.getOrder() != null && externalObject.getOrder() != null ){
				if( internalObject.getOrder().getPriority() != null && externalObject.getOrder().getPriority() != null ){
					if( internalObject.getOrder().getPriority() > externalObject.getOrder().getPriority() ){
						result = 1;
					}else{
						result = -1;
					}
				}
			}
		}
		return result;
	}

}

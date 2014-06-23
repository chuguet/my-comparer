package com.comparadorad.bet.comparer.communication.email.mapper.converter;

import java.util.Locale;

import org.dozer.CustomConverter;

import com.comparadorad.bet.comparer.model.core.bean.I18n;

public class I18nToString implements CustomConverter {

	@Override
	public Object convert(Object existingDestinationFieldValue,
			Object sourceFieldValue, Class<?> destinationClass,
			Class<?> sourceClass) {
		String result = "";
		Locale locale = new Locale("ES");
		if (sourceFieldValue != null && sourceFieldValue instanceof I18n) {
			I18n i18nField = (I18n) sourceFieldValue;
			if (i18nField.getI18nFields() != null) {
				if (i18nField.getI18nField(locale) != null) {
					result = i18nField.getI18nField(locale).getString();
				} else if (i18nField.getNameId() != null) {
					result = i18nField.getNameId();
				}

			}

		}
		return result;
	}

}

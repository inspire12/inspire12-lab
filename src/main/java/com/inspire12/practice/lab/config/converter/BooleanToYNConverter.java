package com.inspire12.practice.lab.config.converter;

import javax.persistence.AttributeConverter;
import javax.persistence.Convert;
import javax.persistence.Converter;

@Converter// (autoApply = true)
public class BooleanToYNConverter implements AttributeConverter<Boolean, String> {
    public String convertToDatabaseColumn(Boolean attribute) {
        return (attribute != null && attribute) ? "Y" : "N";
    }

    public Boolean convertToEntityAttribute(String s) {
        return "Y".equals(s);
    }
}

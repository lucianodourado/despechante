package br.mp.mpm.despachante.util;

import java.math.BigDecimal;

import com.fasterxml.jackson.databind.util.StdConverter;

public class StringToBigDecimalConverter extends StdConverter<String, BigDecimal> {

	@Override
	public BigDecimal convert(String value) {
        String floatString = value;
        if (floatString.contains(",")) {
            floatString = floatString.replace(",", ".");
        }
        return BigDecimal.valueOf(Float.valueOf(floatString));	
	}

}

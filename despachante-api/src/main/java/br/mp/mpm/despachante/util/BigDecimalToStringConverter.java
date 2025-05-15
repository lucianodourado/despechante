package br.mp.mpm.despachante.util;

import java.math.BigDecimal;

import com.fasterxml.jackson.databind.util.StdConverter;

public class BigDecimalToStringConverter extends StdConverter<BigDecimal, String> {

	@Override
	public String convert(BigDecimal value) {
		String floatString  = value.toString();
        if (floatString.contains(".")) {
            floatString = floatString.replace(".", ",");
        }
        return floatString;		
	}

}

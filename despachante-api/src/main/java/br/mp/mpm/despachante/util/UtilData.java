package br.mp.mpm.despachante.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class UtilData {

	public static Date convertStringParaDate(String data, String formatoOrigem) {
		if (data == null || data.equals("")) {
			return null;
		}
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(formatoOrigem);
		LocalDate date = LocalDate.parse(data, formatter);
		return java.sql.Date.valueOf(date);
	}

	public static Date convertStringParaDateTime(String data, String formatoOrigem) {
		if (data == null || data.equals("")) {
			return null;
		}
		try {
			return new SimpleDateFormat(formatoOrigem).parse(data);
		} catch (ParseException e) {
			throw new IllegalArgumentException(String.format("Formato da data inválido (%s)", data));
		}		
	}
	
	public static String convertDateParaString(Date data, String formato) {
		if (data == null) {
			return "";
		}
		SimpleDateFormat sd = new SimpleDateFormat(formato);
		return sd.format(data);
	}

	public static LocalDateTime convertDateParaLocalDateTime(Date data) {
		return data.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
	}

	public static boolean dentroPeriodo(Date dataInicio, Date dataFim) {
		LocalDateTime agora = LocalDateTime.now();
		LocalDateTime inicio = convertDateParaLocalDateTime(dataInicio);
		LocalDateTime fim = convertDateParaLocalDateTime(dataFim);
		return inicio.isBefore(agora) && agora.isBefore(fim);
	}

}

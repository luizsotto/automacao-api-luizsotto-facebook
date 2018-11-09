package br.com.luizcruz.commons.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DataUtils {

	public static Calendar converterStringToCalendar(String pattern, String value) throws ParseException {
		Calendar calendario = Calendar.getInstance();
		calendario.setTime(new SimpleDateFormat(pattern).parse(value));
		calendario.set(Calendar.HOUR, 0);
	    calendario.set(Calendar.MINUTE,0);
	    calendario.set(Calendar.SECOND, 0);
	    calendario.set(Calendar.MILLISECOND,0);
		return calendario;
		
	}
	
	public static String converterCalendarToString(String pattern, Calendar value) throws ParseException {
		return new SimpleDateFormat(pattern).format(value.getTime());
	}
	

	public static boolean validarDateCalendar(Calendar vlrBase, Calendar vlrRecebido) {
		//Se o valor recebido é maior ou igual a valor base
		if(vlrRecebido.compareTo(vlrBase) >= 0) {
			return true;
		}else if(vlrRecebido.compareTo(vlrBase) <= 0) {
			return true;
		}else if(vlrRecebido.compareTo(vlrBase) == 0) {
			return true;
		}else {
			return false;
		}
	}
	
}

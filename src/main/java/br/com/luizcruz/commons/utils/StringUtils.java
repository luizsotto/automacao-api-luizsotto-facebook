package br.com.luizcruz.commons.utils;

import java.text.Normalizer;

public class StringUtils {
	
	/**
	 * Verifica se o campo � null ou vazio
	 * @param param
	 * @return
	 */
	public static boolean isEmptyOrNull(String param) {
		return param != null && param.isEmpty();
	}
	
	public static String toCamelCase(final String init) {
	    if (init==null)
	        return null;

	    final StringBuilder ret = new StringBuilder(init.length());

	    for (final String word : init.split(" ")) {
	        if (!word.isEmpty()) {
	            ret.append(word.substring(0, 1).toUpperCase());
	            ret.append(word.substring(1).toLowerCase());
	        }
	        if (!(ret.length()==init.length()))
	            ret.append(" ");
	    }

	    return ret.toString();
	}
	
	/**
	 * Converte o valor de string para long
	 * @param value
	 * @return
	 */
	public static long tratarParametroLong(String value) {
		if (!value.isEmpty()) return Long.parseLong(value);
		return 0L;
	}
	
	
	/**Método responsável por remover os caracteres especiais
	 * @param str
	 * @return
	 */
	public static String removerCaracteresEspeciais(final String str) {
		String strSemAcentos = Normalizer.normalize(str, Normalizer.Form.NFD);
		strSemAcentos = strSemAcentos.replaceAll("[^\\p{ASCII}]", "");
		return strSemAcentos;
	}
}

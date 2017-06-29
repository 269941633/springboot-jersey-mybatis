package com.salt.api.reportmanage.util;

public class StringUtil {

	public static boolean isBlank(String s){
		return s == null || s.trim().length() == 0;
	}
	
	public static boolean isNotBlank(String s){
		return !isBlank(s);
	}
	
	public static boolean isNotBlank2(Object o){
		return o != null && isNotBlank((String)o);
	}
	
	
	public static boolean isAllNotBlank(String...s){
		for(String _s : s){
			if(isBlank(_s)){
				return false;
			}
		}
		return true;
	}
	
	public static String escapeHtml(String s){
		return s.replaceAll("&", "&amp;")
				.replaceAll("<", "&lt;")
				.replaceAll(">", "&gt")
				.replaceAll("\"", "&quot;")
				.replaceAll(" ", "&quot;")
				.replaceAll("'", "&#39;");
	}
	
	public static String unescapeHtml(String s){
		return s.replaceAll("&lt;", "<")
				.replaceAll("&gt", ">")
				.replaceAll("&quot;", "\"")
				.replaceAll("&quot;", " ")
				.replaceAll("&#39;", "'")
				.replaceAll("&amp;", "&");
	}
}

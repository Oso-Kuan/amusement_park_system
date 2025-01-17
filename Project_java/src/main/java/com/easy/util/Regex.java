package com.easy.util;

public class Regex {
	public static boolean matches(String regex, String... strs) {
		boolean result = true;
		for (int i = 0; i < strs.length; i++) {
			if (!strs[i].matches(regex)) {
				result = false;
				return result;
			}
		}
		return result;
	}

	private static final String REGEXITEM = "^\\w{6,16}$";

	public static boolean matchesItem(String... strs) {
		boolean result = true;
		for (int i = 0; i < strs.length; i++) {
			if (!strs[i].matches(REGEXITEM)) {
				result = false;
				return result;
			}
		}
		return result;
	}
}

package com.choupangxia.utils;

/**
 * @author sec
 * @version 1.0
 * @date 2020/3/16 4:23 PM
 **/
public class GlobalUtil {

	private static int count = 0;

	public static void add() {
		System.out.println("GlobalUtil.add()");
		count++;
	}

	public static int getCount() {
		return count;
	}
}

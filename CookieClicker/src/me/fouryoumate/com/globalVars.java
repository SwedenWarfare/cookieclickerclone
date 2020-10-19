package me.fouryoumate.com;

import javax.swing.JFrame;

public class GlobalVars {

	public static JFrame MAIN_FRAME = new JFrame();
	private static int COOKIES = 50;
	private static int COOKIE_MULTIPLIER = 1;
	private static int COOKIE_MULTIPLIER_PRICE = 25;
	public static int AUTO_CLICKER_PRICE = 50;
	public static int AUTO_CLICKER_LEVEL = 0;
	public static boolean AUTO_CLICKER_TOGGLE = false;
	
	public static float VOLUME = 1;
	public static void setCookies(int amount) {
		COOKIES = amount;
	}
	public static void addCookie(int amount) {
		COOKIES += amount;
	}
	public static void decCookie(int amount) {
		COOKIES -= amount;
	}
	public static int getCookies() {
		return COOKIES;
	}
	public static int getCookieMultiPrice() {
		return COOKIE_MULTIPLIER_PRICE;
	}
	public static int getCookieMulti() {
		return COOKIE_MULTIPLIER;
	}
	public static void setCookieMultiPrice(double amount) {
		COOKIE_MULTIPLIER_PRICE *= amount;
	}
	public static void setCookieMulti(int amount) {
		COOKIE_MULTIPLIER = amount;
	}
	public static void addCookieMulti(int amount) {
		COOKIE_MULTIPLIER += amount;
	}
	public static int cps() {
		return 1*COOKIE_MULTIPLIER;
	}
}

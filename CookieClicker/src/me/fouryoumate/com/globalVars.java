package me.fouryoumate.com;

import javax.swing.JFrame;

public class globalVars {

	public static JFrame MAIN_FRAME = new JFrame();
	public static int COOKIES = 0;
	public static int COOKIE_MULTIPLIER = 1;
	public static int COOKIE_MULTIPLIER_PRICE = 25;
	
	public static float VOLUME = 1;
	public static int cps() {
		return 1*COOKIE_MULTIPLIER;
	}
}

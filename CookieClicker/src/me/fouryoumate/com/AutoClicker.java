package me.fouryoumate.com;

public class AutoClicker implements Runnable{
	private boolean toggleAuto = false;
	public synchronized void toggleAuto() {
		this.toggleAuto = true;
	}
	private synchronized boolean keepRunning() {
		return this.toggleAuto == false;
	}
	@Override
	public void run() {
		while(keepRunning()) {
			try {
				GameGui.cookieButton.doClick();
				Thread.sleep(1000);
				
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

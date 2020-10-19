package me.fouryoumate.com;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class ShopGui implements ActionListener {
	JPanel shopPanel;
	JButton buyMulti = new JButton("Buy multi >> Price: "+GlobalVars.getCookieMultiPrice());
	JButton buyAutoClicker = new JButton("Buy Clicker >> Price: " +GlobalVars.AUTO_CLICKER_PRICE);
	JLabel notEnoughCookies = new JLabel("");
	JLabel shopText;
 	JButton okButton = new JButton("Ok");
	JButton backButton;
	JOptionPane infoPane = new JOptionPane("When you have bought the autoclicker\nPress the cookie button once\nThen hold the A button",JOptionPane.WARNING_MESSAGE);
	JDialog infoDialog = infoPane.createDialog("Info");
	public JFrame mainFrame = GlobalVars.MAIN_FRAME;
	public ShopGui() {
		shopPanel = new JPanel();
		backButton = new JButton("Back");
		
		shopText = new JLabel("Shop");
		
		buyMulti.addActionListener(this);
		backButton.addActionListener(this);
		buyAutoClicker.addActionListener(this);

		shopPanel.setBorder(BorderFactory.createEmptyBorder(30,30,10,30));
		shopPanel.setLayout(new GridLayout(5,0));
		shopPanel.setPreferredSize(new Dimension(250, 250));
		
		shopPanel.add(notEnoughCookies);
		
		shopPanel.add(buyMulti);
		if(GlobalVars.AUTO_CLICKER_LEVEL == 0)
		shopPanel.add(buyAutoClicker);
		
		
		shopPanel.add(backButton);

		mainFrame.setTitle("Shop");
		mainFrame.add(shopPanel, BorderLayout.CENTER);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.pack();
		mainFrame.setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent event) {
		if(event.getSource() == backButton) {
			mainFrame.remove(shopPanel);
			
			new GameGui(mainFrame);
		}else if(event.getSource() == buyMulti) {
			if(GlobalVars.getCookies() >= GlobalVars.getCookieMultiPrice()) {
				GlobalVars.decCookie(GlobalVars.getCookieMultiPrice());
				GlobalVars.setCookieMultiPrice(1.5);
				
			
				buyMulti.setText("Buy multi >> Price: "+GlobalVars.getCookieMultiPrice());
				GameGui.COOKIES_LABEL.setText( "Cookies: "+GlobalVars.getCookies());
				GlobalVars.addCookieMulti(1); 
			}
			else {
				notEnoughCookies.setText("You need: "+GlobalVars.getCookieMultiPrice()+" cookies");
				
			}
		}else if(event.getSource() == buyAutoClicker) {
			if(GlobalVars.getCookies() >= GlobalVars.AUTO_CLICKER_PRICE) {
				GlobalVars.decCookie(GlobalVars.AUTO_CLICKER_PRICE);
				GameGui.COOKIES_LABEL.setText( "Cookies: "+GlobalVars.getCookies());
				GlobalVars.AUTO_CLICKER_LEVEL = 1;

				infoDialog.setAlwaysOnTop(true);
				infoDialog.setVisible(true);
			}
			else {
				notEnoughCookies.setText("You need: "+GlobalVars.AUTO_CLICKER_PRICE+" cookies");
			
			}
		}
	}
}

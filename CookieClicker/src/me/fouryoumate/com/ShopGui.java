package me.fouryoumate.com;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ShopGui implements ActionListener {
	JPanel shopPanel;
	JButton buyMulti = new JButton("Buy multi >> Price: "+globalVars.COOKIE_MULTIPLIER_PRICE);
	
	JLabel notEnoughCookies = new JLabel("");
	JLabel shopText;
	
	JButton backButton;
	
	public JFrame mainFrame = globalVars.MAIN_FRAME;
	public ShopGui() {
		shopPanel = new JPanel();
		backButton = new JButton("Back");
		
		shopText = new JLabel("Shop");
		
		buyMulti.addActionListener(this);
		backButton.addActionListener(this);
		
		
		shopPanel.setBorder(BorderFactory.createEmptyBorder(30,30,10,30));
		shopPanel.setLayout(new GridLayout(4,0));
		shopPanel.setPreferredSize(new Dimension(250, 250));
		
		shopPanel.add(notEnoughCookies);
		shopPanel.add(buyMulti);
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
			if(globalVars.COOKIES >= globalVars.COOKIE_MULTIPLIER_PRICE) {
				globalVars.COOKIES -= globalVars.COOKIE_MULTIPLIER_PRICE;
				globalVars.COOKIE_MULTIPLIER_PRICE *= 1.5;
				
				buyMulti.setText("Buy multi >> Price: "+globalVars.COOKIE_MULTIPLIER_PRICE);
				GameGui.COOKIES_LABEL.setText( "Cookies: "+globalVars.COOKIES);
				globalVars.COOKIE_MULTIPLIER++; 
			}else {
				notEnoughCookies.setText("You need: "+globalVars.COOKIE_MULTIPLIER_PRICE+" cookies");
			
			}
		}
	}
}

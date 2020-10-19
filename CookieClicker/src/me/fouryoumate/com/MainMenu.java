package me.fouryoumate.com;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MainMenu implements ActionListener {

	JButton StartButton;
	JButton ExitButton;
	JLabel TitleText;
	JPanel MenuPanel;
	JFrame MenuFrame = globalVars.MAIN_FRAME;
	
	public MainMenu() {
		
		MenuPanel = new JPanel();
		ExitButton = new JButton("Exit Game");
		TitleText = new JLabel("Cookie Clicker");
		StartButton = new JButton("Start Game");
		StartButton.addActionListener(this);
		ExitButton.addActionListener(this);
		
		MenuPanel.setBorder(BorderFactory.createEmptyBorder(30,30,10,30));
		MenuPanel.setLayout(new GridLayout(4,0));
		
		MenuPanel.add(TitleText, BorderLayout.SOUTH);
		
		MenuPanel.add(StartButton);
		MenuPanel.add(ExitButton);
	 	MenuFrame.add(MenuPanel, BorderLayout.CENTER);
		MenuFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		MenuFrame.pack();
		MenuFrame.setVisible(true);
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == StartButton) {
			SoundManager.effectSounds("sounds/effects/Pling.wav");
			MenuFrame.remove(MenuPanel);
			new GameGui(MenuFrame);
		}else if(e.getSource() == ExitButton) {
			MenuFrame.dispose();
		}
	}
	
}

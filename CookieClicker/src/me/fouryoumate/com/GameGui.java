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
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class GameGui implements ActionListener, ChangeListener {
	
	JPanel gamePanel;
	JButton cookieButton;
	JButton shopButton;
	
	static JLabel COOKIES_LABEL = new JLabel();
	
	JSlider volume;
	JMenuBar menuBar;
	JMenu optionsMenu;
	JMenu saveMenu;
	JMenu soundMenu;
	
	static JLabel volumeLabel = new JLabel("Volume: ");
	
	public JFrame mainFrame = globalVars.MAIN_FRAME;
	
	int cookies = globalVars.COOKIES;
	int multi = globalVars.COOKIE_MULTIPLIER;
	
	public GameGui(JFrame frame) {
		menuBar = new JMenuBar();
		optionsMenu = new JMenu("Options");
		saveMenu = new JMenu("Save / Load");
		soundMenu = new JMenu("Sound");
		volume = new JSlider();
		volume.addChangeListener(this);
		
		soundMenu.add(volumeLabel);
		soundMenu.add(volume);
		menuBar.add(optionsMenu);
		menuBar.add(saveMenu);
		optionsMenu.add(soundMenu);
		
		cookieButton = new JButton("Cookies");
		shopButton = new JButton("Shop");

		COOKIES_LABEL.setText("Cookies: "+cookies);
		
		cookieButton.addActionListener(this);
		shopButton.addActionListener(this);
		
		frame.setJMenuBar(menuBar);
		gamePanel = new JPanel();
		volume.setMinimum(-50);
		
		volume.setMaximum(1);
		gamePanel.setBorder(BorderFactory.createEmptyBorder(30,30,10,30));
		gamePanel.setLayout(new GridLayout(3,0));
		gamePanel.setPreferredSize(new Dimension(260, 200));
	
		menuBar.add(COOKIES_LABEL,BorderLayout.EAST);
		gamePanel.add(cookieButton);
		gamePanel.add(shopButton);
		
		frame.setTitle("Game");
		frame.add(gamePanel, BorderLayout.CENTER);
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		
		if(event.getSource() == cookieButton) {
			cookies += globalVars.cps();
			SoundManager.effectSounds("sounds/effects/Pling.wav");
			COOKIES_LABEL.setText("Cookies: "+cookies);
		}
	}

	@Override
	public void stateChanged(ChangeEvent changeEvent) {
		if(changeEvent.getSource() == volume) {
			globalVars.VOLUME = (float) volume.getValue();
			
		}
	}
}

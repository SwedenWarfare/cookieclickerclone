package me.fouryoumate.com;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;

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

public class GameGui implements ActionListener, ChangeListener, KeyListener {
	
	JPanel gamePanel;
	public static JButton cookieButton;
	JButton shopButton;
	public AutoClicker AutoClicker = new AutoClicker();
	static JLabel COOKIES_LABEL = new JLabel();
	
	JSlider volume;
	JMenuBar menuBar;
	JMenu optionsMenu;
	JMenu saveMenu;
	JMenu soundMenu;
	JMenu statsMenu;
	static JLabel volumeLabel = new JLabel("Volume: ");
	static JLabel MULTIPLIER_LABEL = new JLabel();
	public JFrame mainFrame = GlobalVars.MAIN_FRAME;
	
	int cookies = GlobalVars.COOKIES;
	int multi = GlobalVars.COOKIE_MULTIPLIER;
	
	public GameGui(JFrame frame) {
		menuBar = new JMenuBar();
		optionsMenu = new JMenu("Options");
		saveMenu = new JMenu("Save / Load");
		soundMenu = new JMenu("Sound");
		statsMenu = new JMenu("Stats");
		MULTIPLIER_LABEL.setText("Multiplier: "+multi);
		statsMenu.add(MULTIPLIER_LABEL);
		volume = new JSlider();
		volume.addChangeListener(this);
		
		soundMenu.add(volumeLabel);
		soundMenu.add(volume);
		menuBar.add(optionsMenu);
		menuBar.add(saveMenu);
		menuBar.add(statsMenu);
		optionsMenu.add(soundMenu);
		
		cookieButton = new JButton("Cookies");
		shopButton = new JButton("Shop");

		COOKIES_LABEL.setText("Cookies: "+cookies);
		
		cookieButton.addActionListener(this);
		shopButton.addActionListener(this);
		
		frame.setJMenuBar(menuBar);
		gamePanel = new JPanel();
		cookieButton.addKeyListener(this);
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
		//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		
		if(event.getSource() == cookieButton) {
			cookies += GlobalVars.cps();
			SoundManager.effectSounds("sounds/effects/Pling.wav");
			COOKIES_LABEL.setText("Cookies: "+cookies);
		}else if(event.getSource() == shopButton) {
			GlobalVars.COOKIE_MULTIPLIER = multi;
			GlobalVars.COOKIES = cookies;
			GlobalVars.VOLUME = (float) volume.getValue();
			SoundManager.effectSounds("sounds/effects/Pling.wav");
			AutoClicker.toggleAuto();
			mainFrame.remove(gamePanel);
			new ShopGui();
		}
	}

	@Override
	public void stateChanged(ChangeEvent changeEvent) {
		if(changeEvent.getSource() == volume) {
			GlobalVars.VOLUME = (float) volume.getValue();
			
		}
	}

	@Override
	public void keyPressed(KeyEvent event) {
		// TODO Auto-generated method stub
		Thread thread = new Thread(AutoClicker);
		if(event.getKeyCode() == KeyEvent.VK_B)
			mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		if(event.getKeyCode() == KeyEvent.VK_A) {
			if(GlobalVars.AUTO_CLICKER_LEVEL == 1) {
				if(GlobalVars.AUTO_CLICKER_TOGGLE) {
					GlobalVars.AUTO_CLICKER_TOGGLE = !GlobalVars.AUTO_CLICKER_TOGGLE;
					AutoClicker.toggleAuto();
				}
				else {
					GlobalVars.AUTO_CLICKER_TOGGLE = !GlobalVars.AUTO_CLICKER_TOGGLE;
					thread.start();
					GlobalVars.VOLUME = -50f;
					
				}
			}else {
				return;
			}
		}
	}
	public void windowClosing(java.awt.event.WindowEvent e) {
        System.out.println("Test");
		System.exit(0);
    }

	@Override
	public void keyReleased(KeyEvent event) {
		// TODO Auto-generated method stub
		if(event.getKeyCode() == KeyEvent.VK_A) {
			GlobalVars.VOLUME = (float) volume.getValue();
		}
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}

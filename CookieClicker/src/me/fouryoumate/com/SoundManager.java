package me.fouryoumate.com;

import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;

public class SoundManager {
	
	public static void effectSounds(String effect) {
		File f = new File("./" + effect);
			
		try {
			AudioInputStream audioIn = AudioSystem.getAudioInputStream(f.toURI().toURL());  
			Clip clip = AudioSystem.getClip();
			clip.open(audioIn);
			FloatControl control = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
			control.setValue(GlobalVars.VOLUME);
			clip.start();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}
	


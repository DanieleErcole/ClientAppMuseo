package main.events;

import main.MainApp;
import main.PageManager;
import main.audio.AudioManager;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AudioSliderListener implements ChangeListener {

    private final AudioManager audioManager;
    private boolean ignore;

    public AudioSliderListener(AudioManager audioManager) {
        this.audioManager = audioManager;
        ignore = false;
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        JSlider slider = (JSlider) e.getSource();
        if(ignore) {
            if(MainApp.clicked) {
                audioManager.pauseTrack();
                Timer delayed = new Timer(25, new ActionListener() {
                    @Override
                    public synchronized void actionPerformed(ActionEvent e) {
                        audioManager.getCurrentTrack().setCurrentFrame(MainApp.valueClicked);
                        slider.setValue(MainApp.valueClicked);
                        MainApp.clicked = false;
                        audioManager.startTrack();
                    }
                });
                delayed.setRepeats(false);
                delayed.start();
            }
            return;
        }

        if(!slider.getValueIsAdjusting()) {
            int value = slider.getValue();
            audioManager.getCurrentTrack().getThisClip().setFramePosition(value);
        }
    }

    public void setIgnore(boolean ignore) {
        this.ignore = ignore;
    }

}

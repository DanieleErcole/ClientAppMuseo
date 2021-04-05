package main.events;

import main.audio.AudioManager;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SliderChangeListener implements ChangeListener {

    private final AudioManager audioManager;
    private final SliderListener sliderListener;
    private boolean ignore;

    public SliderChangeListener(AudioManager audioManager, SliderListener sliderListener) {
        this.audioManager = audioManager;
        this.sliderListener = sliderListener;
        ignore = false;
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        JSlider slider = (JSlider) e.getSource();
        if(ignore) {
            if(sliderListener.isClicked()) {
                audioManager.pauseTrack();
                Timer delayed = new Timer(25, new ActionListener() {
                    @Override
                    public synchronized void actionPerformed(ActionEvent e) {
                        audioManager.getCurrentTrack().setCurrentFrame(sliderListener.getValueClicked());
                        slider.setValue(sliderListener.getValueClicked());
                        sliderListener.setClicked(false);
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

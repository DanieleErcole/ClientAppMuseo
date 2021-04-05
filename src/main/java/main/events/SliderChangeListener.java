package main.events;

import main.audio.AudioManager;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Classe che aggiorna la traccia in caso venga cambiato il valore dello slider in caso tramite il click dell'utente sullo slider
 * @author Daniele Pelizzoni
 */
public class SliderChangeListener implements ChangeListener {

    private final AudioManager audioManager;
    private final SliderMouseListener sliderMouseListener;
    private boolean ignore;

    public SliderChangeListener(AudioManager audioManager, SliderMouseListener sliderMouseListener) {
        this.audioManager = audioManager;
        this.sliderMouseListener = sliderMouseListener;
        ignore = false;
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        JSlider slider = (JSlider) e.getSource();
        if(ignore) {
            //Controlla che l'AudioTimerListener non stia aggiornando lo slider e che l'utente abbia cliccato il mouse
            if(sliderMouseListener.isClicked()) {
                audioManager.pauseTrack();
                Timer delayed = new Timer(25, new ActionListener() {
                    @Override
                    public synchronized void actionPerformed(ActionEvent e) {
                        audioManager.getCurrentTrack().setCurrentFrame(sliderMouseListener.getValueClicked());
                        slider.setValue(sliderMouseListener.getValueClicked());
                        sliderMouseListener.setClicked(false);
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

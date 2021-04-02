package main.events;

import main.audio.AudioManager;
import main.pages.RootPage;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AudioTimerListener implements ActionListener {

    private final AudioSliderListener changeListener;
    private final AudioManager audioManager;
    private final RootPage rootPage;

    public AudioTimerListener(AudioSliderListener changeListener, AudioManager audioManager, RootPage rootPage) {
        this.changeListener = changeListener;
        this.audioManager = audioManager;
        this.rootPage = rootPage;
    }

    @Override
    public synchronized void actionPerformed(ActionEvent e) {
        changeListener.setIgnore(true);
        rootPage.getTimeSlider().setValue(audioManager.getCurrentTrack().getThisClip().getFramePosition());
        changeListener.setIgnore(false);
    }

}

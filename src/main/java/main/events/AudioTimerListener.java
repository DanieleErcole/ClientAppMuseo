package main.events;

import main.audio.AudioManager;
import main.pages.RootPage;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Timestamp;
import java.time.LocalDateTime;

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
        if(!rootPage.isAudioPaused()) {
            changeListener.setIgnore(true);
            LocalDateTime t = new Timestamp(audioManager.getCurrentTrack().getThisClip().getMicrosecondPosition() / 1000).toLocalDateTime();
            rootPage.getLeftTimeLabel().setText(t.getMinute() + ":" + t.getSecond());
            rootPage.getRightTimeLabel().setText(
                    audioManager.getCurrentTrack().getDuration().toLocalDateTime().getMinute() + ":" + audioManager.getCurrentTrack().getDuration().toLocalDateTime().getSecond()
            );
            rootPage.getTimeSlider().setValue(audioManager.getCurrentTrack().getThisClip().getFramePosition());
            changeListener.setIgnore(false);
        }
    }

}

package main.events;

import main.audio.AudioManager;
import main.pages.RootPage;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Timestamp;
import java.time.LocalDateTime;

public class AudioTimerListener implements ActionListener {

    private final SliderChangeListener changeListener;
    private final AudioManager audioManager;
    private final RootPage rootPage;

    public AudioTimerListener(SliderChangeListener changeListener, AudioManager audioManager, RootPage rootPage) {
        this.changeListener = changeListener;
        this.audioManager = audioManager;
        this.rootPage = rootPage;
    }

    @Override
    public synchronized void actionPerformed(ActionEvent e) {
        if(!rootPage.isAudioPaused()) {
            changeListener.setIgnore(true);

            LocalDateTime t = new Timestamp(audioManager.getCurrentTrack().getThisClip().getMicrosecondPosition() / 1000).toLocalDateTime();
            String minute = t.getMinute() > 9 ? "" + t.getMinute() : "0" + t.getMinute();
            String second = t.getSecond() > 9 ? "" + t.getSecond() : "0" + t.getSecond();
            rootPage.getLeftTimeLabel().setText(minute + ":" + second);

            int m = audioManager.getCurrentTrack().getDuration().toLocalDateTime().getMinute();
            int s = audioManager.getCurrentTrack().getDuration().toLocalDateTime().getSecond();
            minute = m > 9 ? "" + m : "0" + m;
            second = s > 9 ? "" + s : "0" + s;
            rootPage.getRightTimeLabel().setText(minute + ":" + second);
            rootPage.getTimeSlider().setValue(audioManager.getCurrentTrack().getThisClip().getFramePosition());

            changeListener.setIgnore(false);
        }
    }

}

package main.audio;

import main.database.Reperto;
import main.events.AudioSliderListener;
import main.events.AudioTimerListener;
import main.pages.RootPage;

import javax.sound.sampled.*;
import javax.swing.*;
import java.io.IOException;
import java.net.URL;

public class AudioManager {

    private final Mixer mixer;
    private Reperto find;
    private AudioTrack currentTrack;
    private Timer audioTimer;

    /**
     * Costruttore degli oggetti di classe AudioManager
     */
    public AudioManager() {
        Mixer.Info[] infos = AudioSystem.getMixerInfo();
        mixer = AudioSystem.getMixer(infos[3]);
    }

    public void initAudioTimer(RootPage root, AudioSliderListener audioSliderListener) {
        AudioTimerListener audioTimerListener = new AudioTimerListener(audioSliderListener, this, root);
        audioTimer = new Timer(100, audioTimerListener);
    }

    /**
     * Metodo che fa partire la clip audio con il nome dato
     * @param path -> nome della clip audio
     */
    public void addTrack(URL path, int index) {
        try {
            DataLine.Info dataInfo = new DataLine.Info(Clip.class, null);
            currentTrack = new AudioTrack((Clip) mixer.getLine(dataInfo), AudioSystem.getAudioInputStream(path),.02f, path, index);
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
            return;
        }
        currentTrack.getThisClip().addLineListener(new LineListener() {
            @Override
            public void update(LineEvent event) {
                if(event.getType().equals(LineEvent.Type.STOP) || event.getType().equals(LineEvent.Type.CLOSE))
                    audioTimer.stop();
                else if(event.getType().equals(LineEvent.Type.START) || event.getType().equals(LineEvent.Type.OPEN))
                    audioTimer.start();
            }
        });
    }

    public void startTrack() {
        currentTrack.start();
    }

    public void pauseTrack() {
        currentTrack.pause();
    }

    public void resumeTrack() {
        currentTrack.resume();
    }

    public void stopTrack() {
        currentTrack.stop();
        currentTrack = null;
    }

    //Getter
    public AudioTrack getCurrentTrack() {
        return currentTrack;
    }

    public Reperto getFind() {
        return find;
    }

    //Setter
    public void setFind(Reperto find) {
        this.find = find;
    }

}

package main.audio;

import main.events.AudioSliderListener;
import main.events.AudioTimerListener;
import main.pages.RootPage;

import javax.sound.sampled.*;
import javax.swing.*;
import java.io.IOException;
import java.net.URL;

public class AudioManager {

    private final Mixer mixer;
    private AudioTrack currentTrack;

    private AudioTimerListener audioTimerListener;
    private Timer audioTimer;

    /**
     * Costruttore degli oggetti di classe AudioManager
     */
    public AudioManager() {
        Mixer.Info[] infos = AudioSystem.getMixerInfo();
        mixer = AudioSystem.getMixer(infos[3]);
    }

    public void initAudioTimer(RootPage root, AudioSliderListener audioSliderListener) {
        audioTimerListener = new AudioTimerListener(audioSliderListener, this, root);
        audioTimer = new Timer(100, audioTimerListener);
    }

    /**
     * Metodo che fa partire la clip audio con il nome dato
     * @param path -> nome della clip audio
     * @param isLooped -> flag che identifica se l'audio deve essere riprodotto in loop
     */
    public void addTrack(URL path, boolean isLooped) {
        try {
            DataLine.Info dataInfo = new DataLine.Info(Clip.class, null);
            currentTrack = new AudioTrack((Clip) mixer.getLine(dataInfo), AudioSystem.getAudioInputStream(path),.02f, isLooped, path);
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
            return;
        }
        currentTrack.getThisClip().addLineListener(new LineListener() {
            @Override
            public void update(LineEvent event) {
                if(event.getType().equals(LineEvent.Type.STOP) || event.getType().equals(LineEvent.Type.CLOSE)) {
                    audioTimer.stop();
                }
            }
        });
    }

    public void startTrack() {
        currentTrack.start();
        audioTimer.start();
    }

    public void pauseTrack() {
        currentTrack.pause();
    }

    public void resumeTrack() {
        currentTrack.resume();
    }

    public void stopTrack() {
        currentTrack.stop();
        currentTrack = null;;
    }

    //Getter
    public AudioTrack getCurrentTrack() {
        return currentTrack;
    }

}

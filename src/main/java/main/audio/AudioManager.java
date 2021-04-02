package main.audio;

import javax.sound.sampled.*;
import javax.swing.*;
import java.io.IOException;
import java.net.URL;

public class AudioManager {

    private final Mixer mixer;
    private AudioTrack currentTrack;
    private AudioTask task;

    /**
     * Costruttore degli oggetti di classe AudioManager
     */
    public AudioManager() {
        Mixer.Info[] infos = AudioSystem.getMixerInfo();
        mixer = AudioSystem.getMixer(infos[3]);
    }

    /**
     * Metodo che fa partire la clip audio con il nome dato
     * @param path -> nome della clip audio
     * @param isLooped -> flag che identifica se l'audio deve essere riprodotto in loop
     */
    public void addTrack(String path, JSlider slider, boolean isLooped) {
        try {
            DataLine.Info dataInfo = new DataLine.Info(Clip.class, null);
            currentTrack = new AudioTrack((Clip) mixer.getLine(dataInfo), AudioSystem.getAudioInputStream(new URL(path)),.02f, isLooped, new URL(path));
            //tracks.put(clipName, new AudioTrack((Clip) mixer.getLine(dataInfo), AudioSystem.getAudioInputStream(Assets.getSounds().get(clipName)),.02f, isLooped, clipName));
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
            return;
        }
        task = new AudioTask(currentTrack.getThisClip(), slider);
    }

    public void startTrack() {
        currentTrack.start();
        task.setRunning(true);
        task.start();
    }

    public void pauseTrack() {
        currentTrack.pause();
    }

    public void resumeTrack() {
        currentTrack.resume();
    }

    public void stopTrack() {
        currentTrack.stop();
        task.setRunning(false);
        currentTrack = null;
        task = null;
    }

    //Getter
    public AudioTrack getCurrentTrack() {
        return currentTrack;
    }

}

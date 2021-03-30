package main.audio;

import javax.sound.sampled.*;
import java.io.IOException;
import java.net.URL;

public class AudioManager {

    private final Mixer mixer;
    private AudioTrack currentTrack;

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
    public void addTrack(String path, boolean isLooped) {
        try {
            DataLine.Info dataInfo = new DataLine.Info(Clip.class, null);
            currentTrack = new AudioTrack((Clip) mixer.getLine(dataInfo), AudioSystem.getAudioInputStream(new URL(path)),.02f, isLooped, new URL(path));
            //tracks.put(clipName, new AudioTrack((Clip) mixer.getLine(dataInfo), AudioSystem.getAudioInputStream(Assets.getSounds().get(clipName)),.02f, isLooped, clipName));
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
        }
    }

    /**
     * Metodo che fa partire una traccia audio
     */
    public void startTrack() {
        currentTrack.start();
    }

    /**
     * Metodo che mette in pausa una traccia audio
     */
    public void pauseTrack() {
        currentTrack.pause();
    }

    /**
     * Metodo che riprende la riproduzione della traccia audio
     */
    public void resumeTrack() {
        currentTrack.resume();
    }

    /**
     * Metodo che ferma la riproduzione della clip audio
     */
    public void stopTrack() {
        currentTrack.stop();
        currentTrack = null;
    }

    //Getter
    public AudioTrack getCurrentTrack() {
        return currentTrack;
    }

}

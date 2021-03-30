package main.audio;

import javax.sound.sampled.*;
import java.io.IOException;
import java.net.URL;

/**
 * Classe che rappresenta una generica traccia audio
 * @author Daniele Pelizzoni
 */

public class AudioTrack {

    private final URL clipURL;
    private final Clip thisClip;
    private AudioInputStream thisStream;

    private float volume;
    private long currentFrame;
    private final boolean isLooped;

    /**
     * Costruttore degli oggetti di classe AudioTrack
     * @param thisClip -> clip audio da riprodurre
     * @param thisStream -> stream audio che riproduce la traccia
     * @param volume -> livello di volume
     * @param isLooped -> flag che indica se la traccia deve essere riprodotta in loop
     */
    public AudioTrack(Clip thisClip, AudioInputStream thisStream, float volume, boolean isLooped, URL url) {
        this.thisClip = thisClip;
        this.thisStream = thisStream;
        this.volume = volume;
        this.isLooped = isLooped;
        this.clipURL = url;
        try {
            this.thisClip.open(thisStream);
            //Volume
            FloatControl gainControl = (FloatControl) this.thisClip.getControl(FloatControl.Type.MASTER_GAIN);
            gainControl.setValue(20f * (float) Math.log10(this.volume));
        } catch (LineUnavailableException | IOException e) {
            e.printStackTrace();
        }
        currentFrame = 0L;
    }

    /**
     * Metodo che inizia la riproduzione della traccia
     */
    public void start() {
        assert thisStream != null : "audioStream not initialized";
        if(isLooped)
            thisClip.loop(Clip.LOOP_CONTINUOUSLY);
        thisClip.start();
    }

    /**
     * Metodo che mette in pausa la traccia
     */
    public void pause() {
        currentFrame = thisClip.getMicrosecondPosition();
        thisClip.stop();
    }

    /**
     * Metodo che riprende la riproduzione della traccia
     */
    public void resume() {
        if(!thisClip.isOpen() || !thisClip.isActive()) {
            thisClip.close();
            try {
                thisStream = AudioSystem.getAudioInputStream(clipURL);
                thisClip.open(thisStream);
                if(isLooped)
                    thisClip.loop(Clip.LOOP_CONTINUOUSLY);
            } catch (LineUnavailableException | UnsupportedAudioFileException | IOException e) {
                e.printStackTrace();
            }
            thisClip.setMicrosecondPosition(currentFrame);
            thisClip.start();
        }
    }

    /**
     * Metodo che ferma la riproduzione della traccia
     */
    public void stop() {
        if(thisClip.isRunning() || thisClip.isActive() || thisClip.isOpen()) {
            thisClip.stop();
            thisClip.close();
            try {
                thisStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    //Getter
    public float getVolume() {
        return volume;
    }

}

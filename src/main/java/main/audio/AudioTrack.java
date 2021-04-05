package main.audio;

import javax.sound.sampled.*;
import java.io.IOException;
import java.net.URL;
import java.sql.Timestamp;

/**
 * Classe che rappresenta una traccia audio
 * @author Daniele Pelizzoni
 */
public class AudioTrack {

    private final URL clipURL;
    private final Clip thisClip;
    private AudioInputStream thisStream;
    private final int index;

    private float volume;
    private int currentFrame;
    private Timestamp duration;

    /**
     * Costruttore degli oggetti di classe AudioTrack
     * @param thisClip clip audio da riprodurre
     * @param thisStream stream audio che riproduce la traccia
     * @param volume livello di volume
     * @param url url della traccia audio
     * @param index indice della traccia audio
     */
    public AudioTrack(Clip thisClip, AudioInputStream thisStream, float volume, URL url, int index) {
        this.thisClip = thisClip;
        this.thisStream = thisStream;
        this.volume = volume;
        this.clipURL = url;
        this.index = index;
        try {
            this.thisClip.open(thisStream);
            this.duration = new Timestamp(thisClip.getMicrosecondLength() / 1000);
            //Volume
            FloatControl gainControl = (FloatControl) this.thisClip.getControl(FloatControl.Type.MASTER_GAIN);
            gainControl.setValue(20f * (float) Math.log10(this.volume));
        } catch (LineUnavailableException | IOException e) {
            e.printStackTrace();
        }
        currentFrame = 0;
    }

    /**
     * Metodo che inizia la riproduzione della traccia
     */
    public void start() {
        if(thisStream != null)
            thisClip.start();
    }

    /**
     * Metodo che mette in pausa la traccia
     */
    public void pause() {
        currentFrame = thisClip.getFramePosition();
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
            } catch (LineUnavailableException | UnsupportedAudioFileException | IOException e) {
                e.printStackTrace();
            }
            thisClip.setFramePosition(currentFrame);
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
    public Timestamp getDuration() {
        return duration;
    }

    public Clip getThisClip() {
        return thisClip;
    }

    public URL getClipURL() {
        return clipURL;
    }

    public int getIndex() {
        return index;
    }

    //Setter
    public void setCurrentFrame(int currentFrame) {
        this.currentFrame = currentFrame;
    }

}

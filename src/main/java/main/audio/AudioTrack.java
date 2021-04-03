package main.audio;

import javax.sound.sampled.*;
import java.io.IOException;
import java.net.URL;

public class AudioTrack {

    private final URL clipURL;
    private final Clip thisClip;
    private AudioInputStream thisStream;
    private final int index;

    private float volume;
    private int currentFrame;
    private final boolean isLooped;

    /**
     * Costruttore degli oggetti di classe AudioTrack
     * @param thisClip -> clip audio da riprodurre
     * @param thisStream -> stream audio che riproduce la traccia
     * @param volume -> livello di volume
     * @param isLooped -> flag che indica se la traccia deve essere riprodotta in loop
     */
    public AudioTrack(Clip thisClip, AudioInputStream thisStream, float volume, boolean isLooped, URL url, int index) {
        this.thisClip = thisClip;
        this.thisStream = thisStream;
        this.volume = volume;
        this.isLooped = isLooped;
        this.clipURL = url;
        this.index = index;
        try {
            this.thisClip.open(thisStream);
            //Volume
            FloatControl gainControl = (FloatControl) this.thisClip.getControl(FloatControl.Type.MASTER_GAIN);
            gainControl.setValue(20f * (float) Math.log10(this.volume));
        } catch (LineUnavailableException | IOException e) {
            e.printStackTrace();
        }
        currentFrame = 0;
    }

    public void start() {
        if(thisStream != null) {
            if(isLooped)
                thisClip.loop(Clip.LOOP_CONTINUOUSLY);
            thisClip.start();
        }
    }

    public void pause() {
        currentFrame = thisClip.getFramePosition();
        thisClip.stop();
    }

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
            thisClip.setFramePosition(currentFrame);
            thisClip.start();
        }
    }

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

    public Clip getThisClip() {
        return thisClip;
    }

    public boolean isLooped() {
        return isLooped;
    }

    public int getCurrentFrame() {
        return currentFrame;
    }

    public int getIndex() {
        return index;
    }

    //Setter
    public void setCurrentFrame(int currentFrame) {
        this.currentFrame = currentFrame;
    }

}

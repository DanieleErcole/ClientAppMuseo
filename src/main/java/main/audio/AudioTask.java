package main.audio;

import javax.sound.sampled.Clip;
import javax.swing.*;

public class AudioTask extends Thread {

    private Clip clip;
    private JSlider slider;
    private boolean running;

    public AudioTask(Clip clip, JSlider slider) {
        this.clip = clip;
        this.slider = slider;
        running = false;
    }

    @Override
    public synchronized void run() {
        while(running) {
            //NOTA: aggiornare lo slider
            long frame = clip.getMicrosecondPosition();
        }

        try {
            this.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    //Getter
    public boolean getRunning() {
        return running;
    }

    public void setRunning(boolean r) {
        this.running = r;
    }

}

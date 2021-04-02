package main.audio;

import javax.sound.sampled.Clip;
import javax.swing.*;

public class AudioTask extends Thread {

    private final Clip clip;
    private final JSlider slider;
    private boolean isLoop;
    private boolean running;

    protected float deltaTime;
    protected long lastTime;
    protected long now;

    public AudioTask(Clip clip, JSlider slider, boolean loop) {
        this.clip = clip;
        this.slider = slider;
        isLoop = loop;
        //slider.setMaximum((int) clip.getMicrosecondLength() * 1000000);
        slider.setMaximum(this.clip.getFrameLength());
        lastTime = System.nanoTime();
        running = false;
    }

    @Override
    public void run() {
        float frameTime = 1000000000;
        float deltaOraPrima = 0;

        while(running) {
            now = System.nanoTime();
            deltaOraPrima += now - lastTime;
            lastTime = now;

            if(deltaOraPrima >= frameTime) {
                deltaTime = deltaOraPrima / 100000000;
                slider.setValue(clip.getFramePosition());
                if(clip.getFramePosition() == clip.getFrameLength() && !isLoop)
                    running = false;
                deltaOraPrima = 0;
            }
        }
        /*long frame = clip.getMicrosecondPosition();
        int time = (int) frame * 1000000;
        System.out.println(time);
        slider.setValue(time);*/
        /*while(running) {
            System.out.println(clip.getFramePosition());
            slider.setValue(clip.getFramePosition());
            if(clip.getFramePosition() == clip.getFrameLength() && !isLoop)
                running = false;
        }*/

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

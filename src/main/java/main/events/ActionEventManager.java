package main.events;

import main.PageManager;
import main.audio.AudioManager;
import main.pages.InitialPage;
import main.pages.LoginPage;
import main.pages.Page;
import main.pages.SignUpPage;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ActionEventManager implements ActionListener {

    private final AudioManager audioManager;
    private final PageManager pageManager;
    private int id;

    public ActionEventManager(AudioManager audioManager, PageManager pageManager, int id) {
        this.audioManager = audioManager;
        this.pageManager = pageManager;
        this.id = id;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();

        if(command.contains("change-")) {
            Page page = null;

            if(command.endsWith("login")) {
                pageManager.getRootPage().getContentPane().setSize(800, 600);
                pageManager.getRootPage().getContentPane().setPreferredSize(new Dimension(800, 600));
                pageManager.getRootPage().pack();
                pageManager.getRootPage().hideAudioBar(800);
                page = new LoginPage(audioManager, pageManager, "login");
            } else if(command.endsWith("signup")) {
                pageManager.getRootPage().getContentPane().setSize(800, 600);
                pageManager.getRootPage().getContentPane().setPreferredSize(new Dimension(800, 600));
                pageManager.getRootPage().pack();
                pageManager.getRootPage().hideAudioBar(800);
                page = new SignUpPage(audioManager, pageManager, "signup");
            } else if(command.endsWith("initial"))
                page = new InitialPage(audioManager, pageManager, "initial");

            if(page != null)
                pageManager.changePage(page, audioManager);
        } else if(command.contains("audioStart-")) {
            id = Integer.parseInt(command.substring(11)); //L'indice che corrisponde alla traccia in riproduzione
            pageManager.getRootPage().setAudioPaused(false);
            audioManager.addTrack(getClass().getResource(audioManager.getFind().getUrlAudioguide().get(id)), false);
            pageManager.getRootPage().getTimeSlider().setValue(0);
            pageManager.getRootPage().getTimeSlider().setMaximum(audioManager.getCurrentTrack().getThisClip().getFrameLength());
            pageManager.getRootPage().showAudioBar();
            audioManager.startTrack();
        } else if(command.equals("login")) {

        } else if(command.equals("signup")) {

        } else if(command.equals("selectionRoom")) {

        } else if(command.equals("audioPause")) {
            pageManager.getRootPage().setAudioPaused(true);
            audioManager.pauseTrack();
        } else if(command.equals("audioResume")) {
            pageManager.getRootPage().setAudioPaused(false);
            audioManager.resumeTrack();
        } else if(command.equals("audioNext")) {
            id = id + 1 < audioManager.getFind().getUrlAudioguide().size() ? id + 1 : 0;
            audioManager.stopTrack();
            audioManager.addTrack(getClass().getResource(audioManager.getFind().getUrlAudioguide().get(id)), false);
            pageManager.getRootPage().getTimeSlider().setValue(0);
            pageManager.getRootPage().getTimeSlider().setMaximum(audioManager.getCurrentTrack().getThisClip().getFrameLength());
            audioManager.startTrack();
        } else if(command.equals("audioPrevious")) {
            id = id - 1 >= 0 ? id - 1 : audioManager.getFind().getUrlAudioguide().size() - 1;
            audioManager.stopTrack();
            audioManager.addTrack(getClass().getResource(audioManager.getFind().getUrlAudioguide().get(id)), false);
            pageManager.getRootPage().getTimeSlider().setValue(0);
            pageManager.getRootPage().getTimeSlider().setMaximum(audioManager.getCurrentTrack().getThisClip().getFrameLength());
            audioManager.startTrack();
        } else if(command.equals("audioStop")) {
            pageManager.getRootPage().hideAudioBar(1250);
            pageManager.getRootPage().setAudioPaused(true);
            audioManager.startTrack();
        }
    }

}

package main.events;

import main.PageManager;
import main.audio.AudioManager;
import main.pages.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.HashMap;

public class ButtonActionManager implements ActionListener {

    private final AudioManager audioManager;
    private final PageManager pageManager;
    private int id;

    public ButtonActionManager(AudioManager audioManager, PageManager pageManager, int id) {
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
            } else if(command.endsWith("initial")) {
                pageManager.changeBackButtonAction(0, "", audioManager);
                page = new InitialPage(audioManager, pageManager, "initial");
            } else if(command.endsWith("selectionRoom")) {
                pageManager.changeBackButtonAction(id, "change-initial", audioManager);
                page = new PaginaSelezione(audioManager, pageManager, "room", id);
            } else if(command.endsWith("selectionFind")) {
                pageManager.changeBackButtonAction(id, "change-selectionCase", audioManager);
                page = new PaginaSelezione(audioManager, pageManager, "find", id);
            } else if(command.endsWith("selectionCase")) {
                pageManager.changeBackButtonAction(id, "change-selectionRoom", audioManager);
                page = new PaginaSelezione(audioManager, pageManager, "case", id);
            }

            if(page != null)
                pageManager.changePage(page, audioManager);
        } else if(command.contains("audioStart-")) {
            if(audioManager.getCurrentTrack() != null)
                audioManager.stopTrack();
            id = Integer.parseInt(command.substring(11)); //L'indice che corrisponde alla traccia in riproduzione
            pageManager.getRootPage().setAudioPaused(false);
            audioManager.addTrack(audioManager.getFind().getUrlAudioguide().get(id), id);
            String[] array = audioManager.getCurrentTrack().getClipURL().getPath().split("/");
            pageManager.getRootPage().getTitleLabel().setText(array[array.length - 1]);
            pageManager.getRootPage().getTimeSlider().setValue(0);
            pageManager.getRootPage().getTimeSlider().setMaximum(audioManager.getCurrentTrack().getThisClip().getFrameLength());
            pageManager.getRootPage().getContentPane().setSize(1250, 703);
            pageManager.getRootPage().getContentPane().setPreferredSize(new Dimension(1250, 703));
            pageManager.getRootPage().pack();
            pageManager.getRootPage().hideAudioBar(1250);
            pageManager.getRootPage().showAudioBar(audioManager, pageManager);
            audioManager.startTrack();
        } else if(command.equals("login")) {
            LoginPage page = (LoginPage) ((JButton) e.getSource()).getParent().getParent().getParent().getParent();
            String email = page.getEmailInputField().getText();
            String psw = "";
            StringBuilder str = new StringBuilder();
            for(char c : page.getPasswordInputField().getPassword())
                str.append(c);
            psw = str.toString();

            HashMap<String, String> params = new HashMap<>();
            params.put("type", "login");
            params.put("email", email);
            params.put("password", psw);
            int error = 1;
            try {
                error = pageManager.getDataManager().requestData(Integer.class, params);
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }

            if(error == 0) {
                pageManager.getRootPage().getBackButton().setSize(pageManager.getRootPage().getBackButton().getWidth(), 22);
                pageManager.getRootPage().getBackButton().setPreferredSize(new Dimension(pageManager.getRootPage().getBackButton().getWidth(), 22));
                pageManager.getRootPage().getContentPane().setSize(1250, 628);
                pageManager.getRootPage().getContentPane().setPreferredSize(new Dimension(1250, 628));
                pageManager.getRootPage().pack();
                pageManager.changeBackButtonAction(0, "", audioManager);
                pageManager.changePage(new InitialPage(audioManager, pageManager, "initial"), audioManager);
            }
        } else if(command.equals("signup")) {
            SignUpPage page = (SignUpPage) ((JButton) e.getSource()).getParent().getParent().getParent().getParent();
            String nome = page.getNomeInputField().getText();
            String cognome = page.getCognomeInputField().getText();
            String password = "";
            String email = page.getEmailInputField().getText();

            StringBuilder str = new StringBuilder();
            for(char c : page.getPasswordInputField().getPassword())
                str.append(c);
            password = str.toString();

            HashMap<String, String> params = new HashMap<>();
            params.put("type", "signup");
            params.put("nome", nome);
            params.put("cognome", cognome);
            params.put("email", email);
            params.put("password", password);
            int error = 1;
            try {
                error = pageManager.getDataManager().requestData(Integer.class, params);
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }

            if(error == 0) {
                pageManager.getRootPage().getBackButton().setSize(pageManager.getRootPage().getBackButton().getWidth(), 22);
                pageManager.getRootPage().getBackButton().setPreferredSize(new Dimension(pageManager.getRootPage().getBackButton().getWidth(), 22));
                pageManager.getRootPage().getContentPane().setSize(1250, 628);
                pageManager.getRootPage().getContentPane().setPreferredSize(new Dimension(1250, 628));
                pageManager.getRootPage().pack();
                pageManager.changeBackButtonAction(0, "", audioManager);
                pageManager.changePage(new InitialPage(audioManager, pageManager, "initial"), audioManager);
            }
        } else if(command.equals("logout")) {
            if(audioManager.getCurrentTrack() != null)
                audioManager.stopTrack();
            pageManager.getRootPage().getContentPane().setSize(800, 600);
            pageManager.getRootPage().getContentPane().setPreferredSize(new Dimension(800, 600));
            pageManager.getRootPage().pack();
            pageManager.getRootPage().hideAudioBar(800);
            pageManager.changeBackButtonAction(0, "", audioManager);
            pageManager.changePage(new LoginPage(audioManager, pageManager, "login"), audioManager);
        } else if(command.equals("audioPause")) {
            pageManager.getRootPage().setAudioPaused(true);
            audioManager.pauseTrack();
            pageManager.getRootPage().getCenterButton().setActionCommand("audioResume");
        } else if(command.equals("audioResume")) {
            pageManager.getRootPage().setAudioPaused(false);
            audioManager.resumeTrack();
            pageManager.getRootPage().getCenterButton().setActionCommand("audioPause");
        } else if(command.equals("audioNext")) {
            audioManager.next();
            String[] array = audioManager.getCurrentTrack().getClipURL().getPath().split("/");
            pageManager.getRootPage().getTitleLabel().setText(array[array.length - 1]);
            pageManager.getRootPage().getTimeSlider().setValue(0);
            pageManager.getRootPage().getTimeSlider().setMaximum(audioManager.getCurrentTrack().getThisClip().getFrameLength());
            audioManager.startTrack();
        } else if(command.equals("audioPrevious")) {
            audioManager.previous();
            String[] array = audioManager.getCurrentTrack().getClipURL().getPath().split("/");
            pageManager.getRootPage().getTitleLabel().setText(array[array.length - 1]);
            pageManager.getRootPage().getTimeSlider().setValue(0);
            pageManager.getRootPage().getTimeSlider().setMaximum(audioManager.getCurrentTrack().getThisClip().getFrameLength());
            audioManager.startTrack();
        } else if(command.equals("audioStop")) {
            pageManager.getRootPage().getContentPane().setSize(1250, 628);
            pageManager.getRootPage().getContentPane().setPreferredSize(new Dimension(1250, 628));
            pageManager.getRootPage().pack();
            pageManager.getRootPage().hideAudioBar(1250);
            pageManager.getRootPage().setAudioPaused(true);
            audioManager.stopTrack();
        }
    }

}

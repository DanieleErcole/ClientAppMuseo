package main.events;

import main.PageManager;
import main.audio.AudioManager;
import main.pages.InitialPage;
import main.pages.LoginPage;
import main.pages.Page;
import main.pages.SignUpPage;

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

            if(command.endsWith("login"))
                page = new LoginPage(audioManager, pageManager, "login");
            else if(command.endsWith("signup"))
                page = new SignUpPage(audioManager, pageManager, "signup");
            else if(command.endsWith("initial"))
                page = new InitialPage(audioManager, pageManager, "initial");

            if(page != null)
                pageManager.changePage(page, audioManager);
        } else if(command.equals("login")) {

        } else if(command.equals("signup")) {

        } else if(command.equals("selectionRoom")) {

        } else if(command.equals("audioStart")) {

        } else if(command.equals("audioPause")) {

        } else if(command.equals("audioResume")) {

        } else if(command.equals("audioNext")) {

        } else if(command.equals("audioPrevious")) {

        } else if(command.equals("audioStop")) {

        }
    }

}

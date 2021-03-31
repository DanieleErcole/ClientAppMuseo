package main.events;

import main.PageManager;
import main.audio.AudioManager;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ActionEventManager implements ActionListener {

    private final AudioManager manager;
    private final PageManager pageManager;
    private int id;

    public ActionEventManager(AudioManager manager, PageManager pageManager, int id) {
        this.manager = manager;
        this.pageManager = pageManager;
        this.id = id;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

}

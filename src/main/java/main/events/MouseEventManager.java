package main.events;

import main.PageManager;
import main.audio.AudioManager;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MouseEventManager extends MouseAdapter {

    private final AudioManager manager;
    private final PageManager pageManager;
    private int id;

    public MouseEventManager(AudioManager manager, PageManager pageManager, int id) {
        this.manager = manager;
        this.pageManager = pageManager;
        this.id = id;
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

}

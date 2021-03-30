package main.pages;

import main.PageManager;
import main.audio.AudioManager;

import javax.swing.*;

public abstract class Page extends JPanel {

    private final String pageName;

    public Page(AudioManager audioManager, PageManager pageManager, String name) {
        super();
        pageName = name;
        this.initPage(audioManager, pageManager);
    }

    public abstract void initPage(AudioManager audioManager, PageManager pageManager);

    //Getter
    public String getPageName() {
        return pageName;
    }

}

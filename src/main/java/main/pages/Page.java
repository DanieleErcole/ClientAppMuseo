package main.pages;

import main.PageManager;
import main.audio.AudioManager;
import main.database.DataManager;

import javax.swing.*;

public abstract class Page extends JPanel {

    private final String pageName;

    public Page(String name) {
        super();
        pageName = name;
    }

    public abstract void initPage(AudioManager audioManager, PageManager pageManager, DataManager dataManager);

    //Getter
    public String getPageName() {
        return pageName;
    }

}

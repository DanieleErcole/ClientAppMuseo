package main;

import main.audio.AudioManager;
import main.database.DataManager;
import main.pages.Page;
import main.pages.RootPage;

public class PageManager {

    private final DataManager dataManager;
    private final RootPage rootPage; // cambiare poi in rootpage una volta finita in NetBeans

    public PageManager(AudioManager audioManager) {
        dataManager = new DataManager("localhost", "request-script.php");
        rootPage = new RootPage(audioManager, this);
    }

    public void changePage(Page newPage, AudioManager audioManager) {
        newPage.initPage(audioManager, this, dataManager);
        rootPage.setPage(newPage);
    }

    //Getter
    public RootPage getRootPage() {
        return rootPage;
    }

}

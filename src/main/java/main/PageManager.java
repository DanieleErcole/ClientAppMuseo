package main;

import main.audio.AudioManager;
import main.database.DataManager;
import main.events.ButtonActionManager;
import main.pages.Page;
import main.pages.RootPage;

public class PageManager {

    private final DataManager dataManager;
    private ButtonActionManager backButtonListener;
    private final RootPage rootPage;

    public PageManager(AudioManager audioManager) {
        dataManager = new DataManager("localhost", "request-script.php");
        rootPage = new RootPage(audioManager, this);
    }

    public void changePage(Page newPage, AudioManager audioManager) {
        newPage.initPage(audioManager, this, dataManager);
        rootPage.setPage(newPage);
    }

    public void changeBackButtonAction(int id, String command, AudioManager audioManager) {
        if(backButtonListener != null)
            rootPage.getBackButton().removeActionListener(backButtonListener);
        backButtonListener = new ButtonActionManager(audioManager, this, id);
        rootPage.getBackButton().addActionListener(backButtonListener);
        rootPage.getBackButton().setActionCommand(command);
    }

    //Getter
    public RootPage getRootPage() {
        return rootPage;
    }

    public DataManager getDataManager() {
        return dataManager;
    }

}

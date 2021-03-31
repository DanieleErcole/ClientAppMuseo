package main;

import main.database.DataManager;
import main.pages.Page;

public class PageManager {

    private DataManager dataManager;
    private Page rootPage; // cambiare poi in rootpage una volta finita in NetBeans

    public PageManager() {
        dataManager = new DataManager("localhost", "request-script.php");
        //costruire la rootpage
    }

    public void changePage(Page newPage) {
        //rootPage.setPage(newPage);
    }

}

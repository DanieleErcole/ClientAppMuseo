package main.pages;

import main.PageManager;
import main.audio.AudioManager;
import main.database.DataManager;

import javax.swing.*;

/**
 * Classe che rappresenta una pagina generica
 * @author Daniele Pelizzoni e Simone Raffo
 */
public abstract class Page extends JPanel {

    private final String pageName;

    public Page(String name) {
        super();
        pageName = name;
    }

    /**
     * Metodo che inizializza i contenuti di una pagina
     * @param audioManager gestore delle tracce audio legate ai reperti
     * @param pageManager gestore delle pagine
     * @param dataManager gestore della comunicazione con il server
     */
    public abstract void initPage(AudioManager audioManager, PageManager pageManager, DataManager dataManager);

    //Getter
    public String getPageName() {
        return pageName;
    }

}

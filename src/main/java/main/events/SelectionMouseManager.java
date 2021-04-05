package main.events;

import main.PageManager;
import main.audio.AudioManager;
import main.pages.Page;
import main.pages.PaginaInformazioniReperto;
import main.pages.PaginaSelezione;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class SelectionMouseManager extends MouseAdapter {

    private final AudioManager audioManager;
    private final PageManager pageManager;
    private final String typeSelection;
    private final int backCodice;
    private int id;

    public SelectionMouseManager(AudioManager audioManager, PageManager pageManager, int id, String typeSelection, int backCodice) {
        this.audioManager = audioManager;
        this.pageManager = pageManager;
        this.typeSelection = typeSelection;
        this.id = id;
        this.backCodice = backCodice;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        Page page = null;

        if(typeSelection.equals("room")) {
            pageManager.changeBackButtonAction(backCodice, "change-initial", audioManager);
            page = new PaginaSelezione(audioManager, pageManager, "room", id);
        } else if(typeSelection.equals("case")) {
            pageManager.changeBackButtonAction(backCodice, "change-selectionRoom", audioManager);
            page = new PaginaSelezione(audioManager, pageManager, "case", id);
        } else if(typeSelection.equals("find")) {
            pageManager.changeBackButtonAction(backCodice, "change-selectionCase", audioManager);
            page = new PaginaSelezione(audioManager, pageManager, "find", id);
        } else if(typeSelection.equals("selectFind")) {
            pageManager.changeBackButtonAction(backCodice, "change-selectionFind", audioManager);
            page = new PaginaInformazioniReperto(audioManager, pageManager, id);
        }

        if(page != null)
            pageManager.changePage(page, audioManager);
    }

}

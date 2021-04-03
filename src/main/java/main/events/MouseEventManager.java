package main.events;

import main.PageManager;
import main.audio.AudioManager;
import main.pages.Page;
import main.pages.PaginaInformazioniReperto;
import main.pages.PaginaSelezione;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MouseEventManager extends MouseAdapter {

    private final AudioManager audioManager;
    private final PageManager pageManager;
    private final String typeSelection;
    private int id;

    public MouseEventManager(AudioManager audioManager, PageManager pageManager, int id, String typeSelection) {
        this.audioManager = audioManager;
        this.pageManager = pageManager;
        this.typeSelection = typeSelection;
        this.id = id;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        Page page = null;

        if(typeSelection.equals("room")) {
            pageManager.changeBackButtonAction(id, "change-initial", audioManager);
            page = new PaginaSelezione(audioManager, pageManager, "room", id);
        } else if(typeSelection.equals("case")) {
            pageManager.changeBackButtonAction(id, "change-selectionRoom", audioManager);
            page = new PaginaSelezione(audioManager, pageManager, "case", id);
        } else if(typeSelection.equals("find")) {
            pageManager.changeBackButtonAction(id, "change-selectionCase", audioManager);
            page = new PaginaSelezione(audioManager, pageManager, "find", id);
        } else if(typeSelection.equals("selectFind")) {
            pageManager.changeBackButtonAction(id, "change-selectionFind", audioManager);
            page = new PaginaInformazioniReperto(audioManager, pageManager, id);
        }

        if(page != null)
            pageManager.changePage(page, audioManager);
    }

}

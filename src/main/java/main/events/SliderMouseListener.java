package main.events;

import main.MainApp;
import main.PageManager;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class SliderMouseListener extends MouseAdapter {

    private final PageManager pageManager;
    private boolean clicked;
    private int valueClicked;

    public SliderMouseListener(PageManager pageManager) {
        this.pageManager = pageManager;
        clicked = false;
        valueClicked = 0;
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if(!clicked) {
            clicked = true;
            valueClicked = pageManager.getRootPage().getTimeSlider().getValue();
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        clicked = true;
        valueClicked = pageManager.getRootPage().getTimeSlider().getValue();
    }

    //Getter
    public boolean isClicked() {
        return clicked;
    }

    public int getValueClicked() {
        return valueClicked;
    }

    //Setter
    public void setClicked(boolean clicked) {
        this.clicked = clicked;
    }

}

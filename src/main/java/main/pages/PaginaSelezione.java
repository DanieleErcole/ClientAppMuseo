
package main.pages;

import main.PageManager;
import main.audio.AudioManager;
import main.database.DataManager;

import java.awt.Dimension;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Classe che rappresenta la pagina che permette la selezione di sale, teche o reperti
 * @author Simone Raffo
 */
public class PaginaSelezione extends Page {

    private int id;
    private String typeOfSelection;
    private ArrayList<TemplateElementoDx> templatesDx;
    private ArrayList<TemplateElementoSx> templatesSx;
    private int width;
    private int height;
    
    /**
     * Creates new form PaginaSelezione
     */
    public PaginaSelezione(AudioManager audioManager, PageManager pageManager, String typeOfSelection, int id) {
        super("SelectionRooms");
        this.id = id;
        this.typeOfSelection = typeOfSelection;
        initComponents();
    }

    @Override
    public void initPage(AudioManager audioManager, PageManager pageManager, DataManager dataManager) {
        templatesDx = new ArrayList<>();
        templatesSx = new ArrayList<>();
        switch(typeOfSelection) {
            case "room":
                this.initRooms(audioManager, pageManager, dataManager);
                break;
            case "find":
                this.initFinds(audioManager, pageManager, dataManager);
                break;
            case "case":
                this.initCases(audioManager, pageManager, dataManager);
                break;
        }

        width = 1250;
        height = 253 * (templatesDx.size() + templatesSx.size());
        setPreferredSize(new Dimension(width, height));
        setMinimumSize(new Dimension(width, height));
        setMaximumSize(new Dimension(width, height));
        for(int i = 0; i < templatesDx.size() + templatesSx.size(); i++){
            if(i % 2 == 0){
                templatesDx.get(i/2).setLocation(0, i * 253);
                templatesDx.get(i/2).setSize(1250, 250);
                this.add(templatesDx.get(i/2));
            }
            else{
                templatesSx.get(i/2).setLocation(0, i * 253);
                templatesSx.get(i/2).setSize(1250, 250);
                this.add(templatesSx.get(i/2));
            }
        }
    }

    private void initRooms(AudioManager audioManager, PageManager pageManager, DataManager dataManager) {
        HashMap<String, String> params = new HashMap<>();
        params.put("type", "sale-amount");
        Integer[] rooms;
        try {
            rooms = dataManager.requestData(Integer[].class, params);
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        for(int i = 0; i < rooms.length; i++) {
            if(i % 2 == 0) {
                TemplateElementoDx t = new TemplateElementoDx("room", rooms[i], id);
                t.initPage(audioManager, pageManager, dataManager);
                templatesDx.add(t);
            } else {
                TemplateElementoSx t = new TemplateElementoSx("room", rooms[i], id);
                t.initPage(audioManager, pageManager, dataManager);
                templatesSx.add(t);
            }
        }
    }

    private void initCases(AudioManager audioManager, PageManager pageManager, DataManager dataManager) {
        HashMap<String, String> params = new HashMap<>();
        params.put("type", "teche-amount");
        params.put("codice", "" + id);
        Integer[] cases;
        try {
            cases = dataManager.requestData(Integer[].class, params);
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        for(int i = 0; i < cases.length; i++) {
            if(i % 2 == 0) {
                TemplateElementoDx t = new TemplateElementoDx("case", cases[i], id);
                t.initPage(audioManager, pageManager, dataManager);
                templatesDx.add(t);
            } else {
                TemplateElementoSx t = new TemplateElementoSx("case", cases[i], id);
                t.initPage(audioManager, pageManager, dataManager);
                templatesSx.add(t);
            }
        }
    }

    private void initFinds(AudioManager audioManager, PageManager pageManager, DataManager dataManager) {
        HashMap<String, String>params = new HashMap<>();
        params.put("type", "reperti-amount");
        params.put("codice", "" + id);
        Integer[] finds;
        try {
            finds = dataManager.requestData(Integer[].class, params);
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        for(int i = 0; i < finds.length; i++) {
            if(i % 2 == 0) {
                TemplateElementoDx t = new TemplateElementoDx("find", finds[i], id);
                t.initPage(audioManager, pageManager, dataManager);
                templatesDx.add(t);
            } else {
                TemplateElementoSx t = new TemplateElementoSx("find", finds[i], id);
                t.initPage(audioManager, pageManager, dataManager);
                templatesSx.add(t);
            }
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setBackground(new java.awt.Color(131, 123, 104));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 1250, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 600, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    public int getWidth(){
        return width;
    }

    public int getHeight(){
        return height;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}

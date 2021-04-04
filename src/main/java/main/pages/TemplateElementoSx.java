/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.pages;

import main.PageManager;
import main.audio.AudioManager;
import main.database.*;
import main.events.MouseEventManager;

import java.io.IOException;
import java.util.HashMap;

/**
 *
 * @author raffo
 */
public class TemplateElementoSx extends Page {

    private int codice;
    private int backCodice;
    private String typeSelection;

    /**
     * Creates new form TemplateElementoDx
     */
    public TemplateElementoSx(String typeSelection, int codice, int backCodice) {
        super("templateElemSx");
        initComponents();
        this.codice = codice;
        this.typeSelection = typeSelection;
        this.backCodice = backCodice;
    }

    @Override
    public void initPage(AudioManager audioManager, PageManager pageManager, DataManager dataManager) {
        switch(typeSelection) {
            case "room":
                this.initRoom(audioManager, pageManager, dataManager);
                break;
            case "find":
                this.initFind(audioManager, pageManager, dataManager);
                break;
            case "case":
                this.initCase(audioManager, pageManager, dataManager);
                break;
        }
    }

    private void initRoom(AudioManager audioManager, PageManager pageManager, DataManager dataManager) {
        HashMap<String, String> params = new HashMap<>();
        params.put("type", "sala");
        params.put("codice", "" + codice);
        Room room;
        try {
            room = dataManager.requestData(Room.class, params);
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        /*Image img = null;
        try {
            img = dataManager.requestImage(room.getFotoURL());
            img = new ImageIcon(img).getImage().getScaledInstance(440, 220, Image.SCALE_SMOOTH);
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }*/

        params = new HashMap<>();
        params.put("type", "periodoStorico");
        params.put("codice", "" + room.getPeriodoStorico());
        HistoricalPeriod period;
        try {
            period = dataManager.requestData(HistoricalPeriod.class, params);
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        this.addMouseListener(new MouseEventManager(audioManager, pageManager, codice, "case", backCodice));
        titoloElemento.setText("Sala periodo " + period.getNome());
    }

    private void initCase(AudioManager audioManager, PageManager pageManager, DataManager dataManager) {
        HashMap<String, String> params = new HashMap<>();
        params.put("type", "teca");
        params.put("codice", "" + codice);
        Teca teca;
        try {
            teca = dataManager.requestData(Teca.class, params);
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        /*Image img = null;
        try {
            img = dataManager.requestImage(room.getFotoURL());
            img = new ImageIcon(img).getImage().getScaledInstance(440, 220, Image.SCALE_SMOOTH);
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }*/

        this.addMouseListener(new MouseEventManager(audioManager, pageManager, codice, "find", backCodice));
        titoloElemento.setText("Teca " + teca.getCodice());
        descrizione.setText(teca.getDescrizione());
    }

    private void initFind(AudioManager audioManager, PageManager pageManager, DataManager dataManager) {
        HashMap<String, String> params = new HashMap<>();
        params.put("type", "reperto");
        params.put("codice", "" + codice);
        Reperto find;
        try {
            find = dataManager.requestData(Reperto.class, params);
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        /*Image img = null;
        try {
            img = dataManager.requestImage(room.getFotoURL());
            img = new ImageIcon(img).getImage().getScaledInstance(440, 220, Image.SCALE_SMOOTH);
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }*/

        params = new HashMap<>();
        params.put("type", "specie");
        params.put("codice", "" + find.getSpecie());
        Specie specie;
        try {
            specie = dataManager.requestData(Specie.class, params);
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        this.addMouseListener(new MouseEventManager(audioManager, pageManager, codice, "selectFind", backCodice));
        titoloElemento.setText(specie.getNome());
        descrizione.setText(find.getDescrizione());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        contenitoreImmagine = new javax.swing.JPanel();
        immagineElemento = new javax.swing.JLabel();
        pannelloDescrizione = new javax.swing.JPanel();
        contenitoreDescrizione = new javax.swing.JScrollPane();
        descrizione = new javax.swing.JTextArea();
        titoloElemento = new javax.swing.JLabel();

        setBackground(new java.awt.Color(35, 35, 35));
        setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        setLayout(null);

        contenitoreImmagine.setBackground(new java.awt.Color(20, 20, 20));

        javax.swing.GroupLayout contenitoreImmagineLayout = new javax.swing.GroupLayout(contenitoreImmagine);
        contenitoreImmagine.setLayout(contenitoreImmagineLayout);
        contenitoreImmagineLayout.setHorizontalGroup(
            contenitoreImmagineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(immagineElemento, javax.swing.GroupLayout.DEFAULT_SIZE, 350, Short.MAX_VALUE)
        );
        contenitoreImmagineLayout.setVerticalGroup(
            contenitoreImmagineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(immagineElemento, javax.swing.GroupLayout.DEFAULT_SIZE, 210, Short.MAX_VALUE)
        );

        add(contenitoreImmagine);
        contenitoreImmagine.setBounds(20, 20, 350, 210);

        pannelloDescrizione.setBackground(new java.awt.Color(20, 20, 20));

        contenitoreDescrizione.setBackground(new java.awt.Color(20, 20, 20));
        contenitoreDescrizione.setBorder(null);

        descrizione.setEditable(false);
        descrizione.setBackground(new java.awt.Color(20, 20, 20));
        descrizione.setColumns(20);
        descrizione.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        descrizione.setForeground(new java.awt.Color(255, 255, 255));
        descrizione.setLineWrap(true);
        descrizione.setRows(5);
        descrizione.setText("Morbi a mauris pulvinar, euismod quam eget, tempor ex. Nullam Morbi a mauris pulvinar, euismod quam eget, tempor ex. Nullam. Morbi a mauris pulvinar, euismod quam eget, tempor ex. Nullam");
        descrizione.setWrapStyleWord(true);
        descrizione.setBorder(null);
        descrizione.setFocusable(false);
        contenitoreDescrizione.setViewportView(descrizione);

        titoloElemento.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        titoloElemento.setForeground(new java.awt.Color(255, 255, 255));
        titoloElemento.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        titoloElemento.setText("Sala Cretaceo");

        javax.swing.GroupLayout pannelloDescrizioneLayout = new javax.swing.GroupLayout(pannelloDescrizione);
        pannelloDescrizione.setLayout(pannelloDescrizioneLayout);
        pannelloDescrizioneLayout.setHorizontalGroup(
            pannelloDescrizioneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pannelloDescrizioneLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(titoloElemento, javax.swing.GroupLayout.PREFERRED_SIZE, 414, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34))
            .addGroup(pannelloDescrizioneLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(contenitoreDescrizione, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(17, Short.MAX_VALUE))
        );
        pannelloDescrizioneLayout.setVerticalGroup(
            pannelloDescrizioneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pannelloDescrizioneLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(titoloElemento, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(contenitoreDescrizione, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        add(pannelloDescrizione);
        pannelloDescrizione.setBounds(770, 20, 484, 210);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane contenitoreDescrizione;
    private javax.swing.JPanel contenitoreImmagine;
    private javax.swing.JTextArea descrizione;
    private javax.swing.JLabel immagineElemento;
    private javax.swing.JPanel pannelloDescrizione;
    private javax.swing.JLabel titoloElemento;
    // End of variables declaration//GEN-END:variables
}

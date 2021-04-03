/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.pages;

import main.PageManager;
import main.audio.AudioManager;
import main.database.DataManager;

import java.awt.Color;

/**
 *
 * @author raffo
 */
public class TemplateElementoDx extends Page {

    /**
     * Creates new form TemplateElementoDx
     */
    public TemplateElementoDx(String titolo) {
        super("templateElemDx");
        initComponents();
        titoloElemento.setText(titolo);
    }

    @Override
    public void initPage(AudioManager audioManager, PageManager pageManager, DataManager dataManager) {

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

        contenitoreImmagine.setBackground(new java.awt.Color(0, 170, 72));

        immagineElemento.setBackground(new java.awt.Color(0, 170, 72));

        javax.swing.GroupLayout contenitoreImmagineLayout = new javax.swing.GroupLayout(contenitoreImmagine);
        contenitoreImmagine.setLayout(contenitoreImmagineLayout);
        contenitoreImmagineLayout.setHorizontalGroup(
            contenitoreImmagineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(immagineElemento, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 350, Short.MAX_VALUE)
        );
        contenitoreImmagineLayout.setVerticalGroup(
            contenitoreImmagineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(immagineElemento, javax.swing.GroupLayout.DEFAULT_SIZE, 204, Short.MAX_VALUE)
        );

        pannelloDescrizione.setBackground(new java.awt.Color(0, 170, 72));

        contenitoreDescrizione.setBorder(null);

        descrizione.setEditable(false);
        descrizione.setBackground(new java.awt.Color(0, 170, 72));
        descrizione.setColumns(20);
        descrizione.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        descrizione.setForeground(new java.awt.Color(255, 255, 255));
        descrizione.setLineWrap(true);
        descrizione.setRows(5);
        descrizione.setText("Morbi a mauris pulvinar, euismod quam eget, tempor ex. Nullam ");
        descrizione.setWrapStyleWord(true);
        descrizione.setBorder(null);
        descrizione.setFocusable(false);
        contenitoreDescrizione.setViewportView(descrizione);

        titoloElemento.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        titoloElemento.setForeground(new java.awt.Color(255, 255, 255));
        titoloElemento.setText("Sala Cretaceo");

        javax.swing.GroupLayout pannelloDescrizioneLayout = new javax.swing.GroupLayout(pannelloDescrizione);
        pannelloDescrizione.setLayout(pannelloDescrizioneLayout);
        pannelloDescrizioneLayout.setHorizontalGroup(
            pannelloDescrizioneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pannelloDescrizioneLayout.createSequentialGroup()
                .addContainerGap(12, Short.MAX_VALUE)
                .addGroup(pannelloDescrizioneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(titoloElemento, javax.swing.GroupLayout.PREFERRED_SIZE, 414, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(contenitoreDescrizione, javax.swing.GroupLayout.PREFERRED_SIZE, 457, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15))
        );
        pannelloDescrizioneLayout.setVerticalGroup(
            pannelloDescrizioneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pannelloDescrizioneLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(titoloElemento, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(contenitoreDescrizione, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pannelloDescrizione, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 392, Short.MAX_VALUE)
                .addComponent(contenitoreImmagine, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pannelloDescrizione, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(contenitoreImmagine, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(19, Short.MAX_VALUE))
        );
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

package main.pages;

import main.PageManager;
import main.audio.AudioManager;
import main.events.ButtonActionManager;

import javax.swing.*;
import java.awt.*;

/**
 * Classe che rappresenta un elemento dell'elenco di audioguide
 * @author Simone Raffo
 */
public class TemplateAudioguida extends JPanel {

    private int index;
    private ImageIcon playImg;
    private ImageIcon pauseImg;
    private ImageIcon playImgHover;
    private ImageIcon pauseImgHover;

    private boolean isAudioPaused;

    /**
     * Creates new form TemplateAudioguida
     */
    public TemplateAudioguida(int index, AudioManager audioManager, PageManager pageManager, Image bandiera, String trackName) {
        isAudioPaused = true;
        playImg = new ImageIcon(new ImageIcon(getClass().getResource("/playBtnImg.png")).getImage().getScaledInstance(32, 32, Image.SCALE_SMOOTH));
        pauseImg = new ImageIcon(new ImageIcon(getClass().getResource("/pauseBtnImg.png")).getImage().getScaledInstance(32, 32, Image.SCALE_SMOOTH));
        playImgHover = new ImageIcon(new ImageIcon(getClass().getResource("/playBtnImgHover.png")).getImage().getScaledInstance(32, 32, Image.SCALE_SMOOTH));
        pauseImgHover = new ImageIcon(new ImageIcon(getClass().getResource("/pauseBtnImgHover.png")).getImage().getScaledInstance(32, 32, Image.SCALE_SMOOTH));

        initComponents();
        jButton1.setIcon(playImg);
        this.index = index;
        jButton1.setActionCommand("audioStart-" + this.index);
        jButton1.addActionListener(new ButtonActionManager(audioManager, pageManager, index));
        jLabel1.setIcon(new ImageIcon(bandiera));
        jLabel2.setText(trackName);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 32767));
        jLabel2 = new javax.swing.JLabel();

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 100, Short.MAX_VALUE)
        );

        setBackground(new java.awt.Color(60, 53, 57));
        setPreferredSize(new java.awt.Dimension(224, 62));

        jButton1.setBorderPainted(false);
        jButton1.setContentAreaFilled(false);
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton1MouseExited(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(29, 29, 29)
                                                .addComponent(filler1, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)))
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(16, 16, 16))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(14, 14, 14)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                                .addComponent(filler1, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(11, 11, 11)
                                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(13, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1MouseEntered(java.awt.event.MouseEvent evt) {
        if(isAudioPaused)
            jButton1.setIcon(playImgHover);
        else jButton1.setIcon(pauseImgHover);
    }

    private void jButton1MouseExited(java.awt.event.MouseEvent evt) {
        if(isAudioPaused)
            jButton1.setIcon(playImg);
        else jButton1.setIcon(pauseImg);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.Box.Filler filler1;
    // End of variables declaration//GEN-END:variables

    public boolean isAudioPaused() {
        return isAudioPaused;
    }

    public void setAudioPaused(boolean audioPaused) {
        isAudioPaused = audioPaused;
    }

}

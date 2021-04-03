
package main.pages;

import main.PageManager;
import main.audio.AudioManager;
import main.database.DataManager;
import main.events.ActionEventManager;

import javax.swing.*;
import java.awt.*;

/**
 *
 * @author raffo
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
    public TemplateAudioguida(int index, AudioManager audioManager, PageManager pageManager) {
        isAudioPaused = true;
        playImg = new ImageIcon(new ImageIcon(getClass().getResource("/playBtnImg.png")).getImage().getScaledInstance(32, 32, Image.SCALE_SMOOTH));
        pauseImg = new ImageIcon(new ImageIcon(getClass().getResource("/pauseBtnImg.png")).getImage().getScaledInstance(32, 32, Image.SCALE_SMOOTH));
        playImgHover = new ImageIcon(new ImageIcon(getClass().getResource("/playBtnImgHover.png")).getImage().getScaledInstance(32, 32, Image.SCALE_SMOOTH));
        pauseImgHover = new ImageIcon(new ImageIcon(getClass().getResource("/pauseBtnImgHover.png")).getImage().getScaledInstance(32, 32, Image.SCALE_SMOOTH));

        initComponents();
        jButton1.setIcon(playImg);
        this.index = index;
        jButton1.setActionCommand("audioStart-" + this.index);
        jButton1.addActionListener(new ActionEventManager(audioManager, pageManager, index));
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
        jPanel2 = new javax.swing.JPanel();

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

        setBackground(new java.awt.Color(20, 20, 20));

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

        jPanel2.setBackground(new java.awt.Color(50, 50, 50));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 2, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
                        .addGroup(layout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 98, Short.MAX_VALUE)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap(11, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
                                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables

    public boolean isAudioPaused() {
        return isAudioPaused;
    }

    public void setAudioPaused(boolean audioPaused) {
        isAudioPaused = audioPaused;
    }

}

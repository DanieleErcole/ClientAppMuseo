
package main.pages;

import main.PageManager;
import main.audio.AudioManager;
import main.events.ButtonActionManager;

import java.awt.*;
import java.util.HashMap;
import javax.swing.*;

/**
 *
 * @author User
 */
public class RootPage extends JFrame {

    private ImageIcon playImg;
    private ImageIcon pauseImg;
    private ImageIcon stopImg;
    private ImageIcon precImg;
    private ImageIcon nextImg;
    private ImageIcon playImgHover;
    private ImageIcon pauseImgHover;
    private ImageIcon stopImgHover;
    private ImageIcon precImgHover;
    private ImageIcon nextImgHover;

    private ImageIcon backImg;
    private ImageIcon backImgHover;

    private boolean isAudioPaused;
    private HashMap<JButton, ButtonActionManager> audioActionlisteners;

    /**
     * Creates new form RootPage
     */
    public RootPage(AudioManager audioManager, PageManager pageManager) {
        super("Museo");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        audioActionlisteners = new HashMap<>();
        playImg = new ImageIcon(new ImageIcon(getClass().getResource("/playBtnImg.png")).getImage().getScaledInstance(38, 38, Image.SCALE_SMOOTH));
        precImg = new ImageIcon(new ImageIcon(getClass().getResource("/precBtnImg.png")).getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH));
        nextImg = new ImageIcon(new ImageIcon(getClass().getResource("/nextBtnImg.png")).getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH));
        pauseImg = new ImageIcon(new ImageIcon(getClass().getResource("/pauseBtnImg.png")).getImage().getScaledInstance(38, 38, Image.SCALE_SMOOTH));
        stopImg = new ImageIcon(new ImageIcon(getClass().getResource("/stopBtnImg.png")).getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH));
        backImg = new ImageIcon(new ImageIcon(getClass().getResource("/backBtnImg.png")).getImage().getScaledInstance(18, 18, Image.SCALE_SMOOTH));
        playImgHover = new ImageIcon(new ImageIcon(getClass().getResource("/playBtnImgHover.png")).getImage().getScaledInstance(38, 38, Image.SCALE_SMOOTH));
        precImgHover = new ImageIcon(new ImageIcon(getClass().getResource("/precBtnImgHover.png")).getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH));
        nextImgHover = new ImageIcon(new ImageIcon(getClass().getResource("/nextBtnImgHover.png")).getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH));
        pauseImgHover = new ImageIcon(new ImageIcon(getClass().getResource("/pauseBtnImgHover.png")).getImage().getScaledInstance(38, 38, Image.SCALE_SMOOTH));
        stopImgHover = new ImageIcon(new ImageIcon(getClass().getResource("/stopBtnImgHover.png")).getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH));
        backImgHover = new ImageIcon(new ImageIcon(getClass().getResource("/backBtnImgHover.png")).getImage().getScaledInstance(18, 18, Image.SCALE_SMOOTH));

        initComponents();
        rootPanel.getVerticalScrollBar().setUnitIncrement(25);
        centerButton.setIcon(pauseImg);
        precButton.setIcon(precImg);
        nextButton.setIcon(nextImg);
        stopButton.setIcon(stopImg);
        jButton3.setIcon(backImg);
        isAudioPaused = true;
        centerButton.setActionCommand("audioPause");
        nextButton.setActionCommand("audioNext");
        precButton.setActionCommand("audioPrevious");
        stopButton.setActionCommand("audioStop");
        stopButton.addActionListener(new ButtonActionManager(audioManager, pageManager, 0));
        jButton1.setActionCommand("logout");
        jButton1.addActionListener(new ButtonActionManager(audioManager, pageManager, 0));
        
        this.pack();
        this.setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        rootPanel = new javax.swing.JScrollPane();
        frameBar = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        audioBar = new javax.swing.JPanel();
        timeSlider = new javax.swing.JSlider();
        leftTimeLabel = new javax.swing.JLabel();
        rightTimeLabel = new javax.swing.JLabel();
        centerButton = new javax.swing.JButton();
        precButton = new javax.swing.JButton();
        nextButton = new javax.swing.JButton();
        titleLabel = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        stopButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        rootPanel.setBorder(null);
        rootPanel.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        frameBar.setBackground(new java.awt.Color(50, 44, 48));

        jButton1.setBackground(new java.awt.Color(66, 67, 68));
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Logout");
        jButton1.setActionCommand("logout");
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.setFocusPainted(false);

        jButton2.setBackground(new java.awt.Color(66, 67, 68));
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Website");
        jButton2.setActionCommand("website");
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.setFocusPainted(false);

        jButton3.setContentAreaFilled(false);
        jButton3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton3MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton3MouseExited(evt);
            }
        });

        javax.swing.GroupLayout frameBarLayout = new javax.swing.GroupLayout(frameBar);
        frameBar.setLayout(frameBarLayout);
        frameBarLayout.setHorizontalGroup(
                frameBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, frameBarLayout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton1)
                                .addContainerGap())
        );
        frameBarLayout.setVerticalGroup(
                frameBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, frameBarLayout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addGroup(frameBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jButton1)
                                        .addComponent(jButton2)
                                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(3, 3, 3))
        );

        audioBar.setBackground(new java.awt.Color(50, 44, 48));
        audioBar.setPreferredSize(new java.awt.Dimension(1250, 75));

        timeSlider.setForeground(new java.awt.Color(215, 201, 104));
        timeSlider.setValue(0);
        timeSlider.setFocusable(false);

        leftTimeLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        leftTimeLabel.setForeground(new java.awt.Color(255, 255, 255));
        leftTimeLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        leftTimeLabel.setText("--:--");

        rightTimeLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        rightTimeLabel.setForeground(new java.awt.Color(255, 255, 255));
        rightTimeLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        rightTimeLabel.setText("--:--");

        centerButton.setBorderPainted(false);
        centerButton.setContentAreaFilled(false);
        centerButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        centerButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                centerButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                centerButtonMouseExited(evt);
            }
        });

        precButton.setBorderPainted(false);
        precButton.setContentAreaFilled(false);
        precButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        precButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                precButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                precButtonMouseExited(evt);
            }
        });

        nextButton.setBorderPainted(false);
        nextButton.setContentAreaFilled(false);
        nextButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        nextButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                nextButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                nextButtonMouseExited(evt);
            }
        });

        titleLabel.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        titleLabel.setForeground(new java.awt.Color(255, 255, 255));
        titleLabel.setText("Titolo traccia");

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setPreferredSize(new java.awt.Dimension(46, 33));

        stopButton.setBorderPainted(false);
        stopButton.setContentAreaFilled(false);
        stopButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                stopButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                stopButtonMouseExited(evt);
            }
        });

        javax.swing.GroupLayout audioBarLayout = new javax.swing.GroupLayout(audioBar);
        audioBar.setLayout(audioBarLayout);
        audioBarLayout.setHorizontalGroup(
                audioBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(audioBarLayout.createSequentialGroup()
                                .addGroup(audioBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(audioBarLayout.createSequentialGroup()
                                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(leftTimeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(timeSlider, javax.swing.GroupLayout.PREFERRED_SIZE, 830, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(rightTimeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(88, 88, 88))
                                        .addGroup(audioBarLayout.createSequentialGroup()
                                                .addGap(14, 14, 14)
                                                .addComponent(titleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(precButton, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(centerButton, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(nextButton, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(29, 29, 29)
                                                .addComponent(stopButton, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(406, 406, 406)))
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(26, 26, 26))
        );
        audioBarLayout.setVerticalGroup(
                audioBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(audioBarLayout.createSequentialGroup()
                                .addGroup(audioBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, audioBarLayout.createSequentialGroup()
                                                .addGap(0, 0, Short.MAX_VALUE)
                                                .addComponent(stopButton, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(10, 10, 10))
                                        .addGroup(audioBarLayout.createSequentialGroup()
                                                .addGap(4, 4, 4)
                                                .addGroup(audioBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(precButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addGroup(audioBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                                .addComponent(nextButton, javax.swing.GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE)
                                                                .addComponent(centerButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addComponent(titleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                .addGap(1, 1, 1)))
                                .addGroup(audioBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(timeSlider, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(leftTimeLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(rightTimeLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap())
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, audioBarLayout.createSequentialGroup()
                                .addGap(17, 17, 17)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(rootPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 1250, Short.MAX_VALUE)
                        .addComponent(frameBar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(audioBar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(frameBar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(rootPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(audioBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void setPage(Page page) {
        rootPanel.setViewportView(page);
    }
    
    public void hideAudioBar(int newWidth) {
        centerButton.removeActionListener(audioActionlisteners.get(centerButton));
        precButton.removeActionListener(audioActionlisteners.get(precButton));
        nextButton.removeActionListener(audioActionlisteners.get(nextButton));
        audioActionlisteners = new HashMap<>();

        frameBar.setSize(newWidth, 28);
        frameBar.setPreferredSize(new Dimension(newWidth, 28));
        rootPanel.setSize(newWidth, 600);
        rootPanel.setPreferredSize(new Dimension(newWidth, 600));
        audioBar.setSize(0, 0);
        audioBar.setPreferredSize(new Dimension(0, 0));
    }
    
    public void showAudioBar(AudioManager audioManager, PageManager pageManager) {
        ButtonActionManager listener = new ButtonActionManager(audioManager, pageManager, 0);
        centerButton.addActionListener(listener);
        audioActionlisteners.put(centerButton, listener);
        listener = new ButtonActionManager(audioManager, pageManager, audioManager.getCurrentTrack().getIndex());
        precButton.addActionListener(listener);
        nextButton.addActionListener(listener);
        audioActionlisteners.put(precButton, listener);
        audioActionlisteners.put(nextButton, listener);

        frameBar.setSize(1250, 28);
        frameBar.setPreferredSize(new Dimension(1250, 28));
        rootPanel.setSize(1250, 600);
        rootPanel.setPreferredSize(new Dimension(1250, 600));
        audioBar.setSize(1250, 75);
        audioBar.setPreferredSize(new Dimension(1250, 75));
    }

    private void centerButtonMouseEntered(java.awt.event.MouseEvent evt) {
        if(isAudioPaused)
            centerButton.setIcon(playImgHover);
        else centerButton.setIcon(pauseImgHover);
    }

    private void centerButtonMouseExited(java.awt.event.MouseEvent evt) {
        if(isAudioPaused)
            centerButton.setIcon(playImg);
        else centerButton.setIcon(pauseImg);
    }

    private void precButtonMouseEntered(java.awt.event.MouseEvent evt) {
        precButton.setIcon(precImgHover);
    }

    private void precButtonMouseExited(java.awt.event.MouseEvent evt) {
        precButton.setIcon(precImg);
    }

    private void nextButtonMouseEntered(java.awt.event.MouseEvent evt) {
        nextButton.setIcon(nextImgHover);
    }

    private void nextButtonMouseExited(java.awt.event.MouseEvent evt) {
        nextButton.setIcon(nextImg);
    }

    private void stopButtonMouseEntered(java.awt.event.MouseEvent evt) {
        stopButton.setIcon(stopImgHover);
    }

    private void stopButtonMouseExited(java.awt.event.MouseEvent evt) {
        stopButton.setIcon(stopImg);
    }

    private void jButton3MouseEntered(java.awt.event.MouseEvent evt) {
        jButton3.setIcon(backImgHover);
    }

    private void jButton3MouseExited(java.awt.event.MouseEvent evt) {
        jButton3.setIcon(backImg);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel audioBar;
    private javax.swing.JButton centerButton;
    private javax.swing.JPanel frameBar;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel leftTimeLabel;
    private javax.swing.JButton nextButton;
    private javax.swing.JButton precButton;
    private javax.swing.JLabel rightTimeLabel;
    private javax.swing.JScrollPane rootPanel;
    private javax.swing.JSlider timeSlider;
    private javax.swing.JLabel titleLabel;
    private javax.swing.JButton stopButton;
    // End of variables declaration//GEN-END:variables

    public JButton getCenterButton() {
        return centerButton;
    }

    public JLabel getLeftTimeLabel() {
        return leftTimeLabel;
    }

    public JLabel getRightTimeLabel() {
        return rightTimeLabel;
    }

    public JSlider getTimeSlider() {
        return timeSlider;
    }

    public JLabel getTitleLabel() {
        return titleLabel;
    }

    public boolean isAudioPaused() {
        return isAudioPaused;
    }

    public JButton getBackButton() {
        return jButton3;
    }

    public void setAudioPaused(boolean audioPaused) {
        isAudioPaused = audioPaused;
    }

}

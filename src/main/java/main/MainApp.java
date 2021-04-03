package main;

import com.formdev.flatlaf.FlatDarkLaf;
import main.audio.AudioManager;
import main.events.AudioSliderListener;
import main.events.MouseSliderListener;
import main.pages.*;

import javax.swing.*;
import java.awt.*;

public class MainApp {

    private final PageManager pageManager;
    private final AudioManager audioManager;
    private final AudioSliderListener changeListener;
    private final MouseSliderListener mouseSliderListener;

    public MainApp() {
        audioManager = new AudioManager();
        pageManager = new PageManager(audioManager);
        mouseSliderListener = new MouseSliderListener(pageManager);
        changeListener = new AudioSliderListener(audioManager, mouseSliderListener);
    }

    public void startApplication() {
        //InitialPage initial = new InitialPage(audioManager, pageManager, "initial");
        //pageManager.changePage(initial, audioManager);
        PaginaInformazioniReperto findInfo = new PaginaInformazioniReperto(audioManager, pageManager, 0);
        pageManager.changePage(findInfo, audioManager);

        pageManager.getRootPage().getTimeSlider().addChangeListener(changeListener);
        pageManager.getRootPage().getTimeSlider().addMouseListener(mouseSliderListener);
        audioManager.initAudioTimer(pageManager.getRootPage(), changeListener);

        //TODO: test audio
        pageManager.getRootPage().setAudioPaused(false);
        audioManager.addTrack(getClass().getResource("/AudioTest/Hollow Knight - Sealed Vessel - Path of Pain Music.wav"), false);
        pageManager.getRootPage().getTimeSlider().setMaximum(audioManager.getCurrentTrack().getThisClip().getFrameLength());
        audioManager.startTrack();

        /*root.getContentPane().setSize(800, 600);
        root.getContentPane().setPreferredSize(new Dimension(800, 600));
        root.pack();
        root.hideAudioBar(800);
        root.setPage(new SignUpPage(audioManager, pageManager, "login"));*/
        pageManager.getRootPage().setVisible(true);
    }

    public static void main(String[] args) {
        FlatDarkLaf.install();

        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("com.formdev.flatlaf".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        EventQueue.invokeLater(new Runnable() {
            public void run() {
               new MainApp().startApplication();
            }
        });
    }

}

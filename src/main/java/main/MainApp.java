package main;

import com.formdev.flatlaf.FlatDarkLaf;
import main.audio.AudioManager;
import main.events.AudioSliderListener;
import main.pages.InitialPage;
import main.pages.LoginPage;
import main.pages.RootPage;
import main.pages.SignUpPage;

import javax.sound.sampled.LineEvent;
import javax.sound.sampled.LineListener;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MainApp {

    private final PageManager pageManager;
    private final AudioManager audioManager;
    private final AudioSliderListener changeListener;

    public static boolean clicked = false;
    public static int valueClicked = 0;

    public MainApp() {
        audioManager = new AudioManager();
        pageManager = new PageManager(audioManager);
        changeListener = new AudioSliderListener(audioManager);
    }

    public void startApplication() {
        InitialPage initial = new InitialPage(audioManager, pageManager, "initial");
        pageManager.changePage(initial, audioManager);
        pageManager.getRootPage().getTimeSlider().addChangeListener(changeListener);
        pageManager.getRootPage().getTimeSlider().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                if(!MainApp.clicked) {
                    MainApp.clicked = true;
                    MainApp.valueClicked = pageManager.getRootPage().getTimeSlider().getValue();
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {
                MainApp.clicked = true;
                MainApp.valueClicked = pageManager.getRootPage().getTimeSlider().getValue();
            }
        });
        audioManager.initAudioTimer(pageManager.getRootPage(), changeListener);
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

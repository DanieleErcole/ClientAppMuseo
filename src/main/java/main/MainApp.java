package main;

import com.formdev.flatlaf.FlatDarkLaf;
import main.audio.AudioManager;
import main.pages.InitialPage;
import main.pages.LoginPage;
import main.pages.RootPage;
import main.pages.SignUpPage;

import javax.swing.*;
import java.awt.*;

public class MainApp {

    private final PageManager pageManager;
    private final AudioManager audioManager;

    public MainApp() {
        audioManager = new AudioManager();
        pageManager = new PageManager(audioManager);
    }

    public void startApplication() {
        InitialPage initial = new InitialPage(audioManager, pageManager, "initial");
        /*root.getContentPane().setSize(800, 600);
        root.getContentPane().setPreferredSize(new Dimension(800, 600));
        root.pack();
        root.hideAudioBar(800);
        root.setPage(new SignUpPage(audioManager, pageManager, "login"));*/
        pageManager.changePage(initial, audioManager);
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

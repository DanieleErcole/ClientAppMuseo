package main;

import com.formdev.flatlaf.FlatDarkLaf;
import main.audio.AudioManager;
import main.events.SliderChangeListener;
import main.events.SliderMouseListener;
import main.pages.*;

import javax.swing.*;
import java.awt.*;

/**
 * Classe principale dell'applicazione, si occupa dell'inizializzazione e dell'avvio della stessa
 * @author Daniele Pelizzoni e Simone Raffo
 */
public class MainApp {

    private final PageManager pageManager;
    private final AudioManager audioManager;
    private final SliderChangeListener changeListener;
    private final SliderMouseListener sliderMouseListener;

    public MainApp() {
        audioManager = new AudioManager();
        pageManager = new PageManager(audioManager);
        sliderMouseListener = new SliderMouseListener(pageManager);
        changeListener = new SliderChangeListener(audioManager, sliderMouseListener);
    }

    public void startApplication() {
        pageManager.getRootPage().getTimeSlider().addChangeListener(changeListener);
        pageManager.getRootPage().getTimeSlider().addMouseListener(sliderMouseListener);
        audioManager.initAudioTimer(pageManager.getRootPage(), changeListener);

        LoginPage page = new LoginPage(audioManager, pageManager, "login");
        pageManager.getRootPage().getContentPane().setSize(800, 600);
        pageManager.getRootPage().getContentPane().setPreferredSize(new Dimension(800, 600));
        pageManager.getRootPage().pack();
        pageManager.getRootPage().hideAudioBar(800);
        pageManager.changePage(page, audioManager);
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

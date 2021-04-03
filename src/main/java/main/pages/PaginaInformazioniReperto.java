/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.pages;

import main.PageManager;
import main.audio.AudioManager;
import main.database.DataManager;
import main.database.Reperto;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.*;

/**
 *
 * @author raffo
 */
public class PaginaInformazioniReperto extends Page {

    private final int codice;
    private Reperto reperto;
    
    /**
     * Creates new form PaginaInformazioniReperto
     */
    public PaginaInformazioniReperto(AudioManager audioManager, PageManager pageManager, int codice) {
        super("FindInfo");
        initComponents();
        this.codice = codice;

        /*reperto = new Reperto("Dino Saurino", "a", "b", 1990, "");
        JPanel viewport = new JPanel(null);
        viewport.setBackground(new Color(20, 20, 20));
        viewport.setPreferredSize(new Dimension(228, reperto.getUrlAudioguide().size() * 62));
        for(int i = 0; i < reperto.getUrlAudioguide().size(); i++) {
            TemplateAudioguida template = new TemplateAudioguida(i, audioManager, pageManager);
            template.setLocation(0, i * 62);
            template.setSize(228, 62);
            viewport.add(template);
        }
        contenitoreAudioguide.setViewportView(viewport);

        JScrollBar scrollBar = new JScrollBar(JScrollBar.VERTICAL) {
            public boolean isVisible(){
                return true;
            }
        };
        contenitoreAudioguide.setVerticalScrollBar(scrollBar);
        contenitoreAudioguide.getVerticalScrollBar().setUnitIncrement(25);
        contenitoreAudioguide.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
        contenitoreDescrizione.setBorder(null);*/
    }

    @Override
    public void initPage(AudioManager audioManager, PageManager pageManager, DataManager dataManager) {
        HashMap<String, String> params = new HashMap<>();
        params.put("type", "reperto");
        params.put("codice", "" + codice);

        try {
            reperto = dataManager.requestData(Reperto.class, params);
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        Image img;
        params = new HashMap<>();
        params.put("reperto", "" + codice);
        try {
            img = dataManager.requestImage("req-image.php", params);
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }
        this.getAudioFiles(dataManager);

        JPanel viewport = new JPanel(null);
        viewport.setBackground(new Color(20, 20, 20));
        viewport.setPreferredSize(new Dimension(228, reperto.getUrlAudioguide().size() * 62));
        for(int i = 0; i < reperto.getUrlAudioguide().size(); i++) {
            TemplateAudioguida template = new TemplateAudioguida(i, audioManager, pageManager);
            template.setLocation(0, i * 62);
            template.setSize(228, 62);
            viewport.add(template);
        }
        contenitoreAudioguide.setViewportView(viewport);
        JScrollBar scrollBar = new JScrollBar(JScrollBar.VERTICAL) {
            public boolean isVisible(){
                return true;
            }
        };
        contenitoreAudioguide.setVerticalScrollBar(scrollBar);
        contenitoreAudioguide.getVerticalScrollBar().setUnitIncrement(25);
        contenitoreAudioguide.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
        contenitoreDescrizione.setBorder(null);

        ritrovamentoReperto.setText(reperto.getLuogoRitrovamento() + ", " + reperto.getAnnoRitrovamento());
        genereReperto.setText(reperto.getSpecie().getGenere());
        ordineReperto.setText(reperto.getSpecie().getOrdine());
        phylumReperto.setText(reperto.getSpecie().getPhylum());
        specieReperto.setText(reperto.getSpecie().getNome());
        famigliaReperto.setText(reperto.getSpecie().getFamiglia());
        classeReperto.setText(reperto.getSpecie().getClasse());
        regnoReperto.setText(reperto.getSpecie().getRegno());
        descrizioneReperto.setText(reperto.getDescrizione());

        immagine3.setIcon(new ImageIcon(img));
    }

    private void getAudioFiles(DataManager dataManager) {
        ArrayList<String> languages = new ArrayList<>();
        languages.add("italiano");
        languages.add("inglese");
        languages.add("spagnolo");
        languages.add("tedesco");
        languages.add("francese");
        languages.add("portoghese");
        languages.add("cinese");
        languages.add("giapponese");
        languages.add("russo");
        languages.add("coreano");

        HashMap<String, String> params;
        for(String lang : languages) {
            params = new HashMap<>();
            params.put("lingua", lang);
            params.put("reperto", "" + codice);
            try {
                File audioFile = dataManager.requestFile("audio-file.php", params, "audio-" + codice + "-" + lang + ".wav");
                String filePath = dataManager.insertFile(audioFile);
                reperto.getUrlAudioguide().add(filePath);
            } catch (IOException e) {
                e.printStackTrace();
                break;
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

        pannelloRitrovamento = new javax.swing.JPanel();
        ritrovamentoReperto = new javax.swing.JLabel();
        pannelloSpecie = new javax.swing.JPanel();
        specieReperto = new javax.swing.JLabel();
        pannelloGenere = new javax.swing.JPanel();
        genereReperto = new javax.swing.JLabel();
        pannelloFamiglia = new javax.swing.JPanel();
        famigliaReperto = new javax.swing.JLabel();
        pannelloOrdine = new javax.swing.JPanel();
        ordineReperto = new javax.swing.JLabel();
        pannelloClasse = new javax.swing.JPanel();
        classeReperto = new javax.swing.JLabel();
        pannelloPhylum = new javax.swing.JPanel();
        phylumReperto = new javax.swing.JLabel();
        pannelloRegno = new javax.swing.JPanel();
        regnoReperto = new javax.swing.JLabel();
        contenitorePannelloDescrizione = new javax.swing.JPanel();
        contenitoreDescrizione = new javax.swing.JScrollPane();
        descrizioneReperto = new javax.swing.JTextArea();
        pannelloImmagine3 = new javax.swing.JPanel();
        immagine3 = new javax.swing.JLabel();
        contenitoreTitolo = new javax.swing.JPanel();
        titoloReperto = new javax.swing.JLabel();
        canvasReperto3D = new javax.swing.JPanel();
        pannelloAudioguide = new javax.swing.JPanel();
        nomePannello = new javax.swing.JLabel();
        separatoreNome = new javax.swing.JPanel();
        contenitoreAudioguide = new javax.swing.JScrollPane();

        setBackground(new java.awt.Color(34, 34, 34));
        setLayout(null);

        pannelloRitrovamento.setBackground(new java.awt.Color(50, 50, 50));
        pannelloRitrovamento.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(50, 50, 50)), "Ritrovamento"));

        ritrovamentoReperto.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        ritrovamentoReperto.setForeground(new java.awt.Color(255, 255, 255));
        ritrovamentoReperto.setText("Francia, 05-10-1990");

        javax.swing.GroupLayout pannelloRitrovamentoLayout = new javax.swing.GroupLayout(pannelloRitrovamento);
        pannelloRitrovamento.setLayout(pannelloRitrovamentoLayout);
        pannelloRitrovamentoLayout.setHorizontalGroup(
            pannelloRitrovamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pannelloRitrovamentoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ritrovamentoReperto, javax.swing.GroupLayout.DEFAULT_SIZE, 198, Short.MAX_VALUE)
                .addContainerGap())
        );
        pannelloRitrovamentoLayout.setVerticalGroup(
            pannelloRitrovamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(ritrovamentoReperto, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        add(pannelloRitrovamento);
        pannelloRitrovamento.setBounds(40, 90, 230, 53);

        pannelloSpecie.setBackground(new java.awt.Color(50, 50, 50));
        pannelloSpecie.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(50, 50, 50)), "Specie"));

        specieReperto.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        specieReperto.setForeground(new java.awt.Color(255, 255, 255));
        specieReperto.setText("Tyrannosaurus Rex");

        javax.swing.GroupLayout pannelloSpecieLayout = new javax.swing.GroupLayout(pannelloSpecie);
        pannelloSpecie.setLayout(pannelloSpecieLayout);
        pannelloSpecieLayout.setHorizontalGroup(
            pannelloSpecieLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pannelloSpecieLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(specieReperto, javax.swing.GroupLayout.DEFAULT_SIZE, 218, Short.MAX_VALUE)
                .addContainerGap())
        );
        pannelloSpecieLayout.setVerticalGroup(
            pannelloSpecieLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(specieReperto, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
        );

        add(pannelloSpecie);
        pannelloSpecie.setBounds(270, 90, 240, 53);

        pannelloGenere.setBackground(new java.awt.Color(50, 50, 50));
        pannelloGenere.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(50, 50, 50)), "Genere"));

        genereReperto.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        genereReperto.setForeground(new java.awt.Color(255, 255, 255));
        genereReperto.setText("Tyrannosaurus");

        javax.swing.GroupLayout pannelloGenereLayout = new javax.swing.GroupLayout(pannelloGenere);
        pannelloGenere.setLayout(pannelloGenereLayout);
        pannelloGenereLayout.setHorizontalGroup(
            pannelloGenereLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pannelloGenereLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(genereReperto, javax.swing.GroupLayout.DEFAULT_SIZE, 208, Short.MAX_VALUE)
                .addContainerGap())
        );
        pannelloGenereLayout.setVerticalGroup(
            pannelloGenereLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(genereReperto, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        add(pannelloGenere);
        pannelloGenere.setBounds(40, 140, 230, 53);

        pannelloFamiglia.setBackground(new java.awt.Color(50, 50, 50));
        pannelloFamiglia.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(50, 50, 50)), "Famiglia"));

        famigliaReperto.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        famigliaReperto.setForeground(new java.awt.Color(255, 255, 255));
        famigliaReperto.setText("Tyrannosauridae");

        javax.swing.GroupLayout pannelloFamigliaLayout = new javax.swing.GroupLayout(pannelloFamiglia);
        pannelloFamiglia.setLayout(pannelloFamigliaLayout);
        pannelloFamigliaLayout.setHorizontalGroup(
            pannelloFamigliaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pannelloFamigliaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(famigliaReperto, javax.swing.GroupLayout.DEFAULT_SIZE, 208, Short.MAX_VALUE)
                .addContainerGap())
        );
        pannelloFamigliaLayout.setVerticalGroup(
            pannelloFamigliaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(famigliaReperto, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        add(pannelloFamiglia);
        pannelloFamiglia.setBounds(270, 140, 240, 53);

        pannelloOrdine.setBackground(new java.awt.Color(50, 50, 50));
        pannelloOrdine.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(50, 50, 50)), "Ordine"));

        ordineReperto.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        ordineReperto.setForeground(new java.awt.Color(255, 255, 255));
        ordineReperto.setText("Saurischia");

        javax.swing.GroupLayout pannelloOrdineLayout = new javax.swing.GroupLayout(pannelloOrdine);
        pannelloOrdine.setLayout(pannelloOrdineLayout);
        pannelloOrdineLayout.setHorizontalGroup(
            pannelloOrdineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pannelloOrdineLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ordineReperto, javax.swing.GroupLayout.DEFAULT_SIZE, 208, Short.MAX_VALUE)
                .addContainerGap())
        );
        pannelloOrdineLayout.setVerticalGroup(
            pannelloOrdineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(ordineReperto, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        add(pannelloOrdine);
        pannelloOrdine.setBounds(40, 190, 230, 53);

        pannelloClasse.setBackground(new java.awt.Color(50, 50, 50));
        pannelloClasse.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(50, 50, 50)), "Classe"));

        classeReperto.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        classeReperto.setForeground(new java.awt.Color(255, 255, 255));
        classeReperto.setText("Sauropsida");

        javax.swing.GroupLayout pannelloClasseLayout = new javax.swing.GroupLayout(pannelloClasse);
        pannelloClasse.setLayout(pannelloClasseLayout);
        pannelloClasseLayout.setHorizontalGroup(
            pannelloClasseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pannelloClasseLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(classeReperto, javax.swing.GroupLayout.DEFAULT_SIZE, 208, Short.MAX_VALUE)
                .addContainerGap())
        );
        pannelloClasseLayout.setVerticalGroup(
            pannelloClasseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(classeReperto, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        add(pannelloClasse);
        pannelloClasse.setBounds(270, 190, 240, 53);

        pannelloPhylum.setBackground(new java.awt.Color(50, 50, 50));
        pannelloPhylum.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(50, 50, 50)), "Phylum"));

        phylumReperto.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        phylumReperto.setForeground(new java.awt.Color(255, 255, 255));
        phylumReperto.setText("Chordata");

        javax.swing.GroupLayout pannelloPhylumLayout = new javax.swing.GroupLayout(pannelloPhylum);
        pannelloPhylum.setLayout(pannelloPhylumLayout);
        pannelloPhylumLayout.setHorizontalGroup(
            pannelloPhylumLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pannelloPhylumLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(phylumReperto, javax.swing.GroupLayout.DEFAULT_SIZE, 198, Short.MAX_VALUE)
                .addContainerGap())
        );
        pannelloPhylumLayout.setVerticalGroup(
            pannelloPhylumLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(phylumReperto, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        add(pannelloPhylum);
        pannelloPhylum.setBounds(40, 240, 230, 53);

        pannelloRegno.setBackground(new java.awt.Color(50, 50, 50));
        pannelloRegno.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(50, 50, 50)), "Regno"));

        regnoReperto.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        regnoReperto.setForeground(new java.awt.Color(255, 255, 255));
        regnoReperto.setText("Animalia");

        javax.swing.GroupLayout pannelloRegnoLayout = new javax.swing.GroupLayout(pannelloRegno);
        pannelloRegno.setLayout(pannelloRegnoLayout);
        pannelloRegnoLayout.setHorizontalGroup(
            pannelloRegnoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pannelloRegnoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(regnoReperto, javax.swing.GroupLayout.DEFAULT_SIZE, 208, Short.MAX_VALUE)
                .addContainerGap())
        );
        pannelloRegnoLayout.setVerticalGroup(
            pannelloRegnoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(regnoReperto, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        add(pannelloRegno);
        pannelloRegno.setBounds(270, 240, 240, 53);

        contenitorePannelloDescrizione.setBackground(new java.awt.Color(50, 50, 50));
        contenitorePannelloDescrizione.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(50, 50, 50)), "Descrizione"));

        contenitoreDescrizione.setBorder(null);

        descrizioneReperto.setBackground(new java.awt.Color(50, 50, 50));
        descrizioneReperto.setColumns(20);
        descrizioneReperto.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        descrizioneReperto.setForeground(new java.awt.Color(255, 255, 255));
        descrizioneReperto.setLineWrap(true);
        descrizioneReperto.setRows(5);
        descrizioneReperto.setText("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nulla quis venenatis tortor. In pretium, velit et congue tempor, odio dolor vestibulum felis, eget lacinia augue ante a dui. Nullam elementum mi in lacinia commodo. Cras vestibulum sapien nec varius lacinia. Quisque ac molestie nisl. Aenean sodales metus odio, id tempor ligula dictum at. Maecenas eleifend tellus at rutrum interdum. Etiam ultricies ligula et turpis convallis, vitae rhoncus sapien iaculis. Mauris posuer cursus. Aliquam maximus molestie blandit. Mauris vulputate auctor neque, faucibus volutpat magna tincidunt aliquam. Vivamus lobortis vel augue vel ultricies. In ut urna dolor. Phasellus gravida malesuada sem vel auctor. Duis maximus mauris at semper cursus.\n\n\n");
        descrizioneReperto.setWrapStyleWord(true);
        descrizioneReperto.setBorder(null);
        descrizioneReperto.setFocusable(false);
        descrizioneReperto.setPreferredSize(new java.awt.Dimension(272, 117));
        contenitoreDescrizione.setViewportView(descrizioneReperto);

        javax.swing.GroupLayout contenitorePannelloDescrizioneLayout = new javax.swing.GroupLayout(contenitorePannelloDescrizione);
        contenitorePannelloDescrizione.setLayout(contenitorePannelloDescrizioneLayout);
        contenitorePannelloDescrizioneLayout.setHorizontalGroup(
            contenitorePannelloDescrizioneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, contenitorePannelloDescrizioneLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(contenitoreDescrizione, javax.swing.GroupLayout.DEFAULT_SIZE, 468, Short.MAX_VALUE)
                .addContainerGap())
        );
        contenitorePannelloDescrizioneLayout.setVerticalGroup(
            contenitorePannelloDescrizioneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, contenitorePannelloDescrizioneLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(contenitoreDescrizione, javax.swing.GroupLayout.DEFAULT_SIZE, 215, Short.MAX_VALUE)
                .addContainerGap())
        );

        add(contenitorePannelloDescrizione);
        contenitorePannelloDescrizione.setBounds(30, 320, 490, 250);

        pannelloImmagine3.setBackground(new java.awt.Color(34, 34, 34));

        immagine3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        immagine3.setPreferredSize(new java.awt.Dimension(225, 300));

        javax.swing.GroupLayout pannelloImmagine3Layout = new javax.swing.GroupLayout(pannelloImmagine3);
        pannelloImmagine3.setLayout(pannelloImmagine3Layout);
        pannelloImmagine3Layout.setHorizontalGroup(
            pannelloImmagine3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pannelloImmagine3Layout.createSequentialGroup()
                .addComponent(immagine3, javax.swing.GroupLayout.PREFERRED_SIZE, 442, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        pannelloImmagine3Layout.setVerticalGroup(
            pannelloImmagine3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pannelloImmagine3Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(immagine3, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        add(pannelloImmagine3);
        pannelloImmagine3.setBounds(550, 90, 390, 220);

        contenitoreTitolo.setBackground(new java.awt.Color(34, 34, 34));

        titoloReperto.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        titoloReperto.setForeground(new java.awt.Color(255, 255, 255));
        titoloReperto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titoloReperto.setText("Dino Saurino");

        javax.swing.GroupLayout contenitoreTitoloLayout = new javax.swing.GroupLayout(contenitoreTitolo);
        contenitoreTitolo.setLayout(contenitoreTitoloLayout);
        contenitoreTitoloLayout.setHorizontalGroup(
            contenitoreTitoloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, contenitoreTitoloLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(titoloReperto, javax.swing.GroupLayout.DEFAULT_SIZE, 950, Short.MAX_VALUE)
                .addContainerGap())
        );
        contenitoreTitoloLayout.setVerticalGroup(
            contenitoreTitoloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contenitoreTitoloLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(titoloReperto, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
                .addContainerGap())
        );

        add(contenitoreTitolo);
        contenitoreTitolo.setBounds(0, 0, 970, 50);

        canvasReperto3D.setBackground(new java.awt.Color(34, 34, 34));

        javax.swing.GroupLayout canvasReperto3DLayout = new javax.swing.GroupLayout(canvasReperto3D);
        canvasReperto3D.setLayout(canvasReperto3DLayout);
        canvasReperto3DLayout.setHorizontalGroup(
            canvasReperto3DLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 440, Short.MAX_VALUE)
        );
        canvasReperto3DLayout.setVerticalGroup(
            canvasReperto3DLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 240, Short.MAX_VALUE)
        );

        add(canvasReperto3D);
        canvasReperto3D.setBounds(550, 330, 440, 240);

        pannelloAudioguide.setBackground(new java.awt.Color(20, 20, 20));
        pannelloAudioguide.setLayout(null);

        nomePannello.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        nomePannello.setForeground(new java.awt.Color(255, 255, 255));
        nomePannello.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        nomePannello.setText("Audioguide");
        pannelloAudioguide.add(nomePannello);
        nomePannello.setBounds(11, 22, 208, 25);

        separatoreNome.setBackground(new java.awt.Color(50, 50, 50));

        javax.swing.GroupLayout separatoreNomeLayout = new javax.swing.GroupLayout(separatoreNome);
        separatoreNome.setLayout(separatoreNomeLayout);
        separatoreNomeLayout.setHorizontalGroup(
            separatoreNomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 190, Short.MAX_VALUE)
        );
        separatoreNomeLayout.setVerticalGroup(
            separatoreNomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 4, Short.MAX_VALUE)
        );

        pannelloAudioguide.add(separatoreNome);
        separatoreNome.setBounds(21, 53, 190, 4);

        contenitoreAudioguide.setBackground(new java.awt.Color(20, 20, 20));
        contenitoreAudioguide.setBorder(null);
        contenitoreAudioguide.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        pannelloAudioguide.add(contenitoreAudioguide);
        contenitoreAudioguide.setBounds(0, 70, 228, 531);

        add(pannelloAudioguide);
        pannelloAudioguide.setBounds(1020, 0, 230, 600);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel canvasReperto3D;
    private javax.swing.JLabel classeReperto;
    private javax.swing.JScrollPane contenitoreAudioguide;
    private javax.swing.JScrollPane contenitoreDescrizione;
    private javax.swing.JPanel contenitorePannelloDescrizione;
    private javax.swing.JPanel contenitoreTitolo;
    private javax.swing.JTextArea descrizioneReperto;
    private javax.swing.JLabel famigliaReperto;
    private javax.swing.JLabel genereReperto;
    private javax.swing.JLabel immagine3;
    private javax.swing.JLabel nomePannello;
    private javax.swing.JLabel ordineReperto;
    private javax.swing.JPanel pannelloAudioguide;
    private javax.swing.JPanel pannelloClasse;
    private javax.swing.JPanel pannelloFamiglia;
    private javax.swing.JPanel pannelloGenere;
    private javax.swing.JPanel pannelloImmagine3;
    private javax.swing.JPanel pannelloOrdine;
    private javax.swing.JPanel pannelloPhylum;
    private javax.swing.JPanel pannelloRegno;
    private javax.swing.JPanel pannelloRitrovamento;
    private javax.swing.JPanel pannelloSpecie;
    private javax.swing.JLabel phylumReperto;
    private javax.swing.JLabel regnoReperto;
    private javax.swing.JLabel ritrovamentoReperto;
    private javax.swing.JPanel separatoreNome;
    private javax.swing.JLabel specieReperto;
    private javax.swing.JLabel titoloReperto;
    // End of variables declaration//GEN-END:variables
}

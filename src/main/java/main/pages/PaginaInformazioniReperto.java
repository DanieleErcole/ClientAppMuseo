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
import main.database.Specie;
import main.visualization.Visualizzatore3D;

import java.awt.*;
import java.io.IOException;
import java.net.MalformedURLException;
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

        JScrollBar scrollBar = new JScrollBar(JScrollBar.VERTICAL) {
            public boolean isVisible(){
                return true;
            }
        };
        contenitoreAudioguide.setVerticalScrollBar(scrollBar);
        contenitoreAudioguide.getVerticalScrollBar().setUnitIncrement(25);
        contenitoreAudioguide.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
        contenitoreDescrizione.setBorder(null);
    }

    @Override
    public void initPage(AudioManager audioManager, PageManager pageManager, DataManager dataManager) {
        HashMap<String, String> params = new HashMap<>();
        params.put("type", "reperto");
        params.put("codice", "" + codice);

        Specie specie;
        try {
            reperto = dataManager.requestData(Reperto.class, params);
            params = new HashMap<>();
            params.put("type", "specie");
            params.put("codice", "" + reperto.getSpecie());
            specie = dataManager.requestData(Specie.class, params);
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

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
        HashMap<String, String> bandiere = this.getBandiere(languages);

        //File audio
        this.getAudioFiles(dataManager, languages);
        audioManager.setFind(reperto);
        JPanel viewport = new JPanel(null);
        viewport.setBackground(new Color(20, 20, 20));
        viewport.setPreferredSize(new Dimension(228, reperto.getUrlAudioguide().size() * 62));
        for(int i = 0; i < reperto.getUrlAudioguide().size(); i++) {
            String[] array = reperto.getUrlAudioguide().get(i).getPath().split("/");
            TemplateAudioguida template = new TemplateAudioguida(i, audioManager, pageManager, new ImageIcon(getClass().getResource(
                    "/" + bandiere.get(languages.get(i)))).getImage().getScaledInstance(42, 31, Image.SCALE_SMOOTH), array[array.length - 1]);
            template.setLocation(0, i * 62);
            template.setSize(228, 62);
            viewport.add(template);
        }
        contenitoreAudioguide.setViewportView(viewport);

        //Modello 3D e visualizzazione
        try {
            canvasReperto3D.add(new Visualizzatore3D(dataManager.requestFile(
                    reperto.getMesh3DURL(), "Modelli"),
                    canvasReperto3D.getWidth(),
                    canvasReperto3D.getHeight())
            );
            canvasReperto3D.repaint();
            canvasReperto3D.revalidate();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        //Testo
        ritrovamentoReperto.setText(reperto.getLuogoRitrovamento() + ", " + reperto.getAnnoRitrovamento());
        titoloReperto.setText(specie.getNome());
        genereReperto.setText(specie.getGenere());
        ordineReperto.setText(specie.getOrdine());
        phylumReperto.setText(specie.getPhylum());
        specieReperto.setText(specie.getNome());
        famigliaReperto.setText(specie.getFamiglia());
        classeReperto.setText(specie.getClasse());
        regnoReperto.setText(specie.getRegno());
        descrizioneReperto.setText(reperto.getDescrizione());
    }

    private void getAudioFiles(DataManager dataManager, ArrayList<String> languages) {
        HashMap<String, String> params;
        for(String lang : languages) {
            params = new HashMap<>();
            params.put("lingua", lang);
            params.put("reperto", "" + codice);
            try {
                reperto.getUrlAudioguide().add(dataManager.requestFile(codice + "_" + lang + ".wav", "Audio"));
            } catch (IOException e) {
                e.printStackTrace();
                break;
            }
        }
    }

    private HashMap<String, String> getBandiere(ArrayList<String> languages) {
        HashMap<String, String> bandiere = new HashMap<>();
        for(String lang : languages)
            bandiere.put(lang, lang + ".png");
        return bandiere;
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
        contenitoreTitolo = new javax.swing.JPanel();
        titoloReperto = new javax.swing.JLabel();
        canvasReperto3D = new javax.swing.JPanel();
        pannelloAudioguide = new javax.swing.JPanel();
        nomePannello = new javax.swing.JLabel();
        separatoreNome = new javax.swing.JPanel();
        contenitoreAudioguide = new javax.swing.JScrollPane();

        setBackground(new java.awt.Color(199, 190, 169));
        setLayout(null);

        pannelloRitrovamento.setBackground(new java.awt.Color(131, 123, 104));
        pannelloRitrovamento.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(131, 123, 104)), "Ritrovamento", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 12), new java.awt.Color(202, 202, 202))); // NOI18N

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
        pannelloRitrovamento.setBounds(520, 90, 230, 53);

        pannelloSpecie.setBackground(new java.awt.Color(131, 123, 104));
        pannelloSpecie.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(131, 123, 104)), "Specie", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 12), new java.awt.Color(202, 202, 202))); // NOI18N

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
        pannelloSpecie.setBounds(750, 90, 240, 53);

        pannelloGenere.setBackground(new java.awt.Color(131, 123, 104));
        pannelloGenere.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(131, 123, 104)), "Genere", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 12), new java.awt.Color(202, 202, 202))); // NOI18N

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
        pannelloGenere.setBounds(520, 140, 230, 53);

        pannelloFamiglia.setBackground(new java.awt.Color(131, 123, 104));
        pannelloFamiglia.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(131, 123, 104)), "Famiglia", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 12), new java.awt.Color(202, 202, 202))); // NOI18N

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
        pannelloFamiglia.setBounds(750, 140, 240, 53);

        pannelloOrdine.setBackground(new java.awt.Color(131, 123, 104));
        pannelloOrdine.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(131, 123, 104)), "Ordine", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 12), new java.awt.Color(202, 202, 202))); // NOI18N

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
        pannelloOrdine.setBounds(520, 190, 230, 53);

        pannelloClasse.setBackground(new java.awt.Color(131, 123, 104));
        pannelloClasse.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(131, 123, 104)), "Classe", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 12), new java.awt.Color(202, 202, 202))); // NOI18N

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
        pannelloClasse.setBounds(750, 190, 240, 53);

        pannelloPhylum.setBackground(new java.awt.Color(131, 123, 104));
        pannelloPhylum.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(131, 123, 104)), "Phylum", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 12), new java.awt.Color(202, 202, 202))); // NOI18N

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
        pannelloPhylum.setBounds(520, 240, 230, 53);

        pannelloRegno.setBackground(new java.awt.Color(131, 123, 104));
        pannelloRegno.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(131, 123, 104)), "Regno", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 12), new java.awt.Color(202, 202, 202))); // NOI18N

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
        pannelloRegno.setBounds(750, 240, 240, 53);

        contenitorePannelloDescrizione.setBackground(new java.awt.Color(131, 123, 104));
        contenitorePannelloDescrizione.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(131, 123, 104)), "Descrizione", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 12), new java.awt.Color(202, 202, 202))); // NOI18N

        contenitoreDescrizione.setBorder(null);

        descrizioneReperto.setBackground(new java.awt.Color(131, 123, 104));
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
                                .addComponent(contenitoreDescrizione, javax.swing.GroupLayout.DEFAULT_SIZE, 448, Short.MAX_VALUE)
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
        contenitorePannelloDescrizione.setBounds(520, 320, 470, 250);

        contenitoreTitolo.setBackground(new java.awt.Color(131, 123, 104));

        titoloReperto.setBackground(new java.awt.Color(77, 55, 71));
        titoloReperto.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        titoloReperto.setForeground(new java.awt.Color(255, 255, 255));
        titoloReperto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titoloReperto.setText("Dino Saurino");

        javax.swing.GroupLayout contenitoreTitoloLayout = new javax.swing.GroupLayout(contenitoreTitolo);
        contenitoreTitolo.setLayout(contenitoreTitoloLayout);
        contenitoreTitoloLayout.setHorizontalGroup(
                contenitoreTitoloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(contenitoreTitoloLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(titoloReperto, javax.swing.GroupLayout.PREFERRED_SIZE, 1013, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        contenitoreTitoloLayout.setVerticalGroup(
                contenitoreTitoloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(contenitoreTitoloLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(titoloReperto, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
                                .addContainerGap())
        );

        add(contenitoreTitolo);
        contenitoreTitolo.setBounds(0, 0, 1020, 50);

        canvasReperto3D.setBackground(new java.awt.Color(199, 190, 169));

        javax.swing.GroupLayout canvasReperto3DLayout = new javax.swing.GroupLayout(canvasReperto3D);
        canvasReperto3D.setLayout(canvasReperto3DLayout);
        canvasReperto3DLayout.setHorizontalGroup(
                canvasReperto3DLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 460, Short.MAX_VALUE)
        );
        canvasReperto3DLayout.setVerticalGroup(
                canvasReperto3DLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 480, Short.MAX_VALUE)
        );

        add(canvasReperto3D);
        canvasReperto3D.setBounds(30, 90, 460, 480);

        pannelloAudioguide.setBackground(new java.awt.Color(60, 53, 57));
        pannelloAudioguide.setLayout(null);

        nomePannello.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        nomePannello.setForeground(new java.awt.Color(255, 255, 255));
        nomePannello.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        nomePannello.setText("Audioguide");
        pannelloAudioguide.add(nomePannello);
        nomePannello.setBounds(11, 22, 208, 25);

        separatoreNome.setBackground(new java.awt.Color(136, 138, 145));

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
    private javax.swing.JLabel nomePannello;
    private javax.swing.JLabel ordineReperto;
    private javax.swing.JPanel pannelloAudioguide;
    private javax.swing.JPanel pannelloClasse;
    private javax.swing.JPanel pannelloFamiglia;
    private javax.swing.JPanel pannelloGenere;
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

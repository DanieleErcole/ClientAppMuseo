/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.database;

import javax.swing.*;
import java.util.ArrayList;

/**
 *
 * @author raffo
 */
public class Reperto {

    private Specie specie;
    private String nome;
    private String descrizione;
    private String luogoRitrovamento;
    private int annoRitrovamento;
    private String urlLocaleMeshPoligonale;
    private String urlFoto;
    private ArrayList<String> urlAudioguide;
    
    public Reperto(String nome, String descrizione, String luogoRitrovamento, int annoRitrovamento, String urlFoto){
        this.nome = nome;
        this.descrizione = descrizione;
        this.luogoRitrovamento = luogoRitrovamento;
        this.annoRitrovamento = annoRitrovamento;
        this.urlFoto = urlFoto;
        urlAudioguide = new ArrayList<>();
    }
    
    public void inserisciUrlLocaleMeshPoligonale(String url){
        this.urlLocaleMeshPoligonale = url;
    }
    
    public void inserisciSpecie(Specie specie){
        this.specie = specie;
    }
    
    public ArrayList<String> getUrlAudioguide(){
        return urlAudioguide;
    }

    public Specie getSpecie() {
        return specie;
    }

    public String getNome() {
        return nome;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public String getLuogoRitrovamento() {
        return luogoRitrovamento;
    }

    public int getAnnoRitrovamento() {
        return annoRitrovamento;
    }

    public String getUrlLocaleMeshPoligonale() {
        return urlLocaleMeshPoligonale;
    }

    public String getUrlFoto() {
        return urlFoto;
    }

    //Setter
    public void setUrlLocaleMeshPoligonale(String urlLocaleMeshPoligonale) {
        this.urlLocaleMeshPoligonale = urlLocaleMeshPoligonale;
    }

}

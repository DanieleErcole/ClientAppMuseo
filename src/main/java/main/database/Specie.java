/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.database;

/**
 *
 * @author raffo
 */
public class Specie {

    private String nome;
    private String genere;
    private String famiglia;
    private String ordine;
    private String classe;
    private String phylum;
    private String regno;
    
    /*public Specie(String nome, String genere, String famiglia, String ordine, String classe, String phylum, String regno, int probabilità){
        this.nome = nome;
        this.genere = genere;
        this.famiglia = famiglia;
        this.ordine = ordine;
        this.classe = classe;
        this.phylum = this.phylum;
        this.regno = regno;
        this.probabilità = probabilità;
    }*/
    
    public String getNome(){
        return nome;
    }
    
    public String getGenere(){
        return genere;
    }
    
    public String getFamiglia(){
        return famiglia;
    }
    
    public String getOrdine(){
        return ordine;
    }
    
    public String getClasse(){
        return nome;
    }
    
    public String getPhylum(){
        return genere;
    }
    
    public String getRegno(){
        return regno;
    }

}

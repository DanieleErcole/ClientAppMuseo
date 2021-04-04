
package main.database;

import java.net.URL;
import java.util.ArrayList;

/**
 *
 * @author raffo
 */
public class Reperto {

    private int specie;
    private int codice;
    private String descrizione;
    private String luogoRitrovamento;
    private int annoRitrovamento;
    private String mesh3DURL;
    private String fotoURL;
    private int teca;
    private final ArrayList<URL> urlAudioguide;
    
    /*public Reperto(int codice, String nome, String descrizione, String luogoRitrovamento, int annoRitrovamento, String urlFoto) {
        this.codice = codice;
        this.nome = nome;
        this.descrizione = descrizione;
        this.luogoRitrovamento = luogoRitrovamento;
        this.annoRitrovamento = annoRitrovamento;
        this.urlFoto = urlFoto;
        urlAudioguide = new ArrayList<>();
    }*/

    public Reperto() {
        urlAudioguide = new ArrayList<>();
    }

    public ArrayList<URL> getUrlAudioguide(){
        return urlAudioguide;
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

    public int getSpecie() {
        return specie;
    }

    public String getUrlFoto() {
        return fotoURL;
    }

    public int getCodice() {
        return codice;
    }

    public String getMesh3DURL() {
        return mesh3DURL;
    }

    public String getFotoURL() {
        return fotoURL;
    }

}

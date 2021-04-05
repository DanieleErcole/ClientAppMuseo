package main.database;

/**
 * Classe che contiene informazioni riguardanti una sala
 * @author Simone Raffo
 */
public class Room {

    private int codice;
    private int periodoStorico;
    private String planimetria;

    public int getCodice() {
        return codice;
    }

    public int getPeriodoStorico() {
        return periodoStorico;
    }

    public String getPlanimetria() {
        return planimetria;
    }

}

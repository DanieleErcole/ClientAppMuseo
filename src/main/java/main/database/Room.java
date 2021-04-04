package main.database;

import java.awt.*;

public class Room {

    private int codice;
    private int periodoStorico;
    private String planimetria;

    /*public Room(int codice, HistoricalPeriod periodoStorico, Image planimetria) {
        this.codice = codice;
        this.periodoStorico = periodoStorico;
        this.planimetria = planimetria;
    }*/

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

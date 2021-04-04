package main.database;

import java.util.Date;

public class Ticket {

    private String nome;
    private String codice;
    private Date data;
    private TicketType tipoBiglietto;

    /*public Ticket(String nome, String codice, Date data, TicketType tipoBiglietto) {
        this.nome = nome;
        this.codice = codice;
        this.data = data;
        this.tipoBiglietto = tipoBiglietto;
    }*/

    public String getNome() {
        return nome;
    }

    public String getCodice() {
        return codice;
    }

    public Date getData() {
        return data;
    }

    public TicketType getTipoBiglietto() {
        return tipoBiglietto;
    }

}

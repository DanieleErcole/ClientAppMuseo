package main.database;

import java.util.Date;

/**
 * Classe che contiene informazioni riguardanti un biglietto
 * @author Simone Raffo
 */
public class Ticket {

    private String nome;
    private String codice;
    private Date data;
    private TicketType tipoBiglietto;

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

package main.database;

/**
 * Classe che contiene informazioni riguardanti un tipo di biglietto
 * @author Simone Raffo
 */
public class TicketType {

    private String nome;
    private int durata;
    private double prezzo;

    public String getNome() {
        return nome;
    }

    public int getDurata() {
        return durata;
    }

    public double getPrezzo() {
        return prezzo;
    }

}

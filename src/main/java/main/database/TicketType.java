package main.database;

public class TicketType {

    private String nome;
    private int durata;
    private double prezzo;

    /*public TicketType(String nome, int durata, double prezzo) {
        this.nome = nome;
        this.durata = durata;
        this.prezzo = prezzo;
    }*/

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

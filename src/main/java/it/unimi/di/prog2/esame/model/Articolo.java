package it.unimi.di.prog2.esame.model;

public class Articolo {
    private String nome;
    private int daComprare;
    private int comprati;

    public Articolo(String nome, int daComprare, int comprati) {
        this.nome = nome;
        this.daComprare = daComprare;
        this.comprati = comprati;
    }

    public String getNome() {
        return nome;
    }

    public int getDaComprare() {
        return daComprare;
    }

    public int getComprati() {
        return comprati;
    }

    @Override
    public String toString() {
        return "Articolo{" +
                "nome='" + nome + '\'' +
                ", daComprare=" + daComprare +
                ", comprati=" + comprati +
                '}';
    }
}

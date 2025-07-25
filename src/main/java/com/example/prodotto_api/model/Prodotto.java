package com.example.prodotto_api.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.ArrayList;

@Entity
@Table(name = "prodotti")
public class Prodotto {

    @Id
    private int id;
    private String nome;
    private int quantita;
    private String lotto;
    private double prezzo;


    public Prodotto(String nome, int quantita, String lotto, int id, double prezzo){
        this.nome = nome;
        this.quantita = quantita;
        this.lotto = lotto;
        this.id = id;
        this.prezzo = prezzo;
    }

    public Prodotto(String nome, int quantita, String lotto, double prezzo, ArrayList<Prodotto> p){
        this.nome = nome;
        this.quantita = quantita;
        this.lotto = lotto;
        this.id = p.toArray().length + 2;
        this.prezzo = prezzo;
    }

    public Prodotto() {

    }


    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public int getQuantita() {
        return quantita;
    }

    public String getLotto() {
        return lotto;
    }

    public double getPrezzo() {
        return prezzo;
    }

    public void setQuantita(int quantita) {
        this.quantita = quantita;
    }

    public void setLotto(String lotto) {
        this.lotto = lotto;
    }

    public void setPrezzo(double prezzo) {
        this.prezzo = prezzo;
    }


}

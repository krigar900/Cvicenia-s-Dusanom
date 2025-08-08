package com.projekt.rodinnedomy.model;

public class Zariadenie {
    private int id;
    private String typ;
    private double cena;

    public Zariadenie(int id, String typ, double cena) {
        this.id = id;
        this.typ = typ;
        this.cena = cena;
    }


    /*CREATE TABLE zariadenie (
  id SERIAL PRIMARY KEY,
  typ VARCHAR(50),
  cena DECIMAL(8,2)
);*/
}

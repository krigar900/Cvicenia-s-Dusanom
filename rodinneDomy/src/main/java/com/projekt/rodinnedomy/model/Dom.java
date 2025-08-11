package com.projekt.rodinnedomy.model;


public class Dom {

    private int id;
    private String ulica;
    private int cisloDomu;
    private String mesto;
    private String farba;
    private boolean zahrada;

    public Dom() {
        this.id = id;
        this.ulica = ulica;
        this.cisloDomu = cisloDomu;
        this.mesto = mesto;
        this.farba = farba;
        this.zahrada = zahrada;
    }

    //Gettery
    public int getId() {return id;}
    public String getUlica() {return ulica;}
    public int getCisloDomu() {return cisloDomu;}
    public String getMesto() {return mesto;}
    public String getFarba() {return farba;}
    public boolean isZahrada() {return zahrada;}

    //Settery
    public void setId(int id) {this.id = id;}
    public void setUlica(String ulica) {this.ulica = ulica;}
    public void setCisloDomu(int cisloDomu) {this.cisloDomu = cisloDomu;}
    public void setMesto(String mesto) {this.mesto = mesto;}
    public void setFarba(String farba) {this.farba = farba;}
    public void setZahrada(boolean zahrada) {this.zahrada = zahrada;}



}







    /*CREATE TABLE dom (
            id SERIAL PRIMARY KEY,
            ulica VARCHAR (100),
    cislo_domu SMALLINT,
    mesto VARCHAR (100),
    farba VARCHAR(20),
    zahrada BOOLEAN,
    id_rodina INT,
  );*/


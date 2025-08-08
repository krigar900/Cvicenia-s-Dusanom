package com.projekt.rodinnedomy.model;

public class Izba {
    private int id;
    private String typ;
    private int pocetOkien;
    private String vykurovanie;
    private int idDom;
    private int idOsoba;

    public Izba(int id, String typ, int pocetOkien, String vykurovanie, int idDom, int idOsoba) {
        this.id = id;
        this.typ = typ;
        this.pocetOkien = pocetOkien;
        this.vykurovanie = vykurovanie;
        this.idDom = idDom;
        this.idOsoba = idOsoba;
    }

    /*CREATE TABLE izba (
            id SERIAL PRIMARY KEY,
            typ VARCHAR(30),
    pocet_okien SMALLINT,
    vykurovanie VARCHAR(30),
    id_dom INT,
    id_osoba INT,
    FOREIGN KEY (id_dom) REFERENCES dom(id),
    FOREIGN KEY (id_osoba) REFERENCES osoba(id)
            );*/

}

package com.projekt.rodinnedomy.model;

public class zariadenieIzbyDTO {
    private int id;
    private int idIzba;
    private int idZariadenie;
    private int pocet;

    public zariadenieIzbyDTO(int id, int idIzba, int idZariadenie, int pocet) {
        this.id = id;
        this.idIzba = idIzba;
        this.idZariadenie = idZariadenie;
        this.pocet = pocet;
    }

    /*CREATE TABLE zariadenie_izby (
id SERIAL PRIMARY KEY,
id_izba INT,
id_zariadenie INT,
pocet INT,
FOREIGN KEY (id_izba) REFERENCES izba (id),
FOREIGN KEY (id_zariadenie) REFERENCES zariadenie(id)
);*/
}

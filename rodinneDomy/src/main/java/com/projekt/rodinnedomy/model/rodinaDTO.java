package com.projekt.rodinnedomy.model;

public class rodinaDTO {

    private int id;
    private String meno;
    private int pocetClenov;
    private int idDom;

    public rodinaDTO(int id, String meno, int pocetClenov, int idDom) {
        this.id = id;
        this.meno = meno;
        this.pocetClenov = pocetClenov;
        this.idDom = idDom;
    }

    /*CREATE TABLE rodina (
  id SERIAL PRIMARY KEY,
  meno VARCHAR(30),
  pocet clenov INT,
  id_dom INT,
  FOREIGN KEY (id_dom) REFERENCES dom(id)
);*/
}

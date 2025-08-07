package com.projekt.rodinnedomy.model;

import java.time.LocalDate;

public class osobaDTO {
    private int id;
    private String meno;
    private String priezvisko;
    private LocalDate datumNarodenia; //dd.mm.yyyy
    private boolean majitel;
    private int idDom;
    private int idRodina;

    public osobaDTO(int id, String meno, String priezvisko, LocalDate datumNarodenia, boolean majitel, int idDom, int idRodina) {
        this.id = id;
        this.meno = meno;
        this.priezvisko = priezvisko;
        this.datumNarodenia = datumNarodenia;
        this.majitel = majitel;
        this.idDom = idDom;
        this.idRodina = idRodina;
    }



    /*CREATE TABLE osoba (
  id SERIAL PRIMARY KEY,
  meno VARCHAR(50),
  priezvisko VARCHAR(100),
  datum_narodenia DATE,
  majitel BOOLEAN,
  id_dom INT,
  id_rodina INT,
  FOREIGN KEY (id_dom) REFERENCES dom(id),
  FOREIGN KEY (id_rodina) REFERENCES rodina(id)
);
*/
}

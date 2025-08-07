


public class domDTO {

    private int id;
    private String ulica;
    private int cisloDomu;
    private String mesto;
    private String farba;
    private boolean zahrada;

    public domDTO(int id, String ulica, int cisloDomu, String mesto, String farba, boolean zahrada, int idRodina) {
        this.id = id;
        this.ulica = ulica;
        this.cisloDomu = cisloDomu;
        this.mesto = mesto;
        this.farba = farba;
        this.zahrada = zahrada;

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
}

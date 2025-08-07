public class zahradaDTO {
    private int id;
    private int vymerV2;
    private String druh;
    private int idDom;

    public zahradaDTO(int id, int vymerV2, String druh, int idDom) {
        this.id = id;
        this.vymerV2 = vymerV2;
        this.druh = druh;
        this.idDom = idDom;
    }



    /*CREATE TABLE zahrada (
  id SERIAL PRIMARY KEY
  Výmer_v_m2 INT,
  druh VARCHAR(50),
  id_dom INT,
  FOREIGN KEY (id_dom) REFERENCES dom(id)
);
*/
}

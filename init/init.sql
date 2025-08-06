CREATE TABLE osoba (
  id SERIAL PRIMARY KEY,
  meno VARCHAR(50),
  priezvisko VARCHAR(100),
  datum narodenia DATE,
  majitel BOOLEAN,
  id_dom INT,
  id_rodina INT,
  FOREIGN KEY (id_dom) REFERENCES dom(id),
  FOREIGN KEY (id_rodina) REFERENCES rodina(id) 
);


CREATE TABLE dom (
  id SERIAL PRIMARY KEY,
  ulica VARCHAR (100),
  číslo_domu SMALLINT,
  mesto VARCHAR (100),
  farba VARCHAR(20),
  zahrada BOOLEAN
  id_rodina INT,
  FOREIGN KEY (id_rodina) REFERENCES rodina(id)
);


CREATE TABLE izba (
  id SERIAL PRIMARY KEY,
  typ VARCHAR(30),
  pocet_okien SMALLINT,
  vykurovanie VARCHAR(30)
  id_dom INT,
  id_osoba INT,
  FOREIGN KEY (id_dom) REFERENCES dom(id),
  FOREIGN KEY (id_osoba) REFERENCES osoba(id)
);


CREATE TABLE zahrada (
  Výmer_v_m2 INT
  druh VARCHAR(50),
  id_dom INT,
  FOREIGN KEY (id_dom) REFERENCES dom(id)
);


/*
zoznam moznych zariadenie
1. skirna
2. postel
3. stol
*/

CREATE TABLE zariadenie (
  id SERIAL PRIMARY KEY,
  typ VARCHAR(50),
  cena DECIMAL(8,2)
);



CREATE TABLE zariadenie_izby (
id SERIAL PRIMARY KEY,
id_izba INT,
id_zariadenie INT,
pocet INT,
FOREIGN KEY (id_izba) REFERENCES izba (id),
FOREIGN KEY (id_zariadenia) REFERENCES zariadenie(id)
);


CREATE TABLE rodina (
  id SERIAL PRIMARY KEY,
  meno VARCHAR(30),
  počet členov INT,
  id_dom INT,
  FOREIGN KEY (id_dom) REFERENCES dom(id)
);

/*Ako sa definuje foreign key a primary key*/

--Data tabulky zariadenie
INSERT INTO zariadenie
(id, typ, cena)
VALUES
    (nextval('zariadenie_id_seq'::regclass), 'Stol', 200.50),  
    (nextval('zariadenie_id_seq'::regclass), 'Stolicka', 50.45),  
    (nextval('zariadenie_id_seq'::regclass), 'Postel', 400.50),  
    (nextval('zariadenie_id_seq'::regclass), 'Kreslo', 120.35),  
    (nextval('zariadenie_id_seq'::regclass), 'Pohovka', 320.85),  
    (nextval('zariadenie_id_seq'::regclass), 'Skrina', 150.51),  
    (nextval('zariadenie_id_seq'::regclass), 'Televizia', 450.30),  
    (nextval('zariadenie_id_seq'::regclass), 'Sporak', 320.50),  
    (nextval('zariadenie_id_seq'::regclass), 'Polica', 30.45),  
    (nextval('zariadenie_id_seq'::regclass), 'Komoda', 80.31),  
    (nextval('zariadenie_id_seq'::regclass), 'Zrkadlo', 90.60);  

--Data tabulky rodina--
INSERT INTO rodina
(id, meno, pocet_clenov)
VALUES
    (nextval('rodina_id_seq'::regclass), 'Sedlakovci', 5),
    (nextval('rodina_id_seq'::regclass), 'Nehilovci', 5),
    (nextval('rodina_id_seq'::regclass), 'Pavlikovci', 4),
    (nextval('rodina_id_seq'::regclass), 'Gardosikovci', 6);

--Data tabulky dom--

INSERT INTO dom
(id, ulica, cislo_domu, mesto, farba, zahrada, id_rodina)
VALUES
    (nextval('dom_id_seq'::regclass), '-', 45, 'Slatvina', 'bordova', true, 4), --kristian--
    (nextval('dom_id_seq'::regclass), '-', 45, 'Slatvina', 'bordova', true, 4), --mamka/ocko--
    (nextval('dom_id_seq'::regclass), '-', 87, 'Slatvina', 'biela', true, 2),   --anicka--
    (nextval('dom_id_seq'::regclass), 'Osloboditelov', 95, 'Olcnava', 'ruzova', true, 1), --zuzana--
    (nextval('dom_id_seq'::regclass), 'Hornadska', 5, 'Olcnava', 'siva', true, 3), --janka--
    (nextval('dom_id_seq'::regclass), 'Maurerova',793, 'Krompachy', 'oranova', true, 1); --gregor--


--Data tabulky osoba--

INSERT INTO osoba
(id, meno, priezvisko, datum_narodenia, majitel, id_dom, id_rodina)
VALUES
--Sedlakovci--
    (nextval('osoba_id_seq'::regclass), 'Zuzana', 'Sedlakova', '1975-05-24', true, 4, 1),
    (nextval('osoba_id_seq'::regclass), 'Robert', 'Sedlak', '1973-06-12', true, 4, 1),
    (nextval('osoba_id_seq'::regclass), 'Gregor', 'Sedlak', '1999-02-15', false, 4, 1),
    (nextval('osoba_id_seq'::regclass), 'Jan', 'Sedlak', '2001-01-06', false, 6, 1),
    (nextval('osoba_id_seq'::regclass), 'Matej', 'Sedlak', '2002-08-13', false, 6, 1),
--Nehilovci--
    (nextval('osoba_id_seq'::regclass), 'Anna', 'Nehilova', '1976-06-21', true, 3, 2),
    (nextval('osoba_id_seq'::regclass), 'Milos', 'Nehila', '1975-07-31', true, 3, 2),
    (nextval('osoba_id_seq'::regclass), 'Flavian', 'Nehila', '2001-12-06', false, 3, 2),
    (nextval('osoba_id_seq'::regclass), 'Bystrik', 'Nehila', '2012-08-13', false, 3, 2),
    (nextval('osoba_id_seq'::regclass), 'Dorotka', 'Nehilova', '2014-03-14', false, 3, 2),
--Pavlikovci--
    (nextval('osoba_id_seq'::regclass), 'Jane', 'Pavlikova', '1977-09-12', true, 5, 3),
    (nextval('osoba_id_seq'::regclass), 'Marek', 'Pavlik', '1975-10-13', true, 5, 3),
    (nextval('osoba_id_seq'::regclass), 'Nina', 'Pavlikova', '2011-4-12', false, 5, 3),
    (nextval('osoba_id_seq'::regclass), 'Vratko', 'Pavlik', '2015-5-12', false, 5, 3),
--Gardosikovci--
    (nextval('osoba_id_seq'::regclass), 'Anna', 'Gardosikova', '1952-01-06', false, 1, 4),
    (nextval('osoba_id_seq'::regclass), 'Jan', 'Gardosikov', '1953-03-24', false, 1, 4),        
    (nextval('osoba_id_seq'::regclass), 'Michaela', 'Gardosikova', '1992-04-02', false, 2, 4),
    (nextval('osoba_id_seq'::regclass), 'Kristian', 'Gardosik', '1993-09-09', true, 2, 4),   
    (nextval('osoba_id_seq'::regclass), 'Damian', 'Gardosik', '2017-12-14', false, 2, 4), 
    (nextval('osoba_id_seq'::regclass), 'Benjamin', 'Gardosik', '2022-5-19', false, 2, 4);            




--Data tabulky izba--

INSERT INTO izba
(id, typ, pocet_okien, vykurovanie, id_dom, id_osoba)
VALUES
--Sedlakovci--
    (nextval('izba_id_seq'::regclass), 'kuchyna', 2, 'teplovodne', 4, NULL),
    (nextval('izba_id_seq'::regclass), 'obyvacka', 3, 'teplovodne', 4, NULL),
    (nextval('izba_id_seq'::regclass), 'spalna', 1, 'teplovodne', 4, 1), --Zuzana,Robo--
    (nextval('izba_id_seq'::regclass), 'detska', 1, 'teplovodne', 4, 3), --Gregor--
    (nextval('izba_id_seq'::regclass), 'pracovna', 1, 'teplovodne', 4, NULL),
--Nehilovci--
    (nextval('izba_id_seq'::regclass), 'kuchyna', 2, 'teplovodne', 3, NULL),
    (nextval('izba_id_seq'::regclass), 'obyvacka', 2, 'teplovodne', 3, NULL),
    (nextval('izba_id_seq'::regclass), 'spalna', 1, 'teplovodne', 3, 6), --Anna, Milos--
    (nextval('izba_id_seq'::regclass), 'detska', 1, 'teplovodne', 3, 10), --Dorotka--
    (nextval('izba_id_seq'::regclass), 'detska', 2, 'teplovodne', 3, 8), --Flavian--
    (nextval('izba_id_seq'::regclass), 'detska', 1, 'teplovodne', 3, 9), --Bystrik--
--Pavlikovci--
    (nextval('izba_id_seq'::regclass), 'kuchyna', 3, 'teplovodne', 5, NULL),
    (nextval('izba_id_seq'::regclass), 'obyvacka', 1, 'teplovodne', 5, NULL),
    (nextval('izba_id_seq'::regclass), 'spalna', 1, 'teplovodne', 5, 11), --Janka,Marek--
    (nextval('izba_id_seq'::regclass), 'detska', 3, 'teplovodne', 5, 14), --Vratko--
    (nextval('izba_id_seq'::regclass), 'detska', 4, 'teplovodne', 5, 13), --Nina--
--Gardosikovci ml.--
    (nextval('izba_id_seq'::regclass), 'kuchyna', 1, 'teplovodne', 2, NULL),
    (nextval('izba_id_seq'::regclass), 'obyvacka',3, 'teplovodne', 2, NULL),
    (nextval('izba_id_seq'::regclass), 'spalna', 1, 'teplovodne', 2, 17), --Miska,Kristian--
    (nextval('izba_id_seq'::regclass), 'detska', 2, 'teplovodne', 2, 19), --Damian, Benjamin--
--Gardosikovci st.--
    (nextval('izba_id_seq'::regclass), 'kuchyna', 1, 'teplovodne', 1, NULL),
    (nextval('izba_id_seq'::regclass), 'obyvacka', 0, 'teplovodne', 1, NULL),
    (nextval('izba_id_seq'::regclass), 'spalna', 2, 'teplovodne', 1, 15), --Jan, Anna--
--Gregor--
    (nextval('izba_id_seq'::regclass), 'kuchyna', 1, 'teplovodne', 6, NULL),
    (nextval('izba_id_seq'::regclass), 'obyvacka', 2, 'teplovodne', 6, 5), --Matej--
    (nextval('izba_id_seq'::regclass), 'spalna', 2, 'teplovodne', 6, 4); --Jan--
    
 
 --Data tabulky zahrada--
 INSERT INTO zahrada
(id, vymer_v_m2, druh, id_dom)
VALUES
    (nextval('zahrada_id_seq'::regclass), 350, 'uzitkova', 2),
    (nextval('zahrada_id_seq'::regclass), 200, 'uzitkova', 5),
    (nextval('zahrada_id_seq'::regclass), 150, 'okrasna', 4),
    (nextval('zahrada_id_seq'::regclass), 45, 'okrasna', 3),
    (nextval('zahrada_id_seq'::regclass), 350, 'uzitkova', 1);


--Data tabulky zariadenie izby--
INSERT INTO zariadenie_izby
(id, id_izba, id_zariadenie, pocet)
VALUES
    (nextval('zariadenie_izby_id_seq'::regclass), 0, 0, 0),
    (nextval('zariadenie_izby_id_seq'::regclass), 0, 0, 0),
    (nextval('zariadenie_izby_id_seq'::regclass), 0, 0, 0),
    (nextval('zariadenie_izby_id_seq'::regclass), 0, 0, 0),
    (nextval('zariadenie_izby_id_seq'::regclass), 0, 0, 0),
    (nextval('zariadenie_izby_id_seq'::regclass), 0, 0, 0),
    (nextval('zariadenie_izby_id_seq'::regclass), 0, 0, 0),
    (nextval('zariadenie_izby_id_seq'::regclass), 0, 0, 0),
    (nextval('zariadenie_izby_id_seq'::regclass), 0, 0, 0),
    (nextval('zariadenie_izby_id_seq'::regclass), 0, 0, 0),
    (nextval('zariadenie_izby_id_seq'::regclass), 0, 0, 0),
    (nextval('zariadenie_izby_id_seq'::regclass), 0, 0, 0),
    (nextval('zariadenie_izby_id_seq'::regclass), 0, 0, 0),
    (nextval('zariadenie_izby_id_seq'::regclass), 0, 0, 0),
    (nextval('zariadenie_izby_id_seq'::regclass), 0, 0, 0),
    (nextval('zariadenie_izby_id_seq'::regclass), 0, 0, 0),
    (nextval('zariadenie_izby_id_seq'::regclass), 0, 0, 0),
    
 
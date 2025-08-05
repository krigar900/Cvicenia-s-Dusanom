CREATE TABLE owners (
  owner_id SERIAL PRIMARY KEY,
  owner VARCHAR(50),
  house_number NOT NULL,
  city VARCHAR(50),
  number_of_inhabitants INT NOT NULL 
);

INSERT INTO users (owner, house_number, city,number_of_inhabitants)
VALUES 
('Kristián Gardošík',45,'Slatvina',6),
('Zuzana Sedláková',98,'Olcnava',4),
('Janka Pavlíková',14,'Olcnava',4),
('Anna Nehilová',87,'Slatvina',4),
('Gregor Sedlák',62,'Krompachy',0);

CREATE TABLE houses  (
  id_house SERIAL PRIMARY KEY,
  owner VARCHAR(50) REFERENCES owners(owner),
  number_of_rooms INT NOT NULL,
  color VARCHAR(20),
  garden BOOLEAN;
)

INSERT INTO houses (owner. number_of_rooms, color, garden)
VALUES

('Kristián Gardošík',3,'red',TRUE),
('Zuzana Sedláková',5,'silver',TRUE),
('Janka Pavlíková',4,'white',TRUE),
('Anna Nehilová',5,'white',TRUE),
('Gregor Sedlák',3,'orange',FALSE);


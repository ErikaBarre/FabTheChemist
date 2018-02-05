dropdb fabthechemistdb;
createdb fabthechemistdb;
--acceder db
psql fabthechemistdb
DROP TABLE temps;
DROP TABLE villes;
CREATE TABLE temps (
    ville           varchar(80),
    t_basse         int,           -- température basse
    t_haute         int,           -- température haute
    prcp            real,          -- précipitation
    date            date
);
CREATE TABLE villes (
    nom            varchar(80),
    emplacement    point
);
INSERT INTO temps VALUES ('San Francisco', 46, 50, 0.25, '1994-11-27');
INSERT INTO villes VALUES ('San Francisco', '(-194.0, 53.0)');
INSERT INTO temps (ville, t_basse, t_haute, prcp, date) VALUES ('San Francisco', 43, 57, 0.0, '1994-11-29');
INSERT INTO temps (date, ville, t_haute, t_basse) VALUES ('1994-11-29', 'Hayward', 54, 37);
INSERT INTO temps VALUES ('Berkeley', 45, 53, 0.0, '1994-11-28');
CREATE VIEW ma_vue AS
    SELECT ville, t_basse, t_haute, prcp, date, emplacement
        FROM temps, villes
        WHERE ville = nom;
CREATE TABLE capitales (
  nom        text,
  population real,
  altitude   int,    -- (en pied)
  etat       char(2)
);
CREATE SEQUENCE non_capitales_seq;
CREATE TABLE non_capitales (
	id  integer NOT NULL DEFAULT nextval('non_capitales_seq') NOT NULL
	nom        text,
	population real,
	altitude   int     -- (en pied)
);
ALTER SEQUENCE non_capitales_seq OWNED BY non_capitales.id;

CREATE VIEW villes AS
  SELECT nom, population, altitude FROM capitales
    UNION
  SELECT nom, population, altitude FROM non_capitales;
CREATE SEQUENCE produits_seq;  
CREATE TABLE produits (
	id_produit integer PRIMARY KEY,
	no_produit integer CONSTRAINT doit_etre_different UNIQUE,
    nom text NOT NULL,
    prix numeric NOT NULL CONSTRAINT prix_positif CHECK (prix > 0),
    prix_promotion numeric CHECK (prix_promotion > 0), CONSTRAINT promo_valide CHECK (prix > prix_promotion)
); 
CREATE TABLE commandes (
        id_commande integer PRIMARY KEY,
        no_produit integer ,
        quantite integer
);      
CREATE TABLE commande_produits (
	no_produit integer REFERENCES produits (id_produit),
	id_commande integer REFERENCES commandes, 
	quantite integer,
	PRIMARY KEY (no_produit, id_commande)
);

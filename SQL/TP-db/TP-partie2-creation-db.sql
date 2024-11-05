CREATE TABLE grille_tarifs(
	id_gam		CHAR(2)			NOT NULL,
	id_cate		CHAR(4)			NOT NULL,
	prix_jour	NUMERIC(5,2)	NOT NULL CONSTRAINT CK_grille_tarifs_prix_jour CHECK(prix_jour > 0),
		CONSTRAINT PK_grille_tarifs PRIMARY KEY(id_gam, id_cate)
)

CREATE TABLE gammes(
	id_gam		CHAR(2)			NOT NULL	CONSTRAINT PK_gammes PRIMARY KEY,
	libelle		VARCHAR(30)		NOT NULL
)

CREATE TABLE categories(
	id_cate		CHAR(4)			NOT NULL	CONSTRAINT PK_categories PRIMARY KEY,
	libelle		VARCHAR(30)		NOT NULL
)
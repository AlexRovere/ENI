CREATE TABLE clients (
	id_cli		NUMERIC(6)	NOT NULL	CONSTRAINT PK_client PRIMARY KEY,
	nom			CHAR(30)	NOT NULL,
	prenom		CHAR(30),
	adresse		VARCHAR(120),
	cpo			CHAR(5)		NOT NULL	CONSTRAINT CK_clients_cpo CHECK(cpo >= 01000 AND cpo <= 95999),
	ville		VARCHAR(80)	NOT NULL	DEFAULT 'Nantes', 
)

CREATE TABLE fiches (
	id_fic		NUMERIC(6)	NOT NULL	CONSTRAINT PK_fiches PRIMARY KEY IDENTITY,
	id_cli		NUMERIC(6)	NOT NULL,
	date_crea	DATETIME2	NOT NULL	DEFAULT GETDATE(),
	date_paye	DATETIME2,	
	etat		CHAR(2)		NOT NULL	DEFAULT 'en cours'	CONSTRAINT CK_fiches_etat CHECK(etat in('EC', 'RE', 'SO')),
		CONSTRAINT CK_fiches_date_paye_date_crea CHECK(date_paye IS NULL OR date_crea < date_paye AND etat = 'SO'),
)

CREATE TABLE lignes_fic (
	id_fic		NUMERIC(6)	NOT NULL,
	id_lig		NUMERIC(2)	NOT NULL,
	ref_art		CHAR(3),
	date_depart	DATETIME2	NOT NULL	DEFAULT GETDATE(),
	date_retour	DATETIME2,
	duree		CHAR(30),
		CONSTRAINT PK_lignes_fic PRIMARY KEY(id_fic, id_lig),
		CONSTRAINT CK_lignes_fic_date_retour_date_depart CHECK(date_retour IS NULL OR date_depart < date_retour)
)

CREATE TABLE articles (
	ref_art		CHAR(3)		NOT NULL	CONSTRAINT PK_articles PRIMARY KEY,
	id_modele	INT
)


CREATE TABLE modeles (
	id_modele	INT			NOT NULL	CONSTRAINT PK_modeles PRIMARY KEY,
	designation	VARCHAR(80)	NOT NULL,
	id_gam		CHAR(2)		NOT NULL,
	id_cate		CHAR(4)		NOT NULL
)

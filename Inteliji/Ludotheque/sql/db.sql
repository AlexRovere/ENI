
CREATE TABLE IF NOT EXISTS public.clients
(
    no_client int CONSTRAINT PK_client PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    nom varchar NOT NULL,
    prenom varchar NOT NULL,
    email varchar NOT NULL CONSTRAINT "UQ_client_email" UNIQUE,
    no_tel varchar,
    rue varchar NOT NULL,
    code_postal int NOT NULL,
    ville varchar NOT NULL
);

CREATE TABLE IF NOT EXISTS public.jeu
(
    no_jeu integer NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 2147483647 CACHE 1 ),
    titre varchar NOT NULL,
    reference integer NOT NULL,
    description varchar,
    tarif_journee numeric NOT NULL,
    age_min integer NOT NULL,
    duree integer,
    CONSTRAINT jeu_pkey PRIMARY KEY (no_jeu),
    CONSTRAINT "UQ_jeu_reference" UNIQUE (reference)
);

CREATE TABLE IF NOT EXISTS public.genres
(
    no_genre integer NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 2147483647 CACHE 1 ),
    libelle character varying COLLATE pg_catalog."default",
    CONSTRAINT genres_pkey PRIMARY KEY (no_genre)
);

CREATE TABLE IF NOT EXISTS public.jeu_genre
(
    id integer NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 2147483647 CACHE 1 ),
    no_jeu integer NOT NULL,
    no_genre integer NOT NULL,
    CONSTRAINT jeu_genre_pkey PRIMARY KEY (id),
    CONSTRAINT "FK_jeu_genre_genre" FOREIGN KEY (no_genre)
        REFERENCES public.genres (no_genre) MATCH SIMPLE
        ON UPDATE CASCADE
        ON DELETE CASCADE,
    CONSTRAINT "FK_jeu_genre_jeu" FOREIGN KEY (no_jeu)
        REFERENCES public.jeu (no_jeu) MATCH SIMPLE
        ON UPDATE CASCADE
        ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS public.exemplaire_jeu
(
    no_exemplaire integer NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 2147483647 CACHE 1 ),
    no_jeu integer NOT NULL,
    codebarre varchar COLLATE pg_catalog."default" NOT NULL,
    louable boolean NOT NULL,

    CONSTRAINT exemplaire_jeu_pkey PRIMARY KEY (no_exemplaire),
    CONSTRAINT "UQ_examplaire_jeu_codebarre" UNIQUE (codebarre),
    CONSTRAINT "FK_examplaire_jeu_no_jeu" FOREIGN KEY (no_jeu) REFERENCES jeu(no_jeu)
);





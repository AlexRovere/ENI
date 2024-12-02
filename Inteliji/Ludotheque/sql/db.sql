-- Table: public.clients

-- DROP TABLE IF EXISTS public.clients;

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
)

    TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.clients
    OWNER to postgres;
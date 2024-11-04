ALTER TABLE lignes_fic DROP COLUMN duree

ALTER TABLE lignes_fic 
ADD duree AS  (
	CASE
        WHEN date_depart IS NOT NULL AND date_retour IS NOT NULL 
        THEN DATEDIFF(day, date_depart, date_retour) 
        ELSE NULL 
    END
	)


CREATE SEQUENCE SQ_clients START WITH 1000 INCREMENT BY 1;

ALTER TABLE clients
ADD CONSTRAINT DF_clients_seq
DEFAULT NEXT VALUE FOR SQ_clients FOR id_cli

CREATE INDEX UX_clients ON clients (nom, prenom) INCLUDE (adresse)
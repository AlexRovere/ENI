/* SUPPRESSION DES REFERENCES */


ALTER TABLE lignes_fic DROP CONSTRAINT FK_lignes_fic_fiches
ALTER TABLE lignes_fic DROP CONSTRAINT FK_lignes_fic_articles
ALTER TABLE fiches DROP CONSTRAINT FK_fiches_id_cli
ALTER TABLE articles DROP CONSTRAINT FK_articles_modele


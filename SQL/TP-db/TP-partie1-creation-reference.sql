/* AJOUT DES CLES REFERENTIELLES */

ALTER TABLE lignes_fic ADD CONSTRAINT FK_lignes_fic_fiches FOREIGN KEY (id_fic) REFERENCES fiches(id_fic) ON DELETE CASCADE
ALTER TABLE lignes_fic ADD CONSTRAINT FK_lignes_fic_articles FOREIGN KEY (ref_art) REFERENCES articles(ref_art) ON UPDATE CASCADE
ALTER TABLE fiches ADD CONSTRAINT FK_fiches_id_cli FOREIGN KEY (id_cli) REFERENCES clients(id_cli) ON DELETE SET NULL
ALTER TABLE articles ADD CONSTRAINT FK_articles_modele FOREIGN KEY (id_modele) REFERENCES modeles(id_modele)
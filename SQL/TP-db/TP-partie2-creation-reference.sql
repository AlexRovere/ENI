/* AJOUT DES CLES REFERENTIELLES PARTIE 2 */

ALTER TABLE grille_tarifs ADD CONSTRAINT FK_grille_tarifs_gammes FOREIGN KEY (id_gam) REFERENCES gammes(id_gam)
ALTER TABLE grille_tarifs ADD CONSTRAINT FK_grille_tarifs_categories FOREIGN KEY (id_cate) REFERENCES categories(id_cate)
ALTER TABLE modeles ADD CONSTRAINT FK_modeles_grille_tarifs FOREIGN KEY (id_gam, id_cate) REFERENCES grille_tarifs(id_gam, id_cate)

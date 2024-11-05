/* SUPPRESSION DES CLES REFERENTIELLES PARTIE 2 */

ALTER TABLE grille_tarifs DROP CONSTRAINT FK_grille_tarifs_gammes 
ALTER TABLE grille_tarifs DROP CONSTRAINT FK_grille_tarifs_categories
ALTER TABLE modeles DROP CONSTRAINT FK_modeles_grille_tarifs
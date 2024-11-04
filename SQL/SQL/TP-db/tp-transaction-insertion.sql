   USE Locations
GO

BEGIN TRAN insert_client

INSERT INTO clients (id_cli, nom, prenom, adresse, cpo, ville) VALUES (14, 'Bouteau', 'Sabine', 'Rue des platanes', '75002', 'Paris')

INSERT INTO fiches (id_fic, id_cli, date_crea, date_paye, etat) VALUES (1001, 14, GETDATE() - 15, GETDATE() - 13, 'SO')

INSERT INTO gammes VALUES ('PR', 'Matériel Professionnel')
INSERT INTO gammes VALUES ('HG', 'Haut de gamme')
INSERT INTO gammes VALUES ('MG', 'Moyenne gamme')
INSERT INTO gammes VALUES ('EG', 'Entrée de gamme')

INSERT INTO categories VALUES ('MONO', 'Monoski')
INSERT INTO categories VALUES ('SURF', 'Surf')
INSERT INTO categories VALUES ('PA', 'Patinette')
INSERT INTO categories VALUES ('FOA', 'Ski de fond alternatif')
INSERT INTO categories VALUES ('FOP', 'Ski de fond patineur')
INSERT INTO categories VALUES ('SA', 'Ski alpin')

INSERT INTO grille_tarifs VALUES ('EG', 'MONO', 10);
INSERT INTO grille_tarifs VALUES ('MG', 'MONO', 15);
INSERT INTO grille_tarifs VALUES ('EG', 'SURF', 10);
INSERT INTO grille_tarifs VALUES ('MG', 'SURF', 15);
INSERT INTO grille_tarifs VALUES ('HG', 'SURF', 20);
INSERT INTO grille_tarifs VALUES ('PR', 'SURF', 50);
INSERT INTO grille_tarifs VALUES ('EG', 'PA', 10);
INSERT INTO grille_tarifs VALUES ('MG', 'PA', 15);
INSERT INTO grille_tarifs VALUES ('EG', 'FOA', 10);
INSERT INTO grille_tarifs VALUES ('MG', 'FOA', 15);
INSERT INTO grille_tarifs VALUES ('HG', 'FOA', 30);
INSERT INTO grille_tarifs VALUES ('PR', 'FOA', 90);
INSERT INTO grille_tarifs VALUES ('EG', 'FOP', 15);
INSERT INTO grille_tarifs VALUES ('MG', 'FOP', 20);
INSERT INTO grille_tarifs VALUES ('HG', 'FOP', 30);
INSERT INTO grille_tarifs VALUES ('PR', 'FOP', 90);
INSERT INTO grille_tarifs VALUES ('EG', 'SA', 10);
INSERT INTO grille_tarifs VALUES ('MG', 'SA', 15);
INSERT INTO grille_tarifs VALUES ('HG', 'SA', 30);
INSERT INTO grille_tarifs VALUES ('PR', 'SA', 90);

INSERT INTO modeles VALUES (1, 'Fischer Cruiser', 'EG', 'FOA');
INSERT INTO modeles VALUES (2, 'Fischer Sporty Crown', 'MG', 'FOA');
INSERT INTO modeles VALUES (3, 'Fischer RCS Classic GOLD', 'PR', 'FOA');
INSERT INTO modeles VALUES (4, 'Fischer SOSSkating VASA', 'HG', 'FOP');
INSERT INTO modeles VALUES (5, 'Fischer RCS CARBOLITE Skating', 'PR', 'FOP');
INSERT INTO modeles VALUES (6, 'Décathlon Allegre junior 150', 'EG', 'PA');
INSERT INTO modeles VALUES (7, 'Fischer mini ski patinette', 'MG', 'PA');
INSERT INTO modeles VALUES (8, 'Décathlon Apparition', 'EG', 'SURF');
INSERT INTO modeles VALUES (9, 'Salomon 24X+Z12', 'EG', 'SA');
INSERT INTO modeles VALUES (10, 'Salomon Pro Link Equipe 4S', 'PR', 'SA');
INSERT INTO modeles VALUES (11, 'Salomon 3V RACE JR+L10', 'PR', 'SA');



INSERT INTO articles VALUES ('F01', 1);
INSERT INTO articles VALUES ('F02', 1);
INSERT INTO articles VALUES ('F03', 1);
INSERT INTO articles VALUES ('F04', 1);
INSERT INTO articles VALUES ('F05', 1);
INSERT INTO articles VALUES ('F10', 2);
INSERT INTO articles VALUES ('F20', 3);
INSERT INTO articles VALUES ('F21', 3);
INSERT INTO articles VALUES ('F22', 3);
INSERT INTO articles VALUES ('F23', 3);
INSERT INTO articles VALUES ('F50', 4);
INSERT INTO articles VALUES ('F60', 5);
INSERT INTO articles VALUES ('F61', 5);
INSERT INTO articles VALUES ('F62', 5);
INSERT INTO articles VALUES ('F63', 5);
INSERT INTO articles VALUES ('F64', 5);
INSERT INTO articles VALUES ('P01', 6);
INSERT INTO articles VALUES ('P10', 7);
INSERT INTO articles VALUES ('P11', 7);
INSERT INTO articles VALUES ('S01', 8);
INSERT INTO articles VALUES ('S02', 8);
INSERT INTO articles VALUES ('S03', 8);
INSERT INTO articles VALUES ('A01', 9);
INSERT INTO articles VALUES ('A02', 9);
INSERT INTO articles VALUES ('A03', 9);
INSERT INTO articles VALUES ('A04', 9);
INSERT INTO articles VALUES ('A05', 9);
INSERT INTO articles VALUES ('A10', 10);
INSERT INTO articles VALUES ('A11', 10);
INSERT INTO articles VALUES ('A21', 11);



INSERT INTO lignes_fic (id_fic, id_lig, ref_art, date_depart, date_retour) VALUES (1001, 1, 'F05', GETDATE() - 15, GETDATE() - 13)
INSERT INTO lignes_fic (id_fic, id_lig, ref_art, date_depart, date_retour) VALUES (1001, 2, 'F50', GETDATE() - 15, GETDATE() - 14)
INSERT INTO lignes_fic (id_fic, id_lig, ref_art, date_depart, date_retour) VALUES (1001, 3, 'F60', GETDATE() - 13, DATEADD(hour, 6, (GETDATE() - 13)))

select * from clients

ROLLBACK TRAN insert_client

select * from clients

/*delete articles 
delete categories
delete clients
delete fiches
delete gammes
delete grille_tarifs
delete lignes_fic
delete modeles
*/
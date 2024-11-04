-- R01
select * from clients where nom like 'D%'

-- R02
select nom, prenom from clients

-- R03
select id_fic AS 'Numéro fiche', etat AS 'Etat', c.nom AS 'Nom Client', c.prenom AS 'Prénom client' FROM Fiches f 
LEFT JOIN Clients c ON c.id_cli =  f.id_cli 
WHERE c.cpo LIKE '44%'

-- R04
SELECT f.id_fic AS 'FICHE N°',
c.nom AS 'NOM',
c.prenom AS 'PRENOM',
a.ref_art AS 'Référence',
m.designation AS 'Désignation',
l.date_depart AS 'Départ',
l.date_retour AS 'Retour',
gt.prix_jour AS 'Prix/Jour',
l.duree AS 'Montant'
FROM Fiches f
LEFT JOIN Clients c ON c.id_cli = f.id_cli
LEFT JOIN Lignes_fic l ON l.id_fic = f.id_fic
LEFT JOIN Articles a ON l.ref_art = a.ref_art
LEFT JOIN Modeles m ON a.id_modele = m.id_modele
LEFT JOIN Grille_tarifs gt ON m.id_cate = gt.id_cate AND m.id_gam = gt.id_gam
WHERE f.id_fic = 1002

-- R05
SELECT * FROM Clients c
LEFT JOIN Fiches f ON c.id_cli = f.id_cli
WHERE etat = 'EC'

-- R06
SELECT c.nom, c.prenom, m.designation, l.date_depart, l.date_retour, * FROM Fiches f 
LEFT JOIN Clients c ON c.nom = 'Dupond' AND c.prenom = 'Jean' AND ville = 'Paris'
LEFT JOIN Lignes_fic l ON l.id_fic = f.id_fic
LEFT JOIN Articles a ON a.ref_art = l.ref_art
LEFT JOIN Modeles m ON a.id_modele = m.id_modele
LEFT JOIN Categories cat ON m.id_cate = cat.id_cate 
WHERE f.id_cli = c.id_cli

-- R07
SELECT a.ref_art AS 'Référence', m.designation AS 'Désignation', c.libelle AS 'Libellé de la catégorie' from Articles a
LEFT JOIN Modeles m ON a.id_modele = a.id_modele
LEFT JOIN Categories c ON c.id_cate = m.id_cate
WHERE c.libelle LIKE '%ski%'

-- R08
SELECT c.id_cli AS 'ID Client', c.nom AS 'Nom client', COUNT(l.ref_art) AS 'Nombres de locations'  FROM Clients c 
LEFT JOIN Fiches f ON c.id_cli = f.id_cli
LEFT JOIN Lignes_fic l ON f.id_fic = l.id_fic
GROUP BY c.id_cli, c.nom

-- R09 
SELECT c.id_cli AS 'ID Client', SUM(l.duree * gt.prix_jour) AS 'Dépense en cours' FROM Clients c 
LEFT JOIN Fiches f ON c.id_cli = f.id_cli
LEFT JOIN Lignes_fic l ON f.id_fic = l.id_fic
LEFT JOIN Articles a ON l.ref_art = a.ref_art
LEFT JOIN Modeles m ON a.id_modele = m.id_modele
LEFT JOIN Grille_tarifs gt ON m.id_cate = gt.id_cate AND m.id_gam = gt.id_gam
GROUP BY c.id_cli
HAVING SUM(l.duree * gt.prix_jour) > 100

-- R10
SELECT id_gam, AVG(prix_jour) AS 'Prix du jour moyen' FROM Grille_tarifs GROUP BY id_gam

-- R11
SELECT f.id_fic AS 'FICHE N°',
c.nom + ' ' + c.prenom AS 'NOM Prénom du client',
a.ref_art AS 'Référence',
m.designation AS 'Désignation',
l.date_depart AS 'Départ',
l.date_retour AS 'Retour',
gt.prix_jour AS 'Prix/Jour',
l.duree AS 'Montant',
gt.prix_jour * l.duree AS 'Total'
FROM Fiches f
LEFT JOIN Clients c ON c.id_cli = f.id_cli
LEFT JOIN Lignes_fic l ON l.id_fic = f.id_fic
LEFT JOIN Articles a ON l.ref_art = a.ref_art
LEFT JOIN Modeles m ON a.id_modele = m.id_modele
LEFT JOIN Grille_tarifs gt ON m.id_cate = gt.id_cate AND m.id_gam = gt.id_gam
WHERE f.id_fic = 1002

-- R12
SELECT COUNT(f.id_cli) AS 'Total de fiches', COUNT(case f.etat when 'SO' then 1 else null end ) AS 'Total de fiches soldés' FROM Fiches f 

-- R13
SELECT a.ref_art AS 'Référence', m.designation AS 'Désignation', c.libelle AS 'Libellé de la catégorie', COUNT(l.no_lig) AS 'Nombres de locations' from Articles a
LEFT JOIN Modeles m ON a.id_modele = a.id_modele
LEFT JOIN Categories c ON c.id_cate = m.id_cate
LEFT JOIN Lignes_fic l ON l.ref_art = a.ref_art
WHERE c.libelle = 'SURF'
GROUP BY a.ref_art, m.designation, c.libelle


select ville, COUNT(*) as 'nb client dans la ville' from clients group by ville having(COUNT(*) > 1)
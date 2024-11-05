/*
INSERT INTO cards VALUES ('Liliana of the void', '', 5, 5, 'M21')
INSERT INTO skills VALUES ('Fly', '', 'Fly directly')
INSERT INTO card_skill VALUES (1, 1)
INSERT INTO card_types VALUES (1, 'creature')
INSERT INTO monster_types VALUES (1, 'dragon')
INSERT INTO colors VALUES(1, 'U')
INSERT INTO costs VALUES(1, null, 2, 'B')
INSERT INTO costs VALUES(1, null, 4, 'C')
INSERT INTO card_skill VALUES (1, 1)
*/
USE Magic 

go

SELECT c.id, c.name, c.attack, c.defense, c.extension, 
s.skill_name, 
ct.card_type AS card_type, 
mt.monster_type AS monster_type,
col.colors AS colors,
co.costs AS costs

FROM cards c 
INNER JOIN card_skill cs  ON c.id = cs.card_id 
-- LEFT JOIN skills s ON cs.skill_id = s.id

LEFT JOIN (
    SELECT 
        id, 
        STRING_AGG(s.name, ',') AS skill_name
    FROM 
        skills s
    GROUP BY 
        id
) s ON s.id = cs.skill_id


LEFT JOIN (
    SELECT 
        card_id, 
        STRING_AGG(card_type, ',') AS card_type 
    FROM 
        card_types ct
    GROUP BY 
        card_id
) ct ON ct.card_id = c.id
LEFT JOIN (
    SELECT 
        card_id, 
        STRING_AGG(monster_type, ',') AS monster_type 
    FROM 
        monster_types mt
    GROUP BY 
        card_id
) mt ON mt.card_id = c.id
LEFT JOIN (
    SELECT 
        card_id, 
        STRING_AGG(color, '') AS colors 
    FROM 
        colors col 
    GROUP BY 
        card_id
) col ON col.card_id = c.id
LEFT JOIN (
    SELECT 
        card_id, 
        STRING_AGG(CONVERT(VARCHAR, cost) + color, ',') AS costs 
    FROM 
        costs co
    GROUP BY 
        card_id
) co ON co.card_id = c.id

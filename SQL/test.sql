use test
go

CREATE TABLE personnes (
	id INT PRIMARY KEY IDENTITY,
	name varchar(30) not null,
	firstname varchar(30) CONSTRAINT "UQ_firstname" UNIQUE, 
	CONSTRAINT "CK_personne_firstname" CHECK(firstname IS NOT NULL)
);

CREATE TABLE enfants (
id INT PRIMARY KEY IDENTITY,
name varchar(30),
parentId int not null,
CONSTRAINT FK_enfants_parentId FOREIGN KEY(parentId) REFERENCES personnes(id)
)

ALTER TABLE enfants DROP CONSTRAINT FK_enfants_parentID;

ALTER TABLE enfants ADD CONSTRAINT FK_enfants_parentId FOREIGN KEY (parentID) REFERENCES personnes(id) ON UPDATE CASCADE ON DELETE CASCADE;

INSERT INTO personnes VALUES ('alex', 'rovere');

INSERT INTO enfants VALUES ('elly', 1);

SELECT p.id, p.name, p.firstname, e.name AS "enfant" FROM personnes p LEFT JOIN enfants e ON e.parentId = p.id WHERE p.firstname LIKE 'ra%';



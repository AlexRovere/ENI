use testouille
go

ALTER TABLE cars DROP CONSTRAINT FK_cars_brandId;
ALTER TABLE commandes DROP CONSTRAINT FK_commandes_cars;
ALTER TABLE commandes DROP CONSTRAINT FK_commandes_clients;


DROP TABLE commandes;
DROP TABLE cars;
DROP TABLE brands;
DROP TABLE clients;

CREATE TABLE cars (
	id		INT					CONSTRAINT	PK_cars_id	PRIMARY KEY IDENTITY,
	name	VARCHAR(30)			CONSTRAINT	UQ_cars_name UNIQUE,
	color	VARCHAR(30),
	motor	VARCHAR(30), 
	brandId	INT			not null,
	CONSTRAINT CK_cars_color CHECK (color in('red', 'blue', 'green'))
)

CREATE TABLE brands (
	id		INT			CONSTRAINT PK_brands_id	PRIMARY KEY IDENTITY,
	name	VARCHAR(30),
	price	DECIMAL
)

CREATE TABLE clients (
	id		INT			PRIMARY KEY IDENTITY,
	name	VARCHAR(30),
	quality	VARCHAR(30),
	CONSTRAINT CK_brands_quality CHECK (quality IN('low', 'medium', 'hight'))
)

CREATE TABLE commandes (
	id		INT			PRIMARY KEY IDENTITY,
	carId	INT,
	clientId INT,
	CONSTRAINT CK_commandes_cars		FOREIGN KEY (carId)		REFERENCES cars(id),
	CONSTRAINT CK_commandes_clients		FOREIGN KEY (clientId)	REFERENCES clients(id)
)

ALTER TABLE car ADD CONSTRAINT FK_cars_brandId FOREIGN KEY (brandId) REFERENCES brands(id);

INSERT INTO brands VALUES ('Mazda', 'medium');
INSERT INTO brands VALUES ('Audi', 'hight');

INSERT INTO	clients VALUES ('alex');
INSERT INTO	clients VALUES ('sylvain');

INSERT INTO cars VALUES ('mazda 6', 
select * from brands;
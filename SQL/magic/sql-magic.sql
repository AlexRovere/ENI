use magic
go


ALTER TABLE card_types DROP CONSTRAINT FK_card_types_cards
ALTER TABLE monster_types DROP CONSTRAINT FK_monster_types_cards
ALTER TABLE colors DROP CONSTRAINT FK_colors_cards
ALTER TABLE format DROP CONSTRAINT FK_format_card
ALTER TABLE format DROP CONSTRAINT FK_format_deck
ALTER TABLE deck_card DROP CONSTRAINT FK_deck_card_card 
ALTER TABLE card_skill DROP CONSTRAINT FK_card_skill_card 
ALTER TABLE card_skill DROP CONSTRAINT FK_card_skill_skill 
ALTER TABLE cost DROP CONSTRAINT FK_cost_card
ALTER TABLE cost DROP CONSTRAINT FK_cost_skill


DROP TABLE IF EXISTS cards
DROP TABLE IF EXISTS decks
DROP TABLE IF EXISTS card_types
DROP TABLE IF EXISTS monster_types
DROP TABLE IF EXISTS colors
DROP TABLE IF EXISTS formats
DROP TABLE IF EXISTS deck_card
DROP TABLE IF EXISTS skills
DROP TABLE IF EXISTS costs





CREATE TABLE cards (
	 id INT IDENTITY(1,1) PRIMARY KEY,
	 name varchar(50),
	 description varchar(50),
	 attack	tinyint,
	 defense tinyint,
	 extension varchar(50),
	 	 	 CONSTRAINT CK_cards_extension CHECK(extension in ('M20', 'M21'))
)

CREATE TABLE decks (
	 id INT IDENTITY(1,1) PRIMARY KEY,
	 name varchar(50),
	 sleeve varchar(50),
	 avatar varchar(50),
)

CREATE TABLE card_types (
	 id INT IDENTITY(1,1) PRIMARY KEY,
	 card_id INT CONSTRAINT FK_card_types_cards FOREIGN KEY REFERENCES cards(id),
	 card_type varchar(50),
	 	 CONSTRAINT CK_type CHECK(card_type in ('instant', 'sorcery', 'land', 'creature', 'artifact', 'enchantement', 'aura'))
)

CREATE TABLE monster_types (
	 id INT IDENTITY(1,1) PRIMARY KEY,
	 card_id INT CONSTRAINT FK_monster_types_cards FOREIGN KEY REFERENCES cards(id),
	 monster_type varchar(50),
	 	 CONSTRAINT CK_monster_type CHECK(monster_type in ('elemental', 'human', 'zombie', 'demon', 'dragon'))
)


CREATE TABLE colors (
	 id INT IDENTITY(1,1) PRIMARY KEY,
	 card_id INT CONSTRAINT FK_colors_cards FOREIGN KEY REFERENCES cards(id),
	 color varchar(50) CONSTRAINT CK_color CHECK(color in ('R', 'U', 'W', 'B', 'G', 'C')),
)

CREATE TABLE formats (
	 id INT IDENTITY(1,1) PRIMARY KEY,
	 card_id INT CONSTRAINT FK_format_card FOREIGN KEY REFERENCES cards(id),
	 deck_id INT CONSTRAINT FK_format_deck FOREIGN KEY REFERENCES decks(id),
	 name varchar(50),
	 	 	 CONSTRAINT CK_format_name CHECK(name in ('Standard', 'Commander'))
)

CREATE TABLE deck_card (
	 id INT IDENTITY(1,1) PRIMARY KEY,
	 card_id INT CONSTRAINT FK_deck_card_card FOREIGN KEY REFERENCES cards(id),
	 deck_id INT CONSTRAINT FK_deck_card_deck FOREIGN KEY REFERENCES decks(id)
)

CREATE TABLE skills (
	 id INT IDENTITY(1,1) PRIMARY KEY,
	 name varchar(50),
	 description varchar(50),	
	 effect varchar(50)
)

CREATE TABLE card_skill (
	id INT IDENTITY(1,1) PRIMARY KEY,
	card_id INT CONSTRAINT FK_card_skill_card FOREIGN KEY REFERENCES cards(id),
	skill_id INT CONSTRAINT FK_card_skill_skill FOREIGN KEY REFERENCES skills(id)
)

CREATE TABLE costs (
	 id INT IDENTITY(1,1) PRIMARY KEY,
	 card_id INT CONSTRAINT FK_cost_card FOREIGN KEY REFERENCES cards(id),
	 skill_id INT CONSTRAINT FK_cost_skill FOREIGN KEY REFERENCES skills(id),
	 cost INT,
	 color VARCHAR(50)
	 	 	 CONSTRAINT CK_costs_color CHECK(color in ('R', 'U', 'W', 'B', 'G', 'C'))
)
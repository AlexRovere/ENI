<?php

declare(strict_types=1);

namespace DoctrineMigrations;

use Doctrine\DBAL\Schema\Schema;
use Doctrine\Migrations\AbstractMigration;

/**
 * Auto-generated Migration: Please modify to your needs!
 */
final class Version20250219081425 extends AbstractMigration
{
    public function getDescription(): string
    {
        return '';
    }

    public function up(Schema $schema): void
    {
        // this up() migration is auto-generated, please modify it to your needs
        $this->addSql('CREATE SEQUENCE articles_no_article_seq INCREMENT BY 1 MINVALUE 1 START 1');
        $this->addSql('CREATE SEQUENCE categories_no_categorie_seq INCREMENT BY 1 MINVALUE 1 START 1');
        $this->addSql('CREATE SEQUENCE encheres_no_enchere_seq INCREMENT BY 1 MINVALUE 1 START 1');
        $this->addSql('CREATE SEQUENCE utilisateurs_no_utilisateur_seq INCREMENT BY 1 MINVALUE 1 START 1');
        $this->addSql('CREATE TABLE articles (no_article INT NOT NULL, no_categorie INT NOT NULL, no_utilisateur INT NOT NULL, nom_article VARCHAR(255) NOT NULL, description VARCHAR(255) NOT NULL, date_debut_encheres TIMESTAMP(0) WITHOUT TIME ZONE NOT NULL, date_fin_encheres TIMESTAMP(0) WITHOUT TIME ZONE NOT NULL, prix_initial INT NOT NULL, prix_vente INT DEFAULT NULL, retrait_effectue BOOLEAN NOT NULL, PRIMARY KEY(no_article))');
        $this->addSql('CREATE INDEX IDX_BFDD31689EF104D8 ON articles (no_categorie)');
        $this->addSql('CREATE INDEX IDX_BFDD3168870ABB27 ON articles (no_utilisateur)');
        $this->addSql('CREATE TABLE categories (no_categorie INT NOT NULL, libelle VARCHAR(255) NOT NULL, PRIMARY KEY(no_categorie))');
        $this->addSql('CREATE TABLE encheres (no_enchere INT NOT NULL, no_article INT NOT NULL, no_utilisateur INT NOT NULL, date_enchere TIMESTAMP(0) WITHOUT TIME ZONE NOT NULL, montant_enchere INT NOT NULL, PRIMARY KEY(no_enchere))');
        $this->addSql('CREATE INDEX IDX_8B89031DBC2E22B2 ON encheres (no_article)');
        $this->addSql('CREATE INDEX IDX_8B89031D870ABB27 ON encheres (no_utilisateur)');
        $this->addSql('CREATE TABLE retraits (no_article VARCHAR(255) NOT NULL, rue VARCHAR(255) NOT NULL, code_postal VARCHAR(255) NOT NULL, ville VARCHAR(255) NOT NULL, PRIMARY KEY(no_article))');
        $this->addSql('CREATE TABLE utilisateurs (no_utilisateur INT NOT NULL, pseudo VARCHAR(255) NOT NULL, nom VARCHAR(255) NOT NULL, prenom VARCHAR(255) NOT NULL, email VARCHAR(255) NOT NULL, telephone VARCHAR(255) NOT NULL, rue VARCHAR(255) NOT NULL, code_postal VARCHAR(255) NOT NULL, ville VARCHAR(255) NOT NULL, mot_de_passe VARCHAR(255) NOT NULL, credit INT NOT NULL, administrateur BOOLEAN NOT NULL, PRIMARY KEY(no_utilisateur))');
        $this->addSql('CREATE TABLE messenger_messages (id BIGSERIAL NOT NULL, body TEXT NOT NULL, headers TEXT NOT NULL, queue_name VARCHAR(190) NOT NULL, created_at TIMESTAMP(0) WITHOUT TIME ZONE NOT NULL, available_at TIMESTAMP(0) WITHOUT TIME ZONE NOT NULL, delivered_at TIMESTAMP(0) WITHOUT TIME ZONE DEFAULT NULL, PRIMARY KEY(id))');
        $this->addSql('CREATE INDEX IDX_75EA56E0FB7336F0 ON messenger_messages (queue_name)');
        $this->addSql('CREATE INDEX IDX_75EA56E0E3BD61CE ON messenger_messages (available_at)');
        $this->addSql('CREATE INDEX IDX_75EA56E016BA31DB ON messenger_messages (delivered_at)');
        $this->addSql('COMMENT ON COLUMN messenger_messages.created_at IS \'(DC2Type:datetime_immutable)\'');
        $this->addSql('COMMENT ON COLUMN messenger_messages.available_at IS \'(DC2Type:datetime_immutable)\'');
        $this->addSql('COMMENT ON COLUMN messenger_messages.delivered_at IS \'(DC2Type:datetime_immutable)\'');
        $this->addSql('CREATE OR REPLACE FUNCTION notify_messenger_messages() RETURNS TRIGGER AS $$
            BEGIN
                PERFORM pg_notify(\'messenger_messages\', NEW.queue_name::text);
                RETURN NEW;
            END;
        $$ LANGUAGE plpgsql;');
        $this->addSql('DROP TRIGGER IF EXISTS notify_trigger ON messenger_messages;');
        $this->addSql('CREATE TRIGGER notify_trigger AFTER INSERT OR UPDATE ON messenger_messages FOR EACH ROW EXECUTE PROCEDURE notify_messenger_messages();');
        $this->addSql('ALTER TABLE articles ADD CONSTRAINT FK_BFDD31689EF104D8 FOREIGN KEY (no_categorie) REFERENCES categories (no_categorie) NOT DEFERRABLE INITIALLY IMMEDIATE');
        $this->addSql('ALTER TABLE articles ADD CONSTRAINT FK_BFDD3168870ABB27 FOREIGN KEY (no_utilisateur) REFERENCES utilisateurs (no_utilisateur) NOT DEFERRABLE INITIALLY IMMEDIATE');
        $this->addSql('ALTER TABLE encheres ADD CONSTRAINT FK_8B89031DBC2E22B2 FOREIGN KEY (no_article) REFERENCES articles (no_article) NOT DEFERRABLE INITIALLY IMMEDIATE');
        $this->addSql('ALTER TABLE encheres ADD CONSTRAINT FK_8B89031D870ABB27 FOREIGN KEY (no_utilisateur) REFERENCES utilisateurs (no_utilisateur) NOT DEFERRABLE INITIALLY IMMEDIATE');
    }

    public function down(Schema $schema): void
    {
        // this down() migration is auto-generated, please modify it to your needs
        $this->addSql('CREATE SCHEMA public');
        $this->addSql('DROP SEQUENCE articles_no_article_seq CASCADE');
        $this->addSql('DROP SEQUENCE categories_no_categorie_seq CASCADE');
        $this->addSql('DROP SEQUENCE encheres_no_enchere_seq CASCADE');
        $this->addSql('DROP SEQUENCE utilisateurs_no_utilisateur_seq CASCADE');
        $this->addSql('ALTER TABLE articles DROP CONSTRAINT FK_BFDD31689EF104D8');
        $this->addSql('ALTER TABLE articles DROP CONSTRAINT FK_BFDD3168870ABB27');
        $this->addSql('ALTER TABLE encheres DROP CONSTRAINT FK_8B89031DBC2E22B2');
        $this->addSql('ALTER TABLE encheres DROP CONSTRAINT FK_8B89031D870ABB27');
        $this->addSql('DROP TABLE articles');
        $this->addSql('DROP TABLE categories');
        $this->addSql('DROP TABLE encheres');
        $this->addSql('DROP TABLE retraits');
        $this->addSql('DROP TABLE utilisateurs');
        $this->addSql('DROP TABLE messenger_messages');
    }
}

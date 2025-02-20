<?php

declare(strict_types=1);

namespace DoctrineMigrations;

use Doctrine\DBAL\Schema\Schema;
use Doctrine\Migrations\AbstractMigration;

/**
 * Auto-generated Migration: Please modify to your needs!
 */
final class Version20250220143431 extends AbstractMigration
{
    public function getDescription(): string
    {
        return '';
    }

    public function up(Schema $schema): void
    {
        // this up() migration is auto-generated, please modify it to your needs
        $this->addSql('CREATE TABLE wish_category (wish_id INT NOT NULL, category_id INT NOT NULL, PRIMARY KEY(wish_id, category_id))');
        $this->addSql('CREATE INDEX IDX_167D52BE42B83698 ON wish_category (wish_id)');
        $this->addSql('CREATE INDEX IDX_167D52BE12469DE2 ON wish_category (category_id)');
        $this->addSql('ALTER TABLE wish_category ADD CONSTRAINT FK_167D52BE42B83698 FOREIGN KEY (wish_id) REFERENCES wish (id) ON DELETE CASCADE NOT DEFERRABLE INITIALLY IMMEDIATE');
        $this->addSql('ALTER TABLE wish_category ADD CONSTRAINT FK_167D52BE12469DE2 FOREIGN KEY (category_id) REFERENCES category (id) ON DELETE CASCADE NOT DEFERRABLE INITIALLY IMMEDIATE');
        $this->addSql('ALTER TABLE category_wish DROP CONSTRAINT fk_5c4a0e8e12469de2');
        $this->addSql('ALTER TABLE category_wish DROP CONSTRAINT fk_5c4a0e8e42b83698');
        $this->addSql('DROP TABLE category_wish');
    }

    public function down(Schema $schema): void
    {
        // this down() migration is auto-generated, please modify it to your needs
        $this->addSql('CREATE SCHEMA public');
        $this->addSql('CREATE TABLE category_wish (category_id INT NOT NULL, wish_id INT NOT NULL, PRIMARY KEY(category_id, wish_id))');
        $this->addSql('CREATE INDEX idx_5c4a0e8e42b83698 ON category_wish (wish_id)');
        $this->addSql('CREATE INDEX idx_5c4a0e8e12469de2 ON category_wish (category_id)');
        $this->addSql('ALTER TABLE category_wish ADD CONSTRAINT fk_5c4a0e8e12469de2 FOREIGN KEY (category_id) REFERENCES category (id) ON DELETE CASCADE NOT DEFERRABLE INITIALLY IMMEDIATE');
        $this->addSql('ALTER TABLE category_wish ADD CONSTRAINT fk_5c4a0e8e42b83698 FOREIGN KEY (wish_id) REFERENCES wish (id) ON DELETE CASCADE NOT DEFERRABLE INITIALLY IMMEDIATE');
        $this->addSql('ALTER TABLE wish_category DROP CONSTRAINT FK_167D52BE42B83698');
        $this->addSql('ALTER TABLE wish_category DROP CONSTRAINT FK_167D52BE12469DE2');
        $this->addSql('DROP TABLE wish_category');
    }
}

<?php

declare(strict_types=1);

namespace DoctrineMigrations;

use Doctrine\DBAL\Schema\Schema;
use Doctrine\Migrations\AbstractMigration;

/**
 * Auto-generated Migration: Please modify to your needs!
 */
final class Version20250220132038 extends AbstractMigration
{
    public function getDescription(): string
    {
        return '';
    }

    public function up(Schema $schema): void
    {
        // this up() migration is auto-generated, please modify it to your needs
        $this->addSql('ALTER TABLE wish_category DROP CONSTRAINT fk_167d52be42b83698');
        $this->addSql('ALTER TABLE wish_category DROP CONSTRAINT fk_167d52be12469de2');
        $this->addSql('DROP TABLE wish_category');
    }

    public function down(Schema $schema): void
    {
        // this down() migration is auto-generated, please modify it to your needs
        $this->addSql('CREATE SCHEMA public');
        $this->addSql('CREATE TABLE wish_category (wish_id INT NOT NULL, category_id INT NOT NULL, PRIMARY KEY(wish_id, category_id))');
        $this->addSql('CREATE INDEX idx_167d52be12469de2 ON wish_category (category_id)');
        $this->addSql('CREATE INDEX idx_167d52be42b83698 ON wish_category (wish_id)');
        $this->addSql('ALTER TABLE wish_category ADD CONSTRAINT fk_167d52be42b83698 FOREIGN KEY (wish_id) REFERENCES wish (id) ON DELETE CASCADE NOT DEFERRABLE INITIALLY IMMEDIATE');
        $this->addSql('ALTER TABLE wish_category ADD CONSTRAINT fk_167d52be12469de2 FOREIGN KEY (category_id) REFERENCES category (id) ON DELETE CASCADE NOT DEFERRABLE INITIALLY IMMEDIATE');
    }
}

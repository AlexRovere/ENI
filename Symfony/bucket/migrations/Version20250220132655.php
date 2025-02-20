<?php

declare(strict_types=1);

namespace DoctrineMigrations;

use Doctrine\DBAL\Schema\Schema;
use Doctrine\Migrations\AbstractMigration;

/**
 * Auto-generated Migration: Please modify to your needs!
 */
final class Version20250220132655 extends AbstractMigration
{
    public function getDescription(): string
    {
        return '';
    }

    public function up(Schema $schema): void
    {
        // this up() migration is auto-generated, please modify it to your needs
        $this->addSql('CREATE TABLE category_wish (category_id INT NOT NULL, wish_id INT NOT NULL, PRIMARY KEY(category_id, wish_id))');
        $this->addSql('CREATE INDEX IDX_5C4A0E8E12469DE2 ON category_wish (category_id)');
        $this->addSql('CREATE INDEX IDX_5C4A0E8E42B83698 ON category_wish (wish_id)');
        $this->addSql('ALTER TABLE category_wish ADD CONSTRAINT FK_5C4A0E8E12469DE2 FOREIGN KEY (category_id) REFERENCES category (id) ON DELETE CASCADE NOT DEFERRABLE INITIALLY IMMEDIATE');
        $this->addSql('ALTER TABLE category_wish ADD CONSTRAINT FK_5C4A0E8E42B83698 FOREIGN KEY (wish_id) REFERENCES wish (id) ON DELETE CASCADE NOT DEFERRABLE INITIALLY IMMEDIATE');
    }

    public function down(Schema $schema): void
    {
        // this down() migration is auto-generated, please modify it to your needs
        $this->addSql('CREATE SCHEMA public');
        $this->addSql('ALTER TABLE category_wish DROP CONSTRAINT FK_5C4A0E8E12469DE2');
        $this->addSql('ALTER TABLE category_wish DROP CONSTRAINT FK_5C4A0E8E42B83698');
        $this->addSql('DROP TABLE category_wish');
    }
}

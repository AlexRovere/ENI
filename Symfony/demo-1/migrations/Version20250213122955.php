<?php

declare(strict_types=1);

namespace DoctrineMigrations;

use Doctrine\DBAL\Schema\Schema;
use Doctrine\Migrations\AbstractMigration;

/**
 * Auto-generated Migration: Please modify to your needs!
 */
final class Version20250213122955 extends AbstractMigration
{
    public function getDescription(): string
    {
        return '';
    }

    public function up(Schema $schema): void
    {
        // this up() migration is auto-generated, please modify it to your needs
        $this->addSql('ALTER TABLE wish ADD title VARCHAR(250) NOT NULL');
        $this->addSql('ALTER TABLE wish ADD description VARCHAR(255) NOT NULL');
        $this->addSql('ALTER TABLE wish ADD author VARCHAR(50) NOT NULL');
        $this->addSql('ALTER TABLE wish ADD is_published BOOLEAN NOT NULL');
        $this->addSql('ALTER TABLE wish ADD date_created TIMESTAMP(0) WITHOUT TIME ZONE NOT NULL');
    }

    public function down(Schema $schema): void
    {
        // this down() migration is auto-generated, please modify it to your needs
        $this->addSql('CREATE SCHEMA public');
        $this->addSql('ALTER TABLE wish DROP title');
        $this->addSql('ALTER TABLE wish DROP description');
        $this->addSql('ALTER TABLE wish DROP author');
        $this->addSql('ALTER TABLE wish DROP is_published');
        $this->addSql('ALTER TABLE wish DROP date_created');
    }
}

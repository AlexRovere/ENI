<?php

namespace App\Entity;

use App\Repository\EnchereRepository;
use Doctrine\DBAL\Types\Types;
use Doctrine\ORM\Mapping as ORM;

#[ORM\Entity(repositoryClass: EnchereRepository::class)]
#[ORM\Table(name: 'encheres')]
class Enchere
{
    #[ORM\Id]
    #[ORM\GeneratedValue(strategy: "IDENTITY")]
    #[ORM\Column(name: 'no_enchere')]
    private ?int $noEnchere = null;

    #[ORM\Column(type: Types::DATETIME_MUTABLE)]
    private ?\DateTimeInterface $dateEnchere = null;

    #[ORM\Column]
    private ?int $montantEnchere = null;

    #[ORM\ManyToOne(inversedBy: 'encheres')]
    #[ORM\JoinColumn(name: 'no_article', referencedColumnName: 'no_article', nullable: false)]
    private ?Article $article = null;

    #[ORM\ManyToOne(inversedBy: 'encheres')]
    #[ORM\JoinColumn(name: 'no_utilisateur', referencedColumnName: 'no_utilisateur', nullable: false)]
    private ?Utilisateur $utilisateur = null;

    public function getNoEnchere(): ?int
    {
        return $this->noEnchere;
    }

    public function setNoEnchere(int $noEnchere): static
    {
        $this->noEnchere = $noEnchere;

        return $this;
    }

    public function getDateEnchere(): ?\DateTimeInterface
    {
        return $this->dateEnchere;
    }

    public function setDateEnchere(\DateTimeInterface $dateEnchere): static
    {
        $this->dateEnchere = $dateEnchere;

        return $this;
    }

    public function getMontantEnchere(): ?int
    {
        return $this->montantEnchere;
    }

    public function setMontantEnchere(int $montantEnchere): static
    {
        $this->montantEnchere = $montantEnchere;

        return $this;
    }

    public function getArticle(): ?Article
    {
        return $this->article;
    }

    public function setArticle(?Article $article): static
    {
        $this->article = $article;

        return $this;
    }

    public function getUtilisateur(): ?Utilisateur
    {
        return $this->utilisateur;
    }

    public function setUtilisateur(?Utilisateur $utilisateur): static
    {
        $this->utilisateur = $utilisateur;

        return $this;
    }
}

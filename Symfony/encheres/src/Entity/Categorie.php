<?php

namespace App\Entity;

use App\Repository\CategorieRepository;
use Doctrine\ORM\Mapping as ORM;

#[ORM\Entity(repositoryClass: CategorieRepository::class)]
#[ORM\Table(name: 'categories')]
class Categorie
{
    #[ORM\Id]
    #[ORM\GeneratedValue]
    #[ORM\Column]
    private ?int $noCategorie = null;

    #[ORM\Column(length: 255)]
    private ?string $libelle = null;

    public function getNoCategorie(): ?int
    {
        return $this->noCategorie;
    }

    public function setNoCategorie(int $noCategorie): static
    {
        $this->noCategorie = $noCategorie;

        return $this;
    }

    public function getLibelle(): ?string
    {
        return $this->libelle;
    }

    public function setLibelle(string $libelle): static
    {
        $this->libelle = $libelle;

        return $this;
    }
}

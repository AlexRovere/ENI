<?php

namespace App\Entity;

use App\Repository\CategorieRepository;
use Doctrine\ORM\Mapping as ORM;
use Symfony\Bridge\Doctrine\Validator\Constraints\UniqueEntity;
use Symfony\Component\Validator\Constraints as Assert;

#[ORM\Entity(repositoryClass: CategorieRepository::class)]
#[ORM\Table(name: 'categories')]
#[UniqueEntity("libelle", message: 'Ce libellé existe déjà')]
class Categorie
{
    #[ORM\Id]
    #[ORM\GeneratedValue(strategy: "SEQUENCE")]
    #[ORM\Column]
    private ?int $noCategorie = null;

    #[ORM\Column(length: 255, type: 'string', unique: true)]
    #[Assert\NotBlank(message: "Le libellé doit être renseigné")]
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

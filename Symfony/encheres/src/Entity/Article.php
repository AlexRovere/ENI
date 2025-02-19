<?php

namespace App\Entity;

use App\Enum\EtatVente;
use App\Repository\ArticleRepository;
use Doctrine\Common\Collections\ArrayCollection;
use Doctrine\Common\Collections\Collection;
use Doctrine\DBAL\Types\Types;
use Doctrine\ORM\Mapping as ORM;
use Symfony\Component\Validator\Constraints as Assert;

#[ORM\Entity(repositoryClass: ArticleRepository::class)]
#[ORM\Table(name: 'articles')]
#[ORM\HasLifecycleCallbacks]
class Article
{
    #[ORM\Id]
    #[ORM\GeneratedValue(strategy: "SEQUENCE")]
    #[ORM\Column(name: 'no_article')]
    private ?int $noArticle = null;

    #[ORM\Column(length: 255)]
    #[Assert\NotBlank()]
    private ?string $nomArticle = null;

    #[ORM\Column(length: 255)]
    private ?string $description = null;

    #[ORM\Column(type: Types::DATETIME_MUTABLE)]
    private ?\DateTimeInterface $dateDebutEncheres = null;

    #[ORM\Column(type: Types::DATETIME_MUTABLE)]
    private ?\DateTimeInterface $dateFinEncheres = null;

    #[ORM\Column]
    private ?int $prixInitial = null;

    #[ORM\Column(nullable: true)]
    private ?int $prixVente = null;

    private ?EtatVente $etatVente = null;

    #[ORM\Column]
    private ?bool $retraitEffectue = null;

    /**
     * @var Collection<int, Retrait>
     */
    #[ORM\OneToMany(mappedBy: 'article', targetEntity: Retrait::class)]
    private Collection $retraits;

    #[ORM\ManyToOne]
    #[ORM\JoinColumn(name: 'no_categorie', referencedColumnName: 'no_categorie', nullable: false)]
    private ?Categorie $categorie = null;

    #[ORM\ManyToOne(inversedBy: 'encheres')]
    #[ORM\JoinColumn(name: 'no_utilisateur', referencedColumnName: 'no_utilisateur', nullable: false)]
    private ?Utilisateur $utilisateur = null;

    /**
     * @var Collection<int, Enchere>
     */
    #[ORM\OneToMany(targetEntity: Enchere::class, mappedBy: 'article')]
    private Collection $encheres;

    public function __construct()
    {
        $this->encheres = new ArrayCollection();
        $this->retraits = new ArrayCollection();
    }

    public function getNoArticle(): ?int
    {
        return $this->noArticle;
    }

    public function getNomArticle(): ?string
    {
        return $this->nomArticle;
    }

    public function setNomArticle(string $nomArticle): static
    {
        $this->nomArticle = $nomArticle;
        return $this;
    }

    public function getDescription(): ?string
    {
        return $this->description;
    }

    public function setDescription(string $description): static
    {
        $this->description = $description;
        return $this;
    }

    public function getDateDebutEncheres(): ?\DateTimeInterface
    {
        return $this->dateDebutEncheres;
    }

    public function setDateDebutEncheres(\DateTimeInterface $dateDebutEncheres): static
    {
        $this->dateDebutEncheres = $dateDebutEncheres;
        return $this;
    }

    public function getDateFinEncheres(): ?\DateTimeInterface
    {
        return $this->dateFinEncheres;
    }

    public function setDateFinEncheres(\DateTimeInterface $dateFinEncheres): static
    {
        $this->dateFinEncheres = $dateFinEncheres;
        return $this;
    }

    public function getPrixInitial(): ?int
    {
        return $this->prixInitial;
    }

    public function setPrixInitial(int $prixInitial): static
    {
        $this->prixInitial = $prixInitial;
        return $this;
    }

    public function getPrixVente(): ?int
    {
        return $this->prixVente;
    }

    public function setPrixVente(?int $prixVente): static
    {
        $this->prixVente = $prixVente;
        return $this;
    }

    public function getEtatVente(): ?EtatVente
    {
        return $this->etatVente;
    }

    public function setEtatVente(EtatVente $etatVente): static
    {
        $this->etatVente = $etatVente;
        return $this;
    }

    public function isRetraitEffectue(): ?bool
    {
        return $this->retraitEffectue;
    }

    public function setRetraitEffectue(bool $retraitEffectue): static
    {
        $this->retraitEffectue = $retraitEffectue;
        return $this;
    }

    /**
     * @return Collection<int, Retrait>
     */
    public function getRetraits(): Collection
    {
        return $this->retraits;
    }

    public function addRetrait(Retrait $retrait): static
    {
        if (!$this->retraits->contains($retrait)) {
            $this->retraits->add($retrait);
            $retrait->setArticle($this);
        }
        return $this;
    }

    public function removeRetrait(Retrait $retrait): static
    {
        if ($this->retraits->removeElement($retrait)) {
            // set the owning side to null (unless already changed)
            if ($retrait->getArticle() === $this) {
                $retrait->setArticle(null);
            }
        }
        return $this;
    }

    public function getCategorie(): ?Categorie
    {
        return $this->categorie;
    }

    public function setCategorie(?Categorie $categorie): static
    {
        $this->categorie = $categorie;
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

    /**
     * @return Collection<int, Enchere>
     */
    public function getEncheres(): Collection
    {
        return $this->encheres;
    }

    public function addEnchere(Enchere $enchere): static
    {
        if (!$this->encheres->contains($enchere)) {
            $this->encheres->add($enchere);
            $enchere->setArticle($this);
        }
        return $this;
    }

    public function removeEnchere(Enchere $enchere): static
    {
        if ($this->encheres->removeElement($enchere)) {
            // set the owning side to null (unless already changed)
            if ($enchere->getArticle() === $this) {
                $enchere->setArticle(null);
            }
        }
        return $this;
    }

    #[ORM\PrePersist]
    public function onPersist(): void {
        $this->setRetraitEffectue(false);
    }
}

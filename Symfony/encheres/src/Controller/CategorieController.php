<?php

namespace App\Controller;

use App\Entity\Categorie;
use App\Form\CategorieType;
use App\Repository\CategorieRepository;
use Doctrine\ORM\EntityManagerInterface;
use Symfony\Bundle\FrameworkBundle\Controller\AbstractController;
use Symfony\Component\HttpFoundation\Request;
use Symfony\Component\HttpFoundation\Response;
use Symfony\Component\Routing\Attribute\Route;
use Symfony\Component\Routing\Exception\ResourceNotFoundException;
use Symfony\Component\Translation\Exception\NotFoundResourceException;

#[Route('/categorie', name: 'app_categorie_')]
final class CategorieController extends AbstractController
{

    private EntityManagerInterface $em;
    private CategorieRepository $categorieRepository;

    public function __construct(EntityManagerInterface $em)
    {
        $this->em = $em;
        $this->categorieRepository = $em->getRepository(Categorie::class);
    }

    #[Route('', name: 'list')]
    public function listCategorie(): Response
    {
        return $this->render('categorie/index.html.twig', [
            "categories" => $this->categorieRepository->findAll()

        ]);
    }

    #[Route('/detail/{id}', name: 'detail')]
    public function detailCategorie(Categorie $categorie, Request $request): Response
    {
        if(!isset($categorie)) {
            throw new ResourceNotFoundException();
        }
        return $this->render('categorie/detail.html.twig', [
            "categorie" => $categorie
        ]);
    }

    #[Route('/create', name: 'create')]
    public function createCategorie(Request $request): Response
    {
        $categorie = new Categorie();
        $form = $this->createForm(CategorieType::class, $categorie);
        $form->handleRequest($request);
        if ($form->isSubmitted() && $form->isValid()) {
            $this->em->persist($categorie);
            $this->em->flush();
            return $this->redirectToRoute("app_categorie_list");
        }
        return $this->render('categorie/save.html.twig', [
            "form" => $form
        ]);
    }

    #[Route('/update', name: 'update')]
    public function updateCategorie(Request $request): Response
    {
        $categorie = new Categorie();
        $form = $this->createForm(CategorieType::class, $categorie);
        $form->handleRequest($request);
        if ($form->isSubmitted() && $form->isValid()) {
            $this->em->persist($categorie);
            $this->em->flush();
            return $this->redirectToRoute("app_categorie_list");
        }
        return $this->render('categorie/save.html.twig', [
            "form" => $form
        ]);
    }
}

<?php

namespace App\Controller;

use App\Entity\Wish;
use App\Form\WishType;
use Doctrine\ORM\EntityManagerInterface;
use Symfony\Bundle\FrameworkBundle\Controller\AbstractController;
use Symfony\Component\HttpFoundation\Request;
use Symfony\Component\HttpFoundation\Response;
use Symfony\Component\Routing\Attribute\Route;
use Symfony\Component\Security\Core\Exception\AccessDeniedException;
use Symfony\Component\Security\Http\Attribute\IsGranted;

final class WishController extends AbstractController
{
    #[Route('/wish', name: 'app_wish')]
    public function index(EntityManagerInterface $em): Response
    {
        $wishesRepo = $em->getRepository(Wish::class);
        return $this->render('wish/index.html.twig', [
            'controller_name' => 'WishController',
            'wishes' => $wishesRepo->findAll()
        ]);
    }

    #[Route('/wish/{id}', name: 'app_wish_detail', requirements: ['id' => '\d+'])]
    public function detail(int $id, EntityManagerInterface $em): Response
    {
        $wishRepo = $em->getRepository(Wish::class);
        $wish = $wishRepo->find($id);
        $categories = $wish->getCategories();
        if (!$id || !isset($wish)) {
            return $this->redirect('/');
        }
        return $this->render('wish/detail.html.twig', [
            'wish' => $wish
        ]);
    }

    #[IsGranted('ROLE_USER')]
    #[Route('wish/create', name: 'app_wish_create')]
    public function createWish(Request $request, EntityManagerInterface $em): Response
    {
        $wish = new Wish();
        $wishForm = $this->createForm(WishType::class, $wish);
        $wishForm->handleRequest($request);

        if ($wishForm->isSubmitted() && $wishForm->isValid()) {
            $wish->setAuthor($this->getUser()->getUserIdentifier());
            $em->persist($wish);
            $em->flush();
            $this->addFlash('success', 'le wish a bien été créée');
            return $this->redirectToRoute("app_wish_detail", [
                "id" => $wish->getId()
            ]);
        }
        return $this->render('wish/save.html.twig', [
            'form' => $wishForm
        ]);
    }

    #[IsGranted('ROLE_USER')]
    #[Route('wish/update/{id}', name: 'app_wish_update', requirements: ['id' => '\d+'])]
    public function updateWish(Wish $wish, Request $request, EntityManagerInterface $em): Response
    {
        if($wish->getAuthor() !== $this->getUser()->getUserIdentifier()) {
            throw new AccessDeniedException();
        }
        $wishForm = $this->createForm(WishType::class, $wish);
        $wishForm->handleRequest($request);

        if ($wishForm->isSubmitted() && $wishForm->isValid()) {
            $em->persist($wish);
            $em->flush();
            $this->addFlash('success', 'le wish a bien été modifié');
            return $this->redirectToRoute("app_wish_detail", [
                "id" => $wish->getId()
            ]);
        }
        return $this->render('wish/save.html.twig', [
            'form' => $wishForm
        ]);
    }

    #[IsGranted('ROLE_USER')]
    #[Route('/wish/delete/{id}', name: 'app_wish_delete', requirements: ['id' => '\d+'])]
    public function deleteWish(Wish $wish, EntityManagerInterface $em): Response
    {
        if($wish->getAuthor() !== $this->getUser()->getUserIdentifier() && !$this->isGranted("ROLE_ADMIN")) {
            throw new AccessDeniedException();
        }
        $em->remove($wish);
        $em->flush();
        $this->addFlash('success', 'le wish a bien été supprimé');
        return $this->redirect('/wish');
    }
}

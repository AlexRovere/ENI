<?php

namespace App\Controller;

use App\Entity\Wish;
use App\Form\WishType;
use App\Repository\WishRepository;
use DateTime;
use Doctrine\ORM\EntityManagerInterface;
use Symfony\Bundle\FrameworkBundle\Controller\AbstractController;
use Symfony\Component\HttpFoundation\Request;
use Symfony\Component\HttpFoundation\Response;
use Symfony\Component\Routing\Attribute\Route;
use Symfony\Component\Validator\Constraints\Date;

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
        if (!$id || !isset($wish)) {
            return $this->redirect('/');
        }
        return $this->render('wish/detail.html.twig', [
            'wish' => $wish
        ]);
    }

    #[Route('wish/create', name: 'app_wish_create')]
    public function createWish(Request $request, EntityManagerInterface $em): Response
    {
        $wish = new Wish();
        $wishForm = $this->createForm(WishType::class, $wish);
        $wishForm->handleRequest($request);

        if($wishForm->isSubmitted() && $wishForm->isValid()) {
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

    #[Route('wish/update/{id}', name: 'app_wish_update',   requirements: ['id' => '\d+'])]
    public function updateWish(Request $request, EntityManagerInterface $em, Wish $wish): Response
    {
        $wishForm = $this->createForm(WishType::class, $wish);
        $wishForm->handleRequest($request);

        if($wishForm->isSubmitted() && $wishForm->isValid()) {
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

    #[Route('/wish/delete/{id}', name: 'app_wish_delete', requirements: ['id' => '\d+'])]
    public function deleteWish(int $id, EntityManagerInterface $em): Response
    {
        $wishRepo = $em->getRepository(Wish::class);
        $wish = $wishRepo->find($id);
        if (!$id || !isset($wish)) {
            return $this->redirect('/wish');
        }
        $em->remove($wish);
        $em->flush();
        $this->addFlash('success', 'le wish a bien été supprimé');
        return $this->redirect('/wish');
    }
}

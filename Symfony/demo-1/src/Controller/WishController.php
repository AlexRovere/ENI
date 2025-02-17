<?php

namespace App\Controller;

use App\Entity\Wish;
use App\Repository\WishRepository;
use DateTime;
use Doctrine\ORM\EntityManagerInterface;
use Symfony\Bundle\FrameworkBundle\Controller\AbstractController;
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
}

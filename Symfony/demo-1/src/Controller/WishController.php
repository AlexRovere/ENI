<?php

namespace App\Controller;

use Symfony\Bundle\FrameworkBundle\Controller\AbstractController;
use Symfony\Component\HttpFoundation\Response;
use Symfony\Component\Routing\Attribute\Route;

final class WishController extends AbstractController
{
    #[Route('/wish', name: 'app_wish')]
    public function index(): Response
    {
        $wishes = [
            ["label" => "mon premier souhait"],
            ["label" => "mon deuxième souhait"],
        ];
        return $this->render('wish/index.html.twig', [
            'controller_name' => 'WishController',
            'wishes' => $wishes
        ]);
    }

    #[Route('/wish/{id}', name: 'app_wish_detail')]
    public function detail(int $id): Response
    {
        return $this->render('wish/detail.html.twig', [
            'id' => $id
        ]);
    }
}

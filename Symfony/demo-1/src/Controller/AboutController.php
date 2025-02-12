<?php

namespace App\Controller;

use Symfony\Bundle\FrameworkBundle\Controller\AbstractController;
use Symfony\Component\HttpFoundation\Response;
use Symfony\Component\Routing\Attribute\Route;

final class AboutController extends AbstractController
{
    #[Route('/about', name: 'app_about')]
    public function index(): Response
    {
        $teams = json_decode(file_get_contents( '../data/team.json'));
        dump($teams);
        return $this->render('about/index.html.twig', [
            "teams" => $teams
        ]);
    }
}

<?php

namespace App\Controller;

use App\Entity\Article;
use App\Form\ArticleType;
use Doctrine\ORM\EntityManagerInterface;
use Symfony\Bundle\FrameworkBundle\Controller\AbstractController;
use Symfony\Component\HttpFoundation\Request;
use Symfony\Component\HttpFoundation\Response;
use Symfony\Component\Routing\Attribute\Route;

final class ArticleController extends AbstractController
{
    #[Route('/', name: 'app_home')]
    public function index(EntityManagerInterface $em): Response
    {
        $articleRepo = $em->getRepository(Article::class);

        return $this->render('article/index.html.twig', [
            'articles' => $articleRepo->findAll()
        ]);
    }

    #[Route('/detail/{id}', name: 'app_article_detail', methods: 'GET')]
    public function detail(string $id, EntityManagerInterface $em): Response
    {
        $articleRepo = $em->getRepository(Article::class);

        $article = $articleRepo->find($id);

        if(!$id || !isset($article)) {
            return $this->redirect("/");
        }

        return $this->render('article/detail.html.twig', [
            'article' => $article
        ]);
    }

    #[Route('/create', name: 'app_article_create')]
    public function createArticle(Request $request): Response
    {
        $article = new Article();
        $form = $this->createForm(ArticleType::class, $article);
        $form->handleRequest($request);
        if($form->isSubmitted() && $form->isValid()) {
            dd($article);
        }

        return $this->render('article/create.html.twig', [
            'form' => $form
        ]);
    }
}

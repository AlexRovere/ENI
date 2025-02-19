<?php

namespace App\Controller;

use App\Entity\Article;
use App\Entity\Categorie;
use App\Form\ArticleType;
use App\Repository\ArticleRepository;
use App\Repository\CategorieRepository;
use Doctrine\ORM\EntityManagerInterface;
use Symfony\Bundle\FrameworkBundle\Controller\AbstractController;
use Symfony\Component\HttpFoundation\Request;
use Symfony\Component\HttpFoundation\Response;
use Symfony\Component\Routing\Attribute\Route;
use Symfony\Component\Routing\Exception\ResourceNotFoundException;

#[Route('', name: 'app_article_')]
final class ArticleController extends AbstractController
{
    private readonly EntityManagerInterface $em;
    private readonly ArticleRepository $articleRepo;

    public function __construct(EntityManagerInterface $em)
    {
        $this->em = $em;
        $this->articleRepo = $em->getRepository(Article::class);
    }

    #[Route('/', name: 'list')]
    public function index(): Response
    {
        $categorieRepo = $this->em->getRepository(Categorie::class);
        return $this->render('article/index.html.twig', [
            'articles' => $this->articleRepo->findAll(),
            'categories' => $categorieRepo->findAll()
        ]);
    }

    #[Route('/detail/{id}', name: 'detail', requirements: ['id' => '\d+'], methods: 'GET')]
    public function detail(string $id): Response
    {

        $article = $this->articleRepo->find($id);

        if(!$id || !isset($article)) {
            throw new ResourceNotFoundException();
        }

        return $this->render('article/detail.html.twig', [
            'article' => $article
        ]);
    }

    #[Route('/create', name: 'create')]
    public function createArticle(Request $request): Response
    {
        $article = new Article();
        $form = $this->createForm(ArticleType::class, $article);
        $form->handleRequest($request);
        if($form->isSubmitted() && $form->isValid()) {
            $this->em->persist($article);
            $this->em->flush();
        }

        return $this->render('article/create.html.twig', [
            'form' => $form
        ]);
    }

    #[Route('/update', name: 'update')]
    public function updateArticle(Request $request): Response
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

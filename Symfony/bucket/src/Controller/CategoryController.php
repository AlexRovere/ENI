<?php

namespace App\Controller;

use App\Entity\Category;
use App\Entity\Wish;
use App\Form\CategoryType;
use App\Repository\CategoryRepository;
use Doctrine\ORM\EntityManagerInterface;
use Symfony\Bundle\FrameworkBundle\Controller\AbstractController;
use Symfony\Component\HttpFoundation\Request;
use Symfony\Component\HttpFoundation\Response;
use Symfony\Component\Routing\Attribute\Route;
use Symfony\Component\Security\Core\Exception\AccessDeniedException;
use Symfony\Component\Security\Http\Attribute\IsGranted;
#[Route('/category', name: 'app_category_')]
#[IsGranted("ROLE_ADMIN")]
final class CategoryController extends AbstractController
{
    private readonly EntityManagerInterface $em;
    private readonly CategoryRepository $categorieRepository;
    public function __construct(EntityManagerInterface $em, CategoryRepository $categoryRepository)
    {
        $this->em =$em;
        $this->categorieRepository =$categoryRepository;
    }

    #[Route('', name: 'list')]
    public function index(): Response
    {
        return $this->render('category/index.html.twig', [
            'categories' => $this->categorieRepository->findAll(),
        ]);
    }

    #[Route('/{id}', name: 'detail', requirements: ['id' => '\d+'])]
    public function detail(Category $category, EntityManagerInterface $em): Response
    {
        return $this->render('category/detail.html.twig', [
            'category' => $category
        ]);
    }

    #[Route('/create', name: 'create')]
    public function create(Request $request): Response
    {
        $category = new Category();
        $categoryForm = $this->createForm(CategoryType::class, $category);
        $categoryForm->handleRequest($request);

        if ($categoryForm->isSubmitted() && $categoryForm->isValid()) {
            $this->em->persist($category);
            $this->em->flush();
            $this->addFlash('success', 'la catégorie a bien été créée');
            return $this->redirectToRoute("app_category_list");
        }
        return $this->render('category/save.html.twig', [
            'form' => $categoryForm
        ]);
    }

    #[Route('/update/{id}', name: 'update',  requirements: ['id' => '\d+'])]
    public function update(Category $category, Request $request): Response
    {
        $categoryForm = $this->createForm(CategoryType::class, $category);
        $categoryForm->handleRequest($request);

        if ($categoryForm->isSubmitted() && $categoryForm->isValid()) {
            $this->em->persist($category);
            $this->em->flush();
            $this->addFlash('success', 'la catégorie a bien été modifié');
            return $this->redirectToRoute("app_category_detail", [
                "id" => $category->getId()
            ]);
        }
        return $this->render('category/save.html.twig', [
            'form' => $categoryForm
        ]);
    }

    #[Route('/delete/{id}', name: 'delete', requirements: ['id' => '\d+'])]
    public function deleteWish(Category $category): Response
    {
        $this->em->remove($category);
        $this->em->flush();
        $this->addFlash('success', 'la catégorie a bien été supprimé');
        return $this->redirectToRoute('app_category_list');
    }

}

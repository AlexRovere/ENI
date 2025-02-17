<?php

namespace App\Form;

use App\Entity\Article;
use App\Entity\Categorie;
use App\Entity\Utilisateur;
use Symfony\Bridge\Doctrine\Form\Type\EntityType;
use Symfony\Component\Form\AbstractType;
use Symfony\Component\Form\Extension\Core\Type\CheckboxType;
use Symfony\Component\Form\Extension\Core\Type\DateType;
use Symfony\Component\Form\Extension\Core\Type\IntegerType;
use Symfony\Component\Form\Extension\Core\Type\SubmitType;
use Symfony\Component\Form\Extension\Core\Type\TextType;
use Symfony\Component\Form\FormBuilderInterface;
use Symfony\Component\OptionsResolver\OptionsResolver;

class ArticleType extends AbstractType
{
    public function buildForm(FormBuilderInterface $builder, array $options): void
    {

        $inputClass = 'block w-full p-4 text-sm text-gray-900 border border-gray-300 rounded-lg bg-gray-50 focus:ring-blue-500 focus:border-blue-500 dark:bg-gray-700 dark:border-gray-600 dark:text-white dark:focus:ring-blue-500 dark:focus:border-blue-500';
        $selectClass = 'bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-blue-500 dark:focus:border-blue-500';
        $builder
            ->add('nomArticle', TextType::class, [
                'label' => 'nomArticle',
                'attr' => [
                    'class' =>  $inputClass,
                ]])
            ->add('description', TextType::class, [
                'label' => 'description',
                'attr' => [
                    'class' =>  $inputClass,
                ]])
            ->add('dateDebutEncheres', DateType::class, [
                'label' => 'dateDebutEncheres',
                'widget' => 'single_text',
                'attr' => [
                    'class' =>  $inputClass,
                ]])
            ->add('dateFinEncheres', DateType::class, [
                'label' => 'dateFinEncheres',
                'widget' => 'single_text',
                'attr' => [
                    'class' =>  $inputClass,
                ]])
            ->add('prixInitial', IntegerType::class, [
                'label' => 'prixInitial',
                'attr' => [
                    'class' =>  $inputClass,
                ]])
            ->add('prixVente', IntegerType::class, [
                'label' => 'prixVente',
                'attr' => [
                    'class' =>  $inputClass,
                ]])
            ->add('retraitEffectue',CheckboxType::class, [
                'label' => 'retraitEffectue',
                'attr' => [
                    'class' => 'ms-2 text-sm font-medium text-gray-900 dark:text-gray-300',
                ]])
            ->add('categorie', EntityType::class, [
                'class' => Categorie::class,
                'choice_label' => 'libelle',
                'attr' => [
                    'class' => $selectClass
                ]])
            ->add('utilisateur', EntityType::class, [
                'class' => Utilisateur::class,
                'choice_label' => 'pseudo',
                'attr' => [
                    'class' => $selectClass
            ]])
            ->add('save', SubmitType::class, [
                'label' => 'Save',
                'attr' => [
                    'class' => 'text-white bg-gradient-to-r from-purple-500 via-purple-600 to-purple-700 hover:bg-gradient-to-br focus:ring-4 focus:outline-none focus:ring-purple-300 dark:focus:ring-purple-800 font-medium rounded-lg text-sm px-5 py-2.5 text-center me-2 mb-2',
                ],
            ]);
        ;
    }

    public function configureOptions(OptionsResolver $resolver): void
    {
        $resolver->setDefaults([
            'data_class' => Article::class,
        ]);
    }
}

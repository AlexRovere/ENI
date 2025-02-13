<?php

namespace App\DataFixtures;

use App\Entity\Wish;
use Doctrine\Bundle\FixturesBundle\Fixture;
use Doctrine\Persistence\ObjectManager;
use Faker\Factory;

class WishFixtures extends Fixture
{
    public function load(ObjectManager $manager): void
    {
        $faker = Factory::create('fr_FR');
        for ($i = 0; $i < 20; $i++) {
            $wish = (new Wish())
                ->setTitle($faker->word())
                ->setDescription($faker->sentence())
                ->setAuthor($faker->name())
                ->setIsPublished($faker->boolean())
                ->setDateCreated($faker->dateTime());
            $manager->persist($wish);
        }

        $manager->flush();
    }
}

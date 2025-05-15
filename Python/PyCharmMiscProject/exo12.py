# Exo 12 : Demande à l’utilisateur des articles de course jusqu’à ce qu’il tape "stop".
# Stocke les articles dans une liste, puis affiche-les un par un.

courses = []

ajouterArticle = True

while ajouterArticle:
    article = input("Quel article ajouter aux courses ? Tapez 'stop' pour arrêter ")
    if article == 'stop':
        ajouterArticle = False
    else:
        courses.append(article)

for article in courses:
    print(article)

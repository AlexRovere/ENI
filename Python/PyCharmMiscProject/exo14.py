# Exo 14 : Crée un dictionnaire avec les infos d’un utilisateur : prénom, âge, ville.
# Affiche les informations avec une boucle.
# Puis ajoute une clé "en alternance" et affiche à nouveau.

utilisateur = {
    "prenom": "alex",
    "age": 18,
    "ville": "paris"
}

for cle in utilisateur:
    print(utilisateur[cle])

utilisateur["enAlternance"] = True

for cle in utilisateur:
    print(utilisateur[cle])

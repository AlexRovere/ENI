# Exo 10 : Crée une fonction perimetre_rectangle(longueur, largeur=5)
# qui calcule le périmètre d’un rectangle.
# Teste avec et sans largeur.

def perimetre_rectangle(longeur, largeur = 5):
    return 2 * (longeur + largeur)

print(perimetre_rectangle(10, 10))
print(perimetre_rectangle(10))

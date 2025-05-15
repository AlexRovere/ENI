# Exo 4 : Demande l’âge de l’utilisateur et affiche :
# "Accès autorisé" si >= 18, "Accès limité" entre 13 et 17, sinon "Accès refusé".

ageUtilisateur = int(input("Quel est votre age ? "))

if ageUtilisateur >= 18:
    print("Accès autorisé")
elif 13 <= ageUtilisateur <= 17:
    print("Accès limité")
else:
    print("Accès refusé")


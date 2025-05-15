# Exo 7 : Redemande un nombre tant que l’utilisateur ne tape pas un nombre positif.
# Affiche un message d’erreur si négatif ou nul, sinon remercie l’utilisateur.

nombreUtilisateur = -1

while nombreUtilisateur <= 0:
    nombreUtilisateur = int(input("Entrez un nombre positif : "))

    if(nombreUtilisateur <= 0):
        print("Ce n'est pas un nombre positif ! ")
    else:
        print("Merci de votre coopération ! ")

# Exo 1 : Crée trois variables (prénom, âge, ville) et affiche-les proprement.
# Ajoute une variable booléenne enAlternance pour préciser si tu es en alternance.

prenom = "alex"
age = 18
ville = "paris"
enAlternance: bool = False

print(F" Prénom : {prenom} \n"
      F" Age :  {age} \n"
      F" Ville : {ville} \n"
      F" En alternance : {"Oui" if enAlternance else "Non"}")

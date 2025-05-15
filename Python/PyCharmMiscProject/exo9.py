# Exo 9 : Crée une fonction qui affiche la table de multiplication d’un nombre donné (de 1 à 10).

def table_multiplication(multiplicateur):
    for i in range(11):
        print(F"{i} * {multiplicateur} = {i * multiplicateur}")

table_multiplication(10)

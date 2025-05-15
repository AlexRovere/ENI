# Exo 13 : Crée une fonction moyenne(notes: list[float]) qui calcule et retourne
# la moyenne des notes, arrondie à 2 chiffres après la virgule

def moyenne(notes: list[float]):
    notesLength = len(notes)
    total = 0
    for note in notes:
        total += note
    return round(total / notesLength, 2)

def moyenne_pyth(notes: list[float]):
    return round(sum(notes) / len(notes), 2)

print(moyenne([19,12,23.3, 80]))

print(moyenne_pyth([19,12,23.3, 80]))


from math import pi

def calculate_cylindre(rayon, hauteur, *, is_round = False):
    result = pi * (rayon ** 2) * hauteur
    return  round(result) if is_round else result

print(calculate_cylindre(10,50, is_round = True))

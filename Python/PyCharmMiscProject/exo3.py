# Exo 3 : Crée une fonction qui prend deux nombres et une opération (+, -, *, /)
# et retourne le résultat selon l’opération.
# Utilise aussi match (Python 3.10+) pour gérer les opérations.

import exo2


def calculate_numbers(number1, number2, operation="+"):
    if operation == "+":
        return number1 + number2
    if operation == "-":
        return number1 - number2
    if operation == "*":
        return number1 * number2
    if operation == "/":
        return number1 / number2
    return 0

def calculate_numbers_switch(number1, number2, operation="+"):
    match operation:
        case "+":
            return number1 + number2
        case "-":
            return number1 - number2
        case "*":
            return number1 * number2
        case "/":
            return number1 / number2
        case _:
            return "Opérateur invalide !"


inputNumber1 = float(input("Premier nombre ? "))
inputNumber2 = float(input("Deuxième nombre ? "))

exo2.print_type(inputNumber1)

print("Somme : ", calculate_numbers_switch(inputNumber1, inputNumber2))
print("Différence : ", calculate_numbers_switch(inputNumber1, inputNumber2, "-"))
print("Produit : ", calculate_numbers_switch(inputNumber1, inputNumber2, "*"))
print("Quotien : ", calculate_numbers_switch(inputNumber1, inputNumber2, "/"))
print("Invalide : ", calculate_numbers_switch(inputNumber1, inputNumber2, "zbla"))

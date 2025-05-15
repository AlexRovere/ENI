# Nombre qui a exactement 2 divisieurs distincts entiers et positifs (0 et 1 ne sont pas premiers)

def first_number(max = 100) :
    first_numbers = []
    for n in range(2, max):
        is_prime = True
        for i in range(2, int(n ** 0.5) + 1):
            print(i)
            if n % i == 0:
                is_prime = False
                break
            if is_prime:
                first_numbers.append(n)
    return first_numbers

print(first_number())

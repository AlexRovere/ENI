ALPHABET = list("abcdefghijklmnopqurstuvwxyz")

matrice = [[] for _ in range(len(ALPHABET))]

for idx_column, column in enumerate(ALPHABET):
    iterator = 0
    for idx_row, row in enumerate(ALPHABET):
        index = idx_row + idx_column
        if index > 26:
            index = 0 + iterator
            iterator += 1
        matrice[idx_column].append(ALPHABET[index])

code = "zabol"

msg = "je suis le message"


def crypter_message(msg):
    msg_crypte = []
    index = 0
    max_index = len(code)

    for letter in list(msg):
        if index == max_index:
            index = 0
        if letter == " ":
            msg_crypte.append(letter)
        else:
            idx_row = matrice[0].index(letter)
            print(matrice[0].index(code[index]))
            print(matrice[4][0])
            idx_col = matrice[matrice.index(code[index])][0]
            msg_crypte.append(matrice[idx_row][idx_col])
            index += 1

    return "".join(msg_crypte)

def decrypter_message(msg):
    msg_decrypte = []
    index = 0
    max_index = len(code)

    for letter in list(msg):
        if index == max_index:
            index = 0
        if letter == " ":
            msg_decrypte.append(letter)
        else:
            idx_col = ALPHABET.index(code[index])
            idx_row = matrice[idx_col].index(letter)
            msg_decrypte.append(matrice[0][idx_row])
            index += 1

    return "".join(msg_decrypte)

print(crypter_message(msg))
print(decrypter_message(crypter_message(msg)))

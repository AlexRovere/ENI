
import unicodedata
import string

word = "kayak"

def nettoyer_texte(texte):
    texte_sans_accents = unicodedata.normalize('NFD', texte)
    texte_sans_accents = ''.join(c for c in texte_sans_accents if unicodedata.category(c) != 'Mn')

    texte_sans_ponctuation = ''.join(c for c in texte_sans_accents if c not in string.punctuation)

    texte_nettoye = texte_sans_ponctuation.lower().replace(" ", "")

    return texte_nettoye

def is_word_palindrome(word: str):
    if not isinstance(word, str): return False
    return nettoyer_texte(word) == nettoyer_texte(word[::-1])

is_word_palindrome_msg = "est un palindrome !" if is_word_palindrome(word) else "n'est pas un palindrome !"

print("Le mot {word} {is_word_palindrome_msg}".format(word = word, is_word_palindrome_msg = is_word_palindrome_msg))


sentence = "La mère Gide digère mal"

def is_sentence_palindrome(sentence: str):
    if not isinstance(word, str): return False
    print( nettoyer_texte(sentence).lower().strip())
    return nettoyer_texte(sentence) == nettoyer_texte(sentence[::-1])

is_sentence_palindrome_msg = "est un palindrome !" if is_sentence_palindrome(sentence) else "n'est pas un palindrome !"

print("La phrase {sentence} {is_sentence_palindrome_msg}".format(sentence = sentence, is_sentence_palindrome_msg = is_sentence_palindrome_msg))

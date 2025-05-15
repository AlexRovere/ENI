class A:
    def methode1(self):
        print("méthode 1 de la class A")

    def methode2(self):
        print("méthode 2 de la classe A")

    def methode4(self):
        print("méthode 4 de la classe A")


class B:
    def methode1(self):
        print("méthode 1 de la class B")

    def methode3(self):
        print("méthode 3 de la classe B")

    def methode4(self):
        print("méthode 4 de la classe B")

class AB(A, B):
    def methode1(self):
        print("méthode 1 de classe AB")
    def methode4(self):
        B.methode4(self)


ab = AB()

ab.methode1()
ab.methode2()
ab.methode3()
ab.methode4()

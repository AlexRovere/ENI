class Aspirateur:
    def __init__ (self, marque, puissance):
        self.__marque = marque
        self.__puissance = puissance

    @property
    def marque(self):
        return self.__marque

    @property
    def puissance(self):
        return self.__puissance

    def __str__(self):
        return f"Aspirateur {self.__marque}, puissance = {self.__puissance}"

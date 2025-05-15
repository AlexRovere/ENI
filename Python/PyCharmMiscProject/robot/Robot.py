import random


class Robot:
    numbers_of_created_robots = 0
    ALPHABET = list("ABCDEFGHIJKLMNOPQRSTUVWXYZ")
    ORIENTATIONS = {1: 'NORD', 2: 'EST', 3:'SUD', 4:'OUEST'}
    SATES = {
        1: "En Service",
        2: "Hors Service",
        3: "En réparation"
    }

    def __init__ (self, statut = 1, orientation = "NORD", robot_type = "Générique", **kwargs):
        self.__robot_type = robot_type
        self.__numero_serie = Robot.generate_numero_serie()
        self.__orientation = orientation
        self.__statut = statut
        Robot.numbers_of_created_robots += 1

    @property
    def robot_type(self):
        return self.robot_type

    @robot_type.setter
    def robot_type(self, type):
        if len(type) < 2:
            print("Erreur : 2 caractères minimum pour le type")
        else:
            self.__robot_type = type

    @property
    def numero_serie(self):
        return self.__numero_serie

    @staticmethod
    def generate_numero_serie():
        random_letters = Robot.ALPHABET[random.randint(0, 25)] +  Robot.ALPHABET[random.randint(0, 25)]
        random_numbers = []
        for n in range(10):
            random_numbers.append(random.randint(0, 9))
        return random_letters + "".join(str(n) for n in random_numbers)

    @property
    def orientation(self):
        return self.__orientation

    @property
    def statut(self):
        return self.__statut

    @statut.setter
    def statut(self, statut):
        if statut not in (1,2,3):
            print("ERREUR: Statut invalide")
        else:
            print(statut)
            self.__statut = statut

    def tourner(self, direction):
        if direction not in (1, -1):
            print("ERREUR: Direction invalide")
        else:
            current_direction_idx = next((k for k, v in Robot.ORIENTATIONS.items() if v ==  self.__orientation), None)
            if direction == 1:
                if current_direction_idx < 4:
                    self.__orientation = Robot.ORIENTATIONS[current_direction_idx + 1]
                else:
                    self.__orientation = Robot.ORIENTATIONS[0]
            else:
                if current_direction_idx > 0:
                    self.__orientation = Robot.ORIENTATIONS[current_direction_idx - 1]
                else:
                    self.__orientation = Robot.ORIENTATIONS[0]

    @classmethod
    def number_of_robots(cls):
        return cls.numbers_of_created_robots

    def __str__(self):
        return (f"""
        Robot {self.__numero_serie} - {self.__robot_type} 
        Statut : {self.__statut}
        Orientation : {self.__orientation}""")

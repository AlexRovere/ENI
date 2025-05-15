from robot.Aspirateur import Aspirateur
from robot.RobotMobile import RobotMobile


class AspirateurRobot(RobotMobile,Aspirateur):

    def __init__(self, distance_max, marque= "dyson", puissance = 1500):
        super().__init__(marque=marque, puissance=puissance)
        self.robot_type = "Aspirateur Robot"
        self.distance_max = distance_max

    def __str__(self):
        return super().__str__() + f"""
        Marque = ${self.__marque}
        Puissance = ${self.__puissance}
        Distance Max = ${self.distance_max}"""


aspiRobot = AspirateurRobot(5)

print(aspiRobot)

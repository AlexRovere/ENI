from robot.Robot import Robot


class RobotMobile(Robot):
   def __init__(self, x = 0, y =0):
       self.__x = x
       self.__y = y

   @property
   def x(self):
       return self.__x

   @property
   def y(self):
       return self.__y

   def afficher_position(self):
       return f"Position : [x={self.__x} ; y={self.__y}]"

   def avancer(self, m):
       match self.__orientation:
           case 1:
               self.__y += m
           case 2:
               self.__x += m
           case 3:
               self.__y -= m
           case 4:
               self.__x -= m

   def __str__(self):
       return super().__str__() + f"""
        Position : [x={self.__x} ; y={self.__y}]"""

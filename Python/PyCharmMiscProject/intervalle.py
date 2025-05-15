class Intervalle:
    def __init__(self, start, end):
        if start > end:
            self.__start = end
            self.__end = start
        else:
            self.__start = start
            self.__end = end

    @property
    def start(self):
        return self.__start

    @start.setter
    def start(self, start):
        if start < self.__end:
            self.__start = start
        else:
            print("Le début doit être inférieur à la fin")

    @property
    def end(self):
        return self.__end

    @end.setter
    def end(self, end):
        if end > self.__start:
            self.__end = end
        else:
            print("La fin doit être supérieur au début")

    def print(self):
        print(f"[{self.__start};{self.__end}]")


first_interval = Intervalle(10, 15)

first_interval.end = 1000
first_interval.start = 800

print(first_interval.start)

first_interval.print()

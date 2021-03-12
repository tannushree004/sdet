class Car:
    'This class represents a car'
    def __init__(self, manufacturer, model, make, transmission, color):
        self.manufacturer = manufacturer
        self.model = model
        self.make = make
        self.transmission = transmission
        self.color = color
    def accelerate(self):
        print(self.manufacturer + "" + self.model + "has started moving")
    def stop(self):
        print(self.manufacturer + "" + self.model + "has stopped moving" )
car1 = Car("Tata","Tiago","2019","automatic","balck")
car2 =Car("Renault","Duster","2015","manual","Brown")
car3 = Car("RollRoyce","Ghost","2020","Automatic","gold")
car1.accelerate()
car1.stop() 

car2.accelerate()
car2.stop() 

car3.accelerate()
car3.stop()
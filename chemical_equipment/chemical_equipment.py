from enum import Enum


class Acids(Enum):
    H2SO4 = 0
    C2H5OH = 1
    HNO3HCL = 2


class TypeOfMaterial(Enum):
    Glass = 0
    Plastic = 1
    Metal = 2
    Carbon = 3


class ChemicalEquipment:

    def __init__(self, name: str = " ", price: float = 0, weight_in_grams: int = 0, year: int = 0,
                 brand: str = " ", acid: Acids = None, type_of_material: TypeOfMaterial = None):
        self.name = name
        self.price = price
        self.weight_in_grams = weight_in_grams
        self.year = year
        self.brand = brand
        self.acid = acid
        self.type_of_material = type_of_material

    def __str__(self):
        return f"Name: {self.name}\n" \
               f"Price: {self.price}\n" \
               f"Weight in grams: {self.weight_in_grams}\n" \
               f"Year: {self.year}\n" \
               f"Brand: {self.brand}\n" \
               f"Acid: {self.acid}\n" \
               f"TypeOfMaterial: {self.type_of_material}\n"

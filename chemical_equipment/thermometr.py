from .chemical_equipment import ChemicalEquipment, Acids, TypeOfMaterial


class Thermometer(ChemicalEquipment):
    def __init__(self, name: str = " ", price: float = 0, weight_in_grams: int = 0, year: int = 0,
                 brand: str = " ", acid: Acids = None, type_of_material: TypeOfMaterial = None,
                 degrees_per_celsium: float = 0.0, degrees_per_fahrenheit: float = 0.0):
        super().__init__(name, price, weight_in_grams, year, brand, acid, type_of_material)
        self.degrees_per_celsium = degrees_per_celsium
        self.degrees_per_fahrenheit = degrees_per_fahrenheit

    def __str__(self):
        return f"{super().__str__()}" \
               f"Degrees Per Celsium : {self.degrees_per_celsium}\n" \
               f"Degrees Per Fahrenheit: {self.degrees_per_fahrenheit}\n"

    def show_current_temp(self, degrees: float = 0.0, is_celsium: bool = True):
        if is_celsium:
            print(self.degrees_per_celsium + degrees)
        else:
            print(self.degrees_per_fahrenheit + is_celsium)

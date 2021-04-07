from .chemical_equipment import ChemicalEquipment, Acids, TypeOfMaterial


class BunsenBurner(ChemicalEquipment):
    def __init__(self, name: str = " ", price: float = 0, weight_in_grams: int = 0, year: int = 0,
                 brand: str = " ", type_of_material: TypeOfMaterial = None,
                 max_degrees: float = 0, degrees: float = 0):
        super().__init__(name=name, price=price, weight_in_grams=weight_in_grams, year=year, brand=brand,
                         type_of_material=type_of_material)
        self.max_degrees = max_degrees
        self.degrees = degrees

    def __str__(self):
        return f"{super().__str__()}" \
               f"Max degrees: {self.max_degrees}\n" \
               f"Degrees: {self.degrees}\n"

    def heat(self, degrees: float = 0):
        if self.degrees+degrees >= self.max_degrees:
            print("reached max temp")
        else:
            self.degrees += degrees
            print(f"{self.max_degrees}")

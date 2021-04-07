from .chemical_equipment import ChemicalEquipment, Acids, TypeOfMaterial


class ChemicalGlass(ChemicalEquipment):
    def __init__(self, name: str = " ", price: float = 0, weight_in_grams: int = 0, year: int = 0,
                 brand: str = " ", acid: Acids = None, type_of_material: TypeOfMaterial = None,
                 volume_in_ml: int = 0):
        super().__init__(name, price, weight_in_grams, year, brand, acid, type_of_material)
        self.volume_in_ml = volume_in_ml
        self.acids = list[Acids]

    def __str__(self):
        return f"{super().__str__()}" \
               f"Kg : {self.volume_in_ml}\n"

    def fill(self, acid: Acids = None):
        self.acids.append(acid)

    def pour_out(self):
        return self.acids

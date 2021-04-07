from .chemical_equipment import ChemicalEquipment, Acids, TypeOfMaterial


class Scales(ChemicalEquipment):
    def __init__(self, name: str = " ", price: float = 0, weight_in_grams: int = 0, year: int = 0,
                 brand: str = " ", acid: Acids = None, type_of_material: TypeOfMaterial = None,
                 kg: float = 0.0):
        super().__init__(name, price, weight_in_grams, year, brand, acid, type_of_material)
        self.kg = kg

    def __str__(self):
        return f"{super().__str__()}" \
               f"Kg : {self.kg}\n"

    def show_current_weight(self, weight: float = 0.0):
        print(self.kg + weight)

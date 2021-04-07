from chemical_equipment.chemical_equipment import ChemicalEquipment, Acids


class EquipmentManager:
    def __init__(self, equipments: list[ChemicalEquipment]):
        self.equipments = equipments

    def sort_by_brand(self, reverse: bool = False):
        return sorted(self.equipments, key=lambda e: e.brand, reverse=reverse)

    def sort_by_year(self, reverse: bool = False):
        return sorted(self.equipments, key=lambda e: e.year, reverse=reverse)

    def search_by_acid(self, acid: Acids = None):
        result = []
        for i in self.equipments:
            if i.acid == acid:
                result.append(i)
        return result

import unittest
from chemical_equipment.chemical_equipment import Acids, TypeOfMaterial
from chemical_equipment.chemical_glass import ChemicalGlass
from chemical_equipment.scales import Scales
from chemical_equipment.thermometr import Thermometer
from chemical_equipment.bunsen_burner import BunsenBurner
from equipment_manager.equipment_manager import EquipmentManager


class ManagerTest(unittest.TestCase):
    manager = EquipmentManager([
        ChemicalGlass("Kolba", 100, 200, 2007, "Tokyo labs", Acids.H2SO4, TypeOfMaterial.Glass, 1000),
        Scales("Electric scales", 200, 1000, 2021, "Bosch", Acids.C2H5OH, TypeOfMaterial.Plastic, 0),
        Thermometer("Gradusnyk", 1000, 1000, 1910, "Home made", Acids.HNO3HCL, TypeOfMaterial.Glass),
        BunsenBurner("Bunsen Burner 2000", 500, 3000, 2015, "USA labs eq", TypeOfMaterial.Metal, 500)
    ])

    def test_sort_by_brand_increase(self):
        self.assertEqual(sorted(self.manager.equipments, key=lambda e: e.brand, reverse=True),
                         self.manager.sort_by_brand(True))

    def test_sort_by_year_increase(self):
        self.assertEqual(sorted(self.manager.equipments, key=lambda e: e.year, reverse=True),
                         self.manager.sort_by_year(True))

    def test_sort_by_brand_decrease(self):
        self.assertEqual(sorted(self.manager.equipments, key=lambda e: e.brand, reverse=False),
                         self.manager.sort_by_brand(False))

    def test_sort_by_year_decrease(self):
        self.assertEqual(sorted(self.manager.equipments, key=lambda e: e.year, reverse=False),
                         self.manager.sort_by_year(False))

    def test_search_by_acid(self):
        self.assertEqual(sorted(filter(lambda e: e.acid == Acids.H2SO4, self.manager.equipments),
                                key=lambda e: e.acid == Acids.H2SO4), self.manager.search_by_acid(Acids.H2SO4))

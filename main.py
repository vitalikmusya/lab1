from chemical_equipment.chemical_equipment import Acids, TypeOfMaterial
from chemical_equipment.chemical_glass import ChemicalGlass
from chemical_equipment.scales import Scales
from chemical_equipment.thermometr import Thermometer
from chemical_equipment.bunsen_burner import BunsenBurner
from equipment_manager.equipment_manager import EquipmentManager


def main():
    manager = EquipmentManager([
        ChemicalGlass("Kolba", 100, 200, 2007, "Tokyo labs", Acids.H2SO4, TypeOfMaterial.Glass, 1000),
        Scales("Electric scales", 200, 1000, 2021, "Bosch", Acids.C2H5OH, TypeOfMaterial.Plastic, 0),
        Thermometer("Gradusnyk", 1000, 1000, 1910, "Home made", Acids.HNO3HCL, TypeOfMaterial.Glass),
        BunsenBurner("Bunsen Burner 2000", 500, 3000, 2015, "USA labs eq", TypeOfMaterial.Metal, 500)
    ])
    print("_________________________________________________")
    print("Sorted by decrease of year")
    print("_________________________________________________")
    print("\n".join([str(x) for x in manager.sort_by_year()]))
    print("_________________________________________________")
    print("Sorted brand by alphabet")
    print("_________________________________________________")
    print("\n".join([str(x) for x in manager.sort_by_brand()]))
    print("_________________________________________________")
    print("Search by acid")
    print("_________________________________________________")
    print("\n".join([str(x) for x in manager.search_by_acid(Acids.H2SO4)]))


if __name__ == '__main__':
    main()

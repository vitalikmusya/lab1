package org.musya.rest.models;

import org.musya.rest.models.chemical_equipment.*;
import org.musya.rest.models.manager.EquipmentManager;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        EquipmentManager equipmentManager = new EquipmentManager(new ArrayList<ChemicalEquipment>());

        equipmentManager.addChemicalEquipment(new ChemicalGlass("Kolba", 100.0f, 200,
                2007, "Tokyo labs", Acids.H2SO4, TypeOfMaterial.GLASS, 1000));

        equipmentManager.addChemicalEquipment(new Scales("Electric scales", 200.0f,
                1000, 2021, "Bosch", Acids.C2H5OH, TypeOfMaterial.PLASTIC, 1.0f));

        equipmentManager.addChemicalEquipment(new Thermometr("Gradusnyk", 1000.0f, 1000,
                1910, "Home made", Acids.HNO3HCL, TypeOfMaterial.GLASS, 14.0f,
                50.0f));

        equipmentManager.addChemicalEquipment(new BunsenBurner("Bunsen Burner 2000", 500.0f,
                3000, 2015, "USA labs eq", Acids.HNO3HCL, TypeOfMaterial.METAL,
                500.0f, 132.0f));
        System.out.println("_______________________________________________________");
        System.out.println("Sorted by decrease of year");

        equipmentManager.sortByYear(true).forEach(System.out::println);

        System.out.println("_______________________________________________________");

        System.out.println("Sorted brand by alphabet");

        equipmentManager.sortByBrand(true).forEach(System.out::println);

        System.out.println("_______________________________________________________");

        System.out.println("Search by acid");

        System.out.println(equipmentManager.searchBar(Acids.C2H5OH));
    }

}

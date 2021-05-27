package org.vitalik.chemical_equipment;

import org.vitalik.chemical_equipment.Acids;
import org.vitalik.chemical_equipment.TypeOfMaterial;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString
@Setter
@Getter
@NoArgsConstructor

public class ChemicalEquipment {

    private String name;
    private Float price;
    private int weightInGrams;
    private int year;
    private String brand;
    private Acids acid;
    private TypeOfMaterial typeOfMaterial;

    public ChemicalEquipment(final String name, final Float price, final int weightInGrams, final int year,
                             final String brand, final Acids acid, final TypeOfMaterial typeOfMaterial) {
        this.name = name;
        this.price = price;
        this.weightInGrams = weightInGrams;
        this.year = year;
        this.brand = brand;
        this.acid = acid;
        this.typeOfMaterial = typeOfMaterial;
    }
}

package org.musya.rest.models.chemical_equipment;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.*;

@ToString
@Setter
@Getter
@NoArgsConstructor

public class ChemicalEquipment {
    private Integer id;

    @NotNull(message = "Missing name")
    @Size(min=2, max=32)
    private String name;

    @NotNull(message = "Missing price")
    @Min(1)
    @Max(9999)
    private Float price;

    @NotNull(message = "Missing weightInGrams")
    @Min(1)
    @Max(9999)
    private int weightInGrams;

    @NotNull(message = "Missing year")
    @Min(1)
    @Max(9999)
    private int year;

    @NotNull(message = "Missing brand")
    @Size(min=2, max=32)
    private String brand;

    @NotNull(message = "Missing acid (enum)")
    @Enumerated(EnumType.STRING)
    private Acids acid;

    @NotNull(message = "Missing typeOfMaterial (enum)")
    @Enumerated(EnumType.STRING)
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

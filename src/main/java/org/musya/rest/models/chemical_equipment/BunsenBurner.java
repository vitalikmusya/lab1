package org.musya.rest.models.chemical_equipment;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString
@Setter
@Getter
@NoArgsConstructor

public class BunsenBurner extends ChemicalEquipment{

    private Float maxDegrees;
    private Float degrees;

    public BunsenBurner(final String namePar,final Float pricePar,final int weightInGramsPar,final int yearPar,
                        final String brandPar, final Acids acidPar,final TypeOfMaterial typeOfMaterialPar,
                        final Float maxDegreesPar, final Float degreesPar) {
        super(namePar, pricePar, weightInGramsPar, yearPar, brandPar, acidPar, typeOfMaterialPar);
        this.maxDegrees = maxDegreesPar;
        this.degrees = degreesPar;
    }
}

package org.vitalik.chemical_equipment;

import lombok.ToString;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@ToString

public class ChemicalGlass extends ChemicalEquipment {

    private int volumeInMl;

    public ChemicalGlass(final String namePar, final Float pricePar, final int weightInGramsPar, final int yearPar,
                         final String brandPar, final Acids acidPar, final TypeOfMaterial typeOfMaterialPar,
                         final int volumeInMlPar) {
        super(namePar, pricePar, weightInGramsPar, yearPar, brandPar, acidPar, typeOfMaterialPar);
        this.volumeInMl = volumeInMlPar;
    }
}

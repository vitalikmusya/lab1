package org.vitalik.chemical_equipment;

import lombok.ToString;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@ToString

public class Scales extends ChemicalEquipment {

    private Float kg;

    public Scales(final String namePar,final Float pricePar,final int weightInGramsPar,final int yearPar,
                  final String brandPar, final Acids acidPar, final TypeOfMaterial typeOfMaterialPar,
                  final Float kgPar) {
        super(namePar, pricePar, weightInGramsPar, yearPar, brandPar, acidPar, typeOfMaterialPar);
        this.kg = kgPar;
    }
}

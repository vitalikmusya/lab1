package org.vitalik.chemical_equipment;

import lombok.ToString;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@ToString

public class Thermometr extends ChemicalEquipment{

    private Float degreesPerCelsium;
    private Float degreesPerFahrenheit;

    public Thermometr(final String namePar,final Float pricePar,final int weightInGramsPar,final int yearPar,
                      final String brandPar, final Acids acidPar, final TypeOfMaterial typeOfMaterialPar,
                      final Float degreesPerCelsiumPar, final Float degreesPerFahrenheitPar) {
        super(namePar, pricePar, weightInGramsPar, yearPar, brandPar, acidPar, typeOfMaterialPar);
        this.degreesPerCelsium = degreesPerCelsiumPar;
        this.degreesPerFahrenheit = degreesPerFahrenheitPar;
    }
}

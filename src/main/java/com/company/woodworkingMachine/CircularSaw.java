package com.company.woodworkingMachine;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public final class CircularSaw extends WoodworkingMachine {

    private String bladeNameOfCircularSaw;
    private int amountOfBlades;

    public CircularSaw(final String namePar, final String modelPar, final float pricePar, int powerPar,
                       final Companies manufacture_companyPar, final int rpmPar,
                       final int volumePerSecPar, final String purposePar,
                       final String bladeNameOfCircularSawPar, final int amountOfBladesPar) {
        super(namePar, modelPar, pricePar, powerPar, manufacture_companyPar, rpmPar, volumePerSecPar, purposePar);
        this.bladeNameOfCircularSaw = bladeNameOfCircularSawPar;
        this.amountOfBlades = amountOfBladesPar;
    }

    public void cut() {
        System.out.println("Cut Cut Cut");
    }
}

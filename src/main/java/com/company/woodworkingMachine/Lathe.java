package com.company.woodworkingMachine;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public final class Lathe extends WoodworkingMachine {

    private String bladeNameOfCuter;
    private int stepOfCuter;

    public Lathe(final String namePar, final String modelPar, final float pricePar, int powerPar,
                 final Companies manufacture_companyPar, final int rpmPar,
                 final int volumePerSecPar, final String purposePar,
                 String bladeNameOfCuterPar, int stepOfCuterPar) {
        super(namePar, modelPar, pricePar, powerPar, manufacture_companyPar, rpmPar, volumePerSecPar, purposePar);
        this.bladeNameOfCuter = bladeNameOfCuterPar;
        this.stepOfCuter = stepOfCuterPar;
    }

    public void slice() {
        System.out.println("Slice Slice Slice");
    }

}

package com.company.woodworkingMachine;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public final class ThicknessPlanner extends WoodworkingMachine {

    private int amountOfBarabanes;
    private String nameOfBarabanes;

    public ThicknessPlanner (final String namePar, final String modelPar, final float pricePar, int powerPar,
                             final Companies manufacture_companyPar, final int rpmPar,
                             final int volumePerSecPar, final String purposePar,
                             final int amountOfBarabanesPar, String nameOfBarabanesPar){
        super(namePar, modelPar, pricePar, powerPar, manufacture_companyPar, rpmPar, volumePerSecPar, purposePar);
        this.amountOfBarabanes = amountOfBarabanesPar;
        this.nameOfBarabanes = nameOfBarabanesPar;
    }

    public void grind_down() {
        System.out.println("Grind Grind Grind");
    }
}

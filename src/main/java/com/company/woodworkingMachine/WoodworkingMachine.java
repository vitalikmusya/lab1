package com.company.woodworkingMachine;


import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@ToString

public class WoodworkingMachine {
    private String name;
    private String model;
    private float price;
    private int power;
    private Companies manufactureCompany;
    private int rpm;
    private int volumePerSec;
    private String purpose;

    WoodworkingMachine(final String namePar, final String modelPar, final float pricePar, int powerPar,
                       final Companies manufacture_companyPar, final int rpmPar,
                       final int volumePerSecPar, final String purposePar) {

        this.name = namePar;
        this.model = modelPar;
        this.price = pricePar;
        this.power = powerPar;
        this.manufactureCompany = manufacture_companyPar;
        this.rpm = rpmPar;
        this.volumePerSec = volumePerSecPar;
        this.purpose = purposePar;
    }

    public void turnOn() {
        System.out.println("Machine is ON");
    }

    public void turnOff() {
        System.out.println("Machine is OFF");
    }
}

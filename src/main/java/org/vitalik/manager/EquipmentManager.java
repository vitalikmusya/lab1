package org.vitalik.manager;

import org.vitalik.chemical_equipment.Acids;
import org.vitalik.chemical_equipment.ChemicalEquipment;

import java.util.List;
import java.util.Optional;

public class EquipmentManager {
    private List<ChemicalEquipment> chemicalEquipment;

    public EquipmentManager(final List<ChemicalEquipment> chemicalEquipmentPar) {
        this.chemicalEquipment = chemicalEquipmentPar;
    }

    public void addChemicalEquipment(final ChemicalEquipment chemicalEquipmentPar) {
        this.chemicalEquipment.add(chemicalEquipmentPar);
    }

    public List<ChemicalEquipment> sortByBrand(final boolean reverse) {
        if (reverse) {
            chemicalEquipment.sort((ChemicalEquipment c1, ChemicalEquipment c2) ->
                    c2.getName().compareTo(c1.getName()));
        } else {
            chemicalEquipment.sort((ChemicalEquipment c1, ChemicalEquipment c2) ->
                    c1.getName().compareTo(c2.getName()));
        }
        return chemicalEquipment;
    }

    public List<ChemicalEquipment> sortByYear(final boolean reverse) {
        if (reverse) {
            chemicalEquipment.sort((ChemicalEquipment c1, ChemicalEquipment c2) ->
                    Float.compare(c2.getPrice(), c1.getPrice()));
        } else {
            chemicalEquipment.sort((ChemicalEquipment c1, ChemicalEquipment c2) ->
                    Float.compare(c1.getPrice(), c2.getPrice()));
        }
        return chemicalEquipment;
    }

    public Optional<ChemicalEquipment> searchBar(final Acids search) {
        return chemicalEquipment.stream().filter(c -> c.getAcid().equals(search)).findAny();
    }
}

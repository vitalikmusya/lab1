package org.musya.rest.service;

import org.springframework.web.context.annotation.ApplicationScope;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import org.musya.rest.models.chemical_equipment.ChemicalEquipment;


@Service
@ApplicationScope
public class ChemicalEquipmentService {
    private AtomicInteger id = new AtomicInteger(0);

    private final Map<Integer, ChemicalEquipment> CHEMICAL_EQUIPMENT_MAP = new HashMap<Integer, ChemicalEquipment>();

    public ChemicalEquipment addChemicalEquipment(ChemicalEquipment chemicalEquipment) {
        Integer ChemicalEquipmentId = id.incrementAndGet();
        chemicalEquipment.setId(ChemicalEquipmentId);
        CHEMICAL_EQUIPMENT_MAP.put(ChemicalEquipmentId,chemicalEquipment);
        return chemicalEquipment;
    }

    public ChemicalEquipment updateChemicalEquipment(int id, ChemicalEquipment ChemicalEquipment) {
        ChemicalEquipment.setId(id);
        return CHEMICAL_EQUIPMENT_MAP.put(id, ChemicalEquipment);
    }

    public List<ChemicalEquipment> getChemicalEquipments() {
        return CHEMICAL_EQUIPMENT_MAP.values().stream().collect(Collectors.toList());
    }

    public ChemicalEquipment getChemicalEquipment(Integer id) {
        return CHEMICAL_EQUIPMENT_MAP.get(id);
    }

    public Map<Integer, ChemicalEquipment> getChemicalEquipmentMap(){
        return CHEMICAL_EQUIPMENT_MAP;
    }

    public void deleteChemicalEquipmentById(Integer id){
        CHEMICAL_EQUIPMENT_MAP.remove(id);
    }
}

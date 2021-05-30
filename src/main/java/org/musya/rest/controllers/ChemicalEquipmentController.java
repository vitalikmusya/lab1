package org.musya.rest.controllers;

import org.musya.rest.models.chemical_equipment.ChemicalEquipment;
import org.musya.rest.service.ChemicalEquipmentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path = "/ChemicalEquipments")

public class ChemicalEquipmentController {
    @Autowired
    private ChemicalEquipmentService chemicalEquipmentService;

    @GetMapping(path = "/{id}")
    public ResponseEntity<ChemicalEquipment> getChemicalEquipment(@PathVariable(name = "id") Integer id) {
        if(chemicalEquipmentService.getChemicalEquipment(id) != null) {
            return new ResponseEntity<ChemicalEquipment>(chemicalEquipmentService.getChemicalEquipment(id), HttpStatus.OK);
        }
        return new ResponseEntity<ChemicalEquipment>(HttpStatus.NOT_FOUND);
    }

    @GetMapping
    public List<ChemicalEquipment> getChemicalEquipments() {
        return chemicalEquipmentService.getChemicalEquipments();
    }

    @PostMapping
    public ChemicalEquipment createChemicalEquipment(@RequestBody @Valid ChemicalEquipment ChemicalEquipment) {
        return chemicalEquipmentService.addChemicalEquipment(ChemicalEquipment);
    }

    @PutMapping(path = "/{id}", consumes = "application/json", produces = "application/json")
    public ResponseEntity<ChemicalEquipment> updateChemicalEquipment(@Valid @PathVariable("id") int id, @RequestBody ChemicalEquipment ChemicalEquipment) {
        if (chemicalEquipmentService.getChemicalEquipment(id) != null) {
            return new ResponseEntity<ChemicalEquipment>(chemicalEquipmentService.updateChemicalEquipment(id, ChemicalEquipment), HttpStatus.OK);
        } else {
            return new ResponseEntity<ChemicalEquipment>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping(path = "/{id}")
    public void deleteChemicalEquipmentById(@PathVariable("id") Integer id) {
        chemicalEquipmentService.deleteChemicalEquipmentById(id);
    }
}

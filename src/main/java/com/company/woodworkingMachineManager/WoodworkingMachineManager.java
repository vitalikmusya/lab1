package com.company.woodworkingMachineManager;

import java.util.List;
import java.util.Optional;

import lombok.Getter;
import lombok.NoArgsConstructor;
import com.company.woodworkingMachine.WoodworkingMachine;

@Getter
@NoArgsConstructor
public final class WoodworkingMachineManager {

    private List<WoodworkingMachine> workbenches;

    public WoodworkingMachineManager(final List<WoodworkingMachine> workbenchesPar) {
        this.workbenches = workbenchesPar;
    }

    public void addTechnique(final WoodworkingMachine woodworkingMachine) {
        workbenches.add(woodworkingMachine);
    }

    public List<WoodworkingMachine> sortByVolume(final boolean reverse) {
        if (reverse) {
            workbenches.sort((WoodworkingMachine t1, WoodworkingMachine t2) ->
                    Integer.compare(t2.getVolumePerSec(), t1.getVolumePerSec()));
        } else {
            workbenches.sort((WoodworkingMachine t1, WoodworkingMachine t2) ->
                    Integer.compare(t1.getVolumePerSec(), t2.getVolumePerSec()));
        }
        return workbenches;

        public List<WoodworkingMachine> sortByWatts(final boolean reverse){
            if (reverse) {
                workbenches.sort((WoodworkingMachine t1, WoodworkingMachine t2) ->
                        Integer.compare(t2.getPower(), t1.getPower()));
            } else {
                workbenches.sort((WoodworkingMachine t1, WoodworkingMachine t2) ->
                        Float.compare(t1.getPower(), t2.getPower()));
            }
            return workbenches;
        }

        public Optional<WoodworkingMachine> searchWorkbench(final String search){

        }
    }
}
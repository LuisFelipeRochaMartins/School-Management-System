package com.example.sigga.phase;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class PhaseService {

    private final PhaseRepository phaseRepository;

    @Autowired
    public PhaseService(PhaseRepository phaseRepository) {
        this.phaseRepository = phaseRepository;
    }

    public List<Phase> getPhases(){
        return phaseRepository.findAll();
    }

    public void addNewPhase(@RequestBody Phase phase){
        phaseRepository.save(phase);
    }

    public void deletePhase(Long phaseId){
        boolean exists = phaseRepository.existsById(phaseId);

        if(!exists){
            throw new IllegalStateException("Phase with id "  + phaseId + "does not exists");
        }

        phaseRepository.deleteById(phaseId);
    }

    @Transactional
    public void updatePhase(Long phaseId, Phase phase){
        Phase phaseDB = phaseRepository.findById(phase.getId())
                .orElseThrow(() -> new IllegalArgumentException(
                        "Phase with id " + phase.getId() +  "does not exists"
                ));

        if(phase.getName() != null && !phase.getName().isBlank() && !Objects.equals(phaseDB.getName(), phase.getName())){
            phaseDB.setName(phase.getName());
        }

        if(phase.getDescription() != null && !phase.getDescription().isBlank() && !Objects.equals(phaseDB.getDescription(), phase.getDescription())){
            phaseDB.setDescription(phase.getDescription());
        }
    }
}
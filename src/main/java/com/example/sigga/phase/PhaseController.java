package com.example.sigga.phase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/phase")
public class PhaseController {

    private final PhaseService phaseService;

    @Autowired
    public PhaseController(PhaseService phaseService) {
        this.phaseService = phaseService;
    }

    /**
     * Retorna todas as Fases registradas dentro do banco de dados.
     *
     * @return List<Phase> Fases.
     */
    @GetMapping
    public List<Phase> getPhase () {
        return phaseService.getPhases();
    }

    /**
     * Através de uma POST request, é chamado o serviço para inserir dentro do banco de dados.
     *
     * @param phase Phase - Fase a ser inserida.
     */
    @PostMapping
    public void addNewPhase (@RequestBody Phase phase){
        phaseService.addNewPhase(phase);
    }

    /**
     * Através de uma DELETE request, é chamado o serviço para deletar uma
     * fase com base no parâmetro passado.
     *
     * @param phaseId Long - Id da Fase a ser deletada.
     */
    @DeleteMapping(path = "{phaseid}")
    public void deletePhase(@PathVariable Long phaseId){
        phaseService.deletePhase(phaseId);
    }

    /**
     * Através de uma PUT request, é chamado o serviço para alterar a Fase.
     *
     * @param phaseId   Long - Id da Fase a ser alterada.
     * @param phase     Phase - Fase para alteração.
     */
    @PutMapping(path = "{phaseid}")
    public void updatePhase(@PathVariable Long phaseId,
                            @RequestBody Phase phase){
        phaseService.updatePhase(phaseId, phase);
    }
}

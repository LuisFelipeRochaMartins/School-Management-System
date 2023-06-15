package com.example.sigga.subjects;

import com.example.sigga.department.Department;
import com.example.sigga.teacher.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/subjects")
public class SubjectsController {

    private final SubjectsService subjectsService;

    @Autowired
    public SubjectsController(SubjectsService subjectsService) {
        this.subjectsService = subjectsService;
    }

    /**
     * Retorna a listagem de todos os registros de disciplinas de dentro do banco de dados.
     *
     * @return List<Subjects>
     */
    @GetMapping
    public List<Subjects> getSubjects(){
        return subjectsService.getSubjects();
    }

    /**
     * Através de uma requisição POST, faz a inserção de uma nova disciplina para dentro do banco de dados.
     *
     * @param subjects
     */
    @PostMapping
    public void registerNewSubject(@RequestBody Subjects subjects){
        subjectsService.addNewSubjects(subjects);
    }

    /**
     * Através de um requisição DELETE, faz a exclusão de uma disciplina
     *
     * @param subjectId
     */
    @DeleteMapping(path = "subjectId")
    public void deleteSubject(@PathVariable("{subjectId}") Long subjectId){
        subjectsService.deleteSubject(subjectId);
    }

    /**
     * Através de uma requisição PUT, faz a alteração de uma disciplina.
     *
     * @param studentId
     * @param teacherId
     * @param departmentId
     * @param description
     */
    @PutMapping(path = "{studentId}")
    public void updateSubjects(
            @PathVariable("studentId") Long studentId,
            @RequestParam(required = false) Teacher teacherId,
            @RequestParam(required = false) Department departmentId,
            @RequestParam(required = false) String description){
            subjectsService.updateSubject(studentId, teacherId, departmentId, description);
    }

}

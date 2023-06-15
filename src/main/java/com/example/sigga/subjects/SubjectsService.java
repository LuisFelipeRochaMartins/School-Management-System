package com.example.sigga.subjects;

import com.example.sigga.department.Department;
import com.example.sigga.teacher.Teacher;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class SubjectsService {

    private final SubjectsRepository subjectsRepository;

    @Autowired
    public SubjectsService(SubjectsRepository subjectsRepository) {
        this.subjectsRepository = subjectsRepository;
    }

    public void verifySubject(Long departmentId, String email){

    }

    /**
     * Retorna todos as disciplinas registradas no banco de dados.
     *
     * @return List<Subjects>
     */
    public List<Subjects> getSubjects(){
        return subjectsRepository.findAll();
    }

    /**
     * Inseri uma nova disciplina dentro do banco.
     *
     * @param subjects Subjects - Classe de Subjects.
     */
    public void addNewSubjects(Subjects subjects){
        subjectsRepository.save(subjects);
    }

    /**
     * Verifica se o Id passado como parâmetro existe, caso não exista retorna uma exceção, caso existir
     * deleta do banco de dados.
     *
     * @param subjectId - Long - Id da disciplina
     */
    public void deleteSubject(Long subjectId){
        boolean exists = subjectsRepository.existsById(subjectId);

        if(!exists){
            throw new IllegalStateException("Subject with id " + subjectId + " does not exists");
        }
        subjectsRepository.deleteById(subjectId);
    }

    /**
     * Verifica se a disciplina existe através da PK, se existir e os valores que são passados como parâmetro forem validados
     * altera as seguintes colunas: Id do Professor, Id do Departamento, descrição da disciplina
     *
     * @param subjectId     Long - Id da Disciplina
     * @param teacher     Long - Id do Professor
     * @param department  Long - Id do Departamento
     * @param description   String - Descrição da disciplina.
     */
    @Transactional
    public void updateSubject(Long subjectId, Teacher teacher, Department department, String description){
        Subjects subjects = subjectsRepository.findById(subjectId)
                .orElseThrow(() -> new IllegalArgumentException(
                        "Subject with id " + subjectId + "does not exists"
                ));
        if(description != null && description.length() > 0 && !Objects.equals(subjects.getDescription(), description)){
            subjects.setDescription(description);
        }

        if(teacher != null && !Objects.equals(subjects.getTeacherId(), teacher)){
            subjects.setTeacherId(teacher);
        }

        if(department != null && !Objects.equals(subjects.getDepartmentId(), department)){
            subjects.setDepartmentId(department);
        }
    }
}

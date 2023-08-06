package com.example.sigga.subjects;

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
     * @param subjects      Subjects - Disciplina.
     */
    @Transactional
    public void updateSubject(Long subjectId, Subjects subjects){
        Subjects subjectsDB = subjectsRepository.findById(subjectId)
                .orElseThrow(() -> new IllegalArgumentException(
                        "Subject with id " + subjectId + "does not exists"
                ));
        if (subjects.getDescription() != null && !subjects.getDescription().isBlank() && !Objects.equals(subjectsDB.getDescription(), subjects.getDescription())) {
            subjectsDB.setDescription(subjects.getDescription());
        }
    }
}
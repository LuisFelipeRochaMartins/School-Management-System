package com.example.sigga.teacher;

import com.example.sigga.student.StudentRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class TeacherService {

    private final TeacherRepository teacherRepository;

    @Autowired
    public TeacherService(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    /**
     * Retorna todos os Professor presentes no banco de dados.
     *
     * @return List<Student> - Professors
     */
    public List<Teacher> getTeachers() {
        return teacherRepository.findAll();
    }

    /**
     * Verifica através do Email passado como parâmetro, se não existir retorna uma exceção.
     *
     * @param email String - Email do Professor
     */
    public void verifyTeacherEmail(String email){
        Optional<Teacher> teacherOptional = teacherRepository.findTeacherByEmail(email);

        if(teacherOptional.isPresent()){
            throw new IllegalStateException("Email Taken");
        }
    }

    /**
     * Verifica se o email do Professor está em uso, caso esteja, retorna uma mensagem, caso não inseri o
     * novo Professor dentro do banco de dados.
     *
     * @param teacher Teacher - Classe do Professor.
     */
    public void addNewTeacher(Teacher teacher){
        verifyTeacherEmail(teacher.getEmail());
        teacherRepository.save(teacher);
    }

    /**
     * Verifica se o Id do Professor existe dentro do banco de dados, caso exista deleta o registro.
     *
     * @param teacherId String - Id do Professor
     */
    public void deleteTeacher(Long teacherId){
        boolean exists = teacherRepository.existsById(teacherId);

        if(!exists){
            throw new IllegalStateException("Teacher with id " + teacherId + " does not exists");
        }
        teacherRepository.deleteById(teacherId);
    }

    /**
     * Verifica se o Professor existe através da PK, se existir e os valores que são passados como parâmetro forem validados
     * altera as seguintes colunas: email e nome.
     *
     * @param teacherId Long - Id do Professor
     * @param name      String - Nome do Professor
     * @param email     String - Email do Professor
     */
    @Transactional
    public void updateTeacher(Long teacherId, String name, String email){
        Teacher teacher = teacherRepository.findById(teacherId)
                .orElseThrow(() -> new IllegalArgumentException(
                        "Teacher with id = " + teacherId + " does not exists"
                ));
        if(name != null && name.length() > 0 && !Objects.equals(teacher.getName(), name)){
            teacher.setName(name);
        }
        if(email != null & email.length() > 0 && !Objects.equals(teacher.getEmail(), email)){
            teacher.setEmail(email);
        }
    }
}

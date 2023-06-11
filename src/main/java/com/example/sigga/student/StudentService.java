package com.example.sigga.student;

import com.example.sigga.student.Student;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    /**
     * Retorna todos os Estudante presentes no banco de dados.
     *
     * @return List<Student> - Estudantes
     */
    public List<Student> getStudents(){
        return studentRepository.findAll();
    }

    /**
     * Verifica se o email do Estudante está em uso, caso esteja, retorna uma mensagem, caso não inseri o
     * novo estudante dentro do banco de dados.
     *
     * @param student Student - Classe do Estudante.
     */
    public void addNewStudent(@RequestBody Student student){
        verifyEmail(student.getEmail());
        studentRepository.save(student);
    }

    /**
     * Verifica através do Email passado como parâmetro, se não existir retorna uma exceção.
     *
     * @param email String - Email do Estudante
     */
    public void verifyEmail(String email){
        Optional<Student> studentOptional = studentRepository.findStudentByEmail(email);

        if(studentOptional.isPresent()){
            throw new IllegalStateException("Email taken");
        }
    }

    /**
     * Verifica se o Id do Estudante existe dentro do banco de dados, caso exista deleta o registro.
     *
     * @param studentId String - Id do Estudante
     */
    public void deleteStudent(Long studentId){
        boolean exists = studentRepository.existsById(studentId);

        if(!exists){
            throw new IllegalStateException("Student with id = " + studentId + " does not exists");
        }

        studentRepository.deleteById(studentId);
    }

    /**
     * Verifica se o Estudante existe através da PK, se existir e os valores que são passados como parâmetro forem validados
     * altera as seguintes colunas: email e nome.
     *
     * @param studentId Long - Id do Estudante
     * @param name      String - Nome do Estudante
     * @param email     String - Email do Estudante
     */
    @Transactional
    public void updateStudent(Long studentId, String name, String email){
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new IllegalArgumentException(
                        "Student with id = " + studentId + " does not exists"
                ));
        if(name != null && name.length() > 0 && !Objects.equals(student.getName(), name)){
            student.setName(name);
        }

        if(email != null && email.length() > 0 && !Objects.equals(student.getEmail(), email)){
            verifyEmail(email);
            student.setEmail(email);
        }
    }
}

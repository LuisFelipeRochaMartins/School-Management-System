package com.example.sigga.student;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/student")
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    /**
     * Retorna todos os registros de Estudante de dentro do banco de dados.
     *
     * @return List<Student> - Todos os registros de Estudante.
     */
    @GetMapping
    public List<Student> getStudents(){
        return studentService.getStudents();
    }

    /**
     * Através de uma requisição POST, é feita a inserção de um novo Estudante para o banco de dados.
     *
     * @param student Student - Classe do Estudante
     */
    @PostMapping
    @Transactional
    public void registerNewStudent(@RequestBody Student student){
        studentService.addNewStudent(student);
    }

    /**
     * Através de uma requisição DELETE, é feita a exclusão de um Estudante por sua PK.
     *
     * @param studentId Long - Id do Estudante.
     */
    @DeleteMapping(path = "{studentId}")
    public void deleteStudent(@PathVariable("studentId") Long studentId){
        studentService.deleteStudent(studentId);
    }

    /**
     * Através de um requisição PUT, é feita a alteração de um Estudante utilizando sua PK.
     *
     * @param studentId Long   - Id do Estudante a ser alterado.
     * @param student  Student - Estudante para alterar.
     */
    @PutMapping(path = "{studentId}")
    public void updateStudent(
            @PathVariable("studentId") Long studentId,
            @RequestBody Student student){
        studentService.updateStudent(studentId, student);
    }
}
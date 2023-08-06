package com.example.sigga.department;

import com.example.sigga.teacher.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/department")
public class DepartmentController {

    private final DepartmentService departmentService;

    @Autowired
    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    /**
     * Através de uma requisição GET, retorna todos os departamentos registrados dentro do banco de dados.
     *
     * @return List<Department>
     */
    @GetMapping
    public List<Department> getDepartments(){
        return departmentService.getDepartments();
    }

    /**
     * Através de um requisição POST, insere dentro do banco de dados um novo departamento.
     *
     * @param department Long - Id do Departamento
     */
    @PostMapping
    public void registerNewDeparment(@RequestBody Department department){
        departmentService.addNewDepartment(department);
    }

    /**
     * Através de uma requisição DELETE, é feita a exclusão do departamento pelo Id passado como parâmetro.
     *
     * @param departmentId Long - Id do Departamento
     */
    @DeleteMapping(path = "{departmentId}")
    public void deleteDepartment(@PathVariable("departmentId") Long departmentId){
        departmentService.deleteDepartment(departmentId);
    }

    /**
     * Através de uma requisição PUT, é feita a alteração dos do Professor
     *
     * @param departmentId Long    - Id do Departamento
     */
    @PutMapping(path = "{departmentId}")
    public void updateDepartment( @PathVariable("departmentId") Long departmentId){
        departmentService.updateDepartment(departmentId);
    }
}
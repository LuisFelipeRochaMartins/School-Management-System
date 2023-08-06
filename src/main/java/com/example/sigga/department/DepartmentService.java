package com.example.sigga.department;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Objects;

@Service
public class DepartmentService {

    private final DepartmentRepository departmentRepository;

    @Autowired
    public DepartmentService(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    /**
     * Retorna uma lista de todos os departamentos presentes dentro do banco de dados.
     *
     * @return List<Department>
     */
    public List<Department> getDepartments(){
        return departmentRepository.findAll();
    }

    /**
     * Realiza a inserção dentro do banco de dados.
     *
     * @param department Department - novo Departamento
     */
    public void addNewDepartment(@RequestBody Department department){
        departmentRepository.save(department);
    }

    /**
     * Verifica se o Departamento existe pelo Id passado por parâmetro, se não existir retorna uma exceção.
     *
     * @param departmentId  Long - Id do Departamento
     */
    public void deleteDepartment(Long departmentId){
        boolean exists = departmentRepository.existsById(departmentId);

        if(!exists){
            throw new IllegalStateException("Department with id " + departmentId + " does not exists" );
        }

        departmentRepository.deleteById(departmentId);
    }

    /**
     * Verifica se há diferença entre o atributo do objeto e o parametro passado, faz a alteração do id do Professor
     *
     * @param departmentId Long - Id do Departamento
     */
    @Transactional
    public void updateDepartment(Long departmentId){
        Department department = departmentRepository.findById(departmentId)
                .orElseThrow(() -> new IllegalArgumentException(
                        "Deparment with id " + departmentId + " does not exists"
                ));
    }
}

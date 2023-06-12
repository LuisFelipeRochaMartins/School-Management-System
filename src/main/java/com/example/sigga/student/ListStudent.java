package com.example.sigga.student;

import java.util.ArrayList;
import java.util.List;

public class ListStudent {

    private List<Student> list = new ArrayList<Student>();

    public ListStudent() {

    }

    public ListStudent(List<Student> list) {
        this.list = list;
    }

    public List<Student> getList() {
        return list;
    }

    public void setList(List<Student> list) {
        this.list = list;
    }

    /**
     * Adiciona o Estudante à lista.
     *
     * @param student Student - Classe do Estudante
     */
    public void addStudent(Student student){
        list.add(student);
    }

    /**
     * Remove o Estudante com base no parâmetro passado.
     *
     * @param student Student - Classe do Estudante
     */
    public void removeStudent(Student student){
        list.remove(student);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("Lista de Estudantes = ").append(list);
        return sb.toString();
    }
}

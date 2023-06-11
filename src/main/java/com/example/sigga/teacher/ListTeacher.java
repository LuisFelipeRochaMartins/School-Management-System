package com.example.sigga.teacher;

import java.util.ArrayList;
import java.util.List;

public class ListTeacher {

    private List<Teacher> list = new ArrayList<Teacher>();

    public ListTeacher() {

    }

    public ListTeacher(List<Teacher> list) {
        this.list = list;
    }

    public List<Teacher> getList() {
        return list;
    }

    public void setList(List<Teacher> list) {
        this.list = list;
    }

    /**
     * Adiciona um novo Professor à lista.
     *
     * @param teacher Teacher - Classe do Professor
     */
    public void addTeacher(Teacher teacher){
        list.add(teacher);
    }

    /**
     * Remove um Professor.
     *
     * @param teacher Teacher - Classe do Professor.
     */
    public void removeTeacher(Teacher teacher){
        list.remove(teacher);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("Lista de Professores do Curso: ").append(list);
        return sb.toString();
    }
}

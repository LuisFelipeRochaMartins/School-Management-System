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
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("Lista de Estudante da Disciplina: ").append(getList());
        return sb.toString();
    }
}

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

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("Lista de Professores = ").append(list);
        return sb.toString();
    }
}

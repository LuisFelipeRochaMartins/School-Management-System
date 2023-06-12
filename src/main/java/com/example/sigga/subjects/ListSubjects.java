package com.example.sigga.subjects;

import java.util.ArrayList;
import java.util.List;

public class ListSubjects {

    private List<Subjects> list = new ArrayList<Subjects>();

    public ListSubjects() {

    }

    public ListSubjects(List<Subjects> list){
        this.list = list;
    }

    public List<Subjects> getList() {
        return list;
    }

    public void setList(List<Subjects> list) {
        this.list = list;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("Lista de Disciplinas = ").append(list);
        return sb.toString();
    }
}

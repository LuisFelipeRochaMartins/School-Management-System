package com.example.sigga.subjects;

import java.util.ArrayList;
import java.util.List;

public class ListSubjects {

    private List<Subjects> list = new ArrayList<Subjects>();

    public ListSubjects() {

    }

    public ListSubjects(List<Subjects> list) {
        this.list = list;
    }

    public List<Subjects> getList() {
        return list;
    }

    public void setList(List<Subjects> list) {
        this.list = list;
    }

    public void addSubjects(Subjects subjects){
        list.add(subjects);
    }

    public void removeSubjects(Subjects subjects){
        list.remove(subjects);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ListSubjects{");
        sb.append("list=").append(list);
        sb.append('}');
        return sb.toString();
    }
}

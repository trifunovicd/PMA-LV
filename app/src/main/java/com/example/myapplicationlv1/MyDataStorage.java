package com.example.myapplicationlv1;

import java.util.ArrayList;
import java.util.List;

public class MyDataStorage {
    private List<Student> students;

    private MyDataStorage() {
        this.students = new ArrayList<>();
    }

    static private MyDataStorage instance;

    static MyDataStorage getInstance(){
        if(instance==null)
        {
            instance = new MyDataStorage();
        }
        return instance;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(Student student) {
        this.students.add(student);
    }
}

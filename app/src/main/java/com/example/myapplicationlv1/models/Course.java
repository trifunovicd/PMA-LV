package com.example.myapplicationlv1.models;

import java.util.ArrayList;

public class Course {
    String title;
    ArrayList<Instructor> instructors;

    public String getTitle() {
        return title;
    }

    public ArrayList<Instructor> getInstructors() {
        return instructors;
    }
}

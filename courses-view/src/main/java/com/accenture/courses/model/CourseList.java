package com.accenture.courses.model;

import java.util.ArrayList;
import java.util.List;

public class CourseList {

    private List<Course> listCourses = new ArrayList<Course>();

    public CourseList(List<Course> listCourses) {
        this.listCourses = listCourses;
    }

    public List<Course> getListCourses() {
        return listCourses;
    }

    public void setListCourses(List<Course> listCourses) {
        this.listCourses = listCourses;
    }
}

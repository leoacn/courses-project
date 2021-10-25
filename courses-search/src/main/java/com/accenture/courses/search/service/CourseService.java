package com.accenture.courses.search.service;

import com.accenture.courses.search.model.Course;

import java.util.List;

public interface CourseService {
    Course getCourseById(String id);
    List<Course> getAllCourses();
}

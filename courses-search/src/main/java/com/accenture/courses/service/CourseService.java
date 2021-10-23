package com.accenture.courses.service;

import com.accenture.courses.dto.CourseDTO;

import java.util.List;

public interface CourseService {
    CourseDTO getCourseById(Integer id);
    List<CourseDTO> getAllCourses();
}

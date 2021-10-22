package com.accenture.courses.service.impl;

import com.accenture.courses.model.Course;
import com.accenture.courses.repository.CourseRepository;
import com.accenture.courses.service.CourseService;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public final class CourseServiceImpl implements CourseService {

    private final CourseRepository courseRepository;

    @Autowired
    public CourseServiceImpl(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @Override
    public void saveCourse(String courseName) {
        if(Strings.isBlank(courseName)) {
            throw new IllegalArgumentException("Course name cannot be blank");
        }
        Course course = new Course();
        course.setName(courseName);
        courseRepository.save(course);
    }
}

package com.accenture.courses.service.impl;

import com.accenture.courses.dto.CourseDTO;
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
    public CourseDTO saveCourse(String courseName) {
        if(Strings.isBlank(courseName)) {
            throw new IllegalArgumentException("Course name cannot be blank");
        }
        Course course = new Course();
        course.setName(courseName);

        Course response = courseRepository.save(course);

        CourseDTO courseDTO = new CourseDTO();
        courseDTO.setId(response.getId());
        courseDTO.setName(response.getName());

        return courseDTO;
    }
}

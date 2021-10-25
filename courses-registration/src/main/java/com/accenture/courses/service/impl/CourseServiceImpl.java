package com.accenture.courses.service.impl;

import com.accenture.courses.registration.dto.CourseDTO;
import com.accenture.courses.registration.model.Course;
import com.accenture.courses.registration.repository.CourseRepository;
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
    public Course saveCourse(Course course) {

        if(Strings.isBlank(course.getName())) {
            throw new IllegalArgumentException("Course name cannot be blank");
        }

        CourseDTO dto=CourseDTO.create(course.getId(),course.getName(),course.getDetails(),course.getDuration());

        CourseDTO resp = courseRepository.save(dto);

        return Course.create(resp.getId(),resp.getName(),resp.getDetails(),resp.getDuration());
    }
}

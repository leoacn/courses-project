package com.accenture.courses.search.service.impl;

import com.accenture.courses.search.dto.CourseDTO;
import com.accenture.courses.search.model.Course;
import com.accenture.courses.search.repository.CourseRepository;
import com.accenture.courses.search.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CourseServiceImpl implements CourseService {

    private final CourseRepository courseRepository;

    @Autowired
    public CourseServiceImpl(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @Override
    public Course getCourseById(String id) {
        Optional<CourseDTO> result = courseRepository.findById(id);

        if (!result.isPresent()) {
            return null;
        }

        CourseDTO courseDTO = result.get();

        Course course=Course.create(courseDTO.getId(),courseDTO.getName(), courseDTO.getDetails(), courseDTO.getDuration());

        return course;
    }

    @Override
    public List<Course> getAllCourses() {
        List<CourseDTO> courseList = courseRepository.findAll();

        List<Course> courses = new ArrayList<>();

        for (CourseDTO dto : courseList) {
            courses.add(convertToModel(dto));
        }
        return courses;
    }

    private Course convertToModel(CourseDTO courseDTO) {

        Course course=Course.create(courseDTO.getId(),courseDTO.getName(), courseDTO.getDetails(), courseDTO.getDuration());

        return course;
    }
}

package com.accenture.courses.service.impl;

import com.accenture.courses.dto.CourseDTO;

import com.accenture.courses.model.Course;
import com.accenture.courses.repository.CourseRepository;
import com.accenture.courses.service.CourseService;
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
    public CourseDTO getCourseById(Integer id) {
        Optional<Course> course = courseRepository.findById(id);
        if(!course.isPresent()) {
            return null;
        }
        Course response = course.get();
        CourseDTO courseDTO = new CourseDTO();
        courseDTO.setId(response.getId());
        courseDTO.setName(response.getName());
        return courseDTO;
    }

    @Override
    public List<CourseDTO> getAllCourses() {
        List<Course> courseList = courseRepository.findAll();
        List<CourseDTO> courseDTOList = new ArrayList<>();
        for (Course course : courseList) {
            courseDTOList.add(convertToDTO(course));
        }
        return courseDTOList;
    }

    private CourseDTO convertToDTO(Course course) {
        CourseDTO courseDTO = new CourseDTO();
        courseDTO.setId(course.getId());
        courseDTO.setName(course.getName());
        return courseDTO;
    }
}

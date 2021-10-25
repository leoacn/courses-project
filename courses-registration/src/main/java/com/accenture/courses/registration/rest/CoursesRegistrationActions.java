package com.accenture.courses.registration.rest;

import com.accenture.courses.registration.dto.CourseDTO;
import com.accenture.courses.registration.model.Course;
import com.accenture.courses.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController()
@RequestMapping("/courses")
public class CoursesRegistrationActions {

  private final CourseService courseService;


    @Autowired
    public CoursesRegistrationActions(final CourseService courseService) {
        this.courseService = courseService;
    }


    @PostMapping
    public ResponseEntity<Course> registerCourse(@RequestBody Course course, UriComponentsBuilder uriBui) {
        Course resp=courseService.saveCourse(course);

        URI newCourseUri=uriBui.path("/{id}").build(resp.getId());

        return ResponseEntity.created(newCourseUri).body(resp);
    }
}

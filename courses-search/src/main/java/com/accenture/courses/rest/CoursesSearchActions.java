package com.accenture.courses.rest;

import com.accenture.courses.dto.CourseDTO;
import com.accenture.courses.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController()
@RequestMapping("/courses")
public class CoursesSearchActions {

    private final CourseService courseService;

    @Autowired
    public CoursesSearchActions(CourseService courseService) {
        this.courseService = courseService;
    }


    @GetMapping(path = "/{id}")
    public ResponseEntity<?> getCourse(@PathVariable("id") final int id) {
        CourseDTO courseDTO = courseService.getCourseById(id);
        if (courseDTO != null)
            return new ResponseEntity<>(courseDTO, HttpStatus.OK);
        else
            return ResponseEntity.notFound().build();
    }

    @GetMapping(path = "/")
    public ResponseEntity<List<CourseDTO>> getAllCourses() {
        return new ResponseEntity<>(courseService.getAllCourses(), HttpStatus.OK);
    }

}

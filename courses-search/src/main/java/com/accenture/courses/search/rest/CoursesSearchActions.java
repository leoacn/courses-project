package com.accenture.courses.search.rest;

import com.accenture.courses.search.model.Course;
import com.accenture.courses.search.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController()
@RequestMapping("/courses")
public class CoursesSearchActions {

    private final CourseService courseService;

    @Autowired
    public CoursesSearchActions(CourseService courseService) {

        this.courseService = courseService;
    }


    @GetMapping(path = "/")
    public ResponseEntity<List<Course>> getAllCourses(){

        List<Course> courses=courseService.getAllCourses();

        if (courses != null && !courses.isEmpty())
            return new ResponseEntity<>(courses, HttpStatus.OK);
        else
            return ResponseEntity.notFound().build();
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<?> getCourse(@PathVariable("id") final String id) {

        Course course = courseService.getCourseById(id);
        if (course != null)
            return new ResponseEntity<>(course, HttpStatus.OK);
        else
            return ResponseEntity.notFound().build();
    }


}

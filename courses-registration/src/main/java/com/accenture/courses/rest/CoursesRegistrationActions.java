package com.accenture.courses.rest;

import com.accenture.courses.dto.CourseDTO;
import com.accenture.courses.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/courses")
public class CoursesRegistrationActions {

  // private final CourseService courseService;

    /*
    @Autowired
    public CoursesRegistrationActions(final CourseService courseService) {
        this.courseService = courseService;
    }
     */


    @PostMapping
<<<<<<< HEAD
    public ResponseEntity<?> registerCourse(@RequestParam String courseName) {
        //courseService.saveCourse(courseName);
        return ResponseEntity.ok("{ id:1, name:'" + courseName + "' }");
=======
    public ResponseEntity<CourseDTO> registerCourse(@RequestParam String courseName) {
        return new ResponseEntity<>(courseService.saveCourse(courseName), HttpStatus.OK);
>>>>>>> main
    }
}

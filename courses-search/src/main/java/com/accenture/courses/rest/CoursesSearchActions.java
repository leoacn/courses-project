package com.accenture.courses.rest;

import com.accenture.courses.dto.CourseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;

import java.util.ArrayList;
import java.util.List;

@RestController()
@RequestMapping("/courses")
public class CoursesSearchActions {

    @GetMapping(path = "/{id}")
    public ResponseEntity<?> getCourse(@PathVariable("id") final int id){
       if(id==1)
        return ResponseEntity.ok("{ id:1, name:'Spring boot Microservices' }");
       else
           return ResponseEntity.notFound().build();
    }

    @GetMapping(path = "/")
    public ResponseEntity<List<CourseDTO>> getAllCourses(){
        CourseDTO courseDTO1 = new CourseDTO();
        courseDTO1.setId(1);
        courseDTO1.setName("Dummy course");
        CourseDTO courseDTO2 = new CourseDTO();
        courseDTO2.setId(2);
        courseDTO2.setName("Foo course");
        List<CourseDTO> courses = new ArrayList<>();
        courses.add(courseDTO1);
        courses.add(courseDTO2);
        return new ResponseEntity<>(courses, HttpStatus.OK);
    }
}

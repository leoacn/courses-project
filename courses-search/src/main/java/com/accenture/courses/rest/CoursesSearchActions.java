package com.accenture.courses.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;

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


}

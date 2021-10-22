package com.accenture.courses.controller;

import com.accenture.courses.model.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "/courses")
public class CourseController {

    @Autowired
    private RestTemplateBuilder rest;

    @GetMapping(value = "/viewCourses")
    public String viewCourses(Model model) {

        Course[] coursesList = rest.build()
                .getForObject("http://localhost:8000/getAllCourse",Course[].class);

        model.addAttribute("courses",coursesList);
        return "courses/view";
    }

    @GetMapping(value = "/viewCourses/{id}")
    public String viewCoursesId(Model model) {

        Course[] coursesList = rest.build()
                .getForObject("http://localhost:8000/addCourse/",Course[].class);

        model.addAttribute("courses",coursesList);
        return "courses/view";
    }

    @PostMapping(value = "/addCourses")
    public String addCourses(Model model) {
        model.addAttribute("courses", new Course());
        return "courses/add";
    }
}

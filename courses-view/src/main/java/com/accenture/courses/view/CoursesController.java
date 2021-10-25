package com.accenture.courses.view;

import com.accenture.courses.view.model.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Controller
public class CoursesController {
    private static String GET_URL="http://localhost:9090/courses/";

    private static String POST_URL="http://localhost:8080/courses/";

    @Autowired
    private RestTemplate restTemplate;

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }

    @GetMapping("/")
    public String index(Model model) {

        List<Course> courseList=Arrays.asList(
        restTemplate.getForObject(GET_URL, Course[].class));

        ArrayList<Course> courses=new ArrayList<>(courseList);

        model.addAttribute("courses", courses);

        // return view name
        return "index";
    }

    @GetMapping("/register")
    public String registerForm(Model model){
        Course course=new Course();

        model.addAttribute("course",course);

        return "register_form";
    }

    @PostMapping("/register")
    public String submitRegister(@ModelAttribute("course") Course course) {

        HttpHeaders headers=new HttpHeaders();

        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));

        HttpEntity<Course> entityCourse=new HttpEntity<>(course,headers);

        ResponseEntity<Course> resp=restTemplate.postForEntity(POST_URL,entityCourse,Course.class);

        return "redirect:/";
    }


}
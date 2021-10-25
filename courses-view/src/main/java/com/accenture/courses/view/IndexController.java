package com.accenture.courses.view;

import com.accenture.courses.view.model.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class IndexController {

    @Autowired
    private RestTemplate restTemplate;

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }

    @GetMapping("/")
    public String index(Model model) {

        List<Course> courseList=Arrays.asList(
        restTemplate.getForObject("http://localhost:9090/courses/", Course[].class));

        ArrayList<Course> courses=new ArrayList<>(courseList);

        model.addAttribute("courses", courses);

        // return view name
        return "index";
    }

    @GetMapping("/form")
    public String form(Model model) {
        model.addAttribute("form", null);
        return "form";
    }
}
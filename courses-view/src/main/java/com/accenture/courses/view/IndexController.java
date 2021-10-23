package com.accenture.courses.view;

import com.accenture.courses.dto.CourseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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

        List<CourseDTO> dtos=Arrays.asList(
        restTemplate.getForObject("http://localhost:9090/courses/", CourseDTO[].class));

        ArrayList<CourseDTO> courses=new ArrayList<>(dtos);

        model.addAttribute("courses", courses);

        // return view name
        return "index";
    }
}
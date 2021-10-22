package com.accenture.courses.model;

import org.springframework.data.annotation.Id;

import java.io.Serializable;

public class Course implements Serializable {

    @Id
    private Integer id;

    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
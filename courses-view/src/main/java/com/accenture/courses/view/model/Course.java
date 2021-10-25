package com.accenture.courses.view.model;


public  class Course {

    private String id;

    private String name;

    private String details;

    private float duration;

    public Course(){
    }

    public Course(String id, String name, String details, float duration){
              this.id=id;
              this.name=name;
              this.details=details;
              this.duration=duration;
    }

    public static Course create(String id, String name, String details, float duration){
        return new Course(id,name,details,duration);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public float getDuration() {
        return duration;
    }

    public void setDuration(float duration) {
        this.duration = duration;
    }
}

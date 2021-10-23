package com.accenture.courses.repository;

import com.accenture.courses.model.Course;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CourseRepository extends MongoRepository<Course, Integer> {
}

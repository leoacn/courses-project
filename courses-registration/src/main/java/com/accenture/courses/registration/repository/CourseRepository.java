package com.accenture.courses.registration.repository;

import com.accenture.courses.registration.dto.CourseDTO;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CourseRepository extends MongoRepository<CourseDTO, String> {


}

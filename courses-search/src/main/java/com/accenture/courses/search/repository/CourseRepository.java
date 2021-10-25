package com.accenture.courses.search.repository;

import com.accenture.courses.search.dto.CourseDTO;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface CourseRepository extends MongoRepository<CourseDTO, String> {

    @Override
    List<CourseDTO> findAll();

    @Override
    Optional<CourseDTO> findById(String s);
}

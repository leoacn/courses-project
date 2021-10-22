package com.accenture.courses;

import com.accenture.courses.dto.CourseDTO;
import com.accenture.courses.model.Course;
import com.accenture.courses.repository.CourseRepository;
import com.accenture.courses.service.CourseService;
import com.accenture.courses.service.impl.CourseServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class CourseServiceTest {

    private CourseService courseService;

    @Mock
    private CourseRepository courseRepository;

    @Before
    public void init() {
        courseService = new CourseServiceImpl(courseRepository);
    }

    @Test
    public void getCourseByIdTest() {
        Integer dummyId = 1;

        Course dummyResponse = new Course();
        dummyResponse.setId(dummyId);
        dummyResponse.setName("Dummy course");

        when(courseRepository.findById(dummyId)).thenReturn(Optional.of(dummyResponse));
        CourseDTO courseDTO = courseService.getCourseById(dummyId);
        verify(courseRepository, times(1)).findById(dummyId);
        assertEquals(dummyResponse.getId(), courseDTO.getId());
        assertEquals(dummyResponse.getName(), courseDTO.getName());
    }

    @Test
    public void courseByIdNotFoundTest() {
        Integer dummyId = 2;

        when(courseRepository.findById(dummyId)).thenReturn(Optional.empty());
        CourseDTO courseDTO = courseService.getCourseById(dummyId);
        verify(courseRepository, times(1)).findById(dummyId);
        assertNull(courseDTO);
    }

    @Test
    public void getAllCourses() {


        List<Course> dummyResponse = new ArrayList<>();
        Course dummyCourse1 = new Course();
        Course dummyCourse2 = new Course();
        dummyCourse1.setId(1);
        dummyCourse1.setName("Dummy course");
        dummyCourse2.setId(2);
        dummyCourse2.setName("Foo course");
        dummyResponse.add(dummyCourse1);
        dummyResponse.add(dummyCourse2);

        when(courseRepository.findAll()).thenReturn(dummyResponse);
        List<CourseDTO> courseDTOList = courseService.getAllCourses();
        verify(courseRepository, times(1)).findAll();
        assertFalse(courseDTOList.isEmpty());
        assertEquals(2, courseDTOList.size());
    }
}

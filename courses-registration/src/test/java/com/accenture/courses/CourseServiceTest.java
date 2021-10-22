package com.accenture.courses;

import com.accenture.courses.model.Course;
import com.accenture.courses.repository.CourseRepository;
import com.accenture.courses.service.CourseService;
import com.accenture.courses.service.impl.CourseServiceImpl;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class CourseServiceTest {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    private CourseService courseService;

    @Mock
    private CourseRepository courseRepository;

    @Before
    public void init() {
        courseService = new CourseServiceImpl(courseRepository);
    }

    @Test
    public void registerCourseSuccessfully() {
        String courseName = "Dummy course";
        courseService.saveCourse(courseName);
        verify(courseRepository, times(1)).save(any(Course.class));
    }

    @Test
    public void throwsExceptionWhenNameIsNulTest() {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("Course name cannot be blank");
        courseService.saveCourse(null);
    }
}

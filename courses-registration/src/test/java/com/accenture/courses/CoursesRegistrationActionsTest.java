package com.accenture.courses;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.accenture.courses.rest.CoursesRegistrationActions;
import com.accenture.courses.service.CourseService;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

/**
 * Unit test for simple App.
 */
@RunWith(SpringRunner.class)
@WebMvcTest(CoursesRegistrationActions.class)
public class CoursesRegistrationActionsTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean(name = "courseService")
    private CourseService courseService;

    /**
     * Rigorous Test :-)
     */
    @Test
    public void courseRegistrationControllerTest() throws Exception {
        String courseName = "Dummy course";
        mockMvc.perform(post("/courses")
                .param("courseName", courseName))
                .andDo(print())
                .andExpect(status().isOk());
        verify(courseService, times(1)).saveCourse(anyString());
    }
}

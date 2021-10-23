package com.accenture.courses;

<<<<<<< HEAD
import static org.junit.Assert.assertFalse;
=======
import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;
>>>>>>> main
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import com.accenture.courses.dto.CourseDTO;
import com.accenture.courses.rest.CoursesSearchActions;
import com.accenture.courses.service.CourseService;
import com.google.gson.*;
import com.google.gson.reflect.TypeToken;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
<<<<<<< HEAD
=======
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.mock.web.MockHttpServletResponse;
>>>>>>> main
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Unit test for simple App.
 */
@RunWith(SpringRunner.class)
@WebMvcTest(CoursesSearchActions.class)
public class CoursesSearchActionsAppTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean(name = "courseService")
    private CourseService courseService;

    /**
     * Rigorous Test :-)
     */
    @Test
    public void getAllCoursesSuccesfully() throws Exception {
        Gson gson = new GsonBuilder()
                .registerTypeAdapter(LocalDate.class, (JsonDeserializer<LocalDate>) (json, type, jsonDeserializationContext) -> LocalDate.parse(json.getAsJsonPrimitive().getAsString()))
                .registerTypeAdapter(LocalDateTime.class, (JsonDeserializer<LocalDateTime>) (json, type, jsonDeserializationContext) -> LocalDateTime.parse(json.getAsJsonPrimitive().getAsString()))
                .create();

        CourseDTO courseDTO1 = new CourseDTO();
        courseDTO1.setId(1);
        courseDTO1.setName("Dummy course");
        CourseDTO courseDTO2 = new CourseDTO();
        courseDTO2.setId(2);
        courseDTO2.setName("Foo course");
        List<CourseDTO> courses = new ArrayList<>();
        courses.add(courseDTO1);
        courses.add(courseDTO2);

        when(courseService.getAllCourses()).thenReturn(courses);

        ResultActions resultActions = mockMvc.perform(get("/courses/"))
                .andDo(print())
                .andExpect(status().isOk());

        String contentJson = resultActions.andReturn().getResponse().getContentAsString();
        List<CourseDTO> courseDTOList = gson.fromJson(contentJson, new TypeToken<List<CourseDTO>>(){}.getType());
        assertFalse(courseDTOList.isEmpty());
        assertEquals(2, courseDTOList.size());
    }

    @Test
    public void getCourseById() throws Exception {
        Gson gson = new GsonBuilder()
                .registerTypeAdapter(LocalDate.class, (JsonDeserializer<LocalDate>) (json, type, jsonDeserializationContext) -> LocalDate.parse(json.getAsJsonPrimitive().getAsString()))
                .registerTypeAdapter(LocalDateTime.class, (JsonDeserializer<LocalDateTime>) (json, type, jsonDeserializationContext) -> LocalDateTime.parse(json.getAsJsonPrimitive().getAsString()))
                .create();

        CourseDTO courseDTO1 = new CourseDTO();
        courseDTO1.setId(1);
        courseDTO1.setName("Dummy course");

        when(courseService.getCourseById(anyInt())).thenReturn(courseDTO1);

        ResultActions resultActions = mockMvc.perform(get("/courses/1"))
                .andDo(print())
                .andExpect(status().isOk());

        String contentJson = resultActions.andReturn().getResponse().getContentAsString();
        CourseDTO courseDTO = gson.fromJson(contentJson, new TypeToken<CourseDTO>(){}.getType());
        assertNotNull(courseDTO);

    }

    @Test
    public void courseByIdNotFound() throws Exception {
        when(courseService.getCourseById(anyInt())).thenReturn(null);
        mockMvc.perform(get("/courses/1"))
                .andDo(print())
                .andExpect(status().isNotFound());
    }
}

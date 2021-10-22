package com.accenture.courses;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.accenture.courses.dto.CourseDTO;
import com.accenture.courses.rest.CoursesSearchActions;
import com.google.gson.*;
import com.google.gson.reflect.TypeToken;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import java.lang.reflect.Type;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

/**
 * Unit test for simple App.
 */
@RunWith(SpringRunner.class)
@WebMvcTest(CoursesSearchActions.class)
public class CoursesSearchActionsAppTest {

    @Autowired
    private MockMvc mockMvc;


    /**
     * Rigorous Test :-)
     */
    @Test
    public void getAllCoursesSuccesfully() throws Exception {
        Gson gson = new GsonBuilder()
                .registerTypeAdapter(LocalDate.class, (JsonDeserializer<LocalDate>) (json, type, jsonDeserializationContext) -> LocalDate.parse(json.getAsJsonPrimitive().getAsString()))
                .registerTypeAdapter(LocalDateTime.class, (JsonDeserializer<LocalDateTime>) (json, type, jsonDeserializationContext) -> LocalDateTime.parse(json.getAsJsonPrimitive().getAsString()))
                .create();

        ResultActions resultActions = mockMvc.perform(get("/courses/"))
                .andDo(print())
                .andExpect(status().isOk());

        String contentJson = resultActions.andReturn().getResponse().getContentAsString();
        List<CourseDTO> courseDTOList = gson.fromJson(contentJson, new TypeToken<List<CourseDTO>>(){}.getType());
        assertFalse(courseDTOList.isEmpty());
    }
}

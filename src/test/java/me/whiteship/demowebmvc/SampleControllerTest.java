package me.whiteship.demowebmvc;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@WebMvcTest
class SampleControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    void helloTest() throws Exception {
        this.mockMvc.perform(get("/hello"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string("hello"));

    }

    @Test
    void getEvents() throws Exception {
        this.mockMvc.perform(get("/events"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void getEventsWithId() throws Exception {
        this.mockMvc.perform(get("/events/1"))
                .andDo(print())
                .andExpect(status().isOk());

        this.mockMvc.perform(get("/events/2"))
                .andDo(print())
                .andExpect(status().isOk());

        this.mockMvc.perform(get("/events/3"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void createEvent() throws Exception {
        this.mockMvc.perform(post("/events")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .accept(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk());
    }

    @Test
    public void deleteEvent() throws Exception {
        this.mockMvc.perform(delete("/events/1"))
                .andDo(print())
                .andExpect(status().isOk());

        this.mockMvc.perform(delete("/events/2"))
                .andDo(print())
                .andExpect(status().isOk());

        this.mockMvc.perform(delete("/events/3"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void updateEvent() throws Exception {
        this.mockMvc.perform(put("/events")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .accept(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk());
    }
}
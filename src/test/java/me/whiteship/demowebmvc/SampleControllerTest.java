package me.whiteship.demowebmvc;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@WebMvcTest
class SampleControllerTest {

    @Autowired
    MockMvc mockMvc;

   @Test
    public void eventForm() throws Exception {
       this.mockMvc.perform(get("/events/form"))
               .andDo(print())
               .andExpect(view().name("/events/form"))
               .andExpect(model().attributeExists("event"));
   }

   @Test
    public void postEvent() throws Exception {
       this.mockMvc.perform(post("/events")
               .param("name","keesun")
               .param("limit","keesun"))
               .andDo(print());
   }

}
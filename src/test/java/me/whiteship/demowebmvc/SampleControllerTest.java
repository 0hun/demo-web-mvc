package me.whiteship.demowebmvc;

import org.hibernate.validator.internal.constraintvalidators.bv.NotNullValidator;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.web.servlet.ModelAndView;

import javax.xml.transform.Result;
import java.util.Map;

import static org.hamcrest.Matchers.notNullValue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@WebMvcTest
class SampleControllerTest {

    @Autowired
    MockMvc mockMvc;

   @Test
    public void eventForm() throws Exception {
       MockHttpServletRequest request = this.mockMvc.perform(get("/events/form"))
               .andDo(print())
               .andExpect(view().name("events/form"))
               .andExpect(model().attributeExists("event"))
               .andExpect(request().sessionAttribute("event", notNullValue()))
               .andReturn().getRequest();

       Object event = request.getSession().getAttribute("event");
       System.out.println(event);
   }

   @Test
    public void postEvent() throws Exception {
       ResultActions result = this.mockMvc.perform(post("/events")
               .param("name","keesun")
               .param("limit","-10"))
               .andDo(print())
               .andExpect(status().isOk())
               .andExpect(model().hasErrors());

       ModelAndView mav = result.andReturn().getModelAndView();
       Map<String, Object> model = mav.getModel();
       System.out.println(model.size());
   }

}
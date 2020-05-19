package me.whiteship.demowebmvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class SampleController {

    @RequestMapping("/events/{id}")
    @ResponseBody
    public Event getEvent(@PathVariable Integer id) {
        Event event = new Event();
        event.setId(id);
        return event;
    }

}

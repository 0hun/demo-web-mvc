package me.whiteship.demowebmvc;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
public class SampleController {

    @GetMapping("/events")
    @ResponseBody
    public String events() {
        return "events";
    }

    @GetMapping("/events/{id}")
    @ResponseBody
    public String getEvents(@PathVariable int id) {
        return "events";
    }

    @GetHelloMapping
    @ResponseBody
    public String hello() {
        return "hello";
    }



    @DeleteMapping("/events/{id}")
    @ResponseBody
    public String removeEvents(@PathVariable int id) {
        return "events";
    }


}

package me.whiteship.demowebmvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class SampleController {

    @GetMapping("/events/form")
    public String eventForm(Model model) {
        Event event = new Event();
        event.setLimit(50);
        model.addAttribute("event", event);
        return "events/form";
    }

    @PostMapping("/events")
    public String createEvent(@Validated @ModelAttribute Event event,
                           BindingResult bindingResult,
                           Model model) {
        if(bindingResult.hasErrors()) {
            return "events/form";
        }

        return "redirect:events/list";
    }

    @GetMapping("/events/list")
    public String getEvent(Model model) {
        Event event = new Event();
        event.setName("spring");
        event.setLimit(10);

        List<Event> eventList = new ArrayList<>();
        eventList.add(event);

        model.addAttribute(eventList);

        return "events/list";
    }

}

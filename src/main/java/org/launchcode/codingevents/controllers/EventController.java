package org.launchcode.codingevents.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Chris Bay
 */
@Controller
@RequestMapping("events")
public class EventController {

    private static List<String> events= new ArrayList<>();

    @GetMapping
    public String displayAllEvents(Model model) {
//        List<String> events = new ArrayList<>();
//        events.add("Code With Pride");
//        events.add("Strange Loop");
//        events.add("Apple WWDC");
//        ievents.add("SpringOne Platform");
        //** above lines are commented as the create event redirect to displayall events
        model.addAttribute("events", events);
        return "events/index";
    }


    //lives at /events/create
    @GetMapping("create")
    public String renderCreateEventForm(){
        return "events/create";
    }

    //lives at /events/create
    @PostMapping("create")
   public String createEvent(@RequestParam String eventName) {
        //the variable name 'eventName should match the /event/create template input text name
        events.add(eventName);
        return "redirect:";
        // redirect to the path specified after the ':'.In this case since we have @RequestMapping("events") at the top this will redirect to local8080/events
        //which will call above method displayAllEvents
   }

}
package br.com.dcx.ufpb.eng.ApiCiclismo.controller;

import br.com.dcx.ufpb.eng.ApiCiclismo.entity.Event;
import br.com.dcx.ufpb.eng.ApiCiclismo.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/events")
@RestController
public class EventController {

    @Autowired
    private EventService eventService;

    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    @GetMapping
    public ResponseEntity<List<Event>> getAllEvents(){
        return eventService.getAllEvents;
    }

    @GetMapping("/{name}")
    public ResponseEntity<List<Event>> getEventByName(@PathVariable String event_name) {
        return eventService.getEventByName(event_name);
    }

    @PostMapping
    public ResponseEntity<Event> save(@RequestBody Event event){
        Event event = eventService.save(event);
        return new ResponseEntity<>(event, HttpStatus.CREATED);
    }
}

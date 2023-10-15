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
    public List<Event> getAllEvents(){
        return eventService.getAllEvents;
    }

    @GetMapping("/{name}")
    public List<Event> getEventByName (@PathVariable String event_name) {
        return eventService.getByName(event_name);
    }

    @GetMapping("/{id}")
    public Event getEventById(@PathVariable Long eventId) {
        return eventService.findById(eventId);
    }

    @GetMapping("/{level}")
    public List<Event> getEventByLevel(@PathVariable String level) {
        return eventService.getByLevel(level);
    }

    @PostMapping
    public Event save(@RequestBody Event event){
        Event event = eventService.save(event);
        return new ResponseEntity<>(event, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateEvent(@PathVariable Long id, @RequestBody EventDTO event) {
        eventService.updateEvent(id, event);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteEvent(@PathVariable Long id) throws EventNotFoundException {
        eventService.deleteEvent(id);
    }
}

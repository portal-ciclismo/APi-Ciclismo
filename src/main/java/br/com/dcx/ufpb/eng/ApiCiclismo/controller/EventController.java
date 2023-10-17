package br.com.dcx.ufpb.eng.ApiCiclismo.controller;

import br.com.dcx.ufpb.eng.ApiCiclismo.entity.Event;
import br.com.dcx.ufpb.eng.ApiCiclismo.exception.EventNotFoundException;
import br.com.dcx.ufpb.eng.ApiCiclismo.service.serviceIMPL.EventService;
import br.com.dcx.ufpb.eng.ApiCiclismo.dto.EventDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
        return eventService.getAllEvents();
    }

    @GetMapping("/{name}")
    public List<Event> getEventByName (@PathVariable String event_name) {
        return eventService.getEventByName(event_name);
    }

    @GetMapping("/{id}")
    public Event getEventById(@PathVariable Long eventId) throws EventNotFoundException {
        return eventService.getEventById(eventId);
    }

    @GetMapping("/{level}")
    public List<Event> getEventByLevel(@PathVariable String level) {
        return eventService.getByLevel(level);
    }

    @PostMapping
    public Event save(@RequestBody Event event){
        return eventService.saveEvent(event);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateEvent(@PathVariable Long id, @RequestBody EventDTO eventDTO) throws EventNotFoundException {
        eventService.updateEvent(id, eventDTO);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteEvent(@PathVariable Long id) {
        eventService.deleteEvent(id);
    }
}

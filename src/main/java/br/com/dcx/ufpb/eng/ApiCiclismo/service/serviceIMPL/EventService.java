package br.com.dcx.ufpb.eng.ApiCiclismo.service.serviceIMPL;

import br.com.dcx.ufpb.eng.ApiCiclismo.entity.Event;
import br.com.dcx.ufpb.eng.ApiCiclismo.repositories.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EventService {

    private final EventRepository eventRepository;

    @Autowired
    public EventService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    public List<Event> getEvents(){
        return eventRepository.findAll();
    }

    public Event saveEvent(Event event) {
        return eventRepository.save(event);
    }

    public Event getEventById(Long id) throws EventNotFoundException {
        return eventRepository.findById(id).orElseThrow(EventNotFoundException("Non-existent event."));
    }

    public List<Event> getEventByName(String event_name) {
        return eventRepository.findAllByName(event_name);
    }

}

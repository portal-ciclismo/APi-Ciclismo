package br.com.dcx.ufpb.eng.ApiCiclismo.service.serviceIMPL;

import br.com.dcx.ufpb.eng.ApiCiclismo.dto.EventDTO;
import br.com.dcx.ufpb.eng.ApiCiclismo.entity.Event;
import br.com.dcx.ufpb.eng.ApiCiclismo.exception.EventNotFoundException;
import br.com.dcx.ufpb.eng.ApiCiclismo.repositories.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class EventService {

    private final EventRepository eventRepository;
    public List<Event> getAllEvents() {
        return eventRepository.findAll();
    }

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
        return eventRepository.findById(id).orElseThrow(() -> new EventNotFoundException("Non-existent event."));
    }

    public List<Event> getEventByName(String event_name) {
        return eventRepository.findByName(event_name);
    }

    public void deleteEvent(Long id) {
        eventRepository.deleteById(id);
    }

    public List<Event> getByLevel(String level) {
        return eventRepository.findByLevel(level);
    }

    public void updateEvent(Long id, EventDTO eventDTO) throws EventNotFoundException {
        Optional<Event> optionalEvent = eventRepository.findById(id);
        if(optionalEvent.isEmpty()) {
            throw new EventNotFoundException("Event not found.");
        }
        Event event = optionalEvent.get();
        event.setName(eventDTO.getName());

        LocalDateTime dateTime = LocalDateTime.parse(eventDTO.getDate() + " " + eventDTO.getTime());
        event.setDate(dateTime);

        event.setDescription(eventDTO.getDescription());
        event.setLevel(eventDTO.getLevel());
        event.setParticipants(eventDTO.getParticipants());
        event.setSpeed(eventDTO.getSpeed());
        event.setStartLocation(eventDTO.getStartLocation());
        event.setEndLocation(eventDTO.getEndLocation());
        eventRepository.save(event);

    }
}

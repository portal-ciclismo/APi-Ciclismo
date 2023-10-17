package br.com.dcx.ufpb.eng.ApiCiclismo.repositories;


import br.com.dcx.ufpb.eng.ApiCiclismo.entity.Event;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface EventRepository extends JpaRepository<Event, Long> {
    
    List<Event> findByName(String eventName);
    List<Event> findByLevel(String eventLevel);
}

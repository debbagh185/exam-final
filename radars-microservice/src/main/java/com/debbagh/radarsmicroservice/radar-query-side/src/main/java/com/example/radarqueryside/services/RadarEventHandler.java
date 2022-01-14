package com.example.radarqueryside.services;


import com.example.radarqueryside.entities.Radar;
import com.example.radarqueryside.repositories.RadarRepository;
import com.debbagh.cqrs.events.RadarCreatedEvent;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class RadarEventHandler {

    private RadarRepository radarRepository;

    @EventHandler
    public void on(RadarCreatedEvent event){
        log.info("RadarCreatedEvent received.");
        Radar radar =  new Radar(event.getId(), event.getVitesseMax(), event.getLatitude(), event.getLongitude());
        radarRepository.save(radar);
    }
}

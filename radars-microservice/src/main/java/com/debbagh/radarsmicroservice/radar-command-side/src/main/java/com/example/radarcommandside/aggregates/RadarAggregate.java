package com.example.radarcommandside.aggregates;


import com.debbagh.cqrs.commands.CreateRadarCommand;
import com.debbagh.cqrs.events.RadarCreatedEvent;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;

@Aggregate
@Slf4j
public class RadarAggregate {
    @AggregateIdentifier
    private String radarId;
    private Double vitesseMax;
    private Double latitude;
    private Double longitude;

    public RadarAggregate() {
    }

    @CommandHandler
    public RadarAggregate(CreateRadarCommand command){
        log.info("CreateRadarComman received.");

        AggregateLifecycle.apply(new RadarCreatedEvent(
                command.getId(),
                command.getVitesseMax(),
                command.getLatitude(),
                command.getLongitude()
        ));
    }

    @EventSourcingHandler
    public void on(RadarCreatedEvent event){
        log.info("RadarCreatedEvent occured.");
        this.radarId = event.getId();
        this.vitesseMax = event.getVitesseMax();
        this.latitude = event.getLatitude();
        this.longitude = event.getLongitude();
    }
}

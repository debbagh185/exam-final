package com.example.radarcommandside.controllers;


import com.debbagh.cqrs.commands.CreateRadarCommand;
import com.debbagh.cqrs.commands.UpdateRadarCommand;
import com.debbagh.cqrs.dtos.RadarRequestDTO;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.eventsourcing.eventstore.EventStore;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Stream;

@RestController
@AllArgsConstructor
@Slf4j
@RequestMapping("/radars/commands")
public class RadarCommandController {
    private CommandGateway commandGateway;
    private EventStore eventStore;

    @PostMapping("/create")
    public CompletableFuture<String> newRadar(@RequestBody RadarRequestDTO request){
        CompletableFuture<String> response = commandGateway.send(new CreateRadarCommand(
                UUID.randomUUID().toString(),
                request.getVitesseMaximale(),
                request.getLatitude(),
                request.getLongitude()
        ));
        return response;
    }

    @PutMapping("/update")
    public CompletableFuture<String> updateRadar(@RequestBody RadarRequestDTO request){
        CompletableFuture<String> response = commandGateway.send(new UpdateRadarCommand(
                UUID.randomUUID().toString(),
                request.getVitesseMaximale(),
                request.getLatitude(),
                request.getLongitude()
        ));
        return response;
    }

    @GetMapping("/eventStore/{radarId}")
    public Stream eventStore(@PathVariable String radarId){
        return eventStore.readEvents(radarId).asStream();
    }
}

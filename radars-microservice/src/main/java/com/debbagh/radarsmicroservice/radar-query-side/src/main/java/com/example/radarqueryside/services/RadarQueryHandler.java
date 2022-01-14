package com.example.radarqueryside.services;


import com.example.radarqueryside.entities.Radar;
import com.example.radarqueryside.repositories.RadarRepository;
import com.debbagh.cqrs.queries.GetAllRadarsQuery;
import com.debbagh.cqrs.queries.GetRadarByIdQuery;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class RadarQueryHandler {

    private RadarRepository radarRepository;

    @QueryHandler
    public List<Radar> radarList(GetAllRadarsQuery query){
        return radarRepository.findAll();
    }

    @QueryHandler
    public Radar radarById(GetRadarByIdQuery query){
        return radarRepository.findById(query.getId())
                .orElseThrow(()->new RuntimeException("Radar Not Found"));
    }

}

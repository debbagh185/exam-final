package com.example.radarqueryside.repositories;

import com.example.radarqueryside.entities.Radar;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RadarRepository extends JpaRepository<Radar, String> {
}
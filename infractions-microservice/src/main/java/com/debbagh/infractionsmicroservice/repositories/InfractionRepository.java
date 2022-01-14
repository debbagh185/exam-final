package com.debbagh.infractionsmicroservice.repositories;

import com.debbagh.infractionsmicroservice.entities.Infraction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InfractionRepository extends JpaRepository<Infraction, Long> {
}
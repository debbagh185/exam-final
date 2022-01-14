package com.debbagh.infractionsmicroservice.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Infraction {
    @Id
    private String id;
    private Date date;
    private long radarNumber;
    private String numMatricule;
    private double vitesseVehicule;
    private double vitesseMaxRadar;
    private double montantInfraction;
}

package com.debbagh.cqrs.dtos

import java.util.*

data class RadarRequestDTO(
        val vitesseMaximale:Double,
        val longitude : Double,
        val latitude : Double,
)


data class VehiculeRequestDTO(
        val numMatricule: String,
        val matricule: String,
        val puissanceFiscale: Double,
        val modele: String
)

data class ProprietaireRequestDTO(
        val nom: String,
        val dateNaissance: Date,
        val email: String,
)

data class InfractionRequestDTO(
        val date: Date,
        val vitesseVehicule: Double,
        val vitesseMaxRadar: Double,
        val montant: Double,
)

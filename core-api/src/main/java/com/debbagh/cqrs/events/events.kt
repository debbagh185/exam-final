package com.debbagh.cqrs.events

import com.debbagh.cqrs.commands.BaseCommand
import java.util.*

abstract class BaseEvent<T>(
        open val id : T
)

data class RadarCreatedEvent(
        override val id: String,
        val vitesseMax: Double,
        val latitude : Double,
        val longitude : Double,
): BaseEvent<String>(id)

data class RadarUpdatedEvent(
        override val id: String,
        val vitesseMax: Double,
        val latitude : Double,
        val longitude : Double,
): BaseEvent<String>(id)


data class VehiculeCreatedEvent(
        override val id: String,
        val numMatricule: String,
        val matricule: String,
        val puissanceFiscale: Double,
        val modele: String
): BaseEvent<String>(id)

data class VehiculeUpdatedEvent(
        override val id: String,
        val numMatricule: String,
        val matricule: String,
        val puissanceFiscale: Double,
        val modele: String
): BaseEvent<String>(id)

data class ProprietaireCreatedEvent(
        override val id: String,
        val nom: String,
        val dateNaissance: Date,
        val email: String,
): BaseEvent<String>(id)

data class ProprietaireUpdatedEvent(
        override val id: String,
        val nom: String,
        val dateNaissance: Date,
        val email: String,
): BaseEvent<String>(id)

data class InfractionCreatedEvent(
        override val id: String,
        val date: Date,
        val vitesseVehicule: Double,
        val vitesseMaxRadar: Double,
        val montant: Double,
): BaseEvent<String>(id)

data class InfractionUpdatedEvent(
        override val id: String,
        val date: Date,
        val vitesseVehicule: Double,
        val vitesseMaxRadar: Double,
        val montant: Double,
): BaseEvent<String>(id)
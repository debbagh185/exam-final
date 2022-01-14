package com.debbagh.cqrs.commands

import org.axonframework.modelling.command.TargetAggregateIdentifier
import java.util.*

abstract class BaseCommand<T>(
        @TargetAggregateIdentifier
        open val id : T
)

data class CreateRadarCommand(
        override val id: String,
        val vitesseMax: Double,
        val latitude : Double,
        val longitude : Double
): BaseCommand<String>(id)


data class UpdateRadarCommand(
        override val id: String,
        val vitesseMax: Double,
        val latitude : Double,
        val longitude : Double
): BaseCommand<String>(id)

data class CreateVehiculeCommand(
        override val id: String,
        val numMatricule: String,
        val matricule: String,
        val puissanceFiscale: Double,
        val modele: String
): BaseCommand<String>(id)

data class UpdateVehiculeCommand(
        override val id: String,
        val numMatricule: String,
        val matricule: String,
        val puissanceFiscale: Double,
        val modele: String
): BaseCommand<String>(id)

data class CreateProprietaireCommand(
        override val id: String,
        val nom: String,
        val dateNaissance: Date,
        val email: String,
): BaseCommand<String>(id)

data class UpdateProprietaireCommand(
        override val id: String,
        val nom: String,
        val dateNaissance: Date,
        val email: String,
): BaseCommand<String>(id)

data class CreateInfractionCommand(
        override val id: String,
        val date: Date,
        val vitesseVehicule: Double,
        val vitesseMaxRadar: Double,
        val montant: Double,
): BaseCommand<String>(id)

data class UpdateInfractionCommand(
        override val id: String,
        val date: Date,
        val vitesseVehicule: Double,
        val vitesseMaxRadar: Double,
        val montant: Double,
): BaseCommand<String>(id)
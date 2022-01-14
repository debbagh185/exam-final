package com.debbagh.cqrs.queries

class GetAllRadarsQuery{}

class GetAllVehiculesQuery{}

class GetAllInfractionsQuery{}

class GetAllProprietaireQuery{}

data class GetRadarByIdQuery(
        val id:String
)
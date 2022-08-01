package com.example.parse.Model

data class Telematic(
    val costCenter: String,
    val equipmentId: String,
    val eventType: String,
    val lastAddressByLatLon: String,
    val lastLatLonPrecise: Boolean,
    val lastLatitude: Double,
    val lastLongitude: Double,
    val location: Location,
    val locationName: String,
    val projectId: String,
    val timestamp: Long
)
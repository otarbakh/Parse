package com.example.parse.Model

data class InternalTransportations(
    val deliveryDate: String,
    val deliveryDateMilliseconds: Long,
    val deliveryLocation: DeliveryLocation,
    val deliveryLocationAddress: String,
    val description: Any,
    val endDateOption: Any,
    val endDateOptionMilliseconds: Any,
    val id: String,
    val isOrganizedWithoutSam: Any,
    val pGroup: String,
    val pickUpDate: String,
    val pickUpDateMilliseconds: Long,
    val pickUpLocation: PickUpLocation,
    val pickUpLocationAddress: String,
    val projectRequestId: String,
    val provider: String,
    val startDateOption: Any,
    val startDateOptionMilliseconds: Any,
    val status: String,
    val templatePGroup: String
)
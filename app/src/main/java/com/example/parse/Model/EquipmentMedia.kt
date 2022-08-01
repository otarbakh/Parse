package com.example.parse.Model

data class EquipmentMedia(
    val createdAt: String,
    val files: List<File>,
    val id: String,
    val main: Boolean,
    val modelId: String,
    val modelType: String,
    val name: String,
    val type: String
)
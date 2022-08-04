package com.example.parse.Model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class HomeModel(
    val content: List<Content>
) {
    data class Content(
        val cover: String,
        val descriptionKA: String?,
        @SerializedName("publish_date")
        val publishDate: String?,
        val titleKA: String?
    ): Serializable
}
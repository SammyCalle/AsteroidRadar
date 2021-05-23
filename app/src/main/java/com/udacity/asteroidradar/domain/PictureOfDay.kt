package com.udacity.asteroidradar.domain

import com.udacity.asteroidradar.database.PictureTable

data class PictureOfDay(
    val url : String,
    val mediaType : String,
    val title : String
)

fun PictureOfDay.asDataBaseModel() = PictureTable(url, mediaType, title)
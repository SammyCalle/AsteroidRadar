package com.udacity.asteroidradar.database

import androidx.room.Entity
import com.udacity.asteroidradar.domain.PictureOfDay

@Entity(tableName = "picture", primaryKeys = arrayOf("url","title"))
data class PictureTable(val url : String, val mediaType : String,
                        val title : String)

fun List<PictureTable>.asDomainModel() : List<PictureOfDay>{
    return map{
        PictureOfDay(
            url = it.url,
            mediaType = it.mediaType,
            title = it.title
        )
    }
}
//fun PictureTable.asDomainModel() = PictureOfDay(url= this.url, mediaType=this.mediaType, title = this.title)
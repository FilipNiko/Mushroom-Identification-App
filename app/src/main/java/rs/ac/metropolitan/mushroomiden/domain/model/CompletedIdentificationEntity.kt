package rs.ac.metropolitan.mushroomiden.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class CompletedIdentificationEntity(

    @PrimaryKey(autoGenerate = false)
    val accessToken:String,
    val date: String,
    val latitude: Double?,
    val longitude: Double?,
    val imagesUrl:String,
    val city:String?,
    val country:String?,
    val continent:String?
)

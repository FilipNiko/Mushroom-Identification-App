package rs.ac.metropolitan.mushroomiden.data.remote.mushroom_dentification.dto

import com.google.gson.annotations.SerializedName

data class Characteristic(
    @SerializedName("hymenium type")
    val hymeniumType: String,
    @SerializedName("stipe character")
    val stipeCharacter: String,
    @SerializedName("spore print color")
    val sporePrintColor: String,
    @SerializedName("mushroom cap shape")
    val mushroomCapShape: String,
    @SerializedName("hymenium attachment")
    val hymeniumAttachment: String,
    @SerializedName("mushroom ecological type")
    val mushroomEcologicalType: String
)
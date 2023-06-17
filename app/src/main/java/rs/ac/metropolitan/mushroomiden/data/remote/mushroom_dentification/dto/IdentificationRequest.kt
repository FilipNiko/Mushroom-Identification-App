package rs.ac.metropolitan.mushroomiden.data.remote.mushroom_dentification.dto

data class IdentificationRequest(
    val images: List<String>,
    val latitude: Double? = 0.0,
    val longitude: Double? = 0.0,
    val similar_images: Boolean
)
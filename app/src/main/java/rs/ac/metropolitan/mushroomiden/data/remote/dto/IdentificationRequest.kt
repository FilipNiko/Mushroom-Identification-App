package rs.ac.metropolitan.mushroomiden.data.remote.dto

data class IdentificationRequest(
    val images: List<String>,
    val latitude: Double,
    val longitude: Double,
    val similar_images: Boolean
)
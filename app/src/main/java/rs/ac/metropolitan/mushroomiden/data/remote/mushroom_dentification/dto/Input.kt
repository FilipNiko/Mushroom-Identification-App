package rs.ac.metropolitan.mushroomiden.data.remote.mushroom_dentification.dto

data class Input(
    val images: List<String>,
    val latitude: Double,
    val longitude: Double,
    val similar_images: Boolean
)
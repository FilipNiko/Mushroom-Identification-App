package rs.ac.metropolitan.mushroomiden.data.remote.mushroom_dentification.dto

data class SimilarImage(
    val citation: String,
    val id: String,
    val license_name: String,
    val license_url: String,
    val similarity: Double,
    val url: String,
    val url_small: String
)
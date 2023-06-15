package rs.ac.metropolitan.mushroomiden.data.remote.dto

data class Suggestion(
    val details: Details? = null,
    val id: String = "",
    val name: String = "",
    val probability: Double =0.0,
    val similar_images: List<SimilarImage> = emptyList()
)
package rs.ac.metropolitan.mushroomiden.data.remote.reverse_geocoding.dto

data class Administrative(
    val adminLevel: Int,
    val description: String,
    val geonameId: Int,
    val isoCode: String,
    val name: String,
    val order: Int,
    val wikidataId: String
)
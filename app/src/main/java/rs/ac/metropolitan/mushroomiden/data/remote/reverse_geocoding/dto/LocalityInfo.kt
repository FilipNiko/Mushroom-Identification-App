package rs.ac.metropolitan.mushroomiden.data.remote.reverse_geocoding.dto

data class LocalityInfo(
    val LikelyLand: Boolean,
    val administrative: List<Administrative>,
    val informative: List<Informative>
)
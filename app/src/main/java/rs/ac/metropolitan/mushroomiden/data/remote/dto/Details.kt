package rs.ac.metropolitan.mushroomiden.data.remote.dto

data class Details(
    val characteristic: Characteristic,
    val common_names: List<String>,
    val description: Description,
    val edibility: String,
    val entity_id: String,
    val gbif_id: Int,
    val image: Image,
    val images: List<Image>,
    val inaturalist_id: Int,
    val language: String,
    val look_alike: List<LookAlike>,
    val psychoactive: Boolean,
    val rank: String,
    val taxonomy: Taxonomy,
    val url: String
)
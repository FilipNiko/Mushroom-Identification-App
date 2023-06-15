package rs.ac.metropolitan.mushroomiden.common.util



object HeatMapUrlBuilder {

    fun getUrlForLeftHeatImage(taxonId: Int): String {
        val leftBaseUrl:String = "https://api.gbif.org/v2/map/occurrence/density/0/0/0@1x.png?srs=EPSG:4326&style=purpleHeat.point&taxonKey="
        return leftBaseUrl+taxonId.toString();
    }

    fun getUrlForRightHeatImage(taxonId: Int): String {
        val rightBaseUrl:String = "https://api.gbif.org/v2/map/occurrence/density/0/1/0@1x.png?srs=EPSG:4326&style=purpleHeat.point&taxonKey="
        return rightBaseUrl+taxonId.toString();
    }
}
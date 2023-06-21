package rs.ac.metropolitan.mushroomiden.common

object Constants {

    const val BASE_IDENTIFICATION_URL = "https://mushroom.kindwise.com/api/v1/"

    const val DETAILS_IDENTIFICATION_URL = "identification?details=common_names,url,description,edibility,psychoactive,characteristic,look_alike,taxonomy,rank,gbif_id,inaturalist_id,image,images"

    const val DETAILS_RETRIEVE_IDENTIFICATION_URL = "?details=common_names,url,description,edibility,psychoactive,characteristic,look_alike,taxonomy,rank,gbif_id,inaturalist_id,image,images"



    const val BASE_GEOCODING_URL = "https://api.bigdatacloud.net/data/"
    const val REVERSE_GEOCODING_URL = "reverse-geocode-client"


    const val MOCK_URL = "https://a82c64eb-d1fa-4943-83e2-4018645a6c79.mock.pstmn.io"
    const val MOCK_DETAILS_URL = "post"
    const val MOCK_RETRIEVE_DETAILS_URL = "Get"



    const val PARAM_ACCESS_TOKEN = "accesToken"
    const val PARAM_SCORE = "score"


}
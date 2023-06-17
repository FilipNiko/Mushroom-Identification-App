package rs.ac.metropolitan.mushroomiden.data.remote.reverse_geocoding

import retrofit2.http.GET
import retrofit2.http.Query
import rs.ac.metropolitan.mushroomiden.common.Constants
import rs.ac.metropolitan.mushroomiden.data.remote.reverse_geocoding.dto.LocationResultInfoDto

interface ReverseGeocodingApi {

    @GET(Constants.REVERSE_GEOCODING_URL)
    suspend fun getLocationInfo(@Query("latitude") latitude:Double, @Query("longitude") longitude:Double):LocationResultInfoDto
}
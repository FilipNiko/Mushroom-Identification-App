package rs.ac.metropolitan.mushroomiden.data.repository

import rs.ac.metropolitan.mushroomiden.data.remote.reverse_geocoding.ReverseGeocodingApi
import rs.ac.metropolitan.mushroomiden.data.remote.reverse_geocoding.dto.LocationResultInfoDto
import rs.ac.metropolitan.mushroomiden.domain.repository.ReverseGeocodingRepository
import javax.inject.Inject

class ReverseGeocodingRepisotoryImpl @Inject constructor(private val api: ReverseGeocodingApi) :ReverseGeocodingRepository {

    override suspend fun getLocationResultInfo(
        latitude: Double,
        longitude: Double
    ): LocationResultInfoDto {
        return api.getLocationInfo(latitude, longitude)
    }
}
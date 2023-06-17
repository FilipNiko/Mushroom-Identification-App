package rs.ac.metropolitan.mushroomiden.domain.repository

import rs.ac.metropolitan.mushroomiden.data.remote.reverse_geocoding.dto.LocationResultInfoDto


interface ReverseGeocodingRepository {

    suspend fun getLocationResultInfo(latitude: Double, longitude:Double): LocationResultInfoDto
}
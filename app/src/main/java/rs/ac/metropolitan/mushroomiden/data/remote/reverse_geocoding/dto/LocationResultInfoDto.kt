package rs.ac.metropolitan.mushroomiden.data.remote.reverse_geocoding.dto

import rs.ac.metropolitan.mushroomiden.domain.model.LocationResultInfo


data class LocationResultInfoDto(
    val city: String,
    val continent: String,
    val continentCode: String,
    val countryCode: String,
    val countryName: String,
    val latitude: Double,
    val locality: String,
    val localityInfo: LocalityInfo,
    val localityLanguageRequested: String,
    val longitude: Double,
    val lookupSource: String,
    val plusCode: String,
    val postcode: String,
    val principalSubdivision: String,
    val principalSubdivisionCode: String
)

fun LocationResultInfoDto.toLocationResultInfo(): LocationResultInfo {
    return LocationResultInfo(
        city = city,
        continent = continent,
        countryName = countryName,
        latitude = latitude,
        longitude = longitude
    )
}
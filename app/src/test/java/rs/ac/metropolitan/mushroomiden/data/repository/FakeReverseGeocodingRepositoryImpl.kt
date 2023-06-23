package rs.ac.metropolitan.mushroomiden.data.repository

import rs.ac.metropolitan.mushroomiden.data.remote.reverse_geocoding.dto.Administrative
import rs.ac.metropolitan.mushroomiden.data.remote.reverse_geocoding.dto.LocalityInfo
import rs.ac.metropolitan.mushroomiden.data.remote.reverse_geocoding.dto.LocationResultInfoDto
import rs.ac.metropolitan.mushroomiden.domain.repository.ReverseGeocodingRepository

class FakeReverseGeocodingRepositoryImpl :ReverseGeocodingRepository {


    override suspend fun getLocationResultInfo(
        latitude: Double,
        longitude: Double
    ): LocationResultInfoDto {
        return LocationResultInfoDto(
            "Belgrade",
            "Europe",
            "EU",
            "RS",
            "Serbia",
            11.11,
            "s",
            LocalityInfo(
                false,
                listOf(
                Administrative(
                    1,
                    "desc",
                    1,
                    "isoCode",
                    "name",
                    1,
                    "wikidataId")
        ),
            listOf(
            )
            ),
            "localityLanguageRequested",
            22.22,
            "lookupScore",
            "plusCode",
            "postCode",
            "principalSubdiviosion",
            "code")
    }
}
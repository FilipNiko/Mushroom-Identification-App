package rs.ac.metropolitan.mushroomiden.presentation.identificationSceens

import rs.ac.metropolitan.mushroomiden.domain.model.IdentificationResult
import rs.ac.metropolitan.mushroomiden.domain.model.LocationResultInfo


class LocationResultInfoState(
    val isLoading: Boolean = false,
    val locationResultInfo: LocationResultInfo? = null,
    val error: String = ""
) {
}
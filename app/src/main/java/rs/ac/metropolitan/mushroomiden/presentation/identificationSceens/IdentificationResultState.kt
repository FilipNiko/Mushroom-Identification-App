package rs.ac.metropolitan.mushroomiden.presentation.identificationSceens


import rs.ac.metropolitan.mushroomiden.domain.model.IdentificationResult

class IdentificationResultState(
    val isLoading: Boolean = false,
    val identificationResult: IdentificationResult? = null,
    val error: String = ""
) {
}
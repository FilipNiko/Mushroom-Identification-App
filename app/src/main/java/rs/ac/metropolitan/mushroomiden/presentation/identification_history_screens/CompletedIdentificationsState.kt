package rs.ac.metropolitan.mushroomiden.presentation.identification_history_screens

import rs.ac.metropolitan.mushroomiden.domain.model.CompletedIdentificationEntity

data class CompletedIdentificationsState(
    val completedIdentifications: List<CompletedIdentificationEntity> = emptyList()

)
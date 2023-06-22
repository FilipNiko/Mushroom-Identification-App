package rs.ac.metropolitan.mushroomiden.domain.use_case.completed_identifications

import rs.ac.metropolitan.mushroomiden.domain.repository.CompletedIdentificationsRepository
import rs.ac.metropolitan.mushroomiden.domain.model.CompletedIdentificationEntity
import javax.inject.Inject

class AddCompletedIdentificationUseCase @Inject constructor (private val repository: CompletedIdentificationsRepository) {

    suspend operator fun invoke(completedIdentificationEntity: CompletedIdentificationEntity) {
        repository.upsertCompletedIdentification(completedIdentificationEntity)
    }
}
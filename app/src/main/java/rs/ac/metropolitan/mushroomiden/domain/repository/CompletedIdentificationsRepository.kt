package rs.ac.metropolitan.mushroomiden.domain.repository

import kotlinx.coroutines.flow.Flow
import rs.ac.metropolitan.mushroomiden.domain.model.CompletedIdentificationEntity

interface CompletedIdentificationsRepository {

    suspend fun upsertCompletedIdentification(completedIdentificationEntity: CompletedIdentificationEntity)

    fun getAllCompletedIdentifications(): Flow<List<CompletedIdentificationEntity>>
}
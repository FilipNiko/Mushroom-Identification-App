package rs.ac.metropolitan.mushroomiden.data.repository

import kotlinx.coroutines.flow.Flow
import rs.ac.metropolitan.mushroomiden.data.local_data_source.completed_identifications.CompletedIdentificationDao
import rs.ac.metropolitan.mushroomiden.domain.model.CompletedIdentificationEntity
import rs.ac.metropolitan.mushroomiden.domain.repository.CompletedIdentificationsRepository

class CompletedIdentificationRepositoryImpl (
    private val dao: CompletedIdentificationDao
    ) : CompletedIdentificationsRepository {


    override suspend fun upsertCompletedIdentification(completedIdentificationEntity: CompletedIdentificationEntity) {
        dao.upsertCompletedIdentification(completedIdentificationEntity)
    }

    override fun getAllCompletedIdentifications() : Flow<List<CompletedIdentificationEntity>> {
        return dao.getAllCompletedIdentifications()
    }
}
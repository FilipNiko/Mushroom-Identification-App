package rs.ac.metropolitan.mushroomiden.data.repository

import rs.ac.metropolitan.mushroomiden.data.local_data_source.CompletedIdentificationDao
import rs.ac.metropolitan.mushroomiden.domain.model.CompletedIdentificationEntity
import rs.ac.metropolitan.mushroomiden.domain.repository.CompletedIdentificationsRepository

class CompletedIdentificationRepositoryImpl (
    private val dao: CompletedIdentificationDao
    ) : CompletedIdentificationsRepository {


    override suspend fun upsertCompletedIdentification(completedIdentificationEntity: CompletedIdentificationEntity) {
        dao.upsertCompletedIdentification(completedIdentificationEntity)
    }

    override suspend fun getCompletedIdentificationByAccessToken(accessToken: String) : CompletedIdentificationEntity? {
        return dao.getCompletedIdentificationByAccessToken(accessToken)
    }
}
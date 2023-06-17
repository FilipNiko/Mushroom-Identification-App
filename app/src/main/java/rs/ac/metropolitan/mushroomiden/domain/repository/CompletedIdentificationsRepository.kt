package rs.ac.metropolitan.mushroomiden.domain.repository

import rs.ac.metropolitan.mushroomiden.domain.model.CompletedIdentificationEntity

interface CompletedIdentificationsRepository {

    suspend fun upsertCompletedIdentification(completedIdentificationEntity: CompletedIdentificationEntity)

    suspend fun getCompletedIdentificationByAccessToken(accessToken:String): CompletedIdentificationEntity?
}
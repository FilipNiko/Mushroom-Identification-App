package rs.ac.metropolitan.mushroomiden.data.repository

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import rs.ac.metropolitan.mushroomiden.domain.model.CompletedIdentificationEntity
import rs.ac.metropolitan.mushroomiden.domain.repository.CompletedIdentificationsRepository

class FakeCompletedIdentificationRepositoryImpl : CompletedIdentificationsRepository {


    private val completedIdentifications = mutableListOf<CompletedIdentificationEntity>()


    override suspend fun upsertCompletedIdentification(completedIdentificationEntity: CompletedIdentificationEntity) {

        completedIdentifications.add(completedIdentificationEntity)
    }


    override fun getAllCompletedIdentifications(): Flow<List<CompletedIdentificationEntity>> {

        return flow{ emit(completedIdentifications)}
    }
}
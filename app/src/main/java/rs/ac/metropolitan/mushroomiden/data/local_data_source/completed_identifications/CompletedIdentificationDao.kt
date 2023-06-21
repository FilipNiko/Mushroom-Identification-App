package rs.ac.metropolitan.mushroomiden.data.local_data_source.completed_identifications

import androidx.room.Dao
import androidx.room.Query

import androidx.room.Upsert
import kotlinx.coroutines.flow.Flow
import rs.ac.metropolitan.mushroomiden.domain.model.CompletedIdentificationEntity

@Dao
interface CompletedIdentificationDao {

    @Upsert
    suspend fun upsertCompletedIdentification(completedIdentificationEntity: CompletedIdentificationEntity)

    @Query("SELECT * FROM CompletedIdentificationEntity")
    fun getAllCompletedIdentifications(): Flow<List<CompletedIdentificationEntity>>
}
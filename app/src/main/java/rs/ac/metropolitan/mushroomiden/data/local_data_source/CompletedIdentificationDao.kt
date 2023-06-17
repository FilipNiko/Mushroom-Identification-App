package rs.ac.metropolitan.mushroomiden.data.local_data_source

import androidx.room.Dao
import androidx.room.Query

import androidx.room.Upsert
import rs.ac.metropolitan.mushroomiden.domain.model.CompletedIdentificationEntity

@Dao
interface CompletedIdentificationDao {

    @Upsert
    suspend fun upsertCompletedIdentification(completedIdentificationEntity: CompletedIdentificationEntity)

    @Query("SELECT * FROM CompletedIdentificationEntity WHERE accessToken = :accessToken")
    suspend fun getCompletedIdentificationByAccessToken(accessToken:String): CompletedIdentificationEntity?
}
package rs.ac.metropolitan.mushroomiden.data.local_data_source.completed_identifications

import androidx.room.Database
import androidx.room.RoomDatabase
import rs.ac.metropolitan.mushroomiden.domain.model.CompletedIdentificationEntity

@Database(
    entities = [CompletedIdentificationEntity::class],
    version = 1
)
abstract class CompletedIdentificationDatabase: RoomDatabase() {

    abstract val completedIdentificationDao: CompletedIdentificationDao

    companion object {
        const val DATABASE_NAME = "completed_identifications_db"
    }
}
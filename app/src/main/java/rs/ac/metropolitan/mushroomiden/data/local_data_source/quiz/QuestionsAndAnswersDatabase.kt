package rs.ac.metropolitan.mushroomiden.data.local_data_source.quiz

import androidx.room.Database
import androidx.room.RoomDatabase
import rs.ac.metropolitan.mushroomiden.domain.model.QuestionsAndAnswersEntity

@Database(
    entities = [QuestionsAndAnswersEntity::class],
    version = 1,
    exportSchema = true
)
abstract class QuestionsAndAnswersDatabase: RoomDatabase() {

    abstract val questionsAndAnswersDao: QuestionsAndAnswersDao

    companion object {
        const val DATABASE_NAME = "questions_and_answers_db"
    }
}
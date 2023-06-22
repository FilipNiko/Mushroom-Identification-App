package rs.ac.metropolitan.mushroomiden.data.local_data_source.quiz_scoreboard

import androidx.room.Database
import androidx.room.RoomDatabase
import rs.ac.metropolitan.mushroomiden.domain.model.QuestionsAndAnswersEntity
import rs.ac.metropolitan.mushroomiden.domain.model.QuizScoreEntity

@Database(
    entities = [QuizScoreEntity::class],
    version = 1,
    exportSchema = true
)
abstract class QuizScoreboardDatabase: RoomDatabase() {

    abstract val quizScoreboardDao: QuizScoreboardDao

    companion object {
        const val DATABASE_NAME = "quiz_scoreboard_db"
    }
}
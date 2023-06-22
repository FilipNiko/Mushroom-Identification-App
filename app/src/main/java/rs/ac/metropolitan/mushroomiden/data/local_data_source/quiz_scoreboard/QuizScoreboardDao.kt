package rs.ac.metropolitan.mushroomiden.data.local_data_source.quiz_scoreboard

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow
import rs.ac.metropolitan.mushroomiden.domain.model.QuizScoreEntity

@Dao
interface QuizScoreboardDao {

    @Query("SELECT * FROM QuizScoreEntity")
    fun getAllScores(): Flow<List<QuizScoreEntity>>

    @Insert
    suspend fun insertNewScore(score: QuizScoreEntity)
}
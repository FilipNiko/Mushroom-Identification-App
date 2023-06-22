package rs.ac.metropolitan.mushroomiden.data.local_data_source.quiz_questions_answers

import androidx.room.Dao
import androidx.room.Query
import kotlinx.coroutines.flow.Flow
import rs.ac.metropolitan.mushroomiden.domain.model.QuestionsAndAnswersEntity

@Dao
interface QuestionsAndAnswersDao {

    @Query("SELECT * FROM QuestionsAndAnswers")
    fun getAllQuestionsAndAnswers(): Flow<List<QuestionsAndAnswersEntity>>
}
package rs.ac.metropolitan.mushroomiden.data.local_data_source.quiz

import androidx.room.Dao
import androidx.room.Query
import kotlinx.coroutines.flow.Flow
import rs.ac.metropolitan.mushroomiden.domain.model.CompletedIdentificationEntity
import rs.ac.metropolitan.mushroomiden.domain.model.QuestionsAndAnswersEntity

@Dao
interface QuestionsAndAnswersDao {

    @Query("SELECT * FROM QuestionsAndAnswers")
    fun getAllQuestionsAndAnswers(): Flow<List<QuestionsAndAnswersEntity>>
}
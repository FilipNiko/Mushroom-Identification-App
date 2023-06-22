package rs.ac.metropolitan.mushroomiden.data.repository

import kotlinx.coroutines.flow.Flow
import rs.ac.metropolitan.mushroomiden.data.local_data_source.quiz_scoreboard.QuizScoreboardDao
import rs.ac.metropolitan.mushroomiden.domain.model.QuizScoreEntity
import rs.ac.metropolitan.mushroomiden.domain.repository.QuizScoreboardRepository


class QuizScoreboardRepositoryImpl (
    private val dao: QuizScoreboardDao
) : QuizScoreboardRepository {

    override suspend fun instertNewScore(score: QuizScoreEntity) {
        dao.insertNewScore(score)
    }

    override fun getAllScores(): Flow<List<QuizScoreEntity>> {
        return dao.getAllScores()
    }

}
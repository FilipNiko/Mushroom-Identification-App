package rs.ac.metropolitan.mushroomiden.data.repository

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import rs.ac.metropolitan.mushroomiden.domain.model.QuizScoreEntity
import rs.ac.metropolitan.mushroomiden.domain.repository.QuizScoreboardRepository

class FakeQuizScoreboardRepositoryImpl : QuizScoreboardRepository {

    private val scores = mutableListOf<QuizScoreEntity>()

    override suspend fun instertNewScore(score: QuizScoreEntity) {
        scores.add(score)
    }

    override fun getAllScores(): Flow<List<QuizScoreEntity>> {
        return flow {emit (scores)}
    }
}
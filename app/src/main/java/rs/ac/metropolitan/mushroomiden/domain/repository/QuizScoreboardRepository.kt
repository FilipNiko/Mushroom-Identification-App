package rs.ac.metropolitan.mushroomiden.domain.repository

import kotlinx.coroutines.flow.Flow
import rs.ac.metropolitan.mushroomiden.domain.model.QuizScoreEntity

interface QuizScoreboardRepository {

    suspend fun instertNewScore(score: QuizScoreEntity)

    fun getAllScores(): Flow<List<QuizScoreEntity>>

}
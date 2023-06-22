package rs.ac.metropolitan.mushroomiden.domain.use_case.quiz.scoreboard

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import rs.ac.metropolitan.mushroomiden.domain.model.QuizScoreEntity
import rs.ac.metropolitan.mushroomiden.domain.repository.QuizScoreboardRepository
import javax.inject.Inject

class GetAllScoresUseCase @Inject constructor (private val repository: QuizScoreboardRepository) {

    operator fun invoke() : Flow<List<QuizScoreEntity>> {
        return repository.getAllScores().map {
            it.reversed()
        }
    }
}
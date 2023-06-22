package rs.ac.metropolitan.mushroomiden.domain.use_case.quiz.scoreboard

import rs.ac.metropolitan.mushroomiden.domain.model.QuizScoreEntity
import rs.ac.metropolitan.mushroomiden.domain.repository.QuizScoreboardRepository
import javax.inject.Inject


class InsertNewScoreUseCase @Inject constructor (private val repository: QuizScoreboardRepository) {

    suspend operator fun invoke(scoreEntity: QuizScoreEntity) {
        repository.instertNewScore(scoreEntity)
    }
}
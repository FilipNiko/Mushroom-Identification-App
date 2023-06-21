package rs.ac.metropolitan.mushroomiden.domain.use_case.quiz


import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import rs.ac.metropolitan.mushroomiden.domain.model.QuestionsAndAnswersEntity
import rs.ac.metropolitan.mushroomiden.domain.repository.QuestionsAndAswersRepository
import javax.inject.Inject


class GetAllQuestionsAndAnswersUseCase @Inject constructor (private val repository: QuestionsAndAswersRepository) {

    operator fun invoke() : Flow<List<QuestionsAndAnswersEntity>> {
        return repository.getAllQuestionsAndAnswers().map {
            it.shuffled()
        }
    }
}
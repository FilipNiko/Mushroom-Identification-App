package rs.ac.metropolitan.mushroomiden.data.repository

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import rs.ac.metropolitan.mushroomiden.domain.model.QuestionsAndAnswersEntity
import rs.ac.metropolitan.mushroomiden.domain.repository.QuestionsAndAswersRepository

class FakeQuestionsAndAnswersRepositoryImpl : QuestionsAndAswersRepository {

    private val questionsAndAnswers = mutableListOf<QuestionsAndAnswersEntity>(
        QuestionsAndAnswersEntity(1, "1", "1", "1", "2", "3", "4", "5")
    )

    override fun getAllQuestionsAndAnswers(): Flow<List<QuestionsAndAnswersEntity>> {

        return flow { emit (questionsAndAnswers) }
    }
}
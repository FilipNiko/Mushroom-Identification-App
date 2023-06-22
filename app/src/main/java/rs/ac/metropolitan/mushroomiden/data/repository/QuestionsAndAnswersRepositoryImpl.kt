package rs.ac.metropolitan.mushroomiden.data.repository

import kotlinx.coroutines.flow.Flow
import rs.ac.metropolitan.mushroomiden.data.local_data_source.quiz_questions_answers.QuestionsAndAnswersDao
import rs.ac.metropolitan.mushroomiden.domain.model.QuestionsAndAnswersEntity
import rs.ac.metropolitan.mushroomiden.domain.repository.QuestionsAndAswersRepository


class QuestionsAndAnswersRepositoryImpl(private val dao: QuestionsAndAnswersDao) : QuestionsAndAswersRepository {

    override fun getAllQuestionsAndAnswers(): Flow<List<QuestionsAndAnswersEntity>> {
        return dao.getAllQuestionsAndAnswers()
    }
}
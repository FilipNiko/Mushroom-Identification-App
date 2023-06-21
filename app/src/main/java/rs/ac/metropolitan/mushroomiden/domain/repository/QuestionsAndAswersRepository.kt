package rs.ac.metropolitan.mushroomiden.domain.repository

import kotlinx.coroutines.flow.Flow
import rs.ac.metropolitan.mushroomiden.domain.model.CompletedIdentificationEntity
import rs.ac.metropolitan.mushroomiden.domain.model.QuestionsAndAnswersEntity


interface QuestionsAndAswersRepository {

    fun getAllQuestionsAndAnswers(): Flow<List<QuestionsAndAnswersEntity>>
}
package rs.ac.metropolitan.mushroomiden.domain.use_case.quiz.scoreboard

import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import rs.ac.metropolitan.mushroomiden.data.repository.FakeQuizScoreboardRepositoryImpl
import rs.ac.metropolitan.mushroomiden.domain.model.QuizScoreEntity

class GetAllScoresUseCaseTest{

    private lateinit var fakeQuizScoreboardRepositoryImpl: FakeQuizScoreboardRepositoryImpl
    private lateinit var getAllScoresUseCase: GetAllScoresUseCase


    @Before
    fun setUp(){
        fakeQuizScoreboardRepositoryImpl = FakeQuizScoreboardRepositoryImpl()
        getAllScoresUseCase = GetAllScoresUseCase(fakeQuizScoreboardRepositoryImpl)

        runBlocking {

            fakeQuizScoreboardRepositoryImpl.instertNewScore(QuizScoreEntity(1, "20/06/2023", "00:09", 1))
            fakeQuizScoreboardRepositoryImpl.instertNewScore(QuizScoreEntity(2, "20/06/2023", "00:21", 2))
            fakeQuizScoreboardRepositoryImpl.instertNewScore(QuizScoreEntity(3, "21/06/2023", "00:03", 0))
            fakeQuizScoreboardRepositoryImpl.instertNewScore(QuizScoreEntity(4, "21/06/2023", "00:54", 5))
        }
    }

    @Test
    fun `Get all scores, reversed`()= runTest{
        val expectedListSize = 4
        val expectedFirst = QuizScoreEntity(4, "21/06/2023", "00:54", 5)

        val actualListResult = getAllScoresUseCase().first()

        assertEquals(expectedListSize, actualListResult.size)
        assertEquals(expectedFirst, actualListResult[0])
    }
}
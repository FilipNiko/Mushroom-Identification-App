package rs.ac.metropolitan.mushroomiden.domain.use_case.quiz.scoreboard

import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import rs.ac.metropolitan.mushroomiden.data.repository.FakeQuizScoreboardRepositoryImpl
import rs.ac.metropolitan.mushroomiden.domain.model.QuizScoreEntity

class InsertNewScoreUseCaseTest{


    private lateinit var insertNewScoreUseCase: InsertNewScoreUseCase
    private lateinit var fakeQuizScoreboardRepositoryImpl: FakeQuizScoreboardRepositoryImpl


    @Before
    fun setUp(){

        fakeQuizScoreboardRepositoryImpl = FakeQuizScoreboardRepositoryImpl()

        insertNewScoreUseCase = InsertNewScoreUseCase(fakeQuizScoreboardRepositoryImpl)

    }


    @Test
    fun `Insert new completed score test`() = runTest{
        val expectedSize = 1
        val expectedFirst = QuizScoreEntity(1, "20/06/2023", "00:09", 1)

        insertNewScoreUseCase(QuizScoreEntity(1, "20/06/2023", "00:09", 1))
        val actualResultList = fakeQuizScoreboardRepositoryImpl.getAllScores().first()

        assertEquals(expectedSize, actualResultList.size)
        assertEquals(expectedFirst, actualResultList[0])
    }

}
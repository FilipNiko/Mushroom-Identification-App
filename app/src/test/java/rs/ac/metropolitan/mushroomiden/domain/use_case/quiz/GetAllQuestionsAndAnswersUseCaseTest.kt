package rs.ac.metropolitan.mushroomiden.domain.use_case.quiz

import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import rs.ac.metropolitan.mushroomiden.data.repository.FakeQuestionsAndAnswersRepositoryImpl

class GetAllQuestionsAndAnswersUseCaseTest{

    private lateinit var getAllQuestionsAndAnswersUseCase: GetAllQuestionsAndAnswersUseCase
    private lateinit var  fakeQuestionsAndAnswersRepositoryImpl: FakeQuestionsAndAnswersRepositoryImpl


    @Before
    fun setUp(){
        fakeQuestionsAndAnswersRepositoryImpl = FakeQuestionsAndAnswersRepositoryImpl()
        getAllQuestionsAndAnswersUseCase = GetAllQuestionsAndAnswersUseCase(fakeQuestionsAndAnswersRepositoryImpl)
    }

    @Test
    fun `Get all questions and answers test`() = runTest {

        val expectedSize = 1

        val actualListResult = getAllQuestionsAndAnswersUseCase().first()

        assertEquals(expectedSize, actualListResult.size)
    }
}
package rs.ac.metropolitan.mushroomiden.domain.use_case.completed_identifications

import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import rs.ac.metropolitan.mushroomiden.data.repository.FakeCompletedIdentificationRepositoryImpl
import rs.ac.metropolitan.mushroomiden.domain.model.CompletedIdentificationEntity


class GetAllCompletedIdentificationsUseCaseTest{


    private lateinit var getAllCompletedIdentificationsUseCase: GetAllCompletedIdentificationsUseCase
    private lateinit var fakeCompletedIdentificationRepository : FakeCompletedIdentificationRepositoryImpl

    @Before
    fun setUp(){
        fakeCompletedIdentificationRepository = FakeCompletedIdentificationRepositoryImpl()

        getAllCompletedIdentificationsUseCase = GetAllCompletedIdentificationsUseCase(fakeCompletedIdentificationRepository)



        runBlocking {
            fakeCompletedIdentificationRepository.upsertCompletedIdentification(CompletedIdentificationEntity("a123", "19/06/2023", 11.11, 22.22, "url", "Belgrade", "Serbia", "Europe"))
            fakeCompletedIdentificationRepository.upsertCompletedIdentification(CompletedIdentificationEntity("b234", "20/06/2023", 11.11, 22.22, "url", "Belgrade", "Serbia", "Europe"))
            fakeCompletedIdentificationRepository.upsertCompletedIdentification(CompletedIdentificationEntity("c456", "20/06/2023", 11.11, 22.22, "url", "Belgrade", "Serbia", "Europe"))
            fakeCompletedIdentificationRepository.upsertCompletedIdentification(CompletedIdentificationEntity("d567", "21/06/2023", 11.11, 22.22, "url", "Belgrade", "Serbia", "Europe"))
            fakeCompletedIdentificationRepository.upsertCompletedIdentification(CompletedIdentificationEntity("e678", "22/06/2023", 11.11, 22.22, "url", "Belgrade", "Serbia", "Europe"))
        }
    }

    @Test
    fun `Get all completed identifications, reversed test`() = runTest{
        val expectedSize = 5
        val expectedFirst = CompletedIdentificationEntity("e678", "22/06/2023", 11.11, 22.22, "url", "Belgrade", "Serbia", "Europe")

        val completedIdentificationsResult = getAllCompletedIdentificationsUseCase().first()

        assertEquals(expectedSize, completedIdentificationsResult.size)
        assertEquals(expectedFirst, completedIdentificationsResult[0])
    }

}
package rs.ac.metropolitan.mushroomiden.domain.use_case.completed_identifications

import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import rs.ac.metropolitan.mushroomiden.data.repository.FakeCompletedIdentificationRepositoryImpl
import rs.ac.metropolitan.mushroomiden.domain.model.CompletedIdentificationEntity


class AddCompletedIdentificationUseCaseTest{

    private lateinit var addCompletedIdentificationUseCase: AddCompletedIdentificationUseCase
    private lateinit var fakeCompletedIdentificationRepository : FakeCompletedIdentificationRepositoryImpl


    @Before
    fun setUp(){

        fakeCompletedIdentificationRepository = FakeCompletedIdentificationRepositoryImpl()

        addCompletedIdentificationUseCase = AddCompletedIdentificationUseCase(fakeCompletedIdentificationRepository)

    }


    @Test
    fun `Insert new completed identification test`() = runTest{
        val expectedSize = 1
        val expectedFirst = CompletedIdentificationEntity("e678", "22/06/2023", 11.11, 22.22, "url", "Belgrade", "Serbia", "Europe")

        addCompletedIdentificationUseCase(CompletedIdentificationEntity("e678", "22/06/2023", 11.11, 22.22, "url", "Belgrade", "Serbia", "Europe"))
        val actualResultList = fakeCompletedIdentificationRepository.getAllCompletedIdentifications().first()

        assertEquals(expectedSize, actualResultList.size)
        assertEquals(expectedFirst, actualResultList[0])
    }



}
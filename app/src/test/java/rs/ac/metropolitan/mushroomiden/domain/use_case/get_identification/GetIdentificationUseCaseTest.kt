package rs.ac.metropolitan.mushroomiden.domain.use_case.get_identification

import kotlinx.coroutines.flow.dropWhile
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Assert.fail
import org.junit.Before
import org.junit.Test
import rs.ac.metropolitan.mushroomiden.common.Resource
import rs.ac.metropolitan.mushroomiden.data.remote.mushroom_dentification.dto.Classification
import rs.ac.metropolitan.mushroomiden.data.remote.mushroom_dentification.dto.IdentificationRequest
import rs.ac.metropolitan.mushroomiden.data.remote.mushroom_dentification.dto.IdentificationResultDto
import rs.ac.metropolitan.mushroomiden.data.remote.mushroom_dentification.dto.Input
import rs.ac.metropolitan.mushroomiden.data.remote.mushroom_dentification.dto.Result
import rs.ac.metropolitan.mushroomiden.data.remote.mushroom_dentification.dto.Suggestion
import rs.ac.metropolitan.mushroomiden.data.remote.mushroom_dentification.dto.toIdentificationResult
import rs.ac.metropolitan.mushroomiden.data.repository.FakeMushroomIdentificationRepositoryImpl

class GetIdentificationUseCaseTest{


    private lateinit var getIdentificationUseCase: GetIdentificationUseCase
    private lateinit var fakeMushroomIdentificationRepositoryImpl: FakeMushroomIdentificationRepositoryImpl


    @Before
    fun setUp(){
        fakeMushroomIdentificationRepositoryImpl = FakeMushroomIdentificationRepositoryImpl()
        getIdentificationUseCase = GetIdentificationUseCase(fakeMushroomIdentificationRepositoryImpl)
    }

    @Test
    fun `Get Mushroom Identification test`() = runTest{
        val expectedResult = IdentificationResultDto(
            access_token = "acs1",
            completed = 0.0,
            created = 0.0,
            custom_id = "any",
            input = Input(listOf(), 0.0,0.0,true),
            model_version = "modelVersion",
            result = Result(classification = Classification(listOf(Suggestion(id="id", name = "name")))),
            sla_compliant_client = false,
            sla_compliant_system = false,
            status = "completed"
        ).toIdentificationResult()


        val actualResult = getIdentificationUseCase(IdentificationRequest(listOf(), 0.0, 0.0, true)).dropWhile { it is Resource.Loading }.first()

        if (actualResult is Resource.Success) {
            assertEquals(expectedResult, actualResult.data)
        } else {
            fail("Expected success result, but got: ${actualResult.javaClass.simpleName}")
        }


    }

}
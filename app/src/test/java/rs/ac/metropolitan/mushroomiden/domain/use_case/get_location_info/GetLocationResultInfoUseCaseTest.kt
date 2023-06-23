package rs.ac.metropolitan.mushroomiden.domain.use_case.get_location_info


import kotlinx.coroutines.flow.dropWhile
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Assert.fail
import org.junit.Before
import org.junit.Test
import rs.ac.metropolitan.mushroomiden.common.Resource
import rs.ac.metropolitan.mushroomiden.data.remote.reverse_geocoding.dto.Administrative
import rs.ac.metropolitan.mushroomiden.data.remote.reverse_geocoding.dto.LocalityInfo
import rs.ac.metropolitan.mushroomiden.data.remote.reverse_geocoding.dto.LocationResultInfoDto
import rs.ac.metropolitan.mushroomiden.data.remote.reverse_geocoding.dto.toLocationResultInfo
import rs.ac.metropolitan.mushroomiden.data.repository.FakeReverseGeocodingRepositoryImpl

class GetLocationResultInfoUseCaseTest{

    private lateinit var getLocationResultInfoUseCase: GetLocationResultInfoUseCase
    private lateinit var fakeReverseGeocodingRepositoryImpl: FakeReverseGeocodingRepositoryImpl


    @Before
    fun setUp(){
        fakeReverseGeocodingRepositoryImpl = FakeReverseGeocodingRepositoryImpl()
        getLocationResultInfoUseCase = GetLocationResultInfoUseCase(fakeReverseGeocodingRepositoryImpl)
    }

    @Test
    fun `Get Location Info test`() = runTest{
        val expectedResult = LocationResultInfoDto(
            "Belgrade",
            "Europe",
            "EU",
            "RS",
            "Serbia",
            11.11,
            "s",
            LocalityInfo(
                false,
                listOf(
                    Administrative(
                        1,
                        "desc",
                        1,
                        "isoCode",
                        "name",
                        1,
                        "wikidataId")
                ),
                listOf(
                )
            ),
            "localityLanguageRequested",
            22.22,
            "lookupScore",
            "plusCode",
            "postCode",
            "principalSubdiviosion",
            "code").toLocationResultInfo()


        val actualResult = getLocationResultInfoUseCase(11.11, 22.22).dropWhile { it is Resource.Loading }.first()

        if (actualResult is Resource.Success) {
            assertEquals(expectedResult, actualResult.data)
        } else {
            fail("Expected success result, but got: ${actualResult.javaClass.simpleName}")
        }


    }
}
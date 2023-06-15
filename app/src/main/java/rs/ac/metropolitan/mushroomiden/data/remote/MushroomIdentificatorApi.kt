package rs.ac.metropolitan.mushroomiden.data.remote

import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST
import rs.ac.metropolitan.mushroomiden.common.Constants
import rs.ac.metropolitan.mushroomiden.data.remote.dto.IdentificationRequest
import rs.ac.metropolitan.mushroomiden.data.remote.dto.IdentificationResultDto

interface MushroomIdentificatorApi {

    @Headers(
        "Content-Type: application/json",
        "Api-Key:GTpFI8Ds85GK1NaI6sH0vT8p2WRHr4kdrpa5vqrRShm2KAZIVf"
    )
    @POST(Constants.MOCK_DETAILS_URL)
    suspend fun getIdentification(@Body identificationRequest:IdentificationRequest): IdentificationResultDto

}
package rs.ac.metropolitan.mushroomiden.data.remote.mushroom_dentification

import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.POST
import retrofit2.http.Path
import rs.ac.metropolitan.mushroomiden.common.Constants
import rs.ac.metropolitan.mushroomiden.data.remote.mushroom_dentification.dto.IdentificationRequest
import rs.ac.metropolitan.mushroomiden.data.remote.mushroom_dentification.dto.IdentificationResultDto

interface MushroomIdentificatorApi {

    @Headers(
        "Content-Type: application/json",
        "Api-Key:/"
    )
    @POST(Constants.DETAILS_IDENTIFICATION_URL)
    suspend fun getIdentification(@Body identificationRequest: IdentificationRequest): IdentificationResultDto


    @Headers(
        "Content-Type: application/json",
        "Api-Key:/"
    )
    @GET("identification/{accessToken}" + Constants.DETAILS_RETRIEVE_IDENTIFICATION_URL)
    suspend fun retrieveIdentification(@Path("accessToken") accessToken: String): IdentificationResultDto

}
package rs.ac.metropolitan.mushroomiden.domain.use_case.get_identification

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import rs.ac.metropolitan.mushroomiden.common.Resource
import rs.ac.metropolitan.mushroomiden.data.remote.mushroom_dentification.dto.toIdentificationResult
import rs.ac.metropolitan.mushroomiden.domain.model.IdentificationResult
import rs.ac.metropolitan.mushroomiden.domain.repository.MushroomIdentificationRepository
import java.io.IOException
import javax.inject.Inject


class RetrieveIdentificationUseCase @Inject constructor(private val repository: MushroomIdentificationRepository){

    operator fun invoke(accessToken: String): Flow<Resource<IdentificationResult>> = flow {
        try {
            emit(Resource.Loading<IdentificationResult>())
            val result = repository.retrieveIdentification(accessToken).toIdentificationResult()
            emit(Resource.Success<IdentificationResult>(result))
        } catch(e: HttpException) {
            emit(Resource.Error<IdentificationResult>(e.localizedMessage ?: "An unexpected error occured"))
        } catch(e: IOException) {
            emit(Resource.Error<IdentificationResult>("Couldn't reach server. Check your internet connection."))
        }
    }
}
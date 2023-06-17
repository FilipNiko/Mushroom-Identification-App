package rs.ac.metropolitan.mushroomiden.domain.use_case.get_location_info

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import rs.ac.metropolitan.mushroomiden.common.Resource
import rs.ac.metropolitan.mushroomiden.data.remote.reverse_geocoding.dto.toLocationResultInfo
import rs.ac.metropolitan.mushroomiden.domain.model.LocationResultInfo
import rs.ac.metropolitan.mushroomiden.domain.repository.ReverseGeocodingRepository
import java.io.IOException
import javax.inject.Inject


class GetLocationResultInfoUseCase @Inject constructor(
    private val repository: ReverseGeocodingRepository
) {

    operator fun invoke(latitude: Double, longitude: Double): Flow<Resource<LocationResultInfo>> = flow {
            try {
                emit(Resource.Loading<LocationResultInfo>())
                val result = repository.getLocationResultInfo(latitude, longitude).toLocationResultInfo()
                emit(Resource.Success<LocationResultInfo>(result))
            } catch (e: HttpException) {
                emit(Resource.Error<LocationResultInfo>(e.localizedMessage ?: "An unexpected error occured"))
            } catch (e: IOException) {
                emit(Resource.Error<LocationResultInfo>("Couldn't reach server. Check your internet connection."))
            }
        }
}
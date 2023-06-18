package rs.ac.metropolitan.mushroomiden.data.repository

import rs.ac.metropolitan.mushroomiden.data.remote.mushroom_dentification.MushroomIdentificatorApi
import rs.ac.metropolitan.mushroomiden.data.remote.mushroom_dentification.dto.IdentificationRequest
import rs.ac.metropolitan.mushroomiden.data.remote.mushroom_dentification.dto.IdentificationResultDto
import rs.ac.metropolitan.mushroomiden.domain.repository.MushroomIdentificationRepository
import javax.inject.Inject

class MushromIdentificationRepositoryImpl @Inject constructor(private val api: MushroomIdentificatorApi) : MushroomIdentificationRepository{

    override suspend fun getIdentification(identificationRequest: IdentificationRequest): IdentificationResultDto {
        return api.getIdentification(identificationRequest)
    }

    override suspend fun retrieveIdentification(accessToken: String): IdentificationResultDto {
        return api.retrieveIdentification(accessToken)
    }
}
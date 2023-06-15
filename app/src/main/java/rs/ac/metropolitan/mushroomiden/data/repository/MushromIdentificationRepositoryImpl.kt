package rs.ac.metropolitan.mushroomiden.data.repository

import rs.ac.metropolitan.mushroomiden.data.remote.MushroomIdentificatorApi
import rs.ac.metropolitan.mushroomiden.data.remote.dto.IdentificationRequest
import rs.ac.metropolitan.mushroomiden.data.remote.dto.IdentificationResultDto
import rs.ac.metropolitan.mushroomiden.domain.repository.MushroomIdentificationRepository
import javax.inject.Inject

class MushromIdentificationRepositoryImpl @Inject constructor(private val api:MushroomIdentificatorApi) : MushroomIdentificationRepository{

    override suspend fun getIdentification(identificationRequest: IdentificationRequest): IdentificationResultDto {
        return api.getIdentification(identificationRequest)
    }
}
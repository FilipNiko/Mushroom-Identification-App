package rs.ac.metropolitan.mushroomiden.domain.repository


import rs.ac.metropolitan.mushroomiden.data.remote.dto.IdentificationRequest
import rs.ac.metropolitan.mushroomiden.data.remote.dto.IdentificationResultDto

interface MushroomIdentificationRepository {


    suspend fun getIdentification(identificationRequest: IdentificationRequest): IdentificationResultDto
}
package rs.ac.metropolitan.mushroomiden.data.repository

import rs.ac.metropolitan.mushroomiden.data.remote.mushroom_dentification.dto.Classification
import rs.ac.metropolitan.mushroomiden.data.remote.mushroom_dentification.dto.IdentificationRequest
import rs.ac.metropolitan.mushroomiden.data.remote.mushroom_dentification.dto.IdentificationResultDto
import rs.ac.metropolitan.mushroomiden.data.remote.mushroom_dentification.dto.Input
import rs.ac.metropolitan.mushroomiden.data.remote.mushroom_dentification.dto.Result
import rs.ac.metropolitan.mushroomiden.data.remote.mushroom_dentification.dto.Suggestion
import rs.ac.metropolitan.mushroomiden.domain.repository.MushroomIdentificationRepository


class FakeMushroomIdentificationRepositoryImpl : MushroomIdentificationRepository{

    private val identificationResultDto:IdentificationResultDto = IdentificationResultDto(
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
    )

    override suspend fun getIdentification(identificationRequest: IdentificationRequest): IdentificationResultDto {
        return identificationResultDto
    }

    override suspend fun retrieveIdentification(accessToken: String): IdentificationResultDto {
        return identificationResultDto
    }

}
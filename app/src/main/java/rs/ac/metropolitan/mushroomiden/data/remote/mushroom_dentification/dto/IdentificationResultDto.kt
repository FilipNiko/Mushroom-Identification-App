package rs.ac.metropolitan.mushroomiden.data.remote.mushroom_dentification.dto

import rs.ac.metropolitan.mushroomiden.domain.model.IdentificationResult

data class IdentificationResultDto(
    val access_token: String,
    val completed: Double,
    val created: Double,
    val custom_id: Any,
    val input: Input,
    val model_version: String,
    val result: Result,
    val sla_compliant_client: Boolean,
    val sla_compliant_system: Boolean,
    val status: String
)

fun IdentificationResultDto.toIdentificationResult(): IdentificationResult {
    return IdentificationResult(
        access_token=access_token,
        input=input,
        result=result,
        status=status
    )
}
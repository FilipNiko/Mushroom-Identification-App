package rs.ac.metropolitan.mushroomiden.domain.model

import rs.ac.metropolitan.mushroomiden.data.remote.mushroom_dentification.dto.Input
import rs.ac.metropolitan.mushroomiden.data.remote.mushroom_dentification.dto.Result

data class IdentificationResult(
    val access_token: String,
    val input: Input,
    val result: Result,
    val status: String
)

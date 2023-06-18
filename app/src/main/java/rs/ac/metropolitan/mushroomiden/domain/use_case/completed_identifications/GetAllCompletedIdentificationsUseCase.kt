package rs.ac.metropolitan.mushroomiden.domain.use_case.completed_identifications

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import retrofit2.HttpException
import rs.ac.metropolitan.mushroomiden.common.Resource
import rs.ac.metropolitan.mushroomiden.domain.model.CompletedIdentificationEntity
import rs.ac.metropolitan.mushroomiden.domain.repository.CompletedIdentificationsRepository
import java.io.IOException
import javax.inject.Inject


class GetAllCompletedIdentificationsUseCase @Inject constructor (private val repository: CompletedIdentificationsRepository) {

     operator fun invoke() : Flow<List<CompletedIdentificationEntity>> {
        return repository.getAllCompletedIdentifications().map {
            it.reversed()
        }
    }
}
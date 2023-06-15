package rs.ac.metropolitan.mushroomiden.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import rs.ac.metropolitan.mushroomiden.common.Constants
import rs.ac.metropolitan.mushroomiden.data.remote.MushroomIdentificatorApi
import rs.ac.metropolitan.mushroomiden.data.repository.MushromIdentificationRepositoryImpl
import rs.ac.metropolitan.mushroomiden.domain.repository.MushroomIdentificationRepository
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {


    @Provides
    @Singleton
    fun provideMushroomIdentificationApi(): MushroomIdentificatorApi {
        return Retrofit.Builder()
            .baseUrl(Constants.MOCK_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(MushroomIdentificatorApi::class.java)
    }

    @Provides
    @Singleton
    fun provideMushromIdentificationRepository(api: MushroomIdentificatorApi): MushroomIdentificationRepository {
        return MushromIdentificationRepositoryImpl(api)
    }
}
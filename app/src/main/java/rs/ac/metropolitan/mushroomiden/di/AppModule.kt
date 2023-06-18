package rs.ac.metropolitan.mushroomiden.di

import android.app.Application
import androidx.room.Room
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import rs.ac.metropolitan.mushroomiden.common.Constants
import rs.ac.metropolitan.mushroomiden.data.local_data_source.CompletedIdentificationDatabase
import rs.ac.metropolitan.mushroomiden.data.location.DefaultLocationTracker
import rs.ac.metropolitan.mushroomiden.data.remote.mushroom_dentification.MushroomIdentificatorApi
import rs.ac.metropolitan.mushroomiden.data.remote.reverse_geocoding.ReverseGeocodingApi
import rs.ac.metropolitan.mushroomiden.data.repository.CompletedIdentificationRepositoryImpl
import rs.ac.metropolitan.mushroomiden.data.repository.MushromIdentificationRepositoryImpl
import rs.ac.metropolitan.mushroomiden.data.repository.ReverseGeocodingRepisotoryImpl
import rs.ac.metropolitan.mushroomiden.domain.location.LocationTracker
import rs.ac.metropolitan.mushroomiden.domain.repository.CompletedIdentificationsRepository
import rs.ac.metropolitan.mushroomiden.domain.repository.MushroomIdentificationRepository
import rs.ac.metropolitan.mushroomiden.domain.repository.ReverseGeocodingRepository
import rs.ac.metropolitan.mushroomiden.domain.use_case.completed_identifications.AddCompletedIdentificationUseCase
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {


    @Provides
    @Singleton
    fun provideMushroomIdentificationApi(): MushroomIdentificatorApi {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_IDENTIFICATION_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(MushroomIdentificatorApi::class.java)
    }

    @Provides
    @Singleton
    fun provideMushromIdentificationRepository(api: MushroomIdentificatorApi): MushroomIdentificationRepository {
        return MushromIdentificationRepositoryImpl(api)
    }


    @Provides
    @Singleton
    fun provideReverseGeocodingApi(): ReverseGeocodingApi {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_GEOCODING_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ReverseGeocodingApi::class.java)
    }

    @Provides
    @Singleton
    fun provideReverseGeocodingRepository(api: ReverseGeocodingApi): ReverseGeocodingRepository {
        return ReverseGeocodingRepisotoryImpl(api)
    }


    @Provides
    @Singleton
    fun provideCompletedIdentificationsDatabase(app: Application): CompletedIdentificationDatabase {
        return Room.databaseBuilder(
            app,
            CompletedIdentificationDatabase::class.java,
            CompletedIdentificationDatabase.DATABASE_NAME
        ).build()
    }

    @Provides
    @Singleton
    fun provideCompletedIdentificationRepository(db: CompletedIdentificationDatabase): CompletedIdentificationsRepository {
        return CompletedIdentificationRepositoryImpl(db.completedIdentificationDao)
    }




    @Provides
    @Singleton
    fun providesFusedLocationProviderClient(
        application: Application
    ): FusedLocationProviderClient =
        LocationServices.getFusedLocationProviderClient(application)

    @Provides
    @Singleton
    fun providesLocationTracker(
        fusedLocationProviderClient: FusedLocationProviderClient,
        application: Application
    ): LocationTracker = DefaultLocationTracker(
        fusedLocationProviderClient = fusedLocationProviderClient,
        application = application
    )






}
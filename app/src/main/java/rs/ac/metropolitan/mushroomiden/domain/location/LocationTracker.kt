package rs.ac.metropolitan.mushroomiden.domain.location

import android.location.Location

interface LocationTracker {
    suspend fun getCurrentLocation(): Location?
}
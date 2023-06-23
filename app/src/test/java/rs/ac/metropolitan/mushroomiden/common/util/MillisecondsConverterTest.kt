package rs.ac.metropolitan.mushroomiden.common.util

import org.junit.Assert.assertEquals
import org.junit.Test
import rs.ac.metropolitan.mushroomiden.common.util.MillisecondsConverter.millisecondsToMinutesAndSecondsString

class MillisecondsConverterTest{


    @Test
    fun `Test milliseconds converter with 0 value`(){

        val expectedResult = "00:00"
        val actualResult = millisecondsToMinutesAndSecondsString(0L)
        assertEquals(expectedResult,actualResult)

    }

    @Test
    fun `Test milliseconds converter with 11000 value`(){

        val expectedResult = "00:11"
        val actualResult = millisecondsToMinutesAndSecondsString(11000L)
        assertEquals(expectedResult,actualResult)

    }

}



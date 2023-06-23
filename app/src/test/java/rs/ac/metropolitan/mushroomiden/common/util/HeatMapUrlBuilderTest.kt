package rs.ac.metropolitan.mushroomiden.common.util

import org.junit.Assert.assertEquals
import org.junit.Test
import rs.ac.metropolitan.mushroomiden.common.util.HeatMapUrlBuilder.getUrlForLeftHeatImage
import rs.ac.metropolitan.mushroomiden.common.util.HeatMapUrlBuilder.getUrlForRightHeatImage

class HeatMapUrlBuilderTest {

    @Test
    fun `Left image url builder test`() {
        val input = 123
        val expectedResul = "https://api.gbif.org/v2/map/occurrence/density/0/0/0@1x.png?srs=EPSG:4326&style=purpleHeat.point&taxonKey=${123}"

        val actualResult = getUrlForLeftHeatImage(input)

        assertEquals(expectedResul,actualResult)


    }

    @Test
    fun `Right image url builder test`() {

        val input = 123
        val expectedResul = "https://api.gbif.org/v2/map/occurrence/density/0/1/0@1x.png?srs=EPSG:4326&style=purpleHeat.point&taxonKey=${123}"

        val actualResult = getUrlForRightHeatImage(input)

        assertEquals(expectedResul,actualResult)

    }
}
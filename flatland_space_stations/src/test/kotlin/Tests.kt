import hernanbosqued.samples.flatlandSpaceStations
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class Tests {

    @Before
    fun before() {
        println("BEFORE")
    }

    @After
    fun after() {
        println("AFTER")
    }

    @Test
    fun test1() {
        val distance = flatlandSpaceStations(5, arrayOf(0, 4))
        Assert.assertEquals(2,distance)
    }

    @Test
    fun test2() {
        val distance = flatlandSpaceStations(3, arrayOf(1))
        Assert.assertEquals(1,distance)
    }


    @Test
    fun test3() {
        val distance = flatlandSpaceStations(6, arrayOf(0,1,2,3,4,5))
        Assert.assertEquals(0,distance)
    }
}
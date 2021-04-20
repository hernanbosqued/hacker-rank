import hernanbosqued.samples.timeConversion
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
        val time = timeConversion("04:35:10PM")
        Assert.assertEquals("16:35:10", time)
    }
}
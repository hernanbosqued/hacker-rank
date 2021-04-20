import hernanbosqued.samples.queensAttack
import org.junit.After
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
        queensAttack(4, 0, 0, 4, emptyArray())
    }
}
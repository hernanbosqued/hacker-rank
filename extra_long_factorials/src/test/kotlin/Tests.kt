import java.math.BigInteger
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
    fun factorial0() {
        Assert.assertEquals(BigInteger("1"),extraLongFactorials(0))
    }

    @Test
    fun factorial1() {
        Assert.assertEquals(BigInteger("1"),extraLongFactorials(1))
    }

    @Test
    fun factorial10() {
        Assert.assertEquals(BigInteger("3628800"),extraLongFactorials(10))
    }

    @Test
    fun factorial25() {
        Assert.assertEquals(BigInteger("15511210043330985984000000"),extraLongFactorials(25))
    }

    @Test
    fun factorial30() {
        Assert.assertEquals(BigInteger("265252859812191058636308480000000"),extraLongFactorials(30))
    }
}
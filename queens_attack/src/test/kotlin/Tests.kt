import hernanbosqued.samples.queensAttack
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
    fun `4x4, queen in (4,4) and no obstacles`() {
        val distance = queensAttack(4, 0, 4, 4, emptyArray())
        Assert.assertEquals(9, distance)
    }

    @Test
    fun `4x4, queen in (4,4) and one obstacle in (1,1)`() {
        val distance = queensAttack(4, 1, 4, 4, arrayOf(arrayOf(1, 1)))
        Assert.assertEquals(8, distance)
    }

    @Test
    fun `5x5, queen in (4,3) and three obstacles in (1,1)`() {
        val distance = queensAttack(5, 3, 4, 3, arrayOf(arrayOf(5, 5), arrayOf(4, 2), arrayOf(2, 3)))
        Assert.assertEquals(10, distance)
    }

    @Test
    fun `8x8, queen in (1,1) and no obstacles`() {
        val distance = queensAttack(8, 0, 1, 1, emptyArray())
        Assert.assertEquals(21, distance)
    }

    @Test
    fun `100000x100000, queen in (4187,5068) and no obstacles`() {
        val distance = queensAttack(100000, 0, 4187, 5068, emptyArray())
        Assert.assertEquals(308369, distance)
    }
}
import hernanbosqued.samples.biggerIsGreater
import java.io.File
import java.util.*
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
    fun a() {
        Assert.assertEquals("no answer", biggerIsGreater("a"))
    }

    @Test
    fun dkhc() {
        Assert.assertEquals("hcdk", biggerIsGreater("dkhc"))
    }

    @Test
    fun lmno() {
        Assert.assertEquals("lmon", biggerIsGreater("lmno"))
    }

    @Test
    fun dcba() {
        Assert.assertEquals("no answer", biggerIsGreater("dcba"))
    }

    @Test
    fun fedcbabcd() {
        Assert.assertEquals("fedcbabdc", biggerIsGreater("fedcbabcd"))
    }

    @Test
    fun abdc() {
        Assert.assertEquals("acbd", biggerIsGreater("abdc"))
    }

    @Test
    fun hefg() {
        Assert.assertEquals("hegf", biggerIsGreater("hefg"))
    }

    @Test
    fun dhkc() {
        Assert.assertEquals("dhkc", biggerIsGreater("dhck"))
    }

    @Test
    fun aaaaazbaaaa() {
        Assert.assertEquals("aaaabaaaaaz", biggerIsGreater("aaaaazbaaaa"))
    }

    @Test
    fun fromFile() {
        val inputFile = File("./src/resources/input.txt")
        val scannerInput = Scanner(inputFile)
        val size = scannerInput.nextInt()

        val outputFile = File("./src/resources/output.txt")
        val scannerOutput = Scanner(outputFile)

        for (item in 1..size) {
            print(item)
            val input = scannerInput.next()
            val expected = scannerOutput.nextLine()

            val output = biggerIsGreater(input)

            Assert.assertEquals(expected, output)
            println(" OK")
            println(output)
        }
    }

}
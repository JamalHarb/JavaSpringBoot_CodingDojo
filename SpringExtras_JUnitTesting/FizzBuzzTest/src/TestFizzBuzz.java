import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestFizzBuzz {
	
	public FizzBuzz fb;
	
	@BeforeEach
	void setUp() throws Exception {
		fb = new FizzBuzz();
	}

	@Test
	void test() {
		assertNotNull(fb);
	}
	
	@Test
    public void testForFizz() {
        String result = fb.fizzBuzz(3);
        assertTrue(result.equals("fizz"));
    }
    
    @Test
    public void testForBuzz() {
        String result = fb.fizzBuzz(5);
        assertTrue(result.equals("buzz"));
    }
    
    @Test
    public void testForFizzBuzz() {
        String expected = "fizzbuzz";
        String actual = fb.fizzBuzz(30);
        assertEquals(expected, actual);
    }

}

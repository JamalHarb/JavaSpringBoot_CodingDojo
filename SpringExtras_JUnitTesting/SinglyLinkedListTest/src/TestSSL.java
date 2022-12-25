import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestSSL {
	public SSL sll;
	@BeforeEach
	void setUp() throws Exception {
		sll = new SSL();
	}

    @Test
    public void testHeadForNull() {
        assertNull(sll.head);
    }
    
    @Test
    public void testHeadForNode() {
        sll.add(8);
        assertNotNull(sll.head);
    }
    
    @Test
    public void testHeadNextVal() {
        sll.add(5);
        sll.add(10);
        assertTrue(sll.head.next.value == 10);
    }
    
    @Test
    public void testHeadAfterRemove() {
        sll.add(10);
        sll.removeFront();
        // write test first, then write code to pass the test.
        assertNull(sll.head);
    }
}

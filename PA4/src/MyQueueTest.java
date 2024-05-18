import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.NoSuchElementException;

class MyQueueTest {

    @Test
    public void sizeTest() {
        MyQueue<Integer> sizequeue = new MyQueue<>();
        assertEquals(0, sizequeue.size());
        sizequeue.enqueue(1);
        sizequeue.enqueue(2);
        sizequeue.enqueue(3);
        assertEquals(3, sizequeue.size());
        sizequeue.dequeue();
        assertEquals(2, sizequeue.size());
    }

    @Test
    public void emptyTest() {
        MyQueue<Integer> emptyqueue = new MyQueue<>();
        assertTrue(emptyqueue.isEmpty());
        emptyqueue.enqueue(5);
        assertFalse(emptyqueue.isEmpty());
        emptyqueue.dequeue();
        assertTrue(emptyqueue.isEmpty());
    }

    @Test
    public void enququeTest() {
        MyQueue<Integer> enqueuequeue = new MyQueue<>();
        enqueuequeue.enqueue(3);
        assertEquals(3, enqueuequeue.peek());
        enqueuequeue.enqueue(2);
        enqueuequeue.enqueue(1);
        assertEquals(3, enqueuequeue.size());
    }

    @Test
    public void peekTest() {
        MyQueue<Integer> peekqueue = new MyQueue<>();
        assertThrows(NoSuchElementException.class, () -> {
            peekqueue.peek();
        });
        peekqueue.enqueue(5);
        assertEquals(5, peekqueue.peek());
        peekqueue.enqueue(1);
        peekqueue.dequeue();
    }

    @Test
    public void dequeueTest() {
        MyQueue<Integer> dequeuequeue = new MyQueue<>();
        dequeuequeue.enqueue(5);
        dequeuequeue.enqueue(4);
        dequeuequeue.enqueue(3);
        dequeuequeue.enqueue(2);
        dequeuequeue.enqueue(1);
        assertEquals(5, dequeuequeue.dequeue());
        assertEquals(4, dequeuequeue.size());
        assertEquals(4, dequeuequeue.dequeue());
        dequeuequeue.dequeue();
        dequeuequeue.dequeue();
        assertEquals(1, dequeuequeue.size());
    }

}

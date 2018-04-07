import junit.framework.TestCase;
import java.util.Set;
import java.util.TreeSet;

public class RandomizedQueueTest extends TestCase {

    public void testIsEmpty() {
        RandomizedQueue<Integer> q = new RandomizedQueue<>();
        assertTrue(q.isEmpty());
    }

    public void testIsEmptyAfterRemove() {
        RandomizedQueue<Integer> q = new RandomizedQueue<>();
        assertTrue(q.isEmpty());
        q.enqueue(5);
        int r = q.dequeue();
        assertEquals(5, r);
        assertTrue(q.isEmpty());
    }

    public void testSize() {
        RandomizedQueue<Integer> q = new RandomizedQueue<>();
        assertEquals(0, q.size());
        q.enqueue(5);
        assertEquals(1, q.size());
        int r = q.dequeue();
        assertEquals(0, q.size());
    }

    public void testEnqueue() {
        RandomizedQueue<Integer> q = new RandomizedQueue<>();
        int count = 40;
        for (int i = 0; i < count; i++) {
            q.enqueue(i);
        }
        Set<Integer> elements = new TreeSet<Integer>();
        while(!q.isEmpty()) {
            int r = q.dequeue();
            elements.add(r);
        }
        for (int i = 0; i < count; i++) {
            assertTrue(elements.contains(i));
        }
        assertTrue(q.isEmpty());
    }

    public void testDequeue() {
        RandomizedQueue<Integer> q = new RandomizedQueue<>();
        int count = 50;
        for (int i = 0; i < count; i++) {
            q.enqueue(i);
        }
        Set<Integer> elements = new TreeSet<Integer>();
        while(!q.isEmpty()) {
            int r = q.dequeue();
            elements.add(r);
        }
        for (int i = 0; i < count; i++) {
            assertTrue(elements.contains(i));
        }
        assertTrue(q.isEmpty());
    }

    public void testSample() {
        RandomizedQueue<Integer> q = new RandomizedQueue<>();
        int count = 40;
        for (int i = 0; i < count; i++) {
            q.enqueue(i);
        }
        Set<Integer> elements = new TreeSet<Integer>();
        for (int i = 0; i < count; i++) {
            int r = q.sample();
            elements.add(r);
        }
    }

    public void testIterator() {
        RandomizedQueue<Integer> q = new RandomizedQueue<>();
        int count = 40;
        for (int i = 0; i < count; i++) {
            q.enqueue(i);
        }
        Set<Integer> elements = new TreeSet<Integer>();
        for(int e: q) {
            elements.add(e);
        }
        for (int i = 0; i < count; i++) {
            assertTrue(elements.contains(i));
        }
    }
}
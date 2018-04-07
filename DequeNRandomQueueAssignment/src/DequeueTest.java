import junit.framework.TestCase;

public class DequeueTest extends TestCase {

    public void testIterator() {
        Dequeue<Integer> d = new Dequeue<Integer>();
        d.addFirst(1);
        d.addFirst(2);
        d.addFirst(3);
        d.addFirst(4);
        d.addFirst(5);
        d.addLast(6);
        d.addLast(7);
        int sum = 0;
        for(Integer i: d) {
            sum += i;
        }
        assertEquals(28,sum);
    }

    public void testEmpyty() {
        Dequeue<Integer> d = new Dequeue<Integer>();
        assertEquals(0, d.size());
        assertEquals(true, d.isEmpty() );
    }

    public void testSize() {
        Dequeue<Integer> d = new Dequeue<Integer>();
        assertEquals(0, d.size());
        d.addFirst(8);
        assertEquals(1, d.size());
        d.addFirst(8);
        assertEquals(2, d.size());
        d.addFirst(9);
        assertEquals(3, d.size());
        d.removeFirst();
        assertEquals(2, d.size());
        d.removeFirst();
        assertEquals(1, d.size());
        d.removeLast();
        assertEquals(0, d.size());
    }

    public void testAddFirst() {
        Dequeue<Integer> d = new Dequeue<Integer>();
        assertEquals(0, d.size());
        assertEquals(true, d.isEmpty() );
        d.addFirst(8);
        assertEquals(false, d.isEmpty() );

    }

    public void testAddLast() {
        Dequeue<Integer> d = new Dequeue<Integer>();
        assertEquals(0, d.size());
        assertEquals(true, d.isEmpty() );
        d.addLast(8);
        assertEquals(false, d.isEmpty() );
    }

    public void testRemoveFirst() {
        Dequeue<Integer> d = new Dequeue<Integer>();
        assertEquals(0, d.size());
        assertEquals(true, d.isEmpty() );
        d.addFirst(8);
        assertEquals(false, d.isEmpty() );
        int r = d.removeFirst();
        assertEquals(8, r );
        assertEquals(true, d.isEmpty() );

        d.addFirst(1);
        d.addFirst(2);
        d.addFirst(3);
        d.addFirst(4);
        d.addFirst(5);
        r = d.removeFirst();
        assertEquals(5, r);
        r = d.removeFirst();
        assertEquals(4, r);
        r = d.removeFirst();
        assertEquals(3, r);
        r = d.removeFirst();
        assertEquals(2, r);
        r = d.removeFirst();
        assertEquals(1, r);
    }

    public void testRemoveLast() {
        Dequeue<Integer> d = new Dequeue<Integer>();
        assertEquals(0, d.size());
        assertEquals(true, d.isEmpty() );
        d.addFirst(8);
        assertEquals(false, d.isEmpty() );
        int r = d.removeLast();
        assertEquals(8, r );
        assertEquals(true, d.isEmpty() );

        d.addFirst(1);
        d.addFirst(2);
        d.addFirst(3);
        d.addFirst(4);
        d.addFirst(5);
        r = d.removeLast();
        assertEquals(1, r);
        r = d.removeLast();
        assertEquals(2, r);
        r = d.removeLast();
        assertEquals(3, r);
        r = d.removeLast();
        assertEquals(4, r);
        r = d.removeLast();
        assertEquals(5, r);
    }
}
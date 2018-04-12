import junit.framework.TestCase;

public class PointTest extends TestCase {

    public void testSlopeTo() {
        Point one = new Point(1,2);
        Point two = new Point(2,2);
        Point three = new Point(1,3);
        Point four = new Point(1,2);
        assertEquals(Double.POSITIVE_INFINITY, one.slopeTo(three));
        assertEquals(Double.NEGATIVE_INFINITY, one.slopeTo(four));
        assertEquals(0.0, one.slopeTo(two));
    }

    public void testCompareTo() {
    }

    public void testSlopeOrder() {
    }
}
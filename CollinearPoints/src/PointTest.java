import junit.framework.TestCase;
import java.util.Comparator;

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
        Point one = new Point(1,2);
        Point two = new Point(2,2);
        Point three = new Point(1,3);
        Point four = new Point(1,2);
        assertEquals(1, two.compareTo(one));
        assertEquals(-1, one.compareTo(two));
        assertEquals(0, one.compareTo(one));
        assertEquals(1, three.compareTo(four));
        assertEquals(-1, four.compareTo(three));
    }

    public void testSlopeOrder() {
        Point base = new Point(0,0);
        Point one = new Point(2,2);
        Point two = new Point(1,3);
        Point three = new Point(1,2);
        Point four = new Point(0, 0);
        Point five = new Point(0, 1);
        Point six = new Point(1, 0);
        Comparator<Point> comp = base.slopeOrder();
        assertEquals(1, comp.compare(two, one));
        assertEquals(-1, comp.compare(one, two));
        assertEquals(0, comp.compare(two, two));
        assertEquals(1, comp.compare(one, six));
        assertEquals(1, comp.compare(five, six));
        assertEquals(-1, comp.compare(four, five));
    }
}
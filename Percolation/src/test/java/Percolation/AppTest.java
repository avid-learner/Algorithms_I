package Percolation;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
        assertTrue( true );
    }
    
    public void testUnionFind()
    {
        UnionFind u = new UnionFind(10);
        u.union(1,2);
        assertTrue(u.find(1,2));
        assertFalse(u.find(1,3));
        u.union(3,4);
        u.union(5,6);
        u.union(7,8);
        u.union(8,2);
        u.union(9,1);
        assertTrue(u.find(1,7));
        assertTrue(u.find(9,7));
        assertTrue(u.find(8,1));
        assertTrue(u.find(5,6));
        assertFalse(u.find(1,5));
        assertFalse(u.find(4,5));
    }
    
    public void testPercolation()
    {
        Percolation p = new Percolation(20);
        assertTrue(p.isFull(1,1));
        assertTrue(p.isFull(10,10));
        assertFalse(p.percolates());
        p.open(18,18);
        
        for(int i = 1; i <= 20 ; i++)
        {
            p.open(i,2);
        }
        assertTrue(p.percolates());
        assertEquals("number of open sites", p.numberOfOpenSites(), 21);
        
        
    }
}

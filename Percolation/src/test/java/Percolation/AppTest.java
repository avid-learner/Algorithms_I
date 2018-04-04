package Percolation;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import java.util.concurrent.ThreadLocalRandom;

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
    
    
    private class SlowUF
    {
        private int size;
        private int[] store;
        public SlowUF(int n)
        {
            size = n;
            store = new int[n];
            for (int i = 0; i< n; i++)
            {
                store[i] = i;
            }
        }
        
        public boolean find(int x, int y)
        {
            return store[x] == store[y];
        }
        
        public void union(int x, int y)
        {
            int xcolor = store[x];
            int ycolor = store[y];
            for(int i = 0; i < size; i++)
            {
                if(store[i] == ycolor) {
                    store[i] = xcolor;
                }
            }
        }

    }
    
    public void testUFComprehensive()
    {
        int numtests = 1000;
        for(int testno = 0; testno < numtests; testno++){
            UnionFind u = new UnionFind(20);
            SlowUF testu = new SlowUF(20);
            String text  = "";
            for (int i = 0; i < 40; i++) {
                int x = ThreadLocalRandom.current().nextInt(1, 20);
                int y = ThreadLocalRandom.current().nextInt(1, 20);
                String coords = String.format("(%d, %d)", x,y);                
                text += coords;
                assertEquals(coords, u.find(x,y), testu.find(x,y));
                u.union(x,y);
                testu.union(x,y);
                assertEquals(coords, u.find(x,y), testu.find(x,y));
                for (int k = 0; k < 20; k++) {
                    for(int p = k+1; p < 20; p++)
                    {
                        assertEquals(coords, u.find(k,p), testu.find(k,p));
                    }
                }
            }
        }
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
    
    // 0 x x
    // 0 0 x
    // x 0 x
    public void testPercolation1()
    {
        Percolation p = new Percolation(3);
        assertFalse(p.percolates());
        p.open(1,1);
        p.open(2,2);
        p.open(3,2);
        assertFalse(p.percolates());
        p.open(2,1);
        assertTrue(p.percolates());
        assertEquals("number of open sites", 4, p.numberOfOpenSites());
    }
    
    // 0 0 0
    // x x 0
    // x x 0
    public void testPercolation2()
    {
        Percolation p = new Percolation(3);
        assertFalse(p.percolates());
        p.open(1,1);
        p.open(1,2);
        p.open(2,3);
        p.open(3,3);
        assertFalse(p.percolates());
        p.open(1,3);
        assertTrue(p.percolates());
        assertEquals("number of open sites", 5, p.numberOfOpenSites());
    }
   
    // x 0 0
    // 0 0 x
    // 0 x x
    public void testPercolation3()
    {
        Percolation p = new Percolation(3);
        assertFalse(p.percolates());
        p.open(3,1);
        p.open(2,2);
        p.open(1,3);
        assertFalse(p.percolates());
        p.open(2,1);
        assertFalse(p.percolates());
        p.open(1,2);
        assertTrue(p.percolates());
        assertEquals("number of open sites", 5, p.numberOfOpenSites());
    }
        
}

package Sandbox;

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
    
    public void testFreshJuice()
    {
        FreshJuice juice = new FreshJuice();
        juice.size = FreshJuice.FreshJuiceSize.MEDIUM ;
        assertTrue(juice.size == FreshJuice.FreshJuiceSize.MEDIUM);
        //System.out.println("Size: " + juice.size);    
    }
    
    public void testSingleton()
    {
        Singleton single = Singleton.getInstance();
        single.demoMethod();
        Singleton other = Singleton.getInstance();
        other.demoMethod();
        assertEquals("singleton is single", single.getCounter(), 2);
        
    }
    
    public void testPuppy()
    {
      /* Object creation */
      Puppy myPuppy = new Puppy( "tommy" );
      /* Call class method to set puppy's age */
      myPuppy.setAge( 2 );
      /* Call another class method to get puppy's age */
      assertEquals("putty set age", myPuppy.getAge(), 2);
    }
    
    public void testForeach()
    {
        Loops f = new Loops();
        assertEquals("for each", f.foreach(), 10+20+30+40+50);
        
    }
}

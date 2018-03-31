package Sandbox;

// File Name: Singleton.java
public class Singleton {

   private static Singleton singleton = new Singleton( );
   
   private int counter = 0;

   /* A private Constructor prevents any other
    * class from instantiating.
    */
   private Singleton() { }

   /* Static 'instance' method */
   public static Singleton getInstance( ) {
      return singleton;
   }

   /* Other methods protected by singleton-ness */
   protected void demoMethod( ) {
      //System.out.println("demoMethod for singleton");
      counter++;
   }
   
   public int getCounter() {
       return counter;
   }    
}
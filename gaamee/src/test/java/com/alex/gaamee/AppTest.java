package com.alex.gaamee;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

@test
public class AppTest 
    extends TestCase
{
   
    public AppTest( String testName )
    {
        super( testName );
    }

   
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

  
    // Test to see if string is a valid word fails because nothing is not a valid word
    @test
    public void testInputString()
    {
    	Directwords d = new Directwords() ; 
    	String input = "nothing";
    	assertTrue(d.validWord(input)); 
    	
    }
    // Test to see if string is a valid word passes because move is a valid word.
    @test
   public void testInputStringC()
   {
	   Directwords d = new Directwords();
	   String input = "move"; 
	   assertTrue(d.validWord(input)); 
	   
   }
    /// Test to see if the string is null passes because assert false.
    @test
    public void testStringNull()
    {
    	Directwords d = new Directwords(); 
    	String input = null; 
    	assertFalse(d.validWord(input));   	  	
    }
    
}

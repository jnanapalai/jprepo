package com.junit.JUnitExample;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
    }
    
    public String getHello()
    {
    	return "Hello";
    }
    
    public  boolean isEven(int value)
    {
    	int d=value%2;
    	boolean b=false;
    	if(d==0)
    	{
    		b=true;
    	}
    	return b;
    }
}

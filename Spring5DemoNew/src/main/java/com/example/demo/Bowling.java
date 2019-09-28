package com.example.demo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Bowling {/*
	 ArrayList<Integer> scores=new ArrayList<Integer>();
public static void main(String args[])
{
	Bowling bl=new Bowling();
	Scanner sc=new Scanner(System.in);
	int score=0;
	ArrayList<Integer> scoreList=new ArrayList<Integer>();
	String regex = "^\\d+$";
	for(int i=1;i<=10;i++)
	{
	System.out.println("Please enter the number of pins down for roll1 for frame "+i);
	int roll1=0;int roll2=0;
	String roll=sc.next();
	while(!(roll.matches(regex)) || roll.matches(regex) && Integer.parseInt(roll)>10)
	{
		System.out.println("Please enter valid number of pins down for roll1 for frame "+i);
		roll=sc.next();
	}
	roll1=Integer.parseInt(roll);
	
	
	int strikeroll1=0;int strikroll2=0;int spare=0;
	if(roll1==10)
	{
		System.out.println("Plese enter no of pins down for  first roll for strike of frame"+i);
		String strikerollFor1=sc.next();
		while(!(strikerollFor1.matches(regex)) || strikerollFor1.matches(regex) && Integer.parseInt(strikerollFor1)>10)
		{
			System.out.println("Please enter valid number of pins down for first roll for strike");
			strikerollFor1=sc.next();
		}
		strikeroll1=Integer.parseInt(strikerollFor1);
		System.out.println("Please enter no of pins down for second roll for strike of frmae "+i);
		String  strikrollFor2=sc.next();
		 while( !(strikrollFor2.matches(regex)) || strikrollFor2.matches(regex) && Integer.parseInt(strikrollFor2)>10
				 || strikrollFor2.matches(regex) && strikeroll1<10 && Integer.parseInt(strikrollFor2)>10-strikeroll1)
		 {
			 System.out.println("The no of pins entered is not valid Please enter again for second roll for strike of frame"+i);
			 
			 strikrollFor2=sc.next();
		 }
		 strikroll2=Integer.parseInt(strikrollFor2);
		 bl.roll(strikeroll1);bl.roll(strikroll2);bl.roll(10);
		
	}
	else {
		System.out.println("Please enter the number of pins down for roll2 of frame"+i);
		String forroll2=sc.next();
		 while(!(forroll2.matches(regex)) || forroll2.matches(regex) && Integer.parseInt(forroll2)>10-roll1)
		 {
			 System.out.println("The no of pins entered is not valid Please enter again the number of pins down for roll2");
			 forroll2=sc.next();
		 }
		 roll2=Integer.parseInt(forroll2);
		 bl.roll(roll1);bl.roll(roll2);
	}
	if(roll1+roll2==10 && roll1!=10)
	{
		System.out.println("Plese enter no of pins down for   roll for spare of frmae "+i);
		String rollforSpare=sc.next();
	    while(!(rollforSpare.matches(regex)) || rollforSpare.matches(regex) && Integer.parseInt(rollforSpare)>10)
		 {
			 System.out.println("The no of pins entered is not valid Please enter again the number of pins down for roll for spare of frmae"+i);
			 rollforSpare=sc.next();
		 }
		 spare=Integer.parseInt(rollforSpare);
		 bl.roll(spare);
	}
	}
	System.out.println("Score is"+bl.getScore());
}

public void roll(int i)
{
	scores.add(i);
}
	
	public  int getScore()
	{
	Iterator<Integer> itr=scores.iterator();
	int sum=0;
	while(itr.hasNext())
	{
		sum=sum+itr.next();
	}
	return sum;
	}
*/}

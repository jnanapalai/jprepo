package com.example.demo;



//@Service

public class JerseyController implements JerseyInterface {
	
	
	

	@Override
	public String getTaskAgain() {
		// TODO Auto-generated method stub
		return "getTaskAgain";
	}

	@Override
	public String getTask() {
		// TODO Auto-generated method stub
		return getTask("abc");
	}
	
	
	public String getTask(String abc)
	{
		return abc;
	}
	
	

}

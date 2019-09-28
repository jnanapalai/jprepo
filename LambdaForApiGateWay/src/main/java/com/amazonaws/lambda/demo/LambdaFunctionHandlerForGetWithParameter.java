package com.amazonaws.lambda.demo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Item;
import com.amazonaws.services.dynamodbv2.document.KeyAttribute;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestStreamHandler;
import com.google.gson.JsonObject;

public class LambdaFunctionHandlerForGetWithParameter implements RequestStreamHandler {

	@Override
	public void handleRequest(InputStream input, OutputStream output, Context context) throws IOException {
		java.util.List<Employee> emp1=new java.util.ArrayList<Employee>();
		// TODO Auto-generated method stub
		try {
		AmazonDynamoDB ab=AmazonDynamoDBClientBuilder.defaultClient();
		DynamoDB db=new DynamoDB(ab);
		JSONParser parser=new JSONParser();
		BufferedReader reader=new BufferedReader(new InputStreamReader(input));
		JSONObject event=(JSONObject) parser.parse(reader);
		if(event.get("pathParameters")!=null)
		{
		JSONObject pps=(JSONObject) event.get("pathParameters");
		if(pps.get("id")!=null)
		{
	String id=(String) pps.get("id");
	Item result=db.getTable("Employee").getItem("empid", id);
	context.getLogger().log("emname is"+result.getString("empname"));
	Employee emp=new Employee();
	emp.setEmpname(result.getString("empname"));
	emp.setEmpid(Integer.parseInt(result.getString("empid")));
	emp.setEmail(result.getString("email"));
	
	context.getLogger().log("the value of employyee"+emp.toString());
	//emp.setAge(result.getInt("age"));
	emp1.add(emp);
	
		}
		}
		
	}catch(Exception e)
		{
		context.getLogger().log("Inside execption block");
		context.getLogger().log(e.getMessage());
		
		}
		OutputStreamWriter writer = new OutputStreamWriter(output, "UTF-8");
	    writer.write(emp1.toString());
	    writer.close();
	}
}

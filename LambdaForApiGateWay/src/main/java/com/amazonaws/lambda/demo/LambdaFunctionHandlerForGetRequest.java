package com.amazonaws.lambda.demo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.Map;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Table;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.ScanRequest;
import com.amazonaws.services.dynamodbv2.model.ScanResult;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestStreamHandler;

public class LambdaFunctionHandlerForGetRequest implements RequestStreamHandler {

	@Override
	public void handleRequest(InputStream inputStream, OutputStream outputStream, Context context) throws IOException {
		
		JSONObject responseBody = new JSONObject();
	    
	AmazonDynamoDB client= AmazonDynamoDBClientBuilder.defaultClient();
	DynamoDB db=new DynamoDB(client);
	ScanRequest ab=new ScanRequest().withTableName("Employee");
		ScanResult result=	client.scan(ab);
		java.util.List<Employee> emp=new java.util.ArrayList<Employee>();
		for(Map<String, AttributeValue> items:result.getItems())
		{
			Employee emp1=new Employee();
		for(Map.Entry<String, AttributeValue> item:items.entrySet())
		{
			
			if(item.getKey()=="empname")
				emp1.setEmpname(item.getValue().getS());
			else if(item.getKey()=="empid")
				emp1.setEmpid(Integer.parseInt(item.getValue().getS()));
			else if(item.getKey()=="age")
				emp1.setAge(Integer.parseInt(item.getValue().getN()));
			else 
				emp1.setEmail(item.getValue().getS());
			//context.getLogger().log("The attrbute is"+item.getKey());
			
			//context.getLogger().log("The attrbute is"+item.getValue().getS());
		}
		emp.add(emp1);
		responseBody.put("person",emp1);
		}
		
		
		 OutputStreamWriter writer = new OutputStreamWriter(outputStream, "UTF-8");
		    writer.write(emp.toString());
		    writer.close();
	}

}

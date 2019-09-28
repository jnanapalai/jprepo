package com.amazonaws.lambda.demo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Item;
import com.amazonaws.services.dynamodbv2.document.spec.DeleteItemSpec;
import com.amazonaws.services.dynamodbv2.document.spec.PutItemSpec;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestStreamHandler;

public class LambdaFunctionHandlerForPost implements RequestStreamHandler {

	@Override
	public void handleRequest(InputStream input, OutputStream output, Context context) throws IOException {
		AmazonDynamoDB dynamodb=AmazonDynamoDBClientBuilder.defaultClient();
		DynamoDB db=new DynamoDB(dynamodb);
		// TODO Auto-generated method stub
		try {
			JSONParser parser=new JSONParser();
			BufferedReader buffer=new BufferedReader(new InputStreamReader(input));
			JSONObject obj=new JSONObject();
			JSONObject obj1=(JSONObject) parser.parse(buffer);
			if(obj1.get("body")==null)
			{
				
			}
			else {
				int empid=0;
				context.getLogger().log(obj1.get("body").toString());
				Employee emp=new Employee( obj1.get("body").toString());
				context.getLogger().log("emp is"+emp);
				/*db.getTable("Employee").putItem(new PutItemSpec().withItem(
						new Item().withString("empid", String.valueOf(emp.getEmpid()))
						.withString("empname", emp.getEmpname())
						.withString("email",emp.getEmail())
						.withInt("age",emp.getAge())
						));*/
				db.getTable("Employee").deleteItem(new DeleteItemSpec().withPrimaryKey("empid",String.valueOf(emp.getEmpid())));
			}
			
		}catch(Exception e)
		{
			context.getLogger().log("Inside catch"+e.getMessage());
		}
	}

}

package com.amazonaws.lambda.demo;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.RequestStreamHandler;
import com.amazonaws.services.lambda.runtime.events.S3Event;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.GetObjectRequest;
import com.amazonaws.services.s3.model.S3Object;

public class LambdaFunctionHandler
implements RequestStreamHandler{
  /*public String handleRequest(Object obj, Context context) {
      context.getLogger().log("Input: " +obj);
      return "Hello World - " + obj;
  }
  public String handleRequest1(Object obj, Context context) {
      context.getLogger().log("Input: " +obj);
      return "Hello World 1- " + obj;
  }*/
@Override
public void handleRequest(InputStream input, OutputStream output, Context context) throws IOException {
	// TODO Auto-generated method st
	context.getLogger().log("Hello Request Hanlder Steream");
}
}
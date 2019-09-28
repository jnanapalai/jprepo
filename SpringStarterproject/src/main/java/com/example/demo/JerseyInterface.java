package com.example.demo;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
@Path("/task")
public interface JerseyInterface {
	
	@GET
	@Produces("text/plain")
	@Path("/getTaskAgain")
	public String getTaskAgain();
	
	@GET
	public String  getTask();

}

package com.youtube.rest.status;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/v1/status")


public class V1_status {
	
	private static final String API_VERSION = "00.01.00";

	@GET
	
	@Produces(MediaType.TEXT_HTML)
	
	// looks for an HTML "GET" and returns a TEXT_HTML String object
	// only occurs when visting the context path, e.g.: http://localhost:7001/com.youtube.rest/api/v1/status
	public String returnTitle(){
		return "<p>Java Web Service</p> ";
	}


	
	// looks for an HTML "GET" and returns a TEXT_HTML String object
	// only occurs when visting the context path, e.g.: http://localhost:7001/com.youtube.rest/api/v1/status/version
	
	@GET
	@Path("/version")
	@Produces(MediaType.TEXT_HTML)
	public String returnVersion(){
		return "<p>Version: </p>" + API_VERSION;
	}	
	
}

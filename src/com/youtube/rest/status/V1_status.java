package com.youtube.rest.status;

import javax.ws.rs.*;
import javax.ws.rs.core.*;
import java.sql.*;
import com.youtube.dao.*; // imports the package which contains the data connection

@Path("/v1/status")


public class V1_status {
	
	private static final String API_VERSION = "00.01.00";

	@GET
	
	@Produces(MediaType.TEXT_HTML)
	
	// looks for an HTML "GET" and returns a TEXT_HTML String object
	// only occurs when visiting the context path, e.g.: http://localhost:7001/com.youtube.rest/api/v1/status
	public String returnTitle(){
		return "<p>Java Web Service</p>";
	}


	
	// looks for an HTML "GET" and returns a TEXT_HTML String object
	// only occurs when visiting the context path, e.g.: http://localhost:7001/com.youtube.rest/api/v1/status/version
	
	@GET
	@Path("/version")
	@Produces(MediaType.TEXT_HTML)
	public String returnVersion(){
		return "<p>Version: </p>" + API_VERSION;
	}	// end method
	
	//connect to DB and get a string
	
	@GET
	@Path("/database")
	@Produces(MediaType.TEXT_HTML)
	public String returnDatabaseStatus() throws Exception
	{
		PreparedStatement query = null;
		String myString = null; //stores values from data set
		String returnString = null;
		Connection conn = null;
		
		try
		{
			conn = Oracle308tube.oracle380tubeConn().getConnection();
			query = conn.prepareStatement("select to_char(sysdate, 'YYYY-MM-DD HH24:MI:SS') DATETIME " 
			  + "from sys.dual");
			ResultSet rs = query.executeQuery();
			
			while (rs.next())
			{
				myString = rs.getString("DATETIME");
			}
			
			query.close();
			returnString = "<p>Database Status</p><p>Database Date/Time return: " 
					+ myString + "</p";
		}
		
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
		finally
		{
			if (conn != null)
				{
				  conn.close();
				}
		}
		
		return returnString;
	}
	
}

package com.youtube.rest.status;

import javax.ws.rs.*;
import javax.ws.rs.core.*;

import java.sql.*;

import com.youtube.dao.*; // imports the package which contains the data connection

@Path("/postgres")

public class PostgresStatus 
{

//@Path("/database")
	@Produces(MediaType.TEXT_HTML)
	public String returnDatabaseStatus() throws Exception
	{
	
/* */	
		PreparedStatement query = null;
		String myString = null; //stores values from data set
		

		String returnString = "test";
/* */
		Connection conn = null;
		
		try
		{
			conn = PostgresDataTest.localPostgresConn().getConnection();
			query = conn.prepareStatement("select name from test.city " 
			  + "where city.id=1");
			ResultSet rs = query.executeQuery();
			
			while (rs.next())
			{
				myString = rs.getString("name");
			}
			
			query.close();
			returnString = "<p>First PK is : " 
					+ myString + "</p";
		}
		
		catch (Exception e)
		{
			e.printStackTrace();

			returnString = "<p>Sorry, there was an error with the database connection.</p>";
/* */
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

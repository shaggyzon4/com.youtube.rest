package com.youtube.dao;

import javax.naming.*;
import javax.sql.*;

public class Oracle308tube {

	private static DataSource oracle308tube=null;
	private static Context context=null;
	
	public static DataSource oracle380tubeConn() throws Exception
	{
	  if (oracle308tube != null)
	  {
		  return oracle308tube;
	  } // if this is true, we've already set this variable 
	
	  try 
	  {
		if (context==null)
		{
			context=new InitialContext();
		}
		
		oracle308tube= (DataSource) context.lookup("localoracle"); // lookup the JNDI defined in Weblogic console
	  }
	
	  catch (Exception e)
	  {
		e.printStackTrace();
	  }
	  return oracle308tube;
	} //end method
	
} // end class

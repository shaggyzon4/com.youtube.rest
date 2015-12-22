package com.youtube.dao;

import javax.naming.*;
import javax.sql.*;

public class PostgresDataTest 
{

	private static DataSource localPostgres = null;
	private static Context context = null;
	
	public static DataSource localPostgresConn() throws Exception
	{
		if (localPostgres != null) // if not null, a value is stored already and we need not reassign
		{
			return localPostgres; 
		}
		try
		{
			if (context==null)
			{
				context = new InitialContext();
			}
			
			localPostgres = (DataSource) context.lookup("localpostgres");
		}
		catch (Exception e)
		{
			e.printStackTrace();
			System.out.println("IT'S NO GOOD! ABORT!");
		}
		System.out.println("it's a good connection");
		return localPostgres;
	}
}

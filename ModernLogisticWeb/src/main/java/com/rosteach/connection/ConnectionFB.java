package com.rosteach.connection;

import java.util.Properties;

public class ConnectionFB {
	
	public static void getConnection(){
		/**
		 * set Properties for our connection
		 * */
		try{
			Properties prop = new Properties();
			prop.setProperty("user", "SYSDBA");
			prop.setProperty("password", "sysadmin");
			prop.setProperty("encoding", "win1251");
	
			/**
			 * get connection to database method getConnection(url,user,password,encoding)
			 * */
			//Class.forName("org.firebirdsql.jdbc.FBDriver").newInstance();
			//Connection conn = DriverManager.getConnection("jdbc:firebirdsql:192.168.20.13/3050:alter_curent",prop);
		}
		catch(Exception ex){
			
		}
	}
}

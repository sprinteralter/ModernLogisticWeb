package com.rosteach.DAO;
/**
 * @author Rostislav Pavlenko
 * */
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;

import com.rosteach.xml.DocListInvoice;


public class GetClientID {

	/**
	 * getClientId method with input File reference  
	 * */
	public int getClientId(String file, int index, String dataBase, String login,String password) throws JAXBException{
		int temp=0;
		/**
		 * Create an Object with JAXBContext with unmarshalling
		 * */
		DocListInvoice document = (DocListInvoice)((JAXBContext.newInstance(DocListInvoice.class)).createUnmarshaller()).unmarshal(new File(file));
		try{
			/**
			 * set Properties for our connection
			 * */
			Properties prop = new Properties();
			prop.setProperty("user", login);
			prop.setProperty("password", password);
			prop.setProperty("encoding", "win1251");
			
			/**
			 * get connection to database method getConnection(url,user,password,encoding)
			 * */
			Class.forName("org.firebirdsql.jdbc.FBDriver").newInstance();
			Connection conn = DriverManager.getConnection(dataBase,prop);
			System.out.println("Connection for ClientId getting Start with success!!!");
			/**
			 * statement creation
			 * */
			Statement stmHeader = conn.createStatement();
			/**
			 * SQL query creation (insertion)
			 * */
			String sqlH ="SELECT id FROM client WHERE info3='"+
							document.getDocumentInvoice().get(index).getInvoiceParties().get(0).getDeliveryKod().get(0).getTaxID()+"'";
			ResultSet rsId = stmHeader.executeQuery(sqlH);
			/**
			 * process the result set
			 * */
			while(rsId.next()) {
				temp = rsId.getInt("ID");
			}
			/**
			 * Closing our statement and connection!
			 * */
			stmHeader.close();
			conn.close();
		}
		catch(Exception e){
			e.getMessage();
		}
		return temp;
	}
}

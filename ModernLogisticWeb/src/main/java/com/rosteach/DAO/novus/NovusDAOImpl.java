package com.rosteach.DAO.novus;


import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.transaction.Transactional;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.springframework.stereotype.Repository;
import com.rosteach.xml.novus.DESADV;
import com.rosteach.xml.novus.DESADV.HEAD.PACKINGSEQUENCE.POSITION;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.persistence.EntityManager;

@Repository
public class NovusDAOImpl implements NovusDAO {
	
	
	
    
    
	@Override
	public String test(){
		
		// Configure connection pool
		Map properties = new HashMap();
		properties.put("javax.persistence.jdbc.user", "SYSDBA");
		properties.put("javax.persistence.jdbc.password","sysadmin");
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("connection", properties); //sprinter
	    EntityManager em =  emf.createEntityManager();
		//String s = "";
	    Query q = em.createNativeQuery("SELECT id FROM SPRORDERSOUTINV (621,'09.05.2016','09.05.2016',0,Null,0) where OUTCOMEINVOICEIDSSET = 5991581");
		String s = q.getSingleResult().toString();
		System.out.println("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA++++++++++++++++++++++++++++++++++++++++++++++++++"+s);
		return s;
						
	}
	
	
	@Override
	public int Insert(String database, String name, String password, String path){
		
		
		Map properties = new HashMap();
		//if(database.contains("curent")) //”¡–¿“‹ œ–» –¿¡Œ“≈ — –≈¿À‹ÕŒ ¡¿«Œ… !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
		properties.put("javax.persistence.jdbc.url", "jdbc:firebirdsql:localhost/3050:sprinter_curent");
		properties.put("javax.persistence.jdbc.user", "SYSDBA");
		properties.put("javax.persistence.jdbc.password", "sysadmin");
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("connection", properties); 
	    EntityManager em =  emf.createEntityManager();
		
	    DESADV novusXML = new DESADV();
	    JAXBContext jc;
		Unmarshaller u;
		File[] files = new File(path).listFiles();
		
		
		for (File f : files){
			
			try {
				jc = JAXBContext.newInstance(DESADV.class);
				u = jc.createUnmarshaller();
				novusXML = (DESADV) u.unmarshal(f);
			} catch (JAXBException e) {
				e.printStackTrace();
				}
			
			em.getTransaction().begin(); 
			Query q = em.createNativeQuery("EXECUTE PROCEDURE EPRORDERSOUTINV_INSERT('"
										+novusXML.getDATE()+"', '"
										+"11426" +"',"	//clientid
												+ " 0, "						//storeid
												+ "NULL, '"						 //outcomeinvociidset
										+novusXML.getDELIVERYDATE()+ 			//comment
												"', NULL, "						//beepreslinkid
												+ "NULL, "						//beepressstore
												+ "NULL,'"						//termdate
												+ novusXML.getSHIPMENTS() +"', "//paytypedid
												+ "NULL, '"						//comment1
										+novusXML.getORDERNUMBER()+"', "		//comment2
												+ "NULL, NULL, NULL, NULL, NULL, 0)"); 
			//q.executeUpdate();
			int id = (Integer)q.getSingleResult();
			em.getTransaction().commit();
			//int id = (Integer)q.getSingleResult();
			System.out.print(id+"IIIIIIIIIIIIIIIIIIIIIIIIIIIIDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDD");
			
			
			
			List<POSITION> positions = novusXML.getHEAD().getPACKINGSEQUENCE().getPOSITION();
			
			for (POSITION p : positions){
				
				Query goodsID = em.createNativeQuery("select goodsid from prodlink where  prodcode = '"+p.getPRODUCT()+"'"); //clientid = 11426 and
				
				List<Integer> codes = goodsID.getResultList();
				int gid = codes.get(0);
				
				for (int i : codes){
					System.out.println(codes.size() + " CODES SIZE-- " +i+" GID = "+gid);
					
				}
								
				Query mID = em.createNativeQuery("select measureid from goods where id ="+gid);
				short mesID = (Short) mID.getResultList().get(0);
				
				System.out.println(p.getPRODUCT()+" PRODUCT SHTRIHHHHHHHHHHHHHHHH");
				System.out.println(gid + " GGGGGGGGGGGGGGGGGGGGGGGIIIIIIDDDD");
				System.out.println(mesID + " MES ID");
				//Query qp = em.createNativeQuery("EXECUTE PROCEDURE EPRORDERSOUTINVDET_INSERT("+id+","+gid+","+mesID+","+p.getORDEREDQUANTITY()+",null"+")");
				//qp.executeUpdate();
				
				
			
				
				Properties proper = new Properties();
				proper.setProperty("user", "SYSDBA");
				proper.setProperty("password", "sysadmin");
				proper.setProperty("encoding", "win1251");
				/**
				 * get connection to database method getConnection(url,user,password)
				 * */
				String dataBase = "jdbc:firebirdsql:localhost/3050:sprinter_curent";
				try {
					Class.forName("org.firebirdsql.jdbc.FBDriver").newInstance();
					Connection connect = DriverManager.getConnection(dataBase,proper);
					String quer = "EXECUTE PROCEDURE EPRORDERSOUTINVDET_INSERT("+id+","+gid+","+mesID+","+p.getORDEREDQUANTITY()+",null"+")";
					Statement stmD = connect.createStatement();
					stmD.executeUpdate(quer);
					stmD.close();
					connect.close();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
			}
			
			
			//em.getTransaction().commit();
			
			//System.out.println("--------------------------------DESCRIPTION-----------------------------------------");
			//System.out.println(novusXML.getHEAD().getPACKINGSEQUENCE().getPOSITION().get(0).getDESCRIPTION());
		}
		
		//File file = new File(path);
		/*
		if(file.isDirectory()){
			DESADV[] documents = 
			
			String[] s= file.list();
			
			for(int i=0;i<s.length;i++){
				
				
				
			
				try {
					jc = JAXBContext.newInstance(DESADV.class);
					u = jc.createUnmarshaller();
					novusXML = (DESADV) u.unmarshal(new File(path,s[i]));
					
				} catch (JAXBException e) {
				
					e.printStackTrace();
					}
				
				}
		}
			*/
			
		
			
		return 0;

	}
     
}

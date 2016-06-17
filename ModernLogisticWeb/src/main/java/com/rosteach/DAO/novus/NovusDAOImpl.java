package com.rosteach.DAO.novus;


import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TransactionRequiredException;
import javax.transaction.Transactional;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Repository;
import com.rosteach.xml.novus.DESADV;
import com.rosteach.xml.novus.DESADV.HEAD.PACKINGSEQUENCE.POSITION;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.persistence.EntityManager;

@Repository
public class NovusDAOImpl implements NovusDAO {
	
	
	
    
    
	@Override
	public String test() throws SQLException{
		
		// Configure connection pool
		Map properties = new HashMap();
		properties.put("javax.persistence.jdbc.user", "SYSDBA");
		properties.put("javax.persistence.jdbc.password","sysadmin");
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("craft_curent", properties); //sprinter
	    EntityManager em =  emf.createEntityManager();
		
	    
	    //String s = "";
	    Query q = em.createNativeQuery("select * from SPRORDERSOUTINV (1,'16.05.2016',Null,0,Null,0)");
		List<Object> responce = (List<Object>) q.getResultList();
		for(Object s : responce){
			System.out.println(s.toString());
		}
		return String.valueOf(responce.size()) ;
						
	}
	
	
	@Override
	public String Insert(String database, String name, String password, String path) throws SQLException{
		
		
		Map properties = new HashMap();
		properties.put("javax.persistence.jdbc.url", "jdbc:firebirdsql:localhost/3050:sprinter_curent");
		properties.put("javax.persistence.jdbc.user", "SYSDBA");
		properties.put("javax.persistence.jdbc.password", "sysadmin");
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("craft_curent", properties); 
	    EntityManager em =  emf.createEntityManager();
		
	    String fileName = "";
		String result = "";
	
	    
	    JAXBContext jc;
		Unmarshaller u;
		DESADV novusXML = new DESADV();
		File[] files = new File(path).listFiles();
		POSITION tovar = null;
		
		em.getTransaction().begin();
		
		//���������� ��� ����� � �������� <String path>
		for (File f : files){
			fileName = f.getName();
			
			try{	
			try {
				jc = JAXBContext.newInstance(DESADV.class);
				u = jc.createUnmarshaller();
				novusXML = (DESADV) u.unmarshal(f);
			} catch (JAXBException e) {
				e.printStackTrace();
				}
			
			//������� ������
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
			//�������� ����� �� ���������
			int id = (Integer)q.getSingleResult();
			
			//������� ������ ������� ������� � ������
			List<POSITION> positions = novusXML.getHEAD().getPACKINGSEQUENCE().getPOSITION();
			
			//��������� ������ ������� �� ������ � ������
			for (POSITION p : positions){
				try{
				tovar = p;
				
				//���� �������� �� ���������
				Query goodsID = em.createNativeQuery("select goodsid from prodlink where  prodcode = '"+p.getPRODUCT()+"'"); //clientid = 11426 and
				List<Integer> codes = goodsID.getResultList();
				int gid = codes.get(0);	
				
				//������� ��������� �� ���� ��������
				Query mID = em.createNativeQuery("select measureid from goods where id ="+gid);
				short mesID = (Short) mID.getResultList().get(0);
				
				
			 Query qp = em.createNativeQuery("EXECUTE PROCEDURE EPRORDERSOUTINVDET_INSERT("+id+","+gid+","+mesID+",'"+p.getORDEREDQUANTITY()+"',null"+")");
				qp.executeUpdate();
				}catch(IndexOutOfBoundsException ind){
					result = result + "�� ������ (�������� = "+tovar.getPRODUCT()+") ������ "+tovar.getDESCRIPTION()+" � (�����= "+fileName+") \n";
					System.out.println(result+") --------------------------------------------------------------------------------------------");				
					em.getTransaction().rollback();
					em.getTransaction().begin();
					break;
					
				}
				
				}
					
			
			}
				catch(TransactionRequiredException e){
					e.printStackTrace();
				}

			}
		em.getTransaction().commit();
		//FileUtils.cleanDirectory(new File(path));
		
					
		return result;

	}
     
}

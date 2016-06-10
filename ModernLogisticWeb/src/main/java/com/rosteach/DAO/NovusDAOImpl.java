package com.rosteach.DAO;

import javax.persistence.EntityManagerFactory;
import javax.persistence.ParameterMode;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.StoredProcedureQuery;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;

import javax.persistence.EntityManager;

@Repository
public class NovusDAOImpl implements NovusDAO {
	
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("craft_curent"); //sprinter
    EntityManager em =  emf.createEntityManager();
    
	@Override
	public String test(){
		
	    Query q = em.createNativeQuery("SELECT id FROM SPRORDERSOUTINV (621,'09.05.2016','09.05.2016',0,Null,0) where OUTCOMEINVOICEIDSSET = 5991581");
		String s = q.getSingleResult().toString();
			//System.out.println("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA++++++++++++++++++++++++++++++++++++++++++++++++++"+s);
		return s;
						
	}
	
	public int Insert(){

		//INSERT 
		em.getTransaction().begin();
		StoredProcedureQuery storedProcedure = em.createStoredProcedureQuery("EPRORDERSOUTINV_INSERT");
		// set parameters
		storedProcedure.registerStoredProcedureParameter("DOCDATE",  Date.class, ParameterMode.IN);
		storedProcedure.registerStoredProcedureParameter("CLIENTID", Integer.class, ParameterMode.IN);
		storedProcedure.registerStoredProcedureParameter("STOREID", Integer.class, ParameterMode.IN);
		storedProcedure.registerStoredProcedureParameter("OUTCOMEINVOICEIDSSET", String.class, ParameterMode.IN);
		storedProcedure.registerStoredProcedureParameter("comment", String.class, ParameterMode.IN);
		storedProcedure.registerStoredProcedureParameter("BEEPRESLINKID", Integer.class, ParameterMode.IN);
		storedProcedure.registerStoredProcedureParameter("BEEPRESSTOREID", Integer.class, ParameterMode.IN);
		storedProcedure.registerStoredProcedureParameter("TERMDATE", Date.class, ParameterMode.IN);
		storedProcedure.registerStoredProcedureParameter("PAYTYPEID", Integer.class, ParameterMode.IN);
		storedProcedure.registerStoredProcedureParameter("COMMENT1", String.class, ParameterMode.IN);
		storedProcedure.registerStoredProcedureParameter("COMMENT2", String.class, ParameterMode.IN);
		storedProcedure.registerStoredProcedureParameter("PRICETYPEID", Integer.class, ParameterMode.IN);
		storedProcedure.registerStoredProcedureParameter("AGENTID", Integer.class, ParameterMode.IN);
		storedProcedure.registerStoredProcedureParameter("AID", Integer.class, ParameterMode.IN);
		storedProcedure.registerStoredProcedureParameter("DISCOUNT", Float.class, ParameterMode.IN);
		storedProcedure.registerStoredProcedureParameter("SPECDISCOUNT", Float.class, ParameterMode.IN);
		storedProcedure.registerStoredProcedureParameter("OK_PASSED", Integer.class, ParameterMode.IN);
		
		
		
		storedProcedure.registerStoredProcedureParameter("id", Integer.class, ParameterMode.OUT);
		storedProcedure.setParameter("subtotal", 1f);
		// execute SP
		storedProcedure.execute();
		// get result
		int id = (Integer)storedProcedure.getOutputParameterValue("id");
		
		em.getTransaction().commit();
        em.close();
        return id;
	}
     
}

package xy.bd.connection;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAConnection {

	private static EntityManagerFactory connection;
	private EntityManager em;
	private boolean own = true;
	
	private EntityManagerFactory conect(){
		
		try{
			if(connection != null && connection.isOpen()){
				return connection;
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		
		connection = Persistence.createEntityManagerFactory("TAKEME");
		
		return connection;
	}
	
	public void setEntityManager(EntityManager em){
		this.own = false;
		this.em = em;
	}
	
	protected EntityManager getEntityManager(){
		if(em == null || !em.isOpen()){
			em = conect().createEntityManager();
		}
		return em;
	}
	
	protected boolean isOwn() {
		return own;
	}

	protected void close(){
		
		if(em != null && em.isOpen()){
			this.em.close();
		}
	}
}

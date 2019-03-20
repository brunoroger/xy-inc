package xy.bd.jpa;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import xy.util.QuerySQL;
import xy.bd.connection.JPAConnection;
import xy.bd.interfaces.CrudDAO;

public abstract class JPAAbstract<E, ID> extends JPAConnection implements CrudDAO<E, ID> {

	private Class<E> entity;
	
	@SuppressWarnings("unchecked")
	public JPAAbstract() {

		@SuppressWarnings("rawtypes")
		Class<? extends JPAAbstract> realClass = getClass();

		ParameterizedType superclass = (ParameterizedType) realClass
				.getGenericSuperclass();

		this.entity = (Class<E>) superclass.getActualTypeArguments()[0];
	}
	
	protected String getEntityName() {

		String simpleName = this.entity.getSimpleName();

		Entity annotation = this.entity.getAnnotation(Entity.class);

		if (annotation != null && !annotation.name().isEmpty()) {
			return annotation.name();
		}else{
			return simpleName;
		}
	}
	
	protected String getPath(){
		return this.entity.getPackage().getName() +"."+ this.entity.getSimpleName();
	}
	
	public E getObject(ID id){

		EntityManager em = null;

		em = getEntityManager();
		
		E e = em.find(this.entity, id);

		if(isOwn()){
			this.close();
		}
		
		return e;
	}
	
	public E add(E e){

		EntityManager em = getEntityManager();

		if(isOwn()){
			em.getTransaction().begin();
		}

		if(em != null && em.getTransaction().isActive()){
			em.persist(e);
		}

		if(isOwn()){
			em.getTransaction().commit();
			
			em.close();

			this.close();
		}
		
		return e;
	}
	
	public E edit(E e){

		EntityManager em = getEntityManager();

		if(isOwn()){
			em.getTransaction().begin();
		}

		if(em != null && em.getTransaction().isActive()){
			em.merge(e);
		}

		if(isOwn()){
			em.getTransaction().commit();
			
			em.close();

			this.close();
		}
		
		return e;
	}

	public void remove(ID id){

		E e = this.getObject(id);

		EntityManager em = getEntityManager();

		if(isOwn()){
			em.getTransaction().begin();
		}

		if(em != null && em.getTransaction().isActive()){
			e = em.merge(e);
	
			em.remove(e);
		}

		if(isOwn()){
			em.getTransaction().commit();
	
			em.close();
	
			this.close();
		}
	}
	
	private TypedQuery<E> executeSQL(QuerySQL query, EntityManager em){
		
		TypedQuery<E> sql = em.createQuery(query.getSql(), this.entity);
		
		if(query.getParametros() != null){
			for(String key : query.getParametros().keySet()){
				sql.setParameter(key, query.getParametros().get(key));
			}
		}
		
		if(query.getListParameter() != null){
			for(String key : query.getListParameter().keySet()){
				sql.setParameter(key, query.getListParameter().get(key));
			}
		}
		
		return sql;
	}
	
	protected List<E> getList(QuerySQL query){
		
		EntityManager em = getEntityManager();
		
		TypedQuery<E> sql = this.executeSQL(query, em);
		
		List<E> list = sql.getResultList();
		
		if(isOwn()){
			this.close();
		}
		
		return list;
	}
	
	protected E getRow(QuerySQL query){
		
		EntityManager em = getEntityManager();
		
		TypedQuery<E> sql = this.executeSQL(query, em);
		
		E row = sql.getSingleResult();
		
		if(isOwn()){
			this.close();
		}
		
		return row;
	}
}

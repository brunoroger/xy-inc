package xy.bd.interfaces;

import java.util.List;

import javax.persistence.EntityManager;

import xy.util.Search;

public interface CrudDAO<E, ID> {

	public void setEntityManager(EntityManager em) throws Exception;
	
	public E getObject(ID id) throws Exception;
	
	public E add(E e) throws Exception;
	
	public E edit(E e) throws Exception;
	
	public void remove(ID id) throws Exception;
	
	public List<E> list(Search search) throws Exception;
}

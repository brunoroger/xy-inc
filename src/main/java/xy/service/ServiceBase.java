package xy.service;

import java.util.List;

import xy.objects.EntityObject;
import xy.util.Search;

public interface ServiceBase<E extends EntityObject<ID>, ID> {

	public E getObject(ID id) throws Exception;
	public E add(E e) throws Exception;
	public E edit(ID id, E e) throws Exception;
	public void remove(ID id) throws Exception;
	public List<E> list(Search search) throws Exception;
}

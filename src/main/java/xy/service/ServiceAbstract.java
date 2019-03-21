package xy.service;

import java.lang.reflect.ParameterizedType;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import xy.bd.connection.JPAConnection;
import xy.bd.interfaces.CrudDAO;
import xy.exception.NotFoundException;
import xy.exception.ValidException;
import xy.objects.EntityObject;
import xy.util.Search;
import xy.util.DAOFactory;

public class ServiceAbstract<E extends EntityObject<ID>, ID, DAO extends CrudDAO<E, ID>> extends JPAConnection implements ServiceBase<E, ID> {

	protected DAO dao;
	
	@SuppressWarnings("unchecked")
	public ServiceAbstract(){
		
		@SuppressWarnings("rawtypes")
		Class<? extends ServiceAbstract> realClass = getClass();

		ParameterizedType superclass = (ParameterizedType) realClass
				.getGenericSuperclass();

		Class<DAO> dao = (Class<DAO>) superclass.getActualTypeArguments()[2];

		this.dao = (DAO) DAOFactory.getInstanceOf(dao);
	}

	private void validEntity(E e) throws Exception {

		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		Validator validator = factory.getValidator();
		Set<ConstraintViolation<E>> constraintViolations = validator
				.validate(e);
		if (constraintViolations.size() > 0) {
			Iterator<ConstraintViolation<E>> iterator = constraintViolations
					.iterator();

			String msg = "";

			while (iterator.hasNext()) {
				ConstraintViolation<E> cv = iterator.next();
				
				msg += " - " + cv.getPropertyPath() + ": " + cv.getMessage();
			}

			throw new ValidException(msg);
		}
	}

	public E getObject(ID id) throws Exception {
		return this.dao.getObject(id);
	}

	public E add(E e) throws Exception {
		
		this.validEntity(e);
		
		return this.dao.add(e);
	}

	public E edit(ID id, E e) throws Exception {

		if(this.dao.getObject(id) == null) {
			throw new NotFoundException();
		}
		
		this.validEntity(e);
		
		e.setPrimaryKey(id);
		
		return this.dao.edit(e);
	}

	public void remove(ID id) throws Exception {
		this.dao.remove(id);
	}

	public List<E> list(Search search) throws Exception {
		return this.dao.list(search);
	}
}

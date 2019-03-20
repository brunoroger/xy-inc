package xy.rest;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import xy.util.Search;
import xy.util.UtilRest;
import xy.service.ServiceBase;

public class RestAbstract<E, ID, SERVICE extends ServiceBase<E, ID>> {

	private Class<E> entity;

	private Class<SERVICE> service;

	protected UtilRest util = new UtilRest();
	
	@Context
	private ContainerRequestContext req;
	
	@SuppressWarnings("unchecked")
	public RestAbstract() {

		@SuppressWarnings("rawtypes")
		Class<? extends RestAbstract> realClass = getClass();

		ParameterizedType superclass = (ParameterizedType) realClass
				.getGenericSuperclass();

		this.entity = (Class<E>) superclass.getActualTypeArguments()[0];
		this.service = (Class<SERVICE>) superclass.getActualTypeArguments()[2];
	}

	@GET
	@Path("/{id}")
	@Produces("application/json; charset=utf-8")
	public Response getObject(@PathParam("id") ID id) {

		try {
			SERVICE service = this.service.newInstance();

			E e = service.getObject(id);

			return this.util.getResponseList(e);
		} catch (Exception e) {
			return this.util.getResponseException(e);
		}
	}

	@POST
	@Produces("application/json; charset=utf-8")
	@Consumes("application/json")
	public Response add(@Valid String json) {

		try {
			E e = this.util.getObjectMapper().readValue(json, this.entity);

			SERVICE service = this.service.newInstance();

			return this.util.getResponseAdd(service.add(e));
		} catch (Exception e) {
			return this.util.getResponseException(e);
		}
	}

	@PUT
	@Produces("application/json; charset=utf-8")
	@Consumes("application/json")
	public Response edit(@Valid String json) {

		try {
			E e = this.util.getObjectMapper().readValue(json, this.entity);

			SERVICE service = this.service.newInstance();

			return this.util.getResponseEdit(service.edit(e));
		} catch (Exception e) {
			return this.util.getResponseException(e);
		}
	}

	@DELETE
	@Path("/{id}")
	@Produces("application/json; charset=utf-8")
	public Response remove(@PathParam("id") ID id) {

		try {
			SERVICE service = this.service.newInstance();

			service.remove(id);

			return this.util.getResponseRemove();
		} catch (Exception e) {
			return this.util.getResponseException(e);
		}
	}
	
	@GET
	@Produces("application/json; charset=utf-8")
	public Response list(@Context UriInfo allUri) {

		try {
			Search search = new Search();
			
			search.setParametros(allUri.getQueryParameters());
			
			SERVICE service = this.service.newInstance();
			
			List<E> e = service.list(search);

			return this.util.getResponseList(e);
		} catch (Exception e) {
			return this.util.getResponseException(e);
		}
	}
}

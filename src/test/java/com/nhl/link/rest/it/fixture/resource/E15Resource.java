package com.nhl.link.rest.it.fixture.resource;

import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Configuration;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;

import com.nhl.link.rest.DataResponse;
import com.nhl.link.rest.LinkRest;
import com.nhl.link.rest.it.fixture.cayenne.E14;
import com.nhl.link.rest.it.fixture.cayenne.E15;

@Path("e15")
public class E15Resource {

	@Context
	private Configuration config;

	@GET
	public DataResponse<E15> get(@Context UriInfo uriInfo) {
		return LinkRest.select(E15.class, config).uri(uriInfo).select();
	}

	@PUT
	@Path("{id}/e14s")
	// note that parent id is "int" here , but is BIGINT (long) in the DB. This
	// is intentional
	public DataResponse<E14> relateToOneExisting(@PathParam("id") int id, String data) {
		return LinkRest.idempotentFullSync(E14.class, config).toManyParent(E15.class, id, E15.E14S).syncAndSelect(data);
	}
}

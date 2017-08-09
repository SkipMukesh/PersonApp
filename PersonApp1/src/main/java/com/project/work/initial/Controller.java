package com.project.work.initial;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import com.project.work.details.ListDetails;
import com.project.work.getset.Person;

@SuppressWarnings("unused")
@Path("/persons")
public class Controller {

	ListDetails listDetails = new ListDetails();

	@GET
	@Produces("application/json")
	public Response show() {
		List<Person> persons = listDetails.getDetails();
		return Response.ok().entity(persons).header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "POST, GET, PUT, UPDATE, OPTIONS")
				.header("Access-Control-Allow-Headers", "Content-Type, Accept, X-Requested-With").build();
	}

	@GET
	@Path("/{param}")
	@Produces("application/json")
	public Response PersongetOne(@PathParam("param") int pnparm) {
		Person person = listDetails.getOne(pnparm);
		return Response.ok().entity(person).header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "POST, GET, PUT, UPDATE, OPTIONS")
				.header("Access-Control-Allow-Headers", "Content-Type, Accept, X-Requested-With").build();
	}

	@POST
	@Path("/")
	@Consumes("application/json")
	@Produces("application/json")
	public Response PersonaddOne(Person pnparm) {
		listDetails.addOne(pnparm);
		return Response.ok().entity(pnparm).header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "POST, GET, PUT, UPDATE, OPTIONS")
				.header("Access-Control-Allow-Headers", "Content-Type, Accept, X-Requested-With").build();
	}

	@PUT
	@Path("/{param}")
	@Consumes("application/json")
	@Produces("application/json")
	public Response PersoneditOne(@PathParam("param") int pnparm, Person pnid) {
		pnid.setPsnId(pnparm);
		listDetails.editOne(pnid);
		return Response.ok().entity(pnparm).header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "POST, GET, PUT, UPDATE, OPTIONS")
				.header("Access-Control-Allow-Headers", "Content-Type, Accept, X-Requested-With").build();
	}

	@DELETE
	@Path("/{param}")
	@Produces("application/json")
	public Response deleteOne(@PathParam("param") int pnparm) {
		listDetails.deleteOne(pnparm);
		return Response.ok().header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "POST, GET, PUT, UPDATE, OPTIONS")
				.header("Access-Control-Allow-Headers", "Content-Type, Accept, X-Requested-With").build();
	}

}

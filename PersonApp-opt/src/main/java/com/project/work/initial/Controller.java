package com.project.work.initial;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.project.work.details.ListDetails;
import com.project.work.getset.Person; 

@Path("/show")
public class Controller {

	ListDetails listDetails = new ListDetails();

	@GET
	@Produces("application/json")
	public List<Person> show() { 
		return listDetails.getDetails();
	}

	@GET
	@Path("/test")
	public String test() {
		return "test";
	}

	@GET
	@Path("/{param}")
	@Produces("application/json")
	public Person getOne(@PathParam("param") int pnparm) { 
		return listDetails.getOne(pnparm);
	}

	@POST
	@Path("/add")
	@Consumes("application/json")
	@Produces("application/json")
	public Person addOne(Person pnparm) { 
		return listDetails.addOne(pnparm);
	}

	@PUT
	@Path("/edit/{param}")
	@Consumes("application/json")
	@Produces("application/json")
	public Person editOne(@PathParam("param") int pnparm, Person pnid) { 
		pnid.setPsnId(pnparm);
		return listDetails.editOne(pnid);
	}

	@DELETE
	@Path("/delete/{param}")
	@Produces("application/json")
	public void deleteOne(@PathParam("param") int pnparm) {
		listDetails.deleteOne(pnparm);
	}

}

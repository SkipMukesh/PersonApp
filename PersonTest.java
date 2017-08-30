package test.java.com.sag.demo;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.junit.Test;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sag.getset.Person;

public class PersonTest {

	@Test
	public void GetPerson() throws Exception {
		Client client = ClientBuilder.newClient();
		Response response = client.target("http://localhost:8080/demo/api/v1")
		.path("/persons")
		.request()
		.get();
		
		System.out.println("GET..");
		int statusCode = response.getStatus();
		System.out.println("Status: " + statusCode);
		
		String responseValue = response.readEntity(String.class);
		System.out.println("ResponseValue : " + responseValue);
	}
	
	@Test
	public void PostPerson() throws Exception {		
		Person person = new Person(4, "post", 24, "post@work.com");		
		ObjectMapper object = new ObjectMapper(); 
		String data = object.writeValueAsString(person);

		Client client = ClientBuilder.newClient();
		Response response = client.target("http://localhost:8080/demo/api/v1")
		.path("/persons/")
		.request()
		.post(Entity.entity(data, MediaType.APPLICATION_JSON_TYPE));
		
		System.out.println("POST..");
		int status = response.getStatus();
		System.out.println("Status :" + status);
		
		String readEntity = response.readEntity(String.class);
		System.out.println("ResponseValue :" + readEntity );
	}
	
	@Test
	public void PutPerson() throws Exception {
		Person person = new Person(2, "put", 50, "put@work.com");
		ObjectMapper objectMapper = new ObjectMapper();
		String data = objectMapper.writeValueAsString(person);
		
		Client client = ClientBuilder.newClient();
		Response response = client.target("http://localhost:8080/demo/api/v1")
		.path("/persons/2")
		.request()
		.put(Entity.entity(data, MediaType.APPLICATION_JSON_TYPE));
		
		System.out.println("PUT..");
		int status = response.getStatus();
		System.out.println("Status :" + status);

		String readEntity = response.readEntity(String.class);
		System.out.println("ResponseValue :" + readEntity);
	}
	
	@Test
	public void DeletePerson() throws Exception {
		Client client = ClientBuilder.newClient();		
		Response response = client.target("http://localhost:8080/demo/api/v1")
		.path("/persons/1")
		.request()
		.delete();
		
		System.out.println("DELETE..");
		int status = response.getStatus();
		System.out.println("Status :" + status);		
	}
	

		
//		ClientConfig config = new DefaultClientConfig();
//		Client client = Client.create(config);
//		
//		WebResource webResource = client.resource(UriBuilder.fromUri("http://localhost:8080/demo/api/v1").build());
//		webResource.path("/persons").get()
//		System.out.println(.get(String.class));
//
////		int status = webResource.path("/persons").accept(MediaType.APPLICATION_JSON).head().getClientResponseStatus()
////				.getStatusCode();
//		assertEquals(200, status);
//	}
	/*
	 * @Test public void PostPerson() throws ClientErrorException, IOException {
	 * ClientConfig config = new DefaultClientConfig(); Client client =
	 * Client.create(config); WebResource webResource =
	 * client.resource(UriBuilder.fromUri("http://localhost:8080/demo/").build()
	 * ); Person person = new Person(5, "test", 24, "test@work.com");
	 * ObjectMapper object = new ObjectMapper(); String data =
	 * object.writeValueAsString(person); ClientResponse response =
	 * webResource.path("webApi").path("show/add").type(MediaType.
	 * APPLICATION_JSON)
	 * .accept(MediaType.APPLICATION_JSON).post(ClientResponse.class, data); int
	 * status = response.getStatus(); assertEquals(200, status); }
	 * 
	 * @Test public void DeletePerson() throws ClientErrorException, IOException
	 * { ClientConfig config = new DefaultClientConfig(); Client client =
	 * Client.create(config); WebResource webResource =
	 * client.resource(UriBuilder.fromUri("http://localhost:8080/demo/").build()
	 * ); ClientResponse response =
	 * webResource.path("webApi").path("show/delete/1").type(MediaType.
	 * APPLICATION_JSON) .delete(ClientResponse.class, ""); int status =
	 * response.getStatus(); assertEquals(204, status);
	 * 
	 * }
	 * 
	 * @Test public void PutPerson() throws ClientErrorException, IOException {
	 * ClientConfig config = new DefaultClientConfig(); Client client =
	 * Client.create(config); WebResource webResource =
	 * client.resource(UriBuilder.fromUri("http://localhost:8080/demo/").build()
	 * ); Person person = new Person(2, "TEST", 24, "test@work.com");
	 * ObjectMapper object = new ObjectMapper(); String data =
	 * object.writeValueAsString(person); ClientResponse response =
	 * webResource.path("webApi").path("show/edit/2").type(MediaType.
	 * APPLICATION_JSON)
	 * .accept(MediaType.APPLICATION_JSON).put(ClientResponse.class, data); int
	 * status = response.getStatus(); assertEquals(200, status); }
	 */
}

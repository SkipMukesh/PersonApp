package test.java.com.sag.demo;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.junit.Test;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sag.getset.Person;

public class ElasticSearchTest {

	@Test
	public void GetPerson() throws Exception {
		Client client = ClientBuilder.newClient();
		Response response = client.target("http://localhost:9200/mukesh/user")
		.path("/_search")
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
		Response response = client.target("http://localhost:9200/mukesh/user")
		.path("/11")
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
		Response response = client.target("http://localhost:9200/mukesh/user")
		.path("/2")
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
		Response response = client.target("http://localhost:9200/mukesh/user")
		.path("/1")
		.request()
		.delete();
		
		System.out.println("DELETE..");
		int status = response.getStatus();
		System.out.println("Status :" + status);		
	}

}

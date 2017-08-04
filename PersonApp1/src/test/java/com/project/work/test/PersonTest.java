package com.project.work.test;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;

import org.apache.http.client.ClientProtocolException;
import org.junit.Test;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.work.getset.Person;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;

public class PersonTest {

	@Test
	public void testPiece() {
		String t1 = "demo test";
		String t2 = "demo test";
		assertEquals(t2, t1);
	}

	@Test
	@SuppressWarnings("deprecation")
	public void GetPerson() throws ClientProtocolException, IOException {
		ClientConfig config = new DefaultClientConfig();
		Client client = Client.create(config);
		WebResource webResource = client.resource(UriBuilder.fromUri("http://localhost:8080/PersonApp1/").build());
		System.out
				.println(webResource.path("webApi").path("show").accept(MediaType.APPLICATION_JSON).get(String.class));

		int status = webResource.path("webApi").path("show").accept(MediaType.APPLICATION_JSON).head()
				.getClientResponseStatus().getStatusCode();
		assertEquals(200, status);
	}

	@Test
	public void PostPerson() throws ClientProtocolException, IOException {
		ClientConfig config = new DefaultClientConfig();
		Client client = Client.create(config);
		WebResource webResource = client.resource(UriBuilder.fromUri("http://localhost:8080/PersonApp1/").build());
		Person person = new Person(10, "TEST", 24, "test@work.com");
		ObjectMapper object = new ObjectMapper();
		String data = object.writeValueAsString(person);
		ClientResponse response = webResource.path("webApi").path("show").type(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON).post(ClientResponse.class, data);
		int status = response.getStatus();
		assertEquals(200, status);
	}

	@Test
	public void DeletePerson() throws ClientProtocolException, IOException {
		ClientConfig config = new DefaultClientConfig();
		Client client = Client.create(config);
		WebResource webResource = client.resource(UriBuilder.fromUri("http://localhost:8080/PersonApp1/").build());
		ClientResponse response = webResource.path("webApi").path("show/1").type(MediaType.APPLICATION_JSON)
				.delete(ClientResponse.class, "");
		int status = response.getStatus();
		assertEquals(204, status);

	}

	@Test
	public void PutPerson() throws ClientProtocolException, IOException {
		ClientConfig config = new DefaultClientConfig();
		Client client = Client.create(config);
		WebResource webResource = client.resource(UriBuilder.fromUri("http://localhost:8080/PersonApp1/").build());
		Person person = new Person(2, "TEST", 24, "test@work.com");
		ObjectMapper object = new ObjectMapper();
		String data = object.writeValueAsString(person);
		ClientResponse response = webResource.path("webApi").path("show/2").type(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON).put(ClientResponse.class, data);
		int status = response.getStatus();
		assertEquals(200, status);
	}

}

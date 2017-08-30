package com.sag.personapi;

import javax.json.Json;
import javax.json.JsonObject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("helloworld")
@Produces(MediaType.APPLICATION_JSON)
public class HelloworldAPI {
    @GET
    public Response ping() {
        JsonObject json = Json.createObjectBuilder()
                .add("message", "Welcome Hello API")
                .build();

        return Response.ok(json).build();
    }

    @GET
    @Path("message")
    public Response sayHello(@QueryParam("query") String query) {
        JsonObject json = Json.createObjectBuilder()
                .add("message", "Welcome Hello API - " + query)
                .build();

        return Response.ok(json).build();
    }
}
package fr.istic.taa.jaxrs.rest;

import fr.istic.taa.jaxrs.dao.generic.UserDAO;
import fr.istic.taa.jaxrs.domain.User;
import io.swagger.v3.oas.annotations.Parameter;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Response;

@Path("user")
@Produces({"application/json", "application/xml"})
public class UserResource {

    UserDAO dao = new UserDAO();

    @GET
    @Path("/{userId}")
    public User getUserById(@PathParam("userId") Long userId)  {
        return dao.findOne(userId);
    }

    @GET
    @Path("/")
    public User getUser(Long userId)  {
        return new User();
    }

    @POST
    @Consumes("application/json")
    public Response addUser(
        @Parameter(description = "User object that needs to be added to the store", required = true) User user) {
        return Response.ok().entity("SUCCESS").build();
    }
}

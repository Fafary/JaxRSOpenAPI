package fr.istic.taa.jaxrs.rest;

import fr.istic.taa.jaxrs.dao.generic.UserDAO;
import fr.istic.taa.jaxrs.domain.User;
import fr.istic.taa.jaxrs.dto.UserDTO;
import fr.istic.taa.jaxrs.mapstruct.UserMapper;
import fr.istic.taa.jaxrs.mapstruct.UserMapperImpl;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Response;

import java.util.ArrayList;
import java.util.List;

@Path("user")
@Produces({"application/json", "application/xml"})
public class UserResource {
    private final UserDAO dao = new UserDAO();

    private final UserMapper MAPPER = new UserMapperImpl();

    @GET
    @Path("/{userId}")
    @Produces("application/json")
    public Response getUserById(@PathParam("userId") Long userId)  {
        User user = dao.findOne(userId);
        UserDTO userDTO = MAPPER.userToUserDTO(user);

        if (user != null) {
            return Response.ok(userDTO).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @GET
    @Path("/")
    @Produces("application/json")
    public Response getUser()  {
        List<User> users = dao.findAll();
        List<UserDTO> result = new ArrayList<>();

        // Convertir la liste de users en une liste de DTOs
        users.forEach(user -> result.add(MAPPER.userToUserDTO(user)));

        return Response.ok(result).build();
    }

}

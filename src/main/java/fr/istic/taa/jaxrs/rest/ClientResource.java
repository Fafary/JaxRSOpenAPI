package fr.istic.taa.jaxrs.rest;

import fr.istic.taa.jaxrs.dao.generic.ClientsDAO;
import fr.istic.taa.jaxrs.domain.Clients;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("clients")
@Produces({"application/json", "application/xml"})
public class ClientResource {
    ClientsDAO dao = new ClientsDAO();

    @GET
    @Path("/{clientId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getClientById(@PathParam("clientId") long clientId) {
        Clients client = dao.findOne(clientId);

        if (client != null) {
            return Response.ok(client).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getClients() {
        List<Clients> clients = dao.findAll();
        return Response.ok(clients).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addClient(Clients client) {
        boolean success = addClientToService(client);

        if (success) {
            return Response.status(Response.Status.CREATED).entity("Client ajouté avec succès").build();
        } else {
            return Response.status(Response.Status.BAD_REQUEST).entity("Échec de l'ajout du client").build();
        }
    }

    private boolean addClientToService(Clients client) {
        dao.update(client);
        return false;
    }
}

package fr.istic.taa.jaxrs.rest;

import fr.istic.taa.jaxrs.dao.generic.ClientDAO;
import fr.istic.taa.jaxrs.dao.generic.RDVDAO;
import fr.istic.taa.jaxrs.domain.Client;
import fr.istic.taa.jaxrs.domain.RDV;
import fr.istic.taa.jaxrs.dto.ClientDTO;
import fr.istic.taa.jaxrs.mapstruct.ClientMapper;
import fr.istic.taa.jaxrs.mapstruct.ClientMapperImpl;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;

import java.util.ArrayList;
import java.util.List;

@Path("/clients")
@Produces({"application/json", "application/xml"})
public class ClientResource {
    ClientDAO dao = new ClientDAO();
    RDVDAO rdvdao = new RDVDAO();

    private final ClientMapper MAPPER = new ClientMapperImpl();

    @GET
    @Path("/{clientId}")
    @Produces("application/json")
    public Response getClientById(@PathParam("clientId") long clientId) {
        Client client = dao.findOne(clientId);
        ClientDTO clientDTO = MAPPER.clientToClientDTO(client);

        if (client != null) {
            return Response.ok(clientDTO).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @GET
    @Path("/")
    @Produces("application/json")
    public Response getClients() {
        List<Client> clients = dao.findAll();
        List<ClientDTO> result = new ArrayList<>();

        clients.forEach(client -> result.add(MAPPER.clientToClientDTO(client)));

        return Response.ok(result).build();
    }

    @GET
    @Path("/{clientId}/rdvs")
    @Produces("application/json")
    public Response getClientRDVs(@PathParam("clientId") long clientId) {
        List<RDV> RDVs = dao.getRDVs(dao.findOne(clientId));

        return Doctolib.getRDVs(RDVs);
    }

    @PUT
    @Path("/add")
    @Consumes("application/json")
    public Response addClient(ClientDTO clientDTO) {
        dao.save(MAPPER.clientDTOToClient(clientDTO));

        return Response.ok().entity("SUCCESS").build();
    }

    @POST
    @Path("/delete/{clientId}")
    @Consumes("application/json")
    public Response deleteClient(@PathParam("clientId") long clientId) {
        List<RDV> RDVs = dao.getRDVs(dao.findOne(clientId));
        RDVs.forEach(RDV -> rdvdao.delete(RDV));

        dao.deleteById(clientId);

        return Response.ok().entity("SUCCESS").build();
    }

    @POST
    @Path("/update/{clientId}")
    @Consumes("application/json")
    public Response updateClient(@PathParam("clientId") long clientId, String name) {
        Client client = dao.findOne(clientId);
        client.setName(name);
        dao.update(client);

        return Response.ok().entity("SUCCESS").build();
    }

}

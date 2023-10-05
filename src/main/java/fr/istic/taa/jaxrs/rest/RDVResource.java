package fr.istic.taa.jaxrs.rest;

import fr.istic.taa.jaxrs.dao.generic.RDVDAO;
import fr.istic.taa.jaxrs.domain.RDV;
import io.swagger.v3.oas.annotations.Parameter;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Response;

@Path("rdv")
@Produces({"application/json", "application/xml"})
public class RDVResource {

    RDVDAO dao = new RDVDAO();

    @GET
    @Path("/{rdvId}")
    public RDV getRdvById(@PathParam("rdvId") Long rdvId)  {
        return dao.findOne(rdvId);
    }

    @GET
    @Path("/")
    public RDV getRdv(Long rdvId)  {
        return new RDV();
    }

    @POST
    @Consumes("application/json")
    public Response addRDV(
            @Parameter(description = "RDV object that needs to be added to the store", required = true) RDV rdv) {
        return Response.ok().entity("SUCCESS").build();
    }
}

package fr.istic.taa.jaxrs.rest;

import fr.istic.taa.jaxrs.dao.generic.ProfessionnelsDAO;
import fr.istic.taa.jaxrs.domain.Professionnels;
import io.swagger.v3.oas.annotations.Parameter;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Response;

@Path("professionnels")
@Produces({"application/json", "application/xml"})
public class ProfessionnelResource {

    ProfessionnelsDAO dao = new ProfessionnelsDAO();

    @GET
    @Path("/{professionnelsId}")
    public Professionnels getProfessionnelsById(@PathParam("professionnelsId") Long professionnelsId)  {
        return dao.findOne(professionnelsId);
    }

    @GET
    @Path("/")
    public Professionnels getProfessionnels(Long professionnelsId)  {
        return new Professionnels();
    }


    @POST
    @Consumes("application/json")
    public Response addProfessionnels(
            @Parameter(description = "Professionnels object that needs to be added to the store", required = true) Professionnels professionnels) {
        return Response.ok().entity("SUCCESS").build();
    }
}
package fr.istic.taa.jaxrs.rest;

import fr.istic.taa.jaxrs.dao.generic.RDVDAO;
import fr.istic.taa.jaxrs.domain.Client;
import fr.istic.taa.jaxrs.domain.Professionnel;
import fr.istic.taa.jaxrs.domain.RDV;
import fr.istic.taa.jaxrs.dto.RDVDTO;
import fr.istic.taa.jaxrs.mapstruct.RDVMapper;
import fr.istic.taa.jaxrs.mapstruct.RDVMapperImpl;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;

import java.util.ArrayList;
import java.util.List;

@Path("rdvs")
@Produces({"application/json", "application/xml"})
public class RDVResource {
    RDVDAO dao = new RDVDAO();

    private final RDVMapper MAPPER = new RDVMapperImpl();

    @GET
    @Path("/{rdvId}")
    @Produces("application/json")
    public Response getRdvById(@PathParam("rdvId") Long rdvId)  {
        RDV rdv = dao.findOne(rdvId);
        RDVDTO rdvDTO = MAPPER.rdvToRdvDTO(rdv);

        if (rdv != null) {
            return Response.ok(rdvDTO).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @GET
    @Path("/")
    @Produces("application/json")
    public Response getRdvs()  {
        List<RDV> rdvs = dao.findAll();
        List<RDVDTO> result = new ArrayList<>();

        rdvs.forEach(rdv -> result.add(MAPPER.rdvToRdvDTO(rdv)));

        return Response.ok(result).build();
    }

    @PUT
    @Path("/add")
    @Consumes("application/json")
    public Response addRDV(RDVDTO rdvDTO) {
        dao.save(MAPPER.rdvDTOToRdv(rdvDTO));
        return Response.ok().entity("SUCCESS").build();
    }

    @POST
    @Path("/delete/{rdvId}")
    @Consumes("application/json")
    public Response deleteRDV(@PathParam("rdvId") long rdvId) {
        dao.deleteById(rdvId);

        return Response.ok().entity("SUCCESS").build();
    }

    @POST
    @Path("/update/{rdvId}")
    @Consumes("application/json")
    public Response updateRDV(@PathParam("rdvId") long rdvId, Client clientId,
                              Professionnel professionnelId, String sujet, String date) {
        RDV rdv = dao.findOne(rdvId);

        rdv.setClient(clientId);
        rdv.setProfessionnel(professionnelId);
        rdv.setSujet(sujet);
        rdv.setDate(date);
        dao.update(rdv);

        return Response.ok().entity("SUCCESS").build();
    }

}

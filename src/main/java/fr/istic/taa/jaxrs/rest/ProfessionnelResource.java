package fr.istic.taa.jaxrs.rest;

import fr.istic.taa.jaxrs.dao.generic.ProfessionnelDAO;
import fr.istic.taa.jaxrs.dao.generic.RDVDAO;
import fr.istic.taa.jaxrs.domain.Professionnel;
import fr.istic.taa.jaxrs.domain.RDV;
import fr.istic.taa.jaxrs.dto.ProfessionnelDTO;
import fr.istic.taa.jaxrs.mapstruct.ProfessionnelMapper;
import fr.istic.taa.jaxrs.mapstruct.ProfessionnelMapperImpl;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;

import java.util.ArrayList;
import java.util.List;

@Path("professionnels")
@Produces({"application/json", "application/xml"})
public class ProfessionnelResource {
    ProfessionnelDAO dao = new ProfessionnelDAO();
    RDVDAO rdvdao = new RDVDAO();

    private final ProfessionnelMapper MAPPER = new ProfessionnelMapperImpl();

    @GET
    @Path("/{professionnelId}")
    @Produces("application/json")
    public Response getProfessionnelsById(@PathParam("professionnelId") long professionnelsId)  {
        Professionnel professionnel = dao.findOne(professionnelsId);
        ProfessionnelDTO professionnelDTO = MAPPER.professionnelToProfessionnelDTO(professionnel);

        if (professionnel != null) {
            return Response.ok(professionnelDTO).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @GET
    @Path("/")
    @Produces("application/json")
    public Response getProfessionnels()  {
        List<Professionnel> professionnels = dao.findAll();
        List<ProfessionnelDTO> result = new ArrayList<>();

        professionnels.forEach(professionnel -> result.add(MAPPER.professionnelToProfessionnelDTO(professionnel)));

        return Response.ok(result).build();
    }

    @GET
    @Path("/{professionnelId}/rdvs")
    @Produces("application/json")
    public Response getProfessionnelRDVs(@PathParam("professionnelId") long professionnelId) {
        List<RDV> RDVs = dao.getRDVs(dao.findOne(professionnelId));

        return Doctolib.getRDVs(RDVs);
    }

    @PUT
    @Path("/add")
    @Consumes({"application/json"})
    public Response addProfessionnel(ProfessionnelDTO professionnelDTO) {
        dao.save(MAPPER.professionnelDTOToProfessionnel(professionnelDTO));

        return Response.ok().entity("SUCCESS").build();
    }

    @POST
    @Path("/delete/{professionnelId}")
    @Consumes("application/json")
    public Response deleteProfessionnel(@PathParam("professionnelId") long professionnelId) {
        List<RDV> RDVs = dao.getRDVs(dao.findOne(professionnelId));
        RDVs.forEach(RDV -> rdvdao.delete(RDV));

        dao.deleteById(professionnelId);

        return Response.ok().entity("SUCCESS").build();
    }

    @POST
    @Path("/update/{professionnelId}")
    @Consumes("application/json")
    public Response updateProfessionnel(@PathParam("professionnelId") long professionnelId, String name) {
        Professionnel professionnel = dao.findOne(professionnelId);
        professionnel.setName(name);
        dao.update(professionnel);

        return Response.ok().entity("SUCCESS").build();
    }

}

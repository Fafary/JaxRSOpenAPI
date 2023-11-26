package fr.istic.taa.jaxrs.rest;

import fr.istic.taa.jaxrs.domain.RDV;
import fr.istic.taa.jaxrs.dto.RDVDTO;
import fr.istic.taa.jaxrs.mapstruct.RDVMapper;
import fr.istic.taa.jaxrs.mapstruct.RDVMapperImpl;
import jakarta.ws.rs.core.Response;

import java.util.ArrayList;
import java.util.List;

// Fichier avec les fonctions auxiliaires pour les fichiers ressources
public class Doctolib {
    private static final RDVMapper MAPPER = new RDVMapperImpl();

    public static Response getRDVs(List<RDV> RDVs) {
        List<RDVDTO> result = new ArrayList<>();

        // Convertir chaque RDV en RDVDTO en utilisant le mapper
        RDVs.forEach(RDV -> result.add(MAPPER.rdvToRdvDTO(RDV)));

        return Response.ok(result).build();
    }

}

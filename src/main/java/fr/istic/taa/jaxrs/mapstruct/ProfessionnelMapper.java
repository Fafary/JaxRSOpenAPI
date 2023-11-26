package fr.istic.taa.jaxrs.mapstruct;

import fr.istic.taa.jaxrs.domain.Professionnel;
import fr.istic.taa.jaxrs.dto.ProfessionnelDTO;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ProfessionnelMapper {
    // Instance du mapper générée par MapStruct
    ProfessionnelMapper MAPPER = Mappers.getMapper(ProfessionnelMapper.class);

    ProfessionnelDTO professionnelToProfessionnelDTO(Professionnel professionnel);

    Professionnel professionnelDTOToProfessionnel(ProfessionnelDTO professionnelDTO);

}

package fr.istic.taa.jaxrs.mapstruct;

import fr.istic.taa.jaxrs.domain.RDV;
import fr.istic.taa.jaxrs.dto.RDVDTO;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface RDVMapper {
    RDVMapper MAPPER = Mappers.getMapper(RDVMapper.class);

    RDVDTO rdvToRdvDTO(RDV rdv);

    RDV rdvDTOToRdv(RDVDTO rdvDTO);

}

package fr.istic.taa.jaxrs.mapstruct;

import fr.istic.taa.jaxrs.domain.Client;
import fr.istic.taa.jaxrs.dto.ClientDTO;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ClientMapper {
    // Instance du mapper générée par MapStruct
    ClientMapper MAPPER = Mappers.getMapper(ClientMapper.class);

    ClientDTO clientToClientDTO(Client client);
    Client clientDTOToClient(ClientDTO clientDTO);

}

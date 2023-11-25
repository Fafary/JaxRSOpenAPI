package fr.istic.taa.jaxrs.mapstruct;

import fr.istic.taa.jaxrs.domain.User;
import fr.istic.taa.jaxrs.dto.UserDTO;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {
    UserMapper MAPPER = Mappers.getMapper(UserMapper.class);

    UserDTO userToUserDTO(User user);

}

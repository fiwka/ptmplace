package xyz.fiwka.ptmplace.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import xyz.fiwka.ptmplace.dto.request.UserFieldsRequest;
import xyz.fiwka.ptmplace.dto.response.UserResponseDto;
import xyz.fiwka.ptmplace.entity.User;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface UserMapper {

    User toUser(UserFieldsRequest userFieldsRequest);
    UserResponseDto toUserResponseDto(User user);
}

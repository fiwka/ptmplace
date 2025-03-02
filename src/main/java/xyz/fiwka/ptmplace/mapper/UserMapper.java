package xyz.fiwka.ptmplace.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import xyz.fiwka.ptmplace.dto.request.UserFieldsRequest;
import xyz.fiwka.ptmplace.dto.response.UserResponse;
import xyz.fiwka.ptmplace.entity.User;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface UserMapper {

    User toUser(UserFieldsRequest userFieldsRequest);
    UserResponse toUserResponseDto(User user);
}

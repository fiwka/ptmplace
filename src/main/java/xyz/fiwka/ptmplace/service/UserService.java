package xyz.fiwka.ptmplace.service;

import xyz.fiwka.ptmplace.dto.request.UserFieldsRequest;
import xyz.fiwka.ptmplace.dto.response.UserResponseDto;

import java.util.Optional;

public interface UserService {

    UserResponseDto createUser(UserFieldsRequest userFieldsRequest);
    Optional<UserResponseDto> findUser(String email);
    Optional<UserResponseDto> findUser(Long id);
}

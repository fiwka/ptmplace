package xyz.fiwka.ptmplace.service;

import xyz.fiwka.ptmplace.dto.request.UserFieldsRequest;
import xyz.fiwka.ptmplace.dto.response.UserResponse;

import java.util.Optional;

public interface UserService {

    UserResponse createUser(UserFieldsRequest userFieldsRequest);
    Optional<UserResponse> findUser(String email);
    Optional<UserResponse> findUser(Long id);
}

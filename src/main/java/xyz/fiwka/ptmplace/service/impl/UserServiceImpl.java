package xyz.fiwka.ptmplace.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import xyz.fiwka.ptmplace.dto.request.UserFieldsRequest;
import xyz.fiwka.ptmplace.dto.response.UserResponseDto;
import xyz.fiwka.ptmplace.entity.User;
import xyz.fiwka.ptmplace.exception.UserAlreadyExistsException;
import xyz.fiwka.ptmplace.mapper.UserMapper;
import xyz.fiwka.ptmplace.repository.UserRepository;
import xyz.fiwka.ptmplace.service.UserService;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;

    @Override
    @Transactional
    public UserResponseDto createUser(UserFieldsRequest userFieldsRequest) {
        if (userRepository.existsByEmail(userFieldsRequest.email()))
            throw new UserAlreadyExistsException("User with email " + userFieldsRequest.email() + " is already exists");

        var user = userMapper.toUser(userFieldsRequest);
        user.setPassword(passwordEncoder.encode(userFieldsRequest.password()));
        return userMapper.toUserResponseDto(userRepository.save(user));
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<UserResponseDto> findUser(String email) {
        return userRepository.findByEmail(email).map(userMapper::toUserResponseDto);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<UserResponseDto> findUser(Long id) {
        return userRepository.findById(id).map(userMapper::toUserResponseDto);
    }
}

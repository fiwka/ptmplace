package xyz.fiwka.ptmplace.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.fiwka.ptmplace.dto.response.UserResponseDto;
import xyz.fiwka.ptmplace.exception.UserNotFoundException;
import xyz.fiwka.ptmplace.service.UserService;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/me")
    public ResponseEntity<UserResponseDto> getCurrentUser() {
        var authentication = SecurityContextHolder.getContext().getAuthentication();

        return ResponseEntity.ok(userService.findUser(authentication.getName())
                .orElseThrow(() -> new UserNotFoundException("User not found")));
    }
}

package xyz.fiwka.ptmplace.test;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import xyz.fiwka.ptmplace.configuration.JwtProperties;
import xyz.fiwka.ptmplace.dto.request.AuthenticationRequest;
import xyz.fiwka.ptmplace.dto.request.UserFieldsRequest;
import xyz.fiwka.ptmplace.exception.BadCredentialsException;
import xyz.fiwka.ptmplace.mapper.UserMapperImpl;
import xyz.fiwka.ptmplace.provider.JwtTokenProvider;
import xyz.fiwka.ptmplace.service.AuthenticationService;
import xyz.fiwka.ptmplace.service.UserService;
import xyz.fiwka.ptmplace.service.impl.AuthenticationServiceImpl;
import xyz.fiwka.ptmplace.service.impl.PtmplaceUserDetailsService;
import xyz.fiwka.ptmplace.service.impl.UserServiceImpl;
import xyz.fiwka.ptmplace.util.JwtUtil;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

@DataJpaTest
@EnableConfigurationProperties(JwtProperties.class)
@Import({AuthenticationServiceImpl.class, UserServiceImpl.class, UserMapperImpl.class, JwtTokenProvider.class, JwtUtil.class, PtmplaceUserDetailsService.class})
public class AuthenticationServiceTest {

    private static final String JWT_SECRET_KEY = "IvqBPC8wpaxNM/aMmy8pntg0ERBlbXgUpOWvl4U2Jcc=";

    @MockitoBean
    private AuthenticationManager authenticationManager;

    @MockitoBean
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AuthenticationService authenticationService;

    @Autowired
    private JwtUtil jwtUtil;

    @DynamicPropertySource
    public static void jwtProperties(DynamicPropertyRegistry registry) {
        registry.add("jwt.secret-key", () -> JWT_SECRET_KEY);
    }

    @BeforeAll
    public static void initializeTest(@Autowired UserService userService) {
        var userFields = new UserFieldsRequest(
                "Ivanov",
                "Ivan",
                "79000000000",
                "ivanov@example.com",
                "12345678"
        );

        userService.createUser(userFields);
    }

    @Test
    public void whenValidAuthenticate_thenReturnUserToken() {
        var request = new AuthenticationRequest("ivanov@example.com", "12345678");

        var result = authenticationService.authenticate(request);

        var email = jwtUtil.getEmail(result.accessToken());

        assertThat(email)
                .isEqualTo("ivanov@example.com");
    }

    @Test
    public void whenInvalidAuthenticate_thenThrowsBadCredentialsException() {
        var request = new AuthenticationRequest("ivanov2@example.com", "12345678");

        assertThatExceptionOfType(BadCredentialsException.class)
                .isThrownBy(() -> authenticationService.authenticate(request));
    }
}

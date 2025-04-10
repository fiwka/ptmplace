package xyz.fiwka.ptmplace.test;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import xyz.fiwka.ptmplace.dto.request.UserFieldsRequest;
import xyz.fiwka.ptmplace.exception.UserAlreadyExistsException;
import xyz.fiwka.ptmplace.mapper.UserMapperImpl;
import xyz.fiwka.ptmplace.service.UserService;
import xyz.fiwka.ptmplace.service.impl.UserServiceImpl;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

@DataJpaTest
@Import({UserServiceImpl.class, UserMapperImpl.class})
public class UserServiceTest {

    @MockitoBean
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserService userService;

    @Test
    public void whenCreateUser_thenReturnUserResponse() {
        var userFields = new UserFieldsRequest(
                "Ivanov",
                "Ivan",
                "79000000000",
                "me@example.com",
                "12345678"
        );

        var result = userService.createUser(userFields);

        assertThat(result.lastName())
                .isEqualTo("Ivanov");
        assertThat(result.firstName())
                .isEqualTo("Ivan");
        assertThat(result.phoneNumber())
                .isEqualTo("79000000000");
        assertThat(result.email())
                .isEqualTo("me@example.com");
    }

    @Test
    public void whenFindExistingUserByEmail_thenReturnExistingUserResponse() {
        var email = "test@example.com";
        var userFields = new UserFieldsRequest(
                "Ivanov",
                "Ivan",
                "79000000000",
                email,
                "12345678"
        );

        userService.createUser(userFields);

        var result = userService.findUser(email);

        assertThat(result.orElseGet(Assertions::fail).email())
                .isEqualTo(email);
    }

    @Test
    public void whenFindExistingUserById_thenReturnExistingUserResponse() {
        var email = "test@example.com";
        var userFields = new UserFieldsRequest(
                "Ivanov",
                "Ivan",
                "79000000000",
                email,
                "12345678"
        );

        var user = userService.createUser(userFields);

        var result = userService.findUser(user.id());

        assertThat(result.orElseGet(Assertions::fail).email())
                .isEqualTo(email);
    }

    @Test
    public void whenCreateUserConflictEmail_thenThrowsUserAlreadyExistsException() {
        var userFields = new UserFieldsRequest(
                "Ivanov",
                "Ivan",
                "79000000000",
                "mew@example.com",
                "12345678"
        );
        var userFields2 = new UserFieldsRequest(
                "Ivanov",
                "Ivan",
                "79000000000",
                "mew@example.com",
                "12345678"
        );

        userService.createUser(userFields);

        assertThatExceptionOfType(UserAlreadyExistsException.class)
                .isThrownBy(() -> userService.createUser(userFields2));
    }
}

package test.user;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import user.User;
import user.UserService;

public class UserServiceTest {

    @Test
    void createNewUser_OK() {
        UserService userService = new UserService();

        User user = userService.createNewUser("login", "password");

        Assertions.assertEquals("login", user.getLogin());
        Assertions.assertEquals("password", user.getPassword());
    }

    @Test
    void createNewUser_LoginIsNull(){
        UserService userService = new UserService();

        Exception exception = Assertions.assertThrows(
                IllegalArgumentException.class, () -> {userService.createNewUser(null, "password");});
        Assertions.assertEquals(IllegalArgumentException.class, exception.getClass());
        Assertions.assertEquals("login and password cannot be null", exception.getLocalizedMessage());
    }

    @Test
    void createNewUser_LoginIsEmpty(){
        UserService userService = new UserService();

        Exception exception = Assertions.assertThrows(
                IllegalArgumentException.class, () -> {userService.createNewUser("", "password");});
        Assertions.assertEquals(IllegalArgumentException.class, exception.getClass());
        Assertions.assertEquals("login and password cannot be empty", exception.getLocalizedMessage());
    }

}

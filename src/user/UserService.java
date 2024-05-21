package user;

import java.util.Objects;



public class UserService {
    public User createNewUser(String login, String password) {
        if (Objects.isNull(login) || Objects.isNull(password)) {
            throw new IllegalArgumentException("login and password cannot be null");
        }

        if (login.isEmpty() || password.isEmpty()) {
            throw new IllegalArgumentException("login and password cannot be empty");
        }

        return new User(login,password);
    }
}

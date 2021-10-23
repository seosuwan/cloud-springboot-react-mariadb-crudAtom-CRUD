package shop.jarviis.api.cloud.user.service;


import shop.jarviis.api.cloud.user.domain.User;
import shop.jarviis.api.cloud.user.domain.UserDto;
import java.util.Optional;

public interface UserService {
    Optional<User> findById(long userId);
    Optional<User> login(String username, String password);
}

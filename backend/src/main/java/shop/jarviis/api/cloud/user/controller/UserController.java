package shop.jarviis.api.cloud.user.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import shop.jarviis.api.cloud.common.CommonController;
import shop.jarviis.api.cloud.user.domain.User;
import shop.jarviis.api.cloud.user.domain.UserDto;
import shop.jarviis.api.cloud.user.repository.UserRepository;
import shop.jarviis.api.cloud.user.service.UserServiceImpl;

import java.util.List;
import java.util.Optional;

@CrossOrigin("*")
@RequiredArgsConstructor
@RestController
@RequestMapping("/users")
public final class UserController implements CommonController<User, Long> {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private final UserServiceImpl userService;
    private final UserRepository userRepository;

    @PostMapping("/login")
    public ResponseEntity<User> login(@RequestBody UserDto user) {
        return ResponseEntity.ok(userService.login(user.getUsername(), user.getPassword()).orElse(new User())); }

//    @GetMapping("/{id}")
//    public ResponseEntity<UserDto> getById(@PathVariable long id) throws JsonProcessingException {
//        User user = userService.findById(id).get();
//        UserDto userDto = UserDto.builder()
//                .userId(user.getUserId())
//                .username(user.getUsername())
//                .password(user.getPassword())
//                .name(user.getName())
//                .email(user.getEmail())
//                .regDate(user.getRegDate())
//                .build();
//        return new ResponseEntity<>(userDto, HttpStatus.OK);
//    }

    @GetMapping()
    @Override
    public ResponseEntity<List<User>> findAll() { //리스트여서 Null값이아니다.
        return ResponseEntity.ok(userRepository.findAll());
    }
    @GetMapping("/{id}")
    @Override
    public ResponseEntity<User> getById(@PathVariable Long id) {
        return ResponseEntity.ok(userRepository.getById(id));
    }
    @PostMapping("")
    @Override
    public ResponseEntity<String> save(@RequestBody User user) {
        logger.info(String.format("회원가입 정보: %s", user.toString()));
        userRepository.save(user);
        return ResponseEntity.ok("SUCCESS");
    }

    @Override
    public ResponseEntity<Optional<User>> findById(Long id) {
        return ResponseEntity.ok(userRepository.findById(id));
    }

    @Override
    public ResponseEntity<Boolean> existsById(Long id) {
        return ResponseEntity.ok(userRepository.existsById(id));
    }

    @Override
    public ResponseEntity<Long> count() {
        return ResponseEntity.ok(userRepository.count());
    }

    @DeleteMapping("/{id}")
    @Override
    public ResponseEntity<String> deleteById(@PathVariable Long id) {
        userRepository.deleteById(id);
        return ResponseEntity.ok("SUCCESS");
    }
}

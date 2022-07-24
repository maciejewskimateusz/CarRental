package pl.carrental.user;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.carrental.user.dto.UserCredentialsDto;
import pl.carrental.user.dto.UserLoginDto;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@Valid @RequestBody UserCredentialsDto user) {
        userService.register(user);

        return new ResponseEntity<>("User registered successfully", HttpStatus.OK);
    }

//    @PostMapping("/login")
//    public ResponseEntity<String> login(@RequestBody UserLoginDto user) {
//
//    }
}


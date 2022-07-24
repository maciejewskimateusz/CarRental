package pl.carrental.user;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.carrental.user.dto.LoginDto;
import pl.carrental.user.dto.UserCredentialsDto;

@RestController
@RequestMapping("/api/user")
public class UserController {

    private final UserService userService;


    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody UserCredentialsDto user) {

        userService.register(user);
        return new ResponseEntity<>("User registered successfully", HttpStatus.OK);
    }

//    @PostMapping("/login")
//    public ResponseEntity<?> login(@RequestBody LoginDto user) {
//
//
//    }
}


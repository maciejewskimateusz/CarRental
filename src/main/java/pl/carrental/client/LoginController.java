package pl.carrental.client;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import pl.carrental.client.dto.ClientCredentialsDto;

@RestController
public class LoginController {


    @PostMapping("/login")
    public void login(@RequestBody ClientCredentialsDto credentials) {

    }
}

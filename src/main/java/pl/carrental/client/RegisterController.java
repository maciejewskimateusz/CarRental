package pl.carrental.client;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import pl.carrental.client.dto.ClientRegistrationDto;

@RestController
public class RegisterController {

    private ClientService clientService;

    public RegisterController(ClientService clientService) {
        this.clientService = clientService;
    }

    @PostMapping("/api/register")
    ResponseEntity<?> registerClient(@RequestBody ClientRegistrationDto client) {
        clientService.register(client);
        return new ResponseEntity<>("User registered successfully", HttpStatus.OK);
    }
}

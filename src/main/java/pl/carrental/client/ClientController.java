package pl.carrental.client;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import pl.carrental.client.dto.ClientDto;
import pl.carrental.client.dto.ClientRentDto;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/clients")
public class ClientController {

    private ClientService service;

    public ClientController(ClientService service) {
        this.service = service;
    }

    @GetMapping
    List<ClientDto> findAll(@RequestParam(required = false) String lastName) {
        if (lastName == null) {
            return service.findAll();
        } else
            return service.findByLastName(lastName);
        }


    @GetMapping("/{id}")
    public ResponseEntity<ClientDto> findById(@PathVariable Long id) {
        return service.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/{id}/rents/")
    public List<ClientRentDto> getAllClientRents(@PathVariable Long id) {
        return service.getAllClientRentals(id);
    }

    @GetMapping("/{id}/rents/active")
    public List<ClientRentDto> getAllClientActiveRentals(@PathVariable Long id) {
        return service.getAllClientActiveRentals(id);
    }

    @PostMapping
    public ResponseEntity<ClientDto> create(@RequestBody ClientDto client) {
        ClientDto savedClient = service.save(client);
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(client.getId())
                .toUri();
        return ResponseEntity.created(uri).body(savedClient);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClientDto> update(@PathVariable Long id, @RequestBody ClientDto clientDto) {
        if (id.equals(clientDto.getId())) {
            ClientDto updatedClient = service.update(clientDto);
            return ResponseEntity.ok(updatedClient);
        } else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Niezgodne id");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

}

package pl.carrental.client;

import pl.carrental.client.dto.ClientCredentialsDto;

import java.util.Set;
import java.util.stream.Collectors;

public class ClientCredentialsDtoMapper {

    static ClientCredentialsDto map(Client client) {
        String email = client.getEmail();
        String password = client.getPassword();
        Set<String> roles = client.getRoles()
                .stream().map(ClientRole::getName)
                .collect(Collectors.toSet());
        return new ClientCredentialsDto(email, password, roles);
    }
}

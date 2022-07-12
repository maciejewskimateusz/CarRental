package pl.carrental.client;

import pl.carrental.client.dto.ClientCredentialsDto;

public class ClientCredentialsDtoMapper {

    static ClientCredentialsDto map(Client client) {

        return new ClientCredentialsDto(client.getEmail(), client.getPassword(), client.getRole());
    }
}

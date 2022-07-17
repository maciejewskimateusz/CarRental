package pl.carrental.client.mapper;

import pl.carrental.client.Client;
import pl.carrental.client.dto.ClientCredentialsDto;

public class ClientCredentialsDtoMapper {

    public static ClientCredentialsDto map(Client client) {

        return new ClientCredentialsDto(client.getEmail(), client.getPassword(), client.getRole());
    }
}

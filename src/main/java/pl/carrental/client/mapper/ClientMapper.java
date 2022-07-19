package pl.carrental.client.mapper;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import pl.carrental.client.Client;
import pl.carrental.client.ClientAddressRepository;
import pl.carrental.client.dto.ClientDto;

@Service
public class ClientMapper {

    private ClientAddressRepository clientAddressRepository;

    public ClientMapper(ClientAddressRepository clientAddressRepository) {
        this.clientAddressRepository = clientAddressRepository;
    }

    public ClientDto toDto(Client entity) {
        ClientDto dto = new ClientDto();
        dto.setId(entity.getId());
        dto.setPesel(entity.getPesel());
        dto.setBirthDate(entity.getBirthDate());
        dto.setFirstName(entity.getFirstName());
        dto.setLastName(entity.getLastName());
        dto.setAddress(entity.getAddress());
        return dto;
    }

    public Client toEntity(ClientDto dto) {
        Client entity = new Client();
        entity.setId(dto.getId());
        entity.setFirstName(dto.getFirstName());
        entity.setLastName(dto.getLastName());
        entity.setPesel(dto.getPesel());
        entity.setBirthDate(dto.getBirthDate());
        entity.setPremium(false);
        clientAddressRepository.findById(dto.getAddress().getId())
                .ifPresent(entity::setAddress);
        return entity;
    }
}

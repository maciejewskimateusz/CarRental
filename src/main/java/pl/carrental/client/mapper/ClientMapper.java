package pl.carrental.client.mapper;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import pl.carrental.client.Client;
import pl.carrental.client.ClientAddressRepository;
import pl.carrental.client.dto.ClientDto;

@Service
public class ClientMapper {

    private PasswordEncoder passwordEncoder;
    private ClientAddressRepository clientAddressRepository;

    public ClientMapper(final PasswordEncoder passwordEncoder, final ClientAddressRepository clientAddressRepository) {
        this.passwordEncoder = passwordEncoder;
        this.clientAddressRepository = clientAddressRepository;
    }

    public ClientDto toDto(Client entity) {
        ClientDto dto = new ClientDto();
        dto.setId(entity.getId());
        dto.setIdNumber(entity.getIdNumber());
        dto.setEmail(entity.getEmail());
        dto.setPassword(entity.getPassword());
        dto.setFirstName(entity.getFirstName());
        dto.setLastName(entity.getLastName());
        dto.setBirthDate(entity.getBirthDate());
        dto.setAddress(entity.getAddress());
        return dto;
    }

    public Client toEntity(ClientDto dto) {
        Client entity = new Client();

        entity.setId(dto.getId());
        entity.setFirstName(dto.getFirstName());
        entity.setLastName(dto.getLastName());
        entity.setPassword(passwordEncoder.encode(dto.getPassword()));
        entity.setEmail(dto.getEmail());
        entity.setIdNumber(dto.getIdNumber());
        entity.setBirthDate(dto.getBirthDate());
        entity.setPremium(false);
        entity.setRole("USER");
        clientAddressRepository.findById(dto.getAddress().getId())
                .ifPresent(entity::setAddress);
        return entity;
    }
}

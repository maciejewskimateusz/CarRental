package pl.carrental.client;

import org.springframework.stereotype.Service;
import pl.carrental.car.exceptions.ClientNotFoundException;
import pl.carrental.client.dto.ClientDto;
import pl.carrental.client.dto.ClientRentDto;
import pl.carrental.client.exceptions.AlreadyClientExist;
import pl.carrental.client.exceptions.ClientIsNotAdultException;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ClientService {

    private ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public Optional<ClientDto> findById(Long id) {
        return clientRepository.findById(id)
                .map(ClientMapper::toDto);
    }

    public List<ClientDto> findAll() {
        return clientRepository.findAll().stream()
                .map(ClientMapper::toDto)
                .collect(Collectors.toList());
    }

    public List<ClientDto> findByLastName(String lastName) {
        return clientRepository.findAllByLastNameContainingIgnoreCase(lastName).stream()
                .map(ClientMapper::toDto)
                .collect(Collectors.toList());
    }

    public List<ClientRentDto> getAllClientRents(Long clientId) {
        return clientRepository.findById(clientId)
                .map(Client::getRentals)
                .orElseThrow(ClientNotFoundException::new)
                .stream().map(ClientRentMapper::toDto)
                .collect(Collectors.toList());
    }

    public ClientDto save(ClientDto client) {
        if (clientRepository.findByPesel(client.getPesel()).isPresent()) {
            throw new AlreadyClientExist();
        }
        if (!checkIfClientIsAdult(client)) {
            throw new ClientIsNotAdultException();
        }
        Client entity = ClientMapper.toEntity(client);
        Client savedClient = clientRepository.save(entity);
        return ClientMapper.toDto(savedClient);
    }

    public ClientDto update(ClientDto client) {
        Optional<Client> clientByPesel = clientRepository.findByPesel(client.getPesel());
        clientByPesel.ifPresent(c -> {
            if (!c.getId().equals(client.getId())) {
                throw new AlreadyClientExist();
            }
        });
        Client entity = ClientMapper.toEntity(client);
        Client savedClient = clientRepository.save(entity);
        return ClientMapper.toDto(savedClient);
    }


    private boolean checkIfClientIsAdult(final ClientDto client) {
        int years = Period.between(client.getBirthDate(), LocalDate.now()).getYears();
        System.out.println(years);
        return years >= 18;
    }
}

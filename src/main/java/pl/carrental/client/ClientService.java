package pl.carrental.client;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import pl.carrental.car.exceptions.ClientNotFoundException;
import pl.carrental.client.dto.ClientDto;
import pl.carrental.client.dto.ClientRentDto;
import pl.carrental.client.exceptions.ClientAlreadyExistException;
import pl.carrental.client.exceptions.ClientIsNotAdultException;
import pl.carrental.client.mapper.ClientMapper;
import pl.carrental.client.mapper.ClientRentMapper;
import pl.carrental.reservation.RentalRepository;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ClientService {

    private ClientRepository clientRepository;
    private RentalRepository rentalRepository;
    private ClientMapper clientMapper;

    public ClientService(ClientRepository clientRepository, RentalRepository rentalRepository, ClientMapper clientMapper) {
        this.clientRepository = clientRepository;
        this.rentalRepository = rentalRepository;
        this.clientMapper = clientMapper;
    }

    public Optional<ClientDto> findById(Long id) {
        return clientRepository.findById(id)
                .map(client -> clientMapper.toDto(client));
    }

    public List<ClientDto> findAll(int pageNo, int pageSize, String sortBy, String sortDir) {
        Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortBy).ascending()
                : Sort.by(sortBy).descending();
        PageRequest pageable = PageRequest.of(pageNo, pageSize, sort);
        Page<Client> pagedClients = clientRepository.findAll(pageable);

        return pagedClients.map(client -> clientMapper.toDto(client))
                .stream()
                .collect(Collectors.toList());
    }

    public List<ClientDto> findByLastName(String lastName) {
        return clientRepository.findAllByLastNameContainingIgnoreCase(lastName)
                .stream()
                .map(client -> clientMapper.toDto(client))
                .collect(Collectors.toList());
    }

    public List<ClientRentDto> getAllClientRentals(Long clientId) {
        return clientRepository.findById(clientId)
                .map(Client::getRentals)
                .orElseThrow(ClientNotFoundException::new)
                .stream().map(ClientRentMapper::toDto)
                .collect(Collectors.toList());
    }

    public List<ClientRentDto> getAllClientActiveRentals(Long clientId) {
        return rentalRepository.findAllByClient_IdAndReturnDateIsNull(clientId)
                .stream().map(ClientRentMapper::toDto)
                .collect(Collectors.toList());
    }

    public ClientDto save(ClientDto client) {
        if (clientRepository.findByPesel(client.getPesel()).isPresent()) {
            throw new ClientAlreadyExistException();
        }
        if (!checkIfClientIsAdult(client)) {
            throw new ClientIsNotAdultException();
        }
        Client entity = clientMapper.toEntity(client);
        Client savedClient = clientRepository.save(entity);
        return clientMapper.toDto(savedClient);
    }

    public ClientDto update(ClientDto client) {
        Optional<Client> clientByPesel = clientRepository.findByPesel(client.getPesel());
        clientByPesel.ifPresent(c -> {
            if (!c.getId().equals(client.getId())) {
                throw new ClientAlreadyExistException();
            }
        });
        Client entity = clientMapper.toEntity(client);
        Client savedClient = clientRepository.save(entity);
        return clientMapper.toDto(savedClient);
    }

    @Transactional
    public void delete(Long id) {
        clientRepository.findById(id)
                .ifPresent(client -> clientRepository.deleteById(id));
    }


    private boolean checkIfClientIsAdult(final ClientDto client) {
        int years = Period.between(client.getBirthDate(), LocalDate.now()).getYears();
        System.out.println(years);
        return years >= 18;
    }

//    public Optional<UserCredentialsDto> findCredentialsByEmail(String email) {
//        return UserRepository.findByEmail(email)
//                .map(UserCredentialsDtoMapper::map);
//    }

//    @Transactional
//    public void register(ClientRegistrationDto clientRegistrationDto) {
//        Client newClient = Client.builder()
//                .firstName(clientRegistrationDto.getFirstName())
//                .lastName(clientRegistrationDto.getLastName())
//                .email(clientRegistrationDto.getEmail())
//                .password(passwordEncoder.encode(clientRegistrationDto.getPassword()))
//                .pesel(clientRegistrationDto.getPesel())
//                .idNumber(clientRegistrationDto.getIdNumber())
//                .birthDate(clientRegistrationDto.getBirthDate())
//                .role("USER")
//                .premium(false)
//                .build();
//
//        clientRepository.save(newClient);
//    }
}

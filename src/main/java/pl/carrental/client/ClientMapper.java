package pl.carrental.client;

public class ClientMapper {

    static ClientDto toDto(Client entity) {
        ClientDto dto = new ClientDto();
        dto.setId(entity.getId());
        dto.setIdNumber(entity.getIdNumber());
        dto.setFirstName(entity.getFirstName());
        dto.setLastName(entity.getLastName());
        dto.setPesel(entity.getPesel());
        dto.setBirthDate(entity.getBirthDate());
        return dto;
    }

    static Client toEntity(ClientDto dto) {
        Client entity = new Client();
        entity.setId(dto.getId());
        entity.setFirstName(dto.getFirstName());
        entity.setLastName(dto.getLastName());
        entity.setIdNumber(dto.getIdNumber());
        entity.setBirthDate(dto.getBirthDate());
        entity.setPesel(dto.getPesel());
        return entity;
    }
}

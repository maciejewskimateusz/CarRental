package pl.carrental.client;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class ClientAddress {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String address;
    private String city;
    private String state;
    private String zip;
}

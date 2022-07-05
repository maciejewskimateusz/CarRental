package pl.carrental.car.dto;

import lombok.Getter;
import lombok.Setter;
import pl.carrental.car.CarType;
import pl.carrental.car.FuelType;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.math.BigDecimal;
@Getter
@Setter
public class CarDto {

    private Long id;
    private FuelType fuelType;
    private String name;
    private CarType carType;
    private BigDecimal pricePerDay;
    private String registrationNumber;
    private Integer mileage;

}

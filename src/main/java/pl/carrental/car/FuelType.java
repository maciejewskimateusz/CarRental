package pl.carrental.car;

public enum FuelType {
    DIESEL("diesel"),
    PETROL("benzyna"),
    LPG("gaz");

    private String description;

    FuelType(String description) {
        this.description = description;
    }
}

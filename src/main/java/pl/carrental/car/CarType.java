package pl.carrental.car;

public enum CarType {
    SMALL("Małe"),
    COMPACT("Kompakt"),
    SUV("Suv"),
    PREMIUM("Premium");

    private String description;

    CarType(String description) {
        this.description = description;
    }
}

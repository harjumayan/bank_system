package models;

public class Address {
    private String country;
    private String region;
    private String city;
    private String street;
    private String house;

    public Address(String country, String region, String city, String street, String house) {
        this.country = country;
        this.region = region;
        this.city = city;
        this.street = street;
        this.house = house;
    }

    @Override
    public String toString() {
        return street + " " + house + ", " + city + ", " + region + ", " + country;
    }
}

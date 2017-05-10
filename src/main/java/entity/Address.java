package entity;

/**
 * Created by Dimitry on 22.04.17.
 */
public class Address {

    private int house;
    private String street;
    private String city;
    private int zip;

    public Address() {
    }

    public Address(int house, String street, String city, int zip) {
        this.house = house;
        this.street = street;
        this.city = city;
        this.zip = zip;
    }

    public int getHouse() {
        return house;
    }

    public void setHouse(int house) {
        this.house = house;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getZip() {
        return zip;
    }

    public void setZip(int zip) {
        this.zip = zip;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Address address = (Address) o;

        if (house != address.house) return false;
        if (zip != address.zip) return false;
        if (street != null ? !street.equals(address.street) : address.street != null) return false;
        return city != null ? city.equals(address.city) : address.city == null;
    }

    @Override
    public int hashCode() {
        int result = house;
        result = 31 * result + (street != null ? street.hashCode() : 0);
        result = 31 * result + (city != null ? city.hashCode() : 0);
        result = 31 * result + zip;
        return result;
    }

    @Override
    public String toString() {
        return "Address{" +
                "house=" + house +
                ", street='" + street + '\'' +
                ", city='" + city + '\'' +
                ", zip=" + zip +
                '}';
    }
    public void init(){
        System.out.println("Bean created:" + this);
    }

    public void destroy(){
        System.out.println("Bean destroyed:" + this);
    }
}

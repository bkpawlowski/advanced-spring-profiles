package pl.grizzlysoftware.spring.asp.api.module.customer.model;

/**
 * Created by Bartosz Pawłowski, bpawlowski@grizzlysoftware.pl
 *
 * https://blog.grizzlysoftware.pl
 * https://grizzlysoftware.pl
 */
public class Customer {
    public final String name;
    public final String surname;

    public Customer(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }
}

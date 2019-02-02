package pl.grizzlysoftware.spring.asp.api.module.customer.service;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import pl.grizzlysoftware.spring.asp.api.module.customer.model.Customer;

import java.util.Arrays;
import java.util.Collection;

/**
 * Created by Bartosz Pawłowski, bpawlowski@grizzlysoftware.pl
 *
 * https://blog.grizzlysoftware.pl
 * https://grizzlysoftware.pl
 */
@Service
@Profile("customer-module")
public class CustomerService {
    public Collection<Customer> getCustomers() {
        return Arrays.asList(new Customer("Matthew", "Frank"), new Customer("Bar", "Tosh"), new Customer("Rem", "As"));
    }
}

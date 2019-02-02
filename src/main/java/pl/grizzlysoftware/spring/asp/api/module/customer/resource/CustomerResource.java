package pl.grizzlysoftware.spring.asp.api.module.customer.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.grizzlysoftware.spring.asp.api.module.customer.model.Customer;
import pl.grizzlysoftware.spring.asp.api.module.customer.service.CustomerService;

import java.util.Collection;

import static java.lang.String.format;

/**
 * Created by Bartosz Pawłowski, bpawlowski@grizzlysoftware.pl
 *
 * https://blog.grizzlysoftware.pl
 * https://grizzlysoftware.pl
 */
@RestController
@RequestMapping("/customer")
@Profile("customer-module.resource")
public class CustomerResource {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/greet/{customer}")
    public String greetings(@PathVariable String customer) {
        return format("Greetings customer: %s", customer);
    }

    @GetMapping("")
    public Collection<Customer> customers() {
        return customerService.getCustomers();
    }

}

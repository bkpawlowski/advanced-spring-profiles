package pl.grizzlysoftware.spring.asp.api.module.customer.resource;

import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static java.lang.String.format;

/**
 * Created by Bartosz Pawłowski, bpawlowski@grizzlysoftware.pl
 *
 * https://blog.grizzlysoftware.pl
 * https://grizzlysoftware.pl
 */
@RestController
@RequestMapping("/customer/premium")
@Profile("customer-module.premium-resource")
public class PremiumCustomerResource {

    @GetMapping("/greet/{customer}")
    public String greetings(@PathVariable String customer) {
        return format("Greetings premium customer: %s", customer);
    }
}

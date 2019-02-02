package pl.grizzlysoftware.spring.asp.api.module.customer;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * Created by Bartosz Pawłowski, bpawlowski@grizzlysoftware.pl
 *
 * https://blog.grizzlysoftware.pl
 * https://grizzlysoftware.pl
 */
@Configuration
@ComponentScan
@Profile("customer-module")
public class CustomerModuleConfiguration {

}
